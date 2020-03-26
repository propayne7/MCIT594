package Assignment5;

import java.security.acl.LastOwnerException;
import java.util.*;

public class GraphUtils {
	public static final int WEIGHT = 1;
	
	/*
	 * Implement the following methods.
	 */

	public static int minDistance(Graph graph, String src, String dest) {
		// check if values passed to method are null and return -1 if true
		if(graph == null || src.isEmpty() || src == "" || dest.isEmpty() || dest == "" || !graph.containsNode(src) || !graph.containsNode(dest)){
			return -1;
		}
		// create a hashmap with the nodes as the key and distances from src as the value;
		Map<String, Integer> nodesWithDistances = new HashMap<>();
		// populate all values in hashmap with -1 as a default value
		// note that if any value is -1 after the modified BFS below completes, this means the node was not reachable from the src node
		for(String s : graph.getAllNodes()){
			nodesWithDistances.put(s, -1);
		}

		Set<String> marked = new HashSet<>();
		Queue<String> toExplore = new LinkedList<String>();
		int[] distances = new int[graph.getNumNodes()];
		Arrays.fill(distances, -1);

		marked.add(src);
		toExplore.add(src);
		while (!toExplore.isEmpty()) {
			String current = toExplore.remove();
			for (String neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					if (neighbor.equals(dest)) {
						break;
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
			distance++;
		}
		return distance - 1;
	}

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
		return null;
	}

	public static boolean isHamiltonianPath(Graph g, List<String> values) {
		return false;
	}
	
}
