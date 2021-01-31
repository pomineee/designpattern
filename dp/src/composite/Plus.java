package composite;

public class Plus extends Operator{
	Plus(Expression ex1, Expression ex2){
		super(ex1, ex2);
	}
	
	public void  print() {
		System.out.println(list.get(0).str + "+" + list.get(1).str);
	}
}
