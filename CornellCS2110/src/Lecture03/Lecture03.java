package Lecture03;

import java.io.*;
import java.time.*;

public class Lecture03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		People John = new People("John Lucke");
		People Tom = new People("Tom Zhao");
		
		
		
		Message_Store msg_store = new Message_Store();
		Message m1 = new Message(John, Tom, "Hi! Are you there?");
		Message m2 = new Message(Tom, John, "Yes! I am. Long time no see!");
		Message m3 = new Message(Tom, John, "Haha, how are you?");
		msg_store.storage_msg[0] = m1;
		msg_store.storage_msg[1] = m2;
		msg_store.storage_msg[2] = m3;
		
		m1.send();
		m2.send();
		m3.send();
		
		String john_received[] = Tom.getReceivedMsg(msg_store);
		for ( String i : john_received) {
			if (i != null)
				System.out.println(i);
		}
	}
}
