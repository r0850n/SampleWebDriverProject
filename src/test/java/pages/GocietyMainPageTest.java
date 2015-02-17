package pages;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

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
import pages.UserProfilePage;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
		MethodListener.class })
public class GocietyMainPageTest {

	private static final String PAGE_MAIN = "http://desktop.it-sandbox.gociety.com/#!pageMain";

	{
		System.setProperty(
				"atu.reporter.config",
				"D:\\jary\\ATUReporter_Selenium_testNG_2.1 jar+javadoc+prop file+demo proj+atu recorder\\atu.properties");
	}

	private static final String PASSWORD = "tajne123";
	private static final String LOGIN = "robert+3@gociety.com";
	private WebDriver driver;
	private GocietyLoginPage loginPage;
	private GocietyHomePage homePage;
	private UserProfilePage profile;
	private GocietyMainPage mainPage;

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://desktop.it-sandbox.gociety.com");
		
		ATUReports.setWebDriver(driver);
		ATUReports.indexPageDescription = "Test Project";		
		ATUReports.setAuthorInfo("Robert", "Go³dyn", "MainPageTest");
		loginAndGoToMainPage();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		
	}

	@Test
	public void GocietyMainPage() {
		loginAndGoToMainPage();
		
		Assert.assertEquals("Gociety", driver.getTitle());
	}

	@Test  
	public void planSearchTest() throws ATUTestRecorderException {
		// ATUTestRecorder recorder = new ATUTestRecorder("D:\\films","filename",false);
		// recorder.start(); 
		//loginAndGoToMainPage();
		
		ATUReports.setTestCaseReqCoverage("Plans Search test");
		
		
		ATUReports.add("Activity", LogAs.WARNING, new CaptureScreen(
				mainPage.getSelectActivity()));
		ATUReports.add("Activity id 0", LogAs.WARNING, new CaptureScreen(
				mainPage.getOptions().get(0)));
		ATUReports.add("0","",mainPage.getOptions().get(0).getText(),true);
		ATUReports.add("1","",mainPage.getOptions().get(1).getText(),true);
		ATUReports.add("2","",mainPage.getOptions().get(2).getText(),true);
		ATUReports.add("3","",mainPage.getOptions().get(3).getText(),true);
		ATUReports.add("4","",mainPage.getOptions().get(5).getText(),true);
		
		ATUReports.add("Sort By", LogAs.WARNING, new CaptureScreen(
				mainPage.getOrderBySelect()));
		ATUReports.add("Sort By option 1","",mainPage.getOptionsOrderBy().get(0).getText(),true);
		ATUReports.add("Sort By option 2","",mainPage.getOptionsOrderBy().get(1).getText(),true);
		ATUReports.add("Sort By option 3","",mainPage.getOptionsOrderBy().get(2).getText(),true);
		//recorder.stop();
	}

	@Test
	public void getImputLocationsendKey() {
		loginAndGoToMainPage();
		
		mainPage.getImputLocation().sendKeys("test");
		
	}

	

	@Test
	public void getLocationWithin() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void getLocationWithinOptions() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void getMainPage() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void getOptionsTest() {
		driver.get(PAGE_MAIN);
		mainPage= new GocietyMainPage(driver);
		
		ATUReports.add("Act", LogAs.WARNING, new CaptureScreen(
				mainPage.getOptions().get(0)));
		
		ATUReports.add("screeen", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
	}

	@Test
	public void getOptionsOrderBy() {
		driver.get(PAGE_MAIN);
		mainPage= new GocietyMainPage(driver);
		
		mainPage.getOptions().get(2).click();
		
		mainPage.getOptionsOrderBy().get(1).click();
		ATUReports.add("Sort By", LogAs.WARNING, new CaptureScreen(
				mainPage.getOrderBySelect()));
		//mainPage.getImputLocation().click();
	//	mainPage.getImputLocationsendKey().sendKeys("den");
		
		/*ATUReports.add("Imput Location", LogAs.WARNING, new CaptureScreen(
				mainPage.getSearchResult()));*/
	}

	@Test
	public void getOrderBySelect() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void getSearchResult() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void getSelectActivity() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void getSerachResult() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void getSortByButton() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void getSortByOpction() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void getWelcomText() {
		throw new RuntimeException("Test not implemented");
	}
	 
	@Test 
	public void navMenuTest(){
		
		loginAndGoToMainPage();
		
		ATUReports.setTestCaseReqCoverage("Menu Navigator Elements");
		ATUReports.add("Menu", LogAs.WARNING, new CaptureScreen(
				mainPage.getNavMenu()));
			
		ATUReports.add("AssertPlanValue","","Plan",mainPage.getPlans().getText(),true);
		
		prepareScreenShotsOfMenuItems();
		
		Assert.assertEquals("PLANS", mainPage.getPlans().getText());
		Assert.assertEquals("TRIP REPORTS", mainPage.getTripReports().getText());
		
	}

	private void loginAndGoToMainPage() {
		driver.get("http://desktop.it-sandbox.gociety.com/#!pageLogin");
		prepareLogin();
		
		driver.get(PAGE_MAIN);
		mainPage= new GocietyMainPage(driver);
	}

	private void prepareScreenShotsOfMenuItems() {
		ATUReports.add("Plan", LogAs.WARNING, new CaptureScreen(
				mainPage.getPlans()));
		ATUReports.add("Trip Reports", LogAs.WARNING, new CaptureScreen(
				mainPage.getTripReports()));
		ATUReports.add("Community", LogAs.WARNING, new CaptureScreen(
				mainPage.getCommunity()));
		ATUReports.add("My Gociety", LogAs.WARNING, new CaptureScreen(
				mainPage.getMyGociety()));
		ATUReports.add("Inbox", LogAs.WARNING, new CaptureScreen(
				mainPage.getInbox()));
		ATUReports.add("Notyfications", LogAs.WARNING, new CaptureScreen(
				mainPage.getNotifications()));
	}
	
	private void prepareLogin() {
		loginPage = new GocietyLoginPage(driver);

		loginPage.loginAs(LOGIN, PASSWORD);
		ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));

	}

	private void logOut() {
		profile = new UserProfilePage(driver);
		profile.getLogOutButton().click();
		profile.getSignOut().click();
		// wd.get(LOGIN_PAGE);

	}
}
