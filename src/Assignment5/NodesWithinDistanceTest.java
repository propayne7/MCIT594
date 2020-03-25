package Assignment5;

import org.junit.Test;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;

public class NodesWithinDistanceTest
{
    public static final String FILENAME = "graph_builder_test.txt";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testDistance1Undirected() {
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
        try {
            final Set nodesWithinDistance = GraphUtils.nodesWithinDistance((Graph)buildUndirectedGraph, "0", 1);
            Assert.assertNotNull("nodesWithinDistance returns returns incorrect value when distance = 1 in undirected graph", (Object)nodesWithinDistance);
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect number of elements when distance = 1 in undirected graph", nodesWithinDistance.size() == 4);
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in undirected graph", nodesWithinDistance.contains("1"));
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in undirected graph", nodesWithinDistance.contains("2"));
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in undirected graph", nodesWithinDistance.contains("3"));
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in undirected graph", nodesWithinDistance.contains("5"));
        }
        catch (Exception ex) {
            Assert.fail("nodesWithinDistance throws exception when distance = 1 in undirected graph: " + ex.toString());
        }
    }

    @Test
    public void testDistance1Directed() {
        final DirectedGraph buildDirectedGraph = GraphBuilder.buildDirectedGraph("graph_builder_test.txt");
        try {
            final Set nodesWithinDistance = GraphUtils.nodesWithinDistance((Graph)buildDirectedGraph, "1", 1);
            Assert.assertNotNull("nodesWithinDistance returns incorrect value when distance = 1 in directed graph", (Object)nodesWithinDistance);
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect number of elements when distance = 1 in directed graph", nodesWithinDistance.size() == 2);
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in directed graph", nodesWithinDistance.contains("2"));
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in directed graph", nodesWithinDistance.contains("5"));
        }
        catch (Exception ex) {
            Assert.fail("nodesWithinDistance throws exception when distance = 1 in directed graph: " + ex.toString());
        }
    }
}
