package com.w2a.Testcase;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class LoginTest extends TestBase {
	
	@Test
	public void login() throws Throwable
	{
		verifyEquals("abc","xyz");
		log.debug("login inital");
		// driver.findElement(By.xpath(OR.getProperty("BmlBtn"))).click();
		click("BmlBtn_XPATH");
		Thread.sleep(3000);
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("custBtn_XPATH"))),"Login not success");
		log.debug("login successfully");
		Reporter.log("login done");
		
		Thread.sleep(3000);
		
		
	}

}
