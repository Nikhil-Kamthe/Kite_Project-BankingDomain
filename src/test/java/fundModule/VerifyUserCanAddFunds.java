package fundModule;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.Base1;
import pomClasses.FundPage;
import pomClasses.HomePage;
import pomClasses.LoginPage;


public class VerifyUserCanAddFunds {

	WebDriver driver ;
	LoginPage lp;
	HomePage hp;
	FundPage fp;
	
	@BeforeClass
	public void beforeClass() {
		driver = Base1.getDriver();
	}

	@BeforeMethod
	public void beforeMethod() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		fp = new FundPage(driver);
		
	}
	
	@Test (priority=1)
	public void verifyUserCanLogin() throws IOException {
		lp.enterUserID();
		lp.enterPassword();
		lp.clickSubmitBtn();
		
		Assert.assertTrue(hp.checkForHomePage());   
			
	}
	
	@Test (priority=2, dependsOnMethods="verifyUserCanLogin")
	public void verifyUserCanClickOnFunds() {
		
		String addFundText = hp.clickOnFundText();
		Assert.assertEquals(addFundText, "Add funds", "User is not on Fund Page");
		fp.clickOnAddFunds();
		
		String depositFundWindow = fp.checkUserIsOnDepositFundWindow();
		Assert.assertEquals(depositFundWindow, "Deposit funds","User is not on DepositFund Window");	
	}
	
	@Test (priority=3)
	public void verifyUserCanAddFunds() throws IOException, InterruptedException {
		
		fp.enterAmount();
		fp.enterUPIID();
		fp.hitContinueBtn();

		Thread.sleep(30000);
		String msg = fp.paymentDeclineMsg();
		
		Assert.assertEquals(msg, "Transaction declined by customer.");
		System.out.println("User added funds successfully");
	}
	
	
	@AfterMethod
	public void afterMethod() {
		
	}
	
	@AfterClass
	public void afterClass() {
		
	}
	
}
