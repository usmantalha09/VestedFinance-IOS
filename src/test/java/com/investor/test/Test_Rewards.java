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

public class Test_Rewards extends BaseClass{

	@Test
	public void RewardsScreenAndFlowOfReferralAndEarn() {

		initReport();
		initConfiguration();
		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-707\">QAA-707 : [IOS] - Verify the Rewards screen and flow of referral and earn</a>");

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
		
		ErrorCollector.extentLogInfo("Step " + step + " : Click on Earn Tab");
		browsePage.clickOnRewardsEarnTab();
		
		ErrorCollector.extentLogInfo("Step " + step + " : Verify 'View Details' button is displaying.");
		ErrorCollector.verifyTrue(browsePage.veriyReferralDetailsButtonIsDisplaying(),"Verified 'View Details' button is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + step + " : Click on View Details button");
		browsePage.clickOnRewardsViewDetailsButton();
		
		swipeDownSlightly();
		scrollDown();
		swipeScreen(Direction.DOWN);
		
		scrollDownToText("Referral disclosure");
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step " + step + " : Verify 'Referrals' page is displaying.");
		ErrorCollector.verifyTrue(browsePage.veriyReferralsPageIsDisplaying(),"Verified 'Referrals' page is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + step + " : Verify 'Referrals' page is displaying.");
		ErrorCollector.verifyTrue(browsePage.veriyReferralsPageIsDisplaying(),"Verified 'Referrals' page is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + step + " : Verify 'Invite' button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyInviteButtonIsDisplaying(),"Verified 'Invite' button is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + step + " : Verify 'Invite' button is clickable.");
		ErrorCollector.verifyTrue(browsePage.verifyInviteButtonIsEnabled(),"Verified 'Invite' button is clickable.");

		ErrorCollector.extentLogInfo("Step " + step + " : Verify 'FAQ' button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyFAQButtonIsDisplaying(),"Verified 'FAQ' button is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + step + " : Verify 'FAQ' button is clickable.");
		ErrorCollector.verifyTrue(browsePage.verifyFAQButtonIsEnabled(),"Verified 'FAQ' button is clickable.");

		ErrorCollector.extentLogInfo("Step " + step + " : Verify 'Referral Disclosure' button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyReferralDisclosureButtonIsDisplaying(),"Verified 'Referral Disclosure' button is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + step + " : Verify 'Referral Disclosure' button is clickable.");
		ErrorCollector.verifyTrue(browsePage.verifyReferralDisclosureButtonIsEnabled(),"Verified 'Referral Disclosure' button is clickable.");
		
		ErrorCollector.extentLogInfo("Step " + step + " : Click on 'Invite' button.");
		browsePage.clickOnInviteButton();
		
		ErrorCollector.extentLogInfo("Step " + step + " : Verify 'Copy' button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyCopyButtonIsDisplaying(),"Verified 'Copy' button is displaying.");
		
		
	}
	

}
