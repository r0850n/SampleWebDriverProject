package testCase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.GocietyLoginPage;
import pages.GocietyMainPage;
import pages.MyPlanPage;
import Ent.Category;
import Ent.Paces;
import Ent.User;
import langs.Acounts_Email;
import langs.Pass;
import main.CreatorService;

public class CreateAcountTest extends CreatorService {
	  
	
	@Test       
	public void tesEditAcount() throws Exception{
		loginAndGoToMainPage(Acounts_Email.getEmail("RG_Email_3"), Pass.getPass("RG_pass"));
	GocietyMainPage	mainPage= getMainPage();
		
		String firstName="janusz";
		String lastName="janusz";
		
		loginAsAnotherUser(Acounts_Email.getEmail("12"), Pass.getPass("RG_pass"));
		getPageEditProfile().changeName(firstName,lastName);
		
		getProfile().getLogOutButton().click();
		getProfile().getSignOut().click();
		loginAndGoToMainPage(Acounts_Email.getEmail("12"), Pass.getPass("RG_pass"));
		System.out.println(mainPage.getWelcomText().getText());
		
		Assert.assertEquals(mainPage.getWelcomText().getText(), "Welcome, "+firstName );
		
	}
	  
	@Test     
	public void createPlan() throws InterruptedException{
		loginAndGoToMainPage(Acounts_Email.getEmail("RG_Email_3"), Pass.getPass("RG_pass"));
		MyPlanPage planPage = getPlanPage();
		
		planPage.TITLE="test54785676";
		planPage.setLOCATION("warszawa");
		planPage.setDESCRIPTION("testaaaa");		
		planPage.setCATEGORY(Category.H_AND_C.toString());
		planPage.setPACES(Paces.WORKOUT.toString());
		planPage.setDATE(null);
		planPage.setTIME(null);
		planPage.setAutoAccept(false);
		planPage.setMemLimit("10");
		
		
		planPage.createNewPlan();
		planPage.getConfirmDialogYes().click();
	}
	 
	@Test  
	public void creatPlanWithGpsLocation() throws InterruptedException{
		MyPlanPage planPage = getPlanPage();
		planPage.setTITLE("test Gps");
		planPage.setDESCRIPTION("test gps location hjsdcfjaghsdhsd!!!!!!!!!");
		planPage.setCATEGORY(Category.TEST_DARIUSZA.toString());
		planPage.setPACES(Paces.NO_BS.toString());
		planPage.setAutoAccept(true);
		planPage.setGps(true);
		planPage.setLat("34.2");
		planPage.setLon("76.12");
		
		planPage.createNewPlan();
		planPage.getConfirmDialogYes().click();
	 
	}

	@Test  
	public void createNewAcount() throws Exception{ 
		
		String newUserLogin="";
		String newUserPassword="";
		
	User user= new User();
	user.setEmail(newUserLogin);
	user.setFirstName("jan3");
	user.setLastName("kowal3");
	user.setLocalization("wroc³aw");
	user.setPassword(newUserPassword);
	
	getPageEditProfile().signInAs(user);
	 System.out.println(getMainPage().getWelcomText().getText());
	 
	// loginAsAnotherUser(newUserLogin, newUserPassword);
	// loginAndGoToMainPage(newUserLogin, newUserPassword);
	// createPlan();
	}
	
	@Test 
	public void passtest(){
		
		System.out.println(Acounts_Email.getEmail("RG_pass"));
		
	}
} 
  