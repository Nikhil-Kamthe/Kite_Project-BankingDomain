package pomClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.Util1;

public class FundPage extends Util1 {
	
	WebDriver driver;
	
	@FindBy(xpath = "//button[@type='button']")
	private static WebElement addFundsBtn;
	
	@FindBy(xpath = "//h1[text()='Deposit funds']")
	private static WebElement depositFundText;
	
	@FindBy(xpath = "//input[@placeholder='Enter amount']")
	private static WebElement amount;
	
	@FindBy(xpath = "//input[@name='vpa']")
	private static WebElement upiID;
	
	@FindBy(xpath = "//button[@type='submit']")
	private static WebElement continueBtn;
	
	@FindBy(xpath = "//p[text()='Transaction declined by customer.']")
	private static WebElement paymentDeclineMsg;
	
	
	public FundPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		}
	
	public void clickOnAddFunds(){
		
		explicitWait(driver, 10, addFundsBtn);
		addFundsBtn.click();
		
		List<String> address = getWindowList(driver);
		driver.switchTo().window(address.get(1));	
	}
	
	public String checkUserIsOnDepositFundWindow() {
		return depositFundText.getText();
	}
	
	public void enterAmount() throws IOException {
		explicitWait(driver, 5, amount);
		amount.sendKeys(getConfigData("amount"));
	}	
	
	public void enterUPIID() throws IOException {
		explicitWait(driver, 5, upiID);
		upiID.clear();
		upiID.sendKeys(getConfigData("UPIID"));	
	}

	public void hitContinueBtn() throws IOException {	
		continueBtn.click();
	}	
		
	public String paymentDeclineMsg() {
		explicitWait(driver, 10, paymentDeclineMsg);
		return paymentDeclineMsg.getText();
	}
	
}
