class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int n = isConnected.length;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int[] vis = new int[n];
        int cnt=0;
       for(int i=0;i<n;i++){
            if(vis[i]==0){
            cnt++;
            dfs(i,adj,vis);
        }
       }
       return cnt;
    }

    public void dfs(int i,ArrayList<ArrayList<Integer>> adj,int[] vis){
        vis[i]=1;

        for(Integer node: adj.get(i)){
            if(vis[node]==0){
                dfs(node,adj,vis);
            }
        }
    }
}
