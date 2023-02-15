package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class utils {
	public static WebDriver driver;
	private static final Map<String, Supplier<WebDriver>>BROWSERPOOL = new HashMap<>();
	private final static Supplier<WebDriver>CHROME_BROWSER = () -> {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	};
	private final static Supplier<WebDriver>FIREFOX_BROWSER = () ->{
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	};
	private final static Supplier<WebDriver>EDGE_DRIVER = () -> {
		WebDriverManager.edgedriver().setup();
		return new EdgeDriver();
	};
	
	public static WebDriver browserFactory(){
		BROWSERPOOL.put("chrome",CHROME_BROWSER);
		BROWSERPOOL.put("firefox", FIREFOX_BROWSER);
		BROWSERPOOL.put("edge", EDGE_DRIVER);
		
		try{
			driver = BROWSERPOOL.get()n
		}catch(RuntimeException e){
		
		}
		
	}
}
