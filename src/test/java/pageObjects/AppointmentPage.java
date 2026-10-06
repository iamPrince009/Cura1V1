package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppointmentPage extends BasePage{

	public AppointmentPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='Make Appointment']")
	WebElement appointText;
	
	public String getAppoint()
	{
		return appointText.getText();
	}
	
}
