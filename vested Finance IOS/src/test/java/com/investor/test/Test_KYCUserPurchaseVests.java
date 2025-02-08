package com.investor.test;

import java.util.List;

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

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.offset.PointOption;

public class Test_KYCUserPurchaseVests extends BaseClass {
	
	@Test(groups = "CashRequired")
	public void VerifyKYCUserPurchaseThemeBasedVests() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-147\">[iOS] Verify KYC-approved funded account user is able to purchase a Vests - Theme based Vests<a/>");

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
		String invalidVestAmount1 = "aaa";
		String invalidVestAmount3 = "@@@";	
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
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Cancel pending vests orders if available.");
		if(kYCUserPurchaseStockPage.isCancelPendingVestsOrderDisplaying()) {
			List<MobileElement> allPendingOrders = kYCUserPurchaseStockPage.getAllPendingVestsOrders();
			for(int i=0;i<allPendingOrders.size();i++){
				String vestName = kYCUserPurchaseStockPage.getPendingVestOrdersVestName(i);
				
				ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on cancel button for vest: "+vestName);
				kYCUserPurchaseStockPage.clickOnCancelButtonForVestOrder(i);

				ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Yes' cancel button");
				kYCUserPurchaseStockPage.clickOnYesCancelButton();
				
				
			}
			waitTime(3000);
		}

		mobileScrollScreenIOS(Direction.DOWN);
		scrollToText("THEME-BASED VESTS");
		waitTime(3000);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on First Theme Based Vest.");
		kYCUserPurchaseStockPage.clickOnFirstThemeBasedVest();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Buy button");
		kYCUserPurchaseStockPage.clickOnVestBuyButton();
		Waits.wait3s();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Name is displaying on table");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyTableHeaderNameOnPreviewOrderTable(),"Verified name is displaying on Buy Vest Pgae table.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Price is displaying on table");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyTableHeaderPriceOnPreviewOrderTable(),"Verified price is displaying on Buy Vest Pgae table.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Weight is displaying on table");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyTableHeaderWeightOnPreviewOrderTable(),"Verified weight is displaying on Buy Vest Pgae table.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Share is displaying on table");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyTableHeaderSharesOnPreviewOrderTable(),"Verified shares is displaying on Buy Vest Pgae table.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify error message 'Investment Amount field' is enabled");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.isThemeBasedBuyVestInvestmentAmountFieldEnabled(),"Verified error message 'Investment Amount field' is enabled");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify error message 'Preview order button' is enabled");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.isThemeBasedBuyVestPreviewOrderButtonEnabled(),"Verified error message 'Preview order button' is enabled");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Preview Order button");
		kYCUserPurchaseStockPage.clickOnPreviewOrderButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify error message 'Investment Amount is required' displaying");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyErrorMessageInvestementAmountIsRequiredIsDisplaying(),"Verified error message 'Investment Amount is required' displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter "+invalidVestAmount1+" in investment amount field");
		kYCUserPurchaseStockPage.enterValueInInvestementInput(invalidVestAmount1);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify error message 'Investment Amount is required' displaying");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyErrorMessageInvestementAmountIsRequiredIsDisplaying(),"Verified error message 'Investment Amount is required' displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter "+invalidVestAmount3+" in investment amount field");
		kYCUserPurchaseStockPage.enterValueInInvestementInput(invalidVestAmount3);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify error message 'Investment Amount is required' displaying");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyErrorMessageInvestementAmountIsRequiredIsDisplaying(),"Verified error message 'Investment Amount is required' displaying");
		
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter investment amount: " + invalidinvestAmount);
		kYCUserPurchaseStockPage.enterInvestAmount(invalidinvestAmount);
		driver.hideKeyboard();
//		waitTime(3000);
//		
//		//Step to add
//		// verify the amount field is auto-populated.(market price xapth is not visible)
//
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnThemeBasedBuyVestPreviewOrderButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify error message 'Please enter a value greater than or equal to $10.00.' displaying");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyErrorMessageInvestementAmountIsLessThan10DollarsIsDisplaying(),"Verified error message 'Please enter a value greater than or equal to $10.00.' displaying");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter investment amount: " + validinvestAmount);
		kYCUserPurchaseStockPage.enterInvestAmount(validinvestAmount);
		driver.hideKeyboard();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnThemeBasedBuyVestPreviewOrderButton();
//		waitTime(5000);
//
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
	
	@Test//(groups = "CashRequired")
	public void VerifyKYCUserPurchaseMultiAssets() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-145\">[iOS] Verify KYC-approved funded account user is able to purchase a Vests - Multi-Assets Class<a/>");

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
		String invalidVestAmount1 = "aaa";
		String invalidVestAmount3 = "@@@";	
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
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Cancel pending vests orders if available.");
		if(kYCUserPurchaseStockPage.isCancelPendingVestsOrderDisplaying()) {
			List<MobileElement> allPendingOrders = kYCUserPurchaseStockPage.getAllPendingVestsOrders();
			for(int i=0;i<allPendingOrders.size();i++){
				String vestName = kYCUserPurchaseStockPage.getPendingVestOrdersVestName(i);
				
				ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on cancel button for vest: "+vestName);
				kYCUserPurchaseStockPage.clickOnCancelButtonForVestOrder(i);

				ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Yes' cancel button");
				kYCUserPurchaseStockPage.clickOnYesCancelButton();
				
				
			}
			waitTime(3000);
		}

		mobileScrollScreenIOS(Direction.DOWN);
		scrollToText("MULTI-ASSET CLASS VESTS");
		waitTime(3000);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Multi Asset Class Vest.");
		kYCUserPurchaseStockPage.clickOnMultiAssetClassVestAtIndex(2);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Buy button");
//		new TouchAction(driver).tap(PointOption.point(194, 791)).perform();
		kYCUserPurchaseStockPage.clickOnVestBuyButton();
		Waits.wait3s();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Name is displaying on table");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyTableHeaderNameOnPreviewOrderTable(),"Verified name is displaying on Buy Vest Page table.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Price is displaying on table");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyTableHeaderPriceOnPreviewOrderTable(),"Verified price is displaying on Buy Vest Page table.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Weight is displaying on table");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyTableHeaderWeightOnPreviewOrderTable(),"Verified weight is displaying on Buy Vest Page table.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Share is displaying on table");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyTableHeaderSharesOnPreviewOrderTable(),"Verified shares is displaying on Buy Vest Page table.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify error message 'Investment Amount field' is enabled");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.isThemeBasedBuyVestInvestmentAmountFieldEnabled(),"Verified error message 'Investment Amount field' is enabled");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify error message 'Preview order button' is enabled");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.isThemeBasedBuyVestPreviewOrderButtonEnabled(),"Verified error message 'Preview order button' is enabled");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Preview Order button");
		kYCUserPurchaseStockPage.clickOnPreviewOrderButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify error message 'Investment Amount is required' displaying");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyErrorMessageInvestementAmountIsRequiredIsDisplaying(),"Verified error message 'Investment Amount is required' displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter "+invalidVestAmount1+" in investment amount field");
		kYCUserPurchaseStockPage.enterValueInInvestementInput(invalidVestAmount1);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify error message 'Investment Amount is required' displaying");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyErrorMessageInvestementAmountIsRequiredIsDisplaying(),"Verified error message 'Investment Amount is required' displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter "+invalidVestAmount3+" in investment amount field");
		kYCUserPurchaseStockPage.enterValueInInvestementInput(invalidVestAmount3);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify error message 'Investment Amount is required' displaying");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyErrorMessageInvestementAmountIsRequiredIsDisplaying(),"Verified error message 'Investment Amount is required' displaying");
		
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter investment amount: " + invalidinvestAmount);
		kYCUserPurchaseStockPage.enterInvestAmount(invalidinvestAmount);
		driver.hideKeyboard();
//		waitTime(3000);
//		
//		//Step to add
//		// verify the amount field is auto-populated.(market price xapth is not visible)
//
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnThemeBasedBuyVestPreviewOrderButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify error message 'Please enter a value greater than or equal to $10.00.' displaying");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyErrorMessageInvestementAmountIsLessThan10DollarsIsDisplaying(),"Verified error message 'Please enter a value greater than or equal to $10.00.' displaying");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter investment amount: " + validinvestAmount);
		kYCUserPurchaseStockPage.enterInvestAmount(validinvestAmount);
		driver.hideKeyboard();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Preview Order' button");
		kYCUserPurchaseStockPage.clickOnThemeBasedBuyVestPreviewOrderButton();
//		waitTime(5000);
//
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

}
