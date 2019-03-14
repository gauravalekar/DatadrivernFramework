package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.google.common.io.Files;
import com.w2a.base.TestBase;

public class TestUtil extends TestBase{

	
	public static String screenshotname;
	
	public static void CaptureScreenshot() throws Exception {
			
		File srcfile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Date d = new Date();
		screenshotname = d.toString().replace(":", "_").replace(" ","_")+".jpg";
		Files.copy(srcfile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenshotname)); 
	}
	
	@DataProvider(name="dp")
	public Object [][] getData(Method m){
		
		String Sheetname = m.getName();
		int rows = excel.getRowCount(Sheetname);
		int cols = excel.getColumnCount(Sheetname);
		
		Object[][] data = new Object [rows-1][1];
		
		Hashtable<String,String> table = null;

		for(int rowNum=2; rowNum<=rows;rowNum++) {
			
			table = new Hashtable<String,String>();
			
			for (int colNum=0; colNum<cols;colNum++) {
			
				// data[0][0]
				table.put(excel.getCellData(Sheetname, colNum, 1), excel.getCellData(Sheetname, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}
		}
	return data;	
	}
	
	
public static boolean isTestRunnable(String testName, ExcelReader excel){
		
		String sheetName="test_suite";
		int rows = excel.getRowCount(sheetName);
		
		
		for(int rNum=2; rNum<=rows; rNum++){
			
			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			
			if(testCase.equalsIgnoreCase(testName)){
				
				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
				
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
			
			
		}
		return false;
	}
	
}
