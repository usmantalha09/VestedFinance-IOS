package com.investor.test;

import com.investor.base.BaseClass;
import com.investor.base.BaseClass.Direction;
import com.investor.base.PropertiesReader;

import java.io.File;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.investor.errorCollectors.ErrorCollector;
import com.investor.pages.ExplorePage;
import com.investor.pages.LoginPage;
import com.investor.pages.SignupPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSElement;


public class Test_ViewRecommendedAndWatchlistStocks extends BaseClass{

	
    @Test(priority = 1)
    public void Instruments_View() {

    	initReport();
        initConfiguration();

        ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-21\"><b>QAA-21 : iOS - Verify KYC-approved funded account user is successfully able to login into the platform and view recommended and watchlist stocks/ETFs</b></a>");

        SignupPage signup = new SignupPage();
        LoginPage loginPage = new LoginPage();
        ExplorePage browsePage = new ExplorePage();
        
        Object[][] dataArr = getData(TestDataFileName,TestDataSheetName);
        String email=dataArr[0][1].toString();
        String password=dataArr[0][2].toString();
        String pinCode=dataArr[0][3].toString();
        if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
        

        int step=1;
        ErrorCollector.extentLogInfo("Step "+step+" : Verify Login button displaying.");
        ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(),"Verified Login button displaying");
        step++;
        
        ErrorCollector.extentLogInfo("Step "+step+" : Click on Login button.");
        waitTime(7000);
        loginPage.clickOnLoginButton();
        step++;
        
        ErrorCollector.extentLogInfo("Step "+step+" : Click on Login With Email button.");
        loginPage.clickOnLoginWithEmailButton();
        step++;
        
        ErrorCollector.extentLogInfo("Step "+step+" : Enter email address : "+email);
        signup.enterEmailAddress(email);
        step++;
        
        ErrorCollector.extentLogInfo("Step "+step+" : Enter Password : "+password);
        signup.enterPassword(password);
        step++;
        
        ErrorCollector.extentLogInfo("Step "+step+" : Click on Login button.");
        loginPage.clickOnLoginSubmitButton();
        step++;
        
        ErrorCollector.extentLogInfo("Step "+step+" : Enter Pin Code  : "+pinCode);
        waitTime(3000);
        loginPage.enterPinCode(pinCode);
        step++;

        ErrorCollector.extentLogInfo("Step "+step+" : Verify home page is displaying.");
        ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified home page is displaying.");
        
        ErrorCollector.extentLogInfo("Step "+step+" : Verify Browse button displaying.");
        ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(),"Verified Browse button displaying");
        step++;
        
        ErrorCollector.extentLogInfo("Step "+step+" : Click on Browse button.");
        browsePage.clickOnBrowseButton();
        step++;
        waitTime(3000);
        
     
        ErrorCollector.extentLogInfo("Step "+step+" : Click on Home button.");
        browsePage.clickOnHomeButton();
        step++;
        waitTime(4000);
		scrollToText("WATCHLIST");
		waitTime(2000);
      
        
        ErrorCollector.extentLogInfo("Step "+step+" : Click on WatchList First stock");
        waitTime(500);
        browsePage.clickOnWatchListStock();
        step++;
        
        ErrorCollector.extentLogInfo("Step "+step+" : Click on OVERVIEW Tab");
        browsePage.clickOnOverviewTab();
        step++;
        
        ErrorCollector.extentLogInfo("Step "+step+" : Verify OVERVIEW Tab Detail is displaying.");
        ErrorCollector.verifyTrue(browsePage.verifyOverviewTabDetailsIsDisplaying(),"Verified OVERVIEW Tab Detail is displaying");
        step++;
        
        ErrorCollector.extentLogInfo("Step "+step+" : Click on RETURNS Tab");
        browsePage.clickOnReturnsTab();
        step++;
        
        ErrorCollector.extentLogInfo("Step "+step+" : Verify RETURNS Tab Detail is displaying.");
        ErrorCollector.verifyTrue(browsePage.verifyReturnsTabDetailsIsDisplaying(),"Verified RETURNS Tab Detail is displaying");
        step++;
        
        try {
        	browsePage.clickOnFundamentalDataTab();
        	ErrorCollector.extentLogInfo("Step "+step+" : Click on FUNDAMENTAL DATA Tab");
            
            step++;
            
            ErrorCollector.extentLogInfo("Step "+step+" : Verify FUNDAMENTAL DATA Tab Detail is displaying.");
            ErrorCollector.verifyTrue(browsePage.verifyFundamentalDataTabDetailsIsDisplaying(),"Verified FUNDAMENTAL DATA Tab Detail is displaying");
            step++;
            
            ErrorCollector.extentLogInfo("Step "+step+" : Click on KEY RATIOS Tab");
            browsePage.clickOnKeyRatiosTab();
            step++;
            
            ErrorCollector.extentLogInfo("Step "+step+" : Verify KEY RATIO Tab Detail is displaying.");
            ErrorCollector.verifyTrue(browsePage.verifyKeyRatiosTabDetailsIsDisplaying(),"Verified KEY RATIO Tab Detail is displaying");
            step++;

		} catch (Exception e) {
			
		}        
        
        ErrorCollector.extentLogInfo("Step "+step+" : Verify WatchList button is displaying.");
        ErrorCollector.verifyTrue(browsePage.verifyWatchListButtonIsDisplaying(),"Verified WatchList button is displaying");
        step++;
        
        ErrorCollector.extentLogInfo("Step "+step+" : Click on BUY button");
        browsePage.clickOnBUYTab();
        step++;
        
        ErrorCollector.extentLogInfo("Step "+step+" : Verify Fund Account Page is displaying.");
        ErrorCollector.verifyTrue(browsePage.verifyFundAccountPageIsDisplaying(),"Verified Fund Account Page is displaying");
        step++;
        
    }

}
