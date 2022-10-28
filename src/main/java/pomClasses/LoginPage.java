package pomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v102.runtime.Runtime.GetPropertiesResponse;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.Util1;

public class LoginPage extends Util1{

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
	
	public void enterUserID() throws IOException{
		userID.sendKeys(getConfigData("userID"));
	}
	
	public void enterPassword() throws IOException{
		password.sendKeys(getConfigData("password"));
	}
	
	public void clickSubmitBtn(){
		submitBtn.click();
	}
	
	
}
