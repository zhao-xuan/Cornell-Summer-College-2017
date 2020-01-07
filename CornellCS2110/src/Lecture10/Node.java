package Lecture10;

public class Node<T> {

	public Node<T> parent, left, right;
	public T data;
	
	public Node() {
		this.parent = this.left = this.right = null;
		this.data = null;
	}
	public Node(T data) {
		this.parent = this.left = this.right = null;
		this.data = data;
	}
	
	public T getData() { return this.data; }
	public Node<T> getLeft() { return this.left; }
	public Node<T> getRight() { return this.right; }
	public Node<T> getParent() { return this.parent; }
	
	public void setData(T data) { this.data = data; }
	public void setLeft(T data) {
		Node<T> temp = new Node<T>(data);
		this.left = temp;
		this.left.parent = this;
	}
	
	public void setRight(T data) {
		Node<T> temp = new Node<T>(data);
		this.right = temp;
		this.right.parent = this;
	}
	public void setParent(T data) {
		Node<T> temp = new Node<T>(data);
		if (this.getData().toString().compareTo(temp.getData().toString()) > 0) {
			temp.right = this;
		} else {
			temp.left = this;
		}
		this.parent = temp;
	}
	public boolean hasLeft() {
		return (this.left != null);
	}
	public boolean hasRight() {
		return (this.right != null);
	}

}