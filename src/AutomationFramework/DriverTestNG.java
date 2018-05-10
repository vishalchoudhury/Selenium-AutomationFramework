package AutomationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class DriverTestNG {
	public static WebDriver driver;
	public static Logger Log = Logger.getLogger(Logger.class.getName());

	@BeforeMethod
	public void home() {
		Log.info("Going to Home Page");
		
		driver = Home.homePage(driver, Log);
		
		driver = Driver.windowSwitch(driver);
	}
	
	
	@Test
	public void login() throws Exception {
	  	
		Log.info("Going to Login Page");
		
		driver = Login.loginPage(driver, Log);
		
		driver = Driver.windowSwitch(driver);
		
  }
	
	@AfterMethod
	public void logout() throws Exception {
		
		Log.info("Going to Log out");
		
		driver = Logout.logOut(driver, Log);
		
	}
  
  @BeforeTest
  public void beforeMethod() {
	  	Scanner sc = new Scanner(System.in);
		DOMConfigurator.configure("log4j.xml");
		
		System.out.println("Choose your browser"+"\n 1-> Chrome"+"\n 2-> Firefox"); 
		int choice = sc.nextInt();
		
		Log.info("Going to opt Browser");
		
		driver = Browser.chooseBrowser(driver, choice, Log);
		
		Reporter.log("Application Launched Successfully");
  }

  @AfterTest
  public void afterMethod() {
	  	Log.info("Closing Broswer");
		
		driver.close();
		
		Log.info("Closing Driver Successfully");
		
		driver.quit();
		
		Reporter.log("Test Executed Successfully");
  }

}
