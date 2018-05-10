package AutomationFramework;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
public class Browser {
	public static WebDriver chooseBrowser(WebDriver driver, int choice,Logger Log) {
		// TODO Auto-generated method stub
		switch(choice) {
		case 1: Log.info("Invoking Chrome browser");
				System.setProperty("webdriver.chrome.driver", "C:\\Apllications and installer\\Selenium\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
		case 2: Log.info("Invoking Firefox Browser");
				System.setProperty("webdriver.firefox.driver", "C:\\Apllications and installer\\Selenium\\geckodriver.exe");
				break;
		default: System.out.println("Wrong choice");
		}
		Log.info("Maximizing Window");
		driver.manage().window().maximize();
		return driver;
	}

}
