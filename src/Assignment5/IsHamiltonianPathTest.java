package Assignment5;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import java.util.LinkedList;
import java.util.List;

public class IsHamiltonianPathTest
{
    public static final String FILENAME = "is_hamiltonian_path_test.txt";

    protected List<String> createValidPath() {
        final LinkedList<String> list = new LinkedList<String>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("0");
        return list;
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testValidUndirected() {
        final List<String> validPath = this.createValidPath();
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph("is_hamiltonian_path_test.txt");
        try {
            Assert.assertTrue("isHamiltonianPath returns incorrect value when list represents a valid Hamiltonian path in undirected graph", GraphUtils.isHamiltonianPath((Graph)buildUndirectedGraph, (List)validPath));
        }
        catch (Exception ex) {
            Assert.fail("isHamiltonianPath throws exception when list represents a valid Hamiltonian path in undirected graph: " + ex.toString());
        }
    }

    @Test
    public void testValidDirected() {
        final List<String> validPath = this.createValidPath();
        final DirectedGraph buildDirectedGraph = GraphBuilder.buildDirectedGraph("is_hamiltonian_path_test.txt");
        try {
            Assert.assertTrue("isHamiltonianPath returns incorrect value when list represents a valid Hamiltonian path in directed graph", GraphUtils.isHamiltonianPath((Graph)buildDirectedGraph, (List)validPath));
        }
        catch (Exception ex) {
            Assert.fail("isHamiltonianPath throws exception when list represents a valid Hamiltonian path in directed graph: " + ex.toString());
        }
    }
}