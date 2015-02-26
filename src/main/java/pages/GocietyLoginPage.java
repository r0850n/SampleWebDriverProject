package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GocietyLoginPage {
	private final static String LOGIN_PAGE = "http://desktop.it-sandbox.gociety.com/#!pageEditProfile";
	private WebDriver driver;
	
	
	@FindBy(id = "inputEmail")
	private WebElement inputEmail;
	
	@FindBy(id="email")
	private WebElement fEmail;
	
	@FindBy(id="pass")
	private WebElement fPass;
	
	@FindBy(id="loginbutton")
	private WebElement facebookLoginButton;

	
	@FindBy(id = "inputPassword")
	private WebElement inputPassword;
	
	@FindBy(id = "loginButtonBtn")
	private WebElement loginButton;
	
	@FindBy(css=".fbLoginButton")
	private WebElement facebookButton;
	
	// @FindBy(className="alert alert-error")
	@FindBy(css = "html body#body div#pageLogin.app-page.active-page div.contentWrapper div.content div.centerPart div.loginCenteredBox div.wrap div.formLoginWrap form#formLogin div.alert.alert-error")
	// @FindBy(xpath="/html/body/div[7]/div[1]/div[2]/div[1]/div/div/div[4]/form/div[1]")
	private WebElement errorLogin;
	
	@FindBy(className="firstNameTopMenu")
	private WebElement welcomeText;
	
	public WebElement getWelcomeText() {
		return welcomeText;
	}

	public WebElement getFacebookButton() {
		return facebookButton;
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
	public WebElement getFacebookLoginButton() {
		return facebookLoginButton;
	}
	
	public void loginViaFacebook(String facebookEmail, String facebookPassword){
		driver.get("http://desktop.it-sandbox.gociety.com/#!pageLogin");
		
		getFacebookButton().click();
		driver.get("https://www.facebook.com/login.php?skip_api_login=1&api_key=131780523685805&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fv1.0%2Fdialog%2Foauth%3Fredirect_uri%3Dhttp%253A%252F%252Fdesktop.it-sandbox.gociety.com%252F%2523%2521pageFBLogin%26state%3D00446b191af4b2a2ed090e28c11d8e74aa17ca3a7f5479dafc60678d34c4120f%26scope%3Demail%252Cuser_birthday%252Cuser_location%26client_id%3D131780523685805%26ret%3Dlogin&cancel_uri=http%3A%2F%2Fdesktop.it-sandbox.gociety.com%2F%3Ferror%3Daccess_denied%26error_code%3D200%26error_description%3DPermissions%2Berror%26error_reason%3Duser_denied%26state%3D00446b191af4b2a2ed090e28c11d8e74aa17ca3a7f5479dafc60678d34c4120f%23%21pageFBLogin&display=page");
		getfEmail().sendKeys(facebookEmail);
		getfPass().sendKeys(facebookPassword);
		getFacebookLoginButton().submit();
		
		
		
	
	}
	public static String getLoginPage() {
		return LOGIN_PAGE;
	}

	public WebElement getInputEmail() {
		return inputEmail;
	}

	public WebElement getfEmail() {
		return fEmail;
	}

	public WebElement getfPass() {
		return fPass;
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
	public GocietyLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
