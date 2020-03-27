package Assignment5;

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
		if(graph instanceof UndirectedGraph){
			Map<String, Integer> nodesWithDistances = moddedBFS((UndirectedGraph) graph, src, dest);
			return nodesWithDistances.get(dest);
		}

		if(graph instanceof DirectedGraph){
			Map<String, Integer> nodesWithDistances = moddedBFS((DirectedGraph) graph, src, dest);
			return nodesWithDistances.get(dest);
		}
		return -1;
	}

	public static Map<String, Integer> moddedBFS(UndirectedGraph graph, String src, String dest) {

		// create a hashmap with the nodes as the key and distances from src as the value;
		Map<String, Integer> nodesWithDistances = new HashMap<>();
		// populate all values in hashmap with -1 as a default value
		// note that if any value is -1 after the modified BFS below completes, this means the node was not reachable from the src node
		for(String s : graph.getAllNodes()){
			nodesWithDistances.put(s, -1);
		}
		// hashset to
		Set<String> marked = new HashSet<>();
		Queue<String> toExplore = new LinkedList<String>();

		marked.add(src);
		toExplore.add(src);
		// mark distance from src to itself as 0
		nodesWithDistances.put(src, 0);

		while (!toExplore.isEmpty()) {
			String current = toExplore.remove();
			for (String neighbor : graph.getNodeNeighbors(current)) {
				int nodeDistance = nodesWithDistances.get(neighbor);
				nodesWithDistances.put(neighbor, nodeDistance + 1);
				if (!marked.contains(neighbor)) {
					if (neighbor.equals(dest)) {
						break;
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
		}
		return nodesWithDistances;
	}

	public static Map<String, Integer> moddedBFS(DirectedGraph graph, String src, String dest) {

		// create a hashmap with the nodes as the key and distances from src as the value;
		Map<String, Integer> nodesWithDistances = new HashMap<>();
		// populate all values in hashmap with -1 as a default value
		// note that if any value is -1 after the modified BFS below completes, this means the node was not reachable from the src node
		for(String s : graph.getAllNodes()){
			nodesWithDistances.put(s, 0);
		}
		// hashset to
		Set<String> marked = new HashSet<>();
		Queue<String> toExplore = new LinkedList<String>();

		marked.add(src);
		toExplore.add(src);
		// mark distance from src to itself as 0
		nodesWithDistances.put(src, 0);

		while (!toExplore.isEmpty()) {
			String current = toExplore.remove();
			for (String neighbor : graph.getNodeNeighbors(current)) {
				System.out.println("Current Node: " + current);
				System.out.println("Neighbors: " + graph.getNodeNeighbors(current));
				System.out.println();
				int nodeDistance = nodesWithDistances.get(neighbor);
				nodesWithDistances.put(neighbor, nodeDistance + 1);
				if (!marked.contains(neighbor)) {
					if (neighbor.equals(dest)) {
						break;
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
		}
		System.out.println("Nodes with distances: " + nodesWithDistances);
		return nodesWithDistances;
	}

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
		return null;
	}

	public static boolean isHamiltonianPath(Graph g, List<String> values) {
		return false;
	}
	
}
