package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageSchowProfile {
	
	
	private WebDriver driver;

	public PageSchowProfile(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

}
 