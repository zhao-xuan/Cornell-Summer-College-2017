package CS2110Review1;

public class Review1 {

	public static void main(String[] args) {
		Graph g = new Graph();
		Vertice v1 = new Vertice("A");
		Vertice v2 = new Vertice("B");
		Vertice v3 = new Vertice("C");
		Vertice v4 = new Vertice("D");
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		g.printGraph();
		g.addEdge(v1, v3, 1);
		g.addEdge(v1, v2, 1);
		g.addEdge(v4, v2, 1);
		
		Node temp = g.allEdges.back;
		while (!(temp == null)) {
			Edges tempe = (Edges)temp.getData();
			System.out.println(tempe.from.label + " ---> " + tempe.to.label);
			temp = temp.getNext();
		}
		
		System.out.println();
	}

}
