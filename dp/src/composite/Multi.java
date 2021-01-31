package composite;

public class Multi extends Operator{
	Multi(Expression ex1, Expression ex2){
		super(ex1, ex2);
	}
	
	public void  print() {
		System.out.println(list.get(0).str + "*" + list.get(1).str);
	}
}
