package pageUIs;

public class AbstractPageUI {
	public static String REGISTER_HEADER_TEXT = "//a[contains(text(),'Register')]";
	public static String LOGIN_HEADER_TEXT = "//a[contains(text(),'Log in')]";
	public static String WHISHLIST_HEADER_TEXT = "//span[contains(text(),'Wishlist')]";
	public static String SHOPPINGCART_HEADER_TEXT = "//span[contains(text(),'Shopping cart')]";

	public static String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static String GENDER_SELECTBOX = "//input[@id='gender-male']";
	public static String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
	public static String LASTNAME_TEXTBOX = "//input[@id='LastName']";
	public static String DAY_DROPDOWNLIST = "//select[@name='DateOfBirthDay']";
	public static String MONTH_DROPDOWNLIST = "//select[@name='DateOfBirthMonth']";
	public static String YEAR_DROPDOWNLIST = "//select[@name='DateOfBirthYear']";
	public static String DYNAMIC_DATEOFBIRTH_DROPDOWNLIST = "//select[@name='%s']";

	public static String COMPANYNAME_TEXTBOX = "//input[@id='Company']";
	public static String DYNAMIC_ERROR_MESSAGE = "//span[text()='%s']";

	public static String DYNAMIC_PRODUCTTAB_TEXT = "//ul[@class='top-menu notmobile']//a[text()='Computers ']";
	public static String COMPUTERS_TAB_TEXT = "//ul[@class='top-menu notmobile']//a[text()='Computers ']";

}
