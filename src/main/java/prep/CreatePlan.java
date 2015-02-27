package prep;

import langs.Acounts_Email;
import langs.Pass;
import main.MainC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.internal.NewProfileExtensionConnection;
import org.openqa.selenium.support.PageFactory;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import pages.GocietyHomePage;
import pages.GocietyLoginPage;
import pages.GocietyMainPage;
import pages.MyPlanPage;
import pages.PlanViewPage;
import pages.UserProfilePage;

public class CreatePlan {
	WebDriver driver;
	private GocietyLoginPage loginPage;
	private GocietyHomePage homePage;
	private UserProfilePage profile;
	protected GocietyMainPage mainPage;
	private MyPlanPage planPage;
	private PlanViewPage planViewPage;
	MainC mainC;
	private boolean save=true;
	
	
	
	public void passed(WebDriver driver,String title, String location,
			String description, String category, String pace, String date,
			boolean gps,String lat,String lon) throws InterruptedException {
		
		driver.get("http://desktop.it-sandbox.gociety.com/#!pageLogin");
		loginPage= new GocietyLoginPage(driver);
		loginPage.loginAs(Acounts_Email.getEmail("RG_Email_3"), Pass.getPass("RG_pass"));
		
		driver.get("http://desktop.it-sandbox.gociety.com/#!pageMain");
		mainPage = new GocietyMainPage(driver);
	Thread.sleep(10000);
		mainPage.getMakePlanButton().click();
		prepareCreatePlan(driver,title, location, description,
				category, pace, date,gps,lat,lon);
		planPage.getConfirmDialogYes().click();
	}
	
	
	private void prepareCreatePlan(WebDriver driver,String title, String location,
			String description, String category, String pace, String date,
			boolean gps,String lat,String lon) throws InterruptedException {
		ATUReports.indexPageDescription = "Test Project";
		ATUReports.setAuthorInfo("Robert", "Go³dyn", "MainPageTest");
		planPage = new MyPlanPage(driver);
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

	public CreatePlan(WebDriver driver){
		this.driver=driver;
		mainPage= new GocietyMainPage(driver);
		planPage= new MyPlanPage(driver);
		loginPage= new GocietyLoginPage(driver);
		
		PageFactory.initElements(driver, this);
	}
   
}
