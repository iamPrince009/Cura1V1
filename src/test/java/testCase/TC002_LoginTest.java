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
		HomePage home = new HomePage(driver);
		home.clickAppoint();
		
		LoginPage login = new LoginPage(driver);
		System.out.println(login.checkLogin());
		login.fillUsername();
		login.fillPassword();
		login.clickLogin();
		//Assert.assertTrue(true);
		
		AppointmentPage appoint = new AppointmentPage(driver);
		String text = appoint.getAppoint();
		Assert.assertEquals(text, "Make Appointment");
		
	}

}
