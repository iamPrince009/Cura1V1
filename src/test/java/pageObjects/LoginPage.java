package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	Actions act = new Actions(driver);
	
	
	@FindBy(xpath="//h2[normalize-space()='Login']")
	WebElement loginText;
	
	@FindBy(xpath="//input[@value='John Doe']")
	WebElement givenUsername;
	
	@FindBy(xpath="//input[@value='ThisIsNotAPassword']")
	WebElement givenPassword;
	
	@FindBy(xpath="//input[@id='txt-username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='txt-password']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='btn-login']")
	WebElement loginbtn;
	
	public boolean checkLogin()
	{
		return loginText.isDisplayed();
	}
	
	public void fillUsername()
	{
		userName.sendKeys(givenUsername.getAttribute("value"));
	}
	
	public void fillPassword()
	{
		password.sendKeys(givenPassword.getAttribute("value"));
	}
	
	public void clickLogin()
	{
		loginbtn.click();
	}
}
