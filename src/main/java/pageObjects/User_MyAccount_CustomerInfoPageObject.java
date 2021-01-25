package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.AbstractPageUI;
import pageUIs.User_MyAccountPageUI;

public class User_MyAccount_CustomerInfoPageObject extends AbstractPage {
	WebDriver driver;

	public User_MyAccount_CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSaveButton() {
		scrollToElementByJS(driver, User_MyAccountPageUI.SAVE_BUTTON);
		waitForElementVisible(driver, User_MyAccountPageUI.SAVE_BUTTON);
		clickToElement(driver, User_MyAccountPageUI.SAVE_BUTTON);

	}

	public void clickToCustomerInfoText() {
		waitForElementVisible(driver, User_MyAccountPageUI.CUSTOMERINFO_TAB_TEXT);
		clickToElement(driver, User_MyAccountPageUI.CUSTOMERINFO_TAB_TEXT);

	}

	public boolean isGenderdisplay() {
		waitForElementVisible(driver, AbstractPageUI.GENDER_SELECTBOX);
		return isElementSelected(driver, AbstractPageUI.GENDER_SELECTBOX);
	}

	public boolean isFirstNameDisplay(String updateFirstName) {
		waitForElementVisible(driver, AbstractPageUI.FIRSTNAME_TEXTBOX);
		updateFirstName = getElementAttribute(driver, AbstractPageUI.FIRSTNAME_TEXTBOX, "value");
		return isElementDisplayed(driver, AbstractPageUI.FIRSTNAME_TEXTBOX, updateFirstName);
	}

	public boolean isLastNameDisplay(String updateLastName) {
		waitForElementVisible(driver, AbstractPageUI.LASTNAME_TEXTBOX);
		updateLastName = getElementAttribute(driver, AbstractPageUI.LASTNAME_TEXTBOX, "value");
		return isElementDisplayed(driver, AbstractPageUI.LASTNAME_TEXTBOX, updateLastName);
	}

	public boolean isDayDisplay(String updateDate) {
		waitForElementVisible(driver, AbstractPageUI.DAY_DROPDOWNLIST);
		updateDate = getSelectedValueInDropdown(driver, AbstractPageUI.DAY_DROPDOWNLIST);
		return isElementDisplayed(driver, AbstractPageUI.DAY_DROPDOWNLIST, updateDate);
	}

	public boolean isMonthDisplay(String updateMonth) {
		waitForElementVisible(driver, AbstractPageUI.MONTH_DROPDOWNLIST);
		updateMonth = getSelectedValueInDropdown(driver, AbstractPageUI.MONTH_DROPDOWNLIST);
		return isElementDisplayed(driver, AbstractPageUI.MONTH_DROPDOWNLIST, updateMonth);
	}

	public boolean isYearDisplay(String updateYear) {
		waitForElementVisible(driver, AbstractPageUI.YEAR_DROPDOWNLIST);
		updateYear = getSelectedValueInDropdown(driver, AbstractPageUI.YEAR_DROPDOWNLIST);
		return isElementDisplayed(driver, AbstractPageUI.YEAR_DROPDOWNLIST, updateYear);
	}

	public boolean isEmailDisplay(String updateEmail) {
		waitForElementVisible(driver, AbstractPageUI.EMAIL_TEXTBOX);
		updateEmail = getElementAttribute(driver, AbstractPageUI.EMAIL_TEXTBOX, "value");
		return isElementDisplayed(driver, AbstractPageUI.EMAIL_TEXTBOX, updateEmail);
	}

	public boolean isCompanyNameDisplay(String updatecompanyName) {
		waitForElementVisible(driver, AbstractPageUI.COMPANYNAME_TEXTBOX);
		updatecompanyName = getElementAttribute(driver, AbstractPageUI.COMPANYNAME_TEXTBOX, "value");
		return isElementDisplayed(driver, AbstractPageUI.COMPANYNAME_TEXTBOX, updatecompanyName);
	}

	public MyAccount_AddressesPageObject clickToAddressesText() {
		waitForElementVisible(driver, User_MyAccountPageUI.ADDRESSES_TAB_TEXT);
		clickToElement(driver, User_MyAccountPageUI.ADDRESSES_TAB_TEXT);
		return PageGeneratorManager.getAddressesPageObject(driver);
	}

	public MyAccount_ChangePassWordPageObject clickToChangePassWord() {
		waitForElementVisible(driver, User_MyAccountPageUI.CHANGE_PASSWORD_TAB_TEXT);
		clickToElement(driver, User_MyAccountPageUI.CHANGE_PASSWORD_TAB_TEXT);
		return PageGeneratorManager.getChangePassWordPageObject(driver);
	}

}
