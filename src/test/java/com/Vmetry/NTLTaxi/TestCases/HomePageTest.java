package com.Vmetry.NTLTaxi.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vmetry.NTLTaxi.Initializer.Initializer;
import com.Vmetry.NTLTaxi.InputReader.inputReader;
import com.Vmetry.NTLTaxi.Pages.HomePage;
import com.Vmetry.NTLTaxi.Utils.ScreenshotGenerator;

public class HomePageTest extends Initializer {

	public void testHomePage() throws IOException {
		// initialize();
		// wd.get(envProp.getProperty("URL"));
		/*
		 * HomePage.enter_Username("Abinaya");
		 * HomePage.enter_Number("9790823178");
		 * HomePage.enter_Pickup_place("Adyar");
		 * HomePage.enter_Drop_Place("Guindy");
		 * HomePage.select_CabType("Sedan"); HomePage.check_booklater();
		 */
	}

	@BeforeTest()
	public void initializeTheBrowser() throws IOException {
		initialize();

	}

	@Test(priority = 1, dataProvider = "HomePageTest")
	public void input(String dataset, String username, String mno,
			String pickup, String drop, String car) throws IOException {
		log = report.startTest(dataset);
		wd.get(envProp.getProperty("URL"));
		HomePage.enter_Username(username);
		HomePage.enter_Number(mno);
		HomePage.enter_Pickup_place(pickup);
		HomePage.enter_Drop_Place(drop);	
		HomePage.select_CabType(car);
		HomePage.check_booklater();
	}

	@DataProvider(name = "HomePageTest")
	public static Object[][] getdata() throws Exception {
		if (inputReader.RunModeVerification("HomePageTest"))

		{
			/*
			 * Object[][] data = new Object[2][5]; // First data set data[0][0]
			 * = "Abinaya"; data[0][1] = "9790823178"; data[0][2] = "Adyar";
			 * data[0][3] = "Guindy"; data[0][4] = "Sedan"; // second data set
			 * 
			 * data[1][0] = "Abinaya1"; data[1][1] = "97908996813"; data[1][2] =
			 * "Guindy"; data[1][3] = "Anna Nagar"; data[1][4] = "Sedan";
			 * 
			 * return data;
			 */

			Object[][] data = inputReader
					.selectSingleDataOrMulitiData("HomePageTest");
			return data;

		}
		return null;
	}

	@AfterMethod
	public void teardown(ITestResult r) throws IOException {
		if (r.isSuccess()) {
			
			ScreenshotGenerator.getScreenshot(r);

		} else {
			ScreenshotGenerator.getScreenshot(r);

		}
	}
}
