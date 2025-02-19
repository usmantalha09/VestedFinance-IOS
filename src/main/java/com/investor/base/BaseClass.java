package com.investor.base;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.google.common.collect.ImmutableList;
import com.investor.errorCollectors.ErrorCollector;
import com.investor.listeners.ExtentListeners;
import com.investor.utilities.BrowserStackJob;
import com.investor.utilities.ExcelReader;
import com.investor.utilities.Utilities;
import com.investor.utilities.Waits;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BaseClass extends Utilities{
	public static boolean closeDriver=false;
	public static WebDriverWait wait;
	public static String browser;
	public static String env;
	public static FileInputStream fis;
	public static ExtentTest extentReport;
	public static SoftAssert softAssert;
	public static Integer waitInSeconds = 5;

	//This is the default path to data package
	public static final String excelFilePath = System.getProperty("user.dir") + "/src/test/resources/data/";
	
	//This is the default path to imageUpload
	public static final String imagePath = System.getProperty("user.dir") + "/src/test/resources/data/images/";
	
	//This is excel file name
	public static final String potentialClientExcel = "potentialClientTestData";
	//This is column name from which we need to get row
	public static final String colName = "env";
	//This is row index of environment column from which we need to get data	
	public static int rowIndex = 0;
	//Excel file name
	public static final String testDataFile = "testData";
	//Excel sheetname
	public static final String testDataSheet = "TestData";
	public static final String KYC_NonAdaarReg = "KYC_NonAdaarReg";
	public static final String KYC_OtherNRI_Reg = "KYC_OtherNRI_Reg";
	
	//Test Suite Runner File Name
	public static final String testSuiteRunnerFileName = "SuiteTests-ios";
	//Test Suite Runner Sheet Name
	public static final String testSuiteRunnerSheetName = "Tests";
	
	public static final String TestDataFileName = "testData";
	
	public static final String TestDataSheetName = "TestData";
	
	public static final String testDataB2BUser = "LoginTestData_MultipleB2BUsers";
	
	public static final String testDataSheetB2BUser = "Non-SSO Credentials";
	
	public static final int defaultTimeForVisibility = 30;
	public static final int defaultTimeTOBeClickable = 30;
	
	
	public static HashMap <String, Integer> methodNamelist = new HashMap<>();

    public static String userName = "";
    public static String accessKey = "";
    public static URL url;
    public static DesiredCapabilities capabilities;
    
    
	public static AppiumDriver<MobileElement> driver;
	public static boolean runOnLocal = false;
	public static boolean runWithDashboard = true;
	public static boolean runOnBrowserStack = true;

	public static final String api_base_url = "";
	public static final String deviceName = "iPhone 14 Pro";
	public static final String BuildNumber = "5.48";
	public static BrowserStackJob browserStackJob;
	public static String browserStackJobStatus;
	
	public static String appBundleId = "com.vested.investing.ios.staging";
	
	public static final String preProdEnv = "pre-prod";
	public static boolean isPreProdEnv = false;
	
	public static void initReport() {
		extentReport = ExtentListeners.testReport.get();
		softAssert = new SoftAssert();
	}
	public static void initConfiguration() {
		
		env = PropertiesReader.getPropertyValue("env");
		isPreProdEnv = env.equalsIgnoreCase(preProdEnv)?true:false;
		try {
			
			if(extentReport==null) {
				initReport();
			}

			if(!runOnBrowserStack) {
				String buildPath = System.getProperty("user.dir") + "/src/test/resources/executables/Vested Staging.app";
				final String URL_STRING = "http://127.0.0.1:4723/wd/hub	";
			    url = new URL(URL_STRING);
			    capabilities = new DesiredCapabilities();
			    
			    capabilities.setCapability("deviceName", "iPhone 12 Pro");
			    capabilities.setCapability("platformVersion", "15");
			    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			    capabilities.setCapability(MobileCapabilityType.APP, buildPath);
			    capabilities.setCapability("autoAcceptAlerts","true");
			    capabilities.setCapability("autoGrantPermissions", "true");
			    capabilities.setCapability("systemPort", "8201");
			    capabilities.setCapability("wdaStartupRetries", "4");
			    capabilities.setCapability("iosInstallPause","8000" );
			    capabilities.setCapability("wdaStartupRetryInterval", "20000");
			  
			    capabilities.setCapability("usePrebuiltWDA", "true");
			    driver = new IOSDriver<MobileElement>(url, capabilities);
			    printString("Running on Local Machine");

			}else {							
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("os_version", "16");
				capabilities.setCapability("device", deviceName);
				capabilities.setCapability("app", "bs://68a16bcf2d1d2f5407b79c84c49a776f8b72e17d");
				capabilities.setCapability("project", "Vested Finance");
				capabilities.setCapability("build", "IOS Tests Run on "+ExtentListeners.currentDateString);
				capabilities.setCapability("name", ExtentListeners.currentTestMethodName);
				capabilities.setCapability("browserstack.idleTimeout", "600000");
				capabilities.setCapability("browserstack.debug", "true");
				capabilities.setCapability("autoAcceptAlerts", "true");
				
				
				driver = new IOSDriver<MobileElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);
				printString("Running on BrowserStack");
				
			}
			try {
				driver.setSetting("snapshotMaxDepth", 60);
				driver.setSetting("customSnapshotTimeout", 50000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		    driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertiesReader.getPropertyValue("implicit.wait")), TimeUnit.SECONDS);
		    
		    try {
		    	waitTime(3000);
		    	
		    	new TouchAction(driver).tap(PointOption.point(264, 602)).perform();
		    	printString("Permission Allowed from Base");
			} catch (Exception e) {
				printString(e.getMessage());
			}
		    try {
		    	JavascriptExecutor jse = (JavascriptExecutor)driver;
				Object response = jse.executeScript("browserstack_executor: {\"action\": \"getSessionDetails\"}");
				System.out.println(response);
				browserStackJobStatus = response.toString();
				printString("BS Logs: "+browserStackJobStatus);
				browserStackJob = BrowserStackJob.fromJsonString(response.toString());
		    }catch(Exception e) {
		    	printString("BS Log Messgae: "+e.getMessage());
		    }
		    
		} catch (Exception e) {
			System.out.println("Cause: "+e.getCause());
			System.out.println("Message: "+e.getMessage());
			//e.printStackTrace();
		}
		System.out.println("Application Started");
	}

	@AfterTest
	public void tearDown() {
	//	driver.quit();
	}
	
	public void pressBack() {
		try {
			driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='chevron_left'])[last()]")).click();
		} catch (Exception e) {
			try {
				driver.findElement(By.xpath("//XCUIElementTypeOther[@name='']")).click();
			} catch (Exception e2) {
				new TouchAction(driver).tap(PointOption.point(20, 68)).perform();
			}
		}
    }
	
	public static AppiumDriver<MobileElement> getDriver() {
		return driver;
	}
	
	public static void printString(String message) {
		try {
			System.out.println(message);			
		}catch (Exception e) {
			//e.printStackTrace();
		}
	}

	public void waitForElementToBePresent(WebElement locator, int timeOutInSeconds) {

		WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	
	public void tryWaitForElementToBePresent(WebElement locator, int timeOutInSeconds) {
		try {

			WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(locator));
		}catch(Exception e) {}
	}

	public void waitForElementsToBePresent(List<WebElement> locator, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElements(locator));
	}

	public void waitForElementToBeClickable(WebElement by, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public IOSElement waitForElementToBePresent(By locator, int timeOutInSeconds) {

		WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
		return (IOSElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

//	public AndroidElement waitForElementToBeInvisible(WebElement locator, int timeOutInSeconds) {
//
//		WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
//		return (AndroidElement) wait.until(ExpectedConditions.invisibilityOf(locator));
//	}
	
	public void clickElement(IOSElement element, String elementLabel) {
		//ExtentTestManager.getTest().info("Clicking " + elementLabel);
		element.click();
	}
	
	public void clickWebElement(WebElement element) {
		element.click();
	}

	public AndroidElement findElement(By locator) {
		return (AndroidElement) getDriver().findElement(locator);

	}

	public void sendKeysToElement(WebElement element, String keys,String elementLabel) {
		//ExtentTestManager.getTest().info("Entering "+ elementLabel + ": " + keys);\
		element.clear();
		element.sendKeys(keys);
		hideKeyboard(element);
	}

	public void sendKeysToElementWithoutReturn(WebElement element, String keys,String elementLabel) {
		//ExtentTestManager.getTest().info("Entering "+ elementLabel + ": " + keys);\
		element.clear();
		element.sendKeys(keys);
	}
	
	public void hideKeyboard(WebElement element) {
//		IOSDriver<WebElement> AD= (IOSDriver) getDriver();
//		AD.getKeyboard().sendKeys(keysToSend);
		waitTime(1000);
		try {
			element.sendKeys(Keys.RETURN);
		} catch (Exception e) {
			try {
				getDriver().findElement(By.xpath("//XCUIElementTypeKey[@name='done']")).click();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public void sendKeysToWebElement(WebElement element, String keys,String elementLabel) {
		//ExtentTestManager.getTest().info("Entering "+ elementLabel + ": " + keys);
		element.clear();
		element.sendKeys(keys);
		Waits.wait1s();

	}

	public String getElementText(WebElement element) {
		return element.getText();
	}
	
	public String getElementAttribute(WebElement element,String attribute) {
		return element.getAttribute(attribute);
	}
	
	public String getWebElementText(WebElement element, String elementLabel) {
		//ExtentTestManager.getTest().info("Getting "+elementLabel+ " Text" );
		return element.getText();
	}

	public boolean isElementClickable(By locator, int timeOutInSeconds)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public boolean isElementClickable(WebElement locator, int timeOutInSeconds)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean isElementSelected(WebElement element)
	{
		boolean isSelected = element.isSelected();
		return isSelected;
	}

	public boolean isElementDisplayed(WebElement element)
	{
		try {
			if(element.isDisplayed()) {
			return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}	
	}
	
	public void swipeRightAtYLocation(int h1) {
		TouchAction action = new TouchAction(getDriver());
		PointOption p1 = new PointOption();
		Dimension dimensions = getDriver().manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		Double screenWidth = dimensions.getWidth() * .61;
		int width1 = screenWidth.intValue();
		Double screenWidthEnd = dimensions.getWidth() * 0.2;
		int width2 = screenWidthEnd.intValue();
		action.press(PointOption.point(width1, h1)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(1100)))
				.moveTo(PointOption.point(width2, h1)).release().perform();
	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		scrollObject.put("element", ((RemoteWebElement) element).getId());
		js.executeScript("mobile: scroll", scrollObject);
	}
	
	public void swipeUpSlightly() {
		new TouchAction((PerformsTouchActions)getDriver()).press(PointOption.point(550, 330)).waitAction().moveTo(PointOption.point(550, 60)).release().perform();
	}
	
	public void swipeDownSlightly() {
		new TouchAction((PerformsTouchActions)getDriver()).press(PointOption.point(550, 330)).waitAction().moveTo(PointOption.point(550, 60)).release().perform();
	}
	
	public void swipeUpSlightlyWithUiAutomator() {
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()");
	}

	public void swipeUp() {
		//ExtentTestManager.getTest().info("Swiping screen");
		TouchAction action = new TouchAction(getDriver());
		PointOption p1= new PointOption();
		Dimension dimensions = getDriver().manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.55;
		Double screenWidth = dimensions.getWidth() * .5;
		int width = screenWidth.intValue();
		int h1 = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int h2 = screenHeightEnd.intValue();
//		action.press(PointOption.point(width,h1))
//				.waitAction()
//				.moveTo(PointOption.point(width, h2))
//				.release()
//				.perform();
		
		//new TouchAction((PerformsTouchActions)getDriver()).press(PointOption.point(width,h1)).waitAction().moveTo(PointOption.point(width, h2)).release().perform();
		try {
		//	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).flingForward()");
		}catch(Exception e) {}
	}
	
	public void scrollUp() {
		//ExtentTestManager.getTest().info("Swiping screen");
		TouchAction action = new TouchAction(getDriver());
		PointOption p1= new PointOption();
		Dimension dimensions = getDriver().manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.55;
		Double screenWidth = dimensions.getWidth() * .5;
		int width = screenWidth.intValue();
		int h1 = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int h2 = screenHeightEnd.intValue();
		action.press(PointOption.point(width,h1))
				.waitAction()
				.moveTo(PointOption.point(width, h2))
				.release()
				.perform();		
	}
	
	public void scrollDown() {
		//ExtentTestManager.getTest().info("Swiping screen");
		TouchAction action = new TouchAction(getDriver());
		PointOption p1= new PointOption();
		Dimension dimensions = getDriver().manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.2;
		Double screenWidth = dimensions.getWidth() * .5;
		int width = screenWidth.intValue();
		int h1 = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.55;
		int h2 = screenHeightEnd.intValue();
		action.press(PointOption.point(width,h1))
				.waitAction()
				.moveTo(PointOption.point(width, h2))
				.release()
				.perform();		
	}
	
	public void scrollIntoViewSmoothly(WebElement Element) {
		Dimension dimension = getDriver().manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.5);
        int scrollEnd = (int) (dimension.getHeight() * 0.2);

        new TouchAction((PerformsTouchActions) getDriver())
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
	}

	public String randomString( int len ){
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();
		StringBuilder sb = new StringBuilder( len );
		for( int i = 0; i < len; i++ )
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}

	public String randomNumberString( int len ){
		String AB = "123456789";
		SecureRandom rnd = new SecureRandom();
		StringBuilder sb = new StringBuilder( len );
		for( int i = 0; i < len; i++ )
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}

	public void longPress(AndroidElement ele, String elementLabel) {
		//ExtentTestManager.getTest().info("Long press "+elementLabel );
		Duration d1 = Duration.between(LocalTime.MAX,LocalTime.NOON);
		new TouchAction(getDriver())
				.longPress(new LongPressOptions()
						.withElement(ElementOption.element(ele))
						.withDuration(d1))
				.release()
				.perform();
	}

	public boolean isElementPresent(WebElement element, String elementLabel){
		//ExtentTestManager.getTest().info("Checking " + elementLabel + " is present");
		try{
			waitForElementToBePresent(element, 30);
			return true;
		}catch (Exception e){
			return false;
		}
	}

	public boolean isElementPresent(WebElement element, int timeOutInSeconds){
		//ExtentTestManager.getTest().info("Checking " + elementLabel + " is present");
		try{
			waitForElementToBePresent(element, timeOutInSeconds);
			return true;
		}catch (Exception e){
			return false;
		}
	}

	public boolean isElementPresent(By element, int timeOutInSeconds){
		//ExtentTestManager.getTest().info("Checking " + elementLabel + " is present");
		try{
			waitForElementToBePresent(element, timeOutInSeconds);
			return true;
		}catch (Exception e){
			return false;
		}
	}

	public void appRunInBackGround(){
//		////ExtentTestManager.getTest().info("Minimizing application");
		getDriver().runAppInBackground(Duration.ofSeconds(1));
		//ExtentTestManager.getTest().info("Re-opening application");
	}

	public void killApplication(){
//		//ExtentTestManager.getTest().info("closing application");
		getDriver().closeApp();
		getDriver().quit();
	}
	
	public void launchApplication() {
		getDriver().launchApp();
	}

	public void swipeScreen(String dir) {

		final int ANIMATION_TIME = 200;
		final int PRESS_TIME = 200;
		int edgeBorder = 10;

		PointOption pointOptionStart, pointOptionEnd;

		Dimension dims = getDriver().manage().window().getSize();
		pointOptionStart = point(dims.width / 2, dims.height / 2);

		switch (dir.toLowerCase()) {
			case "down":
				pointOptionEnd = point(dims.width / 2, dims.height - edgeBorder);
				break;
			case "up":
				pointOptionEnd = point(dims.width / 2, edgeBorder);
				break;
			case "left":
				pointOptionEnd = point(edgeBorder, dims.height / 2);
				break;
			case "right":
				pointOptionEnd = point(dims.width - edgeBorder, dims.height / 2);
				break;
			default:
				throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
		}

		try {
			new TouchAction((PerformsTouchActions) getDriver())
					.press(pointOptionStart)
					.waitAction(waitOptions(ofMillis(PRESS_TIME)))
					.moveTo(pointOptionEnd)
					.release().perform();
		} catch (Exception e) {
			System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
			return;
		}

		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {

		}
	}

	public void swipeByElements (AndroidElement startElement, AndroidElement endElement) {
		int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
		int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
		int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
		int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);
		new TouchAction((PerformsTouchActions) getDriver())
				.press(point(startX,startY))
				.waitAction(waitOptions(ofMillis(1000)))
				.moveTo(point(endX, endY))
				.release().perform();

	}

	public void goBack(int numberOfTimes){

		for (int i=0; i<numberOfTimes; i++){

			//getDriver().pressKey(new KeyEvent(AndroidKey.BACK));
			Waits.wait1s();

		}
	}
	
	public static String getUniqueEmailId(String value) {	
		throw new SkipException("It is to be skipped as per Apurva Jain instructions.");
//		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyHmm");
//		Date date = new Date();
//		String unique = formatter.format(date).toString();
//		String uniqueEmailId = value + unique + "@codeautomation.ai";
//		return uniqueEmailId;
	}
	
	public static String getUniquePassword() {
		SimpleDateFormat formatter = new SimpleDateFormat("mmss");
		Date date = new Date();
		String unique = formatter.format(date).toString();
		String passString="Pass"+unique+"#";
		return passString;
	}
	
	public void updateConfigurations(String key, String value) {
		try { 
			Parameters params = new Parameters();
	         FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
	             new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
	             .configure(params.properties()
	                 .setFileName(System.getProperty("user.dir")+ "/src/test/resources/config/Config.properties"));
	         Configuration config;
			config = builder.getConfiguration();
			config.setProperty(key, value);
	         builder.save();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
         
	}
    
	
	 public Object[][] getData(String filename, String SheetName) {

			ExcelReader excel = new ExcelReader(
					excelFilePath + filename + ".xlsx");
			int rows = excel.getRowCount(SheetName);
			int columns = excel.getColumnCount(SheetName);

			Object[][] data = new Object[rows - 1][columns];

			for (int rowNum = 2; rowNum <= rows; rowNum++) {
				for (int colNum = 0; colNum < columns; colNum++) {

					data[rowNum - 2][colNum] = excel.getCellData(SheetName, colNum, rowNum);
				}
			}
			return data;
	}
	 
	 public static void waitTime(int time) {
			try {
				Thread.sleep(time);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	 
	 public void scrollToText(String text) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		HashMap scrollObjectHashMap=new HashMap<>();
		scrollObjectHashMap.put("direction", "down");
		scrollObjectHashMap.put("predicateString", "label == '"+text+"'");
		jsExecutor.executeScript("mobile: scroll", scrollObjectHashMap);
	}
	 
	 public void scrollToTextContains(String text) {
			String str1 = "new UiScrollable(new UiSelector().scrollable(true).";
			String str2 = "instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))";
			String user_scroll = str1.concat(str2);
		//	getDriver().findElementByAndroidUIAutomator(user_scroll);
		}


	public static void waitForElementVisibility(WebElement element, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForElementInvisibility(WebElement element, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void click(WebElement element) {
		waitForElementVisibility(element, defaultTimeForVisibility);
		waitForElementToBeClickable(element, defaultTimeTOBeClickable);
		element.click();
	}

	public void sendKeysToWebElement(WebElement element, String keys) {
	//	waitForElementVisibility(element, defaultTimeForVisibility);
	//	waitForElementToBeClickable(element, defaultTimeTOBeClickable);
		//waitTime(500);
		element.clear();
		waitTime(500);
		element.sendKeys(keys);
		Waits.wait1s();

	}
	
	public void typeKeysViaKeyboard(String keys) {
    	waitTime(3000);
    	char[] digitChars = keys.toLowerCase().toCharArray();
    	for(int i=0;i<digitChars.length;i++) {
    		if(i==0 && !Character.isDigit(digitChars[i])) {
    			getDriver().findElement(By.xpath("//XCUIElementTypeKey[@name='"+Character.toUpperCase(digitChars[i])+"']")).click();
    		}else {
    			getDriver().findElement(By.xpath("//XCUIElementTypeKey[@name='"+digitChars[i]+"']")).click();
			}
    		
    	}
	}
	
	public static void clearUsingJavascriptExecutor(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", element);
	}
	
	public static String generateRandomNumberWithGivenNumberOfDigits(int number) {
		String randomNumber = "123456789";
		StringBuilder sb = new StringBuilder(number);
		for (int i = 0; i < number; i++) {
			int index = (int) (randomNumber.length() * Math.random());
			sb.append(randomNumber.charAt(index));
		}
		return sb.toString();
	}
	public Object[][] getSuiteTests(String filename, String SheetName) {

		ExcelReader excel = new ExcelReader(
				System.getProperty("user.dir") + "/src/test/resources/data/" + filename + ".xlsm");
		int rows = excel.getRowCount(SheetName);
		int columns = excel.getColumnCount(SheetName);

		Object[][] data = new Object[rows - 1][columns];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < columns; colNum++) {

				data[rowNum - 2][colNum] = excel.getCellData(SheetName, colNum, rowNum);
			}
		}
		return data;
	}
	
	public void updateTestData(String filename,String sheetName,String testName ,String status) {
		
		ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/data/" + filename + ".xlsm");
		Object[][] data = getSuiteTests(filename, sheetName);
		int rowNum = -1;
		for(int x=0;x<data.length;x++) {
			if(data[x][1].toString().equals(testName)) {
				rowNum=x+2;
			}
		}
		printString("Updated Test Result: "+excel.setCellData(sheetName, "Status", rowNum, status));
	}
	
	public void pressBackOnActionBar() {
		getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name='chevron_left']")).click();
		
	}
	
	public void triggerBrowserStackLoginTestAsPassed(String email) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor)BaseClass.getDriver();
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \""+"TEST Login:- "+email+ " PASSED"+"\"}}");
		} catch (Exception e) {
		}
	}
		
	public void triggerBrowserStackLoginTestAsFailed(String email) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor)BaseClass.getDriver();
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \""+"TEST Login:- "+email+ " PASSED"+"\"}}");
		} catch (Exception e) {
		}
	}
	
	public void scrollDownToText(String text) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		HashMap scrollObjectHashMap=new HashMap<>();
		scrollObjectHashMap.put("direction", "down");
		scrollObjectHashMap.put("predicateString", "label == '"+text+"'");
		jsExecutor.executeScript("mobile: scroll", scrollObjectHashMap);
	}
	
	public void scrollUpToText(String text) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		HashMap scrollObjectHashMap=new HashMap<>();
		scrollObjectHashMap.put("direction", "up");
		scrollObjectHashMap.put("predicateString", "label == '"+text+"'");
		jsExecutor.executeScript("mobile: scroll", scrollObjectHashMap);
	}
	
	public void scrollRightToText(String text) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		HashMap scrollObjectHashMap=new HashMap<>();
		scrollObjectHashMap.put("direction", "right");
		scrollObjectHashMap.put("predicateString", "label == '"+text+"'");
		jsExecutor.executeScript("mobile: scroll", scrollObjectHashMap);
	}
	
	public void scrollRightUntilTextDisplaying(String text) {
		if(driver.findElements(By.xpath("(//*[contains(@label,'"+text+"')])[last()]")).size()>0) {
			for(int i=1;i<6;i++) {
				if(isElementDisplayed(driver.findElement(By.xpath("(//*[contains(@label,'"+text+"')])[last()]")))) {
					return;
				}
				JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
				HashMap scrollObjectHashMap=new HashMap<>();
				scrollObjectHashMap.put("direction", "right");
				jsExecutor.executeScript("mobile: scroll", scrollObjectHashMap);
				waitTime(1000);
			}
		}else {
			printString("Text element not present");
		}
	}
	
	public void scrollToElementUpward(MobileElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap scrollObjects = new HashMap();
		scrollObjects.put("element",  element.getId());
		scrollObjects.put("direction", "up");
		driver.executeScript("mobile: scroll", scrollObjects );
	}
	
	public void swipeScreen(Direction dir) {
	    System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

	    // Animation default time:
	    //  - Android: 300 ms
	    //  - iOS: 200 ms
	    // final value depends on your app and could be greater
	    final int ANIMATION_TIME = 200; // ms

	    final int PRESS_TIME = 200; // ms

	    int edgeBorder = 10; // better avoid edges
	    PointOption pointOptionStart, pointOptionEnd;

	    // init screen variables
	    Dimension dims = driver.manage().window().getSize();

	    // init start point = center of screen
	    pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

	    switch (dir) {
	        case DOWN: // center of footer
	            pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
	            break;
	        case UP: // center of header
	            pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
	            break;
	        case LEFT: // center of left side
	            pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
	            break;
	        case RIGHT: // center of right side
	            pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
	            break;
	        default:
	            throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
	    }

	    // execute swipe using TouchAction
	    try {
	        new TouchAction(driver)
	                .press(pointOptionStart)
	                // a bit more reliable when we add small wait
	                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
	                .moveTo(pointOptionEnd)
	                .release().perform();
	    } catch (Exception e) {
	        System.out.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
	        return;
	    }

	    // always allow swipe action to complete
	    try {
	        Thread.sleep(ANIMATION_TIME);
	    } catch (InterruptedException e) {
	        // ignore
	    }
	}

	public enum Direction {
	    UP,
	    DOWN,
	    LEFT,
	    RIGHT;
	}
	
	public void scrollRight(int iter) {
		for(int i=1;i<=iter;i++) {
			mobileScrollScreenIOS(Direction.RIGHT);
		}
	}
	
	public void mobileScrollScreenIOS(Direction dir) {
	    System.out.println("mobileScrollScreenIOS(): dir: '" + dir + "'"); // always log your actions

	    // Animation default time:
	    //  - iOS: 200 ms
	    // final value depends on your app and could be greater
	    final int ANIMATION_TIME = 200; // ms
	    final HashMap<String, String> scrollObject = new HashMap<String, String>();

	    switch (dir) {
	        case DOWN: // from down to up (! differs from mobile:swipe)
	            scrollObject.put("direction", "down");
	            break;
	        case UP: // from up to down (! differs from mobile:swipe)
	            scrollObject.put("direction", "up");
	            break;
	        case LEFT: // from left to right (! differs from mobile:swipe)
	            scrollObject.put("direction", "left");
	            break;
	        case RIGHT: // from right to left (! differs from mobile:swipe)
	            scrollObject.put("direction", "right");
	            break;
	        default:
	            throw new IllegalArgumentException("mobileScrollIOS(): dir: '" + dir + "' NOT supported");
	    }
	    try {
	        driver.executeScript("mobile:scroll", scrollObject); // swipe faster then scroll
	        Thread.sleep(ANIMATION_TIME); // always allow swipe action to complete
	    } catch (Exception e) {
	        System.err.println("mobileScrollIOS(): FAILED\n" + e.getMessage());
	        return;
	    }
	}
	
	public void mobileScrollScreenIOS(Direction dir,int ANIMATION_TIME_MS) {
	    System.out.println("mobileScrollScreenIOS(): dir: '" + dir + "'"); // always log your actions

	    // Animation default time:
	    //  - iOS: 200 ms
	    // final value depends on your app and could be greater
	    //final int ANIMATION_TIME = 200; // ms
	    final HashMap<String, String> scrollObject = new HashMap<String, String>();

	    switch (dir) {
	        case DOWN: // from down to up (! differs from mobile:swipe)
	            scrollObject.put("direction", "down");
	            break;
	        case UP: // from up to down (! differs from mobile:swipe)
	            scrollObject.put("direction", "up");
	            break;
	        case LEFT: // from left to right (! differs from mobile:swipe)
	            scrollObject.put("direction", "left");
	            break;
	        case RIGHT: // from right to left (! differs from mobile:swipe)
	            scrollObject.put("direction", "right");
	            break;
	        default:
	            throw new IllegalArgumentException("mobileScrollIOS(): dir: '" + dir + "' NOT supported");
	    }
	    scrollObject.put("percent", "0.7");
	    try {
	        driver.executeScript("mobile: scrollGesture", scrollObject); // swipe faster then scroll
	        Thread.sleep(ANIMATION_TIME_MS); // always allow swipe action to complete
	    } catch (Exception e) {
	        System.err.println("mobileScrollIOS(): FAILED\n" + e.getMessage());
	        return;
	    }
	}
	public void swipeUpLess() {
		// ExtentTestManager.getTest().info("Swiping screen");
		TouchAction action = new TouchAction(getDriver());
		PointOption p1 = new PointOption();
		Dimension dimensions = getDriver().manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.55;
		Double screenWidth = dimensions.getWidth() * .5;
		int width = screenWidth.intValue();
		int h1 = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int h2 = screenHeightEnd.intValue();
		action.press(PointOption.point(width, h1)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(1100)))
				.moveTo(PointOption.point(width, h2)).release().perform();
	}
	
	public void swipeRightAtBottom() {
		// ExtentTestManager.getTest().info("Swiping screen");
		TouchAction action = new TouchAction(getDriver());
		PointOption p1 = new PointOption();
		Dimension dimensions = getDriver().manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.75;
		Double screenWidth = dimensions.getWidth() * .75;
		int width1 = screenWidth.intValue();
		int h1 = screenHeightStart.intValue();
		Double screenWidthEnd = dimensions.getWidth() * 0.2;
		int width2 = screenWidthEnd.intValue();
		action.press(PointOption.point(width1, h1)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(1100)))
				.moveTo(PointOption.point(width2, h1)).release().perform();
	}
	public void swipeRightAtCenter() {
		// ExtentTestManager.getTest().info("Swiping screen");
		TouchAction action = new TouchAction(getDriver());
		PointOption p1 = new PointOption();
		Dimension dimensions = getDriver().manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		Double screenWidth = dimensions.getWidth() * .75;
		int width1 = screenWidth.intValue();
		int h1 = screenHeightStart.intValue();
		Double screenWidthEnd = dimensions.getWidth() * 0.2;
		int width2 = screenWidthEnd.intValue();
		action.press(PointOption.point(width1, h1)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(1100)))
				.moveTo(PointOption.point(width2, h1)).release().perform();
	}
	
	public void scrollToMobileElement(String elementName, String direction) {
	    final int maximumScrolls = 5;
	    for (int i = 0; i < maximumScrolls; i++) {
	        try {
	            if (findElementsByPredicateString("name == '"+elementName+"' OR label == '"+elementName+"' OR value == '"+elementName+"'").size() > 0)
	            // PredicateString & label is the locator strategy that I used. It can be changed to others as needed for your app.
	                break;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        scroll(direction);
	    }
	}

	private void scroll(String direction) {
	    final HashMap<String, String> scrollObject = new HashMap<String, String>();
	    scrollObject.put("direction", direction);
	    driver.executeScript("mobile:scroll", scrollObject);
	}

	public List<MobileElement> findElementsByPredicateString(String predicateString) {
	    return driver.findElements(MobileBy.iOSNsPredicateString(predicateString));
	}
	
	public void scrollDownToIOSElement(IOSElement el) {
		HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        scrollObject.put("element", el.getId());
        ((JavascriptExecutor)getDriver()).executeScript("mobile: swipe", scrollObject);
}
	public void scrollDownToIOSElement(MobileElement el) {
		HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        scrollObject.put("element", el.getId());
        ((JavascriptExecutor)getDriver()).executeScript("mobile: swipe", scrollObject);
}
	public String getClipboardText() throws UnsupportedFlavorException, IOException {
		
		String NOTES_ID = "com.apple.mobilenotes";
		 By NEW_NOTE = MobileBy.AccessibilityId("New note");
		     By NOTE_CONTENT = MobileBy.AccessibilityId("New note");
		    By PASTE = MobileBy.AccessibilityId("Paste");
		    
		    
		driver.activateApp(NOTES_ID);
        wait.until(ExpectedConditions.presenceOfElementLocated(NEW_NOTE)).click();
        WebElement note = wait.until(ExpectedConditions.presenceOfElementLocated(NOTE_CONTENT));
        note.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(PASTE)).click();
        String data = note.getText();
        System.out.println("Clipboard text was: " + data);


		return data;
	}
	
	public void clickOnElementRightDownCorner(WebElement ele) {
		Point loc = ele.getLocation();
		Dimension d = ele.getSize();
		int x = loc.getX();
		int y = loc.getY();
		int halfHeight = d.getHeight()/2;
		int halfwidth = d.getWidth()/2;
		int xLoc = (x+d.getWidth())-25;
		int yLoc = y+(halfHeight+(halfHeight/2));
		new TouchAction((PerformsTouchActions) getDriver())
		.press(PointOption.point(xLoc, yLoc))
		.release().perform();
	}
	
	private Dimension getWindowSize() { 
		return getDriver().manage().window().getSize();
	}
	

	protected void swipe(double startXPct, double startYPct, double endXPct, double endYPct, Duration duration) {
		Dimension size = getWindowSize();
		Point start = new Point((int)(size.width * startXPct), (int)(size.height * startYPct));
		Point end = new Point((int)(size.width * endXPct), (int)(size.height * endYPct));
		swipe(start, end, duration);
	}
	
	private static int ANDROID_SCROLL_DIVISOR = 3;
	protected void swipe(Point start, Point end, Duration duration) {

		boolean isAndroid = false;//driver instanceof AndroidDriver<MobileElement>;

        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        if (isAndroid) {
            duration = duration.dividedBy(ANDROID_SCROLL_DIVISOR);
        } else {
            swipe.addAction(new Pause(input, duration));
            duration = Duration.ZERO;
        }
        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver<MobileElement>) driver).perform(ImmutableList.of(swipe));
        
        


	}
	
	private static Duration SCROLL_DUR = Duration.ofMillis(1000);
	protected void scroll(ScrollDirection dir, double distance) {
		if (distance < 0 || distance > 1) {
            throw new Error("Scroll distance must be between 0 and 1");
        }
        Dimension size = getWindowSize();
        Point midPoint = new Point((int)(size.width * 0.5), (int)(size.height * 0.5));
        int top = midPoint.y - (int)((size.height * distance) * 0.5);
        int bottom = midPoint.y + (int)((size.height * distance) * 0.5);
        int left = midPoint.x - (int)((size.width * distance) * 0.5);
        int right = midPoint.x + (int)((size.width * distance) * 0.5);
        if (dir == ScrollDirection.UP) {
            swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
        } else if (dir == ScrollDirection.DOWN) {
            swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
        } else if (dir == ScrollDirection.LEFT) {
            swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
        } else {
            swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
        }
	}
	public enum ScrollDirection {
		   UP, DOWN, LEFT, RIGHT
		}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
