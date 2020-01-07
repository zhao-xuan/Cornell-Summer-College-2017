package Lecture05;

public class Graph {

	LinkedList allNodes, allEdges;
	public Graph() {
		this.allNodes = new LinkedList();
		this.allEdges = new LinkedList();
	}
	public void addNode(double a) {
		allNodes.join(a);
	}
	public void addEdge(double a, double b) {
		Node temp1 = allNodes.find(a);
		Node temp2 = allNodes.find(b);
		Edge e = new Edge(temp1, temp2);
		allEdges.join(e);
	}
}
