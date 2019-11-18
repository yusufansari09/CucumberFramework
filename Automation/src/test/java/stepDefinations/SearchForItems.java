package stepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;


import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Cucumber.Automation.Base;

@RunWith(Cucumber.class)
public class SearchForItems {

	public WebDriver driver;
	HomePage onHomePage;
	CheckOutPage onCheckOutPage;
	
    @Given("^User is on Greencart Landing page$")
    public void user_is_on_greencart_landing_page() throws Throwable {
    	driver = Base.getDriver();
    }

    @When("^User searched for (.+) vegetable$")
    public void user_searched_for_vegetable(String strArg1) throws Throwable {
    	onHomePage.searchForAnItemWith(strArg1);
    	Thread.sleep(3000);
    }

    @Then("^\"([^\"]*)\" results are displaed$")
    public void something_results_are_displaed(String strArg1) throws Throwable {
    	onHomePage.isSearchResultDisplayed(strArg1);
    }
    
//    @Then("^verify that selected \"([^\"]*)\" is displayed in checkout page$")
//    public void verify_that_selected_something_is_displayed_in_checkout_page(String strArg1) throws Throwable {
//    	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='product-name']")).getText().contains(strArg1));
//    }

    @And("^added items to cart$")
    public void added_items_to_cart() throws Throwable {
    	onHomePage.incrementItemQuantity();
    	onHomePage.addToCart();
    }

    @And("^User proceed to checkout page for purchase$")
    public void user_proceed_to_checkout_page_for_purchase() throws Throwable {
    	onHomePage.clickOnCartButton();
    	onHomePage.proccedTocheckOutPage();
    }
    
    @Then("^verify that selected (.+) is displayed in checkout page$")
    public void verify_that_selected_is_displayed_in_checkout_page(String selectedItem) throws Throwable {
    	onCheckOutPage.productMatchesSelectedItem(selectedItem);
    }

}
