package MultiBrovserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowserTest {

       private WebDriver driver;

       // Configure for multi browser drivers
       @Parameters("browser")
       @BeforeClass
       public void beforeTest(String browser) {
              if (browser.equalsIgnoreCase("firefox")) {
                     driver = new FirefoxDriver();
              } else if (browser.equalsIgnoreCase("chrome")) {
                     // Set Path for the executable file
                     System.setProperty("webdriver.chrome.driver",
                                  "D:\\chromedriver.exe");
                     driver = new ChromeDriver();
              } else if (browser.equalsIgnoreCase("ie")) {
                     // Set Path for the executable file
                     System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
                     driver = new InternetExplorerDriver();
              } else {
                     throw new IllegalArgumentException("The Browser Type is Undefined");
              }
              // Open App
              driver.get("http://demo.opensourcecms.com/wordpress/wp-login.php");
       }

       @Test
       public void login() throws InterruptedException {
              // Enter UserName
              driver.findElement(By.id("user_login")).clear();
              driver.findElement(By.id("user_login")).sendKeys("admin");
              // Enter Password
              driver.findElement(By.id("user_pass")).clear();
              driver.findElement(By.id("user_pass")).sendKeys("demo123");
              // Click on Submit button
              driver.findElement(By.id("wp-submit")).submit();
       }

       @AfterClass
       public void afterTest() {
              try {
                     driver.quit();
              } catch (Exception e) {
                     driver = null;
              }
       }
}

