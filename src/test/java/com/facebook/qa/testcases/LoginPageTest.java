package com.facebook.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.ForgotPasswordPage;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;
import com.facebook.qa.pages.SignUpPage;
import com.facebook.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	SignUpPage signUpPage;
	TestUtil testUtil;
	HomePage home;
	public static String sheetName = "Login_Data";

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();

		loginPage = new LoginPage();
		signUpPage = new SignUpPage();
		testUtil = new TestUtil();
		 //home = new HomePage();
	}

	@Test
	public void verifyTitle() {
		String title = driver.getTitle();
		System.out.println("title is" + title);
	}

	@Test
	@Description("its an login details")
	@Feature(" login feature")
	@Story("its an login which contains email and password details")
	public void loginTest() {
		log.info("login is Running...");
		home = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		
	}

	@Test
	public void SignUpTest() {
		signUpPage.signUp(prop.getProperty("firstName"), prop.getProperty("lastName"), prop.getProperty("mobileNumber"),
				prop.getProperty("password"), prop.getProperty("day"), prop.getProperty("month"),
				prop.getProperty("year"));
	}
	
	@Test
	public void forgetPasswordTest() {
		ForgotPasswordPage page = new ForgotPasswordPage();
	   page.forgotPassword();
	}

	@DataProvider
	public Object[][] getLoginTestData() {
		Object data[][] = testUtil.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "getLoginTestData")
	public void multipleLoign(String username, String password) {
		loginPage.multiUser(username, password);
	}

	@AfterMethod
	public void down() {
//		driver.quit();
	}
}
