class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        boolean[] visited = new boolean[n];
        HashSet<Integer>[] graph = new HashSet[n];
        int i, j;
        
        for(i = 0; i < n; i++){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
		
        if(graph[start].contains(end)){  
            return true;
        }

        Queue<Integer> q=new LinkedList<>();

        q.add(start);
        visited[start] =true;

        while(!q.isEmpty()){
            int size = q.size();
            int node =q.poll();

            if(node==end){
                return true;
            }
            for(Integer path :graph[node]){
                if(!visited[path]){
                    visited[path]=true;
                    q.offer(path);
                }
            }
        }
        return false;
    }
}
