package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.Computers_DesktopsPageUI;

public class Computers_DesktopsPageObject extends AbstractPage {
	WebDriver driver;

	public Computers_DesktopsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public Computers_Desktops_ProductDetailPageObject clickToOneProduct(String productName) {
		scrollToElementByJS(driver, Computers_DesktopsPageUI.DYNAMIC_PRODUCT_NAME_TEXT,productName);
		waitForElementVisible(driver, Computers_DesktopsPageUI.DYNAMIC_PRODUCT_NAME_TEXT,productName);
		clickToElement(driver, Computers_DesktopsPageUI.DYNAMIC_PRODUCT_NAME_TEXT,productName);
		return PageGeneratorManager.getComputers_Desktops_ProductDetailPageObject(driver);
	}

}
