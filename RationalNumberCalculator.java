/** Program: Rational Calculator 
 *  File:    RationalNumberCalculator.java
 *  Summary: Week6 Exercise 13.16
 *           A simple calculator for performing mathematical calculations with input rational numbers. The program uses the rational class that 
 *           extends the Number class. Users are prompted to enter in an operand, operator, and another operand. The program then displays the original problem with the result
 *  Author: Lee Tompkins 
 *  Date:   July 31 2016
 **/

import java.util.Scanner;

public class RationalNumberCalculator {
	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Rational result = new Rational(); // Rational object for final result 
		// Prompt user for input 
		System.out.println("This is a rational calculator, enter in an operand, an arithmatic operator, and another operand to see the result");
		System.out.print("For Example: 2/4 + 1/4 would display 2/4 + 1/4 = 3/4    ");
		// Store user input 
		String userInput = input.next();
		String userInput1 = input.next();
		String userInput2 = input.next();
		// Split user input into Array 
		String[] operand1String = userInput.split("/");
		String[] operand2String = userInput2.split("/");
		// Declare long arrays
		long[] operand1 = new long[2];
		long[] operand2 = new long[2];
		// Parse String array values to Long and store in long array 
		operand1[0] = Long.parseLong(operand1String[0]);
		operand1[1] = Long.parseLong(operand1String[1]);
		operand2[0] = Long.parseLong(operand2String[0]);
		operand2[1] = Long.parseLong(operand1String[1]);
		// Construct rational Objects from user parsed long values 
		Rational r1 = new Rational(operand1[0], operand1[1]);
		Rational r2 = new Rational(operand2[0], operand2[1]);
		
		// switch for type of operator to choose correct method 
		switch (userInput1.charAt(0)) {
			case '+': {
				result = r1.add(r2);
				break;
			}
			case '-': {
				result = r1.subtract(r2);
				break;
			}
			case 'x': {
				result = r1.multiply(r2);
				break;
			}
			case '*': {
				result = r1.multiply(r2);
				break;
			}
			case '/': {
				result = r1.divide(r2);
			}
			
		}
		// display result 
		System.out.println(userInput + " " + userInput1 + " " + userInput2 + " = " + result.toString());	
		

	}

}
// Listing 7.9 from Chapter 7 
class Rational {
	private long numerator = 0;
	private long denominator = 1; 
	
	public Rational() {
		this.numerator = 1;
		this.denominator = 0;
	}
	
	public Rational(long numerator, long denominator){
		long gcd = gcd(numerator, denominator);
		this.numerator = ((denominator > 0) ? 1 : -1) * numerator / gcd;
		this.denominator = Math.abs(denominator) / gcd;
	}
	private static long gcd(long n, long d) {
		long n1 = Math.abs(n);
		long n2 = Math.abs(d);
		int gcd = 1;
		
		for (int k = 1; k <= n1 && k <= n2; k++) {
			if (n1 % k == 0 && n2 % k == 0)
				gcd = k;
		}
		return gcd;
	}
	
	public long getNumerator(){
		return numerator;
	}
	public long getDenominator(){
		return denominator;
	}
	
	public Rational add(Rational secondRational) {
		 long n = numerator * secondRational.getDenominator() + denominator * secondRational.getNumerator();
		 long d = denominator * secondRational.getDenominator();
		 return new Rational(n, d);
	 }
	
	public Rational subtract(Rational secondRational) {
		long n = numerator * secondRational.getDenominator()
		- denominator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		return new Rational(n, d);
	}
	public Rational multiply(Rational secondRational) {
		long n = numerator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		return new Rational(n, d);
	}
	
	public Rational divide(Rational secondRational) {
		long n = numerator * secondRational.getDenominator();
		long d = denominator * secondRational.numerator;
		return new Rational(n, d);
	}
	
	@Override
	public String toString() {
		if(denominator == 1) {
			return numerator + "";
		} else {
			return numerator + "/" + denominator;
		}
	}
	
	@Override // Override the equals method in the Object class
	public boolean equals(Object other) {
		if ((this.subtract((Rational)(other))).getNumerator() == 0)
				return true;
			else
				return false;
	}
	public int intValue() {
		return (int)doubleValue();
	}
	
	public float floatValue() {
	return (float)doubleValue();
	}
	
	
	public double doubleValue() {
	return numerator * 1.0 / denominator;
	}
	
	
	public long longValue() {
	return (long)doubleValue();
	}
	
	public int compareTo(Rational o) {
	if (this.subtract(o).getNumerator() > 0)
	return 1;
	else if (this.subtract(o).getNumerator() < 0)
	return -1;
	else
	return 0;
	}
}