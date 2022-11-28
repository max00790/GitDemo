package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Base {

	public static WebDriver driver;
	@BeforeMethod
	public void launchAmzon() throws InterruptedException
	{ 
		//Defining Web Driver
		System.setProperty("webdriver.chrome.driver", "D:\\Project\\Eclipse\\chromedriver.exe");
		
		driver  = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); // Implementing Implicit wait
		
		driver.get("https://www.amazon.com"); //  Launching amazon web url
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();
	}
}
