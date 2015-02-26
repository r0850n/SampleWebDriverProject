package main;

import langs.Langs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.PlanViewPage;
import prep.CreatePlan;
import prep.Login;
import Ent.Category;
import Ent.Paces;

public class MainC extends CreatorService {

	private static final String DATE = "02/19/2015 02:58 PM";
	boolean autoAccept = true;
	boolean autoAcceptUnchecked = false;
	WebDriver driver;
	Login login;
	CreatePlan createPlan;
	CreatorService createNewPlanTest;
	PlanViewPage planViewPage;

	public MainC() {
		super();
	}

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		createNewPlanTest = new CreatorService(driver);
		planViewPage = new PlanViewPage(driver);
		createNewPlanTest.strtUp(driver);
		// login= new Login(driver);
		// createPlan = new CreatePlan(driver);
	}

	@Test
	public void test1_whenAutoAcceptIsChecked() throws InterruptedException {
		createPlanAndJoin(autoAccept);
		Assert.assertEquals(createNewPlanTest.getPlanViewPage()
				.getLeaveButton().getText(), Langs.getLang("LANG_Btn_Leave")
				.toUpperCase());
	}

	@Test
	public void whenAutoAcceptUnchecked() throws InterruptedException {
		createPlanAndJoin(autoAcceptUnchecked);
		Assert.assertEquals(createNewPlanTest.getPlanViewPage()
				.getPendingButton().getText(), Langs
				.getLang("LANG_Btn_Pending").toUpperCase());
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

	public void createPlanAndJoin(boolean autoAccept) throws InterruptedException {
		createNewPlanTest.createNewPlan("auto ", "katowice", "asdfdsaf",
				Category.CLIMBING.toString(), Paces.NO_BS.toString(), DATE, null, autoAccept,
				false, "", "");
	
		loginAsAnotherUser();
		for (int sec = 0; sec <= 100; sec++) {
			if (createNewPlanTest.getMainPage().getPlans().isDisplayed()) {
				createNewPlanTest.getMainPage().getPlans().click();
				break;
			} else {
				Thread.sleep(1000);
			}
		}
	
		for (int sec = 0; sec <= 100; sec++) {
			if (createNewPlanTest.getMainPage().getLatestAddedPlan()
					.isDisplayed()) {
				createNewPlanTest.getMainPage().getLatestAddedPlan().click();
				break;
			} else {
				Thread.sleep(1000);
			}
		}
		System.out.println(createNewPlanTest.getPlanViewPage().getJoinButton()
				.getText());
		createNewPlanTest.getPlanViewPage().getJoinButton().click();
		for (int sec = 0; sec <= 100; sec++) {
			if (createNewPlanTest.getPlanViewPage().getConfirmYesButton()
					.isDisplayed()) {
				createNewPlanTest.getPlanViewPage().getConfirmYesButton()
						.click();
				System.out.println(createNewPlanTest.getPlanViewPage()
						.getJoinButton().getText());
	
				// System.out.println(createNewPlanTest.getPlanViewPage().getPendingButton().getText());
				break;
			} else {
				Thread.sleep(1000);
			}
		}
	}

	public void loginAsAnotherUser() {
		createNewPlanTest.logOut();
		createNewPlanTest.loginAndGoToMainPage("robert+4@gociety.com",
				"tajne123");
	}

}