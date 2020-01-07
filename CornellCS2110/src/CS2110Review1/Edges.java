package CS2110Review1;

public class Edges {

	public Vertice from, to;
	public int weight;
	
	public Edges(Vertice from, Vertice to) {
		this.from = from;
		this.to = to;
		this.weight = 1;
	}
	public Edges(Vertice from, Vertice to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	public Vertice getAlternative(Vertice v) {
		if (v.equals(from)) {
			return this.to;
		}
		return this.from;
	}

}
