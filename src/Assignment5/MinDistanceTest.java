package Assignment5;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class MinDistanceTest
{
    public static final String FILENAME = "C:\\Users\\payne\\Desktop\\MCIT594\\src\\Assignment5\\graph_builder_test.txt";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testSrcDestConnectedUndirected() {
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        try {
            Assert.assertTrue("minDistance returns incorrect value when src and dest are connected by a single edge in an undirected graph", GraphUtils.minDistance((Graph)buildUndirectedGraph, "1", "2") == 1);
        }
        catch (Exception ex) {
            Assert.fail("minDistance throws exception when src and dest are connected by a single edge in an undirected graph: " + ex.toString());
        }
    }

    @Test
    public void testSrcDestConnectedDirected() {
        final DirectedGraph buildDirectedGraph = GraphBuilder.buildDirectedGraph(FILENAME);
        try {
            Assert.assertTrue("minDistance returns incorrect value when src and dest are connected by a single edge in a directed graph", GraphUtils.minDistance((Graph)buildDirectedGraph, "1", "2") == 1);
        }
        catch (Exception ex) {
            Assert.fail("minDistance throws exception when src and dest are connected by a single edge in a directed graph: " + ex.toString());
        }
    }
}