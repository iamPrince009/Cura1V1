package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AppointmentPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test
	public void loginTest()
	{
		System.out.println("Executing TC002_LoginTest\n\n");
		
		HomePage home = new HomePage(driver);
		home.clickAppoint();
		
		LoginPage login = new LoginPage(driver);
		System.out.print("Login Page Enabled: ");
		System.out.println(login.checkLogin());
		login.fillUsername();
		login.fillPassword();
		login.clickLogin();
		//Assert.assertTrue(true);
		
		AppointmentPage appoint = new AppointmentPage(driver);
		String text = appoint.getAppoint();
		

		System.out.println("TC002_LoginTest executed successfully\n\n");
		
		Assert.assertEquals(text, "Make Appointment");
		
	}

}
