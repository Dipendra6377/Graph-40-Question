class pair{
    int first;
    int second;
    
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    
	    // Code Here. 
	    ArrayList<ArrayList<pair>> adj =new ArrayList<>();
	    
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<>());
	    }
	    
	    for(int i=0;i<edges.length;i++){
	        adj.get(edges[i][0]).add(new pair(edges[i][1],edges[i][2]));
	        adj.get(edges[i][1]).add(new pair(edges[i][0],edges[i][2]));
	    }
	    PriorityQueue<pair> pq =new PriorityQueue<>((x,y) -> x.second-y.second);
	    
	    int[] vis=new int[V];
	    int sum=0;
	    
	    pq.add(new pair(0,0));
	    vis[0]=1;
	    
	    while(!pq.isEmpty()){
	        pair temp=pq.peek();
	        int node =temp.first;
	        int dist = temp.second;
	        pq.remove();
	        
	        if(vis[node]==1){
	            continue;
	        }
	        vis[node]=1;
	        sum+=dist;
	        
	        for(pair adjnode: adj.get(node)){
	            int newnode = adjnode.first;
	            int newdist = adjnode.second;
	            
	            if(vis[newnode]==0){
	                pq.add(new pair(newnode,newdist));
	            }
	        }
	    }
	    return sum;
	}
}
