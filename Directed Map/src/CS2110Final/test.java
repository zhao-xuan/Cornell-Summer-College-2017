package CS2110Final;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GnomenWald map = new GnomenWald();
		Village v1 = new Village("Rochester");
		Gnome v1g1 = new Gnome("Thomas", "Red", 1);
		Gnome v1g2 = new Gnome("Jerry", "Blue", 0);
		Gnome v1g3 = new Gnome("Jordan", "Yellow", 2);
		Gnome v1g4 = new Gnome("Philips", "Purple", 1);
		v1.addGnomes(v1g1); v1.addGnomes(v1g2); v1.addGnomes(v1g3); v1.addGnomes(v1g4);
		Village v2 = new Village("Syracuse");
		Gnome v2g1 = new Gnome("Sarah", "Pink", 3);
		Gnome v2g2 = new Gnome("John", "Black", 2);
		Gnome v2g3 = new Gnome("Yelson", "White", 1);
		Gnome v2g4 = new Gnome("Jeremy", "Lightblue", 4);
		v2.addGnomes(v2g1); v2.addGnomes(v2g2); v2.addGnomes(v2g3); v2.addGnomes(v2g4);
		Village v3 = new Village("Ithaca");
		Gnome v3g1 = new Gnome("Frank", "Jet black", 0);
		Gnome v3g2 = new Gnome("Mark", "Brown", 3);
		Gnome v3g3 = new Gnome("Alan", "Cyan", 0);
		Gnome v3g4 = new Gnome("Ray", "Red", 0);
		v3.addGnomes(v3g1); v3.addGnomes(v3g2); v3.addGnomes(v3g3); v3.addGnomes(v3g4);
		Village v4 = new Village("New York");
		Gnome v4g1 = new Gnome("Jimmy", "White", 2);
		Gnome v4g2 = new Gnome("Joseph", "Red", 2);
		Gnome v4g3 = new Gnome("Amy", "Yellow", 3);
		Gnome v4g4 = new Gnome("Greenwich", "Green", 1);
		v4.addGnomes(v4g1); v4.addGnomes(v4g2); v4.addGnomes(v4g3); v4.addGnomes(v4g4);
		Village v5 = new Village("San Francisco");
		Gnome v5g1 = new Gnome("Bob", "Green", 4);
		Gnome v5g2 = new Gnome("Paul", "Pink", 4);
		Gnome v5g3 = new Gnome("Staple", "Jet Black", 3);
		Gnome v5g4 = new Gnome("Mary", "Purple", 1);
		v5.addGnomes(v5g1); v5.addGnomes(v5g2); v5.addGnomes(v5g3); v5.addGnomes(v5g4);
		
		map.addVillage(v1);
		map.addVillage(v2);
		map.addVillage(v3);
		map.addVillage(v4);
		map.addVillage(v5);
		
		map.printVillages();
		v1.printGnomes();
	}
}
