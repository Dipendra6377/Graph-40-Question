class Solution {
    public int findCenter(int[][] edges) {
         if(edges[0][0]==edges[1][0]||edges[0][0]==edges[1][1])return edges[0][0];
        return edges[0][1];
    }
}



//////////////////////////////////////////

class Solution {
    public int findCenter(int[][] edges) {
        int a = edges[0][0];
        int b = edges[0][1];
        int ans=0;
        for(int[] i:edges){
            if(a==i[0] || a==i[1]){
                ans=a;
            }
            else{
                ans=b;
            }
        }
        return ans;
    }
}
