package Assignment5;

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
        DirectedGraph directedGraph = builder.buildDirectedGraph("C:\\Users\\payne\\Desktop\\MCIT594\\src\\Assignment5\\graph_builder_test.txt");

        System.out.println(utils.minDistance(undirectedGraph,"a", "b"));

    }
}
