package Lecture07;

public class Lecture07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST tree = new BST();
		tree.insert(new Integer(3), tree.root);
		tree.insert(new Integer(4), tree.root);
		tree.insert(new Integer(2), tree.root);
		System.out.println(tree.root.getValue());
		System.out.println(tree.root.getLeft().getValue());
		System.out.println(tree.root.getRight().getValue());
	}

}
