package com.qa.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.Baseclass;
import com.qa.pages.Dashboard;
import com.qa.pages.LoginPage;
import com.qa.pages.NewAdminUser;

import excel.Excelfile;

public class LoginTestCase  extends Baseclass
{
	LoginPage loginpage;
	Dashboard dashboardpage;
	Excelfile excelfile;

	@Parameters({"browser"})

	@BeforeMethod




	/*public void beforeMethod(String browser)
	{
		initilization(browser);
	}*/

	/*@Test(dataProvider = "data-provider")

	public void loginTC1(String username,String password)
	{
		loginpage=new LoginPage(driver);
		loginpage.login(username,password);


	}
	@DataProvider (name = "data-provider")
	public Object[][] dpMethod(){
		//return new Object[][] {{"admin","admin"}, {"subin","subin"}};
		return new Object[][] {{"admin","admin"}};
		/*loginpage=new LoginPage(driver);
		loginpage.login("admin","admin");
		String txtName=loginpage.verification();
		System.out.println(txtName);
		Assert.assertEquals("7rmart supermarket",txtName);

	}*/
	@Test
	public void InvalidloginTC2() throws IOException
	{


		loginpage=new LoginPage(driver);
		loginpage.invalidLogin();
		String successMsg=loginpage.invalidLoginalertMessage();
		Assert.assertEquals(successMsg, "Username/Password");
	}


	@Test
	public void BlankloginTC3()
	{
		loginpage=new LoginPage(driver);
		loginpage.blankLogin();
		String txtName=loginpage.blankLoginalertMessage();
		Assert.assertEquals("Sign in to start your session",txtName);
	}
	@Test
	public void BlankUserNameloginTC4()
	{
		loginpage=new LoginPage(driver);
		loginpage.blankUserNameLogin();
	}





	/*	@AfterMethod
	public void blankLogin()
	{
	loginpage=new LoginPage(driver);
	loginpage.blankLogin();
		//driver.quit();
	}*/

}

