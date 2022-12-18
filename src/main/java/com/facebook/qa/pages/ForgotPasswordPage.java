package com.facebook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.TestBase;

public class ForgotPasswordPage extends TestBase {
	LoginPage login = new LoginPage();
	
	@FindBy(xpath="//a[text()='Forgotten password?']")
	WebElement forgetPassword;
	
	//Initializing the page objects
		public ForgotPasswordPage() {
			PageFactory.initElements(driver,this);
		}
		
	//actions
		public void forgotPassword() {
			login.login("priyapandey8884.blr@gmail.com","Pandey@123");
			forgetPassword.click();
		}
	

}
