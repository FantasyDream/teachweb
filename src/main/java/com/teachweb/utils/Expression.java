package com.teachweb.utils;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Expression {

	public ArrayList<Object> createExpression(int operator_no, int edge) {
		ArrayList<Object> expression = new ArrayList<Object>();
		Random r = new Random();
		int backet = 0;
		int backet_no = 0;
		for (int i = 1; i <= operator_no + 1; i++) {
			backet = r.nextInt(3);
			if (backet_no != 0 && backet != 0 && expression.get(expression.size() - 1) != "(") {
				Num num = new Num();
				num.randomNum(edge);
				expression.add(num);
				expression.add(")");
				expression.add(randomOperator());
				backet_no--;
			} 
			else if (i != operator_no + 1) {
				if (backet == 1) {
					expression.add(0, "(");
					++backet_no;
					Num num = new Num();
					num.randomNum(edge);
					expression.add(num);
					expression.add(randomOperator());
				} else if (backet == 2) {
					Num num = new Num();
					expression.add("(");
					++backet_no;
					num.randomNum(edge);
					expression.add(num);
					expression.add(randomOperator());
				} else {
					Num num = new Num();
					num.randomNum(edge);
					expression.add(num);
					expression.add(randomOperator());
				}
			} else {
				Num num = new Num();
				num.randomNum(edge);
				expression.add(num);
				expression.add(randomOperator());
			}
		}
		expression.remove(expression.size() - 1);
		while (backet_no != 0) {
			expression.add(")");
			backet_no--;
		}
		while (expression.get(0) == "(") {
			backet = 0;
			int bracket_leng = 0;
			String o = "";
			for (int j = 0; j < expression.size(); j++) {
				o = expression.get(j).toString();
				if (o == "(") {
					backet++;
					bracket_leng--;
				}
				if (o == ")") {
					backet--;
					bracket_leng--;
				}
				if (backet == 0 && bracket_leng != (2 * operator_no)) {
					return expression;
				}
				if (backet >= 1) {
					bracket_leng++;
				}
			}
			if (bracket_leng == (2 * operator_no)) {
				expression.remove(0);
				expression.remove(expression.size() - 1);
			}
		}
		return expression;
	}

	public ArrayList<Object> toRPN(ArrayList<Object> list) {
		ArrayList<Object> right = new ArrayList<Object>();
		Stack<Object> aStack = new Stack<Object>();
		String operator;
		int position = 0;
		while (true) {
			if (isOperator(list.get(position).toString())) {
				if (aStack.empty() || ((String) list.get(position)).equals("(")) {
					aStack.push(list.get(position));
				} else {
					if (((String) list.get(position)).equals(")")) {
						while (true) {
							if (!aStack.empty() && !((String) aStack.peek()).equals("(")) {
								operator = (String) aStack.pop();
								right.add(operator);
							} else {
								if (!aStack.empty())
									aStack.pop();
								break;
							}
						}
					} else {
						while (true) {
							if (!aStack.empty() && priority((String) list.get(position), (String) aStack.peek())) {
								operator = (String) aStack.pop();
								if (!operator.equals("("))
									right.add(operator);
							} else {
								break;
							}
						}
						aStack.push(list.get(position));
					}
				}
			}
			else {
				right.add(list.get(position));
			}
			position++;
			if (position >= list.size())
				break;
		}
		while (!aStack.empty()) {
			operator = (String) aStack.pop();
			if (!operator.equals("("))
				right.add(operator);
		}
		return right;
	}

	public String randomOperator() {
		Random r = new Random();
		String o;
		int a = r.nextInt(4);
		switch (a) {
		case 0:
			o = "+";
			break;
		case 1:
			o = "-";
			break;
		case 2:
			o = "*";
			break;
		case 3:
			o = "÷";
			break;
		default:
			o = "+";
			break;
		}
		return o;
	}

	public static boolean isOperator(String o) {
		if (o.equals("+") || o.equals("-") || o.equals("*") || o.equals("÷") || o.equals("(") || o.equals(")")) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean priority(String operatorout, String operatorin) {
		int m = -1, n = -1;
		String o[] = { "+", "-", "*", "÷", "(", ")" };
		int first[][] = { { 1, 1, 2, 2, 2, 0 }, { 1, 1, 2, 2, 2, 0 }, { 1, 1, 1, 1, 2, 0 }, { 1, 1, 1, 1, 2, 0 },
				{ 2, 2, 2, 2, 2, 0 }, { 2, 2, 2, 2, 2, 2 } };
		for (int i = 0; i < 6; i++) {
			if (operatorin.equalsIgnoreCase(o[i]))
				m = i;
			if (operatorout.equalsIgnoreCase(o[i]))
				n = i;
		}
		if (m == -1 && n == -1)
			return false;
		else if (m == -1 && n != -1)
			return false;
		else if (m != -1 && n == -1)
			return true;
		else if (first[m][n] == 1) 
			return true;
		else
			return false;
	}
	
	public static String toString(ArrayList<Object> list) {
		String s1 = "";
		for (int i = 0; i < list.size(); i++) {
			s1 += list.get(i).toString();
		}
		return s1;
	}
}
