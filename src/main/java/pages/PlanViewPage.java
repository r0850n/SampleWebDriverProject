package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlanViewPage {

	private WebDriver driver;

	@FindBy(css=".bgEditBtn")
	private WebElement editButton;
	
	

	@FindBy(css="html body#body.fbinitialized div#pageViewGroup.app-page.withMenuPanel.active-page div.contentWrapper div.content div.container div.contentContainer div.leftCol div.viewGroupControlPanel a.joiner.joinBTN")
	private WebElement joinButton;
	
	@FindBy(css="button.confirmBtn:nth-child(2)")
	private WebElement confirmYesButton;
	
	@FindBy(css="html body#body.fbinitialized div#pageViewGroup.app-page.withMenuPanel.active-page div.contentWrapper div.content div.container div.contentContainer div.leftCol div.viewGroupControlPanel a.quitter.linkPretender.btn_margin.leaveBTN span")
	private WebElement leaveButton;
	
	@FindBy(css="html body#body.fbinitialized.wysihtml5-supported div#pageViewGroup.app-page.withMenuPanel.active-page div.contentWrapper div.content div.container div.contentContainer div.leftCol div.viewGroupControlPanel a.joiner.pendingBTN.active")
	private WebElement pendingButton;
	
	public WebElement getEditButton() {
		return editButton;
	}
	public WebElement getPendingButton() {
		return pendingButton;
	}

	public WebElement getLeaveButton() {
		return leaveButton;
	}

	public WebElement getConfirmYesButton() {
		return confirmYesButton;
	}

	public WebElement getJoinButton() {
		return joinButton;
	}

	public PlanViewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPlanViewPage(){
	driver.get("");
		return"";
	}
}
