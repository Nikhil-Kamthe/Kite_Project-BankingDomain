package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@id='userid']")
	private WebElement userID;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	
	
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void enterUserID(){
		userID.sendKeys(null);
	}
	
	public void enterPassword(){
		password.sendKeys(null);
	}
	
	public void clickSubmitBtn(){
		submitBtn.sendKeys(null);
	}
	
	
}
