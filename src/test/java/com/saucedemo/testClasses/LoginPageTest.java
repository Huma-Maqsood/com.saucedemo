package com.saucedemo.testClasses;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.saucedemo.base.TestBase;
import com.saucedemo.pageObjectRep.InventoryPage;
import com.saucedemo.pageObjectRep.LoginPage;

public class LoginPageTest extends TestBase{
	

	LoginPage loginpage;
	InventoryPage inventory; 
	
	public LoginPageTest() {
		super(); // this will invoke config class
	}
	 
  
	  @BeforeTest
	  public void beforeTest() {
		  initialization();
		  loginpage = new LoginPage();
		  }
	  
	  @Test (priority = 1)
	  public void loginPageTitleTest() {
		 String title =  loginpage.validateLoginPageTitle();
		 Assert.assertEquals(title, "Swag Labs");
		  		  
	  }
	  
	  @Test (priority = 2)
	  public void LogoTest() {
		  boolean flag = loginpage.validateLogo();
		  Assert.assertTrue(flag);
		  
	  }
	  
	  @Test (priority = 3)
	  public void validLoginTest() {
	  		inventory = loginpage.verifyLogin();
	  		Assert.assertNotNull(inventory, "Login failed or not redirected to the inventory page");
	  		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Redirection to Inventory page failed.");  
		  }

	  @AfterTest
	  public void tearDown() {
		  driver.quit();
	  }

	}
