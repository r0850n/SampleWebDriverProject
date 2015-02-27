package gociety.pages;

import langs.Acounts_Email;
import langs.Pass;
import main.CreatorService;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import Ent.Category;
import Ent.Paces;
import Ent.Radius;
import Ent.SortBy;
import pages.DiscoveryFeedPage;
import pages.GocietyMainPage;
import pages.MyPlanPage;

public class DiscoveryFeedPageTest extends CreatorService {
  @Test     
  public void f() throws InterruptedException {
	
	  loginAndGoToMainPage(Acounts_Email.getEmail("RG_Email_3"), Pass.getPass("RG_pass"));
	   
	   DiscoveryFeedPage discoveryFeed = getDiscoveryFeedPage();
	
	  discoveryFeed.filterPlans(Category.TEST_DARIUSZA.toString(), SortBy.MOST_RECENT_ADDED.toString(), Radius.MILES_100.toString(), "Katowice");
	  
	  discoveryFeed.getImputLocationArea().sendKeys(Keys.ENTER);
	   
	  System.out.println(discoveryFeed.discoveryGird().size());
	  
	
  } 
  @Test     
  public void test() throws InterruptedException{
	 getPlanPage().setCATEGORY(Category.CLIMBING.toString());
	 getPlanPage().setPACES(Paces.NO_BS.toString());
	 getPlanPage().setGps(false);
	 getPlanPage().setLat("10");
	 getPlanPage().setLon("10");
	
	  
	getPlanPage().createNewPlan();
  }
}
