package com.investor.listeners;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.investor.base.BaseClass;

public class RetryAnalyzer implements IRetryAnalyzer {
    public static int retryCnt = 0;
    public static int maxRetryCnt = 0;
    
    //This method will be called everytime a test fails. It will return TRUE if a test fails and need to be retried, else it returns FALSE
    public boolean retry(ITestResult result) {
//        if (retryCnt < maxRetryCnt) {
//            System.out.println("Retrying " + result.getName() + " again and the count is " + (retryCnt+1));
//            retryCnt++;
//            return true;
//        }else {
//			maxRetryCnt=0;
//		}
    	if (BaseClass.methodNamelist.get(result.getName()) < maxRetryCnt) {
            System.out.println("Retrying " + result.getName() + " again and the count is " + (BaseClass.methodNamelist.get(result.getName()) +1));
            BaseClass.methodNamelist.put(result.getName(), BaseClass.methodNamelist.get(result.getName()) +1);
            return true;
        }
        return false;
    }
   
}