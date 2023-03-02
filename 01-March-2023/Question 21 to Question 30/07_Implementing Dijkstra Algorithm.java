class pair{
    int first;
    int second;
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s)
    {
        // Write your code here
         PriorityQueue<pair> pq = new PriorityQueue<pair>((x,y) -> x.first - y.first);
         
         int[] dist = new int[V];
         
         Arrays.fill(dist,Integer.MAX_VALUE);
         
         pq.add(new pair(s,0));
         dist[s]=0;
         
         while(pq.size()>0){
             pair node = pq.peek();
             int parent = node.first;
             int wt=node.second;
             
             pq.remove();
             
             for(ArrayList<Integer> temp :adj.get(parent)){
                 int child =temp.get(0);
                 int weight=temp.get(1);
                 
                 if(dist[child]>dist[parent]+weight){
                     dist[child]=dist[parent]+weight;
                     pq.add(new pair(child,dist[child]));
                 }
             }
         }
         
         return dist;
    }
}

