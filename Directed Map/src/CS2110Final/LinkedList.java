package CS2110Final;

public class LinkedList<T> {

	public Node<T> head, tail;
	public int length;

	// initialize the 'LinkedList' instance
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}

	public LinkedList(Node<T> firstNode) {
		this.tail = this.head = firstNode;
		this.length = 1;
	}
	
	// add the element at the end of the queue
	public void join(T data) {
		Node<T> n=new Node<T>(data);
		if (isEmpty()) {
			this.tail = this.head = n;
			this.length = 1;
			return;
		}
		Node<T> temp = this.tail;
		this.tail.setNext(n);
		this.tail = this.tail.getNext();
		this.tail.setPrevious(temp);
		this.length++;
	}
	//the first element at the head of the queue will leave he queue
	public T leave() {
		if (isEmpty()) {
			System.out.println("The list is empty!");
			return null;
		}
		Node<T> temp = this.head;
		this.head = this.head.getNext();
		this.tail.setPrevious(null);
		
		return temp.getData();
	}
	
	//an element in the queue will leave
	public T delete(T n) {
		Node<T> temp = this.head;
		while (temp != null) {
			if (temp.getData().equals(n)) {
				temp.getPrevious().setNext(temp.getNext());
				temp.getNext().setPrevious(temp.getPrevious());
				return temp.getData();
			}
			temp = temp.getNext();
		}
		return null;
	}
	
	// print the whole list
	public void printList() {
		Node<T> temp = this.head;
		while (!(temp == null)) {
			T p = temp.getData();
			System.out.println(p);
			temp = temp.getNext();
		}
		System.out.println("-----------");
	}

	// check if the list is empty: return true if empty and return false if not
	public boolean isEmpty() {
		if (this.length == 0) {
			return true;
		}
		return false;
	}
}