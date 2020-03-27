package Assignment5;

import java.util.Set;

// class to run the graph class provided and created for this assignment
// !!!!! DO NOT INCLUDE THIS IN YOUR SUBMISSION !!!!!
public class GraphRunner {
    public static void main(String[] args) {
        // create GraphBuilder object -- will be used to build graphs in the runner
        GraphBuilder builder = new GraphBuilder();
        // create GraphUtils object -- will be used to perform analyses on the graphs
        GraphUtils utils = new GraphUtils();

        // create an undirected graph using the test txt file
        UndirectedGraph undirectedGraph = builder.buildUndirectedGraph("C:\\Users\\payne\\Desktop\\MCIT594\\src\\Assignment5\\graph_builder_test.txt");

        // create an undirected graph using the test txt file
        DirectedGraph directedGraph = GraphBuilder.buildDirectedGraph("C:\\Users\\payne\\Desktop\\MCIT594\\src\\Assignment5\\graph_builder_test.txt");

        System.out.println("Nodes within distance of 1 from node 1: ");
        System.out.println(utils.nodesWithinDistance(directedGraph, "1", 1));
        System.out.println();

        System.out.println("Nodes within distance of 3 from node 2: ");
        System.out.println(utils.nodesWithinDistance(undirectedGraph, "1", 3));
        System.out.println();
    }
}
