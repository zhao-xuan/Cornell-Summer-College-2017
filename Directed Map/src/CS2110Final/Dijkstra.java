package CS2110Final;

public class Dijkstra {
	private Village v;
	private Village pre;
	private int cost;
	boolean vis;

	public Dijkstra(Village v) {
		this.setV(v);
		setPre(null);
		setCost(Integer.MAX_VALUE);
		vis = false;
	}

	public void clearCache() {
		pre = null;
		cost = Integer.MAX_VALUE;
		vis = false;
	}

	public static Dijkstra findNodeByVillage(Village v, LinkedList<Dijkstra> allNodes) {
		Node<Dijkstra> header = allNodes.head;
		while (header.hasNext()) {
			if (header.getNext().getData().getV().equals(v))
				return header.getNext().getData();
			header = header.getNext();
		}

		return null;

	}

	public Village getV() {
		return v;
	}

	public void setV(Village v) {
		this.v = v;
	}

	public Village getPre() {
		return pre;
	}

	public void setPre(Village pre) {
		this.pre = pre;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
