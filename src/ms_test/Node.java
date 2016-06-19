package ms_test;

public class Node {

	int name;
	boolean visited;

	public Node(int name) {
		this.name = name;
		visited = false;
	}

	public boolean isConnectedTo(Node node) {
		for (Edge e : Graph.edges) {
			if (e.begin == name && e.end == node.name)
				return true;
		}
		return false;
	}
	
	public boolean isNotConnectedToAnyNode(){
		for (Edge e : Graph.edges) {
			for (Node n : Graph.nodes) {
				if (e.begin == name && e.end == n.name){
					return false;
				}
			}
		}
		
		return true;
	}
}
