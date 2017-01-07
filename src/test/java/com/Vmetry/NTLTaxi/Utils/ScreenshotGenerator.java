package com.Vmetry.NTLTaxi.Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.Vmetry.NTLTaxi.Initializer.Initializer;
import com.relevantcodes.extentreports.LogStatus;

public class ScreenshotGenerator extends Initializer {
	
	public static String Takescreenshoot(String name) throws IOException {
		File source = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"C:\\Selenium WorkSpace\\DDDTest\\screenshots\\" + name
						+ ".jpg");
		FileUtils.copyFile(source, destination);
		return destination.toString();
	}
	
	public static void getScreenshot(ITestResult result) throws IOException
	{
		Object[] data = result.getParameters();
		if (result.isSuccess()) {
			String path = Takescreenshoot(data[0].toString());
			log.log(LogStatus.PASS, data[0].toString(),
					log.addScreenCapture(path));
		} else {

			String path = Takescreenshoot(data[0].toString());
			log.log(LogStatus.FAIL, data[0].toString(),
					log.addScreenCapture(path));
			report.endTest(log);
			report.flush();
		}
	}

}
