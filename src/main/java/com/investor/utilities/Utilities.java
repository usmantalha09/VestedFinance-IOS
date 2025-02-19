package com.investor.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
//import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.google.api.client.util.store.FileDataStoreFactory;
//import com.google.api.services.sheets.v4.Sheets;
//import com.google.api.services.sheets.v4.SheetsScopes;
//import com.google.api.services.sheets.v4.model.Sheet;
//import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.investor.base.BaseClass;


public class Utilities {

	public static String screenshotPath;
	public static String screenshotName;
	
	public static void printString(String msg) {
		System.out.println(msg);
	}
	
	public static String getDate(int days, String Format, String Time_Zone) throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat(Format);
		dateFormat.setTimeZone(TimeZone.getTimeZone(Time_Zone));
		Date date = new Date();
		String DF = dateFormat.format(date);

		Calendar c = Calendar.getInstance();
		c.setTime(dateFormat.parse(DF));
		c.add(Calendar.DATE, days);
		String formattedDate = dateFormat.format(c.getTime());
		return formattedDate;

	}

	public static String removeDollarandSpaces(String amount) {
		printString("Amount :  " + amount);
		if(amount.contains("$")) {
			amount = amount.replace("$", "").trim();
			printString("Remove Dollar :  " + amount);			
		}
		if(amount.contains(",")) {
			amount = amount.replace(",", "").trim();
			printString("Remove Dollar :  " + amount);						
		}
		
		amount = amount.replace(" ", "").trim();
		amount = amount.replaceAll("[^\\x00-\\x7F]","").trim();
		printString("Remove Space :  " + amount);						
		
		
		return amount.trim();
	}
	
	public static String removeCharsFromString(String str, String[] chars ) {
		
		for(String ch:chars) {
			str = str.replaceAll(ch,"").trim();
		}
		return str.trim();
	}
	
	public static ArrayList<String> getDateList(int maxdays, String Format, String Time_Zone) throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		for(int i=0 ; i<= maxdays ; i++) {
			DateFormat dateFormat = new SimpleDateFormat(Format);
			dateFormat.setTimeZone(TimeZone.getTimeZone(Time_Zone));
			Date date = new Date();
			String DF = dateFormat.format(date);
			Calendar c = Calendar.getInstance();
			c.setTime(dateFormat.parse(DF));
			c.add(Calendar.DATE, i);
			String formattedDate = dateFormat.format(c.getTime());
			dates.add(formattedDate);
		}
		return dates;
	}
	
	public String getDateWithTargetFormat(String date ,String Format, String Time_Zone,String targetFormat) throws ParseException{
		DateFormat dateFormat = new SimpleDateFormat(Format);
		dateFormat.setTimeZone(TimeZone.getTimeZone(Time_Zone));
		Date dateTime = dateFormat.parse(date);
		DateFormat targetFormating = new SimpleDateFormat(targetFormat);
		targetFormating.setTimeZone(TimeZone.getTimeZone(Time_Zone));
		return targetFormating.format(dateTime);
	}
	
	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "/target/surefire-reports/html/" + screenshotName));

	}

	private static String[][] convertToArray(List<List<Object>> data) {
	    String[][] array = new String[data.size()][];

	    int i = 0;
	    for (List<Object> row : data) {
	        array[i++] = row.toArray(new String[row.size()]);
	    }
	    return array;
	}
	
	
	public static boolean isTestRunnable(String testName, ExcelReader excel){
		
		String sheetName="test_suite";
		int rows = excel.getRowCount(sheetName);
		
		
		for(int rNum=2; rNum<=rows; rNum++){
			
			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			
			if(testCase.equalsIgnoreCase(testName)){
				
				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
				
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
			
			
		}
		return false;
	}
	
}