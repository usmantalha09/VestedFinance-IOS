package com.investor.test;

import org.testng.annotations.Test;

import com.investor.base.BaseClass;
import com.investor.base.BaseClass.Direction;
import com.investor.base.PropertiesReader;
import com.investor.errorCollectors.ErrorCollector;
import com.investor.listeners.ExtentListeners;
import com.investor.pages.ExplorePage;
import com.investor.pages.KYCUserPurchaseStockPage;
import com.investor.pages.LoginPage;
import com.investor.pages.SignupPage;
import com.investor.utilities.Waits;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Test_Profile extends BaseClass{


	/*@Test(priority = 5)
	public void VerifyLinks_TaxDocuments() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-423\">QAA-423 : iOS - Verify all links are working correctly in tax documents.<a/>");

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
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on General Tab in Profile Menu.");
		browsePage.clickOnGeneralTab();

		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Tax Documents button.");
		browsePage.clickOnProfileTaxDocumentsButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Tax Documents Page is displaying.");
		waitTime(5000);
		ErrorCollector.verifyTrue(browsePage.verifyTaxDocumentsHeadingIsDisplaying(),
				"Verified Tax Documents Page is displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on latest tax document.");
		browsePage.clickOnLatestTaxDocument();
		
		if(browsePage.verifyNoDocAvailable() == true) {
			ErrorCollector.extentLogInfo("<font color=red>Document Is not Available</font>");
		}else {
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify supporting Tax Documents Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySupportingTaxDocumentsHeadingIsDisplaying(),
				"Verified supporting Tax Documents Page is displaying.");
			
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on General Filings Summary (PDF).");
		browsePage.clickOnGeneralFilingSummaryPDF();
		waitTime(4000);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify General Filings Summary (PDF) is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyTaxDocumentPDFDisplaying(),"Verified General Filings Summary (PDF) is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Cancel button.");
		browsePage.clickOnTaxDocViewCancelButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on General Filings Summary (XLSX).");
		browsePage.clickOnGeneralFilingSummaryXLSX();
		waitTime(4000);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify General Filings Summary (XLSX) is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyTaxDocumentXLSXDisplaying(),"Verified General Filings Summary (XLSX) is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Cancel button.");
		browsePage.clickOnTaxDocViewCancelButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Foreign Assets Filing Summary (XLSX).");
		browsePage.clickOnForiegnAssetsFilingSummaryXLSX();
		waitTime(4000);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Foreign Assets Filing Summary (XLSX) is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyTaxDocumentXLSXDisplaying(),"Verified Foreign Assets Filing Summary (XLSX) is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Cancel button.");
		browsePage.clickOnTaxDocViewCancelButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Foreign Source of Income Filing Summary (XLSX).");
		browsePage.clickOnForiegnSourceOfIncomeFilingSummaryXLSX();
		waitTime(4000);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Foreign Source of Income Filing Summary (XLSX) is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyTaxDocumentXLSXDisplaying(),"Verified Foreign Source of Income Filing Summary (XLSX) is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Cancel button.");
		browsePage.clickOnTaxDocViewCancelButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Form 67 Filing Summary (XLSX).");
		browsePage.clickOnForm67FilingSummaryXLSX();
		waitTime(4000);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Form 67 Filing Summary (XLSX) is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyTaxDocumentXLSXDisplaying(),"Verified Form 67 Filing Summary (XLSX) is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Cancel button.");
		browsePage.clickOnTaxDocViewCancelButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Schedule TR Filing Summary (XLSX).");
		browsePage.clickOnScheduleTRFilingSummaryXLSX();
		waitTime(4000);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Schedule TR  Filing Summary (XLSX) is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyTaxDocumentXLSXDisplaying(),"Verified Schedule TR  Filing Summary (XLSX) is displaying.");
		}
	}*/
	
	@Test(priority = 5)
	public void VerifyDifferentUserProfileBasicPlan() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-231\">QAA-231 IOS- Verify Different user Profiles - Basic Plan<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		KYCUserPurchaseStockPage kYCUserPurchaseStockPage = new KYCUserPurchaseStockPage();

		String validinvestAmount = "50";


		Object[][] dataArr = getData("testData", "TestData");
		String email ="vested.automation+w02@gmail.com";// dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_NonPremiumEmailId");
			password = PropertiesReader.getPropertyValue(env+"_NonPremiumPassword");
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
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Profile Menu button.");
		browsePage.clickOnProfileMenuButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on General Tab in Profile Menu.");
		browsePage.clickOnGeneralTab();

		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Go Premium' button.");
		browsePage.clickOnGoPremiumBtn();
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Select a plan page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySelectAPlanPage(), "Verified Select a plan page is displaying.");
		
		swipeScreen(Direction.DOWN);
		
		scrollDownToText("Get Premium Plan");
	
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Price under premium is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyPriceGoPremiumPage(), "Verified Price under premium is displaying.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Back' button.");
		browsePage.clickOnBackBtnPremiumPage();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Back' button.");
		browsePage.clickOnBackButton();
		
		
		mobileScrollScreenIOS(Direction.DOWN);
		scrollToText("MULTI-ASSET CLASS VESTS");
		waitTime(3000);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Multi Asset Class Vest.");
		kYCUserPurchaseStockPage.clickOnMultiAssetClassVestAtIndex(0);

		waitTime(3000);
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Buy button");
//		new TouchAction(driver).tap(PointOption.point(194, 786)).perform();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Pop up message is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifyBuyPop(), "Verified Pop up message is displaying.");
//
//		new TouchAction(driver).tap(PointOption.point(370, 70)).perform();
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Back' button.");
		kYCUserPurchaseStockPage.pressBack();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Multi Asset Class Vest.");
		kYCUserPurchaseStockPage.clickOnMultiAssetClassVestAtIndex(1);

		waitTime(3000);
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Buy button");
//		new TouchAction(driver).tap(PointOption.point(194, 786)).perform();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Pop up message is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifyBuyPop(), "Verified Pop up message is displaying.");
//
//		new TouchAction(driver).tap(PointOption.point(370, 70)).perform();


		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Back' button.");
		kYCUserPurchaseStockPage.pressBack();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Multi Asset Class Vest.");
		kYCUserPurchaseStockPage.clickOnMultiAssetClassVestAtIndex(2);

		waitTime(3000);
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Buy button");
//		new TouchAction(driver).tap(PointOption.point(194, 786)).perform();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Pop up message is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifyBuyPop(), "Verified Pop up message is displaying.");
//
//		new TouchAction(driver).tap(PointOption.point(370, 70)).perform();
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Back' button.");
		kYCUserPurchaseStockPage.pressBack();
		
		mobileScrollScreenIOS(Direction.DOWN);
		scrollToText("THEME-BASED VESTS");
		waitTime(3000);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on First Theme Based Vest.");
		kYCUserPurchaseStockPage.clickOnFirstThemeBasedVest();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Back' button.");
		kYCUserPurchaseStockPage.pressBack();

//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Buy button");
//		kYCUserPurchaseStockPage.clickOnVestBuyButton();
//		Waits.wait3s();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter investment amount: " + validinvestAmount);
//		kYCUserPurchaseStockPage.enterInvestAmount(validinvestAmount);
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Preview Order button");
//		kYCUserPurchaseStockPage.clickOnPreviewOrderButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Save and subscribe button");
//		browsePage.clickOnSubscribeSaveButton();
//
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Plan upgrade page is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifySelectAPlanPage(), "Verified plan upgrade page is displaying.");
//
//
//		kYCUserPurchaseStockPage.goBack(4);
//
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Transfer Tab");
		browsePage.clickOnTransferMenuButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Withdraw fund");
		browsePage.clickOnWithdrawFund();

		
	}
	
	

}
