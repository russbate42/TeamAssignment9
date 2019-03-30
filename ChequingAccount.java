
public class ChequingAccount extends BankAccount{

	private double overdraftFee;
	private double overdraftAmount;


    public ChequingAccount(String numString){
        super(numString);
    }


    public ChequingAccount(Customer anAccountHolder, double aStartBalance,
    	double anOverdraftFee){
    	super(anAccountHolder, aStartBalance);
        if (anOverdraftFee >= 0){
        	setOverdraftFee(anOverdraftFee);
        }
        else {
        	setOverdraftFee(1.0);
        }        
    }


    public double getOverdraftFee(){
    	double copyVal = overdraftFee;
    	return copyVal;
    }


    public void setOverdraftFee(double anOverdraftFee){
        if (anOverdraftFee>=0){
            overdraftFee = anOverdraftFee;
        }
    }


    public double getOverdraftAmount(){
    	double copyVal = overdraftAmount;
    	return copyVal;
    }


    public void setOverdraftAmount(double anOverdraftAmount){
        if (anOverdraftAmount>=0){
            overdraftAmount = anOverdraftAmount;
        }
    }


    public boolean sufficientFunds(double aWithdrawAmount){
        boolean hasSufficientFunds;
        double theOverdraftAmount = getOverdraftAmount();

        if ((getBalance() - aWithdrawAmount + theOverdraftAmount) >= 0){
        	hasSufficientFunds = true;
        }
        else {
        	hasSufficientFunds = false;
        }

        return hasSufficientFunds;
    }


    public void withdraw(double aWithdrawAmount){
        
        if (sufficientFunds(aWithdrawAmount) == true){
        	if (getBalance() - aWithdrawAmount >= 0){
        		super.withdraw(aWithdrawAmount);
        	}
        	else {
        		super.withdraw(aWithdrawAmount + overdraftFee);
        	}
            
        }

    }


    public double getMonthlyFeesAndInterest(){
    	double theAmount;
    	double currentBalance = getBalance();

    	if (currentBalance > 0){
    		theAmount = 0;
    	}
    	else if (currentBalance == 0){
            theAmount = -0.0;
    	}
    	else {
    		theAmount = currentBalance * .2;
    	}

    	return theAmount;
    }


// End of class.
}
