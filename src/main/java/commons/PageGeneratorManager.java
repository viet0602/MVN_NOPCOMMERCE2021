package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.ComputersPageObject;
import pageObjects.Computers_DesktopsPageObject;
import pageObjects.Computers_Desktops_ProductDetailPageObject;
import pageObjects.Computers_Desktops_ProductDetail_ReviewPageObject;
import pageObjects.MyAccount_AddressesPageObject;
import pageObjects.MyAccount_ChangePassWordPageObject;
import pageObjects.SearchPageObject;
import pageObjects.StartPageObject;
import pageObjects.User_HomePageObject;
import pageObjects.User_LoginPageObject;
import pageObjects.User_MyAccount_CustomerInfoPageObject;
import pageObjects.User_RegisterPageObject;

public class PageGeneratorManager {
	public static User_HomePageObject getHomePageObject(WebDriver driver) {
		return new User_HomePageObject(driver);
	}

	public static StartPageObject getStartPageObject(WebDriver driver) {
		return new StartPageObject(driver);
	}

	public static User_RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new User_RegisterPageObject(driver);
	}

	public static User_LoginPageObject getLoginPageObject(WebDriver driver) {
		return new User_LoginPageObject(driver);
	}

	public static User_MyAccount_CustomerInfoPageObject getMyAccountCustomerInfoPageObject(WebDriver driver) {
		return new User_MyAccount_CustomerInfoPageObject(driver);
	}

	public static MyAccount_AddressesPageObject getAddressesPageObject(WebDriver driver) {
		return new MyAccount_AddressesPageObject(driver);
	}

	public static MyAccount_ChangePassWordPageObject getChangePassWordPageObject(WebDriver driver) {
		return new MyAccount_ChangePassWordPageObject(driver);
	}

	public static Computers_DesktopsPageObject getComputers_DesktopsPageObject(WebDriver driver) {
		return new Computers_DesktopsPageObject(driver);
	}

	public static ComputersPageObject getComputersPageObject(WebDriver driver) {
		return new ComputersPageObject(driver);
	}

	public static Computers_Desktops_ProductDetailPageObject getComputers_Desktops_ProductDetailPageObject(
			WebDriver driver) {
		return new Computers_Desktops_ProductDetailPageObject(driver);
	}
	public static Computers_Desktops_ProductDetail_ReviewPageObject getComputers_Desktops_ProductDetail_ReviewPageObject(
			WebDriver driver) {
		return new  Computers_Desktops_ProductDetail_ReviewPageObject(driver);
	}
	public static SearchPageObject getSearchPageObject(WebDriver driver) {
		return new  SearchPageObject(driver);
	}

	//testing
}
