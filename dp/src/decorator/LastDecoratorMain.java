package decorator;

public class LastDecoratorMain {
	public static void main(String[] args) {
		Expression_ ex1 = new Number_("3");
		System.out.println(ex1.getStr());
		
		Expression_ ex2 = new Number_("2");
		ex2 = new Plus_(ex2);
		ex2 = new OpNum_(ex2, "5");
		System.out.println(ex2.getStr());
		
		Expression_ ex3 = new Number_("");
		ex3 = new StartBracket_(ex3);
		ex3 = new StartBracket_(ex3);
		ex3 = new OpNum_(ex3, "2");
		ex3 = new Minus_(ex3);
		ex3 = new OpNum_(ex3, "8");
		ex3 = new EndBracket_(ex3);
		ex3 = new Multiple_(ex3);
		ex3 = new StartBracket_(ex3);
		ex3 = new OpNum_(ex3, "4");
		ex3 = new Plus_(ex3);
		ex3 = new OpNum_(ex3, "5");
		ex3 = new EndBracket_(ex3);
		ex3 = new EndBracket_(ex3);
		ex3 = new Div_(ex3);
		ex3 = new OpNum_(ex3, "2");
		
		System.out.println(ex3.getStr());
	}
	
}

abstract class Expression_{
	String str="";
	abstract String getStr();
}

abstract class OperatorDecorator_ extends Expression_{
	
}

class Number_ extends Expression_{
	Number_(String str){
		this.str = str;
	}

	@Override
	String getStr() {
		return this.str;
	}
}

class Plus_ extends OperatorDecorator_{
	Expression_ ex;
	Plus_(Expression_ ex){
		this.ex=ex;
	}
	@Override
	String getStr() {
		return ex.getStr() + "+";
	}
}

class Minus_ extends OperatorDecorator_{
	Expression_ ex;
	Minus_(Expression_ ex){
		this.ex = ex;
	}
	@Override
	String getStr() {
		return this.ex.getStr() + "-";
	}
}

class Multiple_ extends OperatorDecorator_{
	Expression_ ex;
	Multiple_(Expression_ ex){
		this.ex = ex;
	}
	@Override
	String getStr() {
		return this.ex.getStr() + "*";
	}
}

class Div_ extends OperatorDecorator_{
	Expression_ ex;
	Div_(Expression_ ex){
		this.ex = ex;
	}
	@Override
	String getStr() {
		return this.ex.getStr() + "/";
	}
}

class StartBracket_ extends OperatorDecorator_{
	Expression_ ex;
	StartBracket_(Expression_ ex){
		this.ex = ex;
	}
	@Override
	String getStr() {
		return this.ex.getStr()+"(";
	}
}

class EndBracket_ extends OperatorDecorator_{
	Expression_ ex;
	EndBracket_(Expression_ ex){
		this.ex = ex;
	}
	@Override
	String getStr() {
		return this.ex.getStr()+")";
	}
}

class OpNum_ extends OperatorDecorator_{
	Expression_ ex;
	String num;
	OpNum_(Expression_ ex, String num){
		this.ex = ex;
		this.num = num;
	}
	@Override
	String getStr() {
		return this.ex.getStr()+this.num;
	}
}






