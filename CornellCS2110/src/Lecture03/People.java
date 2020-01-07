package Lecture03;

public class People {
	final public static int MAX_STORAGE = 100;
	final public static int START_ID = 0;
	public static int num_made = 0;
	public static int num_msg_made = 0;

	private String name;
	private int id;
	private int[] received_msg;
	private int[] sent_msg;
	private boolean alert = false;
	
	//initiator
	public People() {
		this.name = "";
		this.id = 0;
		this.received_msg = new int[MAX_STORAGE];
		this.sent_msg[0] = 0;
		this.alert = false;
	}
	
	public People(String name) {
		this.name = name;
		this.id = (START_ID + num_made);
		this.received_msg = new int[MAX_STORAGE];
		for (int i = 0; i < this.received_msg.length; i++) { this.received_msg[i] = -1; }
		this.sent_msg = new int[MAX_STORAGE];
		for (int i = 0; i < this.sent_msg.length; i++) { this.sent_msg[i] = -1; }
		
		num_made++;
	}

	public People(String name, int received_msg, int sent_msg) {
		this.name = name;
		this.id = num_made++;
		this.received_msg[0] = received_msg;
		this.sent_msg[0] = sent_msg;
	}
	
	//accessor
	public String getName () { return name; }
	public int getId() { return id; }
	public int getReceivedMsgId() { return received_msg[0]; }
	public int getSentMsgId() { return sent_msg[0]; }
	public boolean getAlert() { return alert; }
	
	//mutator
	public void setName(String name) { this.name = name; }
	public void setId(int id) { this.id = id; }
	public void setReceivedMsgId(int a) { this.received_msg[0] = a; }
	public void setSentMsgId(int a) { this.sent_msg[0] = a; }
	public void setAlert(boolean b) { this.alert = b; }

	//Methods
	public void add_receive_id(int id) {
		this.received_msg[num_msg_made++] = id;
		this.alert = true;
	}
	public void add_sent_id(int id) {
		this.sent_msg[num_msg_made++] = id;
	}
	public String toString() {
		String temp = "Name(id): " + this.name + "(" + this.id + ")";
		System.out.println(temp);
		for (int i = 0; i < this.sent_msg.length; i++)
			if (this.sent_msg[i] != -1) { System.out.println(this.getName() + " has sent message: " + this.sent_msg[i]); }
		for (int i = 0; i < this.received_msg.length; i++)
			if (this.received_msg[i] != -1) { System.out.println(this.getName() + " has received message: " + this.received_msg[i]); }
		
		return "";
	}
	public String[] getReceivedMsg(Message_Store msg_st) {
		String temp[] = new String[this.received_msg.length];
		int index = 0;
		
		for (int i = 0; i < this.received_msg.length; i++) {
			for (int j = 0; j < msg_st.storage_msg.length && msg_st.storage_msg[j] != null; j++) {
				if (msg_st.storage_msg[j].id == this.received_msg[i]) {
					temp[index] = msg_st.storage_msg[j].getContent();
					index++;
				}
			}
		}
		return temp;
	}
}