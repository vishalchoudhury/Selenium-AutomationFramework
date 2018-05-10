package AutomationFramework;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Home {

	public static WebDriver homePage(WebDriver driver,Logger Log) {
		// TODO Auto-generated method stub
		PageObjects call=new PageObjects(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60); 
		Log.info("Going to hit Amazon.com");
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Log.info("Going to click Signin Button");
		Assert.assertTrue(call.signIn.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(call.signIn)).click();
		return driver;
	}

}
