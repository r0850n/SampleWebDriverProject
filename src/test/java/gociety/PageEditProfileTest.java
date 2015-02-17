package gociety;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import Ent.User;
import pages.GocietyHomePage;
import pages.GocietyLoginPage;
import pages.PageEditProfile;
import pages.UserProfilePage;

public class PageEditProfileTest {
	private final static String LOGIN_PAGE = "http://desktop.it-sandbox.gociety.com/#!pageEditProfile";
	private WebDriver wd;
	private PageEditProfile pageEditProfile;
	private GocietyHomePage homePage;
	private GocietyLoginPage loginPage;
	private UserProfilePage profile;

	@BeforeMethod
	public void setUp() throws Exception {
		wd = new FirefoxDriver();
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wd.get(LOGIN_PAGE);
	}

	@AfterMethod
	public void afterMethod() {
		//wd.quit();

	}
 
	@Test
	private void testHiddenRepo() throws Exception {
		wd.get(LOGIN_PAGE);
		pageEditProfile = new PageEditProfile(wd);
		/*pageEditProfile.getCreateAcountButton().click();
		Thread.sleep(1000);
		System.out.println(pageEditProfile.getImputPasswordAreaRepeat2()
				.getAttribute("style"));*/
		// pageEditProfile.getImputPasswordAreaRepeat3(wd).sendKeys("dupa");
		// System.out.println("aaaaaaaaa"+pageEditProfile.getImputPasswordAreaRepeat3(wd).getAttribute("style"));

		pageEditProfile.getAllElements();
		
	} 
	@Test 
	public void select2() throws Exception{
		wd.get(LOGIN_PAGE);
		pageEditProfile = new PageEditProfile(wd);
		pageEditProfile.getCreateAcountButton().click();
		Thread.sleep(1000);
		
		pageEditProfile.getImputLocation().click();
		pageEditProfile.typeLocation("kat");
		Thread.sleep(1000);
		System.out.println(pageEditProfile.getSearchResult().getText());
		
		System.out.println("wybrane->>>> "+pageEditProfile.localizationSearchResult().get(3).getText());
		
	}

	@Test
	public void testresultSearch() {

		wd.get(LOGIN_PAGE);

		pageEditProfile = new PageEditProfile(wd);
		pageEditProfile.getImputLocation().click();
		pageEditProfile.typeLocation("katowice");
		System.out.println(pageEditProfile.getSearchResult().getText());

		pageEditProfile.getAgreeButton().click();

		pageEditProfile.getSendButton().submit();
	}

	@Test
	public void TestImputsAreas() throws Exception {

		Random generator = new Random();

		User p = new User();
		User osobaLosowa = p.getUsers().get(generator.nextInt(3));
		
		wd.get(LOGIN_PAGE);
		
		signin(osobaLosowa.getEmail(), osobaLosowa.getPassword(),
				osobaLosowa.getFirstName(), osobaLosowa.getLastName(),
				osobaLosowa.getLocalization());

		Thread.sleep(1000);
		wd.get("http://desktop.it-sandbox.gociety.com/#!pageLogin");
		loginPage = new GocietyLoginPage(wd);
		loginPage.loginAs(osobaLosowa.getEmail(), osobaLosowa.getPassword());

		System.out.println(loginPage.getWelcomeText().getText());
		Assert.assertEquals("Welcome, "+osobaLosowa.getFirstName()+"",loginPage.getWelcomeText().getText());
	
	}

	@Test 
	public void createAcountTest() throws Exception {

		User osobaLosowa = prepareCreateAcount();

		Thread.sleep(1000);
		
		veryficationAcount(osobaLosowa);
	}

	
	
	private void logOut() {
		profile=new UserProfilePage(wd);
		profile.getLogOutButton().click();
		profile.getSignOut().click();
		//wd.get(LOGIN_PAGE);
		
	} 
 
	@Test 
	public void massiveAcountTest() throws Exception{
		
		for(int i=0;i<=6;i++){
			
			User osobaLosowa = prepareCreateAcount();

			Thread.sleep(1000);
			
			veryficationAcount(osobaLosowa);
			
		}
	}
	
	@Test  
	public void buuu() throws Exception{
		
		for(int i=0;i<=100;i++)
		massiveAcountTest();
	
	}

	private void prepareTest(User p) throws Exception {
		wd.get(LOGIN_PAGE);
		signin(p.getEmail(), p.getPassword(), p.getFirstName(),
				p.getLastName(), p.getLocalization());
		Thread.sleep(1000);
		wd.get("http://desktop.it-sandbox.gociety.com/#!pageLogin");
		loginPage = new GocietyLoginPage(wd);
		System.out.println(loginPage.getWelcomeText().getText());

	}

	@Test
	private void automatedTestLogin() throws Exception {

		User p = new User();

		for (int i = 0; i >= p.getUsers().size(); i++) {

			prepareTest(p);
		}
	}

	private PageEditProfile signIn() {
		wd.get(PageEditProfile.getEditProfilePage());
		return pageEditProfile;
	}

	private void signin(String email, String password, String firstName,
			String lastName, String localization) throws Exception {
		// signIn();

		pageEditProfile = new PageEditProfile(wd);

		pageEditProfile.signInAs(email, password, firstName, lastName,
				localization, wd);

	}
	
	private void veryficationAcount(User osobaLosowa) {
		wd.get("http://desktop.it-sandbox.gociety.com/#!pageLogin");
		loginPage = new GocietyLoginPage(wd);
		loginPage.loginAs(osobaLosowa.getEmail(), osobaLosowa.getPassword());
		
		System.out.println(loginPage.getWelcomeText().getText());
		
		logOut();
	}
	

	private User prepareCreateAcount() throws Exception {
		Random generator = new Random();

		User p = new User();
		User osobaLosowa = p.getUsers().get(generator.nextInt(6));

		wd.get(LOGIN_PAGE);
		
		signin(osobaLosowa.getEmail(), osobaLosowa.getPassword(),
				osobaLosowa.getFirstName(), osobaLosowa.getLastName(),
				osobaLosowa.getLocalization());
		return osobaLosowa;
	}
	private void setPerson() {

		
		
	}
}
