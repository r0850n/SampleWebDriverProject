package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class GocietyHomePage {
	private static final String HOME_PAGE = "http://www.gociety.com";
	// first change
	@FindBy(xpath = "//html/body")
	private List<WebElement> all;
	
	@FindBy(css = "html#yui_3_17_2_1_1421944983734_192.squarespace-damask.yui3-js-enabled.js.flexbox.canvas.canvastext.webgl.no-touch.hashchange.history.draganddrop.rgba.hsla.multiplebgs.backgroundsize.borderimage.borderradius.boxshadow.textshadow.opacity.cssanimations.csscolumns.cssgradients.no-cssreflections.csstransforms.csstransforms3d.csstransitions.video.audio.svg.inlinesvg.svgclippaths.wf-adobegaramondpro-i4-active.wf-adobegaramondpro-n4-active.wf-proximanova-i3-active.wf-proximanova-i6-active.wf-proximanova-i7-active.wf-proximanova-n3-active.wf-proximanova-n4-active.wf-proximanova-n6-active.wf-proximanova-n7-active.wf-active body#collection-543d9527e4b0b7b5f2452d6f.transparent-header.enable-nav-button.nav-button-style-outline.nav-button-corner-style-pill.banner-button-style-solid.banner-button-corner-style-pill.banner-slideshow-controls-arrows.meta-priority-date.hide-entry-author.hide-list-entry-footer.hide-blog-sidebar.center-navigation--info.gallery-design-grid.aspect-ratio-auto.lightbox-style-light.gallery-navigation-bullets.gallery-info-overlay-show-on-hover.gallery-aspect-ratio-32-standard.gallery-arrow-style-no-background.gallery-transitions-fade.gallery-show-arrows.gallery-auto-crop.product-list-titles-under.product-list-alignment-center.product-item-size-11-square.product-image-auto-crop.product-gallery-size-11-square.show-product-price.show-product-item-nav.product-social-sharing.event-show-past-events.event-thumbnails.event-thumbnail-size-32-standard.event-date-label.event-list-show-cats.event-list-date.event-list-time.event-list-address.event-icalgcal-links.event-excerpts.hide-opentable-icons.opentable-style-dark.newsletter-style-light.small-button-style-solid.small-button-shape-square.medium-button-style-solid.medium-button-shape-square.large-button-style-solid.large-button-shape-square.button-style-solid.button-corner-style-square.native-currency-code-usd.collection-type-page.collection-layout-default.collection-543d9527e4b0b7b5f2452d6f.homepage.mobile-style-available.has-banner-image.general-page div#siteWrapper.clearfix div#yui_3_17_2_1_1421944983734_469.banner-thumbnail-wrapper.has-description div#yui_3_17_2_1_1421944983734_468.desc-wrapper p#yui_3_17_2_1_1421944983734_467 a#yui_3_17_2_1_1421944983734_466")
	private WebElement buttonBecomeAMember;
	
	@FindBy(css="/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div/ul/li[1]/a/div[2]")
	private WebElement welcomeText;
	
	@FindBy(xpath="/html/body/div[6]/div[1]/div[2]/div/div/div[2]/div[2]/div[3]/div[1]/div/div[5]/div")
	private WebElement likeButton;
	
	@FindBy(id="plansContainer")
	private WebElement plansCountainer;
	
	@FindBy(xpath="/html/body/div[5]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/ul/li[2]/a")
	private WebElement plans;
	
	@FindBy(id="postWriter")
	private WebElement postWriter;
	
	@FindBy(xpath="/html/body/div[5]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/ul/li[3]/a")
	private WebElement tripReports;

	@FindBy(id="writePostContent")
	private WebElement comment;
	
	
	public WebElement getPostWriter() {
		return postWriter;
	}

	public WebElement getPlans() {
		return plans;
	}

	public WebElement getTripReports() {
		return tripReports;
	}

	
	
	public WebElement getComment() {
		return comment;
	}

	public WebElement getLikeButton() {
		return likeButton;
	}

	public WebElement getWelcomeText() {
		return welcomeText;
	}

	private WebDriver driver;
	
	
	

	public GocietyHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static String getHomePage() {
		return HOME_PAGE;
	}

	public List<String> getAllElementsString() {
		List<WebElement> elements = all;
		List<String> results = Lists.transform(elements, new ExtractText());
		return results;
	}

	public List<WebElement> getAllElements() {
		List<WebElement> elements = all;
		return elements;
	}

	private final class ExtractText implements Function<WebElement, String> {
		public String apply(WebElement from) {
			return from.getText();
		}
	}

	public WebElement getButtonBecomeAMember() {
		return buttonBecomeAMember;
	}
	
	public List<WebElement> heards(){
		
		
		List<WebElement> hearts = plansCountainer.findElements(By.className("iconHeartContainer"));
		
		
		return hearts;
		
	}
	
	public List<WebElement> getUserPlan(){
		List<WebElement> p = plansCountainer.findElements(By.tagName("a"));
		return p;
	}
}