package com.Vmetry.NTLTaxi.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Vmetry.NTLTaxi.Initializer.Initializer;

public class HomePage extends Initializer{
	
	public static void enter_Username(String username) throws IOException
	{
		getWebElementByXpath("HOMEPAGE_TYPE_USERNAME_XPATH").sendKeys(username);
	}
	public static void enter_Number(String mno) throws IOException
	{
		getWebElementByXpath("HOMEPAGE_TYPE_MOBILENUMBER_XPATH").sendKeys(mno);
	}
	public static void enter_Pickup_place(String pickup) throws IOException
	{
		getWebElementByXpath("HOMEPAGE_TYPE_PICKUPPLACE_XPATH").sendKeys(pickup);
	}
	
	public static void enter_Drop_Place(String drop) throws IOException
	{
	 getWebElementByXpath("HOMEPAGE_TYPE_DROPPLACE_XPATH").sendKeys(drop);
		
	}
	
	public static void select_CabType(String car) throws IOException
	{
		WebElement we =getWebElementByXpath("HOMEPAGE_SELECT_CABTYPE_XPATH");
		Select s = new Select(we);
		s.selectByVisibleText(car);
	}
	public static void check_booklater() throws IOException
	{
		getWebElementByXpath("HOMEPAGE_CLICK_BOOKLATER_XPATH").click();
	}

}
