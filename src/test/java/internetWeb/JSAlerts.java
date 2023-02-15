package internetWeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlerts {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		WebElement jsAlert = driver.findElement(By.xpath("//*[contains(text(),'Click for JS Alert')]"));
		WebElement JSConfirm  = driver.findElement(By.xpath("//*[contains(text(),'Click for JS Confirm')]"));
		WebElement JSPrompt = driver.findElement(By.xpath("//*[contains(text(),'Click for JS Prompt')]"));
		
		jsAlert.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		JSConfirm.click();
		driver.switchTo().alert();
		String alertContext = alert.getText();
		alert.dismiss();
		JSPrompt.click();
		alert.sendKeys("It's me Mario");
		driver.quit();
		
	}
}
