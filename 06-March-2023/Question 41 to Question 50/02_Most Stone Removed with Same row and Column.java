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
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int row=0;
        int col=0;
        for(int i=0;i<n;i++){
            row=Math.max(row,stones[i][0]);
            col=Math.max(col,stones[i][1]);
        }

        DisjointSet ds =new DisjointSet(row+col+1);

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            int u = stones[i][0];
            int v = stones[i][1]+row+1;
            ds.unionBysize(u,v);
            map.put(u,1);
            map.put(v,1);
        }

        int cnt=0;
        for(Map.Entry<Integer,Integer> it :map.entrySet()){
            if(ds.findParent(it.getKey())==it.getKey()){
                cnt++;
            }
        }
        return n-cnt;
    }
}
