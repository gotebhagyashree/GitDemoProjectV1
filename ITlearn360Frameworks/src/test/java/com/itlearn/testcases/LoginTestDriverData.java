package com.itlearn.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.LoginPage;
import com.itllearn.utilities.ReadExcelFile;

public class LoginTestDriverData extends BaseTest{
	
	
String fileName=System.getProperty("user.dir")+"\\TestData\\Book1.xlsx";
	
	@Test(priority =1,dataProvider="LoginDataProvider")
	
		public void verifyLogin(String userEmail,String userpwd)  
		{
			LoginPage lp=new LoginPage(driver); 
			//String username ="Demo12";
			//String password ="Test123456$";
			lp.loginToPortal(userEmail,userpwd);
			 
			lp.logout();
		}
 
	
	@DataProvider(name="LoginDataProvider")
	public String[][] LoginDataProvider()  
	{
		
		
		int ttlRows= ReadExcelFile.getRowCount(fileName, "Sheet1");
		int ttlColumns= ReadExcelFile.getColCount(fileName, "Sheet1");
		
		String data[][]= new String[ttlRows-1][ttlColumns];
		
		for(int i=1;i<ttlRows;i++)
		{
			for(int j=0;j<ttlColumns;j++)
			{
				data[i-1][j]=ReadExcelFile.getCellValue(fileName, "Sheet1", i, j);
			}
		}
		return data;


}
}