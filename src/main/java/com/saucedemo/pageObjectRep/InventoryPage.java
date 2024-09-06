package com.saucedemo.pageObjectRep;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.saucedemo.base.TestBase;

public class InventoryPage extends TestBase{
	
	@FindBy(className = "inventory_item")
	List<WebElement> InventoryList;	
	
	@FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-backpack')]")
	WebElement product1;
	
	@FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-bolt-t-shirt')]")
	WebElement product2;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cartLink;
	
	@FindBy(xpath = "//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]")
	WebElement Product1Price;
	
	@FindBy(xpath = "//button[contains(@id,'remove-sauce-labs-backpack')]")
	WebElement product1RemoveButton;

	@FindBy(xpath = "//button[contains(@id,'remove-sauce-labs-bolt-t-shirt')]")
	WebElement product2RemoveButton;
	
	public InventoryPage(){
		PageFactory.initElements(driver, this);
	}
	
	public List <String> getInventoryListByName() {
		List <String> inventoryListName = new ArrayList<>();
		for(WebElement items: InventoryList) {
			String itemsName = items.getText();
			inventoryListName.add(itemsName);
		}
		return inventoryListName;
		
	}
	public boolean VerifyPriceOfProduct1() {
		String ActualPrice = Product1Price.getText();
		String ExpectedPrice = "$29.99";
		if(ActualPrice.equals(ExpectedPrice))
		{return true;}
		else
		{return false;}
		
	}
	
	public void addProduct1toCart() {
		product1.click();
		
	}
	public void addProduct2toCart() {
		product2.click();
		
	}
	
	public CartPage goToCart() {
		cartLink.click();
		return new CartPage();
	}
	
	public boolean isProduct1inCart() {
		return product1RemoveButton.isDisplayed();
		
	}
	
	public boolean isProduct2inCart() {
		return product2RemoveButton.isDisplayed();
		
	}
	
	
	public List<String> verifyItemsadded() {
		List<String> addedItemNames = new ArrayList<>();
        addedItemNames.add("Sauce Labs Backpack");
        addedItemNames.add("Sauce Labs Bolt T-Shirt");

        return addedItemNames;
		
		
	}

}
