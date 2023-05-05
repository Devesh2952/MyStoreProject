package com.mystore.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.mystore.utility.NewExcelLibrary;

public class ProductDPClass {

	@DataProvider(name="productdata")
	public Object[][] dataload() throws IOException {
		NewExcelLibrary obj  =new NewExcelLibrary ();

		
		int totalrows=obj.getRowCount("Product");
		int totalcols=obj.getCellCount("Product",1);	
				
		Object ProductData[][]=new Object[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				ProductData[i-1][j]=obj.getCellData("Product", i, j);
			}
				
		}
		
		return ProductData;
	}
		
}
