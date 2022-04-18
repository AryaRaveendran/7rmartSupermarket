package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.Baseclass;
import com.qa.pages.AddNewsInManageNews;
import com.qa.pages.Dashboard;
import com.qa.pages.LoginPage;
import com.qa.pages.NewManageSlider;

public class ManageSliderTestCase extends Baseclass
{
	LoginPage loginpage;
	Dashboard dashboardpage;
	NewManageSlider newmanageslider;
	
	@Parameters({"userName","password"})


	@BeforeMethod

	public void beforeTC(String username,String password)
	{
		loginpage=new LoginPage(driver)	;
		loginpage.login(username,password);
		

	}
	@Test
	public void newManageSliderTC1()
	{
		dashboardpage= new Dashboard(driver);
		dashboardpage.manageSliderClick();
		newmanageslider =new NewManageSlider(driver);
		newmanageslider.newManageSlider();
		String successMsg=newmanageslider.alertMessage();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Created Successfully");

	}
	@AfterMethod
	public void logoutTC3()
	{

		dashboardpage= new Dashboard(driver);
		dashboardpage.logout();
	}       

}
