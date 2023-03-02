class pair{
    int first;
    int second;
    
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
//User function Template for Java
class Solution {
    public void Topodfs(ArrayList<ArrayList<pair>> adj,int parent,int[] vis,Stack<Integer> st){
        vis[parent]=1;
        
        for(int i=0;i<adj.get(parent).size();i++){
            int child = adj.get(parent).get(i).first;
            if(vis[child]!=1){
                Topodfs(adj,child,vis,st);
            }
        }
        st.add(parent);
    }

	public int[] shortestPath(int n,int m, int[][] edges) {
		//Code here
		ArrayList<ArrayList<pair>> adj =new ArrayList<>();
		
		for(int i=0;i<6;i++){
		    adj.add(new ArrayList<pair>());
		}
		
		for(int i=0;i<m;i++){
		    int parent = edges[i][0];
		    int child = edges[i][1];
		    int wt = edges[i][2];
		    adj.get(parent).add(new pair(child,wt));
		}
		// TOPO ALGORITHM
		
		int[] vis = new int[n];
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<n;i++){
		    if(vis[i]!=1){
		        Topodfs(adj,i,vis,st);
		    }
		}
		
		
		//CALCULATE DISTANCE
		int[] dist=new int[n];
		for(int i=0;i<n;i++) dist[i]=(int)1e9;
		dist[0]=0;
		
		
		while(!st.isEmpty()){
		    int parent = st.peek();
		    st.pop();
		    
		    for(int i=0;i<adj.get(parent).size();i++){
		        int child = adj.get(parent).get(i).first;
		        int wt = adj.get(parent).get(i).second;
		        if(wt+dist[parent]<dist[child]){
		            dist[child]=wt+dist[parent];
		        }
		    }
		}
		
		for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
		return dist;
	}
}
