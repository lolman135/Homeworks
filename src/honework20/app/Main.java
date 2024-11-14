package honework20.app;

public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        System.out.println("Start graph:");
        graph.printGraph();

        graph.addVertex(5);
        graph.addEdge(2, 5);
        graph.addEdge(3 ,5);

        System.out.println("\nafter adding vertex and edges:");
        graph.printGraph();

        graph.removeVertex(1);
        System.out.println("\nafter removing vertex:");
        graph.printGraph();

        graph.removeEdge(2, 3);
        System.out.println("\nafter removing edge:");
        graph.printGraph();

        System.out.println(graph.hasVertex(0));
        System.out.println(graph.hasVertex(6));

        System.out.println(graph.hasEdge(2, 5));
        System.out.println(graph.hasEdge(2, 3));
    }
}
