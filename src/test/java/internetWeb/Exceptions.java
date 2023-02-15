package internetWeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exceptions {
	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/horizontal_slider");
		try{
			driver.switchTo().frame(0);
		}catch(NoSuchFrameException e){
			e.printStackTrace();
			throw new NoSuchFrameException("\n\n\n_____________NO SUCH Frame ON PAGE ______________\n\n\n");
		}finally {
			driver.quit();
		}
	}
}
