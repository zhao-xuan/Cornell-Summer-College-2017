package Homework03Q1;

public class LinkedList {

	public Node header, back;
	public int length;
	
	public void join(Object d) {
		if (isEmpty()) { 
			header.setNext(new Node(d));;
			back = header.getNext();
		} else {
			back.setNext(new Node(d));
			back = back.getNext();
		}
		this.length++;
	}
	public double leave(double a) {
		if (!isEmpty()) {
			Node temp = findPrevious(a);
			temp.setNext(temp.getNext().getNext());
			return (double) temp.getData();
		} else {
			System.out.println("Sorry, the list is empty.");
			return Double.NaN;
		}
	}
	public void insert(double d, double after) {
		Node tempAfter = find(after);
		Node temp = new Node(d);
		temp.setNext(tempAfter.getNext());
		tempAfter.setNext(temp);
		this.length++;
	}
	public Node find(double a) {
		Node temp = this.header.getNext();
		while (!(temp == null)) {
			if ((double)temp.getData() == a) {
				return temp;
			}
			temp = temp.getNext();
		}
		return new Node();
	}
	public Node findPrevious(double a) {
		Node temp = this.header.getNext();
		while (!(temp == null)) {
			if ((double)temp.getNext().getData() == a) {
				return temp;
			}
			temp = temp.getNext();
		}
		
		return new Node();
	}
	public LinkedList() {
		this.length = 0;
		this.header = new Node();
	}
	public boolean isEmpty() {
		return (this.length == 0);
	}
	public boolean isFull() {
		return false;
	}
	public void printList() {
		Node temp = this.header.getNext();
		while (!(temp == null)) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
}