package Homework03Q1;

public class Calculator {
	
	//'infix' and 'reverse' will store the String of the corresponding format.
	public String infix;
	public String reverse;
	public Double result;
	
	//constructor
	public Calculator() {
		//initialize the variables
		infix = "";
		reverse = "";
	}
	//constructor
	public Calculator(String mode, String input) {
		/*
		 * @para 'mode' indicates which format(either infix or polish reverse) the input is
		 * @para 'input' is the actual expression that the user has input
		 */
		if (mode.equals("infix")) {
			//Again, the method 'isValidInput(String)' will only check the validity of infix form
			if (isValidInput(input)) {
				//the method 'trim(String)' can add spaces between parenthesis and number, which will allow the 'split' method to function properly
				this.infix = trim(input);
				//the method 'transform(String, String)' can transform from one format to another.
				this.reverse = transform("reverse", this.infix);
			} else {
				System.out.println("Your input is invalid!");
			}
		} else if (mode.equals("reverse")) {
			//The validation process of polish reverse format is embedded in the method 'calculate()'
			this.reverse = input;
			this.infix = transform("infix", this.reverse);
		}
	}
	
	public void calculate() {
		/*
		 * precondition: the variable 'infix', 'reverse' and 'result' are properly initialized and have legal values
		 * postcondition: if the format is correct, the result will be stored in the variable 'result'
		 * 				  since the format of infix has been checked, there is no need to check it again
		 * 				  however, if the polish reverse format is incorrect, the program will be terminated
		 */
		Stack temp = new Stack(1000);
		int index = 0;
		String tempNum = "";
		String[] tempreverse = this.reverse.split(" ");
		
		for (int i = 0; i < tempreverse.length; i++) {
			//the 'try-catch' sentences below try to detect incorrect format of polish reverse format.
			try {
				tempNum = "";
				tempNum = tempreverse[i];
				//tempNum += Character.toString(this.reverse.charAt(index));
				//index = (this.reverse.length() > index) ? (index+1) : index;
				if (tempNum != "") {
					temp.push(tempNum);
				}
				//temp.printStack();
				//index++;
				//The process of detecting operator
				if (temp.stack[temp.pointer-1] != null && temp.stack[temp.pointer-1].length() == 1 && isOperator(temp.stack[temp.pointer-1].charAt(0))) {
					//the method 'printStack()' can print the stack at the current stage.
					temp.printStack();
					String c1 = temp.stack[temp.pointer-1];
					//System.out.println(c1);
					String c2 = temp.stack[temp.pointer-2];
					//System.out.println(c2);
					String c3 = temp.stack[temp.pointer-3];
					//System.out.println(c3);
					
					temp.pop();
					temp.pop();
					temp.pop();
					temp.push(cal(c2, c3, c1));
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("-----Your format is incorrect! Re-launch the program to find right answer!-----");
				System.out.println("-----The program has been terminated!-----");
				this.result = Double.NaN;
				break;
			} catch (NumberFormatException e) {
				System.out.println("-----Your format is incorrect! Re-launch the program to find right answer!-----");
				System.out.println("-----The program has been terminated!-----");
				this.result = Double.NaN;
				break;
			}
			
		}
		//This 'try-catch' sentence is also responsible for catching the incorrect format of polish reverse format
		try {
			this.result = Double.parseDouble(temp.stack[temp.pointer-1]);
		} catch (NumberFormatException e) {
			
			System.out.println("-----Your format is incorrect! Re-launch the program to find right answer!-----");
			System.out.println("-----The program has been terminated!-----");
			this.result = Double.NaN;
		} catch (ArrayIndexOutOfBoundsException f) {
			System.out.println("-----Your format is incorrect! Re-launch the program to find right answer!-----");
			System.out.println("-----The program has been terminated!-----");
			this.result = Double.NaN;
		}
	}
	public String cal(String num1, String num2, String operator) {
		/*
		 * @para both 'num1' and 'num2' should be convertable to double, namely they have to be numbers
		 * @para 'operator' is the operator that indicates the operation between 'num1' and 'num2'
		 * precondition: the 'num1' and 'num2' have to be legal numbers in String
		 * 				 operator must be one of the legal operator, including the power '^'
		 * postcondition: the correct answer in String for the operation can be returned
		 * 				  if the precondition has not been full filled, it will return an empty string
		 */
		double tempNum1 = Double.parseDouble(num1);
		double tempNum2 = Double.parseDouble(num2);
		//System.out.println(tempNum1 + " " + tempNum2);
		switch (operator) {
		case "+": return Double.toString(tempNum2+tempNum1);
		case "-": return Double.toString(tempNum2-tempNum1);
		case "*": return Double.toString(tempNum2*tempNum1);
		case "/": return Double.toString(tempNum2/tempNum1);
		case "^": return Double.toString(Math.pow(tempNum1, tempNum2));
		default: return "";
		}
	}
	public String transform(String to, String input) {
		/*
		 * @para 'to' is the desired format. The value of 'to' should be either 'infix' or 'reverse'
		 * @para 'input' is the expression in the original format
		 * precondition: the value of 'to' is either 'infix' or 'reverse'
		 * postcondition: the correct expression in the desired format should be returned as a String
		 */
		//from infix to polish reverse format
		if (to.equals("reverse")) {
			Stack opstack = new Stack(1000);
			opstack.pointer = 0;
			LinkedList listOutput = new LinkedList();
			String[] tokenInput = input.split(" ");
			
			//'tokenInput' has been generated by the 'split' method and contains every single element in the expression(numbers, parenthesis and operators)
			for (String i : tokenInput) {
				if (isNumber(i)) {
					listOutput.join(i);
				} else if (i.equals("(")) {
					opstack.push(i);
				} else if (i.equals(")")) {
					while (!opstack.peek().equals("(")) {
						listOutput.join(opstack.pop());
					}
					opstack.pop();
				} else if (isOperator(i.charAt(0))) {
					while (!opstack.isEmpty() && precedence(opstack.peek().charAt(0)) >= precedence(i.charAt(0))) {
						listOutput.join(opstack.pop());
					}
					opstack.push(i);
				}
			}
			while (!opstack.isEmpty()) {
				listOutput.join(opstack.pop());
			}
			
			Node tempNode = listOutput.header.getNext();
			String realOutput = "";
			while (!(tempNode == null)) {
				realOutput += (String.valueOf(tempNode.getData()) + " ");
				tempNode = tempNode.getNext();
			}
			
			return realOutput;
			//from polish reverse format to infix format
		} else if (to.equals("infix")) {
			String[] temp = input.split(" ");
			Stack resultStack = new Stack(1000);
			int index = 0;
			String tempc;
			while (temp.length != 0 && index < temp.length) {
				tempc = temp[index];
				if (isNumber(tempc)) {
					resultStack.push(tempc);
				} else {
					if (resultStack.pointer < 2) {
						
					} else {
						String s1 = resultStack.pop();
						String s2 = resultStack.pop();
						String s = "(" + s2 + " " +  tempc + " " + s1 + ")";
						resultStack.push(s);
					}
				}
				
				index++;
			}
			return resultStack.stack[0];
		}
		
		return "";
	}
	public boolean isOperator(char c) {
		//detect whether 'c' is an operator or not, return true if it is an operator
		String operand = "+-*/^";
		return (operand.indexOf(c) != -1);
	}
	public boolean isNumber(String c) {
		//check if 'c' is a number or not, return true if it is a number
		String numbers = "0123456789.";
		try {
			double tempNum = Double.parseDouble(c);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	public int precedence(char c) {
		//It will return the precedence of the operator
		
		switch (c) {
		case '+': return 1;
		case '-': return 1;
		case '*': return 2;
		case '/': return 2;
		case '^': return 3;
		default: return -1;
		}
	}
	public boolean isValidInput(String s) {
		//This method will validate if s(of infix format) is the the legal format
		String alphabet = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		String marks = "~!@#$%&_{}|:\"<>?";
		int leftparenNum = 0;
		int rightparenNum = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (alphabet.indexOf(s.charAt(i)) != -1 || marks.indexOf(s.charAt(i)) != -1) {
				return false;
			}
			
			if (s.charAt(i) == '(') {
				leftparenNum++;
				if (isOperatorOrParen(s.charAt(i+1))) {
					return false;
				}
				
			} else if (s.charAt(i) == ')') {
				rightparenNum++;
				if (i < s.length() - 2 && (isNumber(Character.toString(s.charAt(i+1)))) ) {
					return false;
				}
				
			}
			if (s.charAt(i) == ' ') {
				if (isNumber(Character.toString(s.charAt(i+1))) && isNumber(Character.toString(s.charAt(i-1)))) {
					return false;
				}
			}
			
		}
		if (leftparenNum != rightparenNum) {
			return false;
		}
		
		return true;
	}
	public String trim(String input) {
		//this method will trim the 'input' into a splitable format(each single element will be separated by a space)
		String s = "";
		for (int i = 0; i < input.length()-1; i++) {
			s += Character.toString(input.charAt(i));
			if (input.charAt(i) == '('  && isNumber(Character.toString(input.charAt(i+1)))) {
				s += " ";
			}
			if (isNumber(Character.toString(input.charAt(i))) && input.charAt(i+1) == ')') {
				s += " ";
			}
			if (isNumber(Character.toString(input.charAt(i))) && isOperator(input.charAt(i+1))) {
				s += " ";
			}
			if (isOperator(input.charAt(i)) && (isNumber(Character.toString(input.charAt(i+1))) || input.charAt(i+1) == '(')) {
				s += " ";
			}
			if (input.charAt(i) == ')' && isOperator(input.charAt(i+1))) {
				s += " ";
			}
		}
		System.out.println(s);
		s += Character.toString(input.charAt(input.length() - 1));
		
		return s;
	}
	public boolean isOperatorOrParen(char c) {
		//additional method for detecting both operator and parenthesis
		String operand = "+-*/^()";
		return (operand.indexOf(c) != -1);
	}
}