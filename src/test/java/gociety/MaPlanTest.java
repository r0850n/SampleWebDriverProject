package gociety;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import pages.GocietyLoginPage;
import pages.MyPlanPage;

public class MaPlanTest {

	final static String myplanPage = "http://desktop.it-sandbox.gociety.com/#!pageCreateGroup";
	private WebDriver wd;
	private GocietyLoginPage loginPage;
	private MyPlanPage myPlan;

	@BeforeMethod
	public void beforeTest() {
		wd = new FirefoxDriver();
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wd.get(myplanPage);
	}

	@AfterMethod
	public void afterTest() {
		
	}

	@Test  
	public void elementsTest() {
		login();
		//wd.get("http://desktop.it-sandbox.gociety.com/#!pageMain");
		myPlan= new MyPlanPage(wd);
		//wd.get("http://desktop.it-sandbox.gociety.com/#!pageCreateGroup");
		myPlan.getPlan().click();
		myPlan.getMakeNewPlanButton().click();
		System.out.println(myPlan.getiPlanTo().getText());
	}
	@Test 
	public void testAllElements(){
		wd.get("http://desktop.it-sandbox.gociety.com/#!pageMain");
		myPlan= new MyPlanPage(wd);
		myPlan.getAllElements();
		
	}
	
	private void login(){
		
		wd.get("http://desktop.it-sandbox.gociety.com/#!pageLogin");
		loginPage = new GocietyLoginPage(wd);
		loginPage.loginAs("", "");
	}
}
