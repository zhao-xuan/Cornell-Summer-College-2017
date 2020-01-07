package Homework02;

public class Email {
	private Date date;
	private Account sender;
	private Account receiver;
	private String subject;
	private String content;
	
	public Email() {
		
	}
	//init of 'Email' object
	public Email(String subject, String content, Account sender, Account receiver, Date date) {
		this.content = content;
		this.sender = sender;
		this.receiver = receiver;
		this.date = date;
		this.subject = subject;
	}
	
	public String getSubject() { return this.subject; }
	public String getContent() { return this.content; }
	public Date getDate() { return this.date; }
	public Account getSender() { return this.sender; }
	public Account getReceiver() { return this.receiver; }
	
	public void printEmail() {
		System.out.println("------------------------------");
		System.out.print("Date: "); this.date.printDateTime();
		System.out.println("Send by: " + this.sender.getUsername());
		System.out.println("Received by: "+this.receiver.getUsername());
		System.out.println("Subject: "+this.subject);
		System.out.println("Content: " + '\n' + this.content);
		System.out.println("------------------------------");
	}
}