package com.qa.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.Baseclass;
import com.qa.pages.LoginPage;
import com.qa.pages.NewPageInManagePage;
import com.qa.pages.SearchInManagePage;
import com.qa.pages.EditButtonInManagePage;
import com.qa.pages.EditManageProduct;
import com.qa.pages.Dashboard;
import org.testng.Assert;


public class ManagePageTestCase extends Baseclass {

	LoginPage loginpage;
	EditButtonInManagePage managepage;
	NewPageInManagePage newmanagepage;
	Dashboard dashboardpage;
	SearchInManagePage search;
	//EditManageProduct editmanageproduct;

	@Parameters({"userName","password"})


	@BeforeMethod

	public void beforeTC(String username,String password)
	{
		loginpage=new LoginPage(driver)	;
		loginpage.login(username,password);


	}

/*	@Test
	public void searchTC4()
	{
		//loginpage=new LoginPage(driver)	;
		//loginpage.login("admin","admin");
		dashboardpage= new Dashboard(driver);
		dashboardpage.managePagesClick();
		search=new SearchInManagePage(driver);
		search.searchData("test0001");
	}*/

	@Test
	public void editTC1()
	{
		//	loginpage=new LoginPage(driver)	;
		//	loginpage.login("admin","admin");
		dashboardpage= new Dashboard(driver);
		dashboardpage.managePagesClick();
		managepage=new EditButtonInManagePage(driver);	

		managepage.editedData("test0001");
		String successMsg=managepage.alertMessage();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Updated Successfully");
	}
	/*@Test
	public void newpageDataTC2() 
	{
		//loginpage=new LoginPage(driver)	;
		//loginpage.login("admin","admin");
		dashboardpage= new Dashboard(driver);
		dashboardpage.managePagesClick();
		newmanagepage=new NewPageInManagePage(driver);
		newmanagepage.newPageData(); 
		/*String successMsg=newmanagepage.alertMessage();             //it will direct to error msg page
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Created Successfully");
	}*/

	@AfterMethod
	public void logoutTC3()
	{

		dashboardpage= new Dashboard(driver);
		dashboardpage.logout();
	}
}

