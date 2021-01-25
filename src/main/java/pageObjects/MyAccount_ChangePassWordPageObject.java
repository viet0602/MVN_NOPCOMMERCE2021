package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.MyAccount_ChangePassWordPageUI;

public class MyAccount_ChangePassWordPageObject extends AbstractPage{
	WebDriver driver;

	public MyAccount_ChangePassWordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputOldPassWord(String password) {
		waitForElementVisible(driver, MyAccount_ChangePassWordPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, MyAccount_ChangePassWordPageUI.OLD_PASSWORD_TEXTBOX, password);		
	}

	public void inputNewPassWord(String newpassword) {
		waitForElementVisible(driver, MyAccount_ChangePassWordPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, MyAccount_ChangePassWordPageUI.NEW_PASSWORD_TEXTBOX, newpassword);
	}

	public void inputConfirmPassWord(String confirmNewpassWord) {
		waitForElementVisible(driver, MyAccount_ChangePassWordPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, MyAccount_ChangePassWordPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmNewpassWord);
		
	}

	public void clickToChangePassWordButton() {
		waitForElementVisible(driver, MyAccount_ChangePassWordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, MyAccount_ChangePassWordPageUI.CHANGE_PASSWORD_BUTTON);
		
	}

	public boolean isMessageChangePWSuccessDisplay() {
		waitForElementVisible(driver, MyAccount_ChangePassWordPageUI.CHANGE_PASSWORD_SUCCESSFUL_MESSAGE_TEXT);
		return isElementDisplayed(driver, MyAccount_ChangePassWordPageUI.CHANGE_PASSWORD_SUCCESSFUL_MESSAGE_TEXT);
	}
}
