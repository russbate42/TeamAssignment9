
import java.util.*;

public class Bank{

    private PriorityQueue<Customer> customers = new PriorityQueue<Customer>(new CustomerPriorityComparator());
    private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();	

	public void addCustomer(Customer aCustomer){
        customers.add(aCustomer);
	}


	public Customer[] getCustomers(){
		int customersSize = customers.size();
		Customer[] copyCustomers = new Customer[customersSize];
		int i = 0;

		for (Customer aCustomer : customers){
            copyCustomers[i] = aCustomer;
		    i++;
		}

		return copyCustomers;
	}


	public void addAccount(BankAccount anAccount){
        accounts.add(anAccount);
	}


	public BankAccount[] getAccounts(){
		BankAccount[] returnAccounts = new BankAccount[accounts.size()];
		int counter = 0;

		for (BankAccount anAccount : accounts){
			returnAccounts[counter] = anAccount;
			counter++;
		}
		
		return returnAccounts;
	}


}