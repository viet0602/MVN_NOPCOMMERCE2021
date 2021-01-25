package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.AbstractPageUI;
import pageUIs.User_HomePageUI;

public class User_HomePageObject extends AbstractPage{
	WebDriver driver;

	public User_HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCompleteRegisterTextDisplay(WebDriver driver) {
		waitForElementVisible(driver, User_HomePageUI.REGISTER_COMPLETE_TEXT);
		return isElementDisplayed(driver,User_HomePageUI.REGISTER_COMPLETE_TEXT);
	}

	public boolean isLogOutHeaderDisplay() {
		waitForElementVisible(driver, User_HomePageUI.LOGOUT_HEADER_TEXT);
		return isElementDisplayed(driver, User_HomePageUI.LOGOUT_HEADER_TEXT);
	}

	public User_MyAccount_CustomerInfoPageObject clickToMyAccountHeader(WebDriver driver) {
		waitForElementVisible(driver, User_HomePageUI.MYACCOUNT_HEADER_TEXT);
		clickToElement(driver, User_HomePageUI.MYACCOUNT_HEADER_TEXT);
		return PageGeneratorManager.getMyAccountCustomerInfoPageObject(driver);
	}

	public ComputersPageObject clickToComputersTextTab() {
		waitForElementVisible(driver, AbstractPageUI.COMPUTERS_TAB_TEXT);
		clickToElement(driver, AbstractPageUI.COMPUTERS_TAB_TEXT);
		return PageGeneratorManager.getComputersPageObject(driver);
	}

	public SearchPageObject clickToSearchFooter() {
		waitForElementVisible(driver, User_HomePageUI.SEARCH_FOOTER_TEXT);
		clickToElement(driver, User_HomePageUI.SEARCH_FOOTER_TEXT);
		return PageGeneratorManager.getSearchPageObject(driver);
	}

}

