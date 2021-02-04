package factorymethod;

public class FactoryMethodMain {
	public static void main(String[] args) {
		PizzaFactory nyfactory = new NYPizzaFactory();
		// framework 				// subclassing
		PizzaFactory chiafactory = new ChicagoFactory();
		Pizza nych = nyfactory.createPizza("chesse");
		
	}
}

abstract class Pizza{ // abstract product
	String name;
	Pizza(String name){
		this.name = name;
	}
	void prepare() {
		System.out.println(this.name + "preapare()");
	}
	void bake() {
		System.out.println(this.name + "bake()");
	}
	void cut() {
		System.out.println(this.name + "cut()");
	}
	void pack() {
		System.out.println(this.name + "pack()");
	}
}

abstract class PizzaFactory{ // abstract factory
	void orderPizza(String type) {
		Pizza pizza = createPizza(type);
		
	}
	protected abstract Pizza createPizza(String type);
}

class NYPizzaFactory extends PizzaFactory{ //concrete factory
	protected Pizza createPizza(String type) {
		if(type.equals("cheese")) {
			return new NYCheesePizza();
		}else if(type.equals("veggie")){
			return new NYVeggiePizza();
		}
		return null;
	}
}

class ChicagoFactory extends PizzaFactory{ 
	@Override
	protected
	Pizza createPizza(String type) {
		if(type.equals("cheese")) {
			return new ChicagoCheesPizza();
		}else if(type.equals("veggie")) {
			return new ChicagoVeggiePizza();
		}
		return null;
	}
	
}

class NYCheesePizza extends Pizza{ // concrete product
	public NYCheesePizza() {
		super("NYCheesePizza");
	}
}

class NYVeggiePizza extends Pizza{
	public NYVeggiePizza() {
		super("NYVeggiePizza");
	}
}

class ChicagoCheesPizza extends Pizza{
	public ChicagoCheesPizza() {
		super("ChicagoCheesePizza");
	}
}

class ChicagoVeggiePizza extends Pizza{
	public ChicagoVeggiePizza() {
		super("ChicagoVeggiePizza");
	}
}
