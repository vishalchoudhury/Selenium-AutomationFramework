package AutomationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {
	WebDriver driver;
	
	public PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Home Page
	@FindBy(id="nav-link-yourAccount")
	public WebElement signIn;
	
	//Login Page
	@FindBy(id="ap_email")
	public WebElement logIn_txt;
	
	@FindBy(id="continue")
	public WebElement continue_btn;
	
	@FindBy(id="ap_password")
	public WebElement passwd_txt;
	
	@FindBy(id="signInSubmit")
	public WebElement submit_btn;
	
	//Logout Page
	@FindBy(xpath="//*[@id=\"nav-link-yourAccount\"]/span[1]")
	public WebElement acc_link;
	
	@FindBy(xpath="//*[@id=\"nav-item-signout-sa\"]/span")
	public WebElement signout;

}
