package prep;

import main.CreatorService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import pages.GocietyLoginPage;
import pages.GocietyMainPage;
import pages.UserProfilePage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class Login {
	private static final String PAGE_MAIN = "http://desktop.it-sandbox.gociety.com/#!pageMain";
	WebDriver driver;
	private GocietyMainPage mainPage;
	private GocietyLoginPage loginPage;
	private UserProfilePage profile;
	
	
	public void loginAndGoToMainPage(WebDriver driver,String login, String password) {
		driver.get("http://desktop.it-sandbox.gociety.com/#!pageLogin");
		prepareLogin(driver,login, password);

		driver.get(PAGE_MAIN);
		mainPage = new GocietyMainPage(driver);
	}

	private void prepareLogin(WebDriver driver,String login, String password) {
		loginPage = new GocietyLoginPage(driver);

		loginPage.loginAs(login, password);
		ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));

	}

	public void logOut(WebDriver driver) {
		driver.get("http://desktop.it-sandbox.gociety.com/#!pageDiscoveryFeed");
		profile = new UserProfilePage(driver);
		profile.getLogOutButton().click();
		profile.getSignOut().click();
		// wd.get(LOGIN_PAGE);

	}
	public Login(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
