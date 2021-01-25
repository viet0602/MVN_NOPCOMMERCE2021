package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.AbstractPageUI;
public class StartPageObject extends AbstractPage {
	WebDriver driver;

	public StartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public User_RegisterPageObject clickToRegisterHeaderText() {
		waitForElementVisible(driver, AbstractPageUI.REGISTER_HEADER_TEXT);
		clickToElement(driver, AbstractPageUI.REGISTER_HEADER_TEXT);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}

	public User_LoginPageObject clickToLoginHeaderText() {
		waitForElementVisible(driver, AbstractPageUI.LOGIN_HEADER_TEXT);
		clickToElement(driver, AbstractPageUI.LOGIN_HEADER_TEXT);
		return PageGeneratorManager.getLoginPageObject(driver);
	}	
}
