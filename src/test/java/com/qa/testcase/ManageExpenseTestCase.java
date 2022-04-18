package com.qa.testcase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.Baseclass;
import com.qa.pages.Dashboard;
import com.qa.pages.EditAdminUser;
import com.qa.pages.EditManageExpense;
import com.qa.pages.LoginPage;
import com.qa.pages.NewManageExpense;
import com.qa.pages.SearchManageExpense;

public class ManageExpenseTestCase extends Baseclass
{
	LoginPage loginpage;
	Dashboard dashboardpage;
	NewManageExpense newmanageexpense;
	EditManageExpense editmanageexpense;
	SearchManageExpense searchmanageexpense;

	@Parameters({"userName","password"})


	@BeforeMethod

	public void beforeTC(String username,String password)
	{
		loginpage=new LoginPage(driver)	;
		loginpage.login(username,password);


	}

	@Test	
	public void newMnangeExpenseTC1()
	{
		/*loginpage=new LoginPage(driver)	;
		loginpage.login("admin","admin");*/
		dashboardpage= new Dashboard(driver);
		dashboardpage.manageExpenseClick();
		newmanageexpense=new NewManageExpense(driver);
		newmanageexpense.newManageExpenseData("29-4-2022", "700");
		String successMsg=newmanageexpense.alertMessage();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Record Created Successfully");

	}
	@Test
	public void editManageExpenseTC2()
	{
		/*loginpage=new LoginPage(driver)	;
	loginpage.login("admin","admin");*/
		dashboardpage= new Dashboard(driver);
		dashboardpage.manageExpenseClick();
		editmanageexpense=new EditManageExpense(driver);
		editmanageexpense.editAmountInManageExpense("1000");
		String successMsg=editmanageexpense.alertMessage();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Record Updated Successfully");
	}
	@Test
	public void searchManageExpenseTC3()
	{
		dashboardpage= new Dashboard(driver);
		dashboardpage.manageExpenseClick();
		searchmanageexpense=new SearchManageExpense(driver);
		searchmanageexpense.searchExpense();
		
	}
	
	
	
	@AfterMethod
	public void logoutTC3()
	{

		dashboardpage= new Dashboard(driver);
		dashboardpage.logout();
	}       

}

