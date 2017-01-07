package com.Vmetry.NTLTaxi.Initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Vmetry.NTLTaxi.Utils.ReportGenerator;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Initializer {

	public static FileInputStream envFis = null;
	public static Properties envProp = null;
	public static WebDriver wd = null;
	public static FileInputStream locFis = null;
	public static Properties locProp = null;
	public static ExtentReports report;
	public static ExtentTest log;
	public static boolean isArchieve = true;

	public static void initialize() throws IOException {
		
		ReportGenerator.archieveFiles();
		
		report = new ExtentReports(
				"C:\\Selenium WorkSpace\\DDDTest\\Reports\\DDDReport.html");
		envFis = new FileInputStream(new File(System.getProperty("user.dir")
				+ File.separator + "src" + File.separator + "test"
				+ File.separator + "java" + File.separator + "com"
				+ File.separator + "Vmetry" + File.separator + "NTLTaxi"
				+ File.separator + "Config" + File.separator
				+ "environment.properties"));
		envProp = new Properties();
		envProp.load(envFis);

		// if (wd == null)
		// {
		if (envProp.getProperty("BROWSER").equals("FIREFOX"))
			;
		wd = new FirefoxDriver();
	}

	// }

	public static WebElement getWebElementByXpath(String xpath)
			throws IOException {
		locFis = new FileInputStream(new File(System.getProperty("user.dir")
				+ File.separator + "src" + File.separator + "test"
				+ File.separator + "java" + File.separator + "com"
				+ File.separator + "Vmetry" + File.separator + "NTLTaxi"
				+ File.separator + "Config" + File.separator
				+ "locators.properties"));
		locProp = new Properties();
		locProp.load(locFis);
		return wd.findElement(By.xpath(locProp.getProperty(xpath)));
	}

}
