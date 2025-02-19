package com.investor.listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;

public class ExtentManager {

	private static ExtentReports extent;
	public static String configFilesPath = System.getProperty("user.dir") + File.separator + "extent-config.xml";
	private static ExtentTest test;
	    public static ExtentReports createInstance(String fileName) {
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	               
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	        htmlReporter.loadConfig(configFilesPath);
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Automation Tester", "Investor tester");
	        extent.setSystemInfo("Organization", "CodeAutomation");
	        extent.setSystemInfo("Environment", PropertiesReader.getPropertyValue("env"));
	        extent.setSystemInfo("Build", BaseClass.BuildNumber);
	 	        
	        return extent;
	    }

	    
	    public static String screenshotPath;
		public static String screenshotName;
		
		public static void captureScreenshot() {

			File scrFile = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);

			Date d = new Date();
			screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

			try {
				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/reports/" + screenshotName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.err.println(e.getMessage()+"\n\n"+e.getStackTrace());
			}
		}
		
		

	

	}
