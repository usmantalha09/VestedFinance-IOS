package com.investor.listeners;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

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
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.investor.base.BaseClass;
import com.investor.utilities.ModelTests;
import com.investor.utilities.TestsDataConverter;
 
public class TestFilterListener extends BaseClass implements IMethodInterceptor {
public static ModelTests[] tests;
	
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
    	if(BaseClass.runWithDashboard) {
    		ArrayList<String> testsToRun = getTestsNamesFromDB();
    		for(int i=0;i<5;i++) {
    			if(testsToRun==null) {
    				printString("Waiting for 2 minutes for dashboard to be online...");
    				waitTime(120000);
    				testsToRun = getTestsNamesFromDB();
    			}else {break;}
    		}
	    	List<IMethodInstance> methodsToRun = new ArrayList<>();
	    	List<String> localMethods = new ArrayList<>();
	    	for (IMethodInstance method:methods) {
	    		localMethods.add(method.getMethod().getMethodName());
	    		printString(method.getMethod().getMethodName());
		    	if(testsToRun.contains(method.getMethod().getMethodName())) {
		    		methodsToRun.add(method);
		    		methodNamelist.put(method.getMethod().getMethodName(), 0);
		    	}
	    	}
	    	printString("===============Available on Cloud but not running locally!");
	    	localMethods.removeAll(testsToRun);
	    	printString(localMethods.toString().replaceAll(",", "\n"));
	    	printString(localMethods.size()+"");
	    	printString("===========================================");
	    	
	    	printString("Running "+methodsToRun.size()+" Tests");
	        return methodsToRun;
    	}else {
    		//ArrayList<String> dbTests = getTestsNamesFromDB();
    		ArrayList<String> localTests = new ArrayList<>();
    		ArrayList<String> testsToRun = new ArrayList<>();
//    		testsToRun.add("VerifyFundsAvailable_Premium");
    		//testsToRun.add("GoldenCrossover_SignalsDetails");
    		testsToRun.add("InstrumentSell_StopOrder");

    		//testsToRun.add("NewUser_VerifyOTCDetails");
    		//testsToRun.add("NewUser_ETFProvidersSection");
//    		testsToRun.add("Test_BuildNumber");
	    	List<IMethodInstance> methodsToRun = new ArrayList<>();
	    	tests =new ModelTests[testsToRun.size()];
	    	for (IMethodInstance method:methods) {
	    		printString(method.getMethod().getMethodName());
	    		localTests.add(method.getMethod().getMethodName());
		    	if(testsToRun.contains(method.getMethod().getMethodName())) {
		    		methodsToRun.add(method);
		    		methodNamelist.put(method.getMethod().getMethodName(), 0);
		    	}
	    	}
	    	
	    	for(int i=0;i<testsToRun.size();i++) {
	    		ModelTests modelTests = new ModelTests();
	    		modelTests.setTestName(testsToRun.get(i));
	    		tests[i] = modelTests;
	    	}
	    	
	    	//printString("Test Not running: \n"+dbTests.toString()+"\n==================");
	    	printString("Running "+methodsToRun.size()+" Tests");
	    	
	        return methodsToRun;
    	}
    }
    
    public ArrayList<String> getTestsNamesFromDB() {
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
            HttpGet httpget = new HttpGet(api_base_url+"ios/GetTests");
            //Executing the Get request
            HttpResponse httpresponse = client.execute(httpget);
            HttpEntity entity = httpresponse.getEntity();
            String response = EntityUtils.toString(entity);
//            printString("===========================");
//            printString(response);
//            printString("===========================");
            tests = TestsDataConverter.fromJsonString(response);
            ArrayList<String> testsToRun = new ArrayList<>();
            for(ModelTests test: tests) {
//            	System.out.println("Test Name : "+test.getTestName());
//            	System.out.println("Test Run : "+test.getIsExcuted());
            	if(test.getIsExcuted()) {
            		testsToRun.add(test.getTestName());
            	}
            }
            updateAllTestStatus();
            return testsToRun;
    	}catch (Exception e) {
    		System.err.println("////////////////////////////////\nUnable to get Tests from Dashboard: "+e.getStackTrace().toString()+"\n////////////////////////////////");
	 		
			return null;
		}
    }
    

	public static void updateAllTestStatus() {
		for(int i=0;i<TestFilterListener.tests.length;i++) {
			TestFilterListener.tests[i].setExecutionCompleted(false);
		}
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
    		HttpPost httpget = new HttpPost(api_base_url+"ios/UpdateStatus");
    		String json = TestsDataConverter.toJsonString(TestFilterListener.tests);
    		
    		StringEntity requestEntity = new StringEntity(
    				json,
    			    "application/json",
    			    "UTF-8");
    		httpget.setEntity(requestEntity);
            HttpResponse httpresponse = client.execute(httpget);
            HttpEntity entity = httpresponse.getEntity();
            
    	}catch (Exception e) {
    		//e.printStackTrace();
    		System.err.println(e.getMessage()+"\n\n"+e.getStackTrace());
		}
	}
}
