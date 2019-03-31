import java.awt.*;
import java.util.*;


public class Bank {

    private HashSet<BankAccount> accounts;
    private PriorityQueue<Customer> queue;

    public Bank(){
        accounts = new HashSet<>();
        queue = new PriorityQueue(new CustomerPriorityComparator());
    }

    public void addAccount(BankAccount acc) throws DuplicateAccountException {
        if(accounts.contains(acc)){
            throw new DuplicateAccountException();
        }
        accounts.add(acc);
    }


    public void addCustomer(Customer toAdd) {
        queue.add(toAdd);
    }

    public Customer nextCustomer(){
        return queue.poll();
    }

    public void queueCustomer(Customer c){
        queue.add(c);
    }

    public BankAccount[] getAccounts(){
        return accounts.toArray(new BankAccount[accounts.size()]);
    }

    public Customer[] getCustomers(){
        Customer[] customers = queue.toArray(new Customer[queue.size()]);
        Arrays.sort(customers,queue.comparator());
        return customers;
    }

}
