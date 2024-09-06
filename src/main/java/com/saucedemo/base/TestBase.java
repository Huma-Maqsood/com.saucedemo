package com.saucedemo.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public String filePath = "C:\\Users\\huma\\eclipse-workspace\\com.saucedemo\\src\\main\\java\\com\\saucedemo\\config\\config.properties";

	
	public TestBase() {
		prop = new Properties();
		try (FileInputStream fis = new FileInputStream(filePath)) {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		
		String browser = prop.getProperty("Browser");
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();	
		}
		else {
			System.out.println("unable to launch broswer");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.Implicit_Wait));
		driver.get(prop.getProperty("baseUrl"));

	}
	
}