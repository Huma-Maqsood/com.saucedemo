package com.saucedemo.pageObjectRep;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.base.TestBase;

public class LoginPage extends TestBase {
			
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement submit;
	
	@FindBy(xpath="//div[@class='login_logo']")
	WebElement logo;
	
	//Initialize the Page objects
	public LoginPage(){
			PageFactory.initElements(driver, this);
			}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public InventoryPage verifyLogin() {
		username.sendKeys(prop.getProperty("uName"));
		password.sendKeys(prop.getProperty("pwd"));
		submit.click();
		System.out.println("Login successfully");
		
        // Check if redirected to Inventory page
        if (driver.getCurrentUrl().contains("inventory.html")) {
            return new InventoryPage();
        } else {
            return null;
        }
    }
	

}
