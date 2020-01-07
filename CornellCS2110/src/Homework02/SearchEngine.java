package Homework02;

public class SearchEngine {

	//There functions are responsible for returning multiple 'Email' objects according to the searching information
	//All 'temp' arrays are the returning arrays of finding result
	public Email[] getEmailsByReceiver(String username, Account account) {
		int index = 0;
		Email[] temp = new Email[500];
		Email[] all_received_em = account.getReceivedEmail();
		Email[] all_sent_em = account.getSentEmail();
		for (int i = 0; i < account.getReceivedEmail().length && all_received_em[i] != null; i++) {
			if (all_received_em[i].getReceiver().getUsername().contains(username.subSequence(0, username.length()))) {
				temp[index] = all_received_em[i];
				index++;
			}
		}
		for (int j = 0; j < account.getSentEmail().length && all_sent_em[j] != null; j++) {
			if (all_sent_em[j].getReceiver().getUsername().contains(username.subSequence(0, username.length()))) {
				temp[index] = all_sent_em[j];
				index++;
			}
		}
		
		return temp;
	}
	public Email[] getEmailsBySender(String username, Account account) {
		int index = 0;
		Email[] temp = new Email[500];
		Email[] all_received_em = account.getReceivedEmail();
		Email[] all_sent_em = account.getSentEmail();
		for (int i = 0; i < account.getReceivedEmail().length && all_received_em[i] != null; i++) {
			if (all_received_em[i].getSender().getUsername().contains(username.subSequence(0, username.length()))) {
				temp[index] = all_received_em[i];
				index++;
			}
		}
		for (int j = 0; j < account.getSentEmail().length && all_sent_em[j] != null; j++) {
			if (all_sent_em[j].getSender().getUsername().contains(username.subSequence(0, username.length()))) {
				temp[index] = all_sent_em[j];
				index++;
			}
		}
		
		return temp;
	}
	public Email[] getEmailsBySubject(String subject, Account account) {
		int index = 0;
		Email[] temp = new Email[500];
		Email[] all_received_em = account.getReceivedEmail();
		Email[] all_sent_em = account.getSentEmail();
		for (int i = 0; i < account.getReceivedEmail().length && all_received_em[i] != null; i++) {
			if (all_received_em[i].getSubject().contains(subject.subSequence(0, subject.length()))) {
				temp[index] = all_received_em[i];
				index++;
			}
		}
		for (int j = 0; j < account.getSentEmail().length && all_sent_em[j] != null; j++) {
			if (all_sent_em[j].getSubject().contains(subject.subSequence(0, subject.length()))) {
				temp[index] = all_sent_em[j];
				index++;
			}
		}
		
		return temp;
	}
	
	public Email[] getEmailsByContent(String content, Account account) {
		int index = 0;
		Email[] temp = new Email[500];
		Email[] all_received_em = account.getReceivedEmail();
		Email[] all_sent_em = account.getSentEmail();
		for (int i = 0; i < account.getReceivedEmail().length && all_received_em[i] != null; i++) {
			if (all_received_em[i].getContent().contains(content.subSequence(0, content.length()))) {
				temp[index] = all_received_em[i];
				index++;
			}
		}
		for (int j = 0; j < account.getSentEmail().length && all_sent_em[j] != null; j++) {
			if (all_sent_em[j].getContent().contains(content.subSequence(0, content.length()))) {
				temp[index] = all_sent_em[j];
				index++;
			}
		}
		
		return temp;
	}
	public Email[] getEmailsByDate(Date date, Account account) {
		Email[] temp = new Email[500];
		Email[] all_received_em = account.getReceivedEmail();
		Email[] all_sent_em = account.getSentEmail();
		int index = 0;
		for (int i = 0; i < account.getReceivedEmail().length && all_received_em[i] != null; i++) {
			if (all_received_em[i].getDate().isEqualDate(date)) {
				temp[index] = all_received_em[i];
				index++;
			}
		}
		for (int j = 0; j < account.getSentEmail().length && all_sent_em[j] != null; j++) {
			if (all_sent_em[j].getDate().isEqualDate(date)) {
				temp[index] = all_sent_em[j];
				index++;
			}
		}
		return temp;
	}
}