package CS2110Review1;

public class Queue {

	public Node back, front;
	public int length;
	//Queue: first-in-first-out, programmed with linked list
	public Queue() {
		this.back = this.front = new Node();
		this.length = 0;
	}
	public Queue(Object obj) {
		this.back = this.front = new Node(obj);
		this.length = 1;
	}
 
	public void isEmpty() {
		
	}

}
