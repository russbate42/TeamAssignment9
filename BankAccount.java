import java.util.Scanner;

public abstract class BankAccount{

    /*
    * This is the Bank account class used for generating accounts in the bank.
    * @author Group 23
    * @version 1.0
    */
    
    private double balance = 0.0;
    private String accountNumber = "0001";
    private Customer accountHolder = new Customer();
    

    /** This is the default constructor for the bank account. 
    **/
    public BankAccount(){
        accountNumber = getAccountNumber();
        balance = getBalance();
        accountHolder = null;
    }


    /** Constructor for bank account taking one argument. 
    @param startBalance is the balance to initialize the bank account with.
    **/
    public BankAccount(double startBalance){
        accountNumber = getAccountNumber();
        this.balance = startBalance;
        accountHolder = null;
    }


    /** Constructor taking one argument. 
    @param <accountNumber> four digit string specifying the account number.
    **/
    public BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
        balance = getBalance();
        accountHolder = null;
    }


    /** Bank account constructor taking two arguments. 
    @param <startBalance>: the initial balance
    @param <accountNumber>: 4 digit string specifying the account number.
    **/
    public BankAccount(double startBalance, String accountNumber){
        this.accountNumber = accountNumber;
        balance = startBalance;
        accountHolder = null;
        // if (accountNumber.length() != 4){
        //     this.accountHolder = null;
        // }
        // else{
        //     this.accountHolder = null;
        // }       
    }


    /**
    Bank account constructor taking two arguments. 
    @param <accountHolder>: The customer for which to initialize the bank account for. Expects 
    Type Customer to have been initialized and passed to the this constructor. Will use the current 
    specified account holder.  
    @param <startBalance>: Initial balance for the customer. 
    @see Customer class
    **/
    public BankAccount(Customer accountHolder, double startBalance){
        this.accountHolder = accountHolder;
        balance = startBalance;
        accountNumber = getAccountNumber();

    }


    /**
    * Bank account constructor all necessary information about the customer and account. 
    * @param <accountHolder>: The customer for which to initialize the bank account for. Expects 
    Type Customer to have been initialized and passed to the this constructor. Will use the current 
    * specified account holder.  
    * <startBalance>: Initial balance for the customer.
    * <accountNumber>: 4 digit string specifying the account number.
    * @see Customer class
    * @returns none
    **/
    public BankAccount(Customer accountHolder, double startBalance, String accountNumber){
        this.accountNumber = accountNumber;
        balance = startBalance;
        this.accountHolder = accountHolder;
    }


    /**
    * BankAccount copy constructor which will create an identical copy of a bank account. 
    * @param <copyAccount>: Bank account for which to copy information from.  
    * @see BankAccount class
    * @returns none
    **/
    public BankAccount(BankAccount copyAccount){
        accountNumber = copyAccount.getAccountNumber();
        balance = copyAccount.getBalance();
        accountHolder = copyAccount.getAccountHolder();
    }


    /** abstract method to get the monthly fees and interest. It is assumed that
    classes inheriting bank account will implement their own 
    getMonthlyFeesAndInteres() dealio
    @return <unknown>: some amount of type double
    **/
    protected abstract double getMonthlyFeesAndInterest();


    /** This calls the get MonthlyFeesAndInterest() which will be defined by a 
    child class and adjusts the balance of the bank account accordingly
    @see getMonthlyFeesAndInterest()
    **/
    public void monthEndUpdate(){
        double amountAdjust = getMonthlyFeesAndInterest();
        
        if (amountAdjust >= 0){
        	deposit(amountAdjust);
        }
        else {
        	balance = balance + amountAdjust;
        }
    }


    /** This is a simple boolean to check if the amount in question is smaller
    than the balance. This will be used to withdraw checking purposes
    @param <anAmount>: the amount as type double to check against the balance
    @return <hasSufficientFunds>: true if the withdraw would be allowed
    **/
    public boolean sufficientFunds(double anAmount){
        boolean hasSufficientFunds;
        if (anAmount <= getBalance()){
        	hasSufficientFunds = true;
        }
        else {
        	hasSufficientFunds = false;
        }
        return hasSufficientFunds;
    }


    /**
    * Sets the current accountHolder to a default Customer class. 
    * @param none  
    * @see Customer class
    * @returns accountHolder
    **/
    public Customer setAccountHolder(){
        accountHolder = new Customer();
        return accountHolder;
    }

    /**
    * Sets the current accountHolder to a given Customer class. This enables other methods
    * or constructors within BankAccount to grab the current account holder as accountHolder. 
    * @param none  
    * @see Customer class
    * @returns accountHolder
    **/
    public Customer setAccountHolder(Customer currentCustomer){
        accountHolder = currentCustomer;
        return accountHolder;
    }


    /**
    * Getter for the current reference to accountHolder.
    * @param none  
    * @see Customer class
    * @returns accountHolder
    **/
    public Customer getAccountHolder(){
        return accountHolder;
    }


    /**
    * Sets the current accountNumber to a specified string. 
    * @param <givenAccountNumber> an account number to set the reference to as a String.  
    * @see Customer class
    * @returns accountNumber
    **/
    public void setAccountNumber(String givenAccountNumber){
        accountNumber = givenAccountNumber;
    }

    /**
    * Getter for the current accountNumber reference. 
    * @param none  
    * @see Customer class
    * @returns accountNumber
    **/
    public String getAccountNumber(){
        return accountNumber;
    }


    /**
    * Sets the balance given an initial. This will yell at you if an initial balance less than
    * zero is passed as a parameter.
    * @param <givenBalance>: the initial balance to initialize <balance> to.
    * @see Customer class
    * @returns none
    **/
    public void setBalance(double givenBalance){
        if (givenBalance>0){
            balance = givenBalance;
        }
        else{
            System.out.println("Invalid balance.");
        }
    }


    /**
    Getter for the current accountHolder's balance. Encapsulated.  
    @see Customer class
    @return <copyBalance>: a copied amount of the customers balance
    **/
    public double getBalance(){
        double copyBalance = balance;
        return copyBalance;
    }

   
    /**
    Getter for the name of the current account holder.   
    @see Customer class
    @return <accountHolder> name of accountHolder
    **/
    public String getAccountName(){
        accountHolder = getAccountHolder();
        String copyName = accountHolder.getName();
        return copyName;
    }


    /*
    * Getter for the accountHolders customer identification. 
    * @param none
    * @see Customer class
    * @returns <accountholder>.customerID
    */
    public int getID(){
        accountHolder = getAccountHolder();
        return accountHolder.getID();
    }


    /*
    * toString method to replace the default. 
    * @param none
    * @returns <acountInfo>: formatted information about the accountHholder and Account
    */
    public String toString(){

        String customerIDString = Integer.toString(getID());
        String accountInfo1 = "("+getAccountName()+" "+customerIDString+") ";
        
        String balanceString = Double.toString(getBalance());
        String accountInfo2 = getAccountNumber()+": "+balanceString;
        
        String accountInfo = accountInfo1 + accountInfo2;
        return accountInfo;
    }


    /**
    Boolean method to change the balance based on a withdraw amount. Also determines if the 
    withdraw is allowed or not. 
    @see hasSufficientFunds()
    @param <withdrawAmount>: The amount to withdraw from the balance in the bank account.  
    @return <legalWithdraw>: boolean which returns if the widthraw is legal or not as true or false
    **/
    public void withdraw(double withdrawAmount){

        if (withdrawAmount > 0){
        
        	if (sufficientFunds(withdrawAmount) == true){
                balance = balance - withdrawAmount;
        	}
        }
    }


    /**
    Boolean method to modify the balance based on the depositAmount @see @params. Will not allow
    negative deposit amounts.  
    @param <depositAmount>: The amount to deposit in the bank account balance. Will not accept
    @return <legalDeposit>: a boolean if the transaction took place
    a negative number.
    **/
    public boolean deposit(double depositAmount){

        boolean legalDeposit;

        if (depositAmount < 0){
        	//System.out.print("Cannot deposit negative amount.");
            legalDeposit = false;
        }

        else{
            balance = balance + depositAmount;
            legalDeposit = true;
        }

        return legalDeposit;
    }


    /**
    * Mutator method to modify the balance based on the transferAmount @see @params. Will not allow
    * a negative balance of the current account. Transfers this amount to another bank account.  
    * @param <transferAmount>: the amount to transfer to the specified bank account.
    * @return <legalTransfer>: a boolean to determine if the transfer is allowed.
    **/
    public void transfer(double transferAmount, BankAccount accountTo){
        boolean legalDeposit = false;
        boolean legalWithdraw;

        // Deposit test
        if (transferAmount > 0){
            legalDeposit = true;
        }

        legalWithdraw = sufficientFunds(transferAmount);

        if (legalWithdraw == true && legalDeposit == true){
        	withdraw(transferAmount);
            accountTo.setBalance(accountTo.getBalance() + transferAmount);
        }
    }


// end of Class
}

