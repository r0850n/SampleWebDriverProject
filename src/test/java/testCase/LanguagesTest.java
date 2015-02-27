package testCase;

import langs.Acounts_Email;
import langs.Langs;
import langs.Pass;
import main.CreatorService;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GocietyMainPage;
import Ent.Category;
import Ent.GocietyService;
import Ent.Paces;

public class LanguagesTest extends CreatorService{
	
	@Test  
	public void testLangButtonLeave() throws InterruptedException{
		loginAndGoToMainPage(Acounts_Email.getEmail("RG_Email_3"), Pass.getPass("RG_pass"));
		TITLE="test Time";
		LOCATION="katowice";
		
		setCATEGORY(Category.CLIMBING.toString());
		setPACES(Paces.SOCIAL.toString());
		setDESCRIPTION("test kasdkbfvbdkaghb");
		setAutoAccept(true);
        setLOGIN(Acounts_Email.getEmail("RG_Email_10"));
		setPASSWORD(Pass.getPass("RG_pass"));
		setTIME("24:59");
		setDATE("aaa");
		
		
	    createPlanAndJoin();		    
	    Assert.assertEquals(getPlanViewPage()
				.getLeaveButton().getText(), Langs.getLang("LANG_Btn_Leave")
				.toUpperCase());
	
	}  
	@Test
	public void createNewPlan_WithoutDate_ShouldReturn() throws InterruptedException{

		loginAndGoToMainPage(Acounts_Email.getEmail("RG_Email_3"), Pass.getPass("RG_pass"));
		setTITLE("withoutDate");
		setLOCATION("katowice");
		setDATE(null);
		
		setAutoAccept(true);
		setCATEGORY(Category.FITNES.toString());

		createNewPlan();
		Assert.assertEquals(getPlanPage().getValidDate().getText(),  Langs.getLang("LANG_CustomValidator_SelectDate"));
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
