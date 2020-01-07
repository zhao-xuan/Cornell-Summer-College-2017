package Lecture05;

public class Stack {

	final static int DEFAULT_LENGTH = 20;
	public double[] stack;
	public int length;
	public int pointer;
	
	public Stack() {
		this.length = DEFAULT_LENGTH;
		this.stack = new double[this.length];
		this.pointer = 0;
	}
	public Stack(int l) {
		this.length = l;
		this.stack = new double[l];
		this.pointer = 0;
	}
	
	public boolean isFull() {
		return (this.pointer >= this.length);
	}
	public boolean isEmpty() {
		return (this.pointer == 0);
	}
	public void join(double element) {
		if (isFull()) {
			System.out.println("Sorry, the stack is full.");
			return;
		}
		stack[this.pointer++] = element;
	}
	public double leave() {
		if (isEmpty()) {
			System.out.println("Sorry, the stack is empty.");
		}
		double temp = stack[this.pointer-1];
		stack[--this.pointer] = Double.NaN;
		return temp;
	}
	
	public void printStack() {
		for (double i : this.stack) {
			System.out.print(i + " ");
		}
		System.out.println();
	}	
}