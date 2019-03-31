public class ChequingAccount extends BankAccount{
    private double overdraftFee;
    private double overdraftAmount = 100.0; 

    public ChequingAccount(Customer newOwner, double newBalance, double anOverdraftFee) {
        super(newOwner, newBalance);
        setOverdraftFee(anOverdraftFee);
    }
    
    public ChequingAccount(String accountNumber) {
    	super(0.0, accountNumber);
    }

    public void setOverdraftFee(double aFee) {
    	if (aFee >= 0.0) {
    		overdraftFee = aFee;
    	} else {
    		overdraftFee = 1.0;
    	}
    }
    
    public double getOverdraftFee() { 
    	return overdraftFee; 
    }
    
    public void setOverdraftAmount(double newOverdraftAmount){
        overdraftAmount = newOverdraftAmount;
    }

    protected boolean sufficientFunds(double amount) {
    	double availableAmount = getBalance() + overdraftAmount;
    	boolean sufficient = amount > 0 && (amount < getBalance() || amount <= availableAmount);
    	return sufficient;
    }
    
    public void withdraw(double amount) {
    	if (getBalance() - amount < 0) {
    		super.withdraw(amount + overdraftFee);
    	} else {
    		super.withdraw(amount);
    	}
    }
    
    protected double getMonthlyFeesAndInterest() {
    	double amount = 0.0;
    	if (getBalance() < 0.0 ) {
    		amount = .2 * getBalance();
    	}
    	return amount;
    }
}