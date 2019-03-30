
import java.util.Scanner;
import java.util.*;


public class CustomerPriorityComparator implements Comparator<Customer> {

	private String name;
	private int customerID;
    private CreditHistory history;


	public CustomerPriorityComparator(){
        name = "";
        customerID = 0;
	}


    public int compare(Customer a, Customer b) {
        int rating0 = (int) a.getCreditHistory().getCreditRating();
        int rating1 = (int) b.getCreditHistory().getCreditRating();
        
        if(rating0 == rating1 ) {
            return 0;
        }
        else if (rating0 < rating1) {
            return 1;
        }
        else {
            return -1;
        }
    }



    public String getName(){
        String copyName = name;
        return copyName;
    }


    public void setName(String newName){
        name = newName;
    }


    public void setCustomerID(int newID){
        customerID = newID;
    }


    public int getCustomerID(){
        int copyID = customerID;
        return copyID;
    }


	public String toString(){
		String customerIDstring = Integer.toString(customerID);
        String customerString = name+" "+customerIDstring;
        return customerString;
	}

}

