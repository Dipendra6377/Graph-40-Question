class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<pair> q=new LinkedList<>();
        int[][] vis = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                        q.offer(new pair(i,j));
                        vis[i][j]=1;
                    }
                }
            }
        }
        int[] x ={-1,0,1,0};
        int[] y= {0,1,0,-1}; 
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;

            q.remove();

            for(int i=0;i<4;i++){
                int nrow =x[i]+row;
                int ncol = y[i]+col;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.offer(new pair(nrow,ncol));
                    vis[nrow][ncol]=1;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}

class pair{
    int first;
    int second;

    pair(int first,int second){
        this.first =first;
        this.second = second;
    }
}
