package com.w2a.Testcase;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class OpenAccount extends TestBase{
			
			@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
			public void openaccount(Hashtable<String,String> data) throws Exception {
				
				
				if(!(TestUtil.isTestRunnable("OpenAccount", excel))){
					
					throw new SkipException("Skipping the test "+"OpenAccount".toUpperCase()+ "as the Run mode is NO");
				}
		
				click("addcust_XPATH");
				select("cust_XPATH",data.get("customer"));
				select("currency_XPATH",data.get("currency"));
				click("process_XPATH");
				Thread.sleep(2000);
				Alert alert = wait.until(ExpectedConditions.alertIsPresent());
				alert.accept();
			}
			
			
	}