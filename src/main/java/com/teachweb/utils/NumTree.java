package com.teachweb.utils;

import java.util.ArrayList;
import java.util.Stack;

public class NumTree {

	private Object data;
	private Num value;
	private NumTree left;
	private NumTree right;

	public NumTree(Object data, Num value, NumTree left, NumTree right) {
		this.data = data;
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public NumTree() {}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Num getValue() {
		return value;
	}

	public void setValue(Num value) {
		this.value = value;
	}

	public NumTree getLeft() {
		return left;
	}

	public void setLeft(NumTree left) {
		this.left = left;
	}

	public NumTree getRight() {
		return right;
	}

	public void setRight(NumTree right) {
		this.right = right;
	}

	public NumTree createTree(ArrayList<Object> rpn) {
		Stack<Object> stack = new Stack<Object>();
		NumTree t = null;
		Object ob;
		for (int i = 0; i < rpn.size(); i++) {
			t = new NumTree();
			ob = rpn.get(i);
			if (Expression.isOperator(ob.toString())) {
				NumTree t2 = (NumTree) stack.pop();
				NumTree t1 = (NumTree) stack.pop();
					if (NumTree.max(t1, t2)) {
						t.setData(ob.toString());
						t.setLeft(t1);
						t.setRight(t2);
						t.setValue(Num.count(t1.getValue(), t2.getValue(), ob.toString()));
						if (t1.getValue().getDenomenator() == 0) {
							return new NumTree("0", t.getValue(),null, null );
						}
					} else {
						t.setData(ob.toString());
						t.setLeft(t2);
						t.setRight(t1);
						t.setValue(Num.count(t1.getValue(), t2.getValue(),ob.toString()));
						if (t.getValue().getDenomenator() == 0) {
							return new NumTree("0", t.getValue(), null, null);
						}
					}
					stack.push(t);
				
			} else {
				t.setData(ob.toString());
				t.setValue((Num) ob);
				stack.push(t);
			}
		}
		return t;
	}

	public static boolean max(NumTree t1, NumTree t2) {
		int n = Num.max(t1.getValue(), t2.getValue());
		if (n == 1)
			return true;
		else if (n == -1)
			return false;
		else if (Expression.priority(t1.getData().toString(), t2.getData().toString())) {
			if (t2.getLeft() == null || t1.getLeft() == null) {
				return true;
			}
			n = Num.max(t1.getLeft().getValue(), t2.getLeft().getValue());
			if (n == 1) {
				return true;
			} else if (n == -1) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	public String toString(NumTree tree) {
		String s = "";
		s = outPutTree(tree, s);
		return s;
	}
	
	public String outPutTree(NumTree tree, String s) {
		if (tree != null) {
			String s1 = outPutTree(tree.getLeft(), s);
			String s2 = outPutTree(tree.getRight(), s);
			return s1 + s2 + tree.getData();
		}
		return s;
	}
}
