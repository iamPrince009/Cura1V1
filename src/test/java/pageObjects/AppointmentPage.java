package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	

	@FindBy(xpath="//label[@for='chk_hospotal_readmission']")
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
		if(!checkHospital.isSelected())
			checkHospital.click();
		else
			return;
	}
	
	public void setHealthcare(String choice)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		switch(choice)
		{
		case "Medicare":
			js.executeScript("arguments[0].click", medicareRd);
			break;
		case "Medicaid":
			js.executeScript("arguments[0].click()", medicaidRd);
			break;
		default:
			js.executeScript("arguments[0].click()", noneRd);
		}
	}
	
	public void setDate(String date) throws InterruptedException
	{
		visitDate.click();
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//WebElement dates = mywait.until(ExpectedConditions.elementToBeClickable(visitDate));
		//dates.clear();
		Thread.sleep(5000);
		visitDate.sendKeys("18/10/2026");
		//Actions actions = new Actions(driver);
		//actions.keyDown(Keys.ENTER).sendKeys("18/10/2026").keyUp(Keys.ENTER).build().perform();
		//Thread.sleep(5000);
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
