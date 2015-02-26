package pages;

import java.awt.RenderingHints.Key;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Ent.Category;
import Ent.Paces;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class MyPlanPage {

	private String memLimit;
	private WebDriver driver;
	private boolean save = true;
	public String CATEGORY;
	public String PACES;
	public String DESCRIPTION;
	public String LOCATION;
	public String TITLE;
	private String lat;
	private String lon;
	private String DATE = "02/19/2015";
	private String TIME = "dupa";
	private boolean autoAccept;
	private boolean gps;
	// Validators Elements

	@FindBy(xpath = "//*[@id='formGroup_Form']/div[1]/p")
	private WebElement validTitle;

	@FindBy(xpath = "//*[@id='formGroup_Form']/p")
	private WebElement validLacation;

	@FindBy(xpath = "//*[@id='formGroup_Form']/div[5]/p")
	private WebElement validCategory;

	@FindBy(xpath = "//*[@id='formGroup_Form']/div[4]/p")
	private WebElement validDescription;

	@FindBy(xpath = "//*[@id='formGroup_Form']/div[8]/p")
	private WebElement validDate;

	@FindBy(css = "div.newHeader:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)")
	private WebElement plan;

	@FindBy(className = "makePlanBtn")
	private WebElement makeNewPlanButton;

	@FindBy(id = "formGroup_Form_name")
	private WebElement iPlanTo;

	@FindBy(xpath = "//*[@id='formGroup_Form']/ul/li[1]/a")
	private WebElement LocationTab;

	@FindBy(xpath = "//*[@id='formGroup_Form']/ul/li[2]/a")
	private WebElement GpsTab;

	@FindBy(xpath = "//*[@id='localizationCoordinates']/input[1]")
	private WebElement imputLat;

	@FindBy(xpath = "//*[@id='localizationCoordinates']/input[2]")
	private WebElement imputLong;

	//.select2-choice
	@FindBy(css = ".select2-choice")
	private WebElement location;
     //#select2-drop-mask
	@FindBy(xpath = "//*[@id='select2-drop']/div/input")
	private WebElement locationTextArea;

	@FindBy(xpath = "//iframe[@class='wysihtml5-sandbox']")
	private WebElement descriptionArea;

	@FindBy(xpath = "/html/body/div[61]/ul/li/div")
	private WebElement resultLocal;

	@FindBy(id = "formGroup_Form_sport")
	private WebElement sportCategory;

	@FindBy(id = "formGroup_Form_intensityId")
	private WebElement pace;

	@FindBy(xpath = "/html/body/div[16]/div[1]/div[2]/div/div/div[1]/form[1]/div[4]/div")
	private WebElement textAreaGroup;

	@FindBy(id = "habaEditor")
	private WebElement descriptionHidden;

	@FindBy(id = "group_form_submit")
	private WebElement sendButton;

	@FindBy(id = "confirmDialogYes")
	private WebElement confirmDialogYes;

	@FindBy(xpath = "/html/body/div[53]")
	private WebElement subCategory;

	@FindBy(xpath = "/html/body/div[16]/div[1]/div[2]/div/div/div[1]/form[1]/div[6]/div/ul")
	public WebElement sub;

	@FindBy(xpath = "//*[@id='formGroup_Form']/div[10]/label/input")
	private WebElement autoAcceptElement;

	@FindBy(id = "formGroup_Form_joinCap")
	private WebElement memberLimit;

	@FindBy(xpath = "//*[@id='fileupload-div2']/div[2]/span")
	private WebElement loadImageButton;

	@FindBy(xpath = "//*[@id='body']/div[55]")
	private WebElement invalidFormData;

	@FindBy(xpath = "//*[@id='formGroup_Form']/div[9]/p")
	private WebElement validFormTime;

	@FindBy(id = "groupPreview")
	private WebElement preview;

	@FindBy(className = "select2-search")
	private WebElement select2Search;
	
	@FindBy(id="viewGroupDetails")
	private WebElement groupDetails;

	public WebElement getGroupDetails() {
		return groupDetails;
	} 
	public List<WebElement> getAllDetails(){
		
		List<WebElement> element = groupDetails.findElements(By.tagName("li"));
		return element;
		
		
	}

	public WebElement getImputLat() {
		return imputLat;
	}

	public WebElement getImputLong() {
		return imputLong;
	}

	public WebElement getPreview() {
		return preview;
	}

	public WebElement getGpsTab() {
		return GpsTab;
	}

	public WebElement getInvalidFormData() {
		return invalidFormData;
	}

	public WebElement getInvalidFormDataTextOne() {
		return invalidFormData.findElement(By.tagName("h4"));
	}

	public WebElement getLoadImageButton() {
		return loadImageButton;
	}

	public WebElement getMemberLimit() {
		return memberLimit;
	}

	public WebElement getAutoAccept() {
		return autoAcceptElement;
	}

	public WebElement getConfirmDialogYes() {
		return confirmDialogYes;
	}

	public WebElement getValidDescription() {
		return validDescription;
	}

	public WebElement getValidTitle() {
		return validTitle;
	}

	public WebElement getValidLacation() {
		return validLacation;
	}

	public WebElement getValidCategory() {
		return validCategory;
	}

	public WebElement getValidDate() {
		return validDate;
	}

	public WebElement getValidFormTime() {
		return validFormTime;
	}

	public WebElement getSendButton() {
		return sendButton;
	}

	public WebElement getSubCategory() {
		return subCategory;
	}

	public WebElement uploadImage() {
		WebElement img = driver
				.findElement(By
						.xpath("/html/body/div[16]/div[1]/div[2]/div/div/div[1]/form[2]/div[1]/div/div/div[1]/input[1]"));

		String jsScript = "arguments[0].value='data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMTEhQUExQWFBUXGBQUFxgUGBcXFxcXGBYYFxQVFxUYHCggGBolHBQUITEhJSkrLi4uFx8zODMsNygtLisBCgoKDg0OGxAQGywkICQsLCwtLCwsLCwsLCwsLCwsLCwsLCwsLCwsLCwsLCwsLCwsLCwsLCwsLCwsLCwsLCwsLP/AABEIAKgBLAMBIgACEQEDEQH/xAAbAAACAwEBAQAAAAAAAAAAAAAEBQIDBgABB//EAD8QAAEDAgQEBQMBBgUCBwEAAAEAAhEDIQQSMUEFUWFxBhMigZEyobHwFEJScsHRIzNiguEVkgdTg6KywvFD/8QAGQEAAwEBAQAAAAAAAAAAAAAAAQIDBAAF/8QALREAAgICAgICAQMCBwEAAAAAAAECEQMhEhMxQQRRImGRoRRSMkJxscHw8SP/2gAMAwEAAhEDEQA/AFPBeHurtB5ekE3k...PuuXJZ44y/9CMafiOk1pH+KTbXTTa9z8IYeJSAcsOkEXZB1s3MABoBpz1Xi5SXxMS9BoFf4idmlzLjT1H4hGM8Rtt6XNEQQ3IR+BPyvFyZ/HxtLQKObxmgXeqmXC9zIPQRmgCw06okcWwoInz2Dk3KRPSTp8rxclfxoXVv9zlJkhxXDF1w90iL06To3tmAM67K5nF6B9IqAC1qjHNEf7Mw+y5ck/pY/bCpsIw7qRuS0NNgGTl7kO9P/tRFPB0HuAbVDSf4Tl7ySTPsAuXLNKDV1J6sdOyutwaoCcrg8awx2d0b+iJJ7SgGV25i3NO0OIBHSLR7yuXIfHnLI2n6Rz0rRINkEi47l0d4gBeGgDra065bc/qn7L1cqKTto6LsFGGp6kj2ePvKmeHMd9JJjXLDvwuXKk5SjHlZ1geIwWUx6vdhaB7lDteR1XLlTFlc42ziXmzrZcXN7rly0JgI5lFy5cqqbA0ishRhcuVVJiNI4KwVCFy5XjJkpRR//9k=';";

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript(jsScript, img);
		return img;
	}

	public WebElement getDescriptionHidden(String text)
			throws InterruptedException {

		driver.switchTo().frame(
				driver.findElement(By
						.xpath("//iframe[@class='wysihtml5-sandbox']")));
		WebElement element = driver.findElement(By
				.xpath("//body[@class='wysihtml5-editor']"));

		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("arguments[0].innerHTML = '" + text + "'", element);
		driver.switchTo().defaultContent();

		Thread.sleep(1000);
		return descriptionHidden;
	}

	public WebElement setDate() {

		WebElement element = driver.findElement(By
				.xpath("//*[@id='formGroup_Form_Date']/input"));
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript(
				"arguments[0].removeAttribute('readonly','readonly')", element);
		driver.switchTo().defaultContent();
		return element;
	}

	public WebElement setTime() {

		WebElement element = driver.findElement(By
				.xpath("//*[@id='formGroup_Form_Time']/input"));
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript(
				"arguments[0].removeAttribute('readonly','readonly')", element);
		driver.switchTo().defaultContent();
		return element;
	}

	public WebElement getTextAreaGroup() {
		return textAreaGroup;
	}

	public WebElement getPace() {
		return pace;
	}

	public WebElement getSportCategory() {
		return sportCategory;
	}

	public WebElement getDescriptionArea() {
		return descriptionArea;
	}

	public WebElement getLocarionTextArea() {
		return locationTextArea;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getiPlanTo() {
		return iPlanTo;
	}

	public WebElement getLocationTab() {
		return LocationTab;
	}

	public WebElement getSelect2Search() {
		return select2Search;
	}

	public WebElement getMakeNewPlanButton() {
		return makeNewPlanButton;
	}

	public WebElement getPlan() {
		return plan;
	}

	public void getAllElements() {

		List<WebElement> el = driver.findElements(By.cssSelector("*"));

		for (WebElement e : el) {
			System.out.println(e.getText());
		}
	}

	public List<WebElement> getResults() {

		List<WebElement> results = resultLocal.findElements(By.tagName("li"));
		return results;

	}

	public List<WebElement> getSportCategories() {

		List<WebElement> categ = sportCategory.findElements(By
				.tagName("option"));
		return categ;
	}

	public WebElement getSportCategory(String category) {

		for (WebElement element : getSportCategories()) {

			if (element.getText().equals(category)) {
				return element;
			}

		}

		return null;
	}

	public List<WebElement> getPaces() {

		List<WebElement> paces = pace.findElements(By.tagName("option"));
		return paces;
	}

	public WebElement getPace(String pace) {

		for (WebElement element : getPaces()) {

			if (element.getText().equals(pace)) {
				return element;
			}

		}

		return null;

	}

	public List<WebElement> getSubCategories() {

		List<WebElement> cat = subCategory.findElements(By.tagName("li"));
		return cat;
	}

	public WebElement getSportSubCategory(String subcategory) {

		for (WebElement element : getSubCategories()) {

			if (element.getText().equals(subcategory)) {
				return element;
			}

		}

		return null;

	}

	public List<WebElement> getTextArea() {

		List<WebElement> text = textAreaGroup
				.findElements(By.tagName("iframe"));
		return text;
	}

	public MyPlanPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getDateValid() {
		// TODO Auto-generated method stub
		return validDate;
	}

	public void createNewPlan() throws InterruptedException {
		GocietyMainPage mainPage = new GocietyMainPage(driver);
		mainPage.getMakePlanButton().click();
		prepareCreatePlan(getTITLE(), LOCATION, DESCRIPTION, CATEGORY, PACES,
				getDATE(), getTIME(), autoAccept, gps, lat, lon);

		//getConfirmDialogYes().click();

	}

	private void prepareCreatePlan(String title, String location,
			String description, String category, String pace, String date,
			String time, boolean autoAccept, boolean gps, String lat, String lon)
			throws InterruptedException {

		// planPage = new MyPlanPage(driver);
		// title
		getiPlanTo().click();
		getiPlanTo().sendKeys(title);
		// TabLocation
		
		isGpsSelected(location, gps, lat, lon);
		// Search Location
		getDescriptionHidden(description);
		getDescriptionArea().click();
		// Category
		if(category!=null)
		 getSportCategory(category).click();
		Thread.sleep(1000);

		// subCategory TODO

		// Pace
		if(pace!=null)
		getPace(pace).click();
		// TODO DATE/TIME DONE

		setDate().sendKeys(date);
		Thread.sleep(1000);
		setTime().sendKeys(time);

		// auto accept ?
		isAutoAccept(autoAccept);
		// member limit
		getMemberLimit().sendKeys(memLimit);
		// Load image
		getLoadImageButton().click();
		// send
		isSend(save);
		
	}

	private void isAutoAccept(boolean aa) {
		if (aa == true) {
			getAutoAccept().click();
		}

	}

	private void isSend(boolean save) {
		if (save == true) {
			getSendButton().click();
		} else {
			getPreview().click();
			ATUReports.add("Preview", LogAs.PASSED, new CaptureScreen(
					ScreenshotOf.BROWSER_PAGE));
		}
	}

	private void isGpsSelected(String location, boolean gps, String lat,
			String lon) throws InterruptedException {

		if (isGps()) {

			getGpsTab().click();
			getImputLat().click();
			getImputLat().sendKeys(lat);
			getImputLong().click();
			getImputLong().sendKeys(lon);
			getLocationTab().click();
		} else {
			if(location!=null){
			getLocationTab().click();
			getLocation().click();
			getLocarionTextArea().sendKeys(location);

			Thread.sleep(1000);
			getLocarionTextArea().sendKeys(Keys.ENTER);
			}
			// getResults().get(0).click();
		}
	}

	public String getDATE() {
		return DATE;
	}

	public void setDATE(String dATE) {
		DATE = dATE;
	}

	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	public boolean isAutoAccept() {
		return autoAccept;
	}

	public void setAutoAccept(boolean autoAccept) {
		this.autoAccept = autoAccept;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;

	}

	public String getPACES() {
		return PACES;
	}

	public void setPACES(String pACES) {
		PACES = pACES;

	}

	public String getMemLimit() {
		return memLimit;
	}

	public void setMemLimit(String memLimit) {
		this.memLimit = memLimit;
	}

	public boolean isGps() {
		return gps;
	}

	public void setGps(boolean gps) {
		this.gps = gps;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getTIME() {
		return TIME;
	}

	public void setTIME(String tIME) {
		TIME = tIME;
	}
}
