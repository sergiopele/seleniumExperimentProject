package steps;

import org.junit.After;
import org.junit.Before;

import static utils.Utils.openBrowser;
import static utils.Utils.quitBrowser;

public class Hooks {
	@Before
	public void beforeTest() {
		openBrowser();
	}
	
	@After
	public void afterTest() {
		quitBrowser();
	}
}
