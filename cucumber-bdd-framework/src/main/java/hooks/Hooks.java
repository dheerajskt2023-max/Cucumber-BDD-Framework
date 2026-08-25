package hooks;

import base_test.Base_class;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	@Before
	public void beforeScenario() {
		Base_class.setUp();
	}
	
	@After
	public void afterScenario() {
		Base_class.tearDown();
	}
}
