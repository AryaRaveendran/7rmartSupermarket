package com.qa.testcase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.Baseclass;
import com.qa.pages.Dashboard;
import com.qa.pages.LoginPage;

public class DashboardpageTestCase extends Baseclass 
{
	LoginPage loginpage;
	Dashboard dashboardpage;
	
	@Parameters({"userName","password"})


	@BeforeMethod

	public void beforeTC(String username,String password)
	{
		loginpage=new LoginPage(driver)	;
		loginpage.login(username,password);


	}
	@Test	
	public void txtVerificationTC1()
	{
		SoftAssert softAssert=new SoftAssert(); 

		
		dashboardpage=new Dashboard(driver);
		String txtName=dashboardpage.verification();
		System.out.println(txtName);
		Assert.assertEquals("7rmart supermarket",txtName);



		boolean isdisplay=dashboardpage.verification2();
		System.out.println(isdisplay);
		Assert.assertEquals(true, isdisplay);

		// Assert.assertTrue(isdisplay);
		//Assert.assertTrue(isdisplay, "Passed");

		softAssert.assertEquals(true,isdisplay);
		softAssert.assertAll();
		
		
File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File("C:\\projectScreenshots\\homePageScreenshot.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
        
        @AfterMethod
		public void logoutTC()
		{

			dashboardpage= new Dashboard(driver);
			dashboardpage.logout();
		}       


	
	/*public void switchToTab()
	{
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    
	    driver.close();
	    driver.switchTo().window(tabs2.get(0));

	}*/
	
	

}
