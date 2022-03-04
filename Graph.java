import java.util.*;

public class Graph {
    private static LinkedList<Integer>[] adj;
    public Graph(int vertices) {
        adj = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }

    public static void main(String[] args) {
        int _vertices = 5, _edges = 6, source, destination;
        Graph graph = new Graph(_vertices);
        Scanner scan = new Scanner(System.in);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(0, 4);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        /*for(int i = 0; i < _edges; i++) {
            source = scan.nextInt();
            destination = scan.nextInt();
            graph.addEdge(source, destination);
        }*/
        for(int i = 0; i < _vertices; i++) {
            System.out.print(i +" --> "+adj[i]);
            System.out.println();
        }
        
    }
}
