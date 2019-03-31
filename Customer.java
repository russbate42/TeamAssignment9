import java.util.Scanner;

public class Customer implements Comparable<Customer> {

	private String name;
	private int customerID;
    private CreditHistory history;


    public Customer(){
        name = "";
        customerID = 0;
    }


    public Customer(Customer accountHolder){
        setName(accountHolder.getName());
        setCustomerID(accountHolder.getID());
        history = accountHolder.getCreditHistory();
    }


    public Customer(String name, int customerID){
        setName(name);
        setCustomerID(customerID);
    }


    public Customer(String name, int customerID, CreditHistory aHistory){
        setName(name);
        setCustomerID(customerID);
        history = aHistory;
    }


    public int compareTo(Customer aCustomer){
        int compareNum = 0;
        String compareName = aCustomer.getName();
        int compareID = aCustomer.getID();
        char[] compareNameChar = compareName.toCharArray();
        char[] nameChar = name.toCharArray();

        // figure out which name is shorter for dictionary sorting
        int compareNameLength = compareName.length();
        int nameLength = name.length();
        int shorterName = 0;
        int shorterNameLength;

        if (compareNameLength == nameLength){
            shorterNameLength = nameLength;
        }
        else if (compareNameLength < nameLength){
            shorterNameLength = compareNameLength; 
        }
        else {
            shorterNameLength = nameLength;
        }
        
        // if the two names are equal resort to customer ID
        if (name.equals(compareName)){
            if (compareID == customerID){
                compareNum = 0;
            }
            else if (compareID > customerID){
                compareNum = -1;
            }
            else {
                compareNum = +1;
            }
        }

        // if the two names are not equal
        else {

            // search through all the characters in the string and compare their
            // values on the ASCII table
            for (int i = 0; i < shorterNameLength; i++){

                // if the characters are equal
                if (compareNameChar[i] == nameChar[i]){
                    // then we continue, but check to see if we are at the
                    // end of the string, then we choose if its shorter
                    if (i == shorterNameLength - 1){
                        // the name is longer than compareName goes before
                        if (compareNameLength < nameLength){
                            compareNum = +1;
                        }
                        // the name is shorter than compareName goes after
                        else {
                            compareNum = -1;
                        }
                    }
                }

                // otherwise we can make the comparison
                else {
                    // if the character is lower on the ascii table it is before
                    if (compareNameChar[i] < nameChar[i]){
                        compareNum = +1;
                    }
                    // if not less than or equal then its bigger, so goes after
                    else {
                        compareNum = -1;
                    }
                }
            // end of for
            }
        // end of else
        }

        return compareNum;
    // end of compareTo
    }


    public void setCreditHistory(CreditHistory aHistory){
        history = aHistory;
    }

    public CreditHistory getCreditHistory(){
        // CreditHistory copyHistory = new CreditHistory(history);
        return history;
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


    public int getID(){
        int copyID = customerID;
        return copyID;
    }


	public String toString(){
		String customerIDstring = Integer.toString(customerID);
        String customerString = name+" "+customerIDstring;
        return customerString;
	}

}