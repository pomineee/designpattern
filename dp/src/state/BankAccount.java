package state;

public class BankAccount {
	State currentState;
	
	int amount;
	final static int MIN_AMOUNT = 100;
	
	NoTransactionFeeState noTransactionFeeState;
	TransactionFeeState transactionFeeState;
	OverdrawnState overdrawnState;
	
	BankAccount(int amount){
		this.amount = amount;
		noTransactionFeeState = new NoTransactionFeeState(this);
		transactionFeeState = new TransactionFeeState(this);
		overdrawnState = new OverdrawnState(this);
		if(amount < 0 ) {
			currentState = overdrawnState;
		}else if(amount <= MIN_AMOUNT) {
			currentState = transactionFeeState;
		}else {
			currentState = noTransactionFeeState;
		}
		System.out.println(String.format("amount : %d, %s", amount, currentState.toString()));
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public void setState(State state) {
		this.currentState = state;
	}
	
	public void withdraw(int amount) {
		currentState.withdraw(amount);
	}
	
	public void deposit(int amount) {
		currentState.deposit(amount);
	}
	
	public void updateAmount(int amount) {
		this.amount = amount;
	}
	
	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount(50);
		bankAccount.withdraw(70);
		bankAccount.deposit(200);
		bankAccount.withdraw(100);
	}
}
