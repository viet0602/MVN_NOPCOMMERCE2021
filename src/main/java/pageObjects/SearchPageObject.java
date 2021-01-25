package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.SearchPageUI;

public class SearchPageObject extends AbstractPage {
	WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputTextInSearchBox(String keyString) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_FOOTER_TEXTBOX);
		sendkeyToElement(driver, SearchPageUI.SEARCH_FOOTER_TEXTBOX, keyString);

	}

	public void clickToSearchButton() {
		scrollToElementByJS(driver, SearchPageUI.SEARCH_FOOTER_BUTTON);
		waitForElementVisible(driver, SearchPageUI.SEARCH_FOOTER_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_FOOTER_BUTTON);

	}

	public boolean isErrorMessageDisplay(String messageError) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_ERROR_MESSAGE, messageError);
		return isElementDisplayed(driver, SearchPageUI.SEARCH_ERROR_MESSAGE, messageError);
	}

	public boolean isResultRelativeDataDisplay(String searchKey) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_RELATIVE_RESULT_TITLE_TEXT, searchKey);
		return isElementDisplayed(driver, SearchPageUI.SEARCH_RELATIVE_RESULT_TITLE_TEXT, searchKey);
	}

	public void clickToAdvancedSearch() {
		waitForElementVisible(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
		clickToElement(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);

	}

	public void selectCategory(String categoryName) {
		waitForElementVisible(driver, SearchPageUI.CATEGORY_DROPDOWN);
		selectValueInDropdown(driver,SearchPageUI.CATEGORY_DROPDOWN, categoryName);
	}

	public void clickToSubCategories() {
		waitForElementVisible(driver, SearchPageUI.SUB_CATEGORY_CHECKBOX);
		clickToElement(driver, SearchPageUI.SUB_CATEGORY_CHECKBOX);	
	}

	public void selectManufacture(String manuFactureName) {
		waitForElementVisible(driver, SearchPageUI.MANUFACTURER_LIST_DROPDOWN);
		selectValueInDropdown(driver,SearchPageUI.MANUFACTURER_LIST_DROPDOWN, manuFactureName);
		
	}
}
