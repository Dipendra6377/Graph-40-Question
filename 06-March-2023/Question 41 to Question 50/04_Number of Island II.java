class DisjointSet{
    List<Integer> parent =new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
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

        if(size.get(parent_u)>size.get(parent_v)){
            parent.set(parent_v,parent_u);
            size.set(size.get(parent_u),size.get(parent_u)+size.get(parent_v));
        }
        else{
            parent.set(parent_u,parent_v);
            size.set(size.get(parent_v),size.get(parent_u)+size.get(parent_v));
        }
    }
}
class Solution {
    
    public List<Integer> numOfIslands(int n, int m, int[][] grid) {
        //Your code here
      
        DisjointSet ds=new DisjointSet(n*m);
        
        int cnt=0;
        int[][] vis =new int[n][m];
        int l=grid.length;
        List<Integer> ans =new ArrayList<>();
        for(int i=0;i<l;i++){
            int row =grid[i][0];
            int col = grid[i][1];
            
            if(vis[row][col]==1){
                ans.add(cnt);
                continue;
            }
            
            vis[row][col]=1;
            cnt++;
            
            int[] dr={-1,0,1,0};
            int[] dc ={0,1,0,-1};
            
            for(int ind=0;ind<4;ind++){
                int newrow=row+dr[ind];
                int newcol=col+dc[ind];
                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m){
                    if(vis[newrow][newcol]==1){
                        int n1=row*m+col;
                        int n2=newrow*m+newcol;
                        
                        if(ds.findParent(n1)!=ds.findParent(n2)){
                            cnt--;
                            ds.unionBysize(n1,n2);
                        }
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
    
}
