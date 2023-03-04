class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] dist =new int[V];
        
        Arrays.fill(dist,(int)1e8);
        dist[S]=0;
        
        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer> list :edges){
                int u=list.get(0);
                int v=list.get(1);
                int wt=list.get(2);
                
                if(dist[u]!=(int)1e8 && wt+dist[u]<dist[v]){
                    dist[v]=dist[u]+wt;
                }
            }
        }
        
        for(ArrayList<Integer> list :edges){
                int u=list.get(0);
                int v=list.get(1);
                int wt=list.get(2);
                
                if(dist[u]!=(int)1e8 && wt+dist[u]<dist[v]){
                    int[] temp=new int[1];
                    temp[0]=-1;
                    return temp;
                }
            }
        
        
        return dist;
    }
}
