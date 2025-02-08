package com.investor.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.investor.base.BaseClass;
import com.investor.base.BaseClass.Direction;
import com.investor.base.PropertiesReader;
import com.investor.errorCollectors.ErrorCollector;
import com.investor.pages.DIYVestPage;
import com.investor.pages.ExplorePage;
import com.investor.pages.KYCUserPurchaseStockPage;
import com.investor.pages.LoginPage;
import com.investor.pages.SignupPage;

public class Test_KYCUser_BuySell extends BaseClass {
	
	@Test
	public void VerifyUserBuyStockForMarketOrder() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-785\">QAA-785 : [iOS] - Verify that user is buy Instrument/stock for market order<a/>");

		LoginPage loginPage = new LoginPage();
		KYCUserPurchaseStockPage kYCUserPurchaseStockPage = new KYCUserPurchaseStockPage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();		
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}

		String shareValue = "1";
		String amount="50";

		int step = 0;
		step = loginPage.loginToApplication(step, email,password,pinCode);
		waitTime(4000);
		scrollToText("WATCHLIST");
		waitTime(3000);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on WatchList First Stock.");
		kYCUserPurchaseStockPage.clickOnFirstInstrument();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Buy button");
		kYCUserPurchaseStockPage.clickOnBuyButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Share Value : " + shareValue);
		kYCUserPurchaseStockPage.enterShareValue(shareValue);
		waitTime(1000);
		//driver.hideKeyboard();
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify estimated cost field is auto-populated.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyAmountValueIsAutoPopulated(),
				"Verified estimated cost field is auto-populated.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter amount value: "+amount);
		kYCUserPurchaseStockPage.estimatedAmountValue(amount);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnPreviewOrderButton();
		waitTime(3000);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Order Preview Page Title' displaying");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyOrderPreviewTitleIsDisplaying(),
				"Verified 'Order Preview Page Title' is displaying");
		
		if(isPreProdEnv) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Place Buy Order' button");
			kYCUserPurchaseStockPage.clickOnPlaceBuyOrderButton();
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Order Was Placed Successfully Page' displaying");
			ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyorderWasPlacedSuccessfullyPageTitleIsDisplaying(),
					"Verified 'Order Was Placed Successfully Page' is displaying");
		}

	}
	
	
	@Test(groups = "CashRequired")
	public void Instruments_Buy() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-30\">QAA-30 : IOS - Verify KYC-approved funded account user is able to purchase a stock/ETF<a/>");

		LoginPage loginPage = new LoginPage();
		KYCUserPurchaseStockPage kYCUserPurchaseStockPage = new KYCUserPurchaseStockPage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();		
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String shareValue = "1";
		String amount="50";

		int step = 0;
		step = loginPage.loginToApplication(step, email,password,pinCode);
		waitTime(4000);
		scrollToText("WATCHLIST");
		waitTime(3000);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on WatchList First Stock.");
		kYCUserPurchaseStockPage.clickOnFirstInstrument();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Buy button");
		kYCUserPurchaseStockPage.clickOnBuyButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Share Value : " + shareValue);
		kYCUserPurchaseStockPage.enterShareValue(shareValue);
		waitTime(1000);
		//driver.hideKeyboard();
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify estimated cost field is auto-populated.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyAmountValueIsAutoPopulated(),
				"Verified estimated cost field is auto-populated.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter amount value: "+amount);
		kYCUserPurchaseStockPage.estimatedAmountValue(amount);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnPreviewOrderButton();
		waitTime(3000);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Order Preview Page Title' displaying");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyOrderPreviewTitleIsDisplaying(),
				"Verified 'Order Preview Page Title' is displaying");
		if(isPreProdEnv) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Place Buy Order' button");
			kYCUserPurchaseStockPage.clickOnPlaceBuyOrderButton();
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Order Was Placed Successfully Page' displaying");
			ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyorderWasPlacedSuccessfullyPageTitleIsDisplaying(),
					"Verified 'Order Was Placed Successfully Page' is displaying");
		}

	}

	@Test
	public void Negative_InstrumentBuy() {
    	initReport();
        initConfiguration();

        ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-103\"><b>QAA-103 : [Negative IOS buy]- Instrument Buy Scenario.</b></a>");

        SignupPage signup = new SignupPage();
        LoginPage loginPage = new LoginPage();
        ExplorePage browsePage = new ExplorePage();
        KYCUserPurchaseStockPage kycUserPurchaseStockPage = new KYCUserPurchaseStockPage();
        
        Object[][] dataArr = getData(TestDataFileName,TestDataSheetName);
        String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();		
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
        String InvalidshareValue = "0.00000001";
        String fractionalShareValue = "1.001";
        

        int step=0;
        step = loginPage.loginToApplication(step, email,password,pinCode);
        
        ErrorCollector.extentLogInfo("Step "+step+" : Verify Browse button displaying.");
        ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(),"Verified Browse button displaying");
        step++;
        
        ErrorCollector.extentLogInfo("Step "+step+" : Click on Browse button.");
        browsePage.clickOnBrowseButton();
        step++;
        
//        ErrorCollector.extentLogInfo("Step "+step+" : Verify Recommended section is displaying.");
//        ErrorCollector.verifyTrue(browsePage.verifyRecommendedLabelIsDisplaying(),"Verified Recommended section is displaying");
//        step++;
        
        ErrorCollector.extentLogInfo("Step "+step+" : Click on Home button.");
        browsePage.clickOnHomeButton();
        step++;
        waitTime(4000);
		scrollToText("WATCHLIST");
		waitTime(2000);
        
        ErrorCollector.extentLogInfo("Step "+step+" : Verify WatchList section is displaying.");
        ErrorCollector.verifyTrue(browsePage.verifyWatchListLabelIsDisplaying(),"Verified WatchList section is displaying");
        step++;
        
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
        
        ErrorCollector.extentLogInfo("Step "+step+" : Verify instrument buy Page is displaying.");
        ErrorCollector.verifyTrue(browsePage.verifyFundAccountPageIsDisplaying(),"Verified instrument buy Page is displaying");
        step++;
        
        ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Share Value : " + InvalidshareValue);
		kycUserPurchaseStockPage.enterShareValue(InvalidshareValue);
		
		ErrorCollector.extentLogInfo("Step "+step+" : Verify Amount Field value");
		ErrorCollector.verifyEquals(kycUserPurchaseStockPage.getAmountFieldValue(), "0.00");
			
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kycUserPurchaseStockPage.clickOnPreviewOrderButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Error message 'Invalid Cash' is displaying.");
		ErrorCollector.verifyTrue(kycUserPurchaseStockPage.verifyInValidCashErrorMessageDisplaying(),"Verified Error message 'Invalid Cash' is displaying.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Select limit buy order");
		kycUserPurchaseStockPage.selectLimitBuyOrder();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Share Value : " + fractionalShareValue);
		kycUserPurchaseStockPage.enterShareValue(fractionalShareValue);
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kycUserPurchaseStockPage.clickOnPreviewOrderButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify error message 'Fractional shares are not supported for limit orders.' is displaying.");
		ErrorCollector.verifyTrue(kycUserPurchaseStockPage.verifyLimitBuyShareErrorMessage(),
				"Verified error message 'Fractional shares are not supported for limit orders.' is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Select Stop buy order");
		kycUserPurchaseStockPage.selectStopBuyOrder();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get market current market price.");
		double marketPriceString = kycUserPurchaseStockPage.getMarketPriceOnBuySell();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Share Value : " + fractionalShareValue);
		kycUserPurchaseStockPage.enterStopOrderShareValue(fractionalShareValue);
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Stop price : " + marketPriceString);
		kycUserPurchaseStockPage.enterStopPrice(marketPriceString);
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kycUserPurchaseStockPage.clickOnPreviewOrderButton();

        waitTime(3000);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify message 'Low Stop Price' is displaying.");
		ErrorCollector.verifyTrue(kycUserPurchaseStockPage.verifyLowStopPriceErrorMessage(),
				"Verified message 'Low Stop Price' is displaying.");

	}
	
	@Test
 	public void Instrument_Sell() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-33\">QAA-33 : iOS - Verify KYC-approved funded account user is able to sell a stock/ETF that they own<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		DIYVestPage diyVestPage = new DIYVestPage();
		KYCUserPurchaseStockPage kYCUserPurchaseStockPage = new KYCUserPurchaseStockPage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();		
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String vestName = "vest user" + randomNumberString(3);
		String Value;
		String shareValue = "1";

		int step = 0;
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(), "Verified Login button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Login' button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Login With Email' button.");
		loginPage.clickOnLoginWithEmailButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter email address : '" + email+"'");
		signup.enterEmailAddress(email);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Password : '" + password+"'");
		signup.enterPassword(password);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Login' button.");
		loginPage.clickOnLoginSubmitButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Pin Code  : '" + pinCode+"'");
		waitTime(3000);
		loginPage.enterPinCode(pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'home page' is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(), "Verified 'home page' is displaying.");
		scrollToText("YOUR PORTFOLIO");
		waitTime(3000);
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Your portfolio first stock.");
		kYCUserPurchaseStockPage.clickOnYourPortfolioFirstStock();

		try {
			kYCUserPurchaseStockPage.clickOnOkButtonInDialog();
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Ok' button in dialogue");
			kYCUserPurchaseStockPage.clickOnYourPortfolioFirstStockWithOutShowALl();
		}catch (Exception e){

		}
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Sell' button");
		kYCUserPurchaseStockPage.clickOnSellButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Share Value : '" + shareValue+"'");
		kYCUserPurchaseStockPage.enterShareValue(shareValue);
		//driver.hideKeyboard();
		waitTime(3000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify estimated cost field is auto-populated.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyAmountValueIsAutoPopulated(),
				"Verified estimated cost field is auto-populated.");
		//Step to add
		// verify the amount field is auto-populated.(market price xapth is not visible)

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnPreviewOrderButton();
		waitTime(5000);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Order Preview Page Title' displaying");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyOrderPreviewTitleIsDisplaying(),
				"Verified 'Order Preview Page Title' is displaying");
		if(isPreProdEnv) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Place Sell Order' button");
			kYCUserPurchaseStockPage.clickOnPlaceSellOrderButton();
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Order Was Placed Successfully Page' displaying");
			ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyorderWasPlacedSuccessfullyPageTitleIsDisplaying(),
					"Verified 'Order Was Placed Successfully Page' is displaying");
		}
	}

	
	 @Test(groups = "CashRequired")
	public void InstrumentBuy_LimitOrder() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-583\">QAA-583 : IOS - Verify user is able to place various combination of limit buy order<a/>");
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		KYCUserPurchaseStockPage kYCUserPurchaseStockPage = new KYCUserPurchaseStockPage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();		
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String fractionalShareValue = "1.001";
		String nonFractionalShareValue = "1";

		int step = 0;
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(), "Verified Login button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter email address : " + email);
		signup.enterEmailAddress(email);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Password : " + password);
		signup.enterPassword(password);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Pin Code  : " + pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(), "Verified home page is displaying.");
		waitTime(4000);
		scrollToText("WATCHLIST");
		waitTime(3000);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on WatchList First Stock.");
		kYCUserPurchaseStockPage.clickOnFirstInstrument();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Buy button");
		kYCUserPurchaseStockPage.clickOnBuyButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Select limit buy order");
		kYCUserPurchaseStockPage.selectLimitBuyOrder();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Share Value : " + fractionalShareValue);
		kYCUserPurchaseStockPage.enterShareValue(fractionalShareValue);
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnPreviewOrderButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify error message 'Fractional shares are not supported for limit orders.' is displaying.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyLimitBuyShareErrorMessage(),
				"Verified error message 'Fractional shares are not supported for limit orders.' is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Share Value : " + nonFractionalShareValue);
		kYCUserPurchaseStockPage.enterShareValue(nonFractionalShareValue);
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get market current market price.");
		double marketPriceString = kYCUserPurchaseStockPage.getMarketPriceOnBuySell();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter limit price : " + marketPriceString);
		kYCUserPurchaseStockPage.enterLimitPrice(marketPriceString+"");
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnPreviewOrderButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Order Preview Page Title' displaying");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyOrderPreviewTitleIsDisplaying(),
				"Verified 'Order Preview Page Title' is displaying");
		if(isPreProdEnv) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Place Buy Order' button");
			kYCUserPurchaseStockPage.clickOnPlaceBuyOrderButton();
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Order Was Placed Successfully Page' displaying");
			ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyorderWasPlacedSuccessfullyPageTitleIsDisplaying(),
					"Verified 'Order Was Placed Successfully Page' is displaying");
		}

	}

	
	@Test
	public void InstrumentSell_LimitOrder() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-583\">QAA-583 : IOS - Verify user is able to place various combination of limit buy order<a/>");
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		KYCUserPurchaseStockPage kYCUserPurchaseStockPage = new KYCUserPurchaseStockPage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();		
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String fractionalShareValue = "1.001";
		String nonFractionalShareValue = "1";

		int step = 0;
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(), "Verified Login button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter email address : " + email);
		signup.enterEmailAddress(email);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Password : " + password);
		signup.enterPassword(password);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Pin Code  : " + pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(), "Verified home page is displaying.");
		waitTime(4000);
		scrollToText("YOUR PORTFOLIO");
		waitTime(3000);
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Your portfolio first stock.");
		kYCUserPurchaseStockPage.clickOnYourPortfolioFirstStock();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Sell' button");
		kYCUserPurchaseStockPage.clickOnSellButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Select limit buy order");
		kYCUserPurchaseStockPage.selectLimitBuyOrder();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Share Value : " + fractionalShareValue);
		kYCUserPurchaseStockPage.enterShareValue(fractionalShareValue);
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnPreviewOrderButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify error message 'Fractional shares are not supported for limit orders.' is displaying.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyLimitBuyShareErrorMessage(),
				"Verified error message 'Fractional shares are not supported for limit orders.' is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Share Value : " + nonFractionalShareValue);
		kYCUserPurchaseStockPage.enterShareValue(nonFractionalShareValue);
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get market current market price.");
		double marketPriceString = kYCUserPurchaseStockPage.getMarketPriceOnBuySell();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter limit price : " + marketPriceString);
		kYCUserPurchaseStockPage.enterLimitPrice(marketPriceString+"");
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnPreviewOrderButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Order Preview Page Title' displaying");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyOrderPreviewTitleIsDisplaying(),
				"Verified 'Order Preview Page Title' is displaying");
		if(isPreProdEnv) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Place Sell Order' button");
			kYCUserPurchaseStockPage.clickOnPlaceSellOrderButton();
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Order Was Placed Successfully Page' displaying");
			ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyorderWasPlacedSuccessfullyPageTitleIsDisplaying(),
					"Verified 'Order Was Placed Successfully Page' is displaying");
		}
	}

	
	@Test(groups = "CashRequired")
	public void InstrumentBuy_StopOrder() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-593\">QAA-593 : IOS - Verify user is able to place various combination of stop buy order</a>");
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		KYCUserPurchaseStockPage kYCUserPurchaseStockPage = new KYCUserPurchaseStockPage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();		
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String fractionalShareValue = "1.001";
		String nonFractionalShareValue = "1";

		int step = 0;
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(), "Verified Login button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter email address : " + email);
		signup.enterEmailAddress(email);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Password : " + password);
		signup.enterPassword(password);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Pin Code  : " + pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(), "Verified home page is displaying.");
		waitTime(4000);
		scrollToText("WATCHLIST");
		waitTime(3000);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on WatchList First Stock.");
		kYCUserPurchaseStockPage.clickOnFirstInstrument();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Buy button");
		kYCUserPurchaseStockPage.clickOnBuyButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Select Stop buy order");
		kYCUserPurchaseStockPage.selectStopBuyOrder();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get market current market price.");
		double marketPriceString = kYCUserPurchaseStockPage.getMarketPriceOnBuySell();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Share Value : " + fractionalShareValue);
		kYCUserPurchaseStockPage.enterStopOrderShareValue(fractionalShareValue);
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Stop price : " + marketPriceString);
		kYCUserPurchaseStockPage.enterStopPrice(marketPriceString);
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnPreviewOrderButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify message 'Low Stop Price' is displaying.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyLowStopPriceErrorMessage(),
				"Verified message 'Low Stop Price' is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Close' dialog button");
		kYCUserPurchaseStockPage.clickOnCloseLowStopPriceButton();
		
		waitTime(1000);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Share Value : " + nonFractionalShareValue);
		kYCUserPurchaseStockPage.enterStopOrderShareValue(nonFractionalShareValue);
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Stop price : " + marketPriceString);
		kYCUserPurchaseStockPage.enterStopPrice(marketPriceString);
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnPreviewOrderButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify message 'Low Stop Price' is displaying.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyLowStopPriceErrorMessage(),
				"Verified message 'Low Stop Price' is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Close' dialog button");
		kYCUserPurchaseStockPage.clickOnCloseLowStopPriceButton();
		
		waitTime(1000);
		marketPriceString+=1.0;
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Stop price : " + marketPriceString);
		kYCUserPurchaseStockPage.enterStopPrice(marketPriceString);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnPreviewOrderButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Order Preview Page Title' displaying");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyOrderPreviewTitleIsDisplaying(),
				"Verified 'Order Preview Page Title' is displaying");
		if(isPreProdEnv) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Place Buy Order' button");
			kYCUserPurchaseStockPage.clickOnPlaceBuyOrderButton();
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Order Was Placed Successfully Page' displaying");
			ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyorderWasPlacedSuccessfullyPageTitleIsDisplaying(),
					"Verified 'Order Was Placed Successfully Page' is displaying");
		}
	}
	
	
	@Test
	public void InstrumentSell_StopOrder() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-601\">QAA-601 : IOS - Verify user is able to place various combination of stop sell order</a>");
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		KYCUserPurchaseStockPage kYCUserPurchaseStockPage = new KYCUserPurchaseStockPage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();		
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String fractionalShareValue = "0.1";
		String nonFractionalShareValue = "1";

		int step = 0;
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(), "Verified Login button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter email address : " + email);
		signup.enterEmailAddress(email);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Password : " + password);
		signup.enterPassword(password);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Pin Code  : " + pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(), "Verified home page is displaying.");
		waitTime(4000);

		
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Your portfolio first stock.");
		kYCUserPurchaseStockPage.clickOnYourPortfolioFirstStock();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Sell' button");
		kYCUserPurchaseStockPage.clickOnSellButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Select Stop buy order");
		kYCUserPurchaseStockPage.selectStopBuyOrder();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get market current market price.");
		double marketPriceString = kYCUserPurchaseStockPage.getMarketPriceOnBuySell();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Share Value : " + fractionalShareValue);
		kYCUserPurchaseStockPage.enterStopOrderShareValue(fractionalShareValue);
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Stop price : " + marketPriceString);
		kYCUserPurchaseStockPage.enterStopPrice(marketPriceString);
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnPreviewOrderButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify message 'High Stop Price' is displaying.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyHighStopPriceErrorMessage(),
				"Verified message 'High Stop Price' is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Close' dialog button");
		kYCUserPurchaseStockPage.clickOnCloseLowStopPriceButton();
		
		waitTime(1000);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Share Value : " + nonFractionalShareValue);
		kYCUserPurchaseStockPage.enterStopOrderShareValue(nonFractionalShareValue);
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Stop price : " + marketPriceString);
		kYCUserPurchaseStockPage.enterStopPrice(marketPriceString);
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnPreviewOrderButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify message 'High Stop Price' is displaying.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyHighStopPriceErrorMessage(),
				"Verified message 'High Stop Price' is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Close' dialog button");
		kYCUserPurchaseStockPage.clickOnCloseLowStopPriceButton();
		
		waitTime(1000);
		marketPriceString-=1.0;
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Stop price : " + marketPriceString);
		kYCUserPurchaseStockPage.enterStopPrice(marketPriceString);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnPreviewOrderButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Order Preview Page Title' displaying");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyOrderPreviewTitleIsDisplaying(),
				"Verified 'Order Preview Page Title' is displaying");
		
		if(isPreProdEnv) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Place Sell Order' button");
			kYCUserPurchaseStockPage.clickOnPlaceSellOrderButton();
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Order Was Placed Successfully Page' displaying");
			ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyorderWasPlacedSuccessfullyPageTitleIsDisplaying(),
					"Verified 'Order Was Placed Successfully Page' is displaying");
		}
	}


	@Test
	public void Cancel_PendingOrders() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-273\">QAA-273 : IOS - Cancel orders under 'Pending Orders'<a/>");

		LoginPage loginPage = new LoginPage();
		KYCUserPurchaseStockPage kYCUserPurchaseStockPage = new KYCUserPurchaseStockPage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();		
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String shareValue = "1";
		String amount="50";

		int step = 0;
		step = loginPage.loginToApplication(step, email,password,pinCode);
		waitTime(7000);
		scrollToText("YOUR PORTFOLIO");
		waitTime(3000);
		
		if(kYCUserPurchaseStockPage.isPendingOrdersPresent()) {
			scrollToText("PENDING ORDERS");
			waitTime(3000);
			ErrorCollector.extentLogInfo("Step "+(++step)+" : Get all Pending orders.");
			List<WebElement> ordersList = kYCUserPurchaseStockPage.getAllStocksList();
			for (int i = 1; i < ordersList.size(); i++) {
				ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Cancel Order button for stock: "+kYCUserPurchaseStockPage.getPendingOrderStockSymbolAt(1));
				kYCUserPurchaseStockPage.clickOnCancelPendingOrderAt(1);
				
				ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'No' button.");
				kYCUserPurchaseStockPage.clickOnNoPendingOrderCancelDialog();
				
				ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Cancel Order button for stock: "+kYCUserPurchaseStockPage.getPendingOrderStockSymbolAt(1));
				kYCUserPurchaseStockPage.clickOnCancelPendingOrderAt(1);
				
				ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Yes' button.");
				kYCUserPurchaseStockPage.clickOnYesPendingOrderCancelDialog();
			}
			
		}else {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : There is no pending order available.");
		}
	}
	

	@Test
	public void VerifyUserIsAbleToPlaceVariousCombinationOfMarketbuyOrder() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-36\">QAA-36 : iOS - Verify user is able to place various combination of market buy order</a>");

		LoginPage loginPage = new LoginPage();
		KYCUserPurchaseStockPage kYCUserPurchaseStockPage = new KYCUserPurchaseStockPage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();		
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String shareValue = "1";
		String amount="50";
		String fractionalShareValue = "1.001";

		int step = 0;
		step = loginPage.loginToApplication(step, email,password,pinCode);
		waitTime(7000);
		scrollToText("YOUR PORTFOLIO");
		waitTime(3000);
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on WatchList First Stock.");
		kYCUserPurchaseStockPage.clickOnFirstInstrument();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Buy button");
		kYCUserPurchaseStockPage.clickOnBuyButton();


		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Share Value : " + shareValue);
		kYCUserPurchaseStockPage.enterShareValue(shareValue);
		waitTime(1000);
	
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify estimated cost field is auto-populated.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyAmountValueIsAutoPopulated(),
				"Verified estimated cost field is auto-populated.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Fractional Share Value : " + fractionalShareValue);
		kYCUserPurchaseStockPage.enterShareValue(fractionalShareValue);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify estimated cost field is auto-populated.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyAmountValueIsAutoPopulated(),
				"Verified estimated cost field is auto-populated.");
		
		String estimatedCoString = kYCUserPurchaseStockPage.getAmountFieldValue();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnPreviewOrderButton();
		String totalOrderPreviewString = kYCUserPurchaseStockPage.getTotalCostPreviewOrder();
		totalOrderPreviewString=totalOrderPreviewString.replace("$", "");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify estimated cost field is displaying on order preview.");
		ErrorCollector.verifyEquals(estimatedCoString, totalOrderPreviewString);
	
		if(isPreProdEnv) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Place Buy Order' button");
			kYCUserPurchaseStockPage.clickOnPlaceBuyOrderButton();
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Order Was Placed Successfully Page' displaying");
			ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyorderWasPlacedSuccessfullyPageTitleIsDisplaying(),
					"Verified 'Order Was Placed Successfully Page' is displaying");
		}
		
	}
	@Test
	public void SellAllStocks_MarketOrder() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-788\">QAA-788 : [iOS] - Verify that user is able to sell its all shares of Instrument/stock for market order</a>");
		
		LoginPage loginPage = new LoginPage();
		KYCUserPurchaseStockPage kYCUserPurchaseStockPage = new KYCUserPurchaseStockPage();
		
		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();		
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String shareValue = "1";
		String amount="50";
		String fractionalShareValue = "1.001";
		
		int step = 0;
		step = loginPage.loginToApplication(step, email,password,pinCode);
		waitTime(7000);
		scrollToText("YOUR PORTFOLIO");
		waitTime(3000);
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on WatchList First Stock.");
		kYCUserPurchaseStockPage.clickOnFirstInstrument();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Sell button");
		kYCUserPurchaseStockPage.clickOnSellButton();
		
		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Share Value : " + shareValue);
//		kYCUserPurchaseStockPage.enterShareValue(shareValue);
		waitTime(1000);
		
		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify estimated cost field is auto-populated.");
//		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyAmountValueIsAutoPopulated(),
//				"Verified estimated cost field is auto-populated.");
//		
//		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Fractional Share Value : " + fractionalShareValue);
//		kYCUserPurchaseStockPage.enterShareValue(fractionalShareValue);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Sell All check box.");
		kYCUserPurchaseStockPage.clickOnSellAllButton();
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify estimated cost field is auto-populated.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyAmountValueIsAutoPopulated(),
				"Verified estimated cost field is auto-populated.");
		
		String estimatedCoString = kYCUserPurchaseStockPage.getAmountFieldValue();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnPreviewOrderButton();
		String totalOrderPreviewString = kYCUserPurchaseStockPage.getTotalCostPreviewOrder();
		totalOrderPreviewString=totalOrderPreviewString.replace("$", "");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify estimated cost field is displaying on order preview.");
		ErrorCollector.verifyEquals(estimatedCoString, totalOrderPreviewString);
		if(isPreProdEnv) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Place Sell Order' button");
			kYCUserPurchaseStockPage.clickOnPlaceSellOrderButton();
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Order Was Placed Successfully Page' displaying");
			ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyorderWasPlacedSuccessfullyPageTitleIsDisplaying(),
					"Verified 'Order Was Placed Successfully Page' is displaying");
		}
		
	}
	
	@Test
	public void Cancel_PendingVestOrders() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-273\">QAA-273 : IOS - Cancel orders under 'Pending Orders'<a/>");

		LoginPage loginPage = new LoginPage();
		KYCUserPurchaseStockPage kYCUserPurchaseStockPage = new KYCUserPurchaseStockPage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();		
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String shareValue = "1";
		String amount="50";

		int step = 0;
		step = loginPage.loginToApplication(step, email,password,pinCode);
		waitTime(7000);
		scrollToText("YOUR PORTFOLIO");
		waitTime(3000);
		
		if(kYCUserPurchaseStockPage.isPendingOrdersPresent()) {
			scrollToText("PENDING ORDERS");
			waitTime(3000);
			ErrorCollector.extentLogInfo("Step "+(++step)+" : Get all Pending orders.");
			List<WebElement> ordersList = kYCUserPurchaseStockPage.getAllStocksList();
			for (int i = 1; i < ordersList.size(); i++) {
				ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Cancel Order button for stock: "+kYCUserPurchaseStockPage.getPendingOrderStockSymbolAt(1));
				kYCUserPurchaseStockPage.clickOnCancelPendingOrderAt(1);
				
				ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'No' button.");
				kYCUserPurchaseStockPage.clickOnNoPendingOrderCancelDialog();
				
				ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Cancel Order button for stock: "+kYCUserPurchaseStockPage.getPendingOrderStockSymbolAt(1));
				kYCUserPurchaseStockPage.clickOnCancelPendingOrderAt(1);
				
				ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Yes' button.");
				kYCUserPurchaseStockPage.clickOnYesPendingOrderCancelDialog();
			}
			
		}else {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : There is no pending order available.");
		}
	}


}

