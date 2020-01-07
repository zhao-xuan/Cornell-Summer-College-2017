package Homework02;

import java.io.*;

public class Homework03 {
	
	//The maximum capacity of people
	public static final int MAX_PEOPLE_CAPACITY = 100;
	//The maximum capacity of accounts
	public static final int MAX_ACCOUNT_CAPACITY = 500;
	
	public static void main(String[] args) throws IOException{
		
		//'grab' is the common BufferReader for reading the lines in most parts of this program
		InputStreamReader nab = new InputStreamReader(System.in);
		BufferedReader grab = new BufferedReader(nab);
		//'people' is the storage of all 'Person' and 'accounts' is the storage of all 'Account'
		Person people[] = new Person[MAX_PEOPLE_CAPACITY];
		Account accounts[] = new Account[MAX_ACCOUNT_CAPACITY];
		//'status' will indicate which step does user choose. It is supposed to be numbers
		String status = "0";
		//'flag' indicates whether the input is legal in the initial login interface.
		boolean flag = false;
		//'currentAccount' will hold the account which is currently signed in
		Account currentAccount = new Account();
		
		//The setting of pre-existing accounts
		people[0] = new Person("Peter", "Zhang", new Date(7, 12, 1997));
		people[1] = new Person("John", "Liu", new Date(8, 9, 1998));
		people[2] = new Person("David", "Wan", new Date(11, 21, 1997));
		accounts[0] = new Account(people[0], "peter0712", "19970712");
		accounts[1] = new Account(people[1], "john1998", "john1998");
		accounts[2] = new Account(people[2], "david_97", "1997wan");
		accounts[2].printAccount();
		
		//The 'logoutAction()' would prompt information and give response when no account is signed in.
		logoutAction(flag, status, accounts, people, grab, currentAccount);
	}
	
	
	public static void logoutAction(boolean flag, String status, Account[] accounts, Person[] people, BufferedReader grab, Account currentAccount) throws IOException {
		/*
		 * Precondition: 'flag' is false and currentAccount should be 'null'
		 * 				 The input of 'status' should be '1', '2' or '3'
		 */
		System.out.println("--------Welcome to our Email System!--------");
		System.out.println("Please enter the number to choose what you want to do from the following list:");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Exit");
		System.out.println("--------------------------------------------");
		while (!flag) {
			status = grab.readLine();
			try {
				switch (Integer.parseInt(status)) {
				case 1:
					optionLogin(flag, people, accounts, grab, currentAccount);
					flag = true;
					break;
				case 2:
					optionRegister(flag, status, currentAccount, people, accounts, grab);
					flag = true;
					break;
				case 3:
					System.out.println("-----You choose to exit! See you next time!-----");
					flag = true;
					break;
				default: failedAttemptResponse1(flag); break;
				}
			} catch (NumberFormatException e) {
				failedAttemptResponse1(flag);
			}
		}
		/*
		 * Postcondition: The program enters either login operation or register operation, or simply quits.
		 * 				  When the input is invalid, it will prompt user to input again.
		 */
	}
	public static void loginAction() {
		/*
		 * Precondition: (no precondition)
		 */
		System.out.println("-----Please choose what you want to do from the following list:");
		System.out.println("1. Send Email");
		System.out.println("2. Check Inbox");
		System.out.println("3. Check Sentbox");
		System.out.println("4. Seacrh Email");
		System.out.println("5. Log out");
		System.out.println("6. Exit");
		/*
		 * postcondition: The program will provide the information once the user logs in
		 */
	}
	public static void optionLogin(boolean flag, Person[] people, Account[] accounts, BufferedReader grab, Account currentAccount) throws IOException {
		/*precondition: flag is false, the 'temp' should be a valid existing username in the system
		 * 				The input of password should match the password of the account in the system
		 * 				After signing in, the information will be provided by the function 'loginAction()'
		 * 				When sending email, the input of receiver should be the username of a valid existing user
		 * */
		int tryTime = 0;
		//'t' is the pointer which indicates the index of the current account in the array 'accounts'
		int t = 0;
		System.out.println("-----Please enter your username:");
		String temp = grab.readLine();
		//All the combination of while loop and boolean variables are designed for detection of illegal input
		boolean flag1 = false;
		while (!flag1) {
			for (int i = 0; i < accounts.length && accounts[i] != null; i++) {
				if (accounts[i].getUsername().equals(temp)) {
					flag1 = true;
					t = i;
					break;
				}
			}
			if (!flag1) {
				System.out.println("-----Your input is incorrect! Try to enter a valid username!");
				temp = grab.readLine();
			}
		}
		while (tryTime < 3) {
			System.out.println("-----Please enter your password");
			if (accounts[t].authenticate(grab.readLine())) {
				currentAccount = accounts[t];
				tryTime = 10;
				currentAccount.alertAccount();
				//'loginAction()' will give the options once the account is logged in
				loginAction();
				boolean flag3 = false;
				while (!flag3 && currentAccount != null) {
					try {
						String status = grab.readLine();
						//This 'switch-case' provides response for the option(1-6) that user chooses to operate
						switch (Integer.parseInt(status)) {
						case 1:
							String[] tempGrab = new String[3];
							Account tempAccount = new Account();
							System.out.println("-----Please enter the username of the receiver");
							tempGrab[0] = grab.readLine();
							boolean found_username = false;
							while (!found_username) {
								for (int i = 0; i < accounts.length && accounts[i] != null; i++) {
									if (accounts[i].getUsername().equals(tempGrab[0])) {
										found_username = true;
										tempAccount = accounts[i];
										break;
									}
								}
								if (!found_username) {
									System.out.println("-----No such user! Please enter a valid username!");
									tempGrab[0] = grab.readLine();
								}
							}
							System.out.println("-----Please enter the subject of your email, or enter nothing for no subject");
							tempGrab[1] = grab.readLine();
							System.out.println("-----Please enter the content of the email and end with a word 'send' in a single line");
							boolean flag4 = false;
							tempGrab[2] = "";
							//This while loop is designed for sending messages with multiple lines
							while (!flag4) {
								String tempText = ""; 
								tempText += grab.readLine();
								if (tempText.equals("send")) {
									flag4 = true;
									break;
								}
								tempGrab[2] += tempText;
								tempGrab[2] += '\n';
							}
							
							Email tempEmail = new Email(tempGrab[1], tempGrab[2], accounts[t], tempAccount, new Date());
							currentAccount.sendEmail(tempEmail, tempAccount);
							System.out.println("-----Your email has been sent!-----");
							loginAction();
							break;
						case 2:
							System.out.println("-----Below is your inbox-----");
							currentAccount.printReceivedEmail();
							loginAction();
							break;
						case 3:
							System.out.println("-----Below is your sent box-----");
							currentAccount.printSentEmail();
							loginAction();
							break;
						case 4:
							searchEngine(grab, currentAccount);
							break;
						case 5:
							System.out.println("-----You have logged out!-----");
							logoutAction(flag, status, accounts, people, grab, currentAccount);
							currentAccount = null;
							break;
						case 6:
							System.out.println("-----System has been terminated! See you next time!-----");
							tryTime = 999;
							flag3 = true;
							break;
						default: break;
						}
					} catch (NumberFormatException i) {
						failedAttemptResponse3(flag3);
					}
				}
			} else {
				//'tryTime' will limit the chance of inputing incorrect password to 2 times.
				System.out.println("-----Wrong password! You have "+(3-tryTime-1)+" times to try!");
				tryTime++;
			}
			if (tryTime == 3) {
				//The consequence of putting wrong password.....
				System.out.println("-----Your chances are used up. System automatically exits.-----");
			}
		}
		/*
		 * postcondition: Correct information could be provided when user choose different actions
		 * 				  Prompt could be made if the input is invalid
		 * 				  Users would only have 2 chances to input password when the input is incorrect
		 */
	}
	public static void optionRegister(boolean flag, String status, Account currentAccount, Person[] people, Account accounts[], BufferedReader grab) throws IOException {
		/*
		 * There are few requirements when you register:
		 * 1. Your name has to be in the form of 'firstname + lastname', or it will be illegal
		 * 2. You date has to be in the form of 'mm/dd/yy', or it will be illegal!
		 */
		boolean tryTime2 = false;
		int a = 0;
		while (!tryTime2) {
			tryTime2 = true;
			System.out.println("-----Welcome to be one of our members!-----");
			System.out.println("----Please enter your full name:");
			for (a = 0; a < MAX_PEOPLE_CAPACITY; a++) {
				if (people[a] == null) {
					String tempName = grab.readLine();
					boolean flag2 = false;
					while (!flag2) {
						if (tempName.indexOf(' ') == -1) {
							failedAttemptResponse2(flag2);
							tempName = grab.readLine();
						} else {
							flag2 = true;
						}
					}
					String tempFirstName = tempName.substring(0, tempName.indexOf(' '));
					String tempLastName = tempName.substring(tempName.indexOf(' '));
					System.out.println("-----Please enter your birthday in month/day/year:");
					String tempDate = grab.readLine();
					int m = -1, d = -1, y = -1;
					boolean flag3 = false;
					while (!flag3) {
						if (tempDate.indexOf('/') == -1 || (tempDate.indexOf('/') == tempDate.lastIndexOf('/'))) {
							flag3 = false;
							System.out.println("-----Your input is incorrect! Try to match the right form!");
							tempDate = grab.readLine();
						} else {
							m = Integer.parseInt(tempDate.substring(0, tempDate.indexOf('/')));
							d = Integer.parseInt(tempDate.substring(tempDate.indexOf('/')+1, tempDate.lastIndexOf('/')));
							y = Integer.parseInt(tempDate.substring(tempDate.lastIndexOf('/')+1));
							flag3 = true;
						}
					}
					
					Date tempBirthdate = new Date(m, d, y);
					people[a] = new Person(tempFirstName, tempLastName, tempBirthdate);
					break;
				}
			}
			for (a = 0; a < MAX_ACCOUNT_CAPACITY; a++) {
				if (accounts[a] == null) {
					System.out.println("-----Your personal information has been saved! Please enter your username:");
					String tempUsername = grab.readLine();
					System.out.println("-----Please enter your password:");
					String tempPassword = grab.readLine();
					System.out.println("-----Please enter your password again:");
					String tempPassword2 = grab.readLine();
					boolean tempFlag = (!tempPassword.equals(tempPassword2)) ? false : true;
					while (!tempFlag) {
						System.out.println("-----Your first input does not match the second one!-----");
						System.out.println("-----Please enter your password:");
						tempPassword = grab.readLine();
						System.out.println("-----Please enter your password again:");
						tempPassword2 = grab.readLine();
						tempFlag = (!tempPassword.equals(tempPassword2)) ? false : true;
					}
					accounts[a] = new Account(people[a], tempUsername, tempPassword2);
					break;
				}
			}
			System.out.println("-----Your account has been successfully created!-----");
			System.out.println("-----Here is your information:");
			people[a].printPerson();
			accounts[a].printAccount();
			logoutAction(flag, status, accounts, people, grab, currentAccount);
		}
	}
	public static void failedAttemptResponse1(boolean flag) {
		/*
		 * precondition: flag is false and user input is not a number(namely user did not make a correct choice)
		 */
		System.out.println("-----Your input is illegal! Try to choose an option:");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Exit");
		System.out.println("--------------------------------------------");
		flag = true;
		/*
		 * postcondition: the error message will properly prompt out
		 */
	}
	public static void failedAttemptResponse2(boolean flag2) {
		/*
		 * precondition: This function will be called if the input of name is incorrect
		 */
		System.out.println("-----Your input is illegal! Try to add your last name:");
		flag2 = false;
	}
	public static void failedAttemptResponse3(boolean flag3) {
		/*
		 * precondition: The user didn't make a correct choice and 'flag3' is false!
		 */
		System.out.println("-----Your input is illegal! Try to choose an option:");
		System.out.println("1. Send Email");
		System.out.println("2. Check Inbox");
		System.out.println("3. Check Sentbox");
		System.out.println("4. Seacrh Email");
		System.out.println("5. Log out");
		System.out.println("6. Exit");
		flag3 = false;
	}
	public static void searchEngine(BufferedReader grab, Account currentAccount) throws IOException {
		/*
		 * precondition: This function will be invoked if user chooses to '4. Search Email'
		 * 				 grab is functioning and currentAccount matches the account that has been logged in.
		 */
		String option = "";
		System.out.println("-----Please enter the way you want to search. You can only search the emails in your account-----");
		System.out.println("1. By sender");
		System.out.println("2. By Receiver");
		System.out.println("3. By Subject");
		System.out.println("4. By Content");
		System.out.println("5. By Date");
		option = grab.readLine();
		//This switch detects the choice made by user and searches the targeted emails.
		//After searching, the options will be provided for the user
		switch (Integer.parseInt(option)) {
		case 1:
			System.out.println("-----Please enter the name you want to search:");
			Email[] tempEmail2 = currentAccount.getEmailsBySender(grab.readLine(), currentAccount);
			System.out.println("-----Below is your searching result-----");
			if (tempEmail2[0] == null) {System.out.println("-----There is no result!-----");}
			for (int i = 0; i < tempEmail2.length && tempEmail2[i] != null; i++) {
				tempEmail2[i].printEmail();
			}
			loginAction();
			break;
		case 2:
			System.out.println("-----Please enter the name you want to search:");
			Email[] tempEmail3 = currentAccount.getEmailsByReceiver(grab.readLine(), currentAccount);
			System.out.println("-----Below is your searching result-----");
			if (tempEmail3[0] == null) {System.out.println("-----There is no result!-----");}
			for (int i = 0; i < tempEmail3.length && tempEmail3[i] != null; i++) {
				tempEmail3[i].printEmail();
			}
			loginAction();
			break;
		case 3:
			System.out.println("-----Please enter the subject you want to search:");
			Email[] tempEmail4 = currentAccount.getEmailsBySubject(grab.readLine(), currentAccount);
			System.out.println("-----Below is your searching result-----");
			if (tempEmail4[0] == null) {System.out.println("-----There is no result!-----");}
			for (int i = 0; i < tempEmail4.length && tempEmail4[i] != null; i++) {
				tempEmail4[i].printEmail();
			}
			loginAction();
			break;
		case 4:
			System.out.println("-----Please enter the content you want to search:");
			Email[] tempEmail5 = currentAccount.getEmailsByContent(grab.readLine(), currentAccount);
			System.out.println("-----Below is your searching result-----");
			if (tempEmail5[0] == null) {System.out.println("-----There is no result!-----");}
			for (int i = 0; i < tempEmail5.length && tempEmail5[i] != null; i++) {
				tempEmail5[i].printEmail();
			}
			loginAction();
			break;
		case 5:
			System.out.println("-----Please enter the date(mm/dd/yy) you want to search:");
			boolean flag6 = false;
			
			String tempInput = grab.readLine();
			while (!flag6) {
				if (tempInput.indexOf('/') == -1 || (tempInput.indexOf('/') == tempInput.lastIndexOf('/'))) {
					System.out.println("-----Your input is incorrect! Try to enter a valid date!");
					tempInput = grab.readLine();
				} else {
					flag6 = true;
				}
			}
			Date tempDate = new Date(Integer.parseInt(tempInput.substring(0, tempInput.indexOf('/'))), Integer.parseInt(tempInput.substring(tempInput.indexOf('/')+1, tempInput.lastIndexOf('/'))), Integer.parseInt(tempInput.substring(tempInput.lastIndexOf('/')+1)) );
			Email[] tempEmail6 = currentAccount.getEmailsByDate(tempDate, currentAccount);
			System.out.println("-----Below is your searching result-----");
			if (tempEmail6[0] == null) {System.out.println("-----There is no result!-----");}
			for (int i = 0; i < tempEmail6.length && tempEmail6[i] != null; i++) {
				tempEmail6[i].printEmail();
			}
			loginAction();
			break;
		default: break;
		}
	}
}