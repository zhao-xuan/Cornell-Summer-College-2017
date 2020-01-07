package Homework02;

public class Account extends SearchEngine {
	
	private Person person;
	private String username;
	private String accountId;
	private String password;
	private Email[] received_em = new Email[1000]; //Storage for received Emails
	private Email[] sent_em = new Email[1000]; //Storage for sent Emails
	private boolean alert; //Alert user if there is any new Emails
	
	public Account() {
		
	}
	//init of 'Account' object
	public Account(Person person, String username, String password) {
		this.person = person;
		this.username = username;
		this.password = password;
		this.accountId = this.person.getId();
		this.alert = false;
	}
	
	public Person getPerson() { return this.person; }
	public String getUsername() { return this.username; }
	public String getAccountId() { return this.accountId; }
	public Email[] getReceivedEmail() { return this.received_em; }
	public Email[] getSentEmail() { return this.sent_em; }
	
	public boolean authenticate(String password) {
		System.out.println("-----Please enter your password:");
		if (password.equals(this.password)) {
			System.out.println("You successfully login!");
			return true;
		} else {
			System.out.println("Your password is incorrect! Please check your password!");
			return false;
		}
	}
	//This function will print out the account information after register
	public void printAccount() {
		System.out.println("Username: "+this.username);
		System.out.println("Account Id: "+this.accountId);
	}
	public void printReceivedEmail() {
		if (this.received_em[0] == null) {
			System.out.println("-----There is no Email in your inbox.-----");
		} else {
			for (int i = 0; i < this.received_em.length && this.received_em[i] != null; i++) {
				this.received_em[i].printEmail();
			}
		}
	}
	public void printSentEmail() {
		if (this.sent_em[0] == null) {
			System.out.println("-----There is no Email in your Sent box.-----");
		} else {
			for (int i = 0; i < this.sent_em.length && this.sent_em[i] != null; i++) {
				this.sent_em[i].printEmail();
			}
		}
	}
	public void sendEmail(Email email, Account receiver) {
		for (int i = 0; i < this.sent_em.length; i++) {
			if (this.sent_em[i] == null) {
				this.sent_em[i] = email;
				break;
			}
		}
		for (int j = 0; j < receiver.received_em.length; j++) {
			if (receiver.received_em[j] == null) {
				receiver.received_em[j] = email;
				receiver.alert = true;
				break;
			}
		}
	}
	public void alertAccount() {
		if (this.alert == true)
			System.out.println("-----You have new messages! Check it out!!!!!-----");
			alert = false;
	}
}
