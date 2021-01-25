package pageUIs;

public class User_RegisterPageUI {


	public static String EXITS_EMAIL_ERROR_MESSAGE = "//li[text()='The specified email already exists']";
	public static String LESSTHAN6CHAR_PASSWORD_ERROR_MESSAGE_FIRSTLINE = "//p[contains(text(),'Password must meet the following rules:')]";
	public static String LESSTHAN6CHAR_PASSWORD_ERROR_MESSAGE_SECONDLINE = "//li[contains(text(),'must have at least 6 characters')]";
	public static String CONFIRMPASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static String REGISTER_BUTTON = "//input[@id='register-button']";
}