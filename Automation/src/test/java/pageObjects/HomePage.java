package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By searchItem = By.xpath("//input[@type='search']");
	private By searchItemDisplyed = By.xpath("//h4[@class='product-name']");
	private By incrementItemQuantity = By.xpath("//a[@class='increment']");
	private By addSelectedItemToCart = By.xpath("//button[contains(text(),'ADD TO CART')]");
	private By cartButton = By.xpath("//img[contains(@src,'bag.png')]");
	private By checkoutbtn = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	
	
	public void searchForAnItemWith(String item)
	{
		driver.findElement(searchItem).sendKeys(item);
	}
	
	public void isSearchResultDisplayed(String item)
	{
		Assert.assertTrue(driver.findElement(searchItemDisplyed).getText().contains(item));
	}
	
	public void incrementItemQuantity()
	{
		driver.findElement(incrementItemQuantity).click();
	}
	
	public void addToCart()
	{
		driver.findElement(addSelectedItemToCart).click();
	}
	
	public void clickOnCartButton()
	{
		driver.findElement(cartButton);
	}

	public void proccedTocheckOutPage()
	{
		driver.findElement(checkoutbtn).click();
	}
}
