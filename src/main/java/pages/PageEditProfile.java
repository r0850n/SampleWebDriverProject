package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Ent.User;

public class PageEditProfile {
	private final static String LOGIN_PAGE = "http://desktop.it-sandbox.gociety.com/#!pageEditProfile";
	private WebDriver driver;

	@FindBy(xpath = "//*[@id='createAccountButton']")
	private WebElement createAcountButton;

	public WebElement getCreateAcountButton() {
		return createAcountButton;
	}

	@FindBy(xpath = "/html/body/div[7]/div[1]/div[2]/div[1]/div/div/div[2]/div/a[2]")
	private WebElement singinButton;

	public WebElement getSinginButton() {
		return singinButton;
	}

	@FindBy(id = "editProfile_email")
	private WebElement imputEmailArea;

	@FindBy(id = "editProfile_passNew")
	private WebElement imputPasswordarea;

	@FindBy(className = "control-group")
	private WebElement hiddenField;

	@FindBy(id = "editProfile_passNewRep")
	private WebElement imputPasswordAreaRepeat;

	public WebElement getImputPasswordAreaRepeat() {
		return imputPasswordAreaRepeat;
	}

	public WebElement getImputPasswordAreaRepeat2() throws Exception {

		List<WebElement> elementy = hiddenField.findElements(By.tagName("div"));
		WebElement passwordRepeat = elementy.get(3);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.getElementById('editProfile_passNewRep')."
				+ "parentNode.style.display='block'");
		return passwordRepeat;
	}

	public WebElement getImputPasswordAreaRepeat3(WebDriver driver)
			throws Exception {

		WebElement e = driver.findElement(By.id("editProfile_passNewRep"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("style.display='block';", hiddenField);
		Thread.sleep(6000);
	
		return e;

	}

	@FindBy(id = "editProfile_name")
	private WebElement imputFirstName;

	@FindBy(id = "editProfile_surname")
	private WebElement imputLastName;

	@FindBy(xpath = "/html/body/div[26]/div[1]/div[2]/div/div/div[1]/div/div[1]/form[1]/div/div[5]/div[1]/a/div/b")
	private WebElement imputLocation;

	@FindBy(css = "html body#body.fbinitialized div#select2-drop.select2-drop.select2-with-searchbox.select2-drop-active div.select2-search input.select2-input")
	private WebElement imputLocationArea;

	@FindBy(xpath = "/html/body/div[26]/div[1]/div[2]/div/div/div[1]/div/div[1]/form[2]/div[2]/span/input")
	private WebElement agreeButton;

	@FindBy(css = "#submiteditProfile_step1Form")
	private WebElement sendButton;

	// @FindBy(xpath= "/html/body/div[51]/ul/li")
	@FindBy(id = "select2-drop")
	private WebElement searchResult;

	public WebElement getSearchResult() {
		return searchResult;
	}

	public List<WebElement> localizationSearchResult() {
		List<WebElement> results = searchResult.findElements(By.tagName("li"));

		return results;

	}

	public WebElement getSendButton() {
		return sendButton;
	}

	public WebElement getAgreeButton() {
		return agreeButton;
	}

	public WebElement getImputLocationArea() {
		return imputLocationArea;
	}

	public WebElement getImputLocation() {
		return imputLocation;
	}

	public WebElement getImputFirstName() {
		return imputFirstName;
	}

	public WebElement getImputLastName() {
		return imputLastName;
	}

	public PageEditProfile typeEmail(String email) {
		getImputEmailArea().sendKeys(email);
		return this;
	}

	public PageEditProfile typePassword(String password) {
		getImputPasswordarea().sendKeys(password);
		return this;
	}

	public PageEditProfile typePasswordRep(String password, WebDriver driver)
			throws Exception {
		getImputPasswordAreaRepeat2().sendKeys(password);
		return this;
	}

	private PageEditProfile typeFirstName(String firstName) {

		getImputFirstName().sendKeys(firstName);
		return this;

	}

	private PageEditProfile typeLastName(String lastName) {

		getImputLastName().sendKeys(lastName);
		return this;

	}

	public PageEditProfile typeLocation(String location) {

		getImputLocationArea().sendKeys(location);
		return this;
	}

	public GocietyHomePage submitSignIn() {
		getSendButton().submit();

		return new GocietyHomePage(driver);

	}

	public WebElement getImputPasswordarea() {
		return imputPasswordarea;
	}

	public PageEditProfile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getImputEmailArea() {
		return imputEmailArea;
	}

	public static String getEditProfilePage() {

		return LOGIN_PAGE;
	}

	public List<WebElement> getAllElements() {

		List<WebElement> el = driver.findElements(By.cssSelector("*"));

		for (WebElement e : el) {
			System.out.println(e.getText());
		}
		return el;
	}

	public GocietyHomePage signInAs(String email, String password,
			String firstName, String lastName, String location, WebDriver driver)
			throws Exception {

		getCreateAcountButton().click();
		typeEmail(email);
		typePassword(password);

		// typePasswordRep(password,driver);
		typeFirstName(firstName);
		typeLastName(lastName);
		getImputLocation().click();
		typeLocation(location);
		Thread.sleep(1000);
		// getSearchResult().click();
		localizationSearchResult().get(0).click();

		getAgreeButton().click();
		// Thread.sleep(10000);
		getSendButton().click();

		return submitSignIn();
	}

	public void LoginAs() throws Exception {
		User p = new User();
		for (User s : p.getUsers()) {

			signInAs(s.getEmail(), s.getPassword(), s.getFirstName(),
					s.getLastName(), s.getLocalization(), driver);

		}
	}
}
