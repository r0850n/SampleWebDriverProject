package gociety;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

import pages.GocietyHomePage;
import pages.GocietyLoginPage;
import pages.GocietyMainPage;
import static org.openqa.selenium.OutputType.*;

public class NewTest {
	private static final String MAIN_PAGE = "http://desktop.it-sandbox.gociety.com/#!pageMain";

	WebDriver wd;

	private GocietyHomePage homePage;
	private GocietyLoginPage loginPage;
	private GocietyMainPage mainPage;

	@BeforeMethod
	public void setUp() throws Exception {
		wd = new FirefoxDriver();
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testFirst() {
		wd.get(MAIN_PAGE);
		wd.findElement(By.xpath("//form[@id='#plansFilterBarForm']/div[2]"))
				.click();
		if (!wd.findElement(
				By.xpath("//form[@id='#plansFilterBarForm']/div[2]/select//option[2]"))
				.isSelected()) {
			wd.findElement(
					By.xpath("//form[@id='#plansFilterBarForm']/div[2]/select//option[2]"))
					.click();
		}
		if (!wd.findElement(
				By.xpath("//div[@class='pull-left']/select//option[3]"))
				.isSelected()) {
			wd.findElement(
					By.xpath("//div[@class='pull-left']/select//option[3]"))
					.click();
		}
		wd.findElement(By.cssSelector("input.select2-input.select2-focused"))
				.click();
		wd.findElement(By.cssSelector("input.select2-input.select2-focused"))
				.clear();
		wd.findElement(By.cssSelector("input.select2-input.select2-focused"))
				.sendKeys("katowice");
		wd.findElement(By.name("localization")).click();
	}

	@Test
	public void testActivityLabel() {
		wd.get(MAIN_PAGE);
		mainPage = new GocietyMainPage(wd);
		System.out.println(mainPage.getSelectActivity().getText());
		assertTrue(mainPage.getSelectActivity().isEnabled());

	}

	@Test
	public void testSortByButton() {
		wd.get(MAIN_PAGE);
		mainPage = new GocietyMainPage(wd);
		System.out.println(mainPage.getOptionsOrderBy().get(1).getText());
		assertTrue(mainPage.getSortByButton().isEnabled());
	}

	@Test
	public void testLocationWithin() {
		wd.get(MAIN_PAGE);
		mainPage = new GocietyMainPage(wd);

		System.out
				.println(mainPage.getLocationWithinOptions().get(3).getText());
	}

	@Test
	public void testImputLocation() {
		wd.get(MAIN_PAGE);
		mainPage = new GocietyMainPage(wd);
		mainPage.getImputLocation().click();
		assertTrue(mainPage.getImputLocationsendKey().isEnabled());
	}

	
	@Test
	public void testSerach(){
		wd.get(MAIN_PAGE);
		mainPage = new GocietyMainPage(wd);
		
		//set Activity
		mainPage.getOptions().get(3).click();
		
		//set sort by
		
	   // mainPage.getSortByButton().click();
	    mainPage.getOptionsOrderBy().get(1).click();
	    
	    //
	    mainPage.getLocationWithin().click();
	    mainPage.getLocationWithinOptions().get(2).click();
	    
	    mainPage.getImputLocation().click();
	    mainPage.getImputLocationsendKey().sendKeys("katowice");
	    
	    System.out.println(mainPage.getSerachResult().get(0).getText());
	    assertEquals("Katowice, Silesian, Poland", mainPage.getSerachResult().get(0).getText());
	    
	}
	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

	public static boolean isAlertPresent(FirefoxDriver wd) {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}
