package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.StartPageObject;
import pageObjects.User_HomePageObject;
import pageObjects.User_RegisterPageObject;

public class Register_06 extends AbstractTest {
	WebDriver driver;
	StartPageObject startPage;
	User_HomePageObject homePage;
	User_RegisterPageObject registerPage;

	String invalidEmail = "invalidEmail";
	String exitsEmail = "automationfc.vn@gmail.com";
	String lessthan6charspassWord = "12345";
	String confirmPassWord = GlobalConstants.password;
	String wrongconfirmPassWord = "12345679";
	String companyName = "Manual Testing" + randomNumber();
	String day = "6";
	String month = "May";
	String year = "1980";

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Open Browser");
		driver = getBrowserDriver(browserName);
		startPage = PageGeneratorManager.getStartPageObject(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		log.info("Click Register in Header Text");
		registerPage = startPage.clickToRegisterHeaderText();
	}

	public void TC_01_RegisterEmptyData() {
		log.info("TC_01_RegisterEmptyData");
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isErrorMessageDisplay(driver, "First name is required."));
		verifyTrue(registerPage.isErrorMessageDisplay(driver, "Last name is required."));
		verifyTrue(registerPage.isErrorMessageDisplay(driver, "Email is required."));
		verifyTrue(registerPage.isErrorMessageDisplay(driver, "Password is required."));
		verifyTrue(registerPage.isErrorMessageDisplay(driver, "Password is required."));

	}

	public void TC_02_RegisterInvalidEmail() {
		log.info("TC_02_RegisterInvalidEmail");
		registerPage.selectGender(driver);
		registerPage.inputFirstName(driver,GlobalConstants.firstName);
		registerPage.inputLasttName(driver, GlobalConstants.lastName);
		registerPage.selectDay(driver, day);
		registerPage.selectMonth(driver, month);
		registerPage.selectYear(driver, year);
		registerPage.inputEmail(driver, invalidEmail);
		registerPage.inputCompanyName(driver, companyName);
		registerPage.inputPassWord(driver, GlobalConstants.password);
		registerPage.inputConfirmPassWord(confirmPassWord);
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isErrorMessageDisplay(driver, "Wrong email"));
	}

	public void TC_03_RegisterPassWordLessThan6Characters() {
		log.info("TC_03_RegisterPassWordLessThan6Characters");
		registerPage.selectGender(driver);
		registerPage.inputFirstName(driver, GlobalConstants.firstName);
		registerPage.inputLasttName(driver, GlobalConstants.lastName);
		registerPage.selectDay(driver, day);
		registerPage.selectMonth(driver, month);
		registerPage.selectYear(driver, year);
		registerPage.inputEmail(driver, GlobalConstants.email);
		registerPage.inputCompanyName(driver, companyName);
		registerPage.inputPassWord(driver, lessthan6charspassWord);
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isPassWordLessThan6CharactersErrorMessageDisplay());
	}

	public void TC_04_RegisterWrongConfirmPassWord() {
		log.info("TC_04_RegisterWrongConfirmPassWord");
		registerPage.selectGender(driver);
		registerPage.inputFirstName(driver,GlobalConstants. firstName);
		registerPage.inputLasttName(driver, GlobalConstants.lastName);
		registerPage.selectDay(driver, day);
		registerPage.selectMonth(driver, month);
		registerPage.selectYear(driver, year);
		registerPage.inputEmail(driver, GlobalConstants.email);
		registerPage.inputCompanyName(driver, companyName);
		registerPage.inputPassWord(driver, GlobalConstants.password);
		registerPage.inputConfirmPassWord(wrongconfirmPassWord);
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isErrorMessageDisplay(driver, "The password and confirmation password do not match."));
	}

	@Test
	public void TC_05_RegisterValidInfor() {
		log.info("TC_05_RegisterValidInfor");
		registerPage.selectGender(driver);
		registerPage.inputFirstName(driver,GlobalConstants. firstName);
		registerPage.inputLasttName(driver,GlobalConstants. lastName);
		registerPage.selectDay(driver, day);
		registerPage.selectMonth(driver, month);
		registerPage.selectYear(driver, year);
		registerPage.inputEmail(driver, GlobalConstants.email);
		registerPage.inputCompanyName(driver, companyName);
		registerPage.inputPassWord(driver, GlobalConstants.password);
		registerPage.inputConfirmPassWord(confirmPassWord);
		homePage = registerPage.clickToRegisterButton();
		verifyTrue(homePage.isCompleteRegisterTextDisplay(driver));
		startPage = homePage.clickToLogOutHeaderText(driver);
	}

	public void TC_06_RegisterExitsEmail() {
		log.info("TC_06_RegisterExitsEmail");
		registerPage.selectGender(driver);
		registerPage.inputFirstName(driver,GlobalConstants. firstName);
		registerPage.inputLasttName(driver, GlobalConstants.lastName);
		registerPage.selectDay(driver, day);
		registerPage.selectMonth(driver, month);
		registerPage.selectYear(driver, year);
		registerPage.inputEmail(driver, GlobalConstants.email);
		registerPage.inputCompanyName(driver, companyName);
		registerPage.inputPassWord(driver, GlobalConstants.password);
		registerPage.inputConfirmPassWord(confirmPassWord);
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isExistEmailErrorMessageDisplay(driver, "The specified email already exists"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
