package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_ValidateHomePage extends BaseClass{

	@Test
	public void verify_Homepage()
	{
		HomePage home = new HomePage(driver);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		home.clickCura();
		home.clickHome();
		String title = home.getName();
		Assert.assertEquals(title, "CURA Healthcare Service");
	}
}
