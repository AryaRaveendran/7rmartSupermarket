package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.Baseclass;
import com.qa.pages.Dashboard;
import com.qa.pages.LoginPage;
import com.qa.pages.NewAdminUser;
import com.qa.pages.PushNotificationPage;

public class PushNotificationTestCase extends Baseclass
{
	LoginPage loginpage;
	Dashboard dashboardpage;
	PushNotificationPage pushNotification;
	
	@Parameters({"userName","password"})


	@BeforeMethod

	public void beforeTC(String username,String password)
	{
		loginpage=new LoginPage(driver)	;
		loginpage.login(username,password);


	}
	@Test
	
	public void pushNotificationTC1()
	{
		dashboardpage= new Dashboard(driver);
		dashboardpage.pushNotificationClick();
		pushNotification=new PushNotificationPage(driver);
		pushNotification.pushNotification("Notification1","Testing");
		String successMsg=pushNotification.alertMessage();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "send successfully");
	}
	
	@AfterMethod
	public void logoutTC3()
	{

		dashboardpage= new Dashboard(driver);
		dashboardpage.logout();
	}     
}
