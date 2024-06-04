package org.kare;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Base {

	public static String getScreenshot(String testcaseName) throws IOException {

		TakesScreenshot t = (TakesScreenshot)ProductPurchase.driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir")+"//Reports//"+testcaseName+".png");
		FileUtils.copyFile(src, des);
		return System.getProperty("user.dir")+"//Reports//"+testcaseName+".png";
	
		
	}
	
}
