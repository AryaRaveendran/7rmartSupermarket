package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Baseclass;
import com.qa.pages.Dashboard;
import com.qa.pages.EditManageProduct;
import com.qa.pages.LoginPage;
import com.qa.pages.NewManageProduct;
import com.qa.pages.SearchManageProduct;

public class ManageProductTestCase extends Baseclass 
{
	LoginPage loginpage;
	Dashboard dashboardpage;
	EditManageProduct editmanageproduct;
	SearchManageProduct searchproduct;
	NewManageProduct newmanagementproduct;
	@BeforeMethod
	public void beforeTC()
	{
		loginpage=new LoginPage(driver)	;
		loginpage.login("admin","admin");


	}
	@Test
	public void editTC2() throws InterruptedException
	{
	
		dashboardpage= new Dashboard(driver);
		dashboardpage.manageProductClick();
		editmanageproduct=new EditManageProduct(driver);	
		editmanageproduct.editedManageProductData("apple");
		String successMsg=editmanageproduct.alertMessage();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Updated Successfully");


	}
	@Test
	public void searchDataTC3() 
	{
	
		dashboardpage= new Dashboard(driver);
		dashboardpage.manageProductClick();
		searchproduct=new SearchManageProduct(driver);
		searchproduct.searchDropDownData();

	}
	@Test
	public void newProductDataTC4() 
	{

		
		dashboardpage= new Dashboard(driver);
		dashboardpage.manageProductClick();
		newmanagementproduct=new NewManageProduct(driver);
		newmanagementproduct.newProductData("Carrot","20","30","2000","20");
		String successMsg=newmanagementproduct.alertMessage();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Created Successfully");

	}
	@AfterMethod
	public void logout()
	{

		dashboardpage= new Dashboard(driver);
		dashboardpage.logout();
	} 
}
