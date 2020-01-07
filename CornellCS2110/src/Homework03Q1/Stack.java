package Homework03Q1;

public class Stack {

	/*
	 * the class 'Stack' holds for the data structure stack and have fundamental methods of a basic stack
	 * this stack is based on array. In my program, I defined the size for each stack as 1000
	 * 
	 */

	public String[] stack;
	public int length;
	public int pointer;
	
	
	public Stack(int l) {
		//initialize the stack
		this.length = l;
		this.stack = new String[l];
		this.pointer = 0;
	}
	
	public boolean isFull() {
		//detect if the stack is full or not
		return (this.pointer >= this.length);
	}
	public boolean isEmpty() {
		//detect if the stack is empty or not
		return (this.pointer == 0);
	}
	public void push(String element) {
		//push the element on the top of the stack
		if (isFull()) {
			System.out.println("Sorry, the stack is full.");
			return;
		}
		stack[this.pointer] = element;
		this.pointer++;
		this.length++;
	}
	public String pop() {
		//pop out the first element on the top of the stack
		if (isEmpty()) {
			System.out.println("Sorry, the stack is empty.");
			return "";
		}
		String temp = stack[this.pointer-1];
		stack[this.pointer] = null;
		this.pointer--;
		this.length--;
		return temp;
	}
	public String peek() {
		//return the first element on the top if has any
		if (this.pointer == 0) {
			return " ";
		} else {
			return this.stack[this.pointer-1];
		}
	}
	
	public void printStack() {
		//print the whole stack. print out each single element in the stack
		System.out.print("Stack: ");
		for (String i : this.stack) {
			if (i != null) {
				System.out.print(i + " ");
			} else {
				return;
			}
		}
		System.out.println();
	}	
}