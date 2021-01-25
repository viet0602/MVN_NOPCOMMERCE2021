package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.ComputersPageUI;

public class ComputersPageObject extends AbstractPage {
	WebDriver driver;

	public ComputersPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public Computers_DesktopsPageObject clickToDesktopsSubItemText() {
		waitForElementVisible(driver, ComputersPageUI.DESKTOPS_SUBITEM_TEXT);
		clickToElement(driver, ComputersPageUI.DESKTOPS_SUBITEM_TEXT);
		return PageGeneratorManager.getComputers_DesktopsPageObject(driver);
	}

}
