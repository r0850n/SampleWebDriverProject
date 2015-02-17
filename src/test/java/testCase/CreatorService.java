package testCase;

import java.util.concurrent.TimeUnit;

import langs.Langs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import Ent.Category;
import Ent.Paces;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import pages.GetRandomLorum;
import pages.GocietyHomePage;
import pages.GocietyLoginPage;
import pages.GocietyMainPage;
import pages.MyPlanPage;
import pages.PlanViewPage;
import pages.UserProfilePage;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
		MethodListener.class })
public class CreatorService {

	private static final String ERROR_INVLID = Langs
			.getLang("LANG_Validation_Error");
	
	public CreatorService(WebDriver driver) {
		
		// WebDriver driver= new FirefoxDriver();
		 GocietyLoginPage loginPage= new GocietyLoginPage(driver);
		 GocietyHomePage homePage = new GocietyHomePage(driver);
		 UserProfilePage profile= new UserProfilePage(driver);
		 GocietyMainPage mainPage= new GocietyMainPage(driver);
		 MyPlanPage planPage= new MyPlanPage(driver);
	     PlanViewPage planViewPage= new PlanViewPage(driver);
		
	}

	private static final String VALID_DATE = Langs
			.getLang("LANG_CustomValidator_SelectDate");

	{
		System.setProperty(
				"atu.reporter.config",
				"D:\\jary\\ATUReporter_Selenium_testNG_2.1 jar+javadoc+prop file+demo proj+atu recorder\\atu.properties");
	}
	private static final String DATE = "02/19/2015 02:58 PM";
	private static final String PAGE_MAIN = "http://desktop.it-sandbox.gociety.com/#!pageMain";
	private static final String PASSWORD = "tajne123";
	private static final String LOGIN = "robert+3@gociety.com";
	private WebDriver driver;
	private GocietyLoginPage loginPage;
	private GocietyHomePage homePage;
	private UserProfilePage profile;
	protected GocietyMainPage mainPage;
	private MyPlanPage planPage;
	

	private PlanViewPage planViewPage;
	private boolean save=true;

	
	public void createNewPlan(String title, String location,
			String description, String category, String pace, String date,boolean autoAccept,
			boolean gps,String lat,String lon) throws InterruptedException {
		mainPage.getMakePlanButton().click();
		prepareCreatePlan(title, location, description,
				category, pace, date,autoAccept,gps,lat,lon);
		planPage.getConfirmDialogYes().click();
	}

	
	public void tempTest() throws InterruptedException {

		ATUReports.add("Trip Reports", LogAs.WARNING, new CaptureScreen(
				mainPage.getMakePlanButton()));
		mainPage.getMakePlanButton().click();
		planPage = new MyPlanPage(driver);
		ATUReports.add("Category", LogAs.WARNING,
				new CaptureScreen(planPage.getSportCategory()));
		planPage.getSportCategory().click();

		driver.switchTo().defaultContent();
		planPage.sub.click();

		ATUReports.add("Auto accept", LogAs.WARNING,
				new CaptureScreen(planPage.getLoadImageButton()));

		planPage.getLoadImageButton().sendKeys("D:\\DSC_8639.jpg");
		;

		Thread.sleep(1000);

	}
 
	@Test
	public void previewCreatePlanWithCorrectData() throws InterruptedException {
          save=false;
		ATUReports.add("Trip Reports", LogAs.WARNING, new CaptureScreen(
				mainPage.getMakePlanButton()));
		preparePlan();
		

	}

	public void preparePlan() throws InterruptedException {
		mainPage.getMakePlanButton().click();

		prepareCreatePlan("test GPS", "Katowice", "asdkjfgasjkdf",
				Category.SKIING.toString(), Paces.NO_BS.toString(), DATE,true,false,"10","10");
		prepareATUReports();
	}
	
	
	@Test
	public void createPlanWithCorrectData() throws InterruptedException {

		ATUReports.add("Trip Reports", LogAs.WARNING, new CaptureScreen(
				mainPage.getMakePlanButton()));
		mainPage.getMakePlanButton().click();

		prepareCreatePlan("test GPS2", "Katowice", "asdkjfgasjkdf",
				Category.SKIING.toString(), Paces.NO_BS.toString(), DATE,true,true,"10","10");
		prepareATUReports();
		planPage.getConfirmDialogYes().click();

	}

	@Test
	public void createNewPlan_WithoutDate_ShouldReturn()
			throws InterruptedException {
		ATUReports.add("Trip Reports", LogAs.WARNING, new CaptureScreen(
				mainPage.getMakePlanButton()));
		mainPage.getMakePlanButton().click();

		prepareCreatePlan("title", "katowice", "asdkjfgasjkdf",
				Category.RUNNING.toString(), Paces.SLOW_AND_STADY.toString(), null,true,false,null,null);
		
		Assert.assertTrue(planPage.getInvalidFormData().isEnabled());

		Assert.assertEquals(planPage.getInvalidFormDataTextOne().getText(),
				ERROR_INVLID);
		prepareATUReports();
		Assert.assertEquals(planPage.getDateValid().getText(), VALID_DATE);

	}

	@Test
	public void whenYouCreateNewPlanWithoutTitle_ShouldReturn()
			throws InterruptedException {

		ATUReports.add("Trip Reports", LogAs.WARNING, new CaptureScreen(
				mainPage.getMakePlanButton()));
		mainPage.getMakePlanButton().click();

		prepareCreatePlan(null, "katowice", "asdkjfgasjkdf",
				Category.MOTO.toString(), Paces.SLOW_AND_STADY.toString(), null,true,false,null,null);
		prepareATUReports();
		Assert.assertEquals(planPage.getValidTitle().getText(),
				Langs.getLang("LANG_CustomValidator_Title"));
		Assert.assertEquals(planPage.getDateValid().getText(), VALID_DATE);
	}

	@Test
	public void whenYouCreateNewPlanWithoutTitleAndLocation_ShouldReturn()
			throws InterruptedException {

		ATUReports.add("Trip Reports", LogAs.WARNING, new CaptureScreen(
				mainPage.getMakePlanButton()));
		mainPage.getMakePlanButton().click();

		prepareCreatePlan(null, null, "asdkjfgasjkdf",
				Category.H_AND_C.toString(), Paces.SLOW_AND_STADY.toString(), null,true,false,null,null);
		prepareATUReports();
		Assert.assertEquals(planPage.getValidTitle().getText(),
				Langs.getLang("LANG_CustomValidator_Title"));
		Assert.assertEquals(planPage.getValidLacation().getText(),
				Langs.getLang("LANG_CustomValidator_Location"));
	}

	@Test
	public void whenYouCreateNewPlanWithoutTitlLocationAndDescription_ShouldReturn()
			throws InterruptedException {

		ATUReports.add("Trip Reports", LogAs.WARNING, new CaptureScreen(
				mainPage.getMakePlanButton()));
		mainPage.getMakePlanButton().click();

		prepareCreatePlan(null, null, "", Category.ROAD_CYCLING.toString(),
				Paces.RACE.toString(), null,true,false,null,null);
		prepareATUReports();
		Assert.assertEquals(planPage.getValidTitle().getText(),
				Langs.getLang("LANG_CustomValidator_Title"));
		Assert.assertEquals(planPage.getValidLacation().getText(),
				Langs.getLang("LANG_CustomValidator_Location"));
		Assert.assertEquals(planPage.getValidDescription().getText(),
				Langs.getLang("LANG_CustomValidator_Description"));
		Assert.assertEquals(planPage.getDateValid().getText(), VALID_DATE);
	}

	private void prepareCreatePlan(String title, String location,
			String description, String category, String pace, String date,boolean autoAccept,
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
		//auto accept ?
		isAutoAccept(autoAccept);
		
		// member limit
		planPage.getMemberLimit().sendKeys("0");
		// Load image
		planPage.getLoadImageButton().click();
		// send
		isSend(save);
		//planPage.getSendButton().click();
		
		// logOut();
	}
 
	private void isAutoAccept(boolean aa) {
		if(aa==true){
			planPage.getAutoAccept().click();
		}
		
		
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

	private void prepareATUReports() {
		ATUReports.add("title", LogAs.WARNING,
				new CaptureScreen(planPage.getiPlanTo()));

		ATUReports.add("Tab Location", LogAs.WARNING, new CaptureScreen(
				planPage.getLocationTab()));
		ATUReports.add("GPS Tab", LogAs.WARNING,
				new CaptureScreen(planPage.getGpsTab()));
		ATUReports.add("GPS Lat.", LogAs.WARNING,
				new CaptureScreen(planPage.getImputLat()));
		ATUReports.add("GPS Tab", LogAs.WARNING,
				new CaptureScreen(planPage.getImputLong()));
		ATUReports.add("Serch location", LogAs.WARNING, new CaptureScreen(
				planPage.getLocation()));
		ATUReports.add("Serch locationArea", LogAs.WARNING, new CaptureScreen(
				planPage.getLocarionTextArea()));
		ATUReports.add("Category", LogAs.WARNING,
				new CaptureScreen(planPage.getSportCategory()));
		ATUReports.add("SUBCategory", LogAs.WARNING,
				new CaptureScreen(planPage.getSubCategory()));
		ATUReports.add("Paces", LogAs.WARNING,
				new CaptureScreen(planPage.getPace()));

		ATUReports.add("Auto accept", LogAs.WARNING,
				new CaptureScreen(planPage.getAutoAccept()));

		ATUReports.add("Member Limit", LogAs.WARNING, new CaptureScreen(
				planPage.getMemberLimit()));

		ATUReports.add("Select Img Button", LogAs.WARNING, new CaptureScreen(
				planPage.getLoadImageButton()));
		ATUReports.add("SaveButton", LogAs.WARNING, new CaptureScreen(
				planPage.getSendButton()));
		ATUReports.add("Confirm Button", LogAs.WARNING, new CaptureScreen(
				planPage.getConfirmDialogYes()));
	}

	@BeforeMethod
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://desktop.it-sandbox.gociety.com");

		ATUReports.setWebDriver(driver);
		ATUReports.indexPageDescription = "Test Project";
		ATUReports.setAuthorInfo("Robert", "Go³dyn", "MainPageTest");
		loginAndGoToMainPage(LOGIN,PASSWORD);
	}

	@AfterMethod
	public void afterClass() {

		driver.quit();
	}

	public void strtUp(WebDriver driver){
		this.driver= driver;
		//driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://desktop.it-sandbox.gociety.com");

		ATUReports.setWebDriver(driver);
		ATUReports.indexPageDescription = "Test Project";
		ATUReports.setAuthorInfo("Robert", "Go³dyn", "MainPageTest");
		loginAndGoToMainPage(LOGIN,PASSWORD);
		
	}
	public void loginAndGoToMainPage(String login, String password) {
		driver.get("http://desktop.it-sandbox.gociety.com/#!pageLogin");
		prepareLogin(login, password);

		driver.get(PAGE_MAIN);
		mainPage = new GocietyMainPage(driver);
	}

	private void prepareLogin(String login, String password) {
		loginPage = new GocietyLoginPage(driver);

		loginPage.loginAs(login, password);
		ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));

	}

	public void logOut() {
		driver.get("http://desktop.it-sandbox.gociety.com/#!pageDiscoveryFeed");
		profile = new UserProfilePage(driver);
		profile.getLogOutButton().click();
		profile.getSignOut().click();
		// wd.get(LOGIN_PAGE);

	}
	public MyPlanPage getPlanPage() {
		return new MyPlanPage(driver);
	}


	public GocietyLoginPage getLoginPage() {
		return new GocietyLoginPage(driver);
	}


	public GocietyHomePage getHomePage() {
		return new GocietyHomePage(driver);
	}


	public UserProfilePage getProfile() {
		return new UserProfilePage(driver);
	}


	public GocietyMainPage getMainPage() {
		return new GocietyMainPage(driver);
	}


	public PlanViewPage getPlanViewPage() {
		return new PlanViewPage(driver);
	}
}
