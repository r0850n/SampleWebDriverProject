package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GocietyLoginPage {
	private final static String LOGIN_PAGE = "http://desktop.it-sandbox.gociety.com/#!pageEditProfile";

	@FindBy(id = "inputEmail")
	private WebElement inputEmail;

	@FindBy(id = "inputPassword")
	private WebElement inputPassword;
	
	@FindBy(id = "loginButtonBtn")
	private WebElement loginButton;
	// @FindBy(className="alert alert-error")
	@FindBy(css = "html body#body div#pageLogin.app-page.active-page div.contentWrapper div.content div.centerPart div.loginCenteredBox div.wrap div.formLoginWrap form#formLogin div.alert.alert-error")
	// @FindBy(xpath="/html/body/div[7]/div[1]/div[2]/div[1]/div/div/div[4]/form/div[1]")
	private WebElement errorLogin;
	
	@FindBy(className="firstNameTopMenu")
	private WebElement welcomeText;
	
	public WebElement getWelcomeText() {
		return welcomeText;
	}

	private WebDriver driver;

	public GocietyLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public GocietyLoginPage typeEmail(String email) {
		getInputEmail().sendKeys(email);
		return this;
	}

	public GocietyLoginPage typePassword(String password) {
		getInputPassword().sendKeys(password);
		return this;
	}

	public GocietyHomePage submitLogin() {
		getLoginButton().submit();
		return new GocietyHomePage(driver);
	}

	public GocietyHomePage loginAs(String email, String password) {
		typeEmail(email);
		typePassword(password);
		return submitLogin();
	}

	public static String getLoginPage() {
		return LOGIN_PAGE;
	}

	public WebElement getInputEmail() {
		return inputEmail;
	}

	public WebElement getInputPassword() {
		return inputPassword;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getErrorLogin() {
		return errorLogin;
	}
}
