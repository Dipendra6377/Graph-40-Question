class DisjointSet{
    List<Integer> parent =new ArrayList<>();
    List<Integer> size =new ArrayList<>();
    
   public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }
    public int findParent(int node){
        if(parent.get(node)==node){
            return node;
        }

        int temp = findParent(parent.get(node));
        parent.set(node,temp);
        return parent.get(node);
    }

    public void unionBysize(int u,int v){
        int parent_u =findParent(u);
        int parent_v =findParent(v);

        if(parent_u==parent_v) return;

        if(size.get(parent_u)<size.get(parent_v)){
            parent.set(parent_u,parent_v);
            size.set(parent_v,size.get(parent_u)+size.get(parent_v));
        }
        else{
            parent.set(parent_v,parent_u);
            size.set(parent_u,size.get(parent_u)+size.get(parent_v));
        }
    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        int n=grid.length;

        DisjointSet ds =new DisjointSet(n*n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) continue;

                int[] dx ={-1,0,1,0};
                int[] dy ={0,-1,0,1};

                for(int ind=0;ind<4;ind++){
                    int row =i+dx[ind];
                    int col =j+dy[ind];

                    if(row>=0 && row<n && col>=0 && col<n && grid[row][col]==1){
                        int n1 = i*n+j;
                        int n2 =row*n+col;
                        ds.unionBysize(n1,n2);
                    }
                }
            }
        }

        int maxsize=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) continue;

                int[] dx ={-1,0,1,0};
                int[] dy ={0,-1,0,1};
                
                HashSet<Integer> set =new HashSet<>();
                for(int ind=0;ind<4;ind++){
                    int row =i+dx[ind];
                    int col =j+dy[ind];
                    if(row>=0 && row<n && col>=0 && col<n && grid[row][col]==1){
                        set.add(ds.findParent(row*n+col));
                    }
                }
                int size=0;
                for(Integer parent : set){
                    size+=ds.size.get(parent);
                }
                maxsize =Math.max(maxsize,size+1);
            }
        }
        for(int i=0;i<n*n;i++){
            maxsize=Math.max(maxsize,ds.size.get(ds.findParent(i))); 
        }
        return maxsize;
    }
}
