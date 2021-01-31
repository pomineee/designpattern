package decorator;

public class CalDecoMain {
	public static void main(String[] args) {
		Expression test1 = new Number("3");
		System.out.println(test1.getStr());
		
		Expression test2 = new Plus(new Number("2"), new Number("5"));
		System.out.println(test2.getStr());
		
		Expression ex5 = new Mul(new Bracket(new Plus(new Number("3"), new Number("4"))), new Bracket(new Minus(new Number("7"), new Number("9"))));
		Expression ex6 = new Div(new Bracket(ex5), new Number("2"));
		System.out.println(ex6.getStr());
	}
}
