class Solution {
    // Function to detect cycle in a directed graph.
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int node, int[] vis,int[] dfsvis){
        vis[node]=1;
        dfsvis[node]=1;
        
        for(Integer child : adj.get(node)){
            if(vis[child]==0){
                if(dfs(adj,child,vis,dfsvis)==true){
                    return true;
                }
            }
            else if(dfsvis[child]==1){
                return true;
            }
        }
        dfsvis[node]=0;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] vis=new int[V];
        int[] dfsvis=new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(adj,i,vis,dfsvis)==true){
                    return true;
                }
            }
        }
        return false;
    }
}
