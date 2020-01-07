package Lecture10;

public class TreeIterator<T> {

	public Node<T> currentNode;
	public BST<T> targetTree;
	
	public TreeIterator() {
		this.currentNode = null;
		this.targetTree = null;
	}
	public TreeIterator(T data, BST<T> tree) {
		this.currentNode = new Node<T>(data);
		this.targetTree = tree;
	}
}