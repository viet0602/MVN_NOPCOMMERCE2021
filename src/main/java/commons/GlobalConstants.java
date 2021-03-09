package commons;

import java.io.File;
import java.util.Random;

public class GlobalConstants {
	public static String USER_URL = "https://demo.nopcommerce.com/";
	public static String ADMIN_URL = "https://admin-demo.nopcommerce.com/login?ReturnUrl=/admin/";
	public static String email = "viettesting" + randomNumber() + "@gmail.com";
	public static String password = "123456";
	public static String newpassword = "234567";
	public static String firstName = "Nguyen";
	public static String lastName = "Minh" + randomNumber();
	
	
	public static int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);

	}

}
