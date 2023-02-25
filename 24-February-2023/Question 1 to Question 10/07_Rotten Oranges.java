class Pair{
    int row=0;
    int col=0;
    int t=0;
    Pair(int row,int col,int t){
        this.row=row;
        this.col=col;
        this.t=t;
    }
}
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        
       if(grid == null || grid.length == 0) return 0;
        Queue<Pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int vis[][] =new int[n][m];
        int cntfresh=0;

        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) cntfresh++;
            }
        }
        
        int cnt=0;
        int tm=0;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        
        
        while(!q.isEmpty()){
            int first = q.peek().row;
            int second = q.peek().col;
            int time=q.peek().t;
            tm =Math.max(tm,time);
            q.remove();
            
            for(int i=0;i<4;i++){
                int nrow=first+dx[i];
                int ncol=second+dy[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                    q.offer(new Pair(nrow,ncol,time+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }
        
        if(cnt!=cntfresh) return -1;
        return tm;
        
        
    }
}
