import static org.junit.Assert.*;

import org.junit.Test;

public class BankAccountTA9Test
{
    public class MockBankAccount extends BankAccount
    { 
		public MockBankAccount(){};
		public MockBankAccount(Customer c, double b){super(c,b);}
		public MockBankAccount(double startBalance){super(startBalance);}
		public MockBankAccount(double startBalance, String accountNumber) {super(startBalance,accountNumber);}
		public MockBankAccount(BankAccount accountToCopy){super(accountToCopy);}
		double amount = 0.0;
        protected double getMonthlyFeesAndInterest() 
		{ 
			return amount;
		}
    }
    
	// test constructors
//	@Test
//    public void test_creation(){
//        BankAccount b = new MockBankAccount();
//        assertEquals("Expected initial balance to be 0.0", 0.0, b.getBalance(), 0.00001);
//        
//        String actualAccountNumber = b.getAccountNumber();
//        assertEquals("Account number should have exactly length 4 (4 digits)", 4, actualAccountNumber.length());
//        int num = Integer.parseInt(actualAccountNumber);
//        assertTrue("Account number should be a number between 1 and 9999 (inclusive)", 1 <= num && num <= 9999);
//		assertEquals("Unexpected customer", null, b.getAccountHolder());
//    }
//	
//	@Test
//	public void test_constructorWithBalance()
//	{
//		BankAccount b = new MockBankAccount(50.0);
//		assertEquals("Unexpected balance",50.0,b.getBalance(), 0.00001);
//
//		String actualAccountNumber = b.getAccountNumber();
//        assertEquals("Account number should have exactly length 4 (4 digits)", 4, actualAccountNumber.length());
//        int num = Integer.parseInt(actualAccountNumber);
//        assertTrue("Account number should be a number between 1 and 9999 (inclusive)", 1 <= num && num <= 9999);
//		assertEquals("Unexpected customer", null, b.getAccountHolder());
//	}
//	
//	@Test
//	public void test_constructorWithBalance_negative()
//	{
//		BankAccount b = new MockBankAccount(-50.0);
//		assertEquals("Unexpected balance",-50.0,b.getBalance(), 0.00001);
//
//		String actualAccountNumber = b.getAccountNumber();
//        assertEquals("Account number should have exactly length 4 (4 digits)", 4, actualAccountNumber.length());
//        int num = Integer.parseInt(actualAccountNumber);
//        assertTrue("Account number should be a number between 1 and 9999 (inclusive)", 1 <= num && num <= 9999);
//		assertEquals("Unexpected customer", null, b.getAccountHolder());
//	}
//	
//	@Test
//	public void test_constructorWithBalance_zero()
//	{
//		BankAccount b = new MockBankAccount(0.0);
//		assertEquals("Unexpected balance",0.0,b.getBalance(), 0.00001);
//
//        String actualAccountNumber = b.getAccountNumber();
//        assertEquals("Account number should have exactly length 4 (4 digits)", 4, actualAccountNumber.length());
//        int num = Integer.parseInt(actualAccountNumber);
//        assertTrue("Account number should be a number between 1 and 9999 (inclusive)", 1 <= num && num <= 9999);
//		assertEquals("Unexpected customer", null, b.getAccountHolder());
//	}
//	
//	@Test
//	public void test_constructorWithBalanceAndAccountNumber() {
//		BankAccount b = new MockBankAccount(100.0, "1234");
//		assertEquals("Unexpected balance, created with argument 100.0 and '1234'", 100.0, b.getBalance(),0.00001);
//		assertEquals("Unexpected account number, created with argument 100.0 and '1234'", "1234", b.getAccountNumber());		
//		assertEquals("Unexpected customer", null, b.getAccountHolder());
//	}
//	
//	@Test
//	public void test_constructorWithBalanceAndAccountNumber_shortNumber() {
//		BankAccount b = new MockBankAccount(100.0, "987");
//		assertEquals("Unexpected balance, created with argument 100.0 and '987'", 100.0, b.getBalance(),0.00001);
//		assertEquals("Unexpected account number, created with argument 100.0 and '987'", "987", b.getAccountNumber());		
//		assertEquals("Unexpected customer", null, b.getAccountHolder());
//	}
//	
//	@Test
//	public void test_constructorWithBalanceAndAccountNumber_longNumber() {
//		BankAccount b = new MockBankAccount(100.0, "78654");
//		assertEquals("Unexpected balance, created with argument 100.0 and '78654'", 100.0, b.getBalance(),0.00001);
//		assertEquals("Unexpected account number, created with argument 100.0 and '78654'", "78654", b.getAccountNumber());		
//		assertEquals("Unexpected customer", null, b.getAccountHolder());
//	}
//	
//	@Test
//	public void test_constructorWithCustomerAndBalance() {
//		Customer c = new Customer("John Doe", 321);
//		BankAccount b = new MockBankAccount(c, 50.0);
//		assertEquals("Unexpected balance",50.0,b.getBalance(), 0.00001);
//		assertEquals("Unexpected customer", "John Doe", b.getAccountHolder().getName());
//	}
//	
//	@Test
//	public void test_copyConstructor() {
//		Customer c = new Customer("Ada Lovelace", 41);
//		BankAccount b = new MockBankAccount(c, 150.0);
//		String expectedAccountNumber = b.getAccountNumber();
//		
//		BankAccount copy = new MockBankAccount(b);
//		
//		assertEquals("Unexpected balance in copy",150.0,copy.getBalance(), 0.00001);
//		assertEquals("Unexpected customer name in copy", "Ada Lovelace", copy.getAccountHolder().getName());
//		assertEquals("Unexpected customer id in copy", 41, copy.getAccountHolder().getID());
//		assertEquals("Unexpected account number in copy", expectedAccountNumber, copy.getAccountNumber());
//	}	
//	
//	@Test
//	public void test_copyConstructor_changeCustomerNameInOriginal() {
//		Customer c = new Customer("Ada Lovelace", 41);
//		BankAccount b = new MockBankAccount(c, 150.0);
//		
//		BankAccount copy = new MockBankAccount(b);
//		
//		c.setName("Name Changed");
//		
//		assertEquals("Unexpected customer name in copy", "Name Changed", copy.getAccountHolder().getName());
//	}	
//	
//	public void test_copyConstructor_changeCustomerInOriginal() {
//		Customer c = new Customer("Grace Hopper", 41);
//		BankAccount b = new MockBankAccount(c, 150.0);
//		
//		BankAccount copy = new MockBankAccount(b);
//		
//		b.setAccountHolder(new Customer("Created New Customer", 65));
//		
//		assertEquals("Unexpected customer name in copy", "Grace Hopper", copy.getAccountHolder().getName());
//	}	
//	
//	// Testing deposit
//	    
//	@Test
//    public void test_deposit() {
//        BankAccount b = new MockBankAccount();
//        b.deposit(10.25);
//        assertEquals("Deposited 10.25.", 10.25, b.getBalance(), 0.000001);
//    }
//    
//	@Test
//    public void test_deposit_negativeAmount() {
//        BankAccount b = new MockBankAccount();
//        b.deposit(-10.25);
//        assertEquals("Tried to deposit a negative amount, balance should remain unchanged.", 0.00, b.getBalance(), 0.000001);
//    }
//        
//    // testing withdraw
//	@Test
//    public void test_withdraw_sufficientBalance() {
//        BankAccount b = new MockBankAccount();
//        b.deposit(500.00);
//        b.withdraw(44.25);
//        assertEquals("Withdrew 44.25 after depositing 500.00", 455.75, b.getBalance(), 0.000001);
//    }
//    
//	@Test
//    public void test_withdraw_insufficientFunds() {
//        BankAccount b = new MockBankAccount();
//        b.deposit(5.00);
//        b.withdraw(5.01);
//        assertEquals("Withdrew 5.01 after depositing 5.00", 5.00, b.getBalance(), 0.000001);
//    }
//	
//	@Test
//    public void test_withdraw_negativeAmount() {
//        BankAccount b = new MockBankAccount();
//        b.deposit(5.00);
//        b.withdraw(-1.0);
//        assertEquals("Withdrew -1 after depositing 5.00 (nothing should happen)", 5.00, b.getBalance(), 0.000001);
//    }
//	
//	@Test
//    public void test_withdraw_entireBalance() {
//        BankAccount b = new MockBankAccount(5.00);
//        b.withdraw(5.00);
//        assertEquals("Withdrew 5.0 from account with start balance 5.0", 0.00, b.getBalance(), 0.000001);
//    }	
//	
//	@Test
//	public void test_transfer_moreThanSufficientFunds() {
//		BankAccount b = new MockBankAccount(new Customer("temp",1),1340.0);
//		BankAccount b2 = new MockBankAccount(new Customer("temp2",2),500.0);
//		b.transfer(1000,b2);
//        assertEquals("Transfered 1000 from account with 1340 balance to account with 500 balance.  Testing from account", 340.0, b.getBalance(), 0.000001);
//        assertEquals("Transfered 1000 from account with 1000 balance to account with 500 balance.  Testing to account", 1500.0, b2.getBalance(), 0.000001);
//		
//	}
//	
//	@Test
//	public void test_transfer_exactlySufficientFunds() {
//		BankAccount b = new MockBankAccount(new Customer("temp",1),1000.0);
//		BankAccount b2 = new MockBankAccount(new Customer("temp2",2),500.0);
//		b.transfer(1000,b2);
//        assertEquals("Transfered 1000 from account with 1000 balance to account with 500 balance.  Testing from account", 0.0, b.getBalance(), 0.000001);
//        assertEquals("Transfered 1000 from account with 1000 balance to account with 500 balance.  Testing to account", 1500.0, b2.getBalance(), 0.000001);
//		
//	}
//	
//	@Test
//	public void test_transfer_insufficientFunds() {
//		BankAccount b = new MockBankAccount(new Customer("temp",1),1000.0);
//		BankAccount b2 = new MockBankAccount(new Customer("temp2",2),500.0);
//		b.transfer(1001,b2);
//        assertEquals("Transfered 1001 from account with 1000 balance to account with 500 balance.  Testing from account", 1000.0, b.getBalance(), 0.000001);
//        assertEquals("Transfered 1001 from account with 1000 balance to account with 500 balance.  Testing to account", 500.0, b2.getBalance(), 0.000001);		
//	}
//	
//	
//	
//	@Test
//	public void test_toString() {
//		BankAccount b = new MockBankAccount(101.56, "3426");
//		b.setAccountHolder(new Customer("Alan Turing", 123));
//		assertEquals("Expected to string to return (<customer>) <account number>: <balance>", "(Alan Turing 123) 3426: 101.56", b.toString());
//	}
//	
//	@Test
//	public void test_monthEndUpdate_ZeroFees(){
//		MockBankAccount b = new MockBankAccount();
//		b.deposit(100.0);
//		b.monthEndUpdate();
//		assertEquals("Balance should be unchanged when fee and interest is 0.0", 100.0, b.getBalance(), 0.0000001);
//	}
//
//	@Test
//	public void test_monthEndUpdate_PositiveFeesAndInterest(){
//		MockBankAccount b = new MockBankAccount();
//		b.amount = 10.50;
//		b.deposit(100.0);
//		b.monthEndUpdate();
//		assertEquals("Balance should be increased when fee and interest is positive", 110.50, b.getBalance(), 0.0000001);
//	}
//
//	@Test
//	public void test_monthEndUpdate_NegativeFeesAndInterest(){
//		MockBankAccount b = new MockBankAccount();
//		b.amount = -2.35;
//		b.deposit(100.0);
//		b.monthEndUpdate();
//		assertEquals("Balance should be decreased when fee and interest is negative", 97.65, b.getBalance(), 0.0000001);
//	}
//
    
    @Test
    public void test_equals_sameIDDifferentBalance(){
    	MockBankAccount b1 = new MockBankAccount(100.00, "123");
    	MockBankAccount b2 = new MockBankAccount(101.00, "123");
    	
    	boolean actual = b1.equals(b2);
    	
    	assertTrue("Expected bank accounts with same ID to be equal, even if balance is different.", actual);
    	
    }

    @Test
    public void test_equals_differentID(){
    	MockBankAccount b1 = new MockBankAccount(100.00, "123");
    	MockBankAccount b2 = new MockBankAccount(100.00, "456");
    	
    	boolean actual = b1.equals(b2);
    	
    	assertFalse("Expected bank accounts with different ID with everything else the same to be different.", actual);
    	
    }

    @Test
    public void test_equals_differentObjectType(){
    	MockBankAccount b1 = new MockBankAccount(100.00, "123");
    	Integer x = 10;
    	
    	boolean actual = b1.equals(x);
    	
    	assertFalse("Expected bank account to be non-equal to Integer object.", actual);	
    }

    @Test
    public void test_hashCode_IDAllDigits(){
    	MockBankAccount b1 = new MockBankAccount(100.00, "123456");
    	
    	int actual = b1.hashCode();
    	
    	assertEquals("Expected bank account with ID 123456 to have hashCode same as ID", 123456, actual);	
    }

    @Test
    public void test_hashCode_IDAllNonDigits(){
    	MockBankAccount b1 = new MockBankAccount(100.00, "abcdef");
    	
    	int actual = b1.hashCode();
    	
    	assertEquals("Expected bank account with ID abcdef to have hashCode 0", 0, actual);	
    }

    @Test
    public void test_hashCode_IDDigitsAndNonDigits(){
    	MockBankAccount b1 = new MockBankAccount(100.00, "1ab3c56def2");
    	
    	int actual = b1.hashCode();
    	
    	assertEquals("Expected bank account with ID 1ab3c56def2 to have hashCode 13562", 13562, actual);	
    }

}