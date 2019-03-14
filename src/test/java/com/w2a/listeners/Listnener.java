package com.w2a.listeners;

import java.io.IOException;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;


public class Listnener extends TestBase implements ITestListener {


	public void onTestStart(ITestResult arg0) {

		test = rep.startTest(arg0.getName().toUpperCase());
	
	}

		public void onTestSuccess(ITestResult result) {
			
			test.log(LogStatus.PASS, result.getName().toUpperCase()+" PASS");
			rep.endTest(test);
			rep.flush();
		}

		public void onTestFailure(ITestResult arg0) {

			System.setProperty("org.uncommons.reportng.escape-output","false");
			
			try {
				TestUtil.CaptureScreenshot();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Reporter.log("Click to see Screenshot");			
			Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotname+">Screenshot</a>");	
			
			test.log(LogStatus.FAIL, arg0.getName().toUpperCase()+" Failed with exception : "+arg0.getThrowable());
			test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotname));
		}


		public void onTestSkipped(ITestResult arg0) {
			
			test.log(LogStatus.SKIP, arg0.getName().toUpperCase()+" Skipped the test as the Run mode is NO");
			rep.endTest(test);
			rep.flush();
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

			
		}

		public void onStart(ITestResult arg0) {
			
			test = rep.startTest(arg0.getName().toUpperCase());
		}

		public void onFinish(ITestContext context) {
			
			System.out.println("test on finish ========="+context.getName());
			
		}
	
}
