package com.w2a.Testcase;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class Addcustomer extends TestBase{
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
//	public void addCust(String firstname, String lastname, String postcode, String runmode) throws Exception {
	
	public void addCust(Hashtable<String,String> data) throws Exception {
		if(!data.get("runmode").equals("Y")){
			
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		
		click("custBtn_XPATH");
		type("firstname_XPATH",data.get("firstname"));
		type("lastname_XPATH",data.get("lastname"));
		//driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys(postcode);
		type("postcode_XPATH",data.get("postcode"));
		click("addcustomer_XPATH");
		Thread.sleep(4000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		Thread.sleep(2000);
	}
}
