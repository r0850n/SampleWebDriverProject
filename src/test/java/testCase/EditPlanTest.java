package testCase;

import org.junit.Assert;
import org.testng.annotations.Test;

import pages.GocietyMainPage;
import langs.Langs;
import main.CreatorService;

public class EditPlanTest extends CreatorService{
	
	
	@Test 
	public void editPlanTest() throws InterruptedException{
		setTITLE("hsdfadh");
		setLOCATION("wroc³aw");
		
		
	    createPlanAndEdit();
	    
	    Assert.assertTrue(getPlanViewPage().getEditButton().isDisplayed());
	    Assert.assertEquals(getPlanViewPage()
				.getEditButton().getText(), Langs.getLang("LANG_Btn_Edit")
				.toUpperCase());
	}

	
	@Test
	public void editPlanTest2() throws InterruptedException{
		setTITLE("hsdfadh");
		setLOCATION("wroc³aw");
	    createPlanAndEdit();
	    getPlanViewPage().getEditButton().click();
	    prepareCreatePlan("aaa", getLOCATION(), "ddd", getCATEGORY(), getPACES(), "aaa","aaa", true, false, "", "");

	}
}
