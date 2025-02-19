package com.investor.test;

import com.investor.base.BaseClass;
import com.investor.base.BaseClass.Direction;
import com.investor.base.PropertiesReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.investor.errorCollectors.ErrorCollector;
import com.investor.listeners.ExtentListeners;
import com.investor.pages.ExplorePage;
import com.investor.pages.FundTransferPage;
import com.investor.pages.LoginPage;
import com.investor.pages.SignupPage;

public class Test_Explore extends BaseClass {

	@Test(priority = 1)
	public void MonkeyTest_ClickAllTabs() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-54\">QAA-54 : iOS - Verify user is able to access all tabs on navigation menu after logging in<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}

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

		ExtentListeners.attachScreenShot("Home Page Screenshot");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");

		ExtentListeners.attachScreenShot("Browse Page Screenshot");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Transfer Menu button.");
		browsePage.clickOnTransferMenuButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Transfer Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyTransferPageIsDisplaying(), "Verified Transfer Page is displaying");

		ExtentListeners.attachScreenShot("Transfer Page Screenshot");

//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Direct Menu button.");
//		waitTime(3000);
//		browsePage.clickOnDirectMenuButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Direct Page is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifyDirectPageIsDisplaying(), "Verified Direct Page is displaying");
//
//		ExtentListeners.attachScreenShot("Direct Page Screenshot");

		waitTime(20000);
        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on DIY Vest Menu button.");
        browsePage.clickOnDIYVestMenuButton();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify DIY Vest Page is displaying.");
        ErrorCollector.verifyTrue(browsePage.verifyDIYVestPageIsDisplaying(),"Verified DIY Vest Page is displaying");
        ExtentListeners.attachScreenShot("DIY Vest Page Screenshot");

        waitTime(15000);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Home Menu button.");
        browsePage.clickOnHomeButton();
		waitTime(1000);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Profile Menu button.");
		browsePage.clickOnProfileMenuButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Profile Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyProfilePageIsDisplaying(), "Verified Profile Page is displaying");
		ExtentListeners.attachScreenShot("Profile Page Screenshot");

	}

	@Test(priority = 5)
	public void MonkeyTest_ProfileTab() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-148\">QAA-148 : iOS - Monkey Test Profile Tab<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData("testData", "TestData");
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}


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

		// Need to add static id for the profile menu element
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Profile Menu button.");
		browsePage.clickOnProfileMenuButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Profile Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyProfilePageIsDisplaying(), "Verified Profile Page is displaying");
		ExtentListeners.attachScreenShot("Profile Page Screenshot");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Transactions button.");
		browsePage.clickOnProfileTransactionButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Transactions Page is displaying.");
		waitTime(5000);
		ErrorCollector.verifyTrue(browsePage.verifyTransactionHeadingIsDisplaying(),
				"Verified Transactions Page is displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Back button.");
		pressBack();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Trade Confirmation button.");
		browsePage.clickOnProfileTradeConfirmationButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Trade Confirmation Page is displaying.");
		waitTime(5000);
		ErrorCollector.verifyTrue(browsePage.verifyTradeConfirmationHeadingIsDisplaying(),
				"Verified Trade Confirmation Page is displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Back button.");
		pressBack();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Account Statements button.");
		browsePage.clickOnProfileAccountStatementsButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Account Statements Page is displaying.");
		waitTime(5000);
		ErrorCollector.verifyTrue(browsePage.verifyAccountStatementsHeadingIsDisplaying(),
				"Verified Account Statements Page is displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Back button.");
		pressBack();

//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Tax Documents button.");
//		browsePage.clickOnProfileAccountStatementsButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Account Statements Page is displaying.");
//		waitTime(5000);
//		ErrorCollector.verifyTrue(browsePage.verifyAccountStatementsHeadingIsDisplaying(),
//				"Verified Account Statements Page is displaying");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Back button.");
//		pressBack();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Manage Plan button.");
//		browsePage.clickOnProfileManagePlanButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Plan Management Page is displaying.");
//		waitTime(5000);
//		ErrorCollector.verifyTrue(browsePage.verifyManagePlanHeadingIsDisplaying(),
//				"Verified Plan Management Page is displaying");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Back button.");
//		pressBack();

		try {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Investment Profile button.");
			browsePage.clickOnButton("investmentProfileLabel");

		} catch (Exception e) {
			try {
				ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Investment Profile button.");
				browsePage.clickOnButton("Investment Profile");

			} catch (Exception e2) {
				ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Investment Profile button.");
				browsePage.clickOnButtonContains("Investment Profile");
			}
		}

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Investment Profile Page is displaying.");
		waitTime(5000);
		ErrorCollector.verifyTrue(browsePage.verifyInvestmentProfileHeadingIsDisplaying(),
				"Verified Investment Profile Page is displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Back button.");
		pressBack();

//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Recurring Investments button.");
//		browsePage.clickOnRecurringInvestmentsButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Recurring Investments Page is displaying.");
//		waitTime(5000);
//		ErrorCollector.verifyTrue(browsePage.verifyRecurringInvestmentHeadingIsDisplaying(),
//				"Verified Recurring Investments Page is displaying");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Back button.");
//		pressBack();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Referral button.");
//		browsePage.clickOnReferralButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Referral Page is displaying.");
//		waitTime(5000);
//		ErrorCollector.verifyTrue(browsePage.verifyHeadingIsDisplaying("Referral"),
//				"Verified Referral Page is displaying");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Back button.");
//		pressBack();

//		try {
//			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Security button.");
//			browsePage.clickOnButton("securityLabel");
//
//		} catch (Exception e) {
//			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Security button.");
//			browsePage.clickOnButton("Security");
//		}
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Security Page is displaying.");
//		waitTime(5000);
//		ErrorCollector.verifyTrue(browsePage.verifyHeadingIsDisplaying("Security"),
//				"Verified Security Page is displaying");

	}

	@Test(priority = 7)
	public void MonkeyTest_BrowseTab() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-133\">QAA-133 : iOS - Monkey Test Browse Tab<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}


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
		loginPage.enterPinCode(pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(), "Verified home page is displaying.");

		ExtentListeners.attachScreenShot("Home Page Screenshot");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");

		ExtentListeners.attachScreenShot("Browse Page Screenshot");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Top Movers Show All Button ");
		waitTime(1000);
		browsePage.clickOnshowAllButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Top Movers list page is displaying");
		waitTime(1000);
		ErrorCollector.verifyTrue(browsePage.verifyTopMoversPageIsDisplaying(),
				"Verified Top Movers list page is displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Back button.");
		waitTime(1000);
		browsePage.pressBackButtonFromTopMoversPage();
		waitTime(2000);
		swipeUpLess();

//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Recommended Show All Button.");
//		browsePage.clickOnRecommendedShowAllButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Recommended Stocks List Page is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifyHeadingIsDisplaying("Recommended"),
//				"Verified Recommended Stocks List Page is displaying");

	}

	@Test(priority = 4)
	public void MonkeyTest_VDTab() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-149\">QAA-149 : iOS - Monkey Test Vested Direct Page<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}


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

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Direct Menu button.");
		waitTime(3000);
		browsePage.clickOnDirectMenuButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Direct Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyDirectPageIsDisplaying(), "Verified Direct Page is displaying");

		ExtentListeners.attachScreenShot("Direct Page Screenshot");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Open Vested Direct Account button.");
		waitTime(3000);
		browsePage.clickOnOpenVestedDirectAccountButton();

		ErrorCollector
				.extentLogInfo("Step " + (++step) + " : Verify Open Vested Direct Account Page Heading is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyOpenVestedDirectAccountPageHeadingIsDisplaying(),
				"Verified Open Vested Direct Account Page Heading is displaying");

		ExtentListeners.attachScreenShot("Open Vested Direct Account Page Heading Screenshot");

	}

	@Test(priority = 6)
	public void MonkeyTest_TransferFundsTab() {
		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-150\">QAA-150 : iOS - Monkey Test Transfer Funds Tab<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();


		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}

		 FundTransferPage fundTransferPage = new FundTransferPage();

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

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Transfer Menu button.");
		browsePage.clickOnTransferMenuButton();

		waitTime(10000);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Transfer Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyTransferPageIsDisplaying(), "Verified Transfer Page is displaying");

		ExtentListeners.attachScreenShot("Transfer Page Screenshot");

		waitTime(20000);
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on ADD FUNDS button.");
        fundTransferPage.clickOnAddFundsButton();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify ADD FUNDS popup is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyAddFundsPopUpIsDisplaying(),"Verified ADD FUNDS popup is displaying");

        ExtentListeners.attachScreenShot("Add Funds Page Screenshot");

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Back Button button.");
        pressBackOnActionBar();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Withdraw Funds button is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyWithdrawFundButtonIsDisplaying(),"Verified Withdraw Funds button is displaying");


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Withdraw Funds button.");
        fundTransferPage.clickOnWithdrawFundsButton();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Withdraw Funds popup is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyWithdrawalFundsPopUpIsDisplaying(),"Verified Withdraw Funds popup is displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Withdraw Process Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyTransferWithdrawalProcessPageHeadingIsDisplaying(),
				"Verified Withdraw Process Page is displaying");

		ExtentListeners.attachScreenShot("Withdraw Process Page Screenshot");

	}

	@Test(priority = 8)
	public void DashboardLists_vests_premiumAccount() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-200\">QAA-200 : [iOS] Verify the dashboard list for Vests - Premium Account<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}


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
		waitTime(5000);
//		try {
//			ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll to 'Multi-Asset class vests'");
////			browsePage.scrollToMultiAssetClassVests();
////			swipeUpLess();
//			//scrollToText("MULTI-ASSET CLASS VESTS");
//			mobileScrollScreenIOS(Direction.DOWN);
//			waitTime(3000);
//
//			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'i' icon'");
//			browsePage.clickOnMultiAssetVestsInfoIcon();
//		} catch (Exception e) {
//			scrollUpToText("MULTI-ASSET CLASS VESTS");
//			waitTime(3000);
//
//			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'i' icon'");
//			browsePage.clickOnMultiAssetVestsInfoIcon();
//		}
		//mobileScrollScreenIOS(Direction.DOWN,500);
		waitTime(5000);
		scrollToText("MULTI-ASSET CLASS VESTS");
		waitTime(3000);
//		swipeDownSlightly();
//		waitTime(3000);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'i' icon'");
		browsePage.clickOnMultiAssetVestsInfoIcon();


		ErrorCollector
				.extentLogInfo("Step " + (++step) + " : Verify 'Multi-Asset class vests' info dialog is displaying.");
		ErrorCollector.verifyTrue(browsePage.isMultiAssetClassVestsDialogDisplaying(),
				"Verified 'Multi-Asset class vests' info dialog is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'close' icon'");
		browsePage.clickOnDialogCloseIcon();

		ErrorCollector.extentLogInfo(
				"Step " + (++step) + " : Verify 'Multi-Asset class vests' all three types are displaying.");
		ErrorCollector.verifyEquals(browsePage.getMultiAssetClassVestsListSize(), 3);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll to 'THEME-BASED VESTS'");
		//browsePage.scrollToThemeBasedVests();
		scrollToText("THEME-BASED VESTS");
		//waitTime(3000);
//		swipeDownSlightly();
		waitTime(5000);

//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Theme-Based vests' Features banner is displaying.");
//		ErrorCollector.verifyTrue(browsePage.isThemeBasedVestsBannerDisplaying(),
//		"Verified 'Theme-Based vests' Features banner is displaying.");


		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'i' icon'");
		browsePage.clickOnThemeBasedVestsInfoIcon();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Theme-Based vests' info dialog is displaying.");
		waitTime(1000);
		ErrorCollector.verifyTrue(browsePage.isThemeBasedVestsDialogDisplaying(),
				"Verified 'Theme-Based vests' info dialog is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'close' icon'");
		browsePage.clickOnThemeBasedVestDialogCloseIcon();
		swipeUpLess();


		List<WebElement> themVestsList = browsePage.getThemeBasedVests();
		System.out.println(themVestsList.size());
//		for (WebElement vest : themVestsList) {
		for(int i=0 ; i<=2;i++) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Theme-Based vest' <b>"
					+ browsePage.getThemBasedVestName(themVestsList.get(i)) + "</b> is Present.");

			ErrorCollector.verifyTrue(browsePage.verifyThemeBasedVestIsEnabled(themVestsList.get(i)),
					"Verified 'Theme-Based vests' <b>" + browsePage.getThemBasedVestName(themVestsList.get(i)) + "</b> is Present.");

		}

//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Multi-Asset class vests' all three types are displaying.");
//		ErrorCollector.verifyEquals(browsePage.getMultiAssetClassVestsListSize(), 3);
//

	}

	@Test(priority = 9)
		public void DashboardLists_vests_NonPremiumAccount() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-201\">QAA-201 : [iOS] Verify the dashboard list for Vests - Non-Premium Account<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][24].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();

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

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll to 'Multi-Asset class vests'");
		browsePage.scrollToMultiAssetClassVests();


		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'i' icon'");
		browsePage.clickOnMultiAssetVestsInfoIcon();

		ErrorCollector
				.extentLogInfo("Step " + (++step) + " : Verify 'Multi-Asset class vests' info dialog is displaying.");
		ErrorCollector.verifyTrue(browsePage.isMultiAssetClassVestsDialogDisplaying(),
				"Verified 'Multi-Asset class vests' info dialog is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'close' icon'");
		browsePage.clickOnDialogCloseIcon();

		ErrorCollector.extentLogInfo(
				"Step " + (++step) + " : Verify 'Multi-Asset class vests' all three types are displaying.");
		ErrorCollector.verifyEquals(browsePage.getMultiAssetClassVestsListSize(), 3);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll to 'THEME-BASED VESTS'");
		browsePage.scrollToThemeBasedVests();

//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Theme-Based vests' Features banner is displaying.");
//		ErrorCollector.verifyTrue(browsePage.isThemeBasedVestsBannerDisplaying(),"Verified 'Theme-Based vests' Features banner is displaying.");


		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'i' icon'");
		waitTime(1000);
		browsePage.clickOnThemeBasedVestsInfoIcon();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Theme-Based vests' info dialog is displaying.");
		ErrorCollector.verifyTrue(browsePage.isThemeBasedVestsDialogDisplaying(),
				"Verified 'Theme-Based vests' info dialog is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'close' icon'");
		browsePage.clickOnThemeBasedVestDialogCloseIcon();
		swipeUpLess();

		List<WebElement> themVestsList = browsePage.getThemeBasedVests();
//		for (WebElement vest : themVestsList) {
			for(int i=0 ; i<=2;i++) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Theme-Based vest' <b>"
					+ browsePage.getThemBasedVestName(themVestsList.get(i)) + "</b> is Present.");

			ErrorCollector.verifyTrue(browsePage.verifyThemeBasedVestIsEnabled(themVestsList.get(i)),
					"Verified 'Theme-Based vests' <b>" + browsePage.getThemBasedVestName(themVestsList.get(i)) + "</b> is Present.");

		}

	}

   @Test(priority = 10)
	public void MonkeyTest_DIYVestTab() {



		initReport();
		initConfiguration();
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-205\">QAA-205 : Android - Monkey Test DIY Vest Page<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, TestDataSheetName);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}


		int step = 1;
		ErrorCollector.extentLogInfo("Step " + step + " : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(), "Verified Login button displaying");
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Enter email address : " + email);
		signup.enterEmailAddress(email);
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Enter Password : " + password);
		signup.enterPassword(password);
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Enter Pin Code  : " + pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Click on DIY Vest Menu button.");
		browsePage.clickOnDIYVestMenuButton();
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Verify DIY Vest Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyDIYVestPageIsDisplaying(), "Verified DIY Vest Page is displaying");
		ExtentListeners.attachScreenShot("DIY Vest Page Screenshot");
		step++;

		// Specific id for more option element required
//        ErrorCollector.extentLogInfo("Step "+step+" : Click on DIY Vest More Option 3 Dots button.");
//        browsePage.clickOnDivVestMoreOption3Dots();
//        step++;
//
//        ErrorCollector.extentLogInfo("Step "+step+" : Verify Share button is present.");
//        ErrorCollector.verifyTrue(browsePage.isShareButtonPresent(),"Verified Share button is present");
//        step++;
//
//        ErrorCollector.extentLogInfo("Step "+step+" : Click on DIY Vest More Option 3 Dots button.");
//        browsePage.clickOnDivVestMoreOption3Dots();
//        step++;

//        ErrorCollector.extentLogInfo("Step "+step+" : Click on DIY Vest Drop Down Alphabetical button.");
//	     browsePage.clickOnDYourVestDropDown();
//	     step++;
//
//	     ErrorCollector.extentLogInfo("Step "+step+" : Verify Alphabetical button is present.");
//	     ErrorCollector.verifyTrue(browsePage.isAlphabeticalButtonPresent(),"Verified Share button is present");
//	     step++;
//
//	     ErrorCollector.extentLogInfo("Step "+step+" : Click on Alphabetical button.");
//	     browsePage.clickOnAlphabeticalButton();
//	     step++;
//
		ErrorCollector.extentLogInfo("Step " + step + " : Click on Create New button.");
		browsePage.clickOnCreateNewButton();
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Verify Create New DIY Page is present.");
		waitTime(10000);
		ErrorCollector.verifyTrue(browsePage.isCreateNewDIYVestPagePresent(),
				"Verified Create New DIY Page is present");
		ExtentListeners.attachScreenShot("Create New DIY Vest Page Screenshot");
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Click on Back button.");
		pressBack();
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Verify DIY Vest Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyDIYVestPageIsDisplaying(), "Verified DIY Vest Page is displaying");
		step++;

	}


    @Test(priority = 11)
	public void MonkeyTest_RewardsTab() {

		initReport();
		initConfiguration();
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-602\">QAA-602 :[IOS] Monkey Test Rewards Tab<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, TestDataSheetName);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}


		int step = 1;
		ErrorCollector.extentLogInfo("Step " + step + " : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(), "Verified Login button displaying");
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Enter email address : " + email);
		signup.enterEmailAddress(email);
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Enter Password : " + password);
		signup.enterPassword(password);
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Enter Pin Code  : " + pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);
		waitTime(5000);
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Verify homepage is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified homepage is displaying.");

		ErrorCollector.extentLogInfo("Step " + step + " : Click on Rewards Tab");
		browsePage.clickOnRewardsTab();

		ErrorCollector.extentLogInfo("Step " + step + " : Verify Rewards Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyRewardsPageIsDisplaying(),"Verified Rewards Page is displaying.");

		ErrorCollector.extentLogInfo("Step " + step + " : Click on Earn Tab");
		browsePage.clickOnRewardsEarnTab();

		ErrorCollector.extentLogInfo("Step " + step + " : Verify Refer and Earn section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyReferAndEarnSectionIsDisplaying(),"Verified Refer and Earn section is displaying.");

		ErrorCollector.extentLogInfo("Step " + step + " : Click on Redeem Tab");
		browsePage.clickOnRewardsRedeemTab();

		ErrorCollector.extentLogInfo("Step " + step + " : Verify Redeem section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyRedeemSectionIsDisplaying(),"Verified Redeem section is displaying.");

		ErrorCollector.extentLogInfo("Step " + step + " : Click on History Tab");
		browsePage.clickOnRewardsHistoryTab();

		ErrorCollector.extentLogInfo("Step " + step + " : Verify History section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyHistorySectionIsDisplaying(),"Verified History section is displaying.");


	}


	@Test
	public void ExistingUser_VerifyOTCSection() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-906\">QAA-906 : [iOS] - While user logged in with existing user, Verify the 'OTC' section on browse screen<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}


		int step = loginPage.loginToApplication(0, email, password, pinCode);


		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");

		//scrollDownToText("OTC");
//		waitTime(1000);
//		mobileScrollScreenIOS(Direction.DOWN, 70);

		ErrorCollector.extentLogInfo("Steps " + (++step) + " : Verify OTC Section is available.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCSectionIsAvailable(),"Verified OTC Section is available.");


		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to OTC Section.");
		browsePage.scrollDownToOTCSection();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCShowAllButtonIsDisplaying(),"Verified show all button is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is clickable.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCShowAllButtonIsClickable(),"Verified show all button is clickable.");
	}

	

	@Test(priority = 49)
	public void NewUser_VerifyOTCSection() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-908\">QAA-908 : [iOS] - While user logged in with new user, Verify the 'OTC' section on browse screen<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(testDataFile, testDataSheet);
//		String email = dataArr[0][1].toString();
//		String password = dataArr[0][2].toString();
//		String pinCode = dataArr[0][3].toString();

		String email = "ramya.reddy+io4@vestedfinance.co";
		String password = "iTestUser1!";
		String pinCode = "111111";

		int step = 0;

		ErrorCollector.extentLogInfo("Login to application.");
		step = loginPage.loginToApplication(step, email, password, pinCode);

//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup button displaying.");
//		ErrorCollector.verifyTrue(signup.verifySignUpButtonShowing(), "Verified Signup button displaying");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up button.");
//		waitTime(3000);
//		signup.clickOnSignUpButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup with Email button displaying.");
//		ErrorCollector.verifyTrue(signup.verifySignUpWithEmailButtonShowing(),
//				"Verified Signup with Email button displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up With Email button.");
//		signup.clickOnSignUpWithEmailButton();
//
//		String email = getUniqueEmailId("Test");
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter email address : " + email);
//		signup.enterEmailAddress(email);
//
//		String password = getUniquePassword();
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + password);
//		signup.enterPassword(password);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign Up button.");
//		signup.clickOnSubmitSignupButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Verification Code screen is displaying.");
//		ErrorCollector.verifyTrue(signup.verifyOTPScreenIsDisplaying(),
//				"Verify Verification Code screen is displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Back button.");
//		waitTime(3000);
//		signup.clickOnBackButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Back button.");
//		waitTime(1000);
//		signup.clickOnBackButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login button.");
//		signup.clickOnLoginButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login With Email button.");
//		loginPage.clickOnLoginWithEmailButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter email address : " + email);
//		signup.enterEmailAddress(email);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + password);
//		signup.enterPassword(password);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login button.");
//		loginPage.clickOnLoginSubmitButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'START KYC' button is displaying.");
//		ErrorCollector.verifyTrue(loginPage.verifyStarKYCButton(), "Verified 'START KYC' button is displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'EXPLORE PLATFORM' button is displaying.");
//		ErrorCollector.verifyTrue(loginPage.verifyExplorePlatformButton(),
//				"Verified 'EXPLORE PLATFORM' button is displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Explore the Platform' button.");
//		browsePage.clickOnExplorePlatformButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Accept and Proceed' button.");
//		browsePage.clickOnAcceptAndProceedButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Ok' button in popup.");
//		signup.clickOnOkButtonInTermsAcceptedModal();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'AWESOME!' button in popup.");
//		signup.clickOnAwesomeButtonInModal();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on GREATE! button in modal.");
		signup.clickOnGreateButtonInModal();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Done' button in modal.");
		signup.clickOnDoneButtonInModal();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
		
		updateConfigurations(env+"_NewUserEmailId",email);
		updateConfigurations(env+"_NewUserPassword",password);
		//scrollDownToText("OTC");
//		waitTime(1000);
//		mobileScrollScreenIOS(Direction.DOWN, 70);
		
		ErrorCollector.extentLogInfo("Steps " + (++step) + " : Verify OTC Section is available.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCSectionIsAvailable(),"Verified OTC Section is available.");

		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to OTC Section.");
		browsePage.scrollDownToOTCSection();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCShowAllButtonIsDisplaying(),"Verified show all button is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is clickable.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCShowAllButtonIsClickable(),"Verified show all button is clickable.");
	}

	
	
	@Test(priority = 50)
	public void NewUser_VerifyOTCDetails() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-913\">QAA-913 : [iOS] - While user logged in with new user, Verify the 'OTC' details screen<a/>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		
		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = PropertiesReader.getPropertyValue(env+"_NewUserEmailId");
		String password = PropertiesReader.getPropertyValue(env+"_NewUserPassword");
		String pinCode = dataArr[0][3].toString();
		
		int step = 0;
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : <b>Login With New User Credentials</b>.");
		step = loginPage.loginToApplication(step, email, password);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
		
		//scrollDownToText("OTC");
//		waitTime(1000);
//		mobileScrollScreenIOS(Direction.DOWN, 70);
		
		ErrorCollector.extentLogInfo("Steps " + (++step) + " : Verify OTC Section is available.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCSectionIsAvailable(),"Verified OTC Section is available.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to OTC Section.");
		browsePage.scrollDownToOTCSection();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCShowAllButtonIsDisplaying(),"Verified show all button is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is clickable.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCShowAllButtonIsClickable(),"Verified show all button is clickable.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Show All button.");
		browsePage.clickOnOTCShowAllButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify heading 'Over-the-Counter (OTC) Securities is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCHeadingIsDisplaying(),"Verified heading 'Over-the-Counter (OTC) Securities is displaying.");

		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' is selected by default in OTC sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(),"Market Cap",
				"By default 'Market Cap' is not selected by OTC dropdown.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),"Verified 'Alphabetical' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),"Verified 'Symbol' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),"Verfied 'Market Price' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),"Verified 'Daily Change' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),"Verified 'Market Cap' filter is displaying");
	}
	


	@Test(priority = 50)
	public void ExistingUser_VerifyOTCDetails() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-910\">QAA-910 : [iOS] - While user logged in with existing user, Verify the 'OTC' details screen<a/>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		
		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		
		int step = 0;
		step = loginPage.loginToApplication(step, email, password,pinCode);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
		
		//scrollDownToText("OTC");
//		waitTime(1000);
//		mobileScrollScreenIOS(Direction.DOWN, 70);
		
		ErrorCollector.extentLogInfo("Steps " + (++step) + " : Verify OTC Section is available.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCSectionIsAvailable(),"Verified OTC Section is available.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to OTC Section.");
		browsePage.scrollDownToOTCSection();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCShowAllButtonIsDisplaying(),"Verified show all button is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is clickable.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCShowAllButtonIsClickable(),"Verified show all button is clickable.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Show All button.");
		browsePage.clickOnOTCShowAllButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify heading 'Over-the-Counter (OTC) Securities is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCHeadingIsDisplaying(),"Verified heading 'Over-the-Counter (OTC) Securities is displaying.");

		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' is selected by default in OTC sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(),"Market Cap",
				"By default 'Market Cap' is not selected by OTC dropdown.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),"Verified 'Alphabetical' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),"Verified 'Symbol' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),"Verfied 'Market Price' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),"Verified 'Daily Change' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),"Verified 'Market Cap' filter is displaying");
	}
	
	@Test(priority = 51)
	public void NewUser_VerifyOTCDetailsSortingFilters() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-915\">QAA-915 : [iOS] - While user logged in with new user, Verify the sorting filters 'OTC' detail screen<a/>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		String email = PropertiesReader.getPropertyValue(env+"_NewUserEmailId");
		String password = PropertiesReader.getPropertyValue(env+"_NewUserPassword");
		
		int step = 0;
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : <b>Login With New User Credentials</b>.");
		step = loginPage.loginToApplication(step, email, password);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
		
		ErrorCollector.extentLogInfo("Steps " + (++step) + " : Verify OTC Section is available.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCSectionIsAvailable(),"Verified OTC Section is available.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to OTC Section.");
		browsePage.scrollDownToOTCSection();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCShowAllButtonIsDisplaying(),"Verified show all button is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is clickable.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCShowAllButtonIsClickable(),"Verified show all button is clickable.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Show All button.");
		browsePage.clickOnOTCShowAllButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify heading 'Over-the-Counter (OTC) Securities is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCHeadingIsDisplaying(),"Verified heading 'Over-the-Counter (OTC) Securities is displaying.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' is selected by default in OTC sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(),"Market Cap",
				"By default 'Market Cap' is not selected by OTC dropdown.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();
		
		////XCUIElementTypeStaticText[@name="collectionStockName"]  OTC stocks list name
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),"Verified 'Alphabetical' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Alphabetical' filter.");
		browsePage.clickOnSortingFilter("Alphabetical");
		ArrayList<String> names = browsePage.getOTCStocksNames();
		
		ArrayList<String> sortedNames = new ArrayList<>();
		sortedNames.addAll(names);
		Collections.sort(sortedNames);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify OTC stocks are sorted by 'Alphabetical' filter.");
		ErrorCollector.verifyEquals(names, sortedNames,"OTC are not sorted by names Alphabetically.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),"Verified 'Symbol' filter is displaying.");
		 
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Symbol' filter.");
		browsePage.clickOnSortingFilter("Symbol");
		ArrayList<String> symbols = browsePage.getOTCStocksSymbols();
		
		ArrayList<String> sortedSymbols = new ArrayList<>();
		sortedSymbols.addAll(symbols);
		Collections.sort(sortedSymbols);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify OTC stocks are sorted by 'Symbol' filter.");
		ErrorCollector.verifyEquals(symbols, sortedSymbols,"OTC are not sorted by names Symbol.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),"Verfied 'Market Price' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Pricep' filter.");
		browsePage.clickOnSortingFilter("Market Price");
		ArrayList<Double> MarketPrice = browsePage.getOTCStocksMarketPrice();
		
		ArrayList<Double> sortedMarketPrices = new ArrayList<>();
		sortedMarketPrices.addAll(MarketPrice);
		Collections.sort(sortedMarketPrices,Collections.reverseOrder());
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify OTC stocks are sorted by 'Market Price' filter.");
		ErrorCollector.verifyEquals(MarketPrice, sortedMarketPrices,"OTC are not sorted by market price.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),"Verified 'Daily Change' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Daily Change' filter.");
		browsePage.clickOnSortingFilter("Daily Change");
		ArrayList<Double> DailyChange = browsePage.getOTCStocksDailyChange();
		
		ArrayList<Double> sortedDailyChange = new ArrayList<>();
		sortedDailyChange.addAll(DailyChange);
		Collections.sort(sortedDailyChange,Collections.reverseOrder());
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify OTC stocks are sorted by 'Daily Change' filter.");
		ErrorCollector.verifyEquals(DailyChange, sortedDailyChange,"OTC are not sorted by Daily Change.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),"Verified 'Market Cap' filter is displaying");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Cap' filter.");
		browsePage.clickOnSortingFilter("Market Cap");
		ArrayList<Double> marketCapitals = browsePage.getOTCStocksMarketCapital();
		
		ArrayList<Double> sortedMarketCapitals = new ArrayList<>();
		sortedMarketCapitals.addAll(marketCapitals);
		Collections.sort(sortedMarketCapitals,Collections.reverseOrder());
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify OTC stocks are sorted by 'Market Cap' filter.");
		ErrorCollector.verifyEquals(marketCapitals, sortedMarketCapitals,"OTC are not sorted by market capital.");
		
		
	}
	

	@Test(priority = 52)
	public void ExistingUser_VerifyOTCDetailsSortingFilters() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-915\">QAA-915 : [iOS] - While user logged in with new user, Verify the sorting filters 'OTC' detail screen<a/>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		
		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}

		
		int step = loginPage.loginToApplication(0, email, password, pinCode);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
		ErrorCollector.extentLogInfo("Steps " + (++step) + " : Verify OTC Section is available.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCSectionIsAvailable(),"Verified OTC Section is available.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to OTC Section.");
		browsePage.scrollDownToOTCSection();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCShowAllButtonIsDisplaying(),"Verified show all button is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is clickable.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCShowAllButtonIsClickable(),"Verified show all button is clickable.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Show All button.");
		browsePage.clickOnOTCShowAllButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify heading 'Over-the-Counter (OTC) Securities is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyOTCHeadingIsDisplaying(),"Verified heading 'Over-the-Counter (OTC) Securities is displaying.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' is selected by default in OTC sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(),"Market Cap",
				"By default 'Market Cap' is not selected by OTC dropdown.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();
		
		////XCUIElementTypeStaticText[@name="collectionStockName"]  OTC stocks list name
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),"Verified 'Alphabetical' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Alphabetical' filter.");
		browsePage.clickOnSortingFilter("Alphabetical");
		ArrayList<String> names = browsePage.getOTCStocksNames();
		
		ArrayList<String> sortedNames = new ArrayList<>();
		sortedNames.addAll(names);
		Collections.sort(sortedNames);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify OTC stocks are sorted by 'Alphabetical' filter.");
		ErrorCollector.verifyEquals(names, sortedNames,"OTC are not sorted by names Alphabetically.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),"Verified 'Symbol' filter is displaying.");
		 
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Symbol' filter.");
		browsePage.clickOnSortingFilter("Symbol");
		ArrayList<String> symbols = browsePage.getOTCStocksSymbols();
		
		ArrayList<String> sortedSymbols = new ArrayList<>();
		sortedSymbols.addAll(symbols);
		Collections.sort(sortedSymbols);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify OTC stocks are sorted by 'Symbol' filter.");
		ErrorCollector.verifyEquals(symbols, sortedSymbols,"OTC are not sorted by names Symbol.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),"Verfied 'Market Price' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Pricep' filter.");
		browsePage.clickOnSortingFilter("Market Price");
		ArrayList<Double> MarketPrice = browsePage.getOTCStocksMarketPrice();
		
		ArrayList<Double> sortedMarketPrices = new ArrayList<>();
		sortedMarketPrices.addAll(MarketPrice);
		Collections.sort(sortedMarketPrices,Collections.reverseOrder());
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify OTC stocks are sorted by 'Market Price' filter.");
		ErrorCollector.verifyEquals(MarketPrice, sortedMarketPrices,"OTC are not sorted by market price.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),"Verified 'Daily Change' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Daily Change' filter.");
		browsePage.clickOnSortingFilter("Daily Change");
		ArrayList<Double> DailyChange = browsePage.getOTCStocksDailyChange();
		
		ArrayList<Double> sortedDailyChange = new ArrayList<>();
		sortedDailyChange.addAll(DailyChange);
		Collections.sort(sortedDailyChange,Collections.reverseOrder());
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify OTC stocks are sorted by 'Daily Change' filter.");
		ErrorCollector.verifyEquals(DailyChange, sortedDailyChange,"OTC are not sorted by Daily Change.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),"Verified 'Market Cap' filter is displaying");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Cap' filter.");
		browsePage.clickOnSortingFilter("Market Cap");
		ArrayList<Double> marketCapitals = browsePage.getOTCStocksMarketCapital();
		
		ArrayList<Double> sortedMarketCapitals = new ArrayList<>();
		sortedMarketCapitals.addAll(marketCapitals);
		Collections.sort(sortedMarketCapitals,Collections.reverseOrder());
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify OTC stocks are sorted by 'Market Cap' filter.");
		ErrorCollector.verifyEquals(marketCapitals, sortedMarketCapitals,"OTC are not sorted by market capital.");
		
		
	}
	

	@Test(priority = 53)
	public void NewUser_TopMoversDetails() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-943\">QAA-943 : [iOS] - While user logged in with new user, Verify the 'Top Movers' details screen</a>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		String email = PropertiesReader.getPropertyValue(env+"_NewUserEmailId");
		String password = PropertiesReader.getPropertyValue(env+"_NewUserPassword");
		
		int step = 0;
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : <b>Login With New User Credentials</b>.");
		step = loginPage.loginToApplication(step, email, password);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
		
		//scrollDownToText("OTC");
//		waitTime(1000);
//		mobileScrollScreenIOS(Direction.DOWN, 70);
		
		ErrorCollector.extentLogInfo("Steps " + (++step) + " : Verify Top Movers Section is available.");
		ErrorCollector.verifyTrue(browsePage.verifyTopMoversSectionIsAvailable(),"Verified Top Movers Section is available.");
		
		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to OTC Section.");
//		browsePage.scrollDownToOTCSection();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyTopMoversShowAllButtonIsDisplaying(),"Verified show all button is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is clickable.");
		ErrorCollector.verifyTrue(browsePage.verifyTopMoversShowAllButtonIsClickable(),"Verified show all button is clickable.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Show All button.");
		browsePage.clickOnTopMoversShowAllButton();
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Changep' is selected by default in Top Movers sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(),"Daily Change",
				"By default 'Daily Change' is not selected by Top Movers sorting filters dropdown.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),"Verified 'Alphabetical' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),"Verified 'Symbol' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),"Verfied 'Market Price' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),"Verified 'Daily Change' filter is displaying.");
		
	}

	

	@Test(priority = 63)
	public void Existing_TopMoversDetails() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-966\">QAA-966 : [iOS] - While user logged in with existing user, Verify the 'Top Movers' details screen</a>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		
		int step = 0;
		step = loginPage.loginToApplication(step, email, password,pinCode);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
		
		//scrollDownToText("OTC");
//		waitTime(1000);
//		mobileScrollScreenIOS(Direction.DOWN, 70);
		
		ErrorCollector.extentLogInfo("Steps " + (++step) + " : Verify Top Movers Section is available.");
		ErrorCollector.verifyTrue(browsePage.verifyTopMoversSectionIsAvailable(),"Verified Top Movers Section is available.");
		
		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to OTC Section.");
//		browsePage.scrollDownToOTCSection();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyTopMoversShowAllButtonIsDisplaying(),"Verified show all button is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is clickable.");
		ErrorCollector.verifyTrue(browsePage.verifyTopMoversShowAllButtonIsClickable(),"Verified show all button is clickable.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Show All button.");
		browsePage.clickOnTopMoversShowAllButton();
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Changep' is selected by default in Top Movers sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(),"Daily Change",
				"By default 'Daily Change' is not selected by Top Movers sorting filters dropdown.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),"Verified 'Alphabetical' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),"Verified 'Symbol' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),"Verfied 'Market Price' filter is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),"Verified 'Daily Change' filter is displaying.");
		
	}

//	@Test(priority = 54) Obsolete Recommended test case
	public void NewUser_RecommendedSectionDetails() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-946\">QAA-946 : [iOS] - While user logged in with new user, Verify the 'Recommended' details screen</a>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		String email = PropertiesReader.getPropertyValue(env+"_NewUserEmailId");
		String password = PropertiesReader.getPropertyValue(env+"_NewUserPassword");

		int step = 0;
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : <b>Login With New User Credentials</b>.");
		step = loginPage.loginToApplication(step, email, password);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");

		//scrollDownToText("OTC");
//		waitTime(1000);
//		mobileScrollScreenIOS(Direction.DOWN, 70);

		ErrorCollector.extentLogInfo("Steps " + (++step) + " : Verify Recommended Section is available.");
		ErrorCollector.verifyTrue(browsePage.verifyRecommendedSectionIsAvailable(),"Verified Recommended Section is available.");


//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to OTC Section.");
//		browsePage.scrollDownToOTCSection();

//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifyRecommendedShowAllButtonIsDisplaying(),"Verified show all button is displaying.");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is clickable.");
//		ErrorCollector.verifyTrue(browsePage.verifyRecommendedShowAllButtonIsClickable(),"Verified show all button is clickable.");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Show All button.");
//		browsePage.clickOnRecommendedShowAllButton();


//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' is selected by default in Top Movers sorting dropdown is displaying.");
//		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(),"Daily Change",
//				"By default 'Daily Change' is not selected by Top Movers sorting filters dropdown.");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
//		browsePage.clickOnSortingDropdown();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),"Verified 'Alphabetical' filter is displaying.");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),"Verified 'Symbol' filter is displaying.");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),"Verfied 'Market Price' filter is displaying.");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),"Verified 'Daily Change' filter is displaying.");

	}
	

//	@Test(priority = 54) "Obsolete recommended test case"
	public void ExistingUser_RecommendedSectionDetails() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-968\">QAA-968 : [iOS] - While user logged in with existing user, Verify the 'Recommended' details screen</a>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		
		int step = 0;
		step = loginPage.loginToApplication(step, email, password,pinCode);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
		
		//scrollDownToText("OTC");
//		waitTime(1000);
//		mobileScrollScreenIOS(Direction.DOWN, 70);
		
		ErrorCollector.extentLogInfo("Steps " + (++step) + " : Verify Recommended Section is available.");
		ErrorCollector.verifyTrue(browsePage.verifyRecommendedSectionIsAvailable(),"Verified Recommended Section is available.");
		
		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to OTC Section.");
//		browsePage.scrollDownToOTCSection();
		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifyRecommendedShowAllButtonIsDisplaying(),"Verified show all button is displaying.");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is clickable.");
//		ErrorCollector.verifyTrue(browsePage.verifyRecommendedShowAllButtonIsClickable(),"Verified show all button is clickable.");

//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Show All button.");
//		browsePage.clickOnRecommendedShowAllButton();
//
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' is selected by default in Top Movers sorting dropdown is displaying.");
//		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(),"Daily Change",
//				"By default 'Daily Change' is not selected by Top Movers sorting filters dropdown.");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
//		browsePage.clickOnSortingDropdown();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),"Verified 'Alphabetical' filter is displaying.");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),"Verified 'Symbol' filter is displaying.");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),"Verfied 'Market Price' filter is displaying.");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),"Verified 'Daily Change' filter is displaying.");
		
	}
	
	
//	@Test(priority = 55) Obsolete Recommended test case
	public void NewUser_RecommendedSectionDisClosure() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-948\">QAA-948 : [iOS] - While user logged in with new user, Verify the 'Recommended Disclosure' on Browse screen</a>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		
		Object[][] dataArr = getData(testDataFile, testDataSheet);
//		String email = dataArr[0][1].toString();
//		String password = dataArr[0][2].toString();
//		String pinCode = dataArr[0][3].toString();

		String email = "ramya.reddy+io4@vestedfinance.co";
		String password = "iTestUser1!";
  		String pinCode = "111111";
		
		int step = 0;
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup button displaying.");
//		ErrorCollector.verifyTrue(signup.verifySignUpButtonShowing(), "Verified Signup button displaying");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up button.");
//		waitTime(3000);
//		signup.clickOnSignUpButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup with Email button displaying.");
//		ErrorCollector.verifyTrue(signup.verifySignUpWithEmailButtonShowing(),
//				"Verified Signup with Email button displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up With Email button.");
//		signup.clickOnSignUpWithEmailButton();
//
//		String email = getUniqueEmailId("Test");
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter email address : " + email);
//		signup.enterEmailAddress(email);
//
//		String password = getUniquePassword();
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + password);
//		signup.enterPassword(password);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign Up button.");
//		signup.clickOnSubmitSignupButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Verification Code screen is displaying.");
//		ErrorCollector.verifyTrue(signup.verifyOTPScreenIsDisplaying(),
//				"Verify Verification Code screen is displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Back button.");
//		waitTime(3000);
//		signup.clickOnBackButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Back button.");
//		waitTime(1000);
//		signup.clickOnBackButton();

		ErrorCollector.extentLogInfo("Login to application.");
		step = loginPage.loginToApplication(step, email, password, pinCode);

//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login button.");
//		signup.clickOnLoginButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login With Email button.");
//		loginPage.clickOnLoginWithEmailButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter email address : " + email);
//		signup.enterEmailAddress(email);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + password);
//		signup.enterPassword(password);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login button.");
//		loginPage.clickOnLoginSubmitButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'START KYC' button is displaying.");
//		ErrorCollector.verifyTrue(loginPage.verifyStarKYCButton(), "Verified 'START KYC' button is displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'EXPLORE PLATFORM' button is displaying.");
//		ErrorCollector.verifyTrue(loginPage.verifyExplorePlatformButton(),
//				"Verified 'EXPLORE PLATFORM' button is displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Explore the Platform' button.");
//		browsePage.clickOnExplorePlatformButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Accept and Proceed' button.");
//		browsePage.clickOnAcceptAndProceedButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Ok' button in popup.");
//		signup.clickOnOkButtonInTermsAcceptedModal();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'AWESOME!' button in popup.");
//		signup.clickOnAwesomeButtonInModal();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on GREATE! button in modal.");
		signup.clickOnGreateButtonInModal();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Done' button in modal.");
		signup.clickOnDoneButtonInModal();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
		
		//scrollDownToText("OTC");
//		waitTime(1000);
//		mobileScrollScreenIOS(Direction.DOWN, 70);
		
		ErrorCollector.extentLogInfo("Steps " + (++step) + " : Verify Recommended Section is available.");
		ErrorCollector.verifyTrue(browsePage.verifyRecommendedSectionIsAvailable(),"Verified Recommended Section is available.");


		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to Recommended Section.");
		browsePage.scrollDownToOTCSection();

//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Recommended Disclosure is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifyRecommendedDisclosureIsDisplaying(),
//				"Verified Recommended Disclosure is displaying");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Recommended Disclosure.");
//		browsePage.clickOnRecommendedDisclosure();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Recommended Disclosure pop up is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifyRecommendedDisclosurePopUpDescriptionIsDisplaying(),
//				"Verified Recommended Disclosure pop up is displaying");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Recommended Disclosure description 'At Vested, our mission is to empower you to become a successful investor. To help you pick the right investments, we provide stock and/or ETF recommendations based on your risk profile. Your risk profile is based on information you submitted during the KYC process, including age, risk tolerance, investment experience, employment status, and income level.\r\n"
//				+ "\r\n"
//				+ "Vested provides non-discretionary advisory services, meaning you are free to override the recommendations we provide. We rely on the information you give us to make these recommendations. If there are any changes in your financial situation or investment objectives, you can update your profile by visiting the Profile / Account section of the application and altering your investment profile data accordingly.' is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifyRecommendedDisclosurePopUpDescriptionIsDisplaying(),
//				"Verified Recommended Disclosure description is displaying");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify X icon in Recommended Disclosure pop up is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifyXIConInRecommendedDisclosurePopUpIsDisplaying(),
//				"Verified X icon in Recommended Disclosure pop up is displaying");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on close Recommended Disclosure popup.");
//		browsePage.clickCloseOnRecommendedDisclosure();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Recommended Disclosure pop up is closed.");
//		ErrorCollector.verifyFalse(browsePage.verifyRecommendedDisclosurePopUpIsDisplaying(),
//				"Verified Recommended Disclosure pop up is closed");
	}

	@Test(priority = 56)
	public void NewUser_EmergingThemesDisclosureSectionDisClosure() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-950\">QAA-950 : [iOS] - While user logged in with new user, Verify the 'Emerging Themes Disclosure' on Browse screen</a>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		
		String email = PropertiesReader.getPropertyValue(env+"_NewUserEmailId");
		String password = PropertiesReader.getPropertyValue(env+"_NewUserPassword");
		
		int step = 0;
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : <b>Login With New User Credentials</b>.");
		step = loginPage.loginToApplication(step, email, password);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on GREATE! button in modal.");
//		signup.clickOnGreateButtonInModal();
//		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Done' button in modal.");
//		signup.clickOnDoneButtonInModal();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
		
		//scrollDownToText("OTC");
//		waitTime(1000);
//		mobileScrollScreenIOS(Direction.DOWN, 70);
		
		ErrorCollector.extentLogInfo("Steps " + (++step) + " : Verify Emerging Themes Section is available.");
		ErrorCollector.verifyTrue(browsePage.verifyEmergingThemesSectionIsAvailable(),"Verified Emerging Themes Section is available.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to Emerging Themes Section.");
		browsePage.scrollDownToEmergingThemesSection();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Emerging Themes Disclosure is displaying.");
		swipeUpLess();
		ErrorCollector.verifyTrue(browsePage.verifyEmergingThemesDisclosureIsDisplaying(),
				"Verified Emerging Themes Disclosure is displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Emerging Themes Disclosure.");
		browsePage.clickOnEmergingThemesDisclosure();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Emerging Themes Disclosure pop up is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyEmergingThemesDisclosurePopUpDescriptionIsDisplaying(),
				"Verified Emerging Themes Disclosure pop up is displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Emerging Themes Disclosure description 'This collection is a curated list of companies that have material involvement in the specified collection. An analysis of each company's public information (including its financial statements, website, and management's public statements) was performed to determine the nature of the company’s involvement in the industry. Note that this analysis may be based on limited information and may become outdated. Companies may provide misleading or false public information regarding their involvement in the industry.' is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyEmergingThemesDisclosurePopUpDescriptionIsDisplaying(),
				"Verified Emerging Themes Disclosure description is displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify X icon in Emerging Themes Disclosure pop up is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyXIConInEmergingThemesDisclosurePopUpIsDisplaying(),
				"Verified X icon in Emerging Themes Disclosure pop up is displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on close Emerging Themes Disclosure popup.");
		browsePage.clickCloseOnEmergingThemesDisclosure();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Emerging Themes Disclosure pop up is closed.");
		ErrorCollector.verifyFalse(browsePage.verifyEmergingThemesDisclosurePopUpIsDisplaying(),
				"Verified Emerging Themes Disclosure pop up is closed");
	}
	
	
	@Test
	public void ExistingUser_EmergingThemesDisclosurePopUp() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-972\">QAA-972 : [iOS] - While logged in with existing user, Verify the \"Emerging Themes Disclosure\" popup on dashboard screen</a>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		
		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String Pin = dataArr[0][3].toString();
		
		int step = 0;
		step = loginPage.loginToApplication(step, email, password,Pin);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on GREATE! button in modal.");
//		signup.clickOnGreateButtonInModal();
//		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Done' button in modal.");
//		signup.clickOnDoneButtonInModal();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
		
		//scrollDownToText("OTC");
//		waitTime(1000);
//		mobileScrollScreenIOS(Direction.DOWN, 70);
		
		ErrorCollector.extentLogInfo("Steps " + (++step) + " : Verify Emerging Themes Section is available.");
		ErrorCollector.verifyTrue(browsePage.verifyEmergingThemesSectionIsAvailable(),"Verified Emerging Themes Section is available.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to Emerging Themes Section.");
		browsePage.scrollDownToEmergingThemesSection();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Emerging Themes Disclosure is displaying.");
		swipeUpLess();
		ErrorCollector.verifyTrue(browsePage.verifyEmergingThemesDisclosureIsDisplaying(),
				"Verified Emerging Themes Disclosure is displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Emerging Themes Disclosure.");
		browsePage.clickOnEmergingThemesDisclosure();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Emerging Themes Disclosure pop up is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyEmergingThemesDisclosurePopUpDescriptionIsDisplaying(),
				"Verified Emerging Themes Disclosure pop up is displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Emerging Themes Disclosure description 'This collection is a curated list of companies that have material involvement in the specified collection. An analysis of each company's public information (including its financial statements, website, and management's public statements) was performed to determine the nature of the company’s involvement in the industry. Note that this analysis may be based on limited information and may become outdated. Companies may provide misleading or false public information regarding their involvement in the industry.' is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyEmergingThemesDisclosurePopUpDescriptionIsDisplaying(),
				"Verified Emerging Themes Disclosure description is displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify X icon in Emerging Themes Disclosure pop up is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyXIConInEmergingThemesDisclosurePopUpIsDisplaying(),
				"Verified X icon in Emerging Themes Disclosure pop up is displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on close Emerging Themes Disclosure popup.");
		browsePage.clickCloseOnEmergingThemesDisclosure();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Emerging Themes Disclosure pop up is closed.");
		ErrorCollector.verifyFalse(browsePage.verifyEmergingThemesDisclosurePopUpIsDisplaying(),
				"Verified Emerging Themes Disclosure pop up is closed");
	}
	
	
	@Test(priority = 57)
	public void NewUser_TopMoversSection() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-952\">QAA-952 : [iOS] - While user logged in with new user, Verify the 'Top Movers' section on browse screen</a>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		
		Object[][] dataArr = getData(testDataFile, testDataSheet);
////		String email = dataArr[0][1].toString();
////		String password = dataArr[0][2].toString();
//		String pinCode = dataArr[0][3].toString();

		String email = "ramya.reddy+io4@vestedfinance.co";
		String password = "iTestUser1!";
		String pinCode = "111111";
		
		int step = 0;

		ErrorCollector.extentLogInfo("Login to application.");
		step = loginPage.loginToApplication(step, email, password, pinCode);
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup button displaying.");
//		ErrorCollector.verifyTrue(signup.verifySignUpButtonShowing(), "Verified Signup button displaying");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up button.");
//		waitTime(3000);
//		signup.clickOnSignUpButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup with Email button displaying.");
//		ErrorCollector.verifyTrue(signup.verifySignUpWithEmailButtonShowing(),
//				"Verified Signup with Email button displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up With Email button.");
//		signup.clickOnSignUpWithEmailButton();
//
//		String email = getUniqueEmailId("Test");
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter email address : " + email);
//		signup.enterEmailAddress(email);
//
//		String password = getUniquePassword();
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + password);
//		signup.enterPassword(password);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign Up button.");
//		signup.clickOnSubmitSignupButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Verification Code screen is displaying.");
//		ErrorCollector.verifyTrue(signup.verifyOTPScreenIsDisplaying(),
//				"Verify Verification Code screen is displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Back button.");
//		waitTime(3000);
//		signup.clickOnBackButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Back button.");
//		waitTime(1000);
//		signup.clickOnBackButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login button.");
//		signup.clickOnLoginButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login With Email button.");
//		loginPage.clickOnLoginWithEmailButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter email address : " + email);
//		signup.enterEmailAddress(email);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + password);
//		signup.enterPassword(password);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login button.");
//		loginPage.clickOnLoginSubmitButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'START KYC' button is displaying.");
//		ErrorCollector.verifyTrue(loginPage.verifyStarKYCButton(), "Verified 'START KYC' button is displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'EXPLORE PLATFORM' button is displaying.");
//		ErrorCollector.verifyTrue(loginPage.verifyExplorePlatformButton(),
//				"Verified 'EXPLORE PLATFORM' button is displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Explore the Platform' button.");
//		browsePage.clickOnExplorePlatformButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Accept and Proceed' button.");
//		browsePage.clickOnAcceptAndProceedButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Ok' button in popup.");
//		signup.clickOnOkButtonInTermsAcceptedModal();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'AWESOME!' button in popup.");
//		signup.clickOnAwesomeButtonInModal();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on GREATE! button in modal.");
		signup.clickOnGreateButtonInModal();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Done' button in modal.");
		signup.clickOnDoneButtonInModal();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");

		ErrorCollector.extentLogInfo("Steps " + (++step) + " : Verify Top Movers Section is available.");
		ErrorCollector.verifyTrue(browsePage.verifyTopMoversSectionIsAvailable(),"Verified Top Movers Section is available.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyTopMoversShowAllButtonIsDisplaying(),"Verified show all button is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is clickable.");
		ErrorCollector.verifyTrue(browsePage.verifyTopMoversShowAllButtonIsClickable(),"Verified show all button is clickable.");
		
	}
	
	@Test(priority = 57)
	public void ExistingUser_TopMoversSection() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-974\">QAA-974 : [iOS] - While user logged in with existing user, Verify the 'Top Movers' section on browse screen</a>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		
		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		
		int step = loginPage.loginToApplication(0, email, password, pinCode);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");

		ErrorCollector.extentLogInfo("Steps " + (++step) + " : Verify Top Movers Section is available.");
		ErrorCollector.verifyTrue(browsePage.verifyTopMoversSectionIsAvailable(),"Verified Top Movers Section is available.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyTopMoversShowAllButtonIsDisplaying(),"Verified show all button is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Show All button is clickable.");
		ErrorCollector.verifyTrue(browsePage.verifyTopMoversShowAllButtonIsClickable(),"Verified show all button is clickable.");
		
	}
	
//	@Test(priority = 58) Obsolete Recommeded test case
	public void NewUser_RecommendedSection() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-954\">QAA-954 : [iOS] - While user logged in with new user, Verify the 'Recommended' section on browse screen</a>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		
		String email = PropertiesReader.getPropertyValue(env+"_NewUserEmailId");
		String password = PropertiesReader.getPropertyValue(env+"_NewUserPassword");
		
		int step = 0;
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : <b>Login With New User Credentials</b>.");
		step = loginPage.loginToApplication(step, email, password);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
		
		ErrorCollector.extentLogInfo("Steps " + (++step) + " : Verify Recommended Section is available.");
		ErrorCollector.verifyTrue(browsePage.verifyRecommendedSectionIsAvailable(),"Verified Recommended Section is available.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to Recommended Section.");
		browsePage.scrollDownToOTCSection();
		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Recommended Disclosure is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifyRecommendedDisclosureIsDisplaying(),
//				"Verified Recommended Disclosure is displaying");
		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Recommended Disclosure is Clickable.");
//		ErrorCollector.verifyTrue(browsePage.verifyRecommendedDisclosureIsClickable(),
//				"Verified Recommended Disclosure is Clickable");
	}
	
//	@Test(priority = 58) Obsolete Recommended Test case
	public void ExistingUser_RecommendedSection() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-976\">QAA-976 : [iOS] - While user logged in with existing user, Verify the 'Recommended' section on browse screen</a>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		
		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		
		int step = loginPage.loginToApplication(0, email, password, pinCode);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
		
		ErrorCollector.extentLogInfo("Steps " + (++step) + " : Verify Recommended Section is available.");
		ErrorCollector.verifyTrue(browsePage.verifyRecommendedSectionIsAvailable(),"Verified Recommended Section is available.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to Recommended Section.");
		browsePage.scrollDownToOTCSection();
		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Recommended Disclosure is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifyRecommendedDisclosureIsDisplaying(),
//				"Verified Recommended Disclosure is displaying");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Recommended Disclosure is Clickable.");
//		ErrorCollector.verifyTrue(browsePage.verifyRecommendedDisclosureIsClickable(),
//				"Verified Recommended Disclosure is Clickable");
	}

	@Test(priority = 59)
	public void NewUser_SectorsSection() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-956\">QAA-956 : [iOS] - While user logged in with new user, Verify the 'Sectors' section on browse screen</a>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		String [] sectors = {"Information Technology","Consumer Discretionary","Communication Services","Energy","Financials","Utilities","Health Care","Consumer Staples","Industrials","Materials","Real Estate"};
		

		String email = PropertiesReader.getPropertyValue(env+"_NewUserEmailId");
		String password = PropertiesReader.getPropertyValue(env+"_NewUserPassword");
		
		int step = 0;
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : <b>Login With New User Credentials</b>.");
		step = loginPage.loginToApplication(step, email, password);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to Sectors Section.");
		browsePage.scrollDownToSectorsSection();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Sectors' section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySectorsSectionIsDisplaying(),
				"Verified 'Sectors' section is displaying");
		
		for (String sector : sectors) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify category '"+sector+"' is available.");
			ErrorCollector.verifyTrue(browsePage.verifySectorCategoryIsDisplaying(sector),
					"Verified category '"+sector+"' is available.");
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify category '"+sector+"' is clickable.");
			ErrorCollector.verifyTrue(browsePage.verifySectorCategoryIsClickable(sector),
					"Verified category '"+sector+"' is clickable.");
			
			browsePage.swipeRightForEmergingThemes(sector);
		}
	}
	
	@Test(priority = 59)
	public void ExistingUser_SectorsSection() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-978\">QAA-978 : [iOS] - While user logged in with existing user, Verify the 'Sectors' section on browse screen</a>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		String [] sectors = {"Information Technology","Consumer Discretionary","Communication Services","Energy","Financials","Utilities","Health Care","Consumer Staples","Industrials","Materials","Real Estate"};
		

		String email = PropertiesReader.getPropertyValue(env+"_NewUserEmailId");
		String password = PropertiesReader.getPropertyValue(env+"_NewUserPassword");
		
		int step = 0;
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : <b>Login With New User Credentials</b>.");
		step = loginPage.loginToApplication(step, email, password);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to Sectors Section.");
		browsePage.scrollDownToSectorsSection();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Sectors' section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySectorsSectionIsDisplaying(),
				"Verified 'Sectors' section is displaying");
		
		for (String sector : sectors) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify category '"+sector+"' is available.");
			ErrorCollector.verifyTrue(browsePage.verifySectorCategoryIsDisplaying(sector),
					"Verified category '"+sector+"' is available.");
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify category '"+sector+"' is clickable.");
			ErrorCollector.verifyTrue(browsePage.verifySectorCategoryIsClickable(sector),
					"Verified category '"+sector+"' is clickable.");
			
			browsePage.swipeRightForEmergingThemes(sector);
		}
	}
	

	@Test(priority = 60)
	public void NewUser_GeographySection() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-958\">QAA-958 : [iOS] - While user logged in with new user, Verify the 'Geography' section on browse screen</a>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		String [] sectors = {"US","East Asia","Latin America","UK","North America","Europe","Australia","South Asia","South East Asia","Global","Africa"};
		String email = PropertiesReader.getPropertyValue(env+"_NewUserEmailId");
		String password = PropertiesReader.getPropertyValue(env+"_NewUserPassword");
		
		int step = 0;
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : <b>Login With New User Credentials</b>.");
		step = loginPage.loginToApplication(step, email, password);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on GREATE! button in modal.");
//		signup.clickOnGreateButtonInModal();
//		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Done' button in modal.");
//		signup.clickOnDoneButtonInModal();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
	
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to Geography Section.");
		browsePage.scrollDownToGeographyection();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Geography' section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyGeographySectionIsDisplaying(),
				"Verified 'Sectors' section is displaying");
		
		for (String sector : sectors) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify category '"+sector+"' is available.");
			ErrorCollector.verifyTrue(browsePage.verifySectorCategoryIsDisplaying(sector),
					"Verified category '"+sector+"' is available.");
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify category '"+sector+"' is clickable.");
			ErrorCollector.verifyTrue(browsePage.verifySectorCategoryIsClickable(sector),
					"Verified category '"+sector+"' is clickable.");
			browsePage.swipeRightForEmergingThemes(sector);
		}
	}
	
	@Test(priority = 60)
	public void ExistingUser_GeographySection() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-980\">QAA-980 : [iOS] - While user logged in with existing user, Verify the 'Geography' section on browse screen</a>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		String [] sectors = {"US","East Asia","Latin America","UK","North America","Europe","Australia","South Asia","South East Asia","Global","Africa"};
		
		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		
		int step = loginPage.loginToApplication(0, email, password, pinCode);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
	
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to Geography Section.");
		browsePage.scrollDownToGeographyection();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Geography' section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyGeographySectionIsDisplaying(),
				"Verified 'Sectors' section is displaying");
		
		for (String sector : sectors) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify category '"+sector+"' is available.");
			ErrorCollector.verifyTrue(browsePage.verifySectorCategoryIsDisplaying(sector),
					"Verified category '"+sector+"' is available.");
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify category '"+sector+"' is clickable.");
			ErrorCollector.verifyTrue(browsePage.verifySectorCategoryIsClickable(sector),
					"Verified category '"+sector+"' is clickable.");
			browsePage.swipeRightForEmergingThemes(sector);
		}
	}
	
	@Test(priority = 61)
	public void NewUser_EmergingThemeSection() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-960\">QAA-960 : [iOS] - While user logged in with new user, Verify the 'Emerging Themes' details screen</a>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		String [] sectors = {"Crypto","Artificial Intelligence","Cloud Computing","Future Mobility","Cannabis","CRISPR","Factor","Electric Vehicles"};
		
		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = PropertiesReader.getPropertyValue(env+"_NewUserEmailId");
		String password = PropertiesReader.getPropertyValue(env+"_NewUserPassword");
		
		int step = 0;
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : <b>Login With New User Credentials</b>.");
		step = loginPage.loginToApplication(step, email, password);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on GREATE! button in modal.");
//		signup.clickOnGreateButtonInModal();
//		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Done' button in modal.");
//		signup.clickOnDoneButtonInModal();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
	
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to Emerging Themes Section.");
		browsePage.scrollDownToEmergingThemesSection();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Emerging Themes' section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyEmergingThemesSectionIsAvailable(),
				"Verified 'Emerging Themes' section is displaying");
		
		for (String sector : sectors) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify category '"+sector+"' is available.");
			ErrorCollector.verifyTrue(browsePage.verifySectorCategoryIsDisplaying(sector),
					"Verified category '"+sector+"' is available.");
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify category '"+sector+"' is clickable.");
			ErrorCollector.verifyTrue(browsePage.verifySectorCategoryIsClickable(sector),
					"Verified category '"+sector+"' is clickable.");
			
			browsePage.swipeRightForEmergingThemes(sector);
		}
	}
	
	@Test(priority = 62)
	public void NewUser_ETFProvidersSection() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-962\">QAA-962 : [iOS] - While user logged in with new user, Verify the 'ETF Providers' details screen</a>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		String [] sectors = {"Vanguard","Others","iShares","Fidelity","Schwab","Morgan Stanley"};
		String email = "ramya.reddy+io4@vestedfinance.co";
		String password = "iTestUser1!";
		String pincode = "111111";
		int step = 0;
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup button displaying.");
//		ErrorCollector.verifyTrue(signup.verifySignUpButtonShowing(), "Verified Signup button displaying");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up button.");
//		waitTime(3000);
//		signup.clickOnSignUpButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup with Email button displaying.");
//		ErrorCollector.verifyTrue(signup.verifySignUpWithEmailButtonShowing(),
//				"Verified Signup with Email button displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up With Email button.");
//		signup.clickOnSignUpWithEmailButton();
//
//		String email = getUniqueEmailId("Test");
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter email address : " + email);
//		signup.enterEmailAddress(email);
//
//		String password = getUniquePassword();
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + password);
//		signup.enterPassword(password);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign Up button.");
//		signup.clickOnSubmitSignupButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Verification Code screen is displaying.");
//		ErrorCollector.verifyTrue(signup.verifyOTPScreenIsDisplaying(),
//				"Verify Verification Code screen is displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Back button.");
//		waitTime(3000);
//		signup.clickOnBackButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Back button.");
//		waitTime(1000);
//		signup.clickOnBackButton();


//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login button.");
//		loginPage.clickOnLoginButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : <b>Login With New User Credentials</b>.");
		step = loginPage.loginToApplication(step, email, password, pincode);
		
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter email address : " + email);
//		signup.enterEmailAddress(email);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + password);
//		signup.enterPassword(password);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login button.");
//		loginPage.clickOnLoginSubmitButton();
		
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'START KYC' button is displaying.");
//		ErrorCollector.verifyTrue(loginPage.verifyStarKYCButton(), "Verified 'START KYC' button is displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'EXPLORE PLATFORM' button is displaying.");
//		ErrorCollector.verifyTrue(loginPage.verifyExplorePlatformButton(),
//				"Verified 'EXPLORE PLATFORM' button is displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Explore the Platform' button.");
//		browsePage.clickOnExplorePlatformButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Accept and Proceed' button.");
//		browsePage.clickOnAcceptAndProceedButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Ok' button in popup.");
//		signup.clickOnOkButtonInTermsAcceptedModal();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'AWESOME!' button in popup.");
//		signup.clickOnAwesomeButtonInModal();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on GREATE! button in modal.");
		signup.clickOnGreateButtonInModal();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Done' button in modal.");
		signup.clickOnDoneButtonInModal();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
	
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to ETF Providers Section.");
		browsePage.scrollDownToETFSection();
		swipeUpLess();
		swipeUpLess();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'ETF Providers' section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyETFSectionIsDisplaying(),
				"Verified 'ETF Providers' section is displaying");
		
		for (int i=0;i<sectors.length;i++) {
			String sector = sectors[i];
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify category '"+sector+"' is available.");
			ErrorCollector.verifyTrue(browsePage.verifySectorCategoryIsDisplaying(sector),
					"Verified category '"+sector+"' is available.");
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify category '"+sector+"' is clickable.");
			ErrorCollector.verifyTrue(browsePage.verifySectorCategoryIsClickable(sector),
					"Verified category '"+sector+"' is clickable.");
			
			browsePage.swipeRightForETFs(sector);
		}
	}
	
	@Test(priority = 63)
	public void NewUser_IncomeFocusedSection() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-964\">QAA-964 : [iOS] - While user logged in with new user, Verify the 'Income Focused' details screen</a>");
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		String [] sectors = {"Dividends","Real Estate","Bonds"};
		
		String email = PropertiesReader.getPropertyValue(env+"_NewUserEmailId");
		String password = PropertiesReader.getPropertyValue(env+"_NewUserPassword");
		
		int step = 0;
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : <b>Login With New User Credentials</b>.");
		step = loginPage.loginToApplication(step, email, password);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on GREATE! button in modal.");
//		signup.clickOnGreateButtonInModal();
//		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Done' button in modal.");
//		signup.clickOnDoneButtonInModal();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(),
				"Verified Browse Page is displaying");
	
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Scroll down to Income Focused Section.");
		browsePage.scrollDownToIncoeFocusSection();
		swipeUpLess();
		swipeUpLess();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Income Focused' section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyIncomeFocusIsDisplaying(),
				"Verified 'Income Focused' section is displaying");
		
		for (int i=0;i<sectors.length;i++) {
			if(i%3==0) {
				swipeRightAtBottom();
			}
			String sector = sectors[i];
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify category '"+sector+"' is available.");
			ErrorCollector.verifyTrue(browsePage.verifySectorCategoryIsDisplaying(sector),
					"Verified category '"+sector+"' is available.");
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify category '"+sector+"' is clickable.");
			ErrorCollector.verifyTrue(browsePage.verifySectorCategoryIsClickable(sector),
					"Verified category '"+sector+"' is clickable.");
		}
	}
	
	
	
}
