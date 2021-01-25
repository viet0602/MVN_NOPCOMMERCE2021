package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.AbstractPageUI;
import pageUIs.User_RegisterPageUI;

public class User_RegisterPageObject extends AbstractPage {
	WebDriver driver;

	public User_RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public User_HomePageObject clickToRegisterButton() {
		waitForElementVisible(driver, User_RegisterPageUI.REGISTER_BUTTON);
		scrollToElementByJS(driver, User_RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, User_RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getHomePageObject(driver);
	}

	public void inputInvalidEmail(String invalidEmail) {
		waitForElementVisible(driver, AbstractPageUI.EMAIL_TEXTBOX);
		scrollToElementByJS(driver, AbstractPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AbstractPageUI.EMAIL_TEXTBOX, invalidEmail);
		sendKeyboardToElement(driver, AbstractPageUI.EMAIL_TEXTBOX, Keys.ENTER);

	}

	public void inputConfirmPassWord(String confirmPassWord) {
		waitForElementVisible(driver, User_RegisterPageUI.CONFIRMPASSWORD_TEXTBOX);
		sendkeyToElement(driver, User_RegisterPageUI.CONFIRMPASSWORD_TEXTBOX, confirmPassWord);
		//sendKeyboardToElement(driver, User_RegisterPageUI.CONFIRMPASSWORD_TEXTBOX, Keys.ENTER);
	}

	public boolean isExistEmailErrorMessageDisplay(WebDriver driver2, String errorMessage) {
		waitForElementVisible(driver, User_RegisterPageUI.EXITS_EMAIL_ERROR_MESSAGE, errorMessage);
		return isElementDisplayed(driver, User_RegisterPageUI.EXITS_EMAIL_ERROR_MESSAGE, errorMessage);

	}

	public boolean isPassWordLessThan6CharactersErrorMessageDisplay() {
		waitForElementVisible(driver, User_RegisterPageUI.LESSTHAN6CHAR_PASSWORD_ERROR_MESSAGE_FIRSTLINE);
		return isElementDisplayed(driver, User_RegisterPageUI.LESSTHAN6CHAR_PASSWORD_ERROR_MESSAGE_FIRSTLINE)
				&& isElementDisplayed(driver, User_RegisterPageUI.LESSTHAN6CHAR_PASSWORD_ERROR_MESSAGE_SECONDLINE);
	}

}
