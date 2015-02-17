package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import Ent.Category;
import Ent.Paces;
import pages.GocietyMainPage;
import prep.CreatePlan;
import prep.Login;

public class CreateNewTripReports {
	WebDriver driver;
	
	AutoAcceptTest acceptTest;
	
  @Test 
  public void f() throws InterruptedException {
	 
	   
	 
	  
	new CreatePlan(driver).passed(driver, "a", "katowice", "description", Category.CLIMBING.toString(),Paces.NO_BS.toString(), "aaa", false, "", "");
  }
  
  
  
  @BeforeClass
  public void beforeClass() {
	
	  driver= new FirefoxDriver();
	 /* service= new  CreatorService(driver);
	  acceptTest= new AutoAcceptTest(driver);
	  acceptTest.beforeClass();*/
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
