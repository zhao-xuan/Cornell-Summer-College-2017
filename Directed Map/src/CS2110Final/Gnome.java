package CS2110Final;

public class Gnome {

	public static int ID_SETTER = 1;
	public String name;
	public int id;
	public String fav_color;
	public int vip_status; //vip status will never be negative unless the person is unset
	
	public Gnome() {
		// TODO Auto-generated constructor stub
		this.name = "";
		this.id = ID_SETTER++;
		this.fav_color = "Red";
		this.vip_status = 0;
	}
	
	public Gnome(String name, String fav_color, int vip_status) {
		this.name = name;
		this.id = ID_SETTER++;
		this.fav_color = fav_color;
		this.vip_status = vip_status;
	}
	
	public Gnome trackById(int id) {
		//二叉树
		return null;
	}
	
	public LinkedList<Gnome> trackByName(String name) {
		//二叉树
		return null;
	}
	
	public LinkedList<Gnome> trackByfavColor(String color) {
		//二叉树
		return null;
	}
	
	public LinkedList<Gnome> trackByVIPStatus() {
		//二叉树
		return null;
	}

	public String toString() {
		return "ID: " + this.id + " Name: " + this.name + " Favorite Color: " + this.fav_color + " VIP Status: " + this.vip_status;
	}
}
