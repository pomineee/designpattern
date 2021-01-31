package decorator;

public class Plus extends Operator{
	Plus(Expression ex1, Expression ex2) {
		super(ex1, ex2);
	}

	@Override
	public String getStr() {
			return ex1.getStr()+"+"+ex2.getStr();	
		
	}

}
