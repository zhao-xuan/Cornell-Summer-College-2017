package CS2110Review1;

public class Stack {

	final static int DEFAULT_LENGTH = 20;
	public Object[] stack;
	public int length;
	public int pointer;
	
	public Stack() {
		this.length = DEFAULT_LENGTH;
		this.stack = new Object[this.length];
		this.pointer = 0;
	}
	public Stack(int l) {
		this.length = l;
		this.stack = new Object[l];
		this.pointer = 0;
	}
	
	public boolean isFull() {
		return (this.pointer >= this.length);
	}
	public boolean isEmpty() {
		return (this.pointer == 0);
	}
	public void push(Object element) {
		if (isFull()) {
			System.out.println("Sorry, the stack is full.");
			return;
		}
		stack[this.pointer] = element;
		this.pointer++;
	}
	public Object pop() {
		if (isEmpty()) {
			System.out.println("Sorry, the stack is empty.");
			return "";
		}
		Object temp = stack[this.pointer-1];
		stack[this.pointer] = null;
		this.pointer--;
		return temp;
	}
	public Object peek() {
		if (this.pointer == 0) {
			return " ";
		} else {
			return this.stack[this.pointer-1];
		}
	}
	
	public void printStack() {
		System.out.print("Stack: ");
		for (Object i : this.stack) {
			if (i != null) {
				System.out.print(i + " ");
			} else {
				//System.out.print("null" + " ");
			}
		}
		System.out.println();
	}	
}