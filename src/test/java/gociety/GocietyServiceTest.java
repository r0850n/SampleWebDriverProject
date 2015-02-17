package gociety;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.GocietyHomePage;
import pages.GocietyLoginPage;
import pages.GocietyMainPage;

public class GocietyServiceTest {
	private static final String CAST_EVIWARE_AS_SIGNED_INTEGER = "CAST('eviware' AS SIGNED INTEGER)";
	private static final String CLASIC = "' or 1=1--";
	private StringBuffer verificationErrors = new StringBuffer();
	private WebDriver driver;
	private GocietyHomePage homePage;
	private GocietyLoginPage loginPage;
	private GocietyMainPage mainPage;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		Thread.sleep(1000);
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	@Test
	public void startHomePageTest() throws Exception {
		goToHomePage();
		homePage = new GocietyHomePage(driver);
		System.out.println(homePage.getButtonBecomeAMember().getText());
		assertTrue(driver.getTitle().equals("Gociety"));
	}

	@Test
	public void startLoginPageTest() {
		goToLoginPage();
		assertTrue(driver.getTitle().equals("Gociety"));
	}

	@Test
	public void badlLoginTest() throws Exception {
		goToLoginPage();
		loginPage = new GocietyLoginPage(driver);
		loginPage.loginAs("aaa@wp.pl", "aaa");
		System.out.println(loginPage.getErrorLogin().getText());
		assertTrue(loginPage.getErrorLogin().isDisplayed());
	}

	@Test
	public void testGetAll() throws Exception {
		goToHomePage();
		homePage = new GocietyHomePage(driver);
		System.out.println(homePage.getAllElementsString());
	}

	@Test
	public void testSqlInjection_Clasic() throws Exception {
		login(CLASIC, CLASIC);
	}

	@Test
	public void testSqlInjection_Type_Conversion() throws Exception {
		login(CAST_EVIWARE_AS_SIGNED_INTEGER, "yesitdoes!");
		assertTrue(loginPage.getErrorLogin().isDisplayed());
	}

	@Test
	public void testSqlInjection_LogInAndLogIn() throws Exception {
		for (int i = 0; i <= 2; i++) {
			testSqlInjection_Clasic();
		}
	}

	@Test
	public void mainPageTestSelectActivity() throws Exception {
		goToMainPage();
		mainPage = new GocietyMainPage(driver);
	//	 driver.get(GocietyMainPage.getMainPage());
		// System.out.println(mainPage.getSelectActivity().getText());
		// System.out.println(mainPage.getOptions().get(2).getText());
		mainPage.getOptions().get(2).click();
		mainPage.getOptionsOrderBy().get(1).click();
		mainPage.getImputLocation().click();
		mainPage.getImputLocationsendKey().sendKeys("den");
		
		Thread.sleep(1000);
		System.out.println(mainPage.getSearchResult().getText());

		assertEquals("Denver, Colorado, United States", mainPage.getSerachResult().get(1).getText());
		
		System.out.println(mainPage.getOptions().get(3).getText());
	}

	private GocietyHomePage goToHomePage() {
		driver.get(GocietyHomePage.getHomePage());
		return homePage;
	}

	private GocietyLoginPage goToLoginPage() {
		driver.get(GocietyLoginPage.getLoginPage());
		return loginPage;
	}

	private GocietyMainPage goToMainPage() {
	//	driver.get(GocietyMainPage.getMainPage());
		return mainPage;
	}

	private void login(String username, String password) {
		goToLoginPage();
		loginPage = new GocietyLoginPage(driver);
		loginPage.loginAs(username, password);
	}
}