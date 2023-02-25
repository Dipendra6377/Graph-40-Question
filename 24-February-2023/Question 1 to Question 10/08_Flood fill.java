class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inicolor = image[sr][sc];
        int[][] dummy = image;

        int[] x={0,-1,0,1};
        int[] y={1,0,-1,0};

        dfs(image,dummy,sr,sc,x,y,color,inicolor);
        return dummy;
    }

    static void dfs(int[][] image,int[][] dummy,int r,int c,int[] x,int[] y,int color,int inicolor){
        dummy[r][c]=color;
        int n=image.length;
        int m=image[0].length;

        for(int i=0;i<4;i++){
            int row=r+x[i];
            int col=c+y[i];

            if(row>=0 && row<n && col>=0 && col<m && image[row][col]==inicolor && dummy[row][col] !=color){
                dfs(image,dummy,row,col,x,y,color,inicolor);
            }
        }
    }
}
