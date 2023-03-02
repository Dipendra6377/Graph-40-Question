class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());    
        }
        
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int[] dist = new int[n];
        
        for(int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        Queue<Integer> q=new LinkedList<>();
        
        dist[src]=0;
        q.add(src);
        
        while(!q.isEmpty()){
            int parent = q.peek();
            q.remove();
            
            for(int child : adj.get(parent)){
                if(dist[child]>1+dist[parent]){
                    dist[child]=1+dist[parent];
                    q.add(child);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }
        return dist;
        
    }
}
