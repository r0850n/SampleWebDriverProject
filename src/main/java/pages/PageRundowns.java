package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageRundowns {
	
	private WebDriver driver;
	
	public PageRundowns(WebDriver driver){
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

}
