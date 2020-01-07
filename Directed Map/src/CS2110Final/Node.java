package CS2110Final;

public class Node<T> {

	public Node<T> next, previous;
	public T data;
	
	//initialize 'Node' instance
	public Node(T data) {
		this.next = null;
		this.previous = null;
		this.data = data;
	}
	public Node() {
		this.next = null;
		this.previous = null;
		this.data = null;
	}
	
	//getter & setter methods
	public Node<T> getNext() { return this.next; }
	public Node<T> getPrevious() { return this.previous; }
	public T getData() { return this.data; }
	public void setNext(Node<T> n) { this.next = n; }
	public void setPrevious(Node<T> n) { this.previous = n; }
	public void setPerson(T p) { this.data = p; }
	public boolean hasNext() {return (this.next != null);}
}
