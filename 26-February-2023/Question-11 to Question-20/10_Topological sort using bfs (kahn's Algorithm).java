class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
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
        int[] ans=new int[V];
        int i=0;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            ans[i++]=node;
            
            for(int child : adj.get(node)){
                degree[child]--;
                if(degree[child]==0){
                    q.add(child);
                }
            }
        }
        return ans;
    }
}
