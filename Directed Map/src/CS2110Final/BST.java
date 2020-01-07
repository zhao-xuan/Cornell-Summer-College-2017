package CS2110Final;
public class BST<T> {

	public BSTNode<T> root;
	
	public BST(BSTNode<T> node) {
		this.root = node;
	}
	
	public void addNode(T data) {
		BSTNode<T> new_node = new BSTNode<T>(data);
		BSTNode<T> temp = this.root;
		while (temp != null) {
			if (Integer.parseInt(temp.getData().toString()) > Integer.parseInt(new_node.getData().toString())) {
				if (temp.getLeft() == null) {
					temp.setLeft(new_node);
					return;
				}
				temp = temp.getLeft();
			} else {
				
				if (temp.getRight() == null) {
					temp.setRight(new_node);
					return;
				}
				temp = temp.getRight();
			}
		}
	}
	
	public BSTNode<T> deleteNode(T data) {
		BSTNode<T> del_node = new BSTNode<T>(data);
		BSTNode<T> temp = this.root;
		while (temp != null && !temp.getData().equals(del_node)) {
			if (temp.getData().toString().compareTo(del_node.getData().toString()) > 0) {
				temp = temp.getLeft();
			} else {
				temp = temp.getRight();
			}
		}
		
		if (!(temp.hasLeft() || temp.hasRight())) {
			if (temp.equals(temp.getParent().getLeft())) {
				temp.getParent().setLeft(null);
			} else {
				temp.getParent().setRight(null);
			}
		} else if (temp.hasLeft() && !temp.hasRight()) {
			temp.getParent().setLeft(temp.getLeft());
			temp.getLeft().setParent(temp.getParent());
		} else if (temp.hasRight() && !temp.hasLeft()) {
			temp.getParent().setRight(temp.getRight());
			temp.getRight().setParent(temp.getParent());
		} else {
			temp.getParent().setLeft(temp.getLeft());
			temp.getParent().setRight(temp.getRight());
			temp.getLeft().setParent(temp.getParent());
			temp.getRight().setParent(temp.getParent());
			temp.setLeft(null);
			temp.setRight(null);
			temp.setParent(null);
		}
		
		return temp;
	}

	public void printBST(BSTNode<T> t) {
		if (t != null) {
		    printBST(t.getLeft());  
		    System.out.println(t.getData());
		    printBST(t.getRight());  
		}  
	}
}
