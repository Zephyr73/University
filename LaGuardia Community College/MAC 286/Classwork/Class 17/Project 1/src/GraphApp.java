public class GraphApp {
    public static void main(String[] args)
    {
        Graph g = new Graph();

        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addEdge(1,2);
        g.addEdge(0,1);

        g.displayMatrix();
        System.out.println("No. of edges: " + g.countEdges());
    }
}