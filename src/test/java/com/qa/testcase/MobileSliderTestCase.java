package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.Baseclass;
import com.qa.pages.Dashboard;
import com.qa.pages.EditMobileSlider;
import com.qa.pages.LoginPage;
import com.qa.pages.NewManageSlider;
import com.qa.pages.NewMobileSliderPage;

public class MobileSliderTestCase  extends Baseclass
{
	LoginPage loginpage;
	Dashboard dashboardpage;
	NewMobileSliderPage newmobileslider;
	EditMobileSlider editmobileslider;
	
	@Parameters({"userName","password"})


	@BeforeMethod

	public void beforeTC(String username,String password)
	{
		loginpage=new LoginPage(driver)	;
		loginpage.login(username,password);
		

	}
	@Test
	public void mobileSliderTC1()
	{
		dashboardpage= new Dashboard(driver);
		dashboardpage.mobileSliderClick();
		newmobileslider =new NewMobileSliderPage(driver);
		newmobileslider.newMobileSlider();
		String successMsg=newmobileslider.alertMessage();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Slider Created Successfully");

	}
	@Test
	
	public void editmobileSliderTC2()
	{
		dashboardpage= new Dashboard(driver);
		dashboardpage.mobileSliderClick();
		editmobileslider =new EditMobileSlider(driver);
		editmobileslider.editMobileSlider();
		String successMsg=editmobileslider.alertMessage();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Slider Updated Successfully");

	}
	
	
	@AfterMethod
	public void logoutTC3()
	{

		dashboardpage= new Dashboard(driver);
		dashboardpage.logout();
	}       
	
}
