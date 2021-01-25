package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.SearchPageObject;
import pageObjects.StartPageObject;
import pageObjects.User_HomePageObject;
import pageObjects.User_LoginPageObject;
import pageObjects.User_RegisterPageObject;

public class Search_AdvantageSearch_11 extends AbstractTest {
	WebDriver driver;
	StartPageObject startPage;
	User_HomePageObject homePage;
	User_RegisterPageObject registerPage;
	User_LoginPageObject loginPage;
	SearchPageObject searchPage;

	String emptyDataErrorMessage = "Search term minimum length is 3 characters";
	String NotExistDataErrorMessag = "No products were found that matched your criteria.";
	String advanced_Search_ParentCategoriesErrorMessage = "No products were found that matched your criteria.";
	String searchKeyNotExist = "Mac Book Pro 2060";
	String searchKeyRelative = "Apple";
	String searchKeyAbsolute = "ThinkPad X1 Carbon";
	String advantacedSearchParentCategoriesKey = "Apple MacBookPro";
	String categoryName = "Computers";
	String manuFactureName = "HP";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Open Browser");
		driver = getBrowserDriver(browserName);
		log.info("Open Start Page");
		startPage = PageGeneratorManager.getStartPageObject(driver);
		log.info("Click Login in Header Text");
		loginPage = startPage.clickToLoginHeaderText();
		log.info("Input email");
		loginPage.inputEmail(driver, GlobalConstants.email);
		log.info("Input password");
		loginPage.inputPassWord(driver, GlobalConstants.password);
		homePage = loginPage.clickToLoginButton();
	}

	@BeforeMethod
	public void beforeMethod() {
		searchPage = homePage.clickToSearchFooter();
	}

	@Test
	public void TC_01_Search_EmptyData() {
		log.info("TC_01_Search_EmptyData");
		searchPage.inputTextInSearchBox("");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isErrorMessageDisplay(emptyDataErrorMessage));
	}

	@Test
	public void TC_02_Search_NotExistData() {
		log.info("TC_02_Search_NotExistData");
		searchPage.inputTextInSearchBox(searchKeyNotExist);
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isErrorMessageDisplay(NotExistDataErrorMessag));
	}

	@Test
	public void TC_03_Search_RelativeProductName() {
		log.info("TC_03_Search_RelativeProductName");
		searchPage.inputTextInSearchBox(searchKeyRelative);
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isResultRelativeDataDisplay(searchKeyRelative));
	}

	public void TC_04_Search_AbsoluteProductName() {
		log.info("TC_04_Search_RelativeProductName");
		searchPage.inputTextInSearchBox(searchKeyAbsolute);
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isResultRelativeDataDisplay(searchKeyAbsolute));
	}

	public void TC_05_Advanced_Search_ParentCategories() {
		log.info("TC_05_Advanced_Search_ParentCategories");
		searchPage.inputTextInSearchBox(advantacedSearchParentCategoriesKey);
		searchPage.clickToAdvancedSearch();
		searchPage.selectCategory(categoryName);
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isErrorMessageDisplay(advanced_Search_ParentCategoriesErrorMessage));
	}

	public void TC_06_Advanced_Search_SubCategories() {
		log.info("TC_06_Advanced_Search_SubCategories");
		searchPage.inputTextInSearchBox(advantacedSearchParentCategoriesKey);
		searchPage.clickToAdvancedSearch();
		searchPage.selectCategory(categoryName);
		searchPage.clickToSubCategories();
		searchPage.selectManufacture(manuFactureName);	
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isErrorMessageDisplay(advanced_Search_ParentCategoriesErrorMessage));
	}

}
