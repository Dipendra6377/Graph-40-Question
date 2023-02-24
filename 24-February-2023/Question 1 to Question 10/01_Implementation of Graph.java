import java.util.ArrayList;

public class Graph_Implementation {
    public static void main(String[] args) {
        int v=5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);

        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        printGraph(adj);
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj ,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    static void
    printGraph(ArrayList<ArrayList<Integer> > adj)
    {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex"
                    + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "
                        + adj.get(i).get(j));
            }
            System.out.println();
        }
    }
}



// OUTPUT
Adjacency list of vertex0
head -> 1 -> 4

Adjacency list of vertex1
head -> 0 -> 2 -> 3 -> 4

Adjacency list of vertex2
head -> 1 -> 3

Adjacency list of vertex3
head -> 1 -> 2 -> 4

Adjacency list of vertex4
head -> 0 -> 1 -> 3
