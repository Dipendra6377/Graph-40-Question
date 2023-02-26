class pair{
    int first;
    int second;
    
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        Arrays.fill(vis,false);
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(findcycle(i,adj,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean findcycle(int src ,ArrayList<ArrayList<Integer>> adj,boolean[] vis ){
        vis[src]=true;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(src,-1));
        
        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            
            q.remove();
            
            for(Integer child : adj.get(node)){
                if(vis[child]!=true){
                    vis[child]=true;
                    q.add(new pair(child,node));
                }
                else if(parent!=child){
                    return true;
                }
            }
        }
        return false;
    }
}
