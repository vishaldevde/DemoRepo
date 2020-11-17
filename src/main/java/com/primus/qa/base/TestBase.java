package com.primus.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.primus.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		
		prop = new Properties();
		try {
			FileInputStream ip = 	 new FileInputStream("C:\\Users\\vdevde\\Documents\\workspace\\PrimusBankTest\\src"
					+ "\\main\\java\\com\\primus\\qa\\config\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void init() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\chromedriver_win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
