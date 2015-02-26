package testCase;

import langs.Langs;
import main.CreatorService;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GocietyMainPage;
import Ent.Category;
import Ent.GocietyService;
import Ent.Paces;

public class AutoAcceptTest extends CreatorService{
	
	@Test  
	public void t() throws InterruptedException{
		loginAndGoToMainPage("robert+3@gociety.com", "tajne123");
		TITLE="test Time";
		LOCATION="katowice";
		
		setCATEGORY(Category.CLIMBING.toString());
		setPACES(Paces.SOCIAL.toString());
		setDESCRIPTION("test kasdkbfvbdkaghb");
		setAutoAccept(true);
        setLOGIN("robert+10@gociety.com");
		setPASSWORD("tajne123");
		setTIME("24:59");
		setDATE("aaa");
		
		
	    createPlanAndJoin();		    
	    Assert.assertEquals(getPlanViewPage()
				.getLeaveButton().getText(), Langs.getLang("LANG_Btn_Leave")
				.toUpperCase());
	
	} 
	@Test
	public void createNewPlan_WithoutDate_ShouldReturn() throws InterruptedException{
		setTITLE("withoutDate");
		setLOCATION("katowice");
		setDATE(null);
		
		setAutoAccept(true);
		setCATEGORY(Category.FITNES.toString());

		createNewPlan();
		//getPlanPage.getConfirmDialogYes().click();
		Assert.assertTrue(getPlanPage().getInvalidFormData().isEnabled());
	}
	@Test
	public void createNewPlan_Correct() throws InterruptedException{
		setTITLE("aaa");
		setLOCATION("katowice");
		setDATE("02/19/2015 02:58 PM");
		setAutoAccept(true);
		setCATEGORY(Category.FITNES.toString());

		createNewPlan();
	   
		getPlanPage().getConfirmDialogYes().click();
	}
	
	@Test	
    public void testClasses(){
		System.out.println(getMainPage().getNavMenu().getText());
		
	}
}
