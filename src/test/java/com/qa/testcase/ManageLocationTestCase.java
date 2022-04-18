package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.Baseclass;
import com.qa.pages.Dashboard;
import com.qa.pages.EditManageLocation;
import com.qa.pages.LoginPage;
import com.qa.pages.NewAdminUser;
import com.qa.pages.NewManageLocation;
import com.qa.pages.SearchManageLocation;
import com.qa.pages.StatusAdminUser;
import com.qa.pages.StatusManageLocation;

public class ManageLocationTestCase extends Baseclass
{
	LoginPage loginpage;
	NewManageLocation newLocation;
	Dashboard dashboardpage;
	StatusManageLocation statusLocation;
	EditManageLocation editManageLocation;
	SearchManageLocation searchManageLocation;
	
	@Parameters({"userName","password"})


	@BeforeMethod

	public void beforeTC(String username,String password)
	{
		loginpage=new LoginPage(driver)	;
		loginpage.login(username,password);


	}
	
	@Test	
	public void add_New_LocationTC1()
	{
		//loginpage=new LoginPage(driver)	;
		//loginpage.login("admin","admin");
		dashboardpage= new Dashboard(driver);
		dashboardpage.manageLocationClick();
		newLocation=new NewManageLocation(driver);
		newLocation.newPageData("94 Presidential Lane111", "300");
		String successMsg=newLocation.alertMessage();
	  	  System.out.println(successMsg);
	     Assert.assertEquals(successMsg, "Created Successfully");

	}
	@Test
	public void updatestatusTC1()
	{
		//loginpage=new LoginPage(driver)	;
		//loginpage.login("admin","admin");
	dashboardpage= new Dashboard(driver);
		dashboardpage.manageLocationClick();
		statusLocation=new StatusManageLocation(driver);
		statusLocation.status();
		String successMsg=statusLocation.alertMessage();
	  	  System.out.println(successMsg);
	     Assert.assertEquals(successMsg, "Status Changed Successfully");
	}
	@Test
    public void editLocationTC2()
    {
    	//loginpage=new LoginPage(driver)	;
		//loginpage.login("admin","admin");
		dashboardpage= new Dashboard(driver);
		dashboardpage.manageLocationClick();
		editManageLocation=new EditManageLocation(driver);
		editManageLocation.editLocation();
		String successMsg=editManageLocation.alertMessage();
	  	  System.out.println(successMsg);
	     Assert.assertEquals(successMsg, "Updated Successfully");
    }
	
	@Test
	
	public void searchLocationTC3()
	{
		/*loginpage=new LoginPage(driver)	;
		loginpage.login("admin","admin");*/
		dashboardpage= new Dashboard(driver);
		dashboardpage.manageLocationClick();
		searchManageLocation=new SearchManageLocation(driver);
		searchManageLocation.searchLocation("94 Presidential Lane111");
	}
	
@AfterMethod
	public void logoutTC3()
  {
	
	dashboardpage= new Dashboard(driver);
	dashboardpage.logout();
  }

}
