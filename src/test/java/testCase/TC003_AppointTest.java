package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AppointSuccess;
import pageObjects.AppointmentPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC003_AppointTest extends BaseClass{
	
	@Test
	public void testAppoint()
	{

		System.out.println("Executing TC003_AppointTest\n\n");
		
		HomePage home = new HomePage(driver);
		home.clickAppoint();
		
		LoginPage login = new LoginPage(driver);
		System.out.print("Login Page Enabled: ");
		System.out.println(login.checkLogin());
		login.fillUsername();
		login.fillPassword();
		login.clickLogin();
		
		AppointmentPage appoint = new AppointmentPage(driver);
		String text = appoint.getAppoint();
		System.out.println(text);
		appoint.setFacility(2);
		appoint.setCheckBox();
		appoint.setHealthcare("Medicaid");
		try
		{
		appoint.setDate("18/10/2026");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		appoint.setComment("One pack of Aspirin");
		appoint.clickBtn();
		System.out.println("Loading appointment...");
		
		AppointSuccess success = new AppointSuccess(driver);
		String text2 = success.getConfirmation();
		System.out.println(text2);
		System.out.println("Details are:");
		System.out.println("--------------------------------------------");
		System.out.println("Facility: "+success.getFaciltiy());
		System.out.println("Apply for Hospital Readmission: "+success.getAdmission());
		System.out.println("Healthcare Program: "+success.getProgram());
		System.out.println("Visit Date: "+success.getDate());
		System.out.println("Comment: "+success.getComment());
		

		System.out.println("TC003_AppointTest executed successfully");
		
		Assert.assertEquals(text2, "Appointment Confirmation");
	
	}

}
