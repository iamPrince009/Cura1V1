package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppointSuccess extends BasePage{
	
	public AppointSuccess(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='Appointment Confirmation']")
	WebElement confirmText;
	
	@FindBy(xpath="//p[@id='facility']")
	WebElement facility;
	
	@FindBy(xpath="//p[@id='hospital_readmission']")
	WebElement readmission;
	
	@FindBy(xpath="//p[@id='program']")
	WebElement program;
	
	@FindBy(xpath="//p[@id='visit_date']")
	WebElement date;
	
	@FindBy(xpath="//p[@id='comment']")
	WebElement comment;
	
	@FindBy(xpath="//a[@class='btn btn-default']")
	WebElement homebtn;
	
	public String getConfirmation()
	{
		return confirmText.getText();
	}
	
	public String getFaciltiy()
	{
		return facility.getText();
	}
	
	public String getAdmission()
	{
		return readmission.getText();
	}
	
	public String getProgram()
	{
		return program.getText();
	}
	
	public String getDate()
	{
		return date.getText();
	}

	public String getComment()
	{
		return comment.getText();
	}
	
	public void clickHome()
	{
		homebtn.click();
	}
}
