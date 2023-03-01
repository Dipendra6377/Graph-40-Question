class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
      
      //convert 2d array into tree using arraylist
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        } 
        int m=prerequisites.length;
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
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
        int cnt=0;

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            cnt++;

            for(int child: adj.get(node)){
                degree[child]--;

                if(degree[child]==0){
                    q.add(child);
                }
            }
            
        }

        return cnt==n;
    }
}
