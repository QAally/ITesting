package UIAPI.Testing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;



public class CustomerTest {

	@Test(priority = 1, enabled =true)
	public void testDepositAmountForFirstCustomer() throws Exception {
		
		
		SeleniumClient.instance().setBrowser("chrome", "/Users/jaynit/Desktop/webDrivers/chrome/chromedriver");
		DepositHelper.instance().clickCustomerLogin();
		DepositHelper.instance().selectUser("Hermoine Granger");
		Thread.sleep(2000);
		DepositHelper.instance().clickLogin();
		DepositHelper.instance().clickDeposit();
		DepositHelper.instance().enterAmount("1500");
		Thread.sleep(2000);
		DepositHelper.instance().clickButton();
		assertEquals(DepositHelper.instance().getMessage(), "Deposit Successful");
		DepositHelper.instance().clickLogout();
		SeleniumClient.instance().closeBrowser();

	}
	

	@Test(priority = 1, enabled = true)
	public void testDepositAmountForEachCustomer() throws Exception {
		
		
		SeleniumClient.instance().setBrowser("chrome", "/Users/jaynit/Desktop/webDrivers/chrome/chromedriver");
		DepositHelper.instance().clickCustomerLogin();
		DepositHelper.instance().selectUser("Hermoine Granger");
		Thread.sleep(2000);
		DepositHelper.instance().clickLogin();
		DepositHelper.instance().clickDeposit();
		DepositHelper.instance().enterAmount("1500");
		Thread.sleep(2000);
		DepositHelper.instance().clickButton();
		assertEquals(DepositHelper.instance().getMessage(), "Deposit Successful");
		DepositHelper.instance().clickLogout();
		DepositHelper.instance().selectUser("Harry Potter");
		Thread.sleep(2000);
		DepositHelper.instance().clickLogin();
		DepositHelper.instance().clickDeposit();
		DepositHelper.instance().enterAmount("1500");
		Thread.sleep(2000);
		DepositHelper.instance().clickButton();
		assertEquals(DepositHelper.instance().getMessage(), "Deposit Successful");
		DepositHelper.instance().clickLogout();
		DepositHelper.instance().selectUser("Ron Weasly");
		Thread.sleep(2000);
		DepositHelper.instance().clickLogin();
		DepositHelper.instance().clickDeposit();
		DepositHelper.instance().enterAmount("1500");
		Thread.sleep(2000);
		DepositHelper.instance().clickButton();
		assertEquals(DepositHelper.instance().getMessage(), "Deposit Successful");
		DepositHelper.instance().clickLogout();
		DepositHelper.instance().selectUser("Albus Dumbledore");
		Thread.sleep(2000);
		DepositHelper.instance().clickLogin();
		DepositHelper.instance().clickDeposit();
		DepositHelper.instance().enterAmount("1500");
		Thread.sleep(2000);
		DepositHelper.instance().clickButton();
		assertEquals(DepositHelper.instance().getMessage(), "Deposit Successful");
		DepositHelper.instance().clickLogout();
		DepositHelper.instance().selectUser("Neville Longbottom");
		Thread.sleep(2000);
		DepositHelper.instance().clickLogin();
		DepositHelper.instance().clickDeposit();
		DepositHelper.instance().enterAmount("1500");
		Thread.sleep(2000);
		DepositHelper.instance().clickButton();
		assertEquals(DepositHelper.instance().getMessage(), "Deposit Successful");
		DepositHelper.instance().clickLogout();
		SeleniumClient.instance().closeBrowser();
	}
	
	@Test(priority = 1, enabled =true)
	public void testDepositAmountAndWithdrawlForFirstCustomer() throws Exception {
		
		
		SeleniumClient.instance().setBrowser("chrome", "/Users/jaynit/Desktop/webDrivers/chrome/chromedriver");
		DepositHelper.instance().clickCustomerLogin();
		DepositHelper.instance().selectUser("Hermoine Granger");
		Thread.sleep(2000);
		DepositHelper.instance().clickLogin();
		DepositHelper.instance().clickDeposit();
		String amt = DepositHelper.instance().getBalance();
		DepositHelper.instance().enterAmount("31459");
		Thread.sleep(2000);
		DepositHelper.instance().clickButton();
		assertEquals(DepositHelper.instance().getMessage(), "Deposit Successful");
		DepositHelper.instance().refresh();
		DepositHelper.instance().clickTransaction();
		Thread.sleep(5000);
		DepositHelper.instance().editStartDate();
		
		int size = DepositHelper.instance().getAllTransactionNumber();
		assertEquals(DepositHelper.instance().getTransactionRow(size-1).findElements(By.cssSelector("td")).get(1).getText(), "31459");
		assertEquals(DepositHelper.instance().getTransactionRow(size-1).findElements(By.cssSelector("td")).get(2).getText(), "Credit");
		DepositHelper.instance().clickBack();
		DepositHelper.instance().clickWithdrwal();
		DepositHelper.instance().enterAmount("31459");
		DepositHelper.instance().clickButton();
		assertEquals(DepositHelper.instance().getMessage(), "Transaction successful");
		assertEquals(DepositHelper.instance().getBalance(), amt);
		DepositHelper.instance().refresh();
		DepositHelper.instance().clickTransaction();
		DepositHelper.instance().editStartDate();
		size = DepositHelper.instance().getAllTransactionNumber();
		assertEquals(DepositHelper.instance().getTransactionRow(size-1).findElements(By.cssSelector("td")).get(1).getText(), "31459");
		assertEquals(DepositHelper.instance().getTransactionRow(size-1).findElements(By.cssSelector("td")).get(2).getText(), "Debit");
		SeleniumClient.instance().closeBrowser();
	}
	
	@Test(priority = 1, enabled =true)
	public void testDepositAmountAndWithdrawlForDynamicCustomer() throws Exception {
		
		
		SeleniumClient.instance().setBrowser("chrome", "/Users/jaynit/Desktop/webDrivers/chrome/chromedriver");
		DepositHelper.instance().clickCustomerLogin();
		DepositHelper.instance().selectUser(ReadData.readDataFromPropertyFile("userName"));
		Thread.sleep(2000);
		DepositHelper.instance().clickLogin();
		DepositHelper.instance().clickDeposit();
		String depositAmt = ReadData.readDataFromPropertyFile("AmountDeposit");
		DepositHelper.instance().enterAmount(depositAmt);
		Thread.sleep(2000);
		DepositHelper.instance().clickButton();
		assertEquals(DepositHelper.instance().getMessage(), "Deposit Successful");
		DepositHelper.instance().clickWithdrwal();
		String withdrawAmt = ReadData.readDataFromPropertyFile("AmountWithdrawl");
		Thread.sleep(2000);
		DepositHelper.instance().enterAmount(withdrawAmt);
		DepositHelper.instance().clickButton();
		assertEquals(DepositHelper.instance().getMessage(), "Transaction successful");
	
		SeleniumClient.instance().closeBrowser();
		
		
	}
	

}
