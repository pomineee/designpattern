package decorator;

public class Minus extends Operator	{
	Minus(Expression ex1, Expression ex2) {
		super(ex1, ex2);
	}

	@Override
	public String getStr() {
		return  this.ex1.getStr()+"-"+this.ex2.getStr();
	}
	
}
