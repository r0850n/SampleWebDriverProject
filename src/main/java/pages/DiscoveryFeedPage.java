package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ent.Category;
import Ent.Radius;
import Ent.SortBy;

public class DiscoveryFeedPage {
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div[5]/div[1]/div[2]/div/div/div[4]/div[3]/form/div[1]/select")
	private WebElement activity;
	
	@FindBy(xpath="/html/body/div[5]/div[1]/div[2]/div/div/div[4]/div[3]/form/div[2]/select")
	private WebElement sortBy;
	
	@FindBy(xpath="/html/body/div[5]/div[1]/div[2]/div/div/div[4]/div[3]/form/div[4]/div[1]/select")
	private WebElement radius;
	
	@FindBy(xpath = "/html/body/div[5]/div[1]/div[2]/div/div/div[4]/div[3]/form/div[4]/div[2]/div/a")
	private WebElement imputLocation;
	
	@FindBy(xpath = "/html/body/div[51]/div/input")
	private WebElement imputLocationArea;
	
	@FindBy(id = "select2-drop")
	private WebElement searchResult;
	
	@FindBy(id="discoveryGrid")
	private WebElement discoveryGird;
	
	public WebElement getDiscoveryGird() {
		return discoveryGird;
	}
	public List<WebElement> discoveryGird() {
		List<WebElement> results = discoveryGird.findElements(By.className("box-container"));

		return results;

	}
	

	public WebElement getImputLocationArea() {
		return imputLocationArea;
	}

	public WebElement getImputLocation() {
		return imputLocation;
	}
	public void typeLocation(String location) {
		
		 getImputLocationArea().sendKeys(location);
	
	}
	public List<WebElement> localizationSearchResult() {
		List<WebElement> results = searchResult.findElements(By.tagName("li"));

		return results;

	}

	public WebElement getRadius() {
		return radius;
	}

	public WebElement getSortBy() {
		return sortBy;
	}

	public WebElement getActivity() {
		return activity;
	}

	public List<WebElement> getSportCategories() {

		List<WebElement> categ = activity.findElements(By
				.tagName("option"));
		return categ;
	}

	
	public WebElement getActivity(String category){
		
		for (WebElement element : getSportCategories()) {
            
			if(element.getText().equals(category)){
				return element;
			}
			
		}
		
		return null;		
	}

	public List<WebElement> getSortByOptions() {

		List<WebElement> categ = sortBy.findElements(By
				.tagName("option"));
		return categ;
	}

	
	public WebElement getSortBy(String option){
		
		for (WebElement element : getSortByOptions()) {
            
			if(element.getText().equals(option)){
				return element;
			}			
		}
		
		return null;		
	}
	public List<WebElement> getRadiusOption() {

		List<WebElement> categ = radius.findElements(By
				.tagName("option"));
		return categ;
	}

	
	public WebElement getRadius(String option){
		
		for (WebElement element : getRadiusOption()) {
            
			if(element.getText().equals(option)){
				return element;
			}			
		}
		
		return null;		
	}
	
	
	public void filterPlans(String activity, String sortBy,String radius,String location){
		 GocietyMainPage main = new GocietyMainPage(driver);
		 main.getPlans().click();
		 
		getActivity(activity).click();
		getSortBy(sortBy).click();
		getRadius(radius).click();
		
		getImputLocation().click();
		 
		getImputLocationArea().sendKeys(location);
		
		//localizationSearchResult().get(0).click();
	}

	public DiscoveryFeedPage(WebDriver driver) {
		super();
        this.driver=driver;
        PageFactory.initElements(driver, this);

	}

}
