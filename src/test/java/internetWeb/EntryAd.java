package internetWeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class EntryAd {
	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/entry_ad");
		driver.manage().window().maximize();
		WebElement modal = driver.findElement(By.xpath("//*[@class='modal']"));
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(modal));
		driver.findElement(By.xpath("//*[contains(text(),'Close')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'click here')]")).click();
		driver.quit();
	}
}
