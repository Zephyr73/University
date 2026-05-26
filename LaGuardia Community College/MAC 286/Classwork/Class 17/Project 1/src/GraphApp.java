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
        g.addVertex('E');

        g.displayMatrix();
        System.out.println("No. of edges: " + g.countEdges());
        System.out.println("Degree of vertex B: " + g.countDegree(1));
        System.out.println("Degree of vertex E: " + g.countDegree(4));
    }
}