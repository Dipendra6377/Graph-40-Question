class tuple{
    int stop;
    int node;
    int dist;
    tuple(int stop,int node,int dist){
        this.stop=stop;
        this.node=node;
        this.dist=dist;
    }
}

class pair{
    int first;
    int second;
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    
    public int CheapestFLight(int n,int flight[][],int src,int dst,int k) {
        // Code here
        
        ArrayList<ArrayList<pair>> adj =new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<pair>());
        }
        int m=flight.length;
        
        for(int i=0;i<m;i++){
            adj.get(flight[i][0]).add(new pair(flight[i][1],flight[i][2]));
        }
        // no need of priority queue it take logn more space as stop are can also go in order on queue
        Queue<tuple> q=new LinkedList<>();
        q.add(new tuple(0,src,0));
        int[] dist=new int[n];
        
        for(int i=0;i<n;i++){
            dist[i]=(int)1e9;
        }
        dist[src]=0;
        
        while(!q.isEmpty()){
            tuple temp = q.peek();
            q.remove();
            int stops = temp.stop;
            int nodes =temp.node;
            int d =temp.dist;
            
            if(stops> k) continue;
            
            for(pair iter :adj.get(nodes)){
                int adjnode =iter.first;
                int cost =iter.second;
                
                if(d+cost<dist[adjnode] && stops<=k){
                    dist[adjnode]=d+cost;
                    System.out.println(adjnode + " " + dist[adjnode]);
                    q.add(new tuple(1+stops,adjnode,cost+d));
                }
            }
        }
        
        if(dist[dst]==(int)1e9) return -1;
        return dist[dst];
        
    }
}
