package AutomationFramework;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Logout {
	public static WebDriver logOut(WebDriver driver, Logger Log) throws Exception {
		PageObjects call = new PageObjects(driver);
		WebDriverWait wait = new WebDriverWait(driver,60);
		Actions action = new Actions(driver);
		
		Log.info("Moving the mouse to account link area");
		Assert.assertTrue(call.acc_link.isDisplayed());
		action.moveToElement(call.acc_link).build().perform();
		
		Log.info("Click Sign out button");
		Assert.assertTrue(call.signout.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(call.signout)).click();
		return driver;
	}

}
