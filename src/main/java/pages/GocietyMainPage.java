package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GocietyMainPage {
	private static final String MAIN_PAGE = "http://desktop.it-sandbox.gociety.com/#!pageMain";

	@FindBy(xpath = "/html/body/div[6]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/form/div[1]/select")
	private WebElement selectActivity;

	@FindBy(xpath = "/html/body/div[6]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/select")
	private WebElement sortByButton;

	@FindBy(xpath = "/html/body/div[6]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/form/div[4]/select")
	private WebElement locationWithin;

	@FindBy(xpath = "/html/body/div[6]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/select")
	private WebElement orderBySelect;

	// @FindBy(xpath =
	// "/html/body/div[6]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/form/div[4]/div/a/div/b")
	@FindBy(id = "s2id_autogen13")
	private WebElement imputLocation;

	@FindBy(css = "html body#body.fbinitialized div#select2-drop.select2-drop.select2-with-searchbox.select2-drop-active div.select2-search")
	private WebElement imputLocationsendKey;

	@FindBy(css = "html body#body div#select2-drop.select2-drop.select2-with-searchbox.select2-drop-active ul.select2-results")
	private WebElement searchResult;

	@FindBy(className = "firstNameTopMenu")
	private WebElement welcomText;

	// Menu
	@FindBy(className = "nav-menu")
	private WebElement navMenu;

	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/ul/li[1]/a/i")
	private WebElement home;

	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/ul/li[2]/a")
	private WebElement plans;

	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/ul/li[3]/a")
	private WebElement tripReports;

	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/ul/li[4]/a")
	private WebElement community;

	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/ul/li[5]/a")
	private WebElement myGociety;

	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/ul/li[6]/a")
	private WebElement inbox;

	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/ul/li[7]/a")
	private WebElement notifications;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/form/div[1]/select")
	private WebElement activity;

	
	@FindBy(xpath="/html/body/div[6]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/select")
	private WebElement sortBy;
	
	@FindBy(id="makePlanBtn")
	private WebElement makePlanButton;
	
	@FindBy(css="div.dataB.wrapLetter")
	private WebElement latestAddedPlan;
	
	public WebElement getLatestAddedPlan() {
		
		return latestAddedPlan;
	}

	public WebElement getMakePlanButton() {
		return makePlanButton;
	}

	public WebElement getSortBy() {
		return sortBy;
	}

	public WebElement getActivity() {
		return activity;
	}

	public WebElement getNotifications() {
		return notifications;
	}

	public void setNotifications(WebElement notifications) {
		this.notifications = notifications;
	}

	public WebElement getMyGociety() {
		return myGociety;
	}

	public WebElement getInbox() {
		return inbox;
	}

	public WebElement getTripReports() {
		return tripReports;
	}

	public WebElement getHome() {
		return home;
	}

	public WebElement getPlans() {
		driver.get(MAIN_PAGE);
		return plans;
	}

	public WebElement getCommunity() {
		return community;
	}

	public WebElement getNavMenu() {
		return navMenu;
	}

	public WebElement getWelcomText() {
		return welcomText;
	}

	public WebElement getSortByButton() {
		return sortByButton;
	}

	public WebElement getSearchResult() {
		return searchResult;
	}

	public WebElement getLocationWithin() {
		return locationWithin;
	}

	public WebElement getImputLocationsendKey() {
		return imputLocationsendKey;
	}

	public WebElement getImputLocation() {
		return imputLocation;
	}

	public WebElement getOrderBySelect() {
		return orderBySelect;
	}

	public WebElement getSelectActivity() {
		return selectActivity;
	}

	private WebDriver driver;

	public GocietyMainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getOptions() {
		List<WebElement> options = selectActivity.findElements(By
				.tagName("option"));
		return options;
	}

	public List<WebElement> getOptionsOrderBy() {
		List<WebElement> options = orderBySelect.findElements(By
				.tagName("option"));
		return options;
	}

	public List<WebElement> getSerachResult() {
		List<WebElement> res = searchResult.findElements(By.tagName("li"));
		return res;
	}

	public List<WebElement> getSortByOpction() {
		List<WebElement> options = sortByButton.findElements(By
				.tagName("option"));
		return options;
	}

	public List<WebElement> getLocationWithinOptions() {
		List<WebElement> options = locationWithin.findElements(By
				.tagName("option"));
		return options;
	}

	public List<WebElement> getMenuOptions() {
		List<WebElement> options = navMenu.findElements(By.tagName("a"));
		return options;
	}

	public  String getMainPage() {
		driver.get(MAIN_PAGE);
		return MAIN_PAGE;
	}
}