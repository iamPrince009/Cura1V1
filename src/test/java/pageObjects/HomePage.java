package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(xpath="//a[@id='btn-make-appointment']")
	WebElement appointbtn;
	
	@FindBy(xpath="//a[text()='info@katalon.com']")
	WebElement contactinfo;
	
	@FindBy(xpath="//a[@class='btn btn-dark btn-lg toggle']")
	WebElement options;
	
	@FindBy(xpath="//li[@class='sidebar-brand']/a[text()='CURA Healthcare']")
	WebElement curaOptions;
	
	@FindBy(xpath="//a[normalize-space()='Home']")
	WebElement home;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login;
	
	public void clickAppoint()
	{
		appointbtn.click();
	}
	
	public void clickContact()
	{
		contactinfo.click();
	}
	
	public void clickOptions()
	{
		options.click();
	}
	
	public void clickCura()
	{
		curaOptions.click();
	}
	
	public void clickHome()
	{
		home.click();
	}
	
	public void clickLogin()
	{
		js.executeScript("arguments[0].click", login);
	}
	
	public String getName()
	{
		String title = driver.getTitle();
		
		return title;
	}
}
