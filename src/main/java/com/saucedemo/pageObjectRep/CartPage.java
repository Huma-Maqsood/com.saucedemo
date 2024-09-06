package com.saucedemo.pageObjectRep;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.base.TestBase;

public class CartPage extends TestBase{
	
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> cartItems;

	@FindBy(xpath = "//button[@id='checkout']")
	WebElement checkoutButton;

	public CartPage() {
		PageFactory.initElements(driver, this);
	}
    
 	public List<String> getCartItems() {
		List<String> itemNames = new ArrayList<>();
		for (WebElement item : cartItems) {
			itemNames.add(item.getText());
		}
		return itemNames;
	}

	public void checkoutButtonClick() {
		checkoutButton.click();
	}
}
