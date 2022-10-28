package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.Util1;

public class HomePage extends Util1 {

	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Dashboard']")
	private static WebElement Dashboard;
	
	@FindBy(xpath = "//span[text()='Funds']")
	private static WebElement FundModule;
	
	@FindBy(xpath = "//button[@type='button']")
	private static WebElement addFundsBtn;
	

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public boolean checkForHomePage() {
		
		try {
			explicitWait(driver, 15, Dashboard);
			System.out.println("User is successfully login");
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public String clickOnFundText() {
		FundModule.click();
		explicitWait(driver, 10, addFundsBtn);
		
		return addFundsBtn.getText();
	}
}
