package decorator;

public class Bracket extends Operator{
	
	Bracket(Expression ex1){
		super(ex1, null);
	}
	
	Bracket(Expression ex1, Expression ex2) {
		super(ex1, ex2);
	}

	@Override
	public String getStr() {
		return "(" + this.ex1.getStr() + ")";
	}

}
