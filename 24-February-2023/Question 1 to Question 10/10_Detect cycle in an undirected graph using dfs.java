class Solution {
    // Function to detect cycle in an undirected graph.
    
    public boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        vis[node] =true;
        
        for(Integer child : adj.get(node)){
            if(vis[child]==false){
                if(dfs(child,node,adj,vis)==true){
                    return true;
                }
            }
            else if(child!=parent){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis= new boolean[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if(dfs(i,-1,adj,vis)==true){
                    return true;
                }
            }
        }
        return false;
    }
}
