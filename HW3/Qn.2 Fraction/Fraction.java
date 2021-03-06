/*
 * Filename: Fraction.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 3 Question 2 
 * Deadline: 06/12/2012
 * Description: Do arithmetic with fractions
 * 
 */
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Fraction {
	int numerator;
	int denominator;
	Fraction() {	
		this.numerator = 1;
		this.denominator = 1;
	}

	Fraction(int n, int d) {
		//set numerator and denominator to minimum fraction
		int divisor = calGcd(n, d);
		this.numerator = n/divisor;
		this.denominator = d/divisor;
	}

	//change sign of negative integers and calculate gcd
	int calGcd(int a, int b){
		//Always use positive integer to calculate gcd
		return gcd(Math.abs(a), Math.abs(b));
	}
	
	//calculate greatest common divisor:
	int gcd(int a, int b) { 
		return b == 0? a: gcd(b, a % b);
	}
    
	//return string representative of fraction
	public String toString() {	    
		return this.numerator +"/" + this.denominator;
	}

	//return string of decimal value of the fraction
	String toDecimal() {
		float result = (float)this.numerator/(float)this.denominator;
		NumberFormat formatter = new DecimalFormat("#.########");
		return formatter.format(result) ;   
		
	}

	//add fraction f to itself and return the new fraction object
	Fraction add(Fraction f) {
		int newNumerator = (this.numerator * f.denominator) + (this.denominator * f.numerator);
		int newDenominator = this.denominator * f.denominator;
		return new Fraction(newNumerator, newDenominator);
		
	}


}
