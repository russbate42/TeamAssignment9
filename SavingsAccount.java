
public class SavingsAccount extends BankAccount {

	private double annualInterestRate = 0.05;
	private double minimumBalance;


    /**
    * This is the default constructor for the bank account. 
    **/
    public SavingsAccount(){
        super();
    }


    public SavingsAccount(String aNum){
        super(aNum);
    }


    /**
    * Constructor for bank account taking one argument. 
    * @param startBalance is the balance to initialize the bank account with.
    * @returns none
    **/
    public SavingsAccount(double startInterestRate){
        super();
        setAnnualInterestRate(startInterestRate);
    }


    /**
    * Constructor for bank account taking one argument. 
    * @param startBalance is the balance to initialize the bank account with.
    * @returns none
    **/
    public SavingsAccount(double startBalance, double startInterestRate){
        super(startBalance);
        setAnnualInterestRate(startInterestRate);
    }


    /**
    * Constructor for bank account taking one argument. 
    * @param startBalance is the balance to initialize the bank account with.
    * @returns none
    **/
    public SavingsAccount(Customer aCustomer, double startBalance,
        double startInterestRate){
        super(aCustomer, startBalance);
        setAnnualInterestRate(startInterestRate);
    }


    /**
    * Bank account constructor taking two arguments. 
    * @param <startBalance>: the initial balance. <accountNumber>: 4 digit string specifying the
    * account number.
    * @returns none
    **/
    public SavingsAccount(double startBalance, String accountNumber){
        super(startBalance, accountNumber);    
    }


    /**
    * Bank account constructor taking two arguments. 
    * @param <accountHolder>: The customer for which to initialize the bank account for. Expects 
    Type Customer to have been initialized and passed to the this constructor. Will use the current 
    * specified account holder.  
    * <startBalance>: Initial balance for the customer. 
    * @see Customer class
    * @returns none
    **/
    public SavingsAccount(Customer accountHolder, double startBalance){
        super(accountHolder, startBalance);
    }


    public double getMonthlyFeesAndInterest(){
        double currentBalance = getBalance();
        double monthlyRate = annualInterestRate/12;
        double interestIncrued = monthlyRate * currentBalance;
        return interestIncrued;
    }


    public void withdraw(double withdrawAmount){
        double newBalance = getBalance() - withdrawAmount;

        if (newBalance >= minimumBalance){
            super.withdraw(withdrawAmount);
        }

    }


    public void setAnnualInterestRate(double newRate){
    	if (newRate >= 0 && newRate <= 1){
    	    annualInterestRate = newRate;
        }
    }


    public double getAnnualInterestRate(){
    	return annualInterestRate;
    }


    public void setMinimumBalance(double newMinimum){
        minimumBalance = newMinimum;
    }


    public double getMinimumBalance(){
    	return minimumBalance;
    }


// End of class.
}
