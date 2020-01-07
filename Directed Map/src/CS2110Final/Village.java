package CS2110Final;

public class Village {

	public static int VILLAGE_ID_SETTER = 1;
	public int id;
	public String name;
	public LinkedList<Gnome> allGnomes;
	public LinkedList<Village> adj_villages;
	
	public Village() {
		// TODO Auto-generated constructor stub
		this.id = this.VILLAGE_ID_SETTER++;
		this.name = "";
		this.allGnomes = new LinkedList<Gnome>();
		this.adj_villages = new LinkedList<Village>();
	}

	public Village(String name) {
		this.id = this.VILLAGE_ID_SETTER++;
		this.name = name;
		this.allGnomes = new LinkedList<Gnome>();
		this.adj_villages = new LinkedList<Village>();
	}

	public void addGnomes(Gnome g) {
		this.allGnomes.join(g);
	}
	
	public Gnome deleteGnome(Gnome g) {
		Gnome temp = this.allGnomes.delete(g);
		return temp;
	}
	public void addAdjVillage(Village adj) {
		this.adj_villages.join(adj);
	}
	public void printGnomes() {
		Node<Gnome> temp = this.allGnomes.head;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
	public String toString() {
		return "Name: " + this.name + " Id: " + this.id; 
	}
}
