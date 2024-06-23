package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import runners.Selectors;
import stepdefinitions.Runners.Hooks;

@RunWith(SerenityRunner.class)
public class PriceCheckingStepDefs extends Selectors {
    @Step
    @When("I click Back to products")
    public void i_click_back_to_products() {
        Hooks.driver.findElement(By.cssSelector(BACK_TO_PRODUCTS_BUTTON)).click();
    }

    @Step
    @Then("I should see the value of $7.99")
    public void i_should_see_the_value_of_product() {

        WebElement onesiePrice = Hooks.driver.findElement(By.cssSelector(ONESIE_PRICE));
        // Assert that the element is visible
        String actualPrice = onesiePrice.getText().trim();

        // Assert the actual price text matches the expected price
        Assert.assertEquals("Expected product price to be $7.99, but found: " + actualPrice, "$7.99", actualPrice);
    }
}