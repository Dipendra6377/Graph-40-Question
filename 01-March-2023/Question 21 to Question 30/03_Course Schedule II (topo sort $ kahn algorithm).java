class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        } 
        int m=prerequisites.length;
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] degree = new int[n];
        for(int i=0;i<n;i++){
            for(int child: adj.get(i)){
                degree[child]++;
            }
        }
      
      /////////////////////////////////////////////
//Topo sort using kahn algorithm  SAME

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            if(degree[i]==0){
                q.add(i);
            }
        }
        int[] ans=new int[n];
        int i=0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            ans[i++]=node;

            for(int child: adj.get(node)){
                degree[child]--;

                if(degree[child]==0){
                    q.add(child);
                }
            }    
        }
        if(i==n) return ans;
        int[] empty={};
        return empty;
    }
}
