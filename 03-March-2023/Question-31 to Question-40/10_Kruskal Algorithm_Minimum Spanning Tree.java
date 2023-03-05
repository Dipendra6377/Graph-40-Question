import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This will compare twoEdge
// e1 = new Edge(0, 1, 4);
//Edge e2 = new Edge(1, 2, 1);
//Edge e3 = new Edge(0, 2, 2);

// it The compareTo method compares two Edge objects based on their weight values.
// Specifically, it subtracts the weight of the compareEdge from the weight of the current Edge. 
// This returns a negative integer if the current Edge has a smaller weight, a positive integer if the current 
// Edge has a larger weight, and 0 if the Edge objects have the same weight.
class Edge implements Comparable<Edge> {
    int src, dest, weight;
    Edge(int _src, int _dest, int _wt) {
        this.src = _src; this.dest = _dest; this.weight = _wt;
    }
    // Comparator function used for
    // sorting edgesbased on their weight
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
};


// this is same as Disjoint Set question in abive question

class Disjoinset{
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();

    Disjoinset(int n){
        for (int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findparent(int node){
        if(node==parent.get(node)){
            return node;
        }

        int child=findparent(parent.get(node));
        parent.set(node,child);
        return parent.get(node);
    }

    public void Setunion_Bysize(int u,int v){
        int parent_u=findparent(u);
        int parent_v=findparent(v);
        if (parent_u==parent_v) return;

        if(size.get(parent_u)>size.get(parent_v)){
            parent.set(parent_v,parent_u);
            size.set(parent_u,size.get(parent_u)+size.get(parent_v));
        }
        else {
            parent.set(parent_u,parent_v);
            size.set(parent_v,size.get(parent_u)+size.get(parent_v));
        }
    }
}



class tuples{
    int first;
    int second;
    tuples(int first,int second){
        this.first=first;
        this.second=second;
    }
}

public class Minimum_Spanning_tree {
    public static void main(String[] args) {
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        int V=5;

        int wt=minimum_spanning_tree(edges,V);
        System.out.println(wt);
    }

    static int minimum_spanning_tree(int[][]edges,int V){
        ArrayList<ArrayList<tuples>> adj =new ArrayList<>();

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new tuples(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new tuples(edges[i][0],edges[i][2]));
        }
        List<Edge> edge =new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (tuples node : adj.get(i)){
                int node1=node.first;
                int wt=node.second;

                Edge temp =new Edge(i,node1,wt);
                edge.add(temp);
            }
        }
        Collections.sort(edge);

        Disjoinset ds=new Disjoinset(V);
        int mstWt = 0;
        // T C   ::::: M x 4 x alpha x 2
        for (int i = 0; i < edge.size(); i++) {
            int wt = edge.get(i).weight;
            int u = edge.get(i).src;
            int v = edge.get(i).dest;

            if (ds.findparent(u) != ds.findparent(v)) {
                mstWt += wt;
                ds.Setunion_Bysize(u, v);
            }
        }

        return mstWt;

    }
}
