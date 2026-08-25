package base_test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base_class {
	public static WebDriver driver;

	public static void setUp() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.saucedemo.com/");
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
