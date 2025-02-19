package com.investor.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.errorCollectors.ErrorCollector;
import com.investor.listeners.ExtentListeners;
import com.investor.pages.ExplorePage;
import com.investor.pages.FundTransferPage;
import com.investor.pages.LoginPage;
import com.investor.pages.SignupPage;
import com.investor.utilities.Constants;
import com.investor.utilities.SlackUtils;
import com.slack.api.methods.SlackApiException;

public class Test_FundsAvailabilityVerification extends BaseClass {

	@Test
	public void Test_BuildNumber() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-825\">QAA-825 : Android - Add build Number screenshot in the Android and iOS reports<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		FundTransferPage fundTransferPage = new FundTransferPage();

		Object[][] dataArr = getData("testData", "TestData");
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
			pinCode = PropertiesReader.getPropertyValue(env + "_Pin");

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
		loginPage.clickOnLoginButton();
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Enter Pin Code  : " + pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(), "Verified home page is displaying.");
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Click on Profile Menu button.");
		browsePage.clickOnProfileMenuButton();
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Verify Profile Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyProfilePageIsDisplaying(), "Verified Profile Page is displaying");
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Verify General Tab is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyGeneralTabIsDisplaying(), "Verified General Tab is displaying");
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Click on General Tab.");
		browsePage.clickGeneralTab();

		ExtentListeners.attachScreenShot("Build Number Screenshot");

	}

	@Test(priority = 1, groups = "IsCashAvailable")
	public void VerifyFundsAvailable_Premium() throws IOException, SlackApiException {

		initReport();
		initConfiguration();
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-511\">QAA-511.1 : iOS - Verify Funds Available For Premium Account<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		FundTransferPage fundTransferPage = new FundTransferPage();

		Object[][] dataArr = getData("testData", "TestData");
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}
		Double VestedBalance = 0.0;
		Double BuyingPower = 0.0;
		Double UnsettledCash = 0.0;
		String slackMessage = "";

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
		loginPage.clickOnLoginButton();
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Enter Pin Code  : " + pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(), "Verified home page is displaying.");

		BuyingPower = browsePage.getBuyingPower();
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Buying Power: " + BuyingPower);

		if (!(BuyingPower > 1000)) {
			slackMessage = browsePage.getSlackMessage(email, env, "Buying Power");
			printString(slackMessage);
			SlackUtils.SendSlackMessage(slackMessage);
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verifying Buying Power must be greater than 1000");
			ErrorCollector.extentLogInfo(Constants.premiumSkippedTestCases);
			ErrorCollector.verifyTrue(BuyingPower > 1000, "Buying Power is not greater than 1000 in " + env);
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verified:  Buying Power must be greater than 1000");
		}

		UnsettledCash = browsePage.getUnSettledCash();
		ErrorCollector.extentLogInfo("Step " + (++step) + " : UnSettled Cash: " + UnsettledCash);
		ErrorCollector
				.extentLogInfo("Step " + (++step) + " : Verifing BuyingPower must be greater than Unsettled Cash");
		ErrorCollector.verifyTrue(BuyingPower >= UnsettledCash, "Buying Power is not greater than UnSettled Cash");
		ErrorCollector
				.extentLogInfo("Step " + (++step) + " : Verified:  BuyingPower must be greater than Unsettled Cash");

		step++;
		ErrorCollector.extentLogInfo("Step " + step + " : Click on Transfer Menu button.");
		browsePage.clickOnTransferMenuButton();
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Verify Transfer Page is displaying.");
		waitTime(4000);
		ErrorCollector.verifyTrue(browsePage.verifyTransferPageIsDisplaying(), "Verified Transfer Page is displaying");
		step++;

		VestedBalance = browsePage.getTranferBalance();
		ErrorCollector.extentLogInfo("Step " + step + " : Current Balance = " + VestedBalance);

		if (!(VestedBalance > 2000)) {
			slackMessage = browsePage.getSlackMessage(email, env, "Funds");
			printString(slackMessage);
			SlackUtils.SendSlackMessage(slackMessage);
			ErrorCollector.extentLogInfo(Constants.premiumSkippedTestCases);
			ErrorCollector.assertTrue(VestedBalance > 2000, "Available Amount is not enough to execute all Test cases");
		}

	}

	@Test(priority = 2, groups = "IsCashAvailableNonPremium")
	public void VerifyFundsAvailable_NonPremium() throws IOException, SlackApiException {

		initReport();
		initConfiguration();
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-511\">QAA-511.2 : iOS - Verify Funds Available For Non Premium Account<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		FundTransferPage fundTransferPage = new FundTransferPage();

		Object[][] dataArr = getData("testData", "TestData");
		String email = "vested.automation+w02@gmail.com";
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		Double VestedBalance = 0.0;
		Double BuyingPower = 0.0;
		Double UnsettledCash = 0.0;

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_NonPremiumEmailId");
			password = PropertiesReader.getPropertyValue(env + "_NonPremiumPassword");
			pinCode = PropertiesReader.getPropertyValue(env + "_Pin");
		}

		String slackMessage = "";

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
		loginPage.clickOnLoginButton();
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Enter Pin Code  : " + pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(), "Verified home page is displaying.");

		BuyingPower = browsePage.getBuyingPower();
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Buying Power: " + BuyingPower);

		if (BuyingPower > 1000) {
			slackMessage = browsePage.getSlackMessage(email, env, "Buying Power");
			printString(slackMessage);
			SlackUtils.SendSlackMessage(slackMessage);
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verifying Buying Power must be greater than 1000");
			ErrorCollector.extentLogInfo(Constants.nonPremiumSkippedTestCases);
			ErrorCollector.verifyTrue(BuyingPower > 1000, "Buying Power is not greater than 1000 in " + env);
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verified:  Buying Power must be greater than 1000");
		}

		UnsettledCash = browsePage.getUnSettledCash();
		ErrorCollector.extentLogInfo("Step " + (++step) + " : UnSettled Cash: " + UnsettledCash);
		ErrorCollector
				.extentLogInfo("Step " + (++step) + " : Verifing Buying Power must be greater than Unsettled Cash");
		ErrorCollector.verifyTrue(BuyingPower >= UnsettledCash, "Buying Power is not greater than UnSettled Cash");
		ErrorCollector
				.extentLogInfo("Step " + (++step) + " : Verified:  Buying Power must be greater than Unsettled Cash");

		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Click on Transfer Menu button.");
		browsePage.clickOnTransferMenuButton();
		step++;

		ErrorCollector.extentLogInfo("Step " + step + " : Verify Transfer Page is displaying.");
		waitTime(4000);
		ErrorCollector.verifyTrue(browsePage.verifyTransferPageIsDisplaying(), "Verified Transfer Page is displaying");
		step++;

		VestedBalance = browsePage.getTranferBalance();
		ErrorCollector.extentLogInfo("Step " + step + " : Current Balance = " + VestedBalance);

		if (VestedBalance > 2000) {
			slackMessage = browsePage.getSlackMessage(email, env, "Funds");
			printString(slackMessage);
			SlackUtils.SendSlackMessage(slackMessage);
			ErrorCollector.extentLogInfo(Constants.nonPremiumSkippedTestCases);
			ErrorCollector.assertTrue(VestedBalance > 2000, "Available Amount is not enough to execute all Test cases");
		}

	}

}
