Feature: search and Place order for Vegetables

@SeleniumTest
Scenario: Search for items and validate results 
Given User is on Greencart Landing page
When User searched for "Cucumber" vegetable
Then "Cucumber" results are displaed
 
@SeleniumTest
Scenario: Search for items and then move to checkout page 
Given User is on Greencart Landing page
When User searched for "Brinjal" vegetable
And added items to cart
And User proceed to checkout page for purchase
Then verify that selected "Brinjal" is displayed in checkout page