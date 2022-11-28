package test;

import java.time.temporal.ValueRange;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTestCase1 extends Base {



public  static By electronicsDropdown = By.xpath("//select[@id='searchDropdownBox']");
public static By cellPhones = By.xpath("//div[contains(text(),'Cell Phones & Accessories')]");
public static By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");
public static By searchButton = By.xpath("//input[@value='Go']");
public static By minPrice = By.xpath("//input[@id='low-price']");
public static By maxPrice = By.xpath("//input[@id='high-price']");
public static By submitPrice = By.xpath("(//input[@type='submit'])[2]");
public static By itemPrice = By.xpath("//span[@class='a-price-whole']");
public static By featuredBrands = By.xpath("//li[@aria-label='ZAGG']/span/a/div/label/input/following-sibling::i");
public static By sortdropdown = By.xpath("//*[@id='a-autoid-0-announce']");

public static By sortedelements = By.xpath("//span[@class='a-price-whole']");

public static By sortselect = By.xpath("//a[@class='a-dropdown-link']");
 
	
	
	public  static void SearchIPhone() throws InterruptedException
	{
	
		
		//Selecting dropdown Electronics
		WebElement dropdown = driver.findElement(electronicsDropdown);
		Select select = new Select(dropdown);
		select.selectByVisibleText("Electronics");
		//Enter search criteria on search box and click search icon
		driver.findElement(searchBox).sendKeys("iPhone 14");// Searching iphone
		driver.findElement(searchButton).click();
		
	}
	//User selects featured brand and enters price range 
	
	
	public static void SearchbyPriceRange()
	
	{
		driver.findElement(featuredBrands).click();
		driver.findElement(minPrice).sendKeys("10");
		driver.findElement(maxPrice).sendKeys("30");
		driver.findElement(submitPrice).click();
		
		//Storing Price of all items in a list
		List <WebElement> element =  driver.findElements(itemPrice);
		
		for(int i=0;i<element.size();i++)
		{
			String price = driver.findElement(By.cssSelector(".a-price-whole")).getText();
			
			int j=Integer.parseInt(price);  
			
			if (ValueRange.of(10, 30).isValidIntValue(j)) 
			   {
			    System.out.println("Price is with in the Range of 10$-30$.");
			   } 
			else 
				{
			    System.out.println("Price is out of the Range of 10$-30$");
			    break;
				}
			
		}
	}
	
	public void SortProductHightoLow()
	{
		//Capturing all webelements
		
		List<WebElement> priceList = driver.findElements(sortedelements);
		
		//Capture text of all prices in a new original list
		
		List<String> originalList = priceList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort on original list 
		
		List<String> sortedList = originalList.stream().collect(Collectors.toList());
		
		Collections.reverse(sortedList);
		Assert.assertTrue(originalList.equals(sortedList));
	}
		
	
	//@Test
	public void VerifyAmazonTestCase1() throws InterruptedException
	{
		SearchIPhone();
		SearchbyPriceRange();
	}
	
	
	
		public void scrollPage() {
			
			//Scroll
			JavascriptExecutor js = (JavascriptExecutor)driver;		
			js.executeScript("window.scrollBy(0,window.innerHeight)");
			//js.executeScript("document.querySelector(\"div.tableFixHead\").scrollTop=500");

		}
		
		
	}

