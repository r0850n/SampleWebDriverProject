package testCase;

import org.testng.annotations.Test;

import pages.GocietyMainPage;
import langs.Acounts_Email;
import langs.Pass;
import main.CreatorService;

public class ScrollElementTest extends CreatorService {

	
	
	@Test 
	public void test1(){
		
		loginAndGoToMainPage(Acounts_Email.getEmail("RG_Email_3"), Pass.getPass("RG_pass"));
		
		GocietyMainPage mp= getMainPage(); 
		 
		mp.scrollTo(mp.getScrolldiv().get(14));
		mp.getScrolldiv().get(0).click();
		System.out.println(getPlanPage().getGroupDetails().getText());
	}
	
	
}
