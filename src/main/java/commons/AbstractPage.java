package commons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.StartPageObject;
import pageUIs.AbstractPageUI;
import pageUIs.User_HomePageUI;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public abstract class AbstractPage {

	public By byXpath(String locator) {
		return By.xpath(locator);
	}

	// Dynamic Locator
	public String castToObject(String locator, String... values) {
		return String.format(locator, (Object[]) values);
	}

	public WebElement findElementByXpath(WebDriver driver, String locator) {
		return driver.findElement(byXpath(locator));
	}

	public void openUrl(WebDriver driver, String urlValue) {
		driver.get(urlValue);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public List<WebElement> findElementsByXpath(WebDriver driver, String locator) {
		return driver.findElements(byXpath(locator));
	}

	public void clickToElement(WebDriver driver, String locator) {
		findElementByXpath(driver, locator).click();
	}

	// Dynamic locator
	public void clickToElement(WebDriver driver, String locator, String... values) {
		findElementByXpath(driver, castToObject(locator, values)).click();
	}

	public void clearTextBox(WebDriver driver, String locator) {
		findElementByXpath(driver, locator).clear();
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", findElementByXpath(driver, locator));
	}

	// Dynamic locator
	public void clickToElementByJS(WebDriver driver, String locator, String... values) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", findElementByXpath(driver, castToObject(locator, values)));
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		findElementByXpath(driver, locator).sendKeys(value);
	}

	public String getElementText(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).getText().trim();
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return findElementByXpath(driver, locator).getAttribute(attributeName);
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).isDisplayed();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).isSelected();
	}

	// Dynamic Locator
	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		return findElementByXpath(driver, castToObject(locator, values)).isDisplayed();
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(locator)));
	}

	public void waitForElementsVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byXpath(locator)));
	}

	// Dynamic Locator
	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(castToObject(locator, values))));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(locator)));
	}

	public void waitForElementsInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		elements = findElementsByXpath(driver, locator);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}

	public void scrollToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", findElementByXpath(driver, locator));
	}

	// Dynamic locator
	public void scrollToElementByJS(WebDriver driver, String locator, String... values) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);",
				findElementByXpath(driver, castToObject(locator, values)));
	}

	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(findElementByXpath(driver, locator), key).perform();
	}

	public void selectValueInDropdown(WebDriver driver, String locator, String value) {
		select = new Select(findElementByXpath(driver, locator));
		select.selectByVisibleText(value);
	}

	public String getSelectedValueInDropdown(WebDriver driver, String locator) {
		select = new Select(findElementByXpath(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public void checkToCheckBox(WebDriver driver, String locator) {
		element = findElementByXpath(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckBox(WebDriver driver, String locator) {
		element = findElementByXpath(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public int countElementNumber(WebDriver driver, String locator) {
		elements = findElementsByXpath(driver, locator);
		return elements.size();
	}

	// Dynamic locator
	public int countElementNumber(WebDriver driver, String locator, String... values) {
		elements = findElementsByXpath(driver, castToObject(locator, values));
		return elements.size();
	}

	// For Nop commerce Project

	public void inputEmail(WebDriver driver, String email) {
		waitForElementVisible(driver, AbstractPageUI.EMAIL_TEXTBOX);
		clearTextBox(driver, AbstractPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AbstractPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputPassWord(WebDriver driver, String passWord) {
		waitForElementVisible(driver, AbstractPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AbstractPageUI.PASSWORD_TEXTBOX, passWord);
	}

	public boolean isErrorMessageDisplay(WebDriver driver, String errorMessage) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_ERROR_MESSAGE, errorMessage);
		return isElementDisplayed(driver, AbstractPageUI.DYNAMIC_ERROR_MESSAGE, errorMessage);
	}

	public StartPageObject clickToLogOutHeaderText(WebDriver driver) {
		waitForElementVisible(driver, User_HomePageUI.LOGOUT_HEADER_TEXT);
		clickToElementByJS(driver, User_HomePageUI.LOGOUT_HEADER_TEXT);
		return PageGeneratorManager.getStartPageObject(driver);

	}

	public void selectGender(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.GENDER_SELECTBOX);
		clickToElement(driver, AbstractPageUI.GENDER_SELECTBOX);

	}

	public void inputLasttName(WebDriver driver, String lastName) {
		waitForElementVisible(driver, AbstractPageUI.LASTNAME_TEXTBOX);
		clearTextBox(driver, AbstractPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, AbstractPageUI.LASTNAME_TEXTBOX, lastName);

	}

	public void inputFirstName(WebDriver driver, String firstName) {
		waitForElementVisible(driver, AbstractPageUI.FIRSTNAME_TEXTBOX);
		clearTextBox(driver, AbstractPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, AbstractPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void selectDay(WebDriver driver, String day) {
		waitForElementVisible(driver, AbstractPageUI.DAY_DROPDOWNLIST);
		selectValueInDropdown(driver, AbstractPageUI.DAY_DROPDOWNLIST, day);

	}

	public void selectMonth(WebDriver driver, String month) {
		waitForElementVisible(driver, AbstractPageUI.MONTH_DROPDOWNLIST);
		selectValueInDropdown(driver, AbstractPageUI.MONTH_DROPDOWNLIST, month);

	}

	public void selectYear(WebDriver driver, String year) {
		waitForElementVisible(driver, AbstractPageUI.YEAR_DROPDOWNLIST);
		selectValueInDropdown(driver, AbstractPageUI.YEAR_DROPDOWNLIST, year);

	}

	public void inputCompanyName(WebDriver driver, String companyName) {
		waitForElementVisible(driver, AbstractPageUI.COMPANYNAME_TEXTBOX);
		clearTextBox(driver, AbstractPageUI.COMPANYNAME_TEXTBOX);
		sendkeyToElement(driver, AbstractPageUI.COMPANYNAME_TEXTBOX, companyName);

	}

	private List<WebElement> elements;
	private WebDriverWait explicitWait;
	private long longTimeout = 30;
	private JavascriptExecutor jsExecutor;
	private Actions action;
	private Select select;
	private WebElement element;

}
