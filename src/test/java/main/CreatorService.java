package main;

import java.util.concurrent.TimeUnit;

import langs.Langs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import pages.DiscoveryFeedPage;
import pages.GetRandomLorum;
import pages.GocietyHomePage;
import pages.GocietyLoginPage;
import pages.GocietyMainPage;
import pages.MyPlanPage;
import pages.PageEditProfile;
import pages.PageSchowProfile;
import pages.PlanViewPage;
import pages.PostTripReportsPage;
import pages.UserProfilePage;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
		MethodListener.class })
public class CreatorService {
	public boolean user;

	public CreatorService() {
		super();
	}

	@BeforeMethod
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://desktop.it-sandbox.gociety.com");
		//startAsCreatedUser();
		// mainPage=new GocietyMainPage(driver);
	}

	private void startAsCreatedUser() {
		driver.get("http://desktop.it-sandbox.gociety.com");

		loginAndGoToMainPage(LOGIN, PASSWORD);

	}

	@AfterMethod
	public void afterClass() {
		driver.quit();
	}

	public CreatorService(WebDriver driver) {

		// WebDriver driver= new FirefoxDriver();
		GocietyLoginPage loginPage = new GocietyLoginPage(driver);
		GocietyHomePage homePage = new GocietyHomePage(driver);
		UserProfilePage profile = new UserProfilePage(driver);
		GocietyMainPage mainPage = new GocietyMainPage(driver);
		MyPlanPage planPage = new MyPlanPage(driver);
		PlanViewPage planViewPage = new PlanViewPage(driver);

	}

	{
		System.setProperty(
				"atu.reporter.config",
				"D:\\jary\\ATUReporter_Selenium_testNG_2.1 jar+javadoc+prop file+demo proj+atu recorder\\atu.properties");
	}
	private String DATE = "02/20/2015";
	private String PAGE_MAIN = "http://desktop.it-sandbox.gociety.com/#!pageDiscoveryFeed";
	private static final String VALID_DATE = Langs.getLang("LANG_CustomValidator_SelectDate");
	private static final String ERROR_INVLID = Langs.getLang("LANG_Validation_Error");
	private static String TIME = "aaa";
	private String PASSWORD = "tajne123";
	private String LOGIN = "robert+3@gociety.com";
	private String CATEGORY = Category.CLIMBING.toString();
	private String PACES = Paces.ADVENTURING.toString();
	public static String DESCRIPTION = "asdfdsaf";
	public static String LOCATION = "katowice";
	public static String TITLE = "auto ";
	private String lat;
	private String lon;
	private boolean save = true;
	private boolean autoAccept;
	private boolean gps;

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	private GocietyLoginPage loginPage;
	private GocietyHomePage homePage;
	private UserProfilePage profile;
	protected GocietyMainPage mainPage;
	private MyPlanPage planPage;
	private PlanViewPage planViewPage;
	

	public void createNewPlan(String title, String location,
			String description, String category, String pace, String date,String time,
			boolean autoAccept, boolean gps, String lat, String lon)
			throws InterruptedException {
		mainPage.getMakePlanButton().click();
		prepareCreatePlan(title, location, description, category, pace, date,time,
				autoAccept, gps, lat, lon);
		planPage.getConfirmDialogYes().click();
	}

	public void createNewPlan() throws InterruptedException {
		// mainPage.getMakePlanButton().click();
		getMainPage().getMakePlanButton().click();
		prepareCreatePlan(TITLE, LOCATION, DESCRIPTION, CATEGORY, PACES, DATE,TIME,
				autoAccept, gps, lat, lon);

		// planPage.getConfirmDialogYes().click();

	}

	@Test
	public void previewCreatePlanWithCorrectData() throws InterruptedException {
		save = false;
		ATUReports.add("Trip Reports", LogAs.WARNING, new CaptureScreen(
				mainPage.getMakePlanButton()));
		preparePlan();

	}

	public void preparePlan() throws InterruptedException {
		mainPage.getMakePlanButton().click();

		prepareCreatePlan("test GPS", "Katowice", "asdkjfgasjkdf",
				Category.SKIING.toString(), Paces.NO_BS.toString(), DATE,TIME, true,
				false, "10", "10");
		prepareATUReports();
	}

	@Test
	public void createPlanWithCorrectData() throws InterruptedException {

		ATUReports.add("Trip Reports", LogAs.WARNING, new CaptureScreen(
				mainPage.getMakePlanButton()));
		mainPage.getMakePlanButton().click();

		prepareCreatePlan("test GPS2", "Katowice", "asdkjfgasjkdf",
				Category.SKIING.toString(), Paces.NO_BS.toString(), DATE,TIME, true,
				true, "10", "10");
		prepareATUReports();
		planPage.getConfirmDialogYes().click();

	}

	@Test
	public void createNewPlan_WithoutDate_ShouldReturn()
			throws InterruptedException {
		ATUReports.add("Trip Reports", LogAs.WARNING, new CaptureScreen(
				mainPage.getMakePlanButton()));
		mainPage.getMakePlanButton().click();

		prepareCreatePlan("title", LOCATION, "asdkjfgasjkdf",
				Category.RUNNING.toString(), Paces.SLOW_AND_STADY.toString(),
				null,TIME, true, false, null, null);

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

		prepareCreatePlan(null, LOCATION, "asdkjfgasjkdf",
				Category.MOTO.toString(), Paces.SLOW_AND_STADY.toString(),
				null,TIME, true, false, null, null);
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
				Category.H_AND_C.toString(), Paces.SLOW_AND_STADY.toString(),
				null,TIME, true, false, null, null);
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
				Paces.RACE.toString(), null,TIME, true, false, null, null);
		prepareATUReports();
		Assert.assertEquals(planPage.getValidTitle().getText(),
				Langs.getLang("LANG_CustomValidator_Title"));
		Assert.assertEquals(planPage.getValidLacation().getText(),
				Langs.getLang("LANG_CustomValidator_Location"));
		Assert.assertEquals(planPage.getValidDescription().getText(),
				Langs.getLang("LANG_CustomValidator_Description"));
		Assert.assertEquals(planPage.getDateValid().getText(), VALID_DATE);
	}

	public void prepareCreatePlan(String title, String location,
			String description, String category, String pace, String date, String time,
			boolean autoAccept, boolean gps, String lat, String lon)
			throws InterruptedException {

		planPage = new MyPlanPage(driver);
		// title
		planPage.getiPlanTo().click();
		planPage.getiPlanTo().sendKeys(title);
		// TabLocation
		isGpsSelected(location, gps, lat, lon);
		// Search Location
		planPage.getDescriptionHidden(description);
		planPage.getDescriptionArea().click();
		// Category
		planPage.getSportCategory(category).click();
		Thread.sleep(1000);

		// subCategory TODO

		// Pace
		planPage.getPace(pace).click();
		//date
		planPage.setDate().sendKeys(date);
		Thread.sleep(1000);		
		planPage.setTime().sendKeys(time);
		// auto accept ?
		isAutoAccept(autoAccept);
		// member limit
		planPage.getMemberLimit().sendKeys("0");
		// Load image
		planPage.getLoadImageButton().click();
		// send
		isSend(save);
	}

	private void isAutoAccept(boolean aa) {
		if (aa == true) {
			planPage.getAutoAccept().click();
		}

	}

	private void isSend(boolean save) {
		if (save == true) {
			planPage.getSendButton().click();
		} else {
			planPage.getPreview().click();
			ATUReports.add("Preview", LogAs.PASSED, new CaptureScreen(
					ScreenshotOf.BROWSER_PAGE));
		}
	}

	private void isGpsSelected(String location, boolean gps, String lat,
			String lon) throws InterruptedException {

		if (gps == true) {

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
			planPage.getLocarionTextArea().sendKeys(Keys.ENTER);
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
		ATUReports.add("SaveButton", LogAs.WARNING,
				new CaptureScreen(planPage.getSendButton()));
		ATUReports.add("Confirm Button", LogAs.WARNING, new CaptureScreen(
				planPage.getConfirmDialogYes()));
	}

	public void strtUp(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://desktop.it-sandbox.gociety.com");
		ATUReports.setWebDriver(driver);
		ATUReports.indexPageDescription = "Test Project";
		ATUReports.setAuthorInfo("Robert", "Go³dyn", "MainPageTest");
		loginAndGoToMainPage(LOGIN, PASSWORD);

	}

	public void loginAndGoToMainPage(String login, String password) {
		driver.get("http://desktop.it-sandbox.gociety.com/#!pageLogin");
		prepareLogin(login, password);
		driver.get(PAGE_MAIN);
		// mainPage = new GocietyMainPage(driver);
	}

	private void prepareLogin(String login, String password) {
		loginPage = new GocietyLoginPage(driver);
		loginPage.loginAs(login, password);
		/*
		 * ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
		 * ScreenshotOf.BROWSER_PAGE));
		 */

	}

	public void createPlanAndJoin() throws InterruptedException {
		createNewPlan();
		planPage.getConfirmDialogYes().click();

		loginAsAnotherUser(LOGIN, PASSWORD);
		/*for (int sec = 0; sec <= 100; sec++) {
			if (getMainPage().getPlans().isDisplayed()) {
				getMainPage().getPlans().click();
				break;
			} else {
				Thread.sleep(1000);
			}
		}*/
		for (int sec = 0; sec <= 100; sec++) {
			if (getMainPage().getLatestAddedPlan().isDisplayed()) {
				getMainPage().getLatestAddedPlan().click();
				break;
			} else {
				Thread.sleep(1000);
			}
		}
		System.out.println(getPlanViewPage().getJoinButton().getText());
		getPlanViewPage().getJoinButton().click();
		for (int sec = 0; sec <= 100; sec++) {
			if (getPlanViewPage().getConfirmYesButton().isDisplayed()) {
				System.out.println(getPlanViewPage().getConfirmYesButton()
						.isDisplayed());
				getPlanViewPage().getConfirmYesButton().click();
				break;
			} else {
				Thread.sleep(1000);
			}
		}
	}

	public void createPlanAndEdit() throws InterruptedException {
		createNewPlan();
		planPage.getConfirmDialogYes().click();

		loginAsAnotherUser(LOGIN, PASSWORD);
		for (int sec = 0; sec <= 100; sec++) {
			if (getMainPage().getPlans().isDisplayed()) {
				getMainPage().getPlans().click();
				break;
			} else {
				Thread.sleep(1000);
			}
		}
		for (int sec = 0; sec <= 100; sec++) {
			if (getMainPage().getLatestAddedPlan().isDisplayed()) {
				getMainPage().getLatestAddedPlan().click();
				break;
			} else {
				Thread.sleep(1000);
			}
		}
		System.out.println(getPlanViewPage().getEditButton().getText());
		// getPlanViewPage().getEditButton().click();

	}

	public void logOut() {
		driver.get("http://desktop.it-sandbox.gociety.com/#!pageDiscoveryFeed");
		profile = new UserProfilePage(driver);
		profile.getLogOutButton().click();
		profile.getSignOut().click();
	}

	public void loginAsAnotherUser(String login, String password) {
		logOut();
		loginAndGoToMainPage(login, password);
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

	public PostTripReportsPage getPostTripReportsPage() {
		return new PostTripReportsPage(driver);
	}

	public PageSchowProfile getPageSchowProfile() {

		return new PageSchowProfile(driver);
	}

	public PageEditProfile getPageEditProfile() {
		return new PageEditProfile(driver);
	}

	public DiscoveryFeedPage getDiscoveryFeedPage() {
		return new DiscoveryFeedPage(driver);
	}

	public MainC getMainc() {
		return new MainC();

	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getLOGIN() {
		return LOGIN;
	}

	public void setLOGIN(String lOGIN) {
		LOGIN = lOGIN;
	}

	public String getDATE() {
		return DATE;
	}

	public void setDATE(String dATE) {
		DATE = dATE;
	}

	public  String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public  void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

	public  String getLOCATION() {
		return LOCATION;
	}

	public  void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	public static String getTITLE() {
		return TITLE;
	}

	public  void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

	public String getPACES() {
		return PACES;
	}

	public void setPACES(String pACES) {
		PACES = pACES;
	}

	public boolean isAutoAccept() {
		return autoAccept;
	}

	public void setAutoAccept(boolean autoAccept) {
		this.autoAccept = autoAccept;
	}

	public static String getTIME() {
		return TIME;
	}

	public static void setTIME(String tIME) {
		TIME = tIME;
	}
}
