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
import com.qa.pages.NewManageOfferCode;

public class ManageOfferCodeTestCase extends Baseclass
{

	LoginPage loginpage;
	Dashboard dashboardpage;
	NewManageOfferCode manageoffercode;
	
	@Parameters({"userName","password"})


	@BeforeMethod

	public void beforeTC(String username,String password)
	{
		loginpage=new LoginPage(driver)	;
		loginpage.login(username,password);


	}
	@Test
	
	public void newManageOfferCodeTC1()
	{
		dashboardpage= new Dashboard(driver);
		dashboardpage.manageOfferCodeClick();
		manageoffercode =new NewManageOfferCode(driver);
		manageoffercode.newManageOfferCode("0552","55","1000");
		String successMsg=manageoffercode.alertMessage();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Created Successfully");
	}
	
	@AfterMethod
	public void logoutTC()
	{

		dashboardpage= new Dashboard(driver);
		dashboardpage.logout();
	} 
	
}
