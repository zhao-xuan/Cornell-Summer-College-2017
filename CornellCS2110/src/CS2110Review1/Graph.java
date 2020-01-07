package CS2110Review1;

public class Graph {

	public LinkedList allVertice;
	public LinkedList allEdges;
	public Graph() {
		this.allVertice = new LinkedList();
		this.allEdges = new LinkedList();
	}
	public Graph(LinkedList v) {
		this.allVertice = new LinkedList();
		this.allEdges = new LinkedList();
		Node temp = v.back;
		while (!(temp == null)) {
			allVertice.push(v);
			temp = temp.getNext();
		}
	}
	public void addEdge(Vertice from, Vertice to, int weight) {
		if (from.equals(to)) {
			return;
		}
		Edges e = new Edges(from, to, weight);
		allEdges.push(e);
		from.addNeighbor(e);
		to.addNeighbor(e);
	}
	public void addVertex(Vertice v) {
		this.allVertice.push(v);
	}
	public void printGraph() {
		Stack s = new Stack();
		LinkedList l = this.allVertice;
		Node temp = l.back;
		while (!(temp == null)) {
			String t = ((Vertice)temp.getData()).getLabel();
			System.out.println(t);
			temp = temp.getNext();
		}
	}
	public void BFS(Vertice v) {
		Stack bfs = new Stack();
		Node temp = this.allVertice.back;
		
	}
}
