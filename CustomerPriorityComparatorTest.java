import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerPriorityComparatorTest
{
    @Test
    public void test_compare_differentRating_firstSmaller(){
    	Customer c1 = new Customer("Customer One", 123);
    	CreditHistory h1 = new CreditHistory();
    	h1.addRating(4);
    	c1.setCreditHistory(h1);
    	
    	Customer c2 = new Customer("Customer Two", 456);
    	CreditHistory h2 = new CreditHistory();
    	h2.addRating(5);
    	c2.setCreditHistory(h2);
    	
    	int actual = (new CustomerPriorityComparator()).compare(c1,c2);
    	
    	assertTrue("Lower credit rating should be ordered after  In other words, credit rating of 4 is greater than (worse) credit rating of 5.", actual > 0);
    }

    @Test
    public void test_compare_differentRating_secondSmaller(){
    	Customer c1 = new Customer("Customer One", 123);
    	CreditHistory h1 = new CreditHistory();
    	h1.addRating(-1);
    	c1.setCreditHistory(h1);

    	Customer c2 = new Customer("Customer Two", 456);
    	CreditHistory h2 = new CreditHistory();
    	h2.addRating(3);
    	c2.setCreditHistory(h2);
    	
    	int actual = (new CustomerPriorityComparator()).compare(c2,c1);
    	
    	assertTrue("Lower credit rating should be ordered after  In other words, credit rating of -1 is greater than (worse) credit rating of 3.", actual < 0);
    }

    @Test
    public void test_compare_sameRating(){
    	Customer c1 = new Customer("Customer Two", 123);
    	CreditHistory h1 = new CreditHistory();
    	h1.addRating(3);
    	h1.addRating(4);
    	c1.setCreditHistory(h1);

    	Customer c2 = new Customer("Customer Two", 123);
    	CreditHistory h2 = new CreditHistory();
    	h2.addRating(3);
    	h2.addRating(4);
    	c2.setCreditHistory(h2);
    	
    	int actual = (new CustomerPriorityComparator()).compare(c1,c2);
    	
    	assertEquals("Expecting zero when both have same credit rating.", 0, actual);
    }

    
}