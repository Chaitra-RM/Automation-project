package com.netcorecompany.commonutils;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public FileUtils fLib = new FileUtils();
	public static WebDriver driver;
		
	
		@BeforeClass()
		public void configBeforeClass() throws Throwable {
			/*Common  Data*/
			String URL  = fLib.getPropertyKeyValue("url");

			String BROWSER  = fLib.getPropertyKeyValue("browser");

			 if(BROWSER.equals("chrome")) {
			    driver = new ChromeDriver();
			 }else if(BROWSER.equals("firefox")) {
				 driver = new FirefoxDriver();
			 }else if(BROWSER.equals("ie")) {
				 driver = new InternetExplorerDriver();
			 }else {
				 driver = new ChromeDriver(); 
			 }
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(URL);
		}
}
