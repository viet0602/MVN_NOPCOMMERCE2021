package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.Computers_Desktops_ProductDetailPageUI;

public class Computers_Desktops_ProductDetailPageObject extends AbstractPage {
	WebDriver driver;

	public Computers_Desktops_ProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public Computers_Desktops_ProductDetail_ReviewPageObject clickToAddYourReViewText() {
		waitForElementVisible(driver,Computers_Desktops_ProductDetailPageUI.ADD_YOUR_REVIEW_TEXT);
		clickToElement(driver,Computers_Desktops_ProductDetailPageUI.ADD_YOUR_REVIEW_TEXT);
		return PageGeneratorManager.getComputers_Desktops_ProductDetail_ReviewPageObject(driver);
	}
}
