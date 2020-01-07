package CS2110Final;

public class GnomenWald {

	public LinkedList<Village> allVillages;
	public LinkedList<Gnome> allGnomes;
	public LinkedList<Road> allRoads;
	
	public GnomenWald() {
		//init of GnomenWald
		this.allGnomes = new LinkedList<Gnome>();
		this.allRoads = new LinkedList<Road>();
		this.allVillages = new LinkedList<Village>();
	}

	public void addVillage(Village v) {
		this.allVillages.join(v);
	}
	
	public void addRoad(Road r) {
		this.allRoads.join(r);
	}
	
	public Village deleteVillage(Village d) {
		Village temp = this.allVillages.delete(d);
		return temp;
	}
	
	public Road deleteRoad(Road r) {
		Road temp = this.allRoads.delete(r);
		return temp;
	}
	
	public void gnomeWalk(Gnome g, Village from, Village to) {
		//这里需要写最短路径 而且需要打印这个村民从‘from’ 村庄到‘to’村庄的最短路径
	}
	
	public void printVillages() {
		Node<Village> temp = this.allVillages.head;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
}