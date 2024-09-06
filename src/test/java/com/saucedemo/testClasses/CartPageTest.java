package com.saucedemo.testClasses;

import org.testng.annotations.Test;

import com.saucedemo.base.TestBase;
import com.saucedemo.pageObjectRep.CartPage;
import com.saucedemo.pageObjectRep.InventoryPage;
import com.saucedemo.pageObjectRep.LoginPage;

import org.testng.annotations.BeforeTest;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CartPageTest extends TestBase{
	
	LoginPage loginpage;
	InventoryPage inventory;
	CartPage cart;
	
	public CartPageTest() {
		super(); // this will invoke config class
	}
	   
	  @BeforeTest
	  public void beforeTest() throws InterruptedException {
		  initialization();
		  loginpage = new LoginPage();
		  inventory = new InventoryPage();
		  cart = new CartPage();
		  inventory = loginpage.verifyLogin();
		  inventory.addProduct1toCart();
		  inventory.addProduct2toCart();
		  inventory.goToCart();
		  Thread.sleep(2000);
		  }
  @Test(priority = 1)
  public void verifyCartItemsTest() {
 		    List<String> cartItems = cart.getCartItems();
			System.out.println("Cart Items: " + cartItems); // Debugging info
			Assert.assertTrue(cartItems.contains("Sauce Labs Backpack"), "Sauce Labs Backpack is not in the cart");
			Assert.assertTrue(cartItems.contains("Sauce Labs Bolt T-Shirt"), "Sauce Labs Bolt T-Shirt is not in the cart");
		}
  
  @Test(priority = 2)
  public void checkoutButtonTest() throws InterruptedException {
	  cart.checkoutButtonClick();
	  Thread.sleep(3000);
  }
 
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
