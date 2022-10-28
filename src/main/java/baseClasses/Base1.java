package baseClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class Base1 {
	
		static WebDriver driver;
	
		public static WebDriver getDriver()
		{
			ChromeOptions options = new ChromeOptions();		// for removing notification pop-up
			options.addArguments("--disable-notifications");
			
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		
			driver.get("https://kite.zerodha.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
			return driver;
		}
	
		
	
	
	
	

}
