package pageUIs;

public class SearchPageUI {
	public static String SEARCH_FOOTER_TEXTBOX = "//input[@class='search-text']";
	public static String ADVANTAGE_TEXT = "//label[text()='Advanced search']";
	public static String SEARCH_FOOTER_BUTTON = "//div[@class='buttons']//input[@value='Search']";
	public static String SEARCH_ERROR_MESSAGE = "//div[@class='search-results']//div[text()='%s']";
	public static String SEARCH_RELATIVE_RESULT_TITLE_TEXT = "//div[@class='search-results']//a[contains(text(),'%s')]";
	public static String ADVANCED_SEARCH_CHECKBOX = "//label[text()='Advanced search']";
	public static String CATEGORY_DROPDOWN = "//label[text()='Category:']/parent::div[@class='inputs']/select";
	public static String SUB_CATEGORY_CHECKBOX="//label[contains(text(),'Automatically search sub categories')]";
	public static String MANUFACTURER_LIST_DROPDOWN = "//label[text()='Manufacturer:']/parent::div[@class='inputs']/select";
	
}
