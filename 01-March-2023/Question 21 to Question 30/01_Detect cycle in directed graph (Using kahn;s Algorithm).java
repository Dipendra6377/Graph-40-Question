class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] degree = new int[V];
        for(int i=0;i<V;i++){
            for(int child : adj.get(i)){
                degree[child]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(degree[i]==0){
                q.add(i);
            }
        }
        int cnt=0;
        
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            cnt++;
            
            for(int child : adj.get(node)){
                degree[child]--;
                if(degree[child]==0){
                    q.add(child);
                }
            }
        }
        if(cnt==V) return false;
        return true;
    }
}
