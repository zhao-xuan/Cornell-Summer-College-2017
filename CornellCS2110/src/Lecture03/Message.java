package Lecture03;

public class Message {
	private static int num_made = 0;
	private int msg_index = 0;

	private String content = "";
	private String date = "";
	public int id;
	private People sender;
	private People receiver;
	
	public Message(People sender, People receiver, String content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.id = num_made++;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void send() {
		sender.add_sent_id(this.id);
		receiver.add_receive_id(this.id);
	}
}