package com.saucedemo.testClasses;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.*;
import com.saucedemo.base.TestBase;
import com.saucedemo.pageObjectRep.InventoryPage;
import com.saucedemo.pageObjectRep.LoginPage;



public class InventoryPageTest extends TestBase{
	LoginPage loginpage;
	InventoryPage inventory;
	
	public InventoryPageTest() {
		super();
	}
	
	@BeforeTest
		public void pageSetup(){
		initialization();		
		loginpage = new LoginPage();
		inventory = new InventoryPage();
		inventory = loginpage.verifyLogin();
		 }
  

  @Test(priority=1)
  public void VerifyProduct1PriceTest()
  {
	 boolean res = inventory.VerifyPriceOfProduct1();
	 Assert.assertTrue(res, "Price does not match");
  }
  
  @Test(priority=2)
  public void addProduct1toCartTest() {
		inventory.addProduct1toCart();
			
	}
  
  @Test(priority=3)
	public void addProduct2toCartTest() {
		inventory.addProduct2toCart();
	}
  
  @Test(priority=4)
	public void isProduct1inCartTest() {
		inventory.isProduct1inCart();
		Assert.assertTrue(inventory.isProduct1inCart(), "Product 1 is not in cart");	
	}
	
@Test(priority=5)
	public void isProduct2inCartTest() {
		inventory.isProduct2inCart();
		Assert.assertTrue(inventory.isProduct2inCart(), "Product 2 is not in cart");	
	}

  @Test(priority=6)
	public void goToCartTest() {
		inventory.goToCart();
		
	}
  
 @Test(priority=7)  
	public void verifyItemsAddedTest() {
		List<String> actualItems = inventory.verifyItemsadded();
		System.out.println(actualItems);
		List<String> expectedItems = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt");
		Assert.assertEquals(actualItems, expectedItems, "Items added to cart do not match expected items");
	}
  @AfterTest
  public void tearDown() {
	  driver.quit();
  }

}
