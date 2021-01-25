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
import pageObjects.User_LoginPageObject;
import pageObjects.User_RegisterPageObject;

public class Login_06 extends AbstractTest {
	WebDriver driver;
	StartPageObject startPage;
	User_LoginPageObject loginPage;
	User_HomePageObject homePage;
	User_RegisterPageObject registerPage;

	String invalidEmail = "invalidEmail";
	
	String NotYetRegisterEmail = "notyetregister" + randomNumber() + "@gmail.com";
	String wrongPassWord = "1234678";
	String exitsEmail = "automationfc.vn@gmail.com";
	String firstName = "Nguyen";
	String lastName = "Minh" + randomNumber();
	String confirmPassWord = GlobalConstants.password;
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
//		registerPage = startPage.clickToRegisterHeaderText();
//		registerPage.selectGender(driver);
//		registerPage.inputFirstName(driver,firstName);
//		registerPage.inputLasttName(driver,lastName);
//		registerPage.selectDay(driver,day);
//		registerPage.selectMonth(driver,month);
//		registerPage.selectYear(driver,year);
//		registerPage.inputEmail(driver, GlobalConstants.email);
//		registerPage.inputCompanyName(driver,companyName);
//		registerPage.inputPassWord(driver, GlobalConstants.password);
//		registerPage.inputConfirmPassWord(confirmPassWord);
//		homePage = registerPage.clickToRegisterButton();
//		verifyTrue(homePage.isCompleteRegisterTextDisplay(driver));
//		startPage= homePage.clickToLogOutHeaderText(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		log.info("Click Login in Header Text");
		loginPage = startPage.clickToLoginHeaderText();
	}

	@Test
	public void TC_01_LoginEmptyData() {
		log.info("TC_01_LoginEmptyData");
		loginPage.inputEmail(driver, "");
		loginPage.inputPassWord(driver,"");
		loginPage.clickToLoginButton();
		verifyTrue(loginPage.isErrorMessageDisplay(driver, "Please enter your email"));

	}

	@Test
	public void TC_02_LoginInvalidEmail() {
		log.info("TC_02_LoginInvalidEmail");
		loginPage.inputEmail(driver, invalidEmail);
		loginPage.clickToLoginButton();
		verifyTrue(loginPage.isErrorMessageDisplay(driver, "Wrong email"));
	}
	@Test
	public void TC_03_LoginNotYetRegisterEmail() {
		log.info("TC_03_LoginNotYetRegisterEmail");
		loginPage.inputEmail(driver, NotYetRegisterEmail);
		loginPage.inputPassWord(driver, GlobalConstants.password);
		loginPage.clickToLoginButton();
		verifyTrue(loginPage.isErrorMessageLoginWrongEmailDisplay(driver));
	}

	@Test
	public void TC_04_LoginWithoutPassWord() {
		log.info("TC_04_LoginWithoutPassWord");
		loginPage.inputEmail(driver, GlobalConstants.email);
		loginPage.inputPassWord(driver,"");
		loginPage.clickToLoginButton();
		verifyTrue(loginPage.isErrorMessageLoginWithOutPassWordDisplay());
	}

	@Test
	public void TC_05_LoginWrongPassWord() {
		log.info("TC_05_LoginWrongPassWord");
		loginPage.inputEmail(driver, GlobalConstants.email);
		loginPage.inputPassWord(driver, wrongPassWord);
		loginPage.clickToLoginButton();
		verifyTrue(loginPage.isErrorMessageLoginWithOutPassWordDisplay());
	}
	@Test
	public void TC_06_LoginValidInfor() {
		log.info("TC_06_LoginValidInfor");
		loginPage.inputEmail(driver, GlobalConstants.email);
		loginPage.inputPassWord(driver, GlobalConstants.password);
		homePage = loginPage.clickToLoginButton();
		verifyTrue(homePage.isLogOutHeaderDisplay());
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
