package honework20.app;

import java.util.ArrayList;
import java.util.HashMap;


public class Graph {
    int vertexCount;

    //In that case using HashMap instead of ArrayList allow to make code more readable and understandable
    HashMap<Integer, ArrayList<Integer>> adjacencyList;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjacencyList = new HashMap<>();
        for (int i = 0; i < vertexCount; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(int start, int destination){
        if (!(hasVertex(start) && hasVertex(destination))){
            System.out.println("Bad input: this vertex doesn't exist");
            return;
        }

        adjacencyList.get(start).add(destination);
        adjacencyList.get(destination).add(start);
    }

    public void removeVertex(int vertex) {
        if (!hasVertex(vertex)){
            System.out.println("Bad input: this vertex doesn't exist");
            return;
        }

        adjacencyList.remove(vertex);
        for (ArrayList<Integer> edges : adjacencyList.values()) {
            edges.remove(Integer.valueOf(vertex));
        }
    }

    public void removeEdge(int start, int destination){
        if (!(hasVertex(start) && hasVertex(destination))){
            System.out.println("Bad input: this vertex doesn't exist");
            return;
        }
        adjacencyList.get(start).remove(Integer.valueOf(destination));
        adjacencyList.get(destination).remove(Integer.valueOf(start));
    }

    public boolean hasVertex(int vertex){
        return adjacencyList.containsKey(vertex);
    }

    public boolean hasEdge (int start, int destination){

        boolean statement1 = adjacencyList.get(start).contains(destination);
        boolean statement2 = adjacencyList.get(destination).contains(start);
        return statement1 && statement2;
    }


    public void printGraph() {
        for (HashMap.Entry<Integer, ArrayList<Integer>> entry : adjacencyList.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + " is connected to " + entry.getValue());
        }
    }

    private void checkInputVertex(boolean statement){
        if (!statement){
            System.out.println("Bad input: this vertex doesn't exist");
            return;
        }
    }

}
