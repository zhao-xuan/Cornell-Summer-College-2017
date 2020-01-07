package Lecture04;

public class Q1 implements Queue {
	final public int DEFAULT_SIZE = 200;
	public int length, back, front;
	public double[] q;
	
	public Q1(int l) {
		q = new double[l];
		this.length = 0;
		this.back = -1;
		this.front = this.q.length - 1;
	}
	public Q1() {
		q = new double[DEFAULT_SIZE];
	}
	
	public boolean isFull() { return (this.length >= this.q.length); }
	public boolean isEmpty() { return (this.length == 0); }
	
	public void join(double element) {
		if (isFull()) {
			System.out.println("Sorry, the queue is full.");
			return;
		}
		
		this.q[front % (this.q.length)] = element;
		front++;
		this.length++;
	}
	public double leave() {
		if (isEmpty()) {
			System.out.println("Sorry, the queue is empty!");
			return (int)Double.NaN;
		}
		double temp = this.q[back++];
		this.length--;
		return temp;
	}
	public int length() {
		return (int)this.length;
	}
	public void printQueue() {
		for (int i = this.back; i < this.front; i++) {
			System.out.print(this.q[i % this.q.length]+" ");
		}
		System.out.println();
	}
}