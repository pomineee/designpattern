package state;


interface MState {
	public void withdraw(int amount);
	public void deposit(int amount);
}

class MBankAccount {
	MState currentState;
	
	int amount;
	final static int MIN_AMOUNT = 100;
	
	MNoTransactionFeeState noTransactionFeeState;
	MTransactionFeeState transactionFeeState;
	MOverdrawnState overdrawnState;
	
	MBankAccount(int amount){
		this.amount = amount;
		noTransactionFeeState = new MNoTransactionFeeState(this);
		transactionFeeState = new MTransactionFeeState(this);
		overdrawnState = new MOverdrawnState(this);
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
	
	public void setState(MState state) {
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

class MNoTransactionFeeState implements MState{
	MBankAccount ba;
	MNoTransactionFeeState(MBankAccount ba){
		this.ba = ba;
	}
	@Override
	public void withdraw(int amount) {
		ba.updateAmount(ba.getAmount()-amount);
		int currentAmount = ba.getAmount();
		if(currentAmount <= 0) {
			ba.setState(ba.overdrawnState);
		}else if(currentAmount <= MBankAccount.MIN_AMOUNT) {
			ba.setState(ba.transactionFeeState);
		}
		System.out.format("[%s] : withdraw(%d) -> (%d) %s\n", this.toString(), amount, ba.getAmount(), ba.currentState.toString());
	}

	@Override
	public void deposit(int amount) {
		
	}
	
	@Override
	public String toString() {
		return "[NoTransactionFeeState]";
	}
}

class MOverdrawnState implements MState{
	
	MBankAccount ba;
	public MOverdrawnState(MBankAccount ba) {
		this.ba = ba;
	}
	@Override
	public void withdraw(int amount) {
		
	}

	@Override
	public void deposit(int amount) {
		
		ba.updateAmount(ba.getAmount()+amount);
		int currentAmount = ba.getAmount();
		if(currentAmount <= MBankAccount.MIN_AMOUNT) {
			ba.setState(ba.transactionFeeState);
		}else {
			ba.setState(ba.noTransactionFeeState);
		}
		System.out.format("[%s] : deposit(%d) -> (%d) %s\n", this.toString(), amount, ba.getAmount(), ba.currentState.toString());
	}
	
	@Override
	public String toString() {
		return "[OverdrawnState]";
	}
}

class MTransactionFeeState implements MState{
	MBankAccount ba;
	
	public MTransactionFeeState(MBankAccount ba) {
		this.ba = ba;
	}
	@Override
	public void withdraw(int amount) {
		ba.updateAmount(ba.getAmount()-amount);
		int currentAmount = ba.getAmount();
		if(currentAmount <= 0) {
			ba.setState(ba.overdrawnState);
		}
		System.out.format("[%s] : withdraw(%d) -> (%d) %s\n", this.toString(), amount, ba.getAmount(), ba.currentState.toString());
		
	}

	@Override
	public void deposit(int amount) {
		ba.updateAmount(ba.getAmount()+amount);
		int currentAmount = ba.getAmount();
		if(currentAmount >= BankAccount.MIN_AMOUNT) {
			ba.setState(ba.noTransactionFeeState);
		}
		System.out.format("[%s] : deposit(%d) -> (%d) %s\n", this.toString(), amount, ba.getAmount(), ba.currentState.toString());
		
	}
	
	@Override
	public String toString() {
		return "[TransactionFeeState]";
	}
}

