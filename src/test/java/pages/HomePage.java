package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import java.util.List;

public class HomePage extends Utils {
	@FindBy(xpath = "//*/ul/li/a")
	private List<WebElement>homePageCategoryList;
	public HomePage(){
		PageFactory.initElements(driver,this);
	}
}
