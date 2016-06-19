package ms_test;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Graph {
	public static ArrayList<Edge> edges;
	public static ArrayList<Node> nodes;

	private ArrayList<ArrayList<Integer>> pathsList;
	private ArrayList<Integer> path;

	public Graph(ArrayList<Integer> array) {
		/*
		 * Initialization
		 */
		edges = new ArrayList<>();
		nodes = new ArrayList<>();
		pathsList = new ArrayList<>();
		path = new ArrayList<>();

		/*
		 * Filling lists
		 */
		setEdgesList(array);
		setNodesList();

		/*
		 * Main function Cycles search
		 */
		for (Node node : nodes) {
			clearNodesVisible();
			dfs(node);
			path.clear();
		}
	}

	@SuppressWarnings("unchecked")
	public void dfs(Node nodeA) {
		nodeA.visited = true;
		for (Node nodeB : nodes) {

			if (nodeA.isNotConnectedToAnyNode()) {
				path.clear();
			}

			if (nodeA.isConnectedTo(nodeB) && nodeB.visited == true) {

				path.add(0, nodeB.name);

				path.add(nodeB.name);

				pathsList.add((ArrayList<Integer>) path.clone());
			}

			if (nodeA.isConnectedTo(nodeB) && nodeB.visited == false) {
				nodeB.visited = true;
				path.add(nodeB.name);
				dfs(nodeB);
			}
		}
	}

	private void clearNodesVisible() {
		for (Node n : nodes) {
			n.visited = false;
		}
	}

	private void setNodesList() {
		LinkedHashSet<Integer> nodesNames = new LinkedHashSet<>();

		for (Edge e : edges) {
			nodesNames.add(e.begin);
			nodesNames.add(e.end);
		}

		for (int name : nodesNames) {
			nodes.add(new Node(name));
		}
	}

	private void setEdgesList(ArrayList<Integer> array) {
		for (int i = 0; i < array.size() - 1; i += 2) {
			edges.add(new Edge(array.get(i), array.get(i + 1)));
		}
	}

	public String getResult() {
		StringBuilder str = new StringBuilder();
		String res;
		for (ArrayList<Integer> pathName : pathsList) {
			for (int node : pathName) {
				str.append(node + " ");
			}
			str.append("\n");
		}
		res = str.toString();
		return res;
	}

}
