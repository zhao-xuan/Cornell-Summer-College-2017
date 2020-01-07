package Lecture05;

public class Lecture05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack1 = new Stack(5);
		LinkedList list1 = new LinkedList();
		for (int i = 0; i < 5; i++)
			stack1.join(i);
		stack1.printStack();
		stack1.leave();
		stack1.leave();
		stack1.printStack();
		stack1.join(3.5);
		stack1.printStack();
		
		//System.out.println(list1.front.getNext().getData());
	}
}