package com.investor.listeners;

import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.velocity.util.StringUtils;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.json.JsonObjectParser;
import com.google.gson.JsonObject;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.utilities.EnvironmentSetup;
import com.investor.utilities.ModelTests;
import com.investor.utilities.ReportUtils;
import com.investor.utilities.SendEmail;
import com.investor.utilities.SlackUtils;
import com.investor.utilities.TestsDataConverter;
import com.investor.utilities.ZipUtils;
import org.apache.commons.configuration2.builder.fluent.Parameters;

public class ExtentListeners extends BaseClass implements ITestListener,ISuiteListener {

	static Date d = new Date();
	static String fileName = "iOS Automation Test Report.html";
	static Map<Long,ExtentTest> extentTestMap = new HashMap<Long,ExtentTest>();
	private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"/reports/"+fileName);
	public static String currentDateString;
	public static String currentTestMethodName = "Test";
	
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		currentTestMethodName = result.getMethod().getMethodName();
		//ExtentTest test = extent.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		extentTestMap.put(Thread.currentThread().getId(), test);
		testReport.set(test); 
	}
	
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		updateStatus(methodName,  "Passed");
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";
		updateTestData(testSuiteRunnerFileName,testSuiteRunnerSheetName, methodName, "Passed");
		try {

			ExtentManager.captureScreenshot();
			testReport.get().pass("<b>" + "<font color=" + "green>" + "Screenshot of Test Pass" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName)
							.build());
		} catch (IOException e) {

		}

		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(m);
		try {
			JavascriptExecutor jse = (JavascriptExecutor)BaseClass.getDriver();
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \""+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"\"}}");
		} catch (Exception e) {
		}
		if (BaseClass.driver!=null) {
			driver.quit();
		}
	}

	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		updateStatus(methodName,  "Failed");
		updateTestData(testSuiteRunnerFileName,testSuiteRunnerSheetName, methodName, "Failed");
		String excepionMessage=result.getThrowable().getLocalizedMessage();
		testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
				+ "</font>" + "</b >" + "</summary>" +result.getThrowable().getMessage()+"</details>"+" \n");

		try {

			ExtentManager.captureScreenshot();
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName)
							.build());
		} catch (Exception e) {

		}

		String failureLogg="TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);
		try {
			JavascriptExecutor jse = (JavascriptExecutor)BaseClass.getDriver();
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \""+excepionMessage+"\"}}");
		
		} catch (Exception e) {
		}
		if (BaseClass.driver!=null) {
			driver.quit();
		}
	}

	public void onTestSkipped(ITestResult result) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor)BaseClass.getDriver();
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \""+"TEST CASE:- "+ result.getMethod().getMethodName().toUpperCase()+ " PASSED"+"\"}}");
			if (BaseClass.driver!=null) {
				driver.quit();
			}
		} catch (Exception e) {
		}
		try {

			String methodName=result.getMethod().getMethodName();
			if (methodNamelist.get(methodName)>0) {
				extent.removeTest(getTest());
				return;
			}
			printString("Skipped: "+methodName);
			updateStatus(methodName,  "Skipped");
			//updateTestData(testSuiteRunnerFileName,testSuiteRunnerSheetName, methodName, "Skipped");
			String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";
			if(result.getThrowable()!=null) {
				logText = result.getThrowable().getLocalizedMessage()+"</br>"+logText;
			}
			Markup m=MarkupHelper.createLabel("<font color=" + "blue>" + logText
					+ "</font>", ExtentColor.YELLOW);
			testReport.get().skip(m);
		}catch(Exception e) {}
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}
	}
	
	public static ExtentTest getTest() {
		return (ExtentTest)extentTestMap.get((Thread.currentThread().getId()));
	}
	
	public static void captureErrorAndScreenshot(Throwable result) {
		String excepionMessage=Arrays.toString(result.getStackTrace());
		testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
				+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
		try {

			ExtentManager.captureScreenshot();
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName)
							.build());
		} catch (IOException e) {

		}
	}

	@Override
	public void onStart(ISuite suite) {
		try {
			syncBuildUrl();
		} catch (Exception e) {
		}
		
		try {
//			FileUtils.cleanDirectory(new File(System.getProperty("user.dir")+"/lastReport/"));
//			waitTime(500);
//			FileUtils.copyDirectory(new File(System.getProperty("user.dir")+"/reports/"), new File(System.getProperty("user.dir")+"/lastReport/"));
//			waitTime(500);
			FileUtils.cleanDirectory(new File(System.getProperty("user.dir")+"/reports/"));
		} catch (Exception e) {
			
		}
		currentDateString =new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		
	}

	@Override
	public void onFinish(ISuite suite) {
		if(runWithDashboard) {
			 try {
			 	updateJobCompletedStatus();
			 } catch (Exception e) {
			 	try {
			 		updateJobCompletedStatus();
			 	} catch (Exception e2) {
			 	}
			 }
			String reportLink = null;
			try {
				ZipUtils.generateZipFile();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
				 try {
		 	 		ReportUtils.archiveCurrentReport();
		 	 	}catch(Exception e) {
		 	 		try {
			  			ReportUtils.archiveCurrentReport();
			  		}catch(Exception e2) {
				 		System.err.println("////////////////////////////////\nUnable to Upload Report to Dashboard: "+e2.getStackTrace().toString()+"\n////////////////////////////////");
			  		}
		 	 	}
			}catch(Exception e) {
				
			}
			try {
				reportLink = ReportUtils.UploadFileToDrive();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
			} catch (Exception e) {
				try {
					reportLink = ReportUtils.UploadFileToDrive();
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e2) {
					}
				} catch (Exception e3) {
					System.err.println("////////////////////////////////\nUnable to Upload Report to Google Drive: "+e3.getStackTrace().toString()+"\n////////////////////////////////");
			 		
				}
			}
			try {
				Map<String, ISuiteResult> getResults = suite.getResults();
				ISuiteResult iSuiteResult = getResults.get(getResults.keySet().toArray()[0]);
				ITestContext iTestContext = iSuiteResult.getTestContext();
				String nameString = iTestContext.getName();
				int pass = iTestContext.getPassedTests().size();
				int fail = iTestContext.getFailedTests().size();
				int skip = iTestContext.getSkippedTests().size();
//				methodNamelist.forEach((k, v) -> {
//		            if(v>1) {
//		            	//add to skip here
//		            }
//		        });

				int total = pass+fail+skip;
				
				//Failed Test Cases
		 		Object[]FailedTest =  iTestContext.getFailedTests().getAllMethods().toArray() ;
		 		String FailedTestCases =  "-------------------------------------\nFailed Test Cases: ";
		 		for(int i = 0;i<FailedTest.length;i++) {
		 			String ClassName = FailedTest[i].toString().split("\\(")[0];
		 			String MethodName = ClassName.toString().split("\\.")[1];
		 			FailedTestCases = FailedTestCases+"\n-> "+MethodName;
		 		}
		 		FailedTestCases = FailedTestCases+"\n-------------------------------------\n";
		 		
		 		//Passed Test Cases
		 		Object[]PassedTest =  iTestContext.getPassedTests().getAllMethods().toArray() ;
		 		String PassedTestCases =  "-------------------------------------\nPassed Test Cases: ";
		 		for(int i = 0;i<PassedTest.length;i++) {
		 			String ClassName = PassedTest[i].toString().split("\\(")[0];
		 			String MethodName = ClassName.toString().split("\\.")[1];
		 			PassedTestCases = PassedTestCases+"\n-> "+MethodName;
		 		}
		 		PassedTestCases = PassedTestCases+"\n-------------------------------------\n";
				
				String emailBody = "=============================================================\n"+
									nameString+"\n"+
									"Environment: "+(PropertiesReader.getPropertyValue("env")).toUpperCase()+"\n"+
									"Tests Run: "+total+", Passed: "+pass+" ,Failures: "+fail+", Skipped: "+skip+"\n"+FailedTestCases+"\n"+PassedTestCases+"\n"+
									"=============================================================\n";
				printString(emailBody);
				try {
					SlackUtils.SendSlackMessage(emailBody);
				} catch (Exception e) {
					try {
						SlackUtils.SendSlackMessage(emailBody);
					} catch (Exception e2) {
						printString("Unable to Send Message to Slack: \n"+e.getMessage());
					}
				}
				try {
					if (reportLink!=null) {
						SendEmail.SendEmailNow(emailBody,reportLink);
					}else {
						SendEmail.SendEmailNow(emailBody);
					}
				} catch (Exception e) {
					try {
						if (reportLink!=null) {
							SendEmail.SendEmailNow(emailBody,reportLink);
						}else {
							SendEmail.SendEmailNow(emailBody);
						}
					} catch (Exception e2) {
						System.err.println("////////////////////////////////\nError Sending email : "+e2.getStackTrace().toString()+"\n////////////////////////////////");
				 		
					}
				}
				
			}catch(Exception e) {
				printString("Unable to send Email: "+e.getMessage());
			}
		}
		
	}
	
	public static void attachScreenShot(String name) {
		try {

			ExtentManager.captureScreenshot();
			testReport.get().pass("<b>" + "<font color=" + "green>" + name + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName)
							.build());
		} catch (IOException e) {

		}
	}
	

	public static void updateStatus(String testName, String status) {
		if(BaseClass.runWithDashboard) {
			ModelTests test=null;
			for(ModelTests itest:TestFilterListener.tests) {
				if(itest.getTestName().equalsIgnoreCase(testName)) {
					test=itest;
					break;
				}
			}
			test.setTestStatus(status);
			test.setBrowser(StringUtils.capitalizeFirstLetter(BaseClass.deviceName));
			test.setEnvironment(StringUtils.capitalizeFirstLetter(BaseClass.BuildNumber));
			test.setLastExecutionDate(new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime()));
			test.setExecutionCompleted(true);
			try {
				test.setVideoLink(BaseClass.browserStackJob.getVideoURL());
			} catch (Exception e) {
				try {
					if(browserStackJobStatus!=null) {
						JSONObject jsonObject = new JSONObject(browserStackJobStatus);
						test.setVideoLink(jsonObject.get("video_url").toString());
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
			try {
				printString("Updated Status\n===============================================");
				printString(test.toString());
				
				
	    		HttpClient client = HttpClients.custom().
	                    setHostnameVerifier(new AllowAllHostnameVerifier()).
	                    setSslcontext(new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy()
	                    {
	                    	public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException
	                    	{
	                    		return true;
	                    	}
	                    }).build()).build();
	        	
	        	 //Creating a HttpGet object
	    		HttpPost httpget = new HttpPost(api_base_url+"ios/UpdateStatus");
	    		ModelTests[] tests=new ModelTests[1];
	    		tests[0] = test;
	    		String json = TestsDataConverter.toJsonString(tests);
	    		
	    		StringEntity requestEntity = new StringEntity(
	    				json,
	    			    "application/json",
	    			    "UTF-8");
	    		httpget.setEntity(requestEntity);
	            //Executing the Get request
	            HttpResponse httpresponse = client.execute(httpget);
	            HttpEntity entity = httpresponse.getEntity();
	    	}catch (Exception e) {
	    		System.err.println(e.getStackTrace().toString());
			}
		}
	}

	public static void main(String[] args) {
		updateJobCompletedStatus();
	}
	public static void updateJobCompletedStatus() {
		if(BaseClass.runWithDashboard) {
			try {
	    		HttpClient client = HttpClients.custom().
	                    setHostnameVerifier(new AllowAllHostnameVerifier()).
	                    setSslcontext(new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy()
	                    {
	                    	public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException
	                    	{
	                    		return true;
	                    	}
	                    }).build()).build();
	        	
	        	 //Creating a HttpGet object
	    		HttpPost httpget = new HttpPost(api_base_url+"ios/UpdateJobCompleted"); 		
	    		StringEntity requestEntity = new StringEntity(
	    				"",
	    			    "application/json",
	    			    "UTF-8");
	    		httpget.setEntity(requestEntity);
	            //Executing the Get request
	            HttpResponse httpresponse = client.execute(httpget);
	            HttpEntity entity = httpresponse.getEntity();
	            printString(entity.toString());
	    	}catch (Exception e) {
	    		System.err.println(e.getStackTrace().toString());
			}
		}
	}
	
	 public void syncBuildUrl() {
	    	try {
	    		HttpClient client = HttpClients.custom().
	                    setHostnameVerifier(new AllowAllHostnameVerifier()).
	                    setSslcontext(new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy()
	                    {
	                    	public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException
	                    	{
	                    		return true;
	                    	}
	                    }).build()).build();
	        	
	        	 //Creating a HttpGet object
	            HttpGet httpget = new HttpGet(api_base_url+"IOSSetup/GetSelectedBuildUrl");
	            //Executing the Get request
	            HttpResponse httpresponse = client.execute(httpget);
	            HttpEntity entity = httpresponse.getEntity();
	            String response = EntityUtils.toString(entity);
	            printString("===========================");
	            printString(response);
	            printString("===========================");
//	            JsonNode node = new ObjectMapper().readTree(response);
//	            String buildUrlString = node.get("").asText();
	            Parameters params = new Parameters();
	            FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
	                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
	                .configure(params.properties()
	                    .setFileName(System.getProperty("user.dir")+ "/src/test/resources/config/Config.properties"));
	            Configuration config = builder.getConfiguration();
	            EnvironmentSetup setup = EnvironmentSetup.fromJsonString(response);
	            config.setProperty("env", setup.getBuildEnvironment().toLowerCase());
	            config.setProperty("app_build", setup.getBuildURL());
	            builder.save();
	    	}catch (Exception e) {
	    		System.err.println(e.getStackTrace().toString());
			}
	    }

}
