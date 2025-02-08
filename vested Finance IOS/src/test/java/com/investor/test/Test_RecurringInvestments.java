package com.investor.test;

import java.text.ParseException;
import java.util.ArrayList;

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
import com.investor.utilities.Waits;

public class Test_RecurringInvestments extends BaseClass {
	
	@Test()
	public void RecurringInvestments_ThemeBasedVests() throws ParseException {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-83\">[iOS] Create Recurring Investment from Theme based Vests<a/>");

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
		String invalidinvestAmount = "9";
		String validinvestAmount = "10";

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
		mobileScrollScreenIOS(Direction.DOWN);
		mobileScrollScreenIOS(Direction.DOWN);
		scrollToText("THEME-BASED VESTS");
		waitTime(3000);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on First Theme Based Vest.");
		kYCUserPurchaseStockPage.clickOnFirstThemeBasedVest();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Create Recurring Investment button.");
		kYCUserPurchaseStockPage.clickOnCreateRecurringInvestmentButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Start Recurring Investment button in popup.");
		kYCUserPurchaseStockPage.clickOnStartRecurringInvestmentButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter investment amount: "+invalidinvestAmount);
		kYCUserPurchaseStockPage.enterInvestmentAmount(invalidinvestAmount);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify error message 'Please enter a value greater than or equal to $10.00.' is displaying.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyInvestmenteAmountIsLessThanTheMinValue(),"Verified error message 'Please enter a value greater than or equal to $10.000000.' is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get total buying power.");
		Double totalBuyingPower = kYCUserPurchaseStockPage.getTotalBuyingPower();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Add 15 in total buying power.");
		totalBuyingPower+=15.0;
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter investment amount: "+totalBuyingPower);
		kYCUserPurchaseStockPage.enterInvestmentAmount(totalBuyingPower.toString());
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify start date is ahead to the next three working days");
		String getDateThreeDaysAheadOfCurrent = kYCUserPurchaseStockPage.getDateThreeDaysAhead();
		ArrayList<String> dateList = new ArrayList<String>();
		dateList = getDateList(14, "d MMM, yyyy", "US/Eastern");
		ErrorCollector.verifyTrue(dateList.contains(getDateThreeDaysAheadOfCurrent),"Verified start date is ahead to the next three working days");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter investment amount: "+validinvestAmount);
		kYCUserPurchaseStockPage.enterInvestmentAmount(validinvestAmount);
		getDateThreeDaysAheadOfCurrent = kYCUserPurchaseStockPage.getDateThreeDaysAhead();
		String formattedDate = getDateWithTargetFormat(getDateThreeDaysAheadOfCurrent,"d MMM, yyyy", "US/Eastern","EEEE, d MMM, yyyy");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify frequency dropdown is enabled.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyFrequencyDropdownIsEnabled(),"Verified frequency dropdown is enabled.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on FAQ's button.");
		kYCUserPurchaseStockPage.clickOnFAQButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) +" : FAQ's are displaying.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyFAQIsDisplaying(),"Verified FAQ's are displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on close FAQ's button.");
		kYCUserPurchaseStockPage.clickOnCloseFAQButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Preview Recurring Investment button.");
		kYCUserPurchaseStockPage.clickOnPreviewRecurringInvestmentButton();
	
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Investement amount at preview order page.");
		ErrorCollector.verifyEquals(kYCUserPurchaseStockPage.getInvestmentAmountAtPreviewReccInvestment(),validinvestAmount);
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Starting Date at preview order.");
		ErrorCollector.verifyEquals(kYCUserPurchaseStockPage.getStartingDateAtPreviewReccInvestment(),formattedDate);

		if(isPreProdEnv) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Start Recurring Investment button.");
			kYCUserPurchaseStockPage.clickOnStartReccInvestmentButton();
			
			ErrorCollector.extentLogInfo("Step " + (++step) +" : Verify Recurring Investment scheduled success message is displaying.");
			ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyRecurringInvestmentSuccessMessageIsDisplaying(),"Verified Recurring Investment scheduled success message is displaying.");
		}
	}

	
	@Test()
	public void RecurringInvestments_MultiAssetClassVests() throws ParseException {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-81\">[iOS] Create Recurring Investment from 'Multi-Asset Class Vests' menu in the Dashboard<a/>");

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
		String invalidinvestAmount = "9";
		String validinvestAmount = "10";

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
		mobileScrollScreenIOS(Direction.DOWN);
		scrollToText("MULTI-ASSET CLASS VESTS");
		waitTime(3000);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on First Multi-Asset Class Vest.");
		kYCUserPurchaseStockPage.clickOnMultiAssetClassVestAtIndex(0);

//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Create Recurring Investment button.");
//		kYCUserPurchaseStockPage.clickOnCreateMultiAssetClassRecurringInvestmentButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Start Recurring Investment button in popup.");
//		kYCUserPurchaseStockPage.clickOnStartRecurringInvestmentButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter investment amount: "+invalidinvestAmount);
//		kYCUserPurchaseStockPage.enterInvestmentAmount(invalidinvestAmount);
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify error message 'Please enter a value greater than or equal to $10.000000.' is displaying.");
//		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyInvestmenteAmountIsLessThanTheMinValue(),"Verified error message 'Please enter a value greater than or equal to $10.000000.' is displaying.");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get total buying power.");
//		Double totalBuyingPower = kYCUserPurchaseStockPage.getTotalBuyingPower();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Add 15 in total buying power.");
//		totalBuyingPower+=15.0;
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter investment amount: "+totalBuyingPower);
//		kYCUserPurchaseStockPage.enterInvestmentAmount(totalBuyingPower.toString());
//
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify start date is ahead to the next three working days");
//		String getDateThreeDaysAheadOfCurrent = kYCUserPurchaseStockPage.getDateThreeDaysAhead();
//		ArrayList<String> dateList = new ArrayList<String>();
//		dateList = getDateList(14, "d MMM, yyyy", "US/Eastern");
//		ErrorCollector.verifyTrue(dateList.contains(getDateThreeDaysAheadOfCurrent),"Verified start date is ahead to the next three working days");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter investment amount: "+validinvestAmount);
//		kYCUserPurchaseStockPage.enterInvestmentAmount(validinvestAmount);
//		getDateThreeDaysAheadOfCurrent = kYCUserPurchaseStockPage.getDateThreeDaysAhead();
//		String formattedDate = getDateWithTargetFormat(getDateThreeDaysAheadOfCurrent,"d MMM, yyyy", "US/Eastern","EEEE, d MMM, yyyy");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify frequency dropdown is enabled.");
//		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyFrequencyDropdownIsEnabled(),"Verified frequency dropdown is enabled.");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on FAQ's button.");
//		kYCUserPurchaseStockPage.clickOnFAQButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) +" : FAQ's are displaying.");
//		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyFAQIsDisplaying(),"Verified FAQ's are displaying.");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on close FAQ's button.");
//		kYCUserPurchaseStockPage.clickOnCloseFAQButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Preview Recurring Investment button.");
//		kYCUserPurchaseStockPage.clickOnPreviewRecurringInvestmentButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Investement amount at preview order page.");
//		ErrorCollector.verifyEquals(kYCUserPurchaseStockPage.getInvestmentAmountAtPreviewReccInvestment(),validinvestAmount);
//
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Starting Date at preview order.");
//		ErrorCollector.verifyEquals(kYCUserPurchaseStockPage.getStartingDateAtPreviewReccInvestment(),formattedDate);
//
//		if(isPreProdEnv) {
//			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Start Recurring Investment button.");
//			kYCUserPurchaseStockPage.clickOnStartReccInvestmentButton();
//
//			ErrorCollector.extentLogInfo("Step " + (++step) +" : Verify Recurring Investment scheduled success message is displaying.");
//			ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyRecurringInvestmentSuccessMessageIsDisplaying(),"Verified Recurring Investment scheduled success message is displaying.");
//		}

		
	}
}
