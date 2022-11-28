package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AmazonTestCase2  extends AmazonTestCase1 {
	
	public static By sortdropdown = By.xpath("//*[@id='a-autoid-0-announce']");

	public static By sortedelements = By.xpath("//span[@class='a-price-whole']");

	public static By sortselect = By.xpath("//a[@class='a-dropdown-link']");
	
	@Test
	public void VerifyVerifyAmazonTestCase2() throws InterruptedException
	{   SearchIPhone();
	driver.findElement(minPrice).sendKeys("25");
	driver.findElement(maxPrice).sendKeys("50");
	driver.findElement(submitPrice).click();
	driver.findElement(sortdropdown).click();

	//Cicking on Sort criteria dropdown "Price High to Low"
	  
	List <WebElement> options = driver.findElements(By.cssSelector(".a-dropdown-item"));
	for(WebElement option : options)
	   { 
		
		//Explicit wait for hidden element
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement sortcondition = wait.until(
				ExpectedConditions.visibilityOfElementLocated(sortselect));
		if(option.getText().equalsIgnoreCase("Price: High to Low"))
		   {
			option.click();
			break;
		   }
	   }
	
	//Verify the prices are sorted in High to Low price Range
	
	SortProductHightoLow();
	
    }
		
	
}
