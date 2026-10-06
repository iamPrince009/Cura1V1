package seldemo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseLocators {
	static WebDriver driver;
	public static void main(String args[])
	{
		driver = new ChromeDriver();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.manage().window().maximize();
		
		BaseLocators bkl = new BaseLocators();
		bkl.statlocators();
	//driver.quit();
	}
	public void statlocators()
	{
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//first page
		WebElement homebtn = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
		System.out.println("The home button is visible:"+ homebtn.isDisplayed());
		homebtn.click();
		
		//second page
		WebElement username = driver.findElement(By.xpath("//input[@id='txt-username']"));
		username.sendKeys("John Doe");
		WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
		password.sendKeys("ThisIsNotAPassword");
		driver.findElement(By.xpath("//button[@id='btn-login']")).click();
		
		//tackling alert
		//Alert myalert = driver.switchTo().alert();
		//myalert.accept();
		
		//Check for profile
		driver.findElement(By.xpath("//i[@class='fa fa-bars']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Profile']")).click();
		boolean check = driver.findElement(By.xpath("//p[normalize-space()='Under construction.']")).isDisplayed();
		System.out.println(check);
		WebElement checktext = driver.findElement(By.xpath("//p[normalize-space()='Under construction.']"));
		System.out.println(checktext.getText());
		
		//logout
		driver.findElement(By.xpath("//i[@class='fa fa-bars']")).click();
		WebElement logout = driver.findElement(By.xpath("//a[@class='btn btn-default']"));
		logout.click();
		//i[@class='fa fa-bars']
	}
	
	

}
