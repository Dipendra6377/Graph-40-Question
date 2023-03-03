class pair{
    int first;
    int second;
    int dist;

    pair(int first,int second,int dist){
        this.first=first;
        this.second=second;
        this.dist=dist;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0){
            return -1;
        }

        int n=grid.length;
        int m=grid[0].length;

        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;
            }
        }
        dist[0][0]=1;

        Queue<pair> q=new LinkedList<>();
        q.add(new pair(0,0,1));
        int dx[]={0,1,0,-1,1,-1,-1,1};
        int dy[]={1,0,-1,0,1,-1,1,-1};

        while(!q.isEmpty()){
            pair node = q.peek();
            int x=node.first;
            int y=node.second;
            int d=node.dist;
            q.remove();

            for(int i=0;i<8;i++){
                int nrow=x+dx[i];
                int ncol=y+dy[i];
            

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==0){
                    if(1+d <dist[nrow][ncol]){
                        dist[nrow][ncol]=1+d;
                        q.add(new pair(nrow,ncol,dist[nrow][ncol]));
                    }
                }
            }
        }

        return dist[n-1][m-1]<(int)1e9?dist[n-1][m-1]:-1;    
        }
}
