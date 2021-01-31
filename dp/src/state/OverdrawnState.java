package state;

public class OverdrawnState implements State{
	
	BankAccount ba;
	public OverdrawnState(BankAccount ba) {
		this.ba = ba;
	}
	@Override
	public void withdraw(int amount) {
		
		
	}

	@Override
	public void deposit(int amount) {
		
		ba.updateAmount(ba.getAmount()+amount);
		int currentAmount = ba.getAmount();
		if(currentAmount <= BankAccount.MIN_AMOUNT) {
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
