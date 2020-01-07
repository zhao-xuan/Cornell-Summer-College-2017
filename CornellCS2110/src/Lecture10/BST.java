package Lecture10;

public class BST<T> {

	public Node<T> root;
	
	public BST() {
		this.root = null;
	}
	public BST(T data) {
		this.root = new Node<T>(data);
	}
	
	public void appendValue(T data) {
		Node<T> temp = this.root;
		
		while (temp != null) {
			if (data.toString().compareTo(temp.getData().toString()) > 0) {
				if (temp.hasRight()) {
					temp = temp.getRight();
				} else {
					temp.setRight(data);
					break;
				}
			} else {
				if (temp.hasLeft()) {
					temp = temp.getLeft();
				} else {
					temp.setLeft(data);
					break;
				}
			}
		}
	}
	
	public void printTree() {
		Node<T> temp = this.root;
		Node<T> left_leaf = new Node<T>();
		
		while (temp != null) {
			if (temp.hasLeft()) {
				temp = temp.getLeft();
			} else {
				left_leaf = temp;
				break;
			}
		}
		
		while (left_leaf != null) {
			System.out.println(temp);
			temp = left_leaf.getParent();
			if (temp.hasRight()) {
				
			}
		}
	}
}