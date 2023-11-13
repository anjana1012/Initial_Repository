package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.utils.TestUtils;

public class TestBase {
	
	static Properties prop;
	static WebDriver driver;
	
	public TestBase() throws FileNotFoundException {
		Properties prop= new Properties();
		
		FileInputStream ip = new FileInputStream("filePath");
		try {
			prop.load(ip);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void browserName() {
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			//set driver path
			System.setProperty("webdriver.chrome.driver", "D:\\Java Project Wrokspace\\Selenium_InterviewQuestions\\chromedriver.exe");
			driver = new ChromeDriver();
	
		}
		else if(browserName.equals("Firefox")) {
			//set driver path
			System.setProperty("webdriver.gecko.driver", "D:\\Java Project Wrokspace\\Selenium_InterviewQuestions\\chromedriver.exe");
			driver = new FirefoxDriver();
	
		}
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIME_OUT);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("url");
	}
	
	
	
}
