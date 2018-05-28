package com.teachweb.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Check {

	ArrayList<Object> check = new ArrayList<Object>();
	int answer = 1;
	int RPN = 1;

	public boolean checkAnswer(Num result) {
		if ((result.getNumerator() * result.getDenomenator()) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkRPN(String list) {
		if (check.size() == 0) {
			check.add(list);
			return true;
		} else {
			for (int i = 0; i < check.size(); i++) {
				if (check.get(i).equals(list)) {
					return false;
				}
			}
		}
		check.add(list);
		return true;
	}

}
