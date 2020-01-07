package Lecture06;

import java.math.BigInteger;
import java.util.*;

public class Lecture06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger ans = new BigInteger(Integer.toString(1));
		ans = new BigInteger(Integer.toString(50));
		System.out.println(factorial(ans));
	}
	public static BigInteger factorial(BigInteger x) {
		if (x.equals(BigInteger.ONE)) { return BigInteger.ONE; }
		else { return x.multiply(factorial(x.subtract(BigInteger.ONE))); }
	}
}