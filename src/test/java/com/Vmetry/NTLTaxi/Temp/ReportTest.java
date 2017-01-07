package com.Vmetry.NTLTaxi.Temp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportTest {

	public static WebDriver wd;
	public static ExtentReports report;
	public static ExtentTest log;

	@Test(priority = 1)
	public void googleTest() {
		report = new ExtentReports(
				"C:\\Selenium WorkSpace\\DDDTest\\ReportsGeneration\\ddd.html");
		log = report.startTest("googleTest");
		wd = new FirefoxDriver();
		wd.get("https://www.google.co.in");
	}

	@Test(priority = 3)
	public void yahooTest() {
		log = report.startTest("yahooTest");
		wd.get("https://in.yahoo.com/");

	}

	@Test(priority = 2)
	public void gmailTest() {
		log = report.startTest("gmailTest");
		wd.get("https://www.google.com/gmail/about/");

	}

	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if (result.isSuccess()) {
			String path = Takescreenshoot(result.getName());
			log.log(LogStatus.PASS, result.getName(),
					log.addScreenCapture(path));
		} else {

			String path = Takescreenshoot(result.getName());
			log.log(LogStatus.FAIL, result.getName(),
					log.addScreenCapture(path));
			report.endTest(log);
			report.flush();
		}
	}

	public static String Takescreenshoot(String name) throws IOException {
		File source = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"C:\\Selenium WorkSpace\\DDDTest\\screenshots\\" + name
						+ ".jpg");
		FileUtils.copyFile(source, destination);
		return destination.toString();
	}
}
