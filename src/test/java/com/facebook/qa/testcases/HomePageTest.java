package com.facebook.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.ForgotPasswordPage;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ForgotPasswordPage forgotPassword;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		//forgotPassword = new ForgotPasswordPage();
		homePage=loginPage.login(prop.getProperty("email"),prop.getProperty("password"));
		//forgotPassword.forgotPassword();
	}
	
	@Test
	public void verifyHomePageTitleTest() {
	String homePageTitle=homePage.verifyHomePageTitle();
	//Assert.assertEquals(homePageTitle,"facebook");
	System.out.println("the title is" + homePageTitle);
	}
	@Test
	public void clickOnProfileLinkTest() {
		homePage.clickOnProfileLink();
	}
	
	
	

}
