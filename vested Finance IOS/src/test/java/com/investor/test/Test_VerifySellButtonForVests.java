package com.investor.test;

import org.testng.annotations.Test;

import com.investor.base.BaseClass;
import com.investor.base.BaseClass.Direction;
import com.investor.base.PropertiesReader;
import com.investor.errorCollectors.ErrorCollector;
import com.investor.listeners.ExtentListeners;
import com.investor.pages.DIYVestPage;
import com.investor.pages.ExplorePage;
import com.investor.pages.KYCUserPurchaseStockPage;
import com.investor.pages.LoginPage;
import com.investor.pages.SignupPage;
import com.investor.utilities.Waits;

import io.appium.java_client.pagefactory.bys.builder.AppiumByBuilder;

public class Test_VerifySellButtonForVests extends BaseClass{
	
	@Test
	public void VerifySellButtonForThemeBasedVests() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-429\">QAA-429 : [IOS] Verify Sell Button For Theme based Vests<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage explorePage = new ExplorePage();
		KYCUserPurchaseStockPage kYCUserPurchaseStockPage = new KYCUserPurchaseStockPage();

		Object[][] dataArr = getData(TestDataFileName,testDataSheet);
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
		mobileScrollScreenIOS(Direction.DOWN);
		mobileScrollScreenIOS(Direction.DOWN);
		scrollToText("THEME-BASED VESTS");
		waitTime(3000);
		
		String vestName = kYCUserPurchaseStockPage.getThemeBasedVestNameAtIndex(0);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : verify vest '"+vestName+" invested");
		boolean investStatus = kYCUserPurchaseStockPage.getThemeBasedVestInvestedStatusAtIndex(0);
		if(investStatus) {
			ErrorCollector.verifyTrue(investStatus,vestName+" vest is 'invested'.");
			
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on "+vestName);
			kYCUserPurchaseStockPage.clickOnThemebasedVestAtIndex(0);


			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify BUY button is displaying for vest "+vestName);
			ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyBuyButtonIsShowingAtVestDetailsPage(),"Verified buy button is displaying for vest "+vestName);
			
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify SELL button is displaying for vest "+vestName);
			ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifySellButtonIsShowingAtVestDetailsPage(),"Verified buy button is displaying for vest "+vestName);
			
		}else {
			ErrorCollector.verifyFalse(investStatus,vestName+" vest is not 'invested'");
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on "+vestName);
			kYCUserPurchaseStockPage.clickOnThemebasedVestAtIndex(0);

			try {
				kYCUserPurchaseStockPage.clickOnSkipButton();
			}catch (Exception e){

			}

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify BUY button is displaying for vest "+vestName);
			ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyBuyButtonIsShowingAtVestDetailsPage(),"Verified buy button is displaying for vest "+vestName);
			
		}

	}

	
	@Test
	public void VerifySellButtonForMultiAssetsClasssVests() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-430\">QAA-430 : [IOS] Verify Sell Button For Multi Assets Class Vests Vests<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage explorePage = new ExplorePage();
		KYCUserPurchaseStockPage kYCUserPurchaseStockPage = new KYCUserPurchaseStockPage();

		Object[][] dataArr = getData(TestDataFileName,testDataSheet);
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
		mobileScrollScreenIOS(Direction.DOWN);
		scrollToText("MULTI-ASSET CLASS VESTS");
		waitTime(3000);
		
		String vestName = kYCUserPurchaseStockPage.getMultiAssetClassVestNameAtIndex(0);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : verify vest '"+vestName+" invested");
		boolean investStatus = kYCUserPurchaseStockPage.getMultiAssetClassVestInvestedStatusAtIndex(0);
		if(investStatus) {
			ErrorCollector.verifyTrue(investStatus,vestName+" vest is 'invested'.");
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on "+vestName);
			kYCUserPurchaseStockPage.clickOnMultiAssetClassVestAtIndex(0);
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify BUY button is displaying for vest "+vestName);
			ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyBuyButtonIsShowingAtMultiAsserClassVestDetailsPage(),"Verified buy button is displaying for vest "+vestName);
			
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify SELL button is displaying for vest "+vestName);
			ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifySellButtonIsShowingAtVestDetailsPage(),"Verified buy button is displaying for vest "+vestName);
			
		}else {
			ErrorCollector.verifyFalse(investStatus,vestName+" vest is not 'invested'");
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on "+vestName);
			kYCUserPurchaseStockPage.clickOnMultiAssetClassVestAtIndex(0);
			
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify BUY button is displaying for vest "+vestName);
			ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.verifyBuyButtonIsShowingAtMultiAsserClassVestDetailsPage(),"Verified buy button is displaying for vest "+vestName);
			
		}

	}
	

}