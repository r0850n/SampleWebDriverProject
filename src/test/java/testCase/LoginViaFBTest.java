package testCase;

import org.testng.annotations.Test;

import pages.GocietyLoginPage;
import main.CreatorService;

public class LoginViaFBTest extends CreatorService {
	
	@Test
	public void testloginViaFB(){
		
		getLoginPage().loginViaFacebook("robert@gociety.com", "tajne123");
		
		 System.out.println(getMainPage().getWelcomText().getText());
		
		
	}
	
}
