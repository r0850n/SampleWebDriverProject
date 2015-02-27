package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MyPlanPage;
import Ent.Category;
import Ent.Paces;
import langs.Acounts_Email;
import langs.Pass;
import main.CreatorService;

public class CreateNewPlanTest extends CreatorService {

	
	@Test      
	public void testCreate() throws InterruptedException{
		
		loginAndGoToMainPage(Acounts_Email.getEmail("RG_Email_3"), Pass.getPass("RG_pass"));
		
		MyPlanPage a= getPlanPage();
		
		a.setTITLE("test set time ");		
		a.setGps(false);
		a.setLon("-146.3488562");
		a.setLat("-16.1453413");
		a.setLOCATION("katowice");
		a.setDESCRIPTION("fgdjhdgghk");
		a.setCATEGORY(Category.WATER_SPORTS.toString());
		a.setPACES(Paces.WORKOUT.toString());
		a.setDATE("02/24/2015");
		a.setTIME("11:59 PM");
		a.setAutoAccept(true);
		a.setMemLimit("10"); 	
		a.createNewPlan();		
		a.getConfirmDialogYes().click();
	}
	 
	@Test 
	public void test() throws InterruptedException{
		
		loginAndGoToMainPage(Acounts_Email.getEmail("RG_Email_3"), Pass.getPass("RG_pass"));
		MyPlanPage a= getPlanPage();
		
		a.setTITLE("test set time ");		
		a.setGps(false);
		a.setLon("-146.3488562");
		a.setLat("-16.1453413");
		a.setLOCATION("dupa");
		a.setDESCRIPTION("fgdjhdgghk");
		a.setCATEGORY(Category.WATER_SPORTS.toString());
		a.setPACES(Paces.WORKOUT.toString());
		a.setDATE("02/27/2015");
		a.setTIME("11:59 PM");
		a.setAutoAccept(true);
		a.setMemLimit("10"); 	
		a.createNewPlan();		 
		a.getConfirmDialogYes().click();
		
	
		getMainPage().getLatestAddedPlan().click();
		System.out.println(a.getAllDetails().get(0).getText());
		
	}
	
	@Test
	public void t(){
		loginAndGoToMainPage(Acounts_Email.getEmail("RG_Email_3"), Pass.getPass("RG_pass"));
		
	}
	
}
