package composite;

import java.util.ArrayList;

public class CopyCompMain {

	CopyCompMain() {
		Calculator calculator = new Calculator();

		calculator.setExpression(new NumberExpression("3"));
		System.out.println(calculator.getstr());

		AbstractOperationExpression addOperationExpression = new AddOperationExpression();
		addOperationExpression.addOperandExpression(new NumberExpression("2"));
		addOperationExpression.addOperandExpression(new NumberExpression("5"));
		calculator.setExpression(addOperationExpression);
		System.out.println(calculator.getstr());
		
		AbstractOperationExpression subOperationExpression = new SubstractOperationExpression();
		subOperationExpression.addOperandExpression(new NumberExpression("13"));
		subOperationExpression.addOperandExpression(new NumberExpression("2"));
		AbstractOperationExpression addOpEx = new AddOperationExpression();
		addOpEx.addOperandExpression(new NumberExpression("5"));
		addOpEx.addOperandExpression(new NumberExpression("4"));
		
		AbstractOperationExpression mulOpEx = new MultiplyOperationExpression();
		mulOpEx.addOperandExpression(new BracketExpression(subOperationExpression));
		mulOpEx.addOperandExpression(new BracketExpression(addOpEx));
		
		AbstractOperationExpression divOpEx = new DivideOperationExpression();
		divOpEx.addOperandExpression(new BracketExpression(mulOpEx));
		divOpEx.addOperandExpression(new NumberExpression("2"));
		calculator.setExpression(divOpEx);
		System.out.println(calculator.getstr());
	}

	public static void main(String[] args) {
		new CopyCompMain();
	}

}

abstract class AbstractExpression {
	String str;
	abstract String str();
}

abstract class AbstractOperationExpression extends AbstractExpression {

	protected ArrayList<AbstractExpression> operandList = new ArrayList<AbstractExpression>();

	final void addOperandExpression(AbstractExpression operandExpression) {
		operandList.add(operandExpression);	
	}
}

class NumberExpression extends AbstractExpression {

	public NumberExpression(String str) {
		this.str = str;
	}

	String str() {
		return str;
	}
}

class BracketExpression extends AbstractExpression{
	public BracketExpression(AbstractOperationExpression ex) {
		this.str = "(" + ex.str() + ")";
	}
	String str() {
		return this.str;
	}
}

class AddOperationExpression extends AbstractOperationExpression {

	String str() {
		this.str = operandList.get(0).str() + "+" + operandList.get(1).str();
		return this.str;
	}

}

class SubstractOperationExpression extends AbstractOperationExpression {

	String str() {
		this.str = operandList.get(0).str() + "-" + operandList.get(1).str();
		return this.str;
	}

}

class MultiplyOperationExpression extends AbstractOperationExpression {

	String str() {
		this.str = operandList.get(0).str() + "*" + operandList.get(1).str();
		return this.str;
	}

}

class DivideOperationExpression extends AbstractOperationExpression {

	String str() {
		this.str = operandList.get(0).str() + "/" + operandList.get(1).str();
		return this.str; 
	}

}

class Calculator {

	private AbstractExpression expression;

	public Calculator() {
		super();
	}

	String getstr() {
		return expression.str();
	}

	void setExpression(AbstractExpression expression) {
		this.expression = expression;
	}
}
