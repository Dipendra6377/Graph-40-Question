import java.util.ArrayList;
import java.util.List;

class DisjointSet{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();

    DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node){
        if(node==parent.get(node)){
            return node;
        }

        int ulp = findUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }

    public void unionByRank(int u,int v){
        int par_u =findUPar(u);
        int par_v =findUPar(v);

        if(par_u == par_v) return ;

        if(rank.get(par_u)< rank.get(par_v)){
            parent.set(par_u,par_v);
        }
        else if(rank.get(par_v)<rank.get(par_u)){
            parent.set(par_v,par_u);
        }
        else{
            parent.set(par_v,par_u);
            int rankU = rank.get(par_u);
            rank.set(par_u,rankU+1);
        }
    }
}


public class Union_By_rank {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}
