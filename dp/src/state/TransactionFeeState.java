package state;

public class TransactionFeeState implements State{
	BankAccount ba;
	
	public TransactionFeeState(BankAccount ba) {
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
