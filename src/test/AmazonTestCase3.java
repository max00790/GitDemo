package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTestCase3 extends AmazonTestCase1 {

	
	public static By item = By.xpath("(//span[contains(text(),'ZAGG InvisibleShield Glass Elite')])[1]");
	
	public static By addtoCart = By.xpath("//span[contains(text(),' Add both to Cart ')]");
	
	public static By gotoCart = By.xpath("//*[@id='sw-gtc']/span/a");
	
	public static By email = By.xpath("//*[@id=\"ap_email\"]");
	
	public static By proceedtoCheckout = By.xpath("//*[@id='sc-buy-box-ptc-button']/span/input");
	
	@Test
	public void AddtoCart() throws InterruptedException
	{
		SearchIPhone();
		driver.findElement(minPrice).sendKeys("25");
		driver.findElement(maxPrice).sendKeys("50");
		driver.findElement(submitPrice).click();
		
		scrollPage();
		driver.findElement(addtoCart).click();
		driver.findElement(gotoCart).click();
		driver.findElement(proceedtoCheckout).click();
		Assert.assertTrue(driver.findElement(email).isDisplayed());
		
	}
}
