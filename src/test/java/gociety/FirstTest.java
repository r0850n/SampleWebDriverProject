package gociety;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {

WebDriver wd;
    
    @Before
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void test() {
        wd.get("http://desktop.it-sandbox.gociety.com/");
        if (!wd.findElement(By.xpath("//form[@id='#plansFilterBarForm']/div[1]/select//option[5]")).isSelected()) {
            wd.findElement(By.xpath("//form[@id='#plansFilterBarForm']/div[1]/select//option[5]")).click();
        }
        wd.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/form/div[3]/div/a")).click();
        wd.findElement(By.cssSelector("input.select2-input.select2-focused")).click();
        wd.findElement(By.cssSelector("input.select2-input.select2-focused")).clear();
        wd.findElement(By.cssSelector("input.select2-input.select2-focused")).sendKeys("katowice");
        assertEquals(wd.findElement(By.xpath("/html/body/div[51]/ul")).getText(), "Katowice, Silesian, Poland");
        wd.findElement(By.name("localization")).click();
    }
    
    @After
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