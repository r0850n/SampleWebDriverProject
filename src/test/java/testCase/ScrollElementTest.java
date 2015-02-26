package testCase;

import org.testng.annotations.Test;

import pages.GocietyMainPage;
import main.CreatorService;

public class ScrollElementTest extends CreatorService {

	
	
	@Test 
	public void test1(){
		
		loginAndGoToMainPage("robert+3@gociety.com", "tajne123");
		
		GocietyMainPage mp= getMainPage(); 
		 
		mp.scrollTo(mp.getScrolldiv().get(14));
		mp.getScrolldiv().get(0).click();
		System.out.println(getPlanPage().getGroupDetails().getText());
	}
	
	
}
