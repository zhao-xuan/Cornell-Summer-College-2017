package Lecture07;

public class TreeNode {

	public TreeNode left, right;
	public Integer value;
	
	public TreeNode() {
		this.left = null;
		this.right = null;
		this.value = null;
	}
	public TreeNode(Integer v) {
		this.left = null;
		this.right = null;
		this.value = v;
	}
	
	public TreeNode getLeft() { return this.left; }
	public TreeNode getRight() { return this.right; }
	public void setLeft(TreeNode l) { this.left = l; }
	public void setRight(TreeNode r) { this.right = r; }
	public Integer getValue() { return this.value; }
}