package Assignment5;

import java.util.*;

public class GraphUtils {
	
	/*
	 * Implement the following methods.
	 */

	public static int minDistance(Graph graph, String src, String dest) {
		// check if values passed to method are null and return -1 if true
		if(graph == null || src.isEmpty() || src == "" || dest.isEmpty() || dest == "" || !graph.containsNode(src) || !graph.containsNode(dest)){
			return -1;
		}

		// implement a modified BFS to get get the distances between nodes
		int[] distances = new int[graph.getNumNodes()];
		Arrays.fill(distances, -1);





		return 0;
	}

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
		return null;
	}

	public static boolean isHamiltonianPath(Graph g, List<String> values) {
		return false;
	}
	
}
