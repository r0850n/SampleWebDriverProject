package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class GocietyHomePageTest {
	
	WebDriver driver;
	
 

  @BeforeClass
  public void beforeClass() {
	  driver= new FirefoxDriver();
	  driver.get("");
	  
  }

  @AfterClass
  public void afterClass() {
  }


  @Test
  public void GocietyHomePage() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getAllElements() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getAllElementsString() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getButtonBecomeAMember() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getComment() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getHomePage() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getLikeButton() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getPlans() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getPostWriter() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getTripReports() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getUserPlan() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getWelcomeText() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void heards() {
    throw new RuntimeException("Test not implemented");
  }
}
