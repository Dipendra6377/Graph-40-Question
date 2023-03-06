class DisjointSet{
    List<Integer > parent=new ArrayList<>();
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
        int parent_u = findParent(u);
        int parent_v = findParent(v);

        if(parent_u==parent_v) return;

        if(size.get(parent_u)<size.get(parent_v)){
            parent.set(parent_u,parent_v);
            size.set(parent_v,size.get(parent_u)+size.get(parent_v));
        }
        else{
            parent.set(parent_v,parent_u);
            size.set(parent_u,size.get(parent_u)+size.get(parent_v));
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds  =new DisjointSet(n);
        int cntExtraWire=0;

        for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];

            if(ds.findParent(u)==ds.findParent(v)){
                cntExtraWire++;
            }
            else{
                ds.unionBysize(u,v);
            }
        }

        int ParentComputer=0;

        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i) ParentComputer++;

        }
        System.out.println(ParentComputer);
        int ans=ParentComputer-1;

        if(cntExtraWire>=ans){
            return ans;
        }
        return -1;
    }
}
