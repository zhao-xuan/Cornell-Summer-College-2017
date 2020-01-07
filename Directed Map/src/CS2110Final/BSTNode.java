package CS2110Final;

public class BSTNode<T> {

	public BSTNode<T> parent, left, right;
	public T data;
	
	public BSTNode(T data) {
		this.data = data;
	}
	
	public BSTNode<T> getParent() { return this.parent; }
	public BSTNode<T> getLeft() { return this.left; }
	public BSTNode<T> getRight() { return this.right; }
	public T getData() { return this.data; }
	public void setParent(BSTNode<T> node) { this.parent = node; }
	public void setLeft(BSTNode<T> node) { this.left = node; }
	public void setRight(BSTNode<T> node) { this.right = node; }
	public void setData(T data) { this.data = data; }
	public boolean hasLeft() { return (this.left != null); }
	public boolean hasRight() { return (this.right != null); }
	
}
