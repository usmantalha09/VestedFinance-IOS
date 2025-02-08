package com.investor.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.investor.base.BaseClass;
import com.investor.base.BaseClass.Direction;
import com.investor.base.PropertiesReader;
import com.investor.errorCollectors.ErrorCollector;
import com.investor.pages.DIYVestPage;
import com.investor.pages.ExplorePage;
import com.investor.pages.KYCUserPurchaseStockPage;
import com.investor.pages.KYCUserViewPage;
import com.investor.pages.LoginPage;
import com.investor.pages.SignupPage;

public class Test_KYCUserView extends BaseClass {
	@Test
	public void VerifyKYCUserViewThemeBasedVest() throws IOException {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-141\">QAA-141 : [iOS] Verify KYC-approved funded account user is able to view a Vests - Theme based<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		KYCUserViewPage KYCUserViewPage = new KYCUserViewPage();
		KYCUserPurchaseStockPage kycUserPurchaseStockPage = new KYCUserPurchaseStockPage();
		

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
		mobileScrollScreenIOS(Direction.DOWN);
		waitTime(3000);
		mobileScrollScreenIOS(Direction.DOWN);
		waitTime(3000);
		mobileScrollScreenIOS(Direction.DOWN);
		
//		scrollUp();
		waitTime(3000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Random Vest Under Theme' button.");
		KYCUserViewPage.clickOnRandomVestUnderTheme();
//		scrollHorizontalList("FAANG - Rebalance");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Create Recurring Investment Button' is displaying.");
		ErrorCollector.verifyTrue(KYCUserViewPage.verifyCreateRecurringInvestmentButtonIsDisplaying(), "Verified 'Create Recurring Investment Button' is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Max' Popup");
		KYCUserViewPage.clickOnvestGraphMaxButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Max Graph' is displaying.");
		ErrorCollector.verifyTrue(KYCUserViewPage.verifyOverviewGraphIsDisplaying(), "Verified 'Max Graph' is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on '1Y' Popup");
		KYCUserViewPage.clickOnVestGraph1YearButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '1Y Graph' is displaying.");
		ErrorCollector.verifyTrue(KYCUserViewPage.verifyOverviewGraphIsDisplaying(), "Verified '1Y Graph' is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on '3M' Popup");
		KYCUserViewPage.clickOnVestGraph3MonthButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '3M Graph' is displaying.");
		ErrorCollector.verifyTrue(KYCUserViewPage.verifyOverviewGraphIsDisplaying(), "Verified '3M Graph' is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on '1M' Popup");
		KYCUserViewPage.clickOnVestGraph1MonthButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '1M Graph' is displaying.");
		ErrorCollector.verifyTrue(KYCUserViewPage.verifyOverviewGraphIsDisplaying(), "Verified '1M Graph' is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on '1W' Popup");
		KYCUserViewPage.clickOnVestGraph1WeekButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '1W Graph' is displaying.");
		ErrorCollector.verifyTrue(KYCUserViewPage.verifyOverviewGraphIsDisplaying(), "Verified '1W Graph' is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'I' Popup");
		KYCUserViewPage.clickOnIPopupButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Vest Performance Chart Title' is displaying.");
		ErrorCollector.verifyTrue(KYCUserViewPage.verifyVestPerformanceChartTitleIsDisplaying(), "Verified 'Vest Performance Chart Title' is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'I' Popup 'Close' Button");
		KYCUserViewPage.clickOnIPopupCloseButton();
		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Share' button.");
//		KYCUserViewPage.clickOnShareButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Share link Copy' button is clickable.");
//		ErrorCollector.verifyTrue(KYCUserViewPage.ShareCopyButtonIsClickable(),"Verified Share link copy button is clickable.");
		
	}

	
	@Test
	public void VerifyKYCUserViewMultiAssetClassVest() throws IOException {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-139\">QAA-139 : [iOS] Verify KYC-approved funded account user is able to view a Vests - Multi-Asset class<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		DIYVestPage diyVestPage = new DIYVestPage();
		KYCUserViewPage KYCUserViewPage = new KYCUserViewPage();
		KYCUserPurchaseStockPage kYCUserPurchaseStockPage = new KYCUserPurchaseStockPage();
		

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();		
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String Value;
		String shareValue = "1";

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

		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Random Multi Asset Class Vest'.");
		kYCUserPurchaseStockPage.clickOnMultiAssetClassVestAtIndex(0);
		

//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Create Recurring Investment' button.");
//		KYCUserViewPage.clickVestDetailsCreateRecurringInvestmentButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Create Recurring Investment dialog is displaying.");
//		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyStartNewRecInvestmentDialogDisplaying(),"Verified Create Recurring Investment dialog is displaying.");;
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Back' button.");
//		KYCUserViewPage.clickOnBackButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Buy button is displaying.");
		ErrorCollector.verifyTrue(KYCUserViewPage.verifyVestBuyButtonIsDisplaying(),"Verified Buy button is displaying.");;
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Distribution graph' is displaying.");
		ErrorCollector.verifyTrue(KYCUserViewPage.verifyMultiAssetVestOverviewGraphIsDisplaying(), "Verified 'Distribution graph' is displaying.");

		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Compare Vests' button.");
		KYCUserViewPage.clickOnCompareVestsButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Pop-up have all 3 vests listed.");
		ErrorCollector.verifyTrue(KYCUserViewPage.verifyConservativeVestInComparePortfolioModalIsDisplaying(),"Verified 'Conservative' vest is displaying in compare modal.");
		ErrorCollector.verifyTrue(KYCUserViewPage.verifyModerateVestInComparePortfolioModalIsDisplaying(),"Verified 'Moderate' vest is displaying in compare modal.");
		ErrorCollector.verifyTrue(KYCUserViewPage.verifyAggressiveVestInComparePortfolioModalIsDisplaying(),"Verified 'Aggressive' vest is displaying in compare modal.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Close' modal button.");
		KYCUserViewPage.clickOnCloseModalButton();


		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on comparing vest VBNIX 'i' icon.");
		swipeUpLess();
		KYCUserViewPage.clickOnVBNIXInfoIcon();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify info pop-up is displaying.");
		ErrorCollector.verifyTrue(KYCUserViewPage.verifyVBNIXInfoPopup(),"Verified comparing vest VBNIX info pop-up is displaying.");;
		
		

	}

}
