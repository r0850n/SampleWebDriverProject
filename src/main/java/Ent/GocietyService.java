package Ent;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import pages.GocietyHomePage;
import pages.GocietyLoginPage;
import pages.GocietyMainPage;
import pages.MyPlanPage;
import pages.UserProfilePage;

public class GocietyService {
	GocietyLoginPage loginPage;
	GocietyHomePage homePage;
	UserProfilePage profile;
	GocietyMainPage mainPage;
	MyPlanPage planPage;
	private boolean save=true;
	private FirefoxDriver driver;

	public GocietyLoginPage getLoginPage() {
		return loginPage;
	}

	public GocietyHomePage getHomePage() {
		return homePage;
	}

	public UserProfilePage getProfile() {
		return profile;
	}

	public GocietyMainPage getMainPage() {
		return mainPage;
	}

	public MyPlanPage getPlanPage() {
		return planPage;
	}

	public GocietyService(WebDriver driver) {

		loginPage = new GocietyLoginPage(driver);
		homePage = new GocietyHomePage(driver);
		profile = new UserProfilePage(driver);
		mainPage = new GocietyMainPage(driver);
		planPage = new MyPlanPage(driver);

	}
	
	public void passed(String title, String location,
			String description, String category, String pace, String date,
			boolean gps,String lat,String lon) throws InterruptedException {
		mainPage.getMakePlanButton().click();
		prepareCreatePlan(title, location, description,
				category, pace, date,gps,lat,lon);

	}
	private void prepareCreatePlan(String title, String location,
			String description, String category, String pace, String date,
			boolean gps,String lat,String lon) throws InterruptedException {
		ATUReports.indexPageDescription = "Test Project";
		ATUReports.setAuthorInfo("Robert", "Go³dyn", "MainPageTest");
		//planPage = new MyPlanPage(driver);
		// title
		planPage.getiPlanTo().click();
		planPage.getiPlanTo().sendKeys(title);
		// TabLocation
		isGpsSelected(location,gps,lat,lon);
		// Search Location
		
		
		planPage.getDescriptionHidden(description);
		planPage.getDescriptionArea().click();
		// Category
		planPage.getSportCategory(category).click();
		Thread.sleep(1000);

		// subCategory

		// planPage.getSportSubCategory("Groomers").click();

		/*
		 * ATUReports.add("Sub Category", LogAs.WARNING, new
		 * CaptureScreen(planPage.sub)); planPage.sub.click();
		 * Thread.sleep(1000);
		 * System.out.println(planPage.getSubCategories().get(1).getText());
		 * planPage.getSubCategories().get(1).click();
		 */

		// Pace

		// planPage.getPaces().get(0).click();
		planPage.getPace(pace).click();
		planPage.setDate().sendKeys(date);
		Thread.sleep(1000);
		planPage.getAutoAccept().click();
		// member limit
		planPage.getMemberLimit().sendKeys("0");
		// Load image
		planPage.getLoadImageButton().click();
		// send
		isSend(save);
		//planPage.getSendButton().click();
		
		// logOut();
	}
private void isSend(boolean save) {
		
		if (save==true){
			planPage.getSendButton().click();
			
		}
		else{
			planPage.getPreview().click();
			ATUReports.add("Preview", LogAs.PASSED, new CaptureScreen(
					ScreenshotOf.BROWSER_PAGE));
		}
	}

	private void isGpsSelected(String location, boolean gps,String lat,String lon) throws InterruptedException {

		if (gps==true) {
			
			planPage.getGpsTab().click();
			planPage.getImputLat().click();
			planPage.getImputLat().sendKeys(lat);
			planPage.getImputLong().click();
			planPage.getImputLong().sendKeys(lon);
			planPage.getLocationTab().click();
		} else {
			planPage.getLocationTab().click();
			planPage.getLocation().click();
			planPage.getLocarionTextArea().sendKeys(location);
			Thread.sleep(1000);
			planPage.getResults().get(0).click();
		}
	}
	@BeforeMethod
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://desktop.it-sandbox.gociety.com");

		ATUReports.setWebDriver(driver);
		ATUReports.indexPageDescription = "Test Project";
		ATUReports.setAuthorInfo("Robert", "Go³dyn", "MainPageTest");
		//loginAndGoToMainPage("robert+3@gociety.com" , "tajne123");
	}

}
