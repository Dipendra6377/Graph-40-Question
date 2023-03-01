class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj =new ArrayList<>();
                List<Integer> ans = new LinkedList<>();

        int n=graph.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] degree=new int[n];
        for(int i=0;i<n;i++){
            for(int child : graph[i]){
                adj.get(child).add(i);
                degree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < ; i++) {
            if(degree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int temp = q.poll();
            ans.add(temp);
            for(int j : adj.get(temp)) {
                degree[j]--;
                if(degree[j] == 0) q.add(j);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
