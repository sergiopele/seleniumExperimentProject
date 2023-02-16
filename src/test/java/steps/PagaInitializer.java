package steps;

import pages.HomePage;
import utils.Utils;

public class PagaInitializer extends Utils {
	static HomePage homePage = null;
	public static void initPages(){
		homePage = new HomePage();
	}
}
