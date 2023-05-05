package com.mystore.dataprovider;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.mystore.utility.NewExcelLibrary;

public class LoginDPClass  {
	
	@DataProvider(name="logindata")
	public Object[][] dataload() throws IOException {
		NewExcelLibrary obj  =new NewExcelLibrary ();

		
		int totalrows=obj.getRowCount("Credantial");
		int totalcols=obj.getCellCount("Credantial",1);	
				
		Object loginData[][]=new Object[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=obj.getCellData("Credantial", i, j);
			}
				
		}
		
		return loginData;
	}
		
	}
