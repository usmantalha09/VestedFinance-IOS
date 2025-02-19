package com.investor.listeners;

import java.util.Iterator;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.investor.base.BaseClass;

public class MyTestListenerAdapter extends TestListenerAdapter {

    @Override
    public void onFinish(ITestContext context) {
        Iterator<ITestResult> skippedTestCases = context.getSkippedTests().getAllResults().iterator();
        while (skippedTestCases.hasNext()) {
            ITestResult skippedTestCase = skippedTestCases.next();
            ITestNGMethod method = skippedTestCase.getMethod();
            if (context.getSkippedTests().getResults(method).size() > 0) {
            	if (BaseClass.methodNamelist.get(method.getMethodName())<RetryAnalyzer.maxRetryCnt) {
            		 System.out.println("Removing:" + skippedTestCase.getMethod().getMethodName().toString());
                     skippedTestCases.remove();
            	}
            }
        }
    }
}