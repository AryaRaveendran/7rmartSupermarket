package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.Baseclass;
import com.qa.pages.Dashboard;
import com.qa.pages.LoginPage;
import com.qa.pages.NewDeliveryBoy;
import com.qa.pages.NewManageExpense;
import com.qa.pages.SearchManageDeliveryBoyPage;

public class ManageDeliveryBoyTestCase extends Baseclass {

	LoginPage loginpage;
	Dashboard dashboardpage;
	NewDeliveryBoy newdeliveryboy;
	SearchManageDeliveryBoyPage searchdeliveryboy;


	@Parameters({"userName","password"})


	@BeforeMethod

	public void beforeTC(String username,String password)
	{
		loginpage=new LoginPage(driver)	;
		loginpage.login(username,password);


	}
	@Test

	public void newDeliveryBoy()
	{
		/*loginpage=new LoginPage(driver)	;
		loginpage.login("admin","admin");*/
		dashboardpage= new Dashboard(driver);
		dashboardpage.manageDeliveryBoyClick();
		newdeliveryboy=new NewDeliveryBoy(driver);
		newdeliveryboy.newDeliveryBoyData();
		String successMsg=newdeliveryboy.alertMessage();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Boy Details Created Successfully");

	}
	@Test

	public void searchDeliveryBoyData()
	{
		/*loginpage=new LoginPage(driver)	;
		loginpage.login("admin","admin");*/
		dashboardpage= new Dashboard(driver);
		dashboardpage.manageDeliveryBoyClick();
		searchdeliveryboy=new SearchManageDeliveryBoyPage(driver);
		searchdeliveryboy.searchDeliveryBoy("Arya","arya123@gmail.com");
	}

	@AfterMethod
	public void logoutTC()
	{

		dashboardpage= new Dashboard(driver);
		dashboardpage.logout();
	}     

}
