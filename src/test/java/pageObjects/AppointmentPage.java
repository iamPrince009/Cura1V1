package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage extends BasePage{

	public AppointmentPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='Make Appointment']")
	WebElement appointText;
	
	@FindBy(xpath="//select[@id='combo_facility']")
	WebElement facility;
	
	@FindBy(xpath="//option[@value='Tokyo CURA Healthcare Center']")
	WebElement tokyoOption;
	

	@FindBy(xpath="//option[@value='Hongkong CURA Healthcare Center']")
	WebElement hongkongOption;
	
	@FindBy(xpath="//option[@value='Seoul CURA Healthcare Center']")
	WebElement seoulOption;
	

	@FindBy(xpath="//input[@name='hospital_readmission']")
	WebElement checkHospital;
	
	@FindBy(xpath="//input[@id='radio_program_medicare']")
	WebElement medicareRd;
	
	@FindBy(xpath="//input[@id='radio_program_medicaid']")
	WebElement medicaidRd;
	
	@FindBy(xpath="//input[@id='radio_program_none']")
	WebElement noneRd;
	
	@FindBy(xpath="//input[@id='txt_visit_date']")
	WebElement visitDate;
	
	@FindBy(xpath="//textarea[@id='txt_comment']")
	WebElement commentText;
	
	@FindBy(xpath="//button[@id='btn-book-appointment']")
	WebElement appointBtn;
	
	
	public String getAppoint()
	{
		return appointText.getText();
	}
	
	public void setFacility(int choice)
	{
		Select selectChoice = new Select(facility);
		
		switch(choice) {
		case 1: selectChoice.selectByVisibleText(tokyoOption.getText());
				break;
		case 2: selectChoice.selectByVisibleText(hongkongOption.getText());
				break;
		case 3: selectChoice.selectByVisibleText(seoulOption.getText());
				break;
		default: selectChoice.selectByIndex(0);
		}
	}
	
	public void setCheckBox()
	{
		if(checkHospital.isEnabled())
			return;
		else
			checkHospital.click();
	}
	
	public void setHealthcare(String choice)
	{
		switch(choice) {
		case "Medicare": medicareRd.click();
				break;
		case "Medicaid": medicaidRd.click();
				break;
		default: noneRd.click();
		}
	}
	
	public void setDate(String date)
	{
		visitDate.clear();
		visitDate.sendKeys("18/10/2026");
	}
	
	public void setComment(String comment)
	{
		commentText.sendKeys(comment);
	}
	
	public void clickBtn()
	{
		appointBtn.click();
	}
}
