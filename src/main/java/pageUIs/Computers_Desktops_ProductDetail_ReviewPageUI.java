package pageUIs;

public class Computers_Desktops_ProductDetail_ReviewPageUI {
	public static String REVIEW_TITLE_TEXTBOX = "//input[@id='AddProductReview_Title']";
	public static String REVIEW_BODY_TEXTBOX = "//div[@class='inputs']//textarea[@id='AddProductReview_ReviewText']";
	public static String RATING_RADIO_BUTTON = "//input[@id='addproductrating_3']";
	public static String SUBMIT_REVIEW_BUTTON = "//input[@value='Submit review']";
	public static String REVIEW_MESSAGE_SUCCESSFUL_TEXT = "//div[contains(text(),'Product review is successfully added.')]";
	public static String DYNAMIC_REVIEWED_TITLE_DISPLAY_TEXT = "//div[@class='product-review-item']//div[@class='review-title']//strong[text()='%s']";
	public static String DYNAMIC_REVIEWED_BODY_DISPLAY_TEXT="//div[@class='review-text']//div[contains(text(),'%s')]";
	public static String DYNAMIC_REVIEW_USER_DISPLAY_TEXT = "//div[@class='review-info']//span[@class='user']//span[text()='%s']";

}
