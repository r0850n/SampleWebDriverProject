package gociety;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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
import pages.GetRandomLorum;
import pages.GocietyHomePage;
import pages.GocietyLoginPage;
import pages.UserProfilePage;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
		MethodListener.class })
public class LikeTest {

	{
		System.setProperty(
				"atu.reporter.config",
				"D:\\jary\\ATUReporter_Selenium_testNG_2.1 jar+javadoc+prop file+demo proj+atu recorder\\atu.properties");
	}

	private StringBuffer verificationErrors = new StringBuffer();
	private static final String PASSWORD = "tajne123";
	private static final String LOGIN = "robert+3@gociety.com";
	private WebDriver driver;
	private GocietyLoginPage loginPage;
	private GocietyHomePage homePage;
	private UserProfilePage userProfile;
	private GetRandomLorum lorum;
	private UserProfilePage profile;

	
	
	
	@Test
	public void f() {
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://desktop.it-sandbox.gociety.com/#!pageLogin");

		ATUReports.setWebDriver(driver);
		ATUReports.indexPageDescription = "Test Project";

	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		driver.close();
		Thread.sleep(1000);
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	@Test
	public void loginTest() throws InterruptedException {
		prepareLogin();
		ATUReports.add("Info step", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
		ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
		ATUReports.add("Warning Step", LogAs.WARNING, new CaptureScreen(
				loginPage.getInputEmail()));
		ATUReports.add("Fail step", LogAs.FAILED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
		// prepareLogin();

		homePage = new GocietyHomePage(driver);
		for (int i = 0; i < 10; i++)
			for (WebElement heart : homePage.heards()) {

				heart.click();

			}
		System.out.println(homePage.getPlans().getText());

		Thread.sleep(1000);

	}

	@Test
	public void testElements() {

		ATUReports.setAuthorInfo("Robert", "Go³dyn", "");
		ATUReports.add("Info step", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
		lorum = new GetRandomLorum(driver);
		String text = lorum.dajRandoma();

		driver.get("http://desktop.it-sandbox.gociety.com/#!pageLogin");
		prepareLogin();

		ATUReports.setTestCaseReqCoverage(text);
		homePage = new GocietyHomePage(driver);
		ATUReports.add("Warning Step", LogAs.WARNING, new CaptureScreen(
				homePage.getUserPlan().get(0)));
		homePage.getUserPlan().get(0).click();

		homePage.getComment().click();
		homePage.getComment().sendKeys(text);

		homePage.getPostWriter().click();

		// System.out.println(text);

	}

	@Test
	public void spamTest() {

		for (int i = 0; i < 5; i++) {
			spam(i);
		}

	}

	@Test
	public void testWebElements() throws InterruptedException {

		driver.get("http://desktop.it-sandbox.gociety.com/#!pageLogin");
		prepareLogin();
		homePage = new GocietyHomePage(driver);
		Thread.sleep(1000);
		ATUReports.add("LikeHeart", LogAs.WARNING,
				new CaptureScreen(homePage.getLikeButton()));
		Thread.sleep(1000);
		ATUReports.add("Welcome ", LogAs.WARNING,
				new CaptureScreen(homePage.getWelcomeText()));
	}

	@Test
	public void testLogin_Fail() {
		loginPage = new GocietyLoginPage(driver);
		//loginPage.loginAs("aaa", "bbb");
		ATUReports
				.setTestCaseReqCoverage("This test is mapped to Login Requirement TC_001");
		ATUReports.setAuthorInfo("SampleAuthorRG", "asdfdf", "1.2");
		ATUReports.add("Email", "User",loginPage.getInputEmail().getText(), "login", true);
		ATUReports.add("Password", "User",loginPage.getInputPassword().getText(), "dsfasdf", true);

		

		Assert.assertEquals("PLEASE ENTER A VALID EMAIL ADDRESS.", loginPage.getErrorLogin().getText());

	}

	public void spam(int i) {

		lorum = new GetRandomLorum(driver);
		String text = lorum.dajRandoma();
		System.out.println(text);
		driver.get("http://desktop.it-sandbox.gociety.com/#!pageLogin");
		prepareLogin();

		homePage = new GocietyHomePage(driver);
		homePage.getUserPlan().get(i).click();
		homePage.getComment().click();
		homePage.getComment().sendKeys(text);
		homePage.getPostWriter().click();

		System.out.println(text);

		logOut();
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
