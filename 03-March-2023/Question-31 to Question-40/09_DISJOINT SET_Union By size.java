import java.util.ArrayList;
import java.util.List;

class DisjointSet{
    List<Integer> size=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();

    DisjointSet(int n){
        for(int i=0;i<=n;i++){
            size.add(1);
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

    public void unionBySize(int u,int v){
        int par_u =findUPar(u);
        int par_v =findUPar(v);

        if(par_u == par_v) return ;

        if(size.get(par_u)< size.get(par_v)){
            parent.set(par_u,par_v);
            size.set(par_v, size.get(par_u)+size.get(par_v));
        }
        else  {
            parent.set(par_v, par_u);
            size.set(par_v, size.get(par_u) + size.get(par_v));
        }
    }
}


public class Union_By_size {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // if 3 and 7 same or not
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionBySize(3, 7);
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}
