package CS2110Final;

public class Road {

	public Village from, to;
	public int weight;
	
	public Road() {
		// TODO Auto-generated constructor stub
		this.from = new Village();
		this.to = new Village();
		this.weight = 0;
	}
	
	public Road(Village from, Village to) {
		this.from = from;
		this.to = to;
		this.weight = 0;
	}
	
	public Road(Village from, Village to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}