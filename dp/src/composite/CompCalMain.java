package composite;


public class CompCalMain {
	public static void main(String[] args) {
	
		Expression ex1 = new Number("3");
		ex1.print();
		
		Expression ex2 = new Plus(new Number("2"), new Number("5"));
		ex2.print();
		
		Expression ex3 = new Minus(new Number("3"), new Number("2"));
		Expression ex4 = new Plus(new Number("5"), new Number("4"));
		Expression ex5 = new Multi(ex3, ex4);
		ex5.print();
	}
}


