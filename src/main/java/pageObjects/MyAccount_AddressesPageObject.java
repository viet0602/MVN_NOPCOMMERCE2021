package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.MyAccount_AddressesPageUI;

public class MyAccount_AddressesPageObject extends AbstractPage {
	WebDriver driver;

	public MyAccount_AddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public MyAccount_AddressesPageObject clickToAddNewButton() {
		waitForElementVisible(driver, MyAccount_AddressesPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, MyAccount_AddressesPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAddressesPageObject(driver);
	}

	public void inputFirstNameAddress(String firstNameAdd) {
		waitForElementVisible(driver, MyAccount_AddressesPageUI.FIRST_NAME_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAccount_AddressesPageUI.FIRST_NAME_ADDRESS_TEXTBOX, firstNameAdd);

	}

	public void inputLastNameAddress(String lastNameAdd) {
		waitForElementVisible(driver, MyAccount_AddressesPageUI.LAST_NAME_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAccount_AddressesPageUI.LAST_NAME_ADDRESS_TEXTBOX, lastNameAdd);

	}

	public void inputEmailAddress(String emailAdd) {
		waitForElementVisible(driver, MyAccount_AddressesPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAccount_AddressesPageUI.EMAIL_ADDRESS_TEXTBOX, emailAdd);

	}

	public void inputCompanyNameAddress(String companyNameAdd) {
		waitForElementVisible(driver, MyAccount_AddressesPageUI.COMPANY_NAME_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAccount_AddressesPageUI.COMPANY_NAME_ADDRESS_TEXTBOX, companyNameAdd);
	}

	public void selectCountry(String countryName) {
		waitForElementVisible(driver, MyAccount_AddressesPageUI.COUNTRY_NAME_DROPDOWN);
		selectValueInDropdown(driver, MyAccount_AddressesPageUI.COUNTRY_NAME_DROPDOWN, countryName);
	}

	public void selectState(String stateName) {
		waitForElementVisible(driver, MyAccount_AddressesPageUI.STATE_NAME_DROPDOWN);
		selectValueInDropdown(driver, MyAccount_AddressesPageUI.STATE_NAME_DROPDOWN, stateName);

	}

	public void inputCityNameAddress(String cityNameAdd) {
		waitForElementVisible(driver, MyAccount_AddressesPageUI.CITY_NAME_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAccount_AddressesPageUI.CITY_NAME_ADDRESS_TEXTBOX, cityNameAdd);

	}

	public void inputAddress2Name(String addName2) {
		waitForElementVisible(driver, MyAccount_AddressesPageUI.ADDRESS2_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccount_AddressesPageUI.ADDRESS2_NAME_TEXTBOX, addName2);

	}

	public void inputAddress1Name(String addressName1) {
		waitForElementVisible(driver, MyAccount_AddressesPageUI.ADDRESS1_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccount_AddressesPageUI.ADDRESS1_NAME_TEXTBOX, addressName1);

	}

	public void inputPostalCode(String postalCode) {
		waitForElementVisible(driver, MyAccount_AddressesPageUI.POSTAL_CODE_TEXTBOX);
		sendkeyToElement(driver, MyAccount_AddressesPageUI.POSTAL_CODE_TEXTBOX, postalCode);

	}

	public void inputPhoneNumber(String phoneNumber) {
		waitForElementVisible(driver, MyAccount_AddressesPageUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, MyAccount_AddressesPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);

	}

	public void inputFaxNumber(String faxNumber) {
		waitForElementVisible(driver, MyAccount_AddressesPageUI.FAX_NUMBER_TEXTBOX);
		sendkeyToElement(driver, MyAccount_AddressesPageUI.FAX_NUMBER_TEXTBOX, faxNumber);

	}

	public void clickToSaveButton() {
		waitForElementVisible(driver, MyAccount_AddressesPageUI.SAVE_BUTTON);
		clickToElement(driver, MyAccount_AddressesPageUI.SAVE_BUTTON);
	}

	public boolean isInfoAddressDisplay(String iDClass, String text) {
		waitForElementVisible(driver, MyAccount_AddressesPageUI.DYNAMIC_VERIFY_INFO_TEXTFIELD,iDClass,text);
		return isElementDisplayed(driver, MyAccount_AddressesPageUI.DYNAMIC_VERIFY_INFO_TEXTFIELD,iDClass,text);
	}

}
