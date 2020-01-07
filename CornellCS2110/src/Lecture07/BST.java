package Lecture07;

public class BST {

	TreeNode root;
	
	public BST() {
		this.root = null;
	}
	public BST(TreeNode n) {
		this.root = n;
	}
	public BST(int i) {
		this.root = new TreeNode(new Integer(i));
	}
	public boolean isEmpty() {
		if (this.root == null) {
			return true;
		}
		return false;
	}
	public void insert(Integer x, TreeNode n) {
		if (this.isEmpty()) {
			this.root = new TreeNode(new Integer(x));
			return;
		} else {
			TreeNode temp = n;
			if (x < temp.getValue()) {
				if (temp.getLeft() == null) {
					temp.setLeft(new TreeNode(x));
				} else {
					insert(x, n.getLeft());
				}
			} else {
				if (temp.getRight() == null) {
					temp.setRight(new TreeNode(x));
				} else {
					insert(x, n.getRight());
				}
			}
		}
	}
	public int find(Integer x) {
		
		return 0;
	}
	/*public void printTree() {
		if (this.isEmpty()) {
			System.out.println("There is nothing in this tree!");
			return;
		} else {
			TreeNode temp = n;
			if (x < temp.getValue()) {
				if (temp.getLeft() == null) {
					temp.setLeft(new TreeNode(x));
				} else {
					insert(x, n.getLeft());
				}
			} else {
				if (temp.getRight() == null) {
					temp.setRight(new TreeNode(x));
				} else {
					insert(x, n.getRight());
				}
			}
		}
	}*/

}
