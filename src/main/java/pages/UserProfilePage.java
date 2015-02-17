package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfilePage {
	
	@FindBy(id="logoutButton")
	private WebElement logOutButton;
	
	@FindBy(id="buttonYes")
	private WebElement signOut;
	
	@FindBy(xpath="/html/body/div[5]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/ul/li[2]/a")
	private WebElement plans;
	
	@FindBy(xpath="/html/body/div[5]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/ul/li[3]/a")
	private WebElement tripReports;
	
	
	@FindBy(css="html body#body.fbinitialized div#pageDiscoveryFeed.app-page.withMenuPanel.active-page div.contentWrapper div.newHeader div.headerFlex div.whiteBgBox div.container div.nav-menu")
	private WebElement mainNav;
	
	public WebElement getPlans() {
		return plans;
	}


	public WebElement getTripReports() {
		return tripReports;
	}


	public WebElement getSignOut() {
		return signOut;
	}


	public WebElement getLogOutButton() {
		return logOutButton;
	}


	public List<WebElement> getNawMenu(){
		
		System.out.println(mainNav.getText());
		List<WebElement> links= mainNav.findElements(By.tagName("li"));
		return links;

	}
	
	
	private WebDriver driver;
	
	
	public UserProfilePage(WebDriver driver){
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

}
