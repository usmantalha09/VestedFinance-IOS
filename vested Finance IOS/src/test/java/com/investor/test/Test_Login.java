package com.investor.test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.errorCollectors.ErrorCollector;
import com.investor.listeners.ExtentListeners;
import com.investor.pages.ExplorePage;
import com.investor.pages.LoginPage;


public class Test_Login extends BaseClass {
	LoginPage loginPage;

	@Test(priority = 1)
	public void Login_B2C_Email() {

		initReport();

		ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-11\"><b>QAA-11 : Verify that a user is successfully able to login into the B2C platform</b></a>");
		initConfiguration();
		LoginPage loginPage = new LoginPage();

		Object[][] dataArr = getData(testDataFile,testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}

		int step=0;
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(),"Verified Login button displaying");


		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();


		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();


		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+email);
		loginPage.enterEmailAddress(email);


		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+password);
		loginPage.enterPassword(password);


		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();


		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Pin Code  : "+pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);


		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified home page is displaying.");

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Close application.");

	}


	@Test(priority = 2)
	public void Login_AxisUser() {

		initReport();
		ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-15\"><b>QAA-15 : iOS - Verify that a user is successfully able to login into the B2B platform</b></a>");
		ErrorCollector.extentLogInfo("<b>Verify that a user is successfully able to login into the B2B platform</b>");

		initConfiguration();
		LoginPage loginPage = new LoginPage();


		Object [][] dataArr = getData(testDataB2BUser, testDataSheetB2BUser);
		String email = dataArr[0][4].toString();
		String pass = dataArr[0][5].toString();


		int step=0;
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(),"Verified Login button displaying");


		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();


		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();


		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+email);
		loginPage.enterEmailAddress(email);


		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+pass);
		loginPage.enterPassword(pass);


		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();

		try {
			loginPage.clickVestedWidget();

		} catch (Exception e) {
			// TODO: handle exception
		}




		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageB2BIsDisplaying(),"Verified home page is displaying.");

	}

	@Test(priority = 3)
	public void Login_B2B_Email() {

		initReport();
		ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-5\"><b>QAA-5 : Verify that a user is successfully able to login into the B2B platform</b></a>");
		Object [][] data = getData(testDataB2BUser, testDataSheetB2BUser);

		int step=1;

		for(int x=0;x<data.length;x++) {
			String userName = data[x][1].toString();
			String email = data[x][4].toString();
			String pass = data[x][5].toString();


			ErrorCollector.extentLogInfo("<b>Verify authentication for User : '"+userName+"' </b>");
			initConfiguration();
			loginPage = new LoginPage();
			ErrorCollector.extentLogInfo("Step "+(++step)+" : Launch application.");



			ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Login button is displaying.");
			ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(),"Verified Login button is displaying");


			ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
			waitTime(2000);
			loginPage.clickOnLoginButton();


			ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login With Email button.");
			loginPage.clickOnLoginWithEmailButton();


			ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+email);
			loginPage.enterEmailAddress(email);


			ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+pass);
			loginPage.enterPassword(pass);


			ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Login' button.");
			loginPage.clickOnB2BLoginSubmitButton();


			ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify User is logged in and no error message showing.");
			waitTime(1000);
			boolean isShowing = loginPage.verifyLoginErrorDisplaying();
			ErrorCollector.verifyFalse(isShowing,"Verified User is logged in and no error message showing");


			if(isShowing) {
				triggerBrowserStackLoginTestAsFailed(email);
			}else {
				triggerBrowserStackLoginTestAsPassed(email);
			}

			if (x!=data.length-1) {
				ExtentListeners.attachScreenShot("Login Success screenshot");
				waitTime(2000);
				ErrorCollector.extentLogInfo("Step "+(++step)+" : Close application.");

				killApplication();
			}
		}

	}

	@Test(priority = 4)
	public void Negative_Login_B2C_Email() {

		initReport();

		ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-135\"><b>QAA-135 : [iOS][Negative] Verify user is not able to login with Invalid Credentials/b></a>");
		initConfiguration();
		LoginPage loginPage = new LoginPage();

		Object[][] dataArr = getData(testDataFile,testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String invalidEmail1 = "abc";
		String invalidEmail2 = "1111";
		String invalidPinCode1 = "123456";
		String invalidPassword = getUniquePassword();
		String invalidPinCode = "123456";

		int step=0;
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(),"Verified Login button displaying");

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Email Error Message is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyEmailErrorMessageIsDisplaying(),"Verified that Email Error Message is Displaying");
		ErrorCollector.verifyEquals(loginPage.getEmailErrorMessage(), "Email address  is required", "Error messages are not equal.");

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Password Error Message is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyEmailErrorMessageIsDisplaying(),"Verified that Password Error Message is Displaying");
		ErrorCollector.verifyEquals(loginPage.getPasswordErrorMessage(), "Password  is required", "Error messages are not equal.");

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+invalidEmail1);
		loginPage.enterEmailAddress(invalidEmail1);

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Email Error Message is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyEmailErrorMessageIsDisplaying(),"Verified that Email Error Message is Displaying");
		ErrorCollector.verifyEquals(loginPage.getEmailErrorMessage(), "Invalid email ID format.", "Error messages are not equal.");

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+invalidEmail2);
		loginPage.enterEmailAddress(invalidEmail2);

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Email Error Message is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyEmailErrorMessageIsDisplaying(),"Verified that Email Error Message is Displaying");
		ErrorCollector.verifyEquals(loginPage.getEmailErrorMessage(), "Invalid email ID format.", "Error messages are not equal.");

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+email);
		loginPage.enterEmailAddress(email);

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+invalidPassword);
		loginPage.enterPassword(invalidPassword);

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();
		waitTime(2000);

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Login Error Message is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyInvalidCredentialsErrorMessageIsDisplaying(),"Verified that Login Error Message is Displaying");
		ErrorCollector.verifyEquals(loginPage.getCredentialErrorMessage(), "Incorrect email ID and password combination.", "Error messages are not equal.");

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+password);
		loginPage.enterPassword(password);

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Pin Code  : "+invalidPinCode1);
		waitTime(3000);
		loginPage.enterPinCodeWithoutVestedInvestClick(invalidPinCode1);

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify invalid PIN error message is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyInvalidPINErrorMessageIsDisplaying(),"Verified invalid PIN error message is displaying.");

	}

//	@Test(priority = 5)
//	public void ChangePassword_B2C_Email() {
//
//		initReport();
//
//		ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-192\"><b>QAA-192 : [IOS][ Update account Password] Update the user password from the Profile</b></a>");
//		initConfiguration();
//		LoginPage loginPage = new LoginPage();
//		ExplorePage browsePage = new ExplorePage();
//
//		Object[][] dataArr = getData(testDataFile,testDataSheet);
//		String email = dataArr[0][1].toString();
//		String password = dataArr[0][2].toString();
//		String pinCode = dataArr[0][3].toString();
//		if (isPreProdEnv) {
//			email = PropertiesReader.getPropertyValue(env+"_EmailId");
//			password = PropertiesReader.getPropertyValue(env+"_Password");
//		}
//		String newPassword = "$TestUser15";
//
//
//		int step=0;
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Login button displaying.");
//		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(),"Verified Login button displaying");
//
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
//		waitTime(7000);
//		loginPage.clickOnLoginButton();
//
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login With Email button.");
//		loginPage.clickOnLoginWithEmailButton();
//
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+email);
//		loginPage.enterEmailAddress(email);
//
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+password);
//		loginPage.enterPassword(password);
//
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
//		loginPage.clickOnLoginSubmitButton();
//
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Pin Code  : "+pinCode);
//		waitTime(3000);
//		loginPage.enterPinCode(pinCode);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify home page is displaying.");
//		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified home page is displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Profile Menu button.");
//		browsePage.clickOnProfileMenuButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Profile Page is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifyProfilePageIsDisplaying(),"Verified Profile Page is displaying");
//		ExtentListeners.attachScreenShot("Profile Page Screenshot");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Security button.");
//		try {
//			browsePage.clickOnButton("securityLabel");
//
//		} catch (Exception e) {
//			browsePage.clickOnButton("Security");
//		}
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Security Page is displaying.");
//		waitTime(5000);
//		ErrorCollector.verifyTrue(browsePage.verifyHeadingIsDisplaying("Security"),"Verified Security Page is displaying");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Change Password' button.");
//		loginPage.clickOnChangePasswordButton();
//
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Change Password Page is displaying.");
//		ErrorCollector.verifyTrue(loginPage.verifyChangePasswordPageIsDisplaying(),"Verified Change Password Page is displaying.");
//		ExtentListeners.attachScreenShot("Change Password Page Screenshot");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Current Password : "+password);
//		loginPage.enterCurrentPassword(password);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter New Password : "+newPassword);
//		loginPage.enterNewPassword(newPassword);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Confirm New Password : "+newPassword);
//		loginPage.enterConfirmNewPassword(newPassword);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Confirm New Password Eye button");
//		loginPage.clickOnConfirmNewPasswornEyeButton();
//
//		waitTime(1000);
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Password is displaying");
//		ErrorCollector.verifyEquals(loginPage.getConfirmPasswordInputValue(),newPassword ,"Passwords are not equals");
//		ExtentListeners.attachScreenShot("Password is Showing Screenshot");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Change Password button");
//		loginPage.clickOnSubmitChangePasswordButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Password Changed Successfully message is displaying.");
//		ErrorCollector.verifyTrue(loginPage.verifyPasswordChangedSuccesfullyMessageIsdisplaying(),"Verified Password Changed Successfully message is displaying.");
//		ExtentListeners.attachScreenShot("Password Changed Page Screenshot");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Back to Dashboard button");
//		loginPage.clickOnGoToDashboardButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Dashboard is displaying.");
//		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified Dashboard is displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Profile Menu button.");
//		browsePage.clickOnProfileMenuButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Profile Page is displaying.");
//		ErrorCollector.verifyTrue(browsePage.verifyProfilePageIsDisplaying(),"Verified Profile Page is displaying");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Security button.");
//		try {
//			browsePage.clickOnButton("securityLabel");
//
//		} catch (Exception e) {
//			browsePage.clickOnButton("Security");
//		}
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Security Page is displaying.");
//		waitTime(5000);
//		ErrorCollector.verifyTrue(browsePage.verifyHeadingIsDisplaying("Security"),"Verified Security Page is displaying");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Change Password' button.");
//		loginPage.clickOnChangePasswordButton();
//
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Change Password button is displaying.");
//		ErrorCollector.verifyTrue(loginPage.verifyChangePasswordPageIsDisplaying(),"Verified Change Password button is displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Current Password : "+newPassword);
//		loginPage.enterCurrentPassword(newPassword);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter New Password : "+password);
//		loginPage.enterNewPassword(password);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Confirm New Password : "+password);
//		loginPage.enterConfirmNewPassword(password);
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Change Password button");
//		loginPage.clickOnSubmitChangePasswordButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Password Changed Successfully message is displaying.");
//		ErrorCollector.verifyTrue(loginPage.verifyPasswordChangedSuccesfullyMessageIsdisplaying(),"Verified Password Changed Successfully message is displaying.");
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Back to Dashboard button");
//		loginPage.clickOnGoToDashboardButton();
//
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Dashboard is displaying.");
//		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified Dashboard is displaying.");
//
//	}
//
//	@Test(priority = 6)
//    public void ChangePIN_B2C_Email() {
//
//        initReport();
//
//        ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-192\"><b>QAA-192 : [IOS][ Update account Password] Update the user password from the Profile</b></a>");
//        initConfiguration();
//        LoginPage loginPage = new LoginPage();
//        ExplorePage browsePage = new ExplorePage();
//
//        Object[][] dataArr = getData(testDataFile,testDataSheet);
//        String email=dataArr[0][1].toString();
//        String password=dataArr[0][2].toString();
//        String pinCode=dataArr[0][3].toString();
//        String newPassword = getUniquePassword();
//
//
//        int step=0;
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Login button displaying.");
//        ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(),"Verified Login button displaying");
//
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
//        waitTime(7000);
//        loginPage.clickOnLoginButton();
//
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login With Email button.");
//        loginPage.clickOnLoginWithEmailButton();
//
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+email);
//        loginPage.enterEmailAddress(email);
//
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+password);
//        loginPage.enterPassword(password);
//
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
//        loginPage.clickOnLoginSubmitButton();
//
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Pin Code  : "+pinCode);
//        waitTime(3000);
//        loginPage.enterPinCode(pinCode);
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify home page is displaying.");
//        ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified home page is displaying.");
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Profile Menu button.");
//        browsePage.clickOnProfileMenuButton();
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Profile Page is displaying.");
//        ErrorCollector.verifyTrue(browsePage.verifyProfilePageIsDisplaying(),"Verified Profile Page is displaying");
//        ExtentListeners.attachScreenShot("Profile Page Screenshot");
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Security button.");
//        browsePage.clickOnButton("Security");
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Security Page is displaying.");
//        waitTime(5000);
//        ErrorCollector.verifyTrue(browsePage.verifyHeadingIsDisplaying("Security"),"Verified Security Page is displaying");
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Security PIN' button.");
//        loginPage.clickOnSecurityPIN();
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Change Password Page is displaying.");
//        ErrorCollector.verifyTrue(loginPage.verifyChangePasswordPageIsDisplaying(),"Verified Change Password Page is displaying.");
//        ExtentListeners.attachScreenShot("Change Password Page Screenshot");
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Current Password : "+password);
//        loginPage.enterCurrentPassword(password);
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter New Password : "+newPassword);
//        loginPage.enterNewPassword(newPassword);
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Confirm New Password : "+newPassword);
//        loginPage.enterConfirmNewPassword(newPassword);
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Confirm New Password Eye button");
//        loginPage.clickOnConfirmNewPasswornEyeButton();
//
//        waitTime(1000);
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Password is displaying");
//        ErrorCollector.verifyEquals(loginPage.getConfirmPasswordInputValue(),newPassword ,"Passwords are not equals");
//        ExtentListeners.attachScreenShot("Password is Showing Screenshot");
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Change Password button");
//        loginPage.clickOnSubmitChangePasswordButton();
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Password Changed Successfully message is displaying.");
//        ErrorCollector.verifyTrue(loginPage.verifyPasswordChangedSuccesfullyMessageIsdisplaying(),"Verified Password Changed Successfully message is displaying.");
//        ExtentListeners.attachScreenShot("Password Changed Page Screenshot");
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Back to Dashboard button");
//        loginPage.clickOnGoToDashboardButton();
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Dashboard is displaying.");
//        ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified Dashboard is displaying.");
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Profile Menu button.");
//        browsePage.clickOnProfileMenuButton();
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Profile Page is displaying.");
//        ErrorCollector.verifyTrue(browsePage.verifyProfilePageIsDisplaying(),"Verified Profile Page is displaying");
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Security button.");
//        browsePage.clickOnButton("Security");
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Security Page is displaying.");
//        waitTime(5000);
//        ErrorCollector.verifyTrue(browsePage.verifyHeadingIsDisplaying("Security"),"Verified Security Page is displaying");
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Change Password' button.");
//        loginPage.clickOnChangePasswordButton();
//
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Change Password button is displaying.");
//        ErrorCollector.verifyTrue(loginPage.verifyChangePasswordPageIsDisplaying(),"Verified Change Password button is displaying.");
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Current Password : "+newPassword);
//        loginPage.enterCurrentPassword(newPassword);
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter New Password : "+password);
//        loginPage.enterNewPassword(password);
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Confirm New Password : "+password);
//        loginPage.enterConfirmNewPassword(password);
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Change Password button");
//        loginPage.clickOnSubmitChangePasswordButton();
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Password Changed Successfully message is displaying.");
//        ErrorCollector.verifyTrue(loginPage.verifyPasswordChangedSuccesfullyMessageIsdisplaying(),"Verified Password Changed Successfully message is displaying.");
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Back to Dashboard button");
//        loginPage.clickOnGoToDashboardButton();
//
//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Dashboard is displaying.");
//        ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified Dashboard is displaying.");
//
//    }
}
