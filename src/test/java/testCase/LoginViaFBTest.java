package testCase;

import org.testng.annotations.Test;

import pages.GocietyLoginPage;
import langs.Acounts_Email;
import langs.Pass;
import main.CreatorService;

public class LoginViaFBTest extends CreatorService {
	
	@Test
	public void testloginViaFB(){
		
		getLoginPage().loginViaFacebook(Acounts_Email.getEmail("RG_Email_Fb"), Pass.getPass("RG_pass"));
		
		 System.out.println(getMainPage().getWelcomText().getText());
		
		
	}
	
}
