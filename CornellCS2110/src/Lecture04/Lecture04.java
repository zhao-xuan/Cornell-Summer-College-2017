package Lecture04;

public class Lecture04 {

	public static void main(String args[]) {
		Q1 queue = new Q1();
		queue.join(5.0);
		queue.join(6.0);
		queue.join(7.0);
		queue.join(8.0);
		queue.printQueue();
		queue.leave();
		queue.printQueue();
		queue.leave();
		queue.printQueue();
		queue.leave();
		queue.printQueue();
		queue.join(9.0);
		queue.join(10.0);
		queue.join(11.0);
		queue.printQueue();
		for (double i = 1; i <= 18; i++) {
			queue.join(i);
		}
		queue.printQueue();
		System.out.println(queue.length());
		queue.leave();
		queue.leave();
		queue.leave();
		queue.leave();
		queue.leave();
		queue.leave();
		queue.printQueue();
		queue.join(22.0);
		queue.join(23.0);
		queue.printQueue();
	}
}