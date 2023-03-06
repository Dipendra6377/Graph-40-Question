class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node){
        if(parent.get(node)==node){
            return node;
        }

        int temp = findParent(parent.get(node));
        parent.set(node,temp);
        return parent.get(node);
    }

    public void unionBysize(int u,int v){
        int parent_u =findParent(u);
        int parent_v =findParent(v);

        if(parent_u==parent_v) return;

        if(size.get(parent_u)>size.get(parent_v)){
            parent.set(parent_v,parent_u);
            size.set(size.get(parent_u),size.get(parent_u)+size.get(parent_v));
        }
        else{
            parent.set(parent_u,parent_v);
            size.set(size.get(parent_v),size.get(parent_u)+size.get(parent_v));
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();

        DisjointSet ds=new DisjointSet(n);
        HashMap<String,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);

                if(!map.containsKey(mail)){
                    map.put(mail,i);
                }
                else{
                    ds.unionBysize(i,map.get(mail));
                }
            }
        }

        ArrayList<String>[] list=new ArrayList[n];
        for(int i=0;i<n;i++) list[i]=new ArrayList<String>();

        for(Map.Entry<String,Integer> it: map.entrySet()){
            String data=it.getKey();
            int node=ds.findParent(it.getValue());
            list[node].add(data);
        }

        List<List<String>> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(list[i].size()==0) continue;
            Collections.sort(list[i]);
            List<String> temp=new ArrayList<>();

            temp.add(accounts.get(i).get(0));

            for(String it :list[i]){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}
