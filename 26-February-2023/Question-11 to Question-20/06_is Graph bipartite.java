class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[] =new int[n];
        for(int i=0;i<n;i++) color[i]=-1;
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(dfs(graph,0,color,i)==false){
                return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph,int col,int[] color,int node){
        color[node]=col;

        for(int child:graph[node]){
            if(color[child]==-1){
                if(dfs(graph,1-col,color,child)==false){
                return false;
            }
        }
            else if(color[child]==col){
                return false;
            }
        }
        return true;
    }
}
