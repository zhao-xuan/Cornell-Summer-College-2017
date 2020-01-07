package CS2110Review1;

public class Node {

	public Object data;
	public Node previous, next;
	
	//Node for LinkedList: provides 2 domains and getter/setters
	public Node() {
		data = null;
		previous = null;
		next = null;
	}
	public Node(Object data) {
		this.data = data;
		this.next = null;
		this.previous = this.getPrevious();
	}
	
	public Object getData() { return this.data; }
	public Node getNext() { return this.next; }
	public Node getPrevious() { return this.previous; }
	public void setData(Object d) { this.data = d; }
	public void setNext(Node n) { this.next = n; }
	public void setPrevious(Node n) { this.previous = n; }

}
