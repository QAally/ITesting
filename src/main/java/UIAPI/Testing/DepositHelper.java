package UIAPI.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class DepositHelper extends SeleniumBase {

	private static DepositHelper _instance = new DepositHelper();
	private static boolean instanceLogged = false;
	
	public By customerLogin = By.cssSelector("button.btn-primary");
	public By selectCustomer = By.id("userSelect");
	public By button = By.cssSelector("button.btn-default");
	public By transactionButton = By.cssSelector("button[ng-class='btnClass1']");
	public By depositButton = By.cssSelector("button[ng-class='btnClass2']");
	public By withdrawlButton = By.cssSelector("button[ng-class='btnClass3']");
	public By amount = By.cssSelector("input[ng-model='amount']");
	public By back = By.cssSelector("button[ng-click='back()']");
	public By logout = By.cssSelector("button[ng-show='logout']");
	public By accountDetails = By.cssSelector("strong[class='ng-binding']");
	public By message = By.cssSelector("span[ng-show='message']");
	public By table = By.cssSelector("table.table  tr[id*='anchor']");
	
	
	public static DepositHelper instance() {

		if (!instanceLogged) {
			instanceLogged = true;
			LogHelper.instance().setInfo("DepositHelper::instance(): Singleton created.");

		}
		return _instance;
	}

	public void clickCustomerLogin() {
		click(customerLogin);
	}
	
	public void selectUser(String name) {
		waitUntilElementIsDisplayed(selectCustomer, 5);
		Select elm = new Select(findElement(selectCustomer));
		elm.selectByVisibleText(name);
	}
	
	
	public void clickLogin() {
		waitUntilElementIsDisplayed(button, 5);
		click(button);
	}
	
	public void clickButton() {
		waitUntilElementIsDisplayed(button, 5);
		click(button);
	}
	
	public void clickLogout() {
		click(logout);
	}
	
	public void clickTransaction() {
		waitUntilElementIsDisplayed(transactionButton, 5);
		click(transactionButton);
		
	}
	
	By startDate = By.cssSelector("input#start");
	public void editStartDate() {
		waitUntilElementIsDisplayed(startDate, 5);
		type(startDate, "2021-07-24");
	}
	public void clickDeposit() {
		waitUntilElementIsDisplayed(depositButton, 5);
		click(depositButton);
	}
	
	public void clickWithdrwal() {
		waitUntilElementIsDisplayed(withdrawlButton, 5);
		click(withdrawlButton);
	}
	
	public void enterAmount(String amt) {
		waitUntilElementIsDisplayed(amount, 5);
		type(amount, amt);
	}
	
	public String getAccountNumber() {
		return findElements(accountDetails).get(0).getText();
	}
	
	public String getBalance() {
		return findElements(accountDetails).get(1).getText();
	}
	
	public String getCurrency() {
		return findElements(accountDetails).get(2).getText();
	}
	
	public void refresh() {
		SeleniumClient.instance().getBrowser().navigate().refresh();
	}
	
	public void clickBack() {
		waitUntilElementIsDisplayed(back, 5);
		click(back);
	}
	public String getMessage() throws Exception {
		waitUntilElementIsDisplayed(message, 5);
		return getText(message);
		
	}
	
	public int getAllTransactionNumber() {
		waitUntilElementIsDisplayed(table, 5);
		return findElements(table).size();
	}
	
	public WebElement getTransactionRow(int i) throws InterruptedException {
		Thread.sleep(3000);
		waitUntilElementIsDisplayed(table, 5);
		return findElements(table).get(i);
	}
}
