package com.teachweb.utils;

import java.util.Random;

public class Num {

	private int numerator;
	private int denomenator;

	public Num() {

	}

	public Num(int a, int b) {
		this.numerator = a;
		this.denomenator = b;
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenomenator() {
		return denomenator;
	}

	public void setDenomenator(int denomenator) {
		this.denomenator = denomenator;
	}

	public int getGCD(int a, int b) {
		if (b == 0) {
			return a;
		}
		return getGCD(b, a % b);
	}

	public Num reduction(Num a) {
		int gcd = this.getGCD(a.getNumerator(), a.getDenomenator());
		if (gcd == 1) {
			return a;
		} else {
			a.setNumerator(a.getNumerator() / gcd);
			a.setDenomenator(a.getDenomenator() / gcd);
			return a;
		}
	}

	public void randomNum(int edge) {
		Random r = new Random();
		this.numerator = r.nextInt(edge) + 1;
		this.denomenator = 1;
	}

	public static Num count(Num n1, Num n2, String o) {
		Num n = new Num();
		int a = n1.getNumerator();
		int b = n1.getDenomenator();
		int c = n2.getNumerator();
		int d = n2.getDenomenator();
		switch(o){
		case "+":
			if (b==d) {
				n.setNumerator(a+c);
				n.setDenomenator(d);
			}
			else{
				n.setNumerator(a*d+b*c);
				n.setDenomenator(c*d);
			}
			break;
		case "-":
			if (b==d) {
				n.setNumerator(a-c);
				n.setDenomenator(d);
			}
			else{
				n.setNumerator(a*d-b*c);
				n.setDenomenator(c*d);
			}
			break;
		case "*":
			n.setNumerator(a*c);
			n.setDenomenator(b*d);
			break;
		case "/":
			if (c == 0) {
				n = new Num(0, 0);
				break;
			}
			n.setNumerator(a*d);
			n.setDenomenator(b*c);
			n = n.reduction(n);
			break;
		}
		return n;
	}
	
	public static int max(Num n1,Num n2){
		int a = n1.getNumerator();
		int b = n1.getDenomenator();
		int c = n2.getNumerator();
		int d = n2.getDenomenator();
		if(a*c>b*d){
			return 1;
		}
		else if(a*c==b*d){
			return 0;
		}
		else{
			return -1;
		}
	}

	public String toString() {
		if (this.denomenator == 1) {
			return String.valueOf(this.numerator);
		} else if (this.numerator > this.denomenator) {
			if (this.numerator % this.denomenator == 0) {
				return String.valueOf(this.numerator / this.denomenator);
			} else {
				return this.numerator / this.denomenator + "'" + this.numerator % this.denomenator + "/"
						+ this.denomenator;
			}
		} else if (this.numerator < this.denomenator) {
			return this.numerator + "/" + this.denomenator;
		} else if (this.numerator == 0) {
			return "0";
		}
		return "1";
	}

}
