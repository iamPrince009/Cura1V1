package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_ValidateHomePage extends BaseClass{

	@Test
	public void verify_Homepage()
	{

		System.out.println("Executing TC001_ValidateHomePage\n\n");
		
		HomePage home = new HomePage(driver);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		home.clickCura();
		home.clickHome();
		String title = home.getName();
		

		System.out.println("TC001_ValidateHomePage executed successfully\n\n");
		
		Assert.assertEquals(title, "CURA Healthcare Service");

	}
}
