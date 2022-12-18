package com.qa.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTestng {
	
	@Test
	@BeforeMethod()
	public void beforeMethod() {
		System.out.println("before method");
	}
	
	@AfterMethod()
	public void afterMethod() {
		System.out.println("after method");
	}
	
	@BeforeClass
	 public void beforeClass() {
		System.out.println("before class");
	}
	@AfterClass
	 public void afterClass() {
		System.out.println("after class");
	}
	@BeforeTest
	 public void beforeTest() {
		System.out.println("after test");
	}
	@AfterTest
	 public void afterTest() {
		System.out.println("after test");
	}
	@BeforeSuite
	public void beforeSuit() {
		System.out.println("before suit");
	}
	@AfterSuite
	public void afterSuit() {
		System.out.println("after suit");
	}
	
	
	 

}
