package CS2110Review1;

public class Vertice {

	public LinkedList neighborhood;
	public String label;
	
	public Vertice(String label) {
		this.neighborhood = new LinkedList();
		this.label = label;
	}
	
	public void addNeighbor(Edges e) {
		this.neighborhood.push(e);
	}
	public boolean containNeighbor(Edges e) {
		Node temp = this.neighborhood.back;
		while (!(temp == null)) {
			if (temp.getData().equals(e)) {
				return true;
			}
			temp = temp.getNext();
		}
		
		return false;
	}
	public String getLabel() {
		return this.label;
	}
}
