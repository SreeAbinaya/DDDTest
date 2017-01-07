package com.Vmetry.NTLTaxi.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.Vmetry.NTLTaxi.Initializer.Initializer;

public class ReportGenerator extends Initializer {
	
	public static void archieveFiles() throws IOException
	{
		if (isArchieve)
		{
		SimpleDateFormat dateformat = new SimpleDateFormat("YYYY-MM-DD-HH-MM-SS-mm");
		String date = dateformat.format(new Date());
		File source = new File("C:\\Selenium WorkSpace\\DDDTest\\screenshots");
		File destination = new File("C:\\Selenium WorkSpace\\DDDTest\\Oldscreenshots\\"+date);
		FileUtils.copyDirectory(source, destination);
		FileUtils.cleanDirectory(source);
		isArchieve = false;
		}
		
	}

}
