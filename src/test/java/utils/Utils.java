package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Utils {
	public static WebDriver driver;
	private static final Map<String, Supplier<WebDriver>> BROWSERPOOL = new HashMap<>();
	private final static Supplier<WebDriver> CHROME_BROWSER = () -> {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	};
	private final static Supplier<WebDriver> FIREFOX_BROWSER = () -> {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	};
	private final static Supplier<WebDriver> EDGE_BROWSE = () -> {
		WebDriverManager.edgedriver().setup();
		return new EdgeDriver();
	};
	
	private static void browserFactory() {
		BROWSERPOOL.put("chrome", CHROME_BROWSER);
		BROWSERPOOL.put("firefox", FIREFOX_BROWSER);
		BROWSERPOOL.put("edge", EDGE_BROWSE);
		ConfigReader.readProperties(Constants.CONFIG_FILE_PATH);
		try {
			driver = BROWSERPOOL
					.get(ConfigReader.getProperty(KeyWord.browser.toString()))
					.get();
		} catch (RuntimeException e) {
			throw new RuntimeException("\n\n___NO SUCH BROWSER IN DIRECTORY___\n\n");
		}
	}
	
	public static void openBrowser() {
		browserFactory();
		driver.get(ConfigReader.getProperty(KeyWord.url.toString()));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
}
