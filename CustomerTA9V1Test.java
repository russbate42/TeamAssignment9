import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTA9V1Test
{
    @Test
    public void test_compareTo_differentName_firstSmaller(){
    	Customer c1 = new Customer("Customer One", 123);
    	Customer c2 = new Customer("Customer Two", 456);
    	
    	int actual = c1.compareTo(c2);
    	
    	assertTrue("Expecting less than zero when invoking compareTo on customer with name 'Customer One' and providing customer with name as 'Customer Two'", actual < 0);
    }

    @Test
    public void test_compareTo_differentName_secondSmaller(){
    	Customer c1 = new Customer("Customer One", 123);
    	Customer c2 = new Customer("Customer Two", 456);
    	
    	int actual = c2.compareTo(c1);
    	
    	assertTrue("Expecting greater than zero when invoking compareTo on customer with name 'Customer Two' and providing customer with name as 'Customer One'", actual > 0);
    }

    @Test
    public void test_compareTo_sameName_secondSmallerID(){
    	Customer c1 = new Customer("Customer One", 123);
    	Customer c2 = new Customer("Customer One", 456);
    	
    	int actual = c2.compareTo(c1);
    	
    	assertTrue("Expecting greater than zero when invoking compareTo on customer with ID 456 and providing customer with ID 123 when both have the same name", actual > 0);
    }
    
    @Test
    public void test_compareTo_sameName_firstSmallerID(){
    	Customer c1 = new Customer("Customer Two", 123);
    	Customer c2 = new Customer("Customer Two", 456);
    	
    	int actual = c1.compareTo(c2);
    	
    	assertTrue("Expecting less than zero when invoking compareTo on customer with ID 123 and providing customer with ID 456 when both have the same name", actual < 0);
    }

    @Test
    public void test_compareTo_sameNameAndID(){
    	Customer c1 = new Customer("Customer Two", 123);
    	Customer c2 = new Customer("Customer Two", 123);
    	
    	int actual = c1.compareTo(c2);
    	
    	assertEquals("Expecting zero when both have same name and id.", 0, actual);
    }

    
}