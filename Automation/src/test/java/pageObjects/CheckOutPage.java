package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	
	public WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		this.driver = driver;
	}

	By productname = By.xpath("//p[@class='product-name']");
	
	public void productMatchesSelectedItem(String selectedItem)
	{
		Assert.assertTrue(driver.findElement(productname).getText().contains(selectedItem));
	}
}
