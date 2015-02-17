package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetRandomLorum {
	
	
	WebDriver driver;
	

	@FindBy(id="tekst")
	private WebElement tekst;
	
	@FindBy(id="submit")
	private WebElement generuj;
	
	@FindBy(xpath="/html/body/div[2]/div[1]/div[4]/textarea")
	private WebElement ranText;
	
	List<WebElement> getTekst(){
		
		driver.get("http://lipsum.pl/index.php");
		List<WebElement> teksty= tekst.findElements(By.tagName("option"));
		return teksty;
				
	}
	
	
	public String dajRandoma(){
		getTekst().get(2).click();
		
		generuj.click();
		
		String tekst= ranText.getText();
		
		return tekst;
		
		
	}
	
	public GetRandomLorum(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

}
