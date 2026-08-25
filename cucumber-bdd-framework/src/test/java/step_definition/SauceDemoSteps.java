package step_definition;

import org.openqa.selenium.By;
import org.testng.Assert;

import base_test.Base_class;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoSteps extends Base_class{

	@When("User enters valid creds")
	public void user_enters_valid_creds() {
		String username = "standard_user";
		String password = "secret_sauce";

		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("User enters invalid creds")
	public void user_enters_invalid_creds() {
		String username = "locked_out_user";
		String password = "secret_sauce";

		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@And("User clicks on login_button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.id("login-button")).click();
	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		String currentUrl = driver.getCurrentUrl();

		Assert.assertTrue(currentUrl.contains("inventory"));
	}

	@Then("User should not be logged in successfully")
	public void user_should_not_be_logged_in_successfully() {
		String currentUrl = driver.getCurrentUrl();

		Assert.assertFalse(currentUrl.contains("inventory"));
	}

	@When("User logs in with valid credentials")
	public void user_logs_in_with_valid_credentials() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
	}

	@When("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("User selects a product")
	public void user_selects_a_product() {
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	}

	@When("User adds the product to the cart")
	public void user_adds_the_product_to_the_cart() {
		// Verify that the product was added to the cart
		String cartCount = driver.findElement(By.className("shopping_cart_badge")).getText();
		Assert.assertEquals(cartCount, "1");
	}

	@When("User opens the shopping cart")
	public void user_opens_the_shopping_cart() {
		driver.findElement(By.className("shopping_cart_link")).click();

		Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
	}

	@When("User clicks on checkout_button")
	public void user_clicks_on_checkout_button() {
		driver.findElement(By.id("checkout")).click();

		Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one"));
	}

	@When("User enters valid checkout information")
	public void user_enters_valid_checkout_information() {
		driver.findElement(By.id("first-name")).sendKeys("John");
		driver.findElement(By.id("last-name")).sendKeys("Doe");
		driver.findElement(By.id("postal-code")).sendKeys("201301");
	}

	@When("User clicks on continue_button")
	public void user_clicks_on_continue_button() {
		driver.findElement(By.id("continue")).click();

		Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"));
	}

	@When("User clicks on finish_button")
	public void user_clicks_on_finish_button() {
		driver.findElement(By.id("finish")).click();
	}

	@Then("User should see the order confirmation message")
	public void user_should_see_the_order_confirmation_message() {
		String confirmationMessage = driver.findElement(By.className("complete-header")).getText();
		Assert.assertEquals(confirmationMessage, "Thank you for your order!");
	}


}