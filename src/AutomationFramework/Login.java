package AutomationFramework;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import utility.Constant;
import utility.ExcelUtils;

public class Login {
	
	public static WebDriver loginPage(WebDriver driver, Logger Log)throws Exception {
		PageObjects call = new PageObjects(driver);
		WebDriverWait wait = new WebDriverWait(driver,60);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		ExcelUtils.setCellData("Login Action", 1, 0);

		String username = ExcelUtils.getCellData(1, 1);

		String password = ExcelUtils.getCellData(1, 2);
		
		Log.info("Input username");
		Assert.assertTrue(call.logIn_txt.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(call.logIn_txt)).sendKeys(username);
		
		Log.info("Click Next button");
		Assert.assertTrue(call.continue_btn.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(call.continue_btn)).click();
		
		driver = Driver.windowSwitch(driver);
		
		Log.info("Input Password");
		Assert.assertTrue(call.passwd_txt.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(call.passwd_txt)).sendKeys(password);
		
		Log.info("Click Submit button");
		Assert.assertTrue(call.submit_btn.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(call.submit_btn)).submit();
		
        ExcelUtils.setCellData("Pass", 1, 3);
		
        return driver;
	}

}
