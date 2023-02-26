class Node{
    int first;
    int second;
    int steps;
    
    Node(int first,int second,int steps){
        this.first=first;
        this.second=second;
        this.steps=steps;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int[][] dis=new int[n][m];
        
        Queue<Node> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.add(new Node(i,j,0));
                    vis[i][j]=1;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        int x[] ={-1,0,1,0};
        int y[] ={0,1,0,-1};
        
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int step = q.peek().steps;
            
            q.remove();
            dis[row][col]=step;
            for(int i=0;i<4;i++){
                int dx = x[i]+row;
                int dy = y[i]+col;
                
                if(dx>=0 && dx<n && dy>=0 && dy<m && vis[dx][dy]==0){
                    vis[dx][dy]=1;
                    q.add(new Node(dx,dy,step+1));
                }
            }
        }
        return dis;
    }
}
