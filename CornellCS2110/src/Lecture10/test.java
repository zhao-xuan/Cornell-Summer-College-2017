package Lecture10;

public class test {

	public static void main(String[] args) {
		BST<Integer> tree1 = new BST<Integer>(5);
		tree1.appendValue(2);
		tree1.appendValue(3);
		tree1.appendValue(4);
		tree1.printTree();
	}
}