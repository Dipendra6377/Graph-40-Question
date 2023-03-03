class pair{
    int diff;
    int first;
    int second;

    pair(int diff,int first,int second){
        this.diff=diff;
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;

        int[][] dist =new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;
            }
        }
        dist[0][0]=0;

        PriorityQueue<pair> pq=new PriorityQueue<pair>((x,y) ->x.diff-y.diff);
        pq.add(new pair(0,0,0));

        int[] dx ={-1,0,1,0};
        int[] dy ={0,1,0,-1};

        while(pq.size()!=0){
            
            pair node =pq.peek();
            int x = node.first;
            int y = node.second;
            int d= node.diff;
            pq.remove();

            if(x==n-1 && y==m-1){
                
                return d;
            }
            for(int i=0;i<4;i++){
                int nrow = x+dx[i];
                int ncol = y+dy[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m ){
                    int effort=Math.max(Math.abs(heights[nrow][ncol]-heights[x][y]),d);
                    //System.out.println(effort+" "+d);
                    if(effort<dist[nrow][ncol]){
                        dist[nrow][ncol]=effort;
                        pq.add(new pair(effort,nrow,ncol));
                    }
                }
            }
        }
        return 0;
    }
}
