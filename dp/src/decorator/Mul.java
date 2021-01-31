package decorator;

public class Mul extends Operator{

	Mul(Expression ex1, Expression ex2) {
		super(ex1, ex2);
	}

	@Override
	public String getStr() {
			return this.ex1.getStr()+"*"+this.ex2.getStr();			
	}

}
