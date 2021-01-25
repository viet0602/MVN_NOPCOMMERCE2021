package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.Computers_Desktops_ProductDetail_ReviewPageUI;

public class Computers_Desktops_ProductDetail_ReviewPageObject extends AbstractPage {
	WebDriver driver;

	public Computers_Desktops_ProductDetail_ReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputTitleReview(String titleReview) {
		waitForElementVisible(driver, Computers_Desktops_ProductDetail_ReviewPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, Computers_Desktops_ProductDetail_ReviewPageUI.REVIEW_TITLE_TEXTBOX, titleReview);
	}

	public void inputBodyReview(String bodyReview) {
		waitForElementVisible(driver, Computers_Desktops_ProductDetail_ReviewPageUI.REVIEW_BODY_TEXTBOX);
		sendkeyToElement(driver, Computers_Desktops_ProductDetail_ReviewPageUI.REVIEW_BODY_TEXTBOX, bodyReview);
		
	}

	public void selectRatingReview() {
		waitForElementVisible(driver, Computers_Desktops_ProductDetail_ReviewPageUI.RATING_RADIO_BUTTON);
		clickToElement(driver, Computers_Desktops_ProductDetail_ReviewPageUI.RATING_RADIO_BUTTON);		
	}

	public void clickToSubmitReviewButton() {
		scrollToElementByJS(driver, Computers_Desktops_ProductDetail_ReviewPageUI.SUBMIT_REVIEW_BUTTON);
		waitForElementVisible(driver, Computers_Desktops_ProductDetail_ReviewPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, Computers_Desktops_ProductDetail_ReviewPageUI.SUBMIT_REVIEW_BUTTON);	
		
	}

	public boolean isReviewSuccessAddedMessageDisplay() {
		waitForElementVisible(driver, Computers_Desktops_ProductDetail_ReviewPageUI.REVIEW_MESSAGE_SUCCESSFUL_TEXT);
		return isElementDisplayed(driver,Computers_Desktops_ProductDetail_ReviewPageUI.REVIEW_MESSAGE_SUCCESSFUL_TEXT);
	}

	public boolean isReviewTittleDisplay(String titleReview) {
		waitForElementVisible(driver, Computers_Desktops_ProductDetail_ReviewPageUI.DYNAMIC_REVIEWED_TITLE_DISPLAY_TEXT,titleReview);
		return isElementDisplayed(driver,Computers_Desktops_ProductDetail_ReviewPageUI.REVIEW_MESSAGE_SUCCESSFUL_TEXT,titleReview);
	}

	public boolean isReviewBodyDisplay(String bodyReview) {
		waitForElementVisible(driver, Computers_Desktops_ProductDetail_ReviewPageUI.DYNAMIC_REVIEWED_BODY_DISPLAY_TEXT,bodyReview);
		return isElementDisplayed(driver,Computers_Desktops_ProductDetail_ReviewPageUI.DYNAMIC_REVIEWED_BODY_DISPLAY_TEXT,bodyReview);
	}

	public boolean isReviewNameDisplay(String firstNameAdd) {
		waitForElementVisible(driver, Computers_Desktops_ProductDetail_ReviewPageUI.DYNAMIC_REVIEW_USER_DISPLAY_TEXT,firstNameAdd);
		return isElementDisplayed(driver,Computers_Desktops_ProductDetail_ReviewPageUI.DYNAMIC_REVIEW_USER_DISPLAY_TEXT,firstNameAdd);
	}
}
