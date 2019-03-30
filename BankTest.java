import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class BankTest
{
	// Testing customer list
	@Test
	public void testAddAndGetCustomers_oneCustomer(){
		Customer c = new Customer("Mark One", 123);
		Bank b = new Bank();
		
		b.addCustomer(c);
		
		Customer[] actualList = b.getCustomers();
		
		assertEquals("Expected bank to have one customer in list", 1, actualList.length);
		assertEquals("Expected single customer in list to be 'Mark One'", "Mark One", actualList[0].getName());
	}
	
	@Test
	public void testAddAndGetCustomers_twoCustomersAddedInOrder(){
		Customer c1 = new Customer("Mark One", 123);
		Customer c2 = new Customer("Mark Two", 456);
		Bank b = new Bank();
		
		b.addCustomer(c1);
		b.addCustomer(c2);
		
		Customer[] actualList = b.getCustomers();
		
		assertEquals("Expected bank to have two customer in list", 2, actualList.length);
		assertEquals("Expected first customer in list to be 'Mark One'", "Mark One", actualList[0].getName());
		assertEquals("Expected second customer in list to be 'Mark Two'", "Mark Two", actualList[1].getName());
	}
	
	@Test
	public void testAddAndGetCustomers_twoCustomersAddedOutOfOrder(){
		Customer c1 = new Customer("Mark One", 123);
		Customer c2 = new Customer("Mark Two", 456);
		Bank b = new Bank();
		
		b.addCustomer(c2);
		b.addCustomer(c1);
		
		Customer[] actualList = b.getCustomers();
		
		assertEquals("Expected bank to have two customer in list", 2, actualList.length);
		assertEquals("Expected first customer in list to be 'Mark One'", "Mark One", actualList[0].getName());
		assertEquals("Expected second customer in list to be 'Mark Two'", "Mark Two", actualList[1].getName());
	}
	
	@Test
	public void testAddAndGetCustomers_manyCustomers(){
		Customer c1 = new Customer("Ameline", 001);
		Customer c2 = new Customer("Ameline", 100);
		Customer c3 = new Customer("Mark One", 123);
		Customer c4 = new Customer("Mark Two", 456);
		Customer c5 = new Customer("Zain", 901);
		Customer c6 = new Customer("Zhang", 456);
		Bank b = new Bank();
		
		b.addCustomer(c5);
		b.addCustomer(c1);
		b.addCustomer(c4);
		b.addCustomer(c6);
		b.addCustomer(c2);
		b.addCustomer(c3);
		
		Customer[] actualList = b.getCustomers();
		
		assertEquals("Expected bank to have two customer in list", 6, actualList.length);
		assertEquals("Expected first customer in list to be 'Ameline'", "Ameline", actualList[0].getName());
		assertEquals("Expected first customer in list to have id 001", 1, actualList[0].getID());
		assertEquals("Expected second customer in list to be 'Ameline'", "Ameline", actualList[1].getName());
		assertEquals("Expected second customer in list to have id 100", 100, actualList[1].getID());
		assertEquals("Expected third customer in list to be 'Mark One'", "Mark One", actualList[2].getName());
		assertEquals("Expected third customer in list to have id 123", 123, actualList[2].getID());
		assertEquals("Expected fourth customer in list to be 'Mark Two'", "Mark Two", actualList[3].getName());
		assertEquals("Expected fourth customer in list to have id 456", 456, actualList[3].getID());
		assertEquals("Expected fifth customer in list to be 'Zain'", "Zain", actualList[4].getName());
		assertEquals("Expected fifth customer in list to have id 901", 901, actualList[4].getID());
		assertEquals("Expected sixth customer in list to be 'Zhang'", "Zhang", actualList[5].getName());
		assertEquals("Expected sixth customer in list to have id 456", 456, actualList[5].getID());
	}
	
	// testing account list
	@Test
	public void testAddAndGetAccount_oneAccount(){
		BankAccount a = new SavingsAccount("1234");
		Bank b = new Bank();
		
		try {
			b.addAccount(a);
		} catch (DuplicateAccountException dae) {
			fail("Did not expect a duplicate account exception when adding an account to an empty list.");
		}
		
		BankAccount[] actualList = b.getAccounts();
		
		assertEquals("Expected bank to have one account in list", 1, actualList.length);
		assertEquals("Expected single account in list to have 1234 as ID", "1234", actualList[0].getAccountNumber());
	}
	
	@Test
	public void testAddAndGetAccount_twoAccountsSameID(){
		BankAccount a = new SavingsAccount("1234");
		BankAccount a2 = new ChequingAccount("1234");
		Bank b = new Bank();
		
		try {
			b.addAccount(a);
		} catch (DuplicateAccountException dae) {
			fail("Did not expect a duplicate account exception when adding an account to an empty list.");
		}
		
		try {
			b.addAccount(a2);
			fail("Expected DuplicateAccountException when adding second account with same accountNumber as first one added.");
		} catch (DuplicateAccountException dae) {
		}
	}
	
	@Test
	public void testAddAndGetAccount_manyAccountsNoDuplicates(){
		BankAccount a1 = new SavingsAccount("1234");
		BankAccount a2 = new ChequingAccount("Hello21");
		BankAccount a3 = new ChequingAccount("5432");
		BankAccount a4 = new SavingsAccount("A2B3c45");
		BankAccount a5 = new ChequingAccount("NoNumbers");
		Bank b = new Bank();
		
		try {
			b.addAccount(a1);
			b.addAccount(a2);
			b.addAccount(a3);
			b.addAccount(a4);
			b.addAccount(a5);
		} catch (DuplicateAccountException dae) {
			fail("Did not expect a duplicate account exception when adding only unique accounts.");
		}
		
		BankAccount[] actualList = b.getAccounts();
		
		assertEquals("Expected bank to have five accounts in list", 5, actualList.length);
	}
	
	// testing customer queue list
	@Test
	public void test_queueAndNextCustomer_emptyQueue(){
		Bank b = new Bank();
		
		Customer actual = b.nextCustomer();
		
		assertNull("Did not put any customer on the queue, so expected next customer to be null", actual);
	}
	
	@Test
    public void test_queueAndNextCustomer_firstAddedWorseRating(){
    	Customer c1 = new Customer("Customer One", 123);
    	CreditHistory h1 = new CreditHistory();
    	h1.addRating(4);
    	c1.setCreditHistory(h1);
    	
    	Customer c2 = new Customer("Customer Two", 456);
    	CreditHistory h2 = new CreditHistory();
    	h2.addRating(5);
    	c2.setCreditHistory(h2);
    	
    	Bank b = new Bank();
    	b.queueCustomer(c1);
    	b.queueCustomer(c2);
    	
    	Customer actual = b.nextCustomer();
   
    	assertEquals("Last customer added should have been first removed: it had higher rating", "Customer Two", actual.getName());
    }

	@Test
    public void test_queueAndNextCustomer_secondAddedWorseRating(){
    	Customer c1 = new Customer("Customer One", 123);
    	CreditHistory h1 = new CreditHistory();
    	h1.addRating(3);
    	c1.setCreditHistory(h1);
    	
    	Customer c2 = new Customer("Customer Two", 456);
    	CreditHistory h2 = new CreditHistory();
    	h2.addRating(-1);
    	c2.setCreditHistory(h2);
    	
    	Bank b = new Bank();
    	b.queueCustomer(c1);
    	b.queueCustomer(c2);
    	
    	Customer actual = b.nextCustomer();
   
    	assertEquals("First customer added should have been first removed: it had higher rating", "Customer One", actual.getName());
    }


	@Test
    public void test_queueAndNextCustomer_addingManyThenDequeuAll(){
    	Customer c1 = new Customer("Rating 5", 123);
    	CreditHistory h1 = new CreditHistory();
    	h1.addRating(5);
    	c1.setCreditHistory(h1);
    	
    	Customer c2 = new Customer("Rating 4", 456);
    	CreditHistory h2 = new CreditHistory();
    	h2.addRating(4);
    	c2.setCreditHistory(h2);
    	
    	Customer c3 = new Customer("Rating 3", 456);
    	CreditHistory h3 = new CreditHistory();
    	h3.addRating(3);
    	c3.setCreditHistory(h3);
    	
    	Customer c4 = new Customer("Rating -1", 456);
    	CreditHistory h4 = new CreditHistory();
    	h4.addRating(-1);
    	c4.setCreditHistory(h4);
    	
    	Customer c5 = new Customer("Rating -3", 456);
    	CreditHistory h5 = new CreditHistory();
    	h5.addRating(-3);
    	c5.setCreditHistory(h5);
    	
    	Bank b = new Bank();
    	b.queueCustomer(c3);
    	b.queueCustomer(c4);
    	b.queueCustomer(c1);
    	b.queueCustomer(c5);
    	b.queueCustomer(c2);
    	
    	  
    	assertEquals("After queueing five customer, expected customer with rating 5 to be at the head of the queue.", "Rating 5", b.nextCustomer().getName());
    	assertEquals("After queueing five customer, expected customer with rating 4 to be second in the queue.", "Rating 4", b.nextCustomer().getName());
    	assertEquals("After queueing five customer, expected customer with rating 3 to be third in the queue", "Rating 3", b.nextCustomer().getName());
    	assertEquals("After queueing five customer, expected customer with rating -1 to be fourth in the queue.", "Rating -1", b.nextCustomer().getName());
    	assertEquals("After queueing five customer, expected customer with rating -3 to be last in the queue.", "Rating -3", b.nextCustomer().getName());
    }	
}
