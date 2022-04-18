package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.Baseclass;
import com.qa.pages.AddManageCOD;
import com.qa.pages.Dashboard;
import com.qa.pages.LoginPage;
import com.qa.pages.NewAdminUser;

public class ManageCODTestCase extends Baseclass
{
	LoginPage loginpage;
	Dashboard dashboardpage;
	AddManageCOD addmanageCOD;

	@Parameters({"userName","password"})


	@BeforeMethod

	public void beforeTC(String username,String password)
	{
		loginpage=new LoginPage(driver)	;
		loginpage.login(username,password);


	}
	@Test
	public void addManageCOD()
	{
		dashboardpage= new Dashboard(driver);
		dashboardpage.manageCODclick();
		addmanageCOD=new AddManageCOD(driver);
		addmanageCOD.manageCOD();
		String successMsg=addmanageCOD.alertMessage();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Added Successfully");
	}
	@AfterMethod
	public void logoutTC()
	{

		dashboardpage= new Dashboard(driver);
		dashboardpage.logout();
	}       
}
