package composite;

import java.util.ArrayList;

public abstract class Operator extends Expression{
	ArrayList<Expression> list = new ArrayList<Expression>();
	
	Operator(Expression ex1, Expression ex2){
		add(ex1, ex2);
	}
	
	public void add(Expression ex1, Expression ex2) {
		list.add(ex1);
		list.add(ex2);
	}
	
	
}
