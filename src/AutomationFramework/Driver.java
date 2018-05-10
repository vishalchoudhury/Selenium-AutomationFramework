package AutomationFramework;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

import org.apache.log4j.xml.DOMConfigurator;

import java.util.*;
public class Driver {
	public static WebDriver driver;
	public static Logger Log = Logger.getLogger(Logger.class.getName());
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		DOMConfigurator.configure("log4j.xml");
		
		System.out.println("Choose your browser"+"\n 1-> Chrome"+"\n 2-> Firefox"); 
		int choice = sc.nextInt();
		
		Log.info("Going to opt Browser");
		
		driver = Browser.chooseBrowser(driver, choice, Log);
		
		Log.info("Going to Home Page");
		
		driver = Home.homePage(driver, Log);
		
		driver = Driver.windowSwitch(driver);
		
		Log.info("Going to Login Page");
		
		driver = Login.loginPage(driver, Log);
		
		driver = Driver.windowSwitch(driver);
		
		Log.info("Going to Log out");
		
		driver = Logout.logOut(driver, Log);
		
		Log.info("Closing Broswer");
		
		driver.close();
		
		Log.info("Closing Driver Successfully");
		
		driver.quit();
	}

	public static WebDriver windowSwitch(WebDriver driver) {
		
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		
		return driver;
	}
}
