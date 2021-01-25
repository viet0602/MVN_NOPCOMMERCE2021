package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.User_LoginPageUI;

public class User_LoginPageObject extends AbstractPage {
	WebDriver driver;

	public User_LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public User_HomePageObject clickToLoginButton() {
		scrollToElementByJS(driver, User_LoginPageUI.LOGIN_BUTTON);
		waitForElementVisible(driver, User_LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,  User_LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePageObject(driver);
		
	}

	public boolean isErrorEmailMessageDisplay(WebDriver driver, String messageError) {
		waitForElementVisible(driver, User_LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
		return isElementDisplayed(driver, User_LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE, messageError);
	}
	public boolean isErrorMessageLoginWrongEmailDisplay(WebDriver driver) {
		waitForElementVisible(driver, User_LoginPageUI.LOGIN_UNSUCCESSFUL_ERROR_MESSAGE);
		return isElementDisplayed(driver, User_LoginPageUI.LOGIN_UNSUCCESSFUL_ERROR_MESSAGE)
				&& isElementDisplayed(driver, User_LoginPageUI.LOGIN_WRONG_EMAIL_ERROR_MESSAGE);
	}
	public boolean isErrorMessageLoginWithOutPassWordDisplay() {
		waitForElementVisible(driver, User_LoginPageUI.LOGIN_UNSUCCESSFUL_ERROR_MESSAGE);
		return isElementDisplayed(driver, User_LoginPageUI.LOGIN_UNSUCCESSFUL_ERROR_MESSAGE)
				&& isElementDisplayed(driver, User_LoginPageUI.LOGIN_WITHOUTPASSWORD_ERROR_MESSAGE);
	}
	
}
