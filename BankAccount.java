import java.util.Random;

public abstract class BankAccount {
	private double balance;
	private String accountNumber;
	private Customer accountHolder;
	
	public BankAccount(){
		accountNumber = new Random().nextInt(9999) + 1 + "";
		while (accountNumber.length() < 4) {
			accountNumber = '0' + accountNumber;
		}
	}	
	
	public BankAccount(double startBalance){
		this();
		balance = startBalance;
	}
	
	public BankAccount(Customer accountHolder, double startBalance) {
		this(startBalance);
		this.accountHolder = accountHolder;		
	}
	
	public BankAccount(double startBalance, String accountNumber) {
		this(startBalance);
		this.accountNumber = accountNumber;
	}
	
	public BankAccount(BankAccount accountToCopy){
		this.balance = accountToCopy.balance;
		this.accountNumber = accountToCopy.accountNumber;
		this.accountHolder = accountToCopy.accountHolder;
	}
    
	protected abstract double getMonthlyFeesAndInterest();
	
    public void monthEndUpdate() { 
       balance += getMonthlyFeesAndInterest();
    }
    
    protected boolean sufficientFunds(double amount) {
    	return amount > 0 && balance - amount >= 0.0;
    }

	
	public Customer getAccountHolder() {
		return accountHolder;
	}
	
	public void setAccountHolder(Customer aCustomer) {
		accountHolder = aCustomer;
	}
	
	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		}
	}
	
	public void withdraw(double amount) {
		if (sufficientFunds(amount)) {
			balance -= amount;
		}
	}
	
	public void transfer(double amount, BankAccount toAccount) {
		if (sufficientFunds(amount)) {
			withdraw(amount);
			toAccount.deposit(amount);
		}
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String toString() {
		return "(" + accountHolder.toString() + ") " + accountNumber + ": " + balance;
	}

	@Override
	public boolean equals(Object o){
		if (!(o instanceof BankAccount)) return false;
		if(((BankAccount) o).getAccountNumber() == accountNumber) return true;
		return false;
	}

	@Override
	public int hashCode(){
    	String tmp = "";
    	for(char c : accountNumber.toCharArray()){
			if(Character.isDigit(c)) tmp +=c;
		}
    	return tmp.isEmpty()?0:Integer.parseInt(tmp);
	}

}