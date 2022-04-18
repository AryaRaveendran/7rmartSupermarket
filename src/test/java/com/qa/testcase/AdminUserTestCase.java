package com.qa.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.Baseclass;
import com.qa.pages.Dashboard;
import com.qa.pages.EditAdminUser;
import com.qa.pages.LoginPage;
import com.qa.pages.NewAdminUser;
import com.qa.pages.SearchAdminUser;
import com.qa.pages.StatusAdminUser;

import org.testng.Assert;



public class AdminUserTestCase extends Baseclass
{
	LoginPage loginpage;
	NewAdminUser newadminuser;
	Dashboard dashboardpage;
	SearchAdminUser searchadminuser;
	EditAdminUser editadminuser;
	StatusAdminUser statusUser;
	
	@Parameters({"userName","password"})


	@BeforeMethod

	public void beforeTC(String username,String password)
	{
		
		loginpage=new LoginPage(driver)	;
		loginpage.login(username,password);


	}
	@Test
	public void newAdminUserDataTC1()
	{
		
		dashboardpage= new Dashboard(driver);
		dashboardpage.adminUserClick();
		newadminuser=new NewAdminUser(driver);
		newadminuser.newAdminUser();
		String successMsg=newadminuser.alertMessage();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Created Successfully");

	}
	@Test
	public void searchAdminUserDataTC2()
	{
		
		dashboardpage= new Dashboard(driver);
		dashboardpage.adminUserClick(); 
		searchadminuser=new SearchAdminUser(driver);
		searchadminuser.searchUser("arya");
	}
	@Test                                        
	public void editAdminUserDataTC3()
	{
		
		dashboardpage= new Dashboard(driver);
		dashboardpage.adminUserClick(); 
		editadminuser=new EditAdminUser(driver);
		editadminuser.editUserData();
		String successMsg=editadminuser.alertMessage();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Updated Successfully");

	}
	@Test           
	public void ScreenShotAdminUserTC4()
	{


		dashboardpage= new Dashboard(driver);
		dashboardpage.adminUserClick();
		statusUser=new StatusAdminUser(driver);
		statusUser.status();
		String successMsg=statusUser.alertMessage();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Status Changed Successfully");
	}

	@AfterMethod
	public void logoutTC3()
	{

		dashboardpage= new Dashboard(driver);
		dashboardpage.logout();
	}       
}