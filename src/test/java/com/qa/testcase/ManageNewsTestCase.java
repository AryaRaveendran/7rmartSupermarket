package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.Baseclass;
import com.qa.pages.AddNewsInManageNews;
import com.qa.pages.Dashboard;
import com.qa.pages.HomeInManageNews;
import com.qa.pages.LoginPage;
import com.qa.pages.NewManageExpense;
import com.qa.pages.EditManageNews;

public class ManageNewsTestCase extends Baseclass
{
	LoginPage loginpage;
	Dashboard dashboardpage;
	EditManageNews editmanagenewspage;
	AddNewsInManageNews addnews;
	HomeInManageNews home;

	@Parameters({"userName","password"})


	@BeforeMethod

	public void beforeTC(String username,String password)
	{
		loginpage=new LoginPage(driver)	;
		loginpage.login(username,password);
		//dashboardpage= new Dashboard(driver);
		//dashboardpage.manageNewsClick();


	}

	
	@Test
	public void ManageNewsDataTC1() throws InterruptedException
	{
		/*loginpage=new LoginPage(driver)	;
		loginpage.login("admin","admin");*/
		dashboardpage= new Dashboard(driver);
		dashboardpage.manageNewsClick();
		addnews =new AddNewsInManageNews(driver);
		addnews.ManageNewsData("Hello NewTesters");
		String successMsg=addnews.alertMessage();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Created Successfully");

	}
	
@Test
	public void editManageNewsDataTC1()
	{
		//loginpage=new LoginPage(driver)	;
  	  //loginpage.login("admin","admin");
	dashboardpage= new Dashboard(driver);
	dashboardpage.manageNewsClick();
		editmanagenewspage=new EditManageNews(driver);
		editmanagenewspage.editManageNewsData("Hello NewTesters123");   
		String successMsg=editmanagenewspage.alertMessage();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Updated Successfully");

	}
	@Test

	public void manageNewsDataTC2()
	{
		//loginpage=new LoginPage(driver)	;
		//loginpage.login("admin","admin");
		dashboardpage= new Dashboard(driver);
		dashboardpage.manageNewsClick();
		home=new HomeInManageNews(driver);
		home.homeInManageNews();
		String hometext=home.verification();
		System.out.println(hometext);
		Assert.assertEquals("Home",hometext);
	}


@AfterMethod
	public void logoutTC()
	{

		dashboardpage= new Dashboard(driver);
		dashboardpage.logout();
	} 
}
