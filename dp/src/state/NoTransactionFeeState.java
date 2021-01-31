package state;

public class NoTransactionFeeState implements State{
	BankAccount ba;
	NoTransactionFeeState(BankAccount ba){
		this.ba = ba;
	}
	@Override
	public void withdraw(int amount) {
		ba.updateAmount(ba.getAmount()-amount);
		int currentAmount = ba.getAmount();
		if(currentAmount <= 0) {
			ba.setState(ba.overdrawnState);
		}else if(currentAmount <= BankAccount.MIN_AMOUNT) {
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
