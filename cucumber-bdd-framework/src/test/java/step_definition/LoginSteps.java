package step_definition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver driver;
	
	@Given("Browser is opened")
	public void browser_is_opened() {
		// Launch Chrome browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		 // Open SauceDemo
        driver.get("https://www.saucedemo.com/");
	}

	@When("User enters valid creds")
	public void user_enters_valid_creds() {
        // Hardcoded valid credentials
        String username = "standard_user";
        String password = "secret_sauce";

        // Enter username
        driver.findElement(By.id("user-name")).sendKeys(username);

        // Enter password
        driver.findElement(By.id("password")).sendKeys(password);
	}
	
	
	@When("User enters invalid creds")
	public void user_enters_invalid_creds() {
        // Hardcoded valid credentials
        String username = "locked_out_user";
        String password = "secret_sauce";

        // Enter username
        driver.findElement(By.id("user-name")).sendKeys(username);

        // Enter password
        driver.findElement(By.id("password")).sendKeys(password);
	}

	@And("User clicks on login_button")
	public void user_clicks_on_login_button() {
        // Click Login button
        driver.findElement(By.id("login-button")).click();
	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
	      // Verify successful login
        String currentUrl = driver.getCurrentUrl();
        
        Assert.assertTrue(currentUrl.contains("inventory"));
	}
	
	@Then("User should not be logged in successfully")
	public void user_should_not_be_logged_in_successfully() {
	      // Verify successful login
        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse(currentUrl.contains("inventory"));
	}

	@And("Browser should be closed")
	public void browser_should_be_closed() {
        // Close browser
        driver.quit();
	}

}
