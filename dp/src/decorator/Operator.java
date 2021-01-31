package decorator;

public abstract class Operator extends Expression{
	Expression ex1;
	Expression ex2;
	Operator(Expression ex1, Expression ex2){
		this.ex1 = ex1;
		this.ex2 = ex2;
	}
	public abstract String getStr();
}
