package decorator;

public class Number extends Expression{
	
	public Number(String str) {
		this.str = str;
	}
	public Number(Expression ex) {
		this.str+=ex.str;
	}
	public Number(Expression ex, String str) {
		this.str = ex.getStr() + str;
	}
	public Number(Expression ex, Expression ex2) {
		this.str = ex.getStr() + ex2.getStr();
	}
	
	public Number(String str, Expression ex) {
		this.str = str+ ex.getStr();
	}
}
