public class SavingsAccount extends BankAccount {
	private double annualInterestRate = 0.05;
	private double minimumBalance = 0;
	
	public SavingsAccount(){}
	
	public SavingsAccount(double annualInterestRate) {
		super();
		setAnnualInterestRate(annualInterestRate);
	}
	
	public SavingsAccount(String accountNumber){
		super(0.0,accountNumber);
	}
	
	public SavingsAccount(double balance, double annualInterestRate) {
		super(balance);
		setAnnualInterestRate(annualInterestRate);
	}
	
	public SavingsAccount(Customer accountHolder, double balance, double annualInterestRate) {
		super(accountHolder, balance);
		setAnnualInterestRate(annualInterestRate);
	}
	
	public SavingsAccount(Customer accountHolder, double balance) {
		super(accountHolder, balance);
	}
	
    protected double getMonthlyFeesAndInterest() {
		double amount = (annualInterestRate*getBalance())/12;
        return amount;            
    }

    public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	public void setAnnualInterestRate(double newRate) {
		if (newRate >= 0.0 && newRate <= 1.0) {
			annualInterestRate = newRate;
		}
	}
	
	public double getMinimumBalance(){
		return minimumBalance;
	}
	
	public void setMinimumBalance(double minBalance) {
		minimumBalance = minBalance;
	}
	
	public void withdraw(double amount) {
		if (getBalance() - amount >= minimumBalance) {
			super.withdraw(amount);
		}
	}	
//	
//	public void depositMonthlyInterest() {
//		deposit(getBalance() * (annualInterestRate / 12) );
//	}
}