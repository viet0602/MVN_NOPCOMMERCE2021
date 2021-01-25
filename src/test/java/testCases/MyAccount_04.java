package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.ComputersPageObject;
import pageObjects.Computers_DesktopsPageObject;
import pageObjects.Computers_Desktops_ProductDetailPageObject;
import pageObjects.Computers_Desktops_ProductDetail_ReviewPageObject;
import pageObjects.MyAccount_AddressesPageObject;
import pageObjects.MyAccount_ChangePassWordPageObject;
import pageObjects.StartPageObject;
import pageObjects.User_HomePageObject;
import pageObjects.User_LoginPageObject;
import pageObjects.User_MyAccount_CustomerInfoPageObject;
import pageObjects.User_RegisterPageObject;

public class MyAccount_04 extends AbstractTest {
	WebDriver driver;
	StartPageObject startPage;
	User_HomePageObject homePage;
	User_RegisterPageObject registerPage;
	User_LoginPageObject loginPage;
	User_MyAccount_CustomerInfoPageObject myAccount_CustomerInfoPage;
	MyAccount_AddressesPageObject addressesPage;
	MyAccount_ChangePassWordPageObject changePassWordPage;
	ComputersPageObject computerPage;
	Computers_DesktopsPageObject desktopPage;
	Computers_Desktops_ProductDetailPageObject detailPage;
	Computers_Desktops_ProductDetail_ReviewPageObject reviewPage;

	String updateGender = "gender-male";
	String updateFirstName = "Automation";
	String updateLastName = "FC";
	String updateDate = "1";
	String updateMonth = "January";
	String updateYear = "1999";
	String updateEmail = "automationfc.vn@gmail.com";
	String updatecompanyName = "AutomationFC";

	String firstNameAdd = "Automation ";
	String lastNameAdd = "FC";
	String name = firstNameAdd + lastNameAdd;
	String emailAdd = updateEmail;
	String companyNameAdd = updatecompanyName;
	String countryName = "Viet Nam";
	String stateName = "Other";
	String cityNameAdd = "Da Nang";
	String addressName1 = "123/04 Le Lai";
	String addName2 = "234/05 Hai Phong";
	String postalCode = " 550000";
	String phoneNumber = " 0123456789";
	String faxNumber = " 0987654321";
	String citystatezip = cityNameAdd + "," + postalCode;

	String newpassword = "234567";
	String titleReview = "Vicky Testing Review Title";
	String bodyReview = "Vicky Testing Review Body";
	String productName = "Digital Storm VANQUISH 3 Custom Performance PC";

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Open Browser");
		driver = getBrowserDriver(browserName);
		log.info("Open Start Page");
		startPage = PageGeneratorManager.getStartPageObject(driver);

	}

	@Test
	public void TC_01_UpdateCustomer() {
		log.info("TC_01_UpdateCustomer");
		log.info("Click Login in Header Text");
		loginPage = startPage.clickToLoginHeaderText();
		log.info("Input email");
		loginPage.inputEmail(driver, GlobalConstants.email);
		log.info("Input password");
		loginPage.inputPassWord(driver, GlobalConstants.password);
		homePage = loginPage.clickToLoginButton();
		log.info("Click My account in Header Text");
		myAccount_CustomerInfoPage = homePage.clickToMyAccountHeader(driver);
		myAccount_CustomerInfoPage.selectGender(driver);
		myAccount_CustomerInfoPage.inputFirstName(driver, updateFirstName);
		myAccount_CustomerInfoPage.inputLasttName(driver, updateLastName);
		myAccount_CustomerInfoPage.selectDay(driver, updateDate);
		myAccount_CustomerInfoPage.selectMonth(driver, updateMonth);
		myAccount_CustomerInfoPage.selectYear(driver, updateYear);
		myAccount_CustomerInfoPage.inputEmail(driver, updateEmail);
		myAccount_CustomerInfoPage.inputCompanyName(driver, updatecompanyName);
		log.info("Click Save button");
		myAccount_CustomerInfoPage.clickToSaveButton();
		verifyTrue(myAccount_CustomerInfoPage.isFirstNameDisplay(updateFirstName));
		verifyTrue(myAccount_CustomerInfoPage.isLastNameDisplay(updateLastName));
		verifyTrue(myAccount_CustomerInfoPage.isDayDisplay(updateDate));
		verifyTrue(myAccount_CustomerInfoPage.isMonthDisplay(updateMonth));
		verifyTrue(myAccount_CustomerInfoPage.isYearDisplay(updateYear));
		verifyTrue(myAccount_CustomerInfoPage.isEmailDisplay(updateEmail));
		verifyTrue(myAccount_CustomerInfoPage.isCompanyNameDisplay(updatecompanyName));
	}

	@Test
	public void TC_02_AddAdress() {
		log.info("TC_02_AddAdress");
		log.info("Click My account in Header Text");
		myAccount_CustomerInfoPage = homePage.clickToMyAccountHeader(driver);
		log.info("Click to Addresses Text Tab");
		addressesPage = myAccount_CustomerInfoPage.clickToAddressesText();
		log.info("Click to Add New button");
		addressesPage.clickToAddNewButton();
		addressesPage.inputFirstNameAddress(firstNameAdd);
		addressesPage.inputLastNameAddress(lastNameAdd);
		addressesPage.inputEmailAddress(emailAdd);
		addressesPage.inputCompanyNameAddress(companyNameAdd);
		addressesPage.selectCountry(countryName);
		addressesPage.selectState(stateName);
		addressesPage.inputCityNameAddress(cityNameAdd);
		addressesPage.inputAddress1Name(addressName1);
		addressesPage.inputAddress2Name(addName2);
		addressesPage.inputPostalCode(postalCode);
		addressesPage.inputPhoneNumber(phoneNumber);
		addressesPage.inputFaxNumber(faxNumber);
		addressesPage.clickToSaveButton();
		log.info("Verify name");
		verifyTrue(addressesPage.isInfoAddressDisplay("name", name));
		log.info("Verify email");
		verifyTrue(addressesPage.isInfoAddressDisplay("email", emailAdd));
		log.info("Verify phone");
		verifyTrue(addressesPage.isInfoAddressDisplay("phone", phoneNumber));
		log.info("Verify fax");
		verifyTrue(addressesPage.isInfoAddressDisplay("fax", faxNumber));
		log.info("Verify company");
		verifyTrue(addressesPage.isInfoAddressDisplay("company", companyNameAdd));
		log.info("Verify address1");
		verifyTrue(addressesPage.isInfoAddressDisplay("address1", addressName1));
		log.info("Verify address2");
		verifyTrue(addressesPage.isInfoAddressDisplay("address2", addName2));
		log.info("Verify city state");
		verifyTrue(addressesPage.isInfoAddressDisplay("city-state-zip", citystatezip));
		log.info("Verify Country name");
		verifyTrue(addressesPage.isInfoAddressDisplay("country", countryName));
	}

	@Test
	public void TC_03_ChangePassWord() {
		log.info("TC_03_ChangePassWord");
		log.info("Click My account in Header Text");
		myAccount_CustomerInfoPage = homePage.clickToMyAccountHeader(driver);
		changePassWordPage = myAccount_CustomerInfoPage.clickToChangePassWord();
		changePassWordPage.inputOldPassWord(GlobalConstants.password);
		changePassWordPage.inputNewPassWord(newpassword);
		changePassWordPage.inputConfirmPassWord(newpassword);
		changePassWordPage.clickToChangePassWordButton();
		verifyTrue(changePassWordPage.isMessageChangePWSuccessDisplay());
		startPage = changePassWordPage.clickToLogOutHeaderText(driver);
		loginPage = startPage.clickToLoginHeaderText();
		loginPage.inputEmail(driver, GlobalConstants.email);
		loginPage.inputPassWord(driver, GlobalConstants.password);
		loginPage.clickToLoginButton();
		verifyTrue(loginPage.isErrorMessageLoginWithOutPassWordDisplay());
		loginPage.inputEmail(driver, GlobalConstants.email);
		loginPage.inputPassWord(driver, newpassword);
		homePage = loginPage.clickToLoginButton();
		verifyTrue(homePage.isLogOutHeaderDisplay());
	}

	@Test
	public void TC_04_MyProductReview() {
		log.info("TC_04_MyProductReview");
		computerPage = homePage.clickToComputersTextTab();
		desktopPage = computerPage.clickToDesktopsSubItemText();
		detailPage = desktopPage.clickToOneProduct(productName);
		reviewPage = detailPage.clickToAddYourReViewText();
		reviewPage.inputTitleReview(titleReview);
		reviewPage.inputBodyReview(bodyReview);
		reviewPage.selectRatingReview();
		reviewPage.clickToSubmitReviewButton();
		verifyTrue(reviewPage.isReviewSuccessAddedMessageDisplay());
		verifyTrue(reviewPage.isReviewTittleDisplay(titleReview));
		verifyTrue(reviewPage.isReviewBodyDisplay(bodyReview));
		verifyTrue(reviewPage.isReviewNameDisplay(GlobalConstants.firstName));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
