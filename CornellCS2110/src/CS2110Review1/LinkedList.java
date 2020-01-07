package CS2110Review1;

public class LinkedList {

	Node header, back;
	int length;
	
	//Linked list: two domains, data and pointer. One pointer for previous and the other for the next.
	public LinkedList() {
		this.header = this.back = new Node();
		this.length = 0;
	}
	public LinkedList(Object p) {
		this.header = this.back = new Node(p);
		this.length = 1;
	}
	
	public void push(Object p) {
		if (isEmpty()) {
			back = new Node(p);
			header = back;
			//header.setPrevious(back);
		} else {
			Node tempHeader = this.header;
			header.setNext(new Node(p));
			header = header.getNext();
			header.setPrevious(tempHeader);
		}
		this.length++;
	}
	public Object pop() {
		Object data = this.header;
		this.header = this.header.getPrevious();
		this.header.setNext(null);;
		
		return data;
	}
	public void insert(Object c, Object after) {
		Node temp = find(after);
		if (temp == null) {
			System.out.println("Sorry, did not find the object!");
			return;
		} else {
			Node temp2 = temp.getNext();
			Node newNode = new Node(c);
			temp.setNext(newNode);
			newNode.setNext(temp2);
			newNode.setPrevious(temp);
			temp2.setPrevious(newNode);
		}
	}
	public Node find(Object f) {
		Node tempNode = this.back;
		while (!(tempNode == null)) {
			if (tempNode.getData().equals(f)) {
				return tempNode;
			}
			tempNode = tempNode.getNext();
		}
		
		return null;
	}
	public boolean isEmpty() {
		return (this.length == 0);
	}
	public void printList() {
		Node tempNode = this.back;
		while (!(tempNode == null)) {
			System.out.print(tempNode.getData() + " ");
			tempNode = tempNode.getNext();
		}
		System.out.println();
	}
}