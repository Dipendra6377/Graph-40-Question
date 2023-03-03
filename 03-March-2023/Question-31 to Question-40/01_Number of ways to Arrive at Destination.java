class pair{
    int first;
    int second;
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        int m=roads.length;

        ArrayList<ArrayList<pair>> adj =new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            adj.get(roads[i][0]).add(new pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new pair(roads[i][0],roads[i][2]));
        }

        PriorityQueue<pair> pq=new PriorityQueue<>((x,y) -> x.first-y.first);
        int[] dist=new int[n];
        int[] ways=new int[n];
        int mod = (int)(1e9+7);

        for(int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE;
            ways[i]=0;
        }
        dist[0]=0;
        ways[0]=1;
        pq.add(new pair(0,0));

        while(pq.size()!=0){
            
            int dists = pq.peek().first;
            int node =pq.peek().second;
            pq.remove();

            for(pair it :adj.get(node)){
                int adjnode = it.first;
                int d =it.second;

                if(dists+d<dist[adjnode]){
                    dist[adjnode]=dists+d;
                    pq.add(new pair(dists+d,adjnode));
                    ways[adjnode]=ways[node];
                }

                else if(dists+d == dist[adjnode]){
                    ways[adjnode]=(ways[node]+ways[adjnode])%mod;
                }

            }
        }
        return ways[n-1]%mod;
    }
}
