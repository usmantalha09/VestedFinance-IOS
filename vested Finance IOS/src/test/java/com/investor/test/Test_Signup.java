package com.investor.test;

import static org.testng.Assert.assertFalse;

import java.io.File;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.investor.base.BaseClass;
import com.investor.errorCollectors.ErrorCollector;
import com.investor.listeners.ExtentListeners;
import com.investor.pages.DIYVestPage;
import com.investor.pages.ExplorePage;
import com.investor.pages.KYCUserPurchaseStockPage;
import com.investor.pages.LoginPage;
import com.investor.pages.SignupPage;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;


public class Test_Signup extends BaseClass {
	
	@Test(priority = 1)
	public void Negative_SignUp_B2C_Email() {

		initReport();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-137\"><b>QAA-137 : [iOS][Negative] Verify user is not able to sign up if invalid data is used</b></a>");

		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		String invalidEmail1 = "abc";
		String invalidEmail2 = "1111";
		String invalidEmail3 = "1111@aa";
		String invalidPassword1 = "abc";
		String invalidPassword2 = "111";
		String invalidPassword3 = "@@@";
		String invalidPinCode1 = "123456";
		String invalidPinCode2 = "aaaaaa";
		String invalidPinCode3 = "######";
		String invalidPinCode4 = "12345";
		String validEmail = getUniqueEmailId("Test");
		String validPassword = getUniquePassword();
		String passwordErrorMessage = "Your Password should atleast have 8 characters, a lower-case letter, an upper-case letter, a number and a special character.";
		String verififcationCodeErrorMessage = "Invalid verification code provided, please try again.";
		initConfiguration();
		int step = 0;
		String signUPString ="label == \"Sign Up\"";
		IOSElement element =   (IOSElement) driver.findElement(MobileBy.iOSNsPredicateString(signUPString));
		boolean check = element.isDisplayed();
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup button displaying.");
		//ErrorCollector.verifyTrue(signup.verifySignUpButton(), "Verified Signup button displaying");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up button.");
		waitTime(3000);
		signup.clickOnSignUpButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup with Email button displaying.");
		ErrorCollector.verifyTrue(signup.verifySignUpWithEmailButtonShowing(),
				"Verified Signup with Email button displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up With Email button.");
		signup.clickOnSignUpWithEmailButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign Up button.");
		signup.clickOnSubmitSignupButton();
		
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
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+invalidEmail3);
		loginPage.enterEmailAddress(invalidEmail3);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Email Error Message is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyEmailErrorMessageIsDisplaying(),"Verified that Email Error Message is Displaying");
		ErrorCollector.verifyEquals(loginPage.getEmailErrorMessage(), "Invalid email ID format.", "Error messages are not equal.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+validEmail);
		loginPage.enterEmailAddress(validEmail);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+invalidPassword1);
		loginPage.enterPassword(invalidPassword1);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Password Error Message is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyPasswordErrorMessageIsDisplaying(),"Verified that Password Error Message is Displaying");
		ErrorCollector.verifyEquals(loginPage.getPasswordErrorMessage(), passwordErrorMessage, "Error messages are not equal.");
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+invalidPassword2);
		loginPage.enterPassword(invalidPassword2);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Password Error Message is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyPasswordErrorMessageIsDisplaying(),"Verified that Password Error Message is Displaying");
		ErrorCollector.verifyEquals(loginPage.getPasswordErrorMessage(), passwordErrorMessage, "Error messages are not equal.");
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+invalidPassword3);
		loginPage.enterPassword(invalidPassword3);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Password Error Message is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyPasswordErrorMessageIsDisplaying(),"Verified that Password Error Message is Displaying");
		ErrorCollector.verifyEquals(loginPage.getPasswordErrorMessage(), passwordErrorMessage, "Error messages are not equal.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + validPassword);
		signup.enterPassword(validPassword);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign Up button.");
		signup.clickOnSubmitSignupButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Verification Code screen is displaying.");
		ErrorCollector.verifyTrue(signup.verifyOTPScreenIsDisplaying(),
				"Verify Verification Code screen is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Verification Code : "+invalidPinCode1);
		signup.enterVerificationCode(invalidPinCode1);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Confirm Account' button.");
		signup.clickOnConfirmAccountButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify PIN  Error Message is displaying.");
		ErrorCollector.verifyTrue(signup.verifyPINErrorMessageIsDisplaying(),"Verified that PIN Error Message is Displaying");
		ErrorCollector.verifyEquals(signup.getVerificationCodeErrorMessage(), verififcationCodeErrorMessage, "Error messages are not equal.");
	
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Verification Code : "+invalidPinCode2);
		signup.enterVerificationCode(invalidPinCode2);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Confirm Account' button.");
		signup.clickOnConfirmAccountButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify PIN  Error Message is displaying.");
		ErrorCollector.verifyTrue(signup.verifyPINErrorMessageIsDisplaying(),"Verified that PIN Error Message is Displaying");
		ErrorCollector.verifyEquals(signup.getVerificationCodeErrorMessage(), verififcationCodeErrorMessage, "Error messages are not equal.");
	
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Verification Code : "+invalidPinCode3);
		signup.enterVerificationCode(invalidPinCode3);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Confirm Account' button.");
		signup.clickOnConfirmAccountButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify PIN  Error Message is displaying.");
		ErrorCollector.verifyTrue(signup.verifyPINErrorMessageIsDisplaying(),"Verified that PIN Error Message is Displaying");
		ErrorCollector.verifyEquals(signup.getVerificationCodeErrorMessage(), verififcationCodeErrorMessage, "Error messages are not equal.");
	
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Verification Code : "+invalidPinCode4);
		signup.enterVerificationCode(invalidPinCode4);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Confirm Account' button.");
		signup.clickOnConfirmAccountButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify PIN  Error Message is displaying.");
		ErrorCollector.verifyTrue(signup.verifyPINErrorMessageIsDisplaying(),"Verified that PIN Error Message is Displaying");
		ErrorCollector.verifyEquals(signup.getVerificationCodeErrorMessage(), verififcationCodeErrorMessage, "Error messages are not equal.");
	
	}

	@Test(priority = 2)
	public void SignUp_B2C_Email() {

		initReport();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-9\"><b>QAA-9 : iOS - Verify a user is able to sign up to the platform with a valid email address and password</b></a>");
		
		String email = getUniqueEmailId("Test");
		initConfiguration();
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();

		int step = 0;
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup button displaying.");
		ErrorCollector.verifyTrue(signup.verifySignUpButtonShowing(), "Verified Signup button displaying");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up button.");
		waitTime(3000);
		signup.clickOnSignUpButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup with Email button displaying.");
		ErrorCollector.verifyTrue(signup.verifySignUpWithEmailButtonShowing(),
				"Verified Signup with Email button displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up With Email button.");
		signup.clickOnSignUpWithEmailButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter email address : " + email);
		signup.enterEmailAddress(email);
		
		String password = getUniquePassword();
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + password);
		signup.enterPassword(password);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign Up button.");
		signup.clickOnSubmitSignupButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Verification Code screen is displaying.");
		ErrorCollector.verifyTrue(signup.verifyOTPScreenIsDisplaying(),
				"Verify Verification Code screen is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Back button.");
		waitTime(3000);
		signup.clickOnBackButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Back button.");
		waitTime(1000);
		signup.clickOnBackButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login button.");
		signup.clickOnLoginButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter email address : " + email);
		signup.enterEmailAddress(email);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + password);
		signup.enterPassword(password);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'START KYC' button is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyStarKYCButton(), "Verified 'START KYC' button is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'EXPLORE PLATFORM' button is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyExplorePlatformButton(),
				"Verified 'EXPLORE PLATFORM' button is displaying.");
	}

	//@Test(priority = 3)
	public void KYC_NonAadhar() {

		initReport();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-107\"><b>QAA-107 : iOS - [KYC Registration] for the Non Aadhar Indian Residents</b></a>");

		initConfiguration();
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		String mobileNumber = generateRandomNumberWithGivenNumberOfDigits(10);
		Object[][] dataArr = getData(testDataFile,testDataSheet);
		String addressLine1=dataArr[0][10].toString();
		String city=dataArr[0][11].toString();
		String state=dataArr[0][12].toString();
        String cityPinCode=dataArr[0][13].toString();
        String fullName=dataArr[0][14].toString();
        String panCardFileName = "pan_card.jpg";
        String aadhaarCardFileName = "aadhaar_card.jpg";

		int step = 0;
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup button displaying.");
		ErrorCollector.verifyTrue(signup.verifySignUpButtonShowing(), "Verified Signup button displaying");
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up button.");
		waitTime(3000);
		signup.clickOnSignUpButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup with Email button displaying.");
		ErrorCollector.verifyTrue(signup.verifySignUpWithEmailButtonShowing(),
				"Verified Signup with Email button displaying.");
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up With Email button.");
		signup.clickOnSignUpWithEmailButton();
		

		String email = getUniqueEmailId("Test");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter email address : " + email);
		signup.enterEmailAddress(email);
		

		String password = getUniquePassword();
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + password);
		signup.enterPassword(password);
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign Up button.");
		signup.clickOnSubmitSignupButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Verification Code screen is displaying.");
		ErrorCollector.verifyTrue(signup.verifyOTPScreenIsDisplaying(),
				"Verify Verification Code screen is displaying.");
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Back button.");
		waitTime(3000);
		signup.clickOnBackButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Back button.");
		waitTime(1000);
		signup.clickOnBackButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login button.");
		loginPage.clickOnLoginButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter email address : " + email);
		signup.enterEmailAddress(email);
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + password);
		signup.enterPassword(password);
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login button.");
		loginPage.clickOnLoginButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'START KYC' button is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyStarKYCButton(), "Verified 'START KYC' button is displaying.");
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'EXPLORE PLATFORM' button is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyExplorePlatformButton(),
				"Verified 'EXPLORE PLATFORM' button is displaying.");

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Start KYC button.");
		signup.clickOnStartKYCButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Welcome To Vested Awsome button.");
		signup.clickOnWelcomeToVestedAwsomeButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Accept And Continue button.");
		waitTime(2000);
		signup.clickOnAcceptAndContinueButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Gender : Male");
		waitTime(1000);
		signup.clickOnGenderMaleOption();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Marital Status: Single");
		waitTime(500);
		signup.clickOnMaritalStatusSingleOption();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Employment : Unemployed");
		waitTime(500);
		signup.clickOnUnemployedOption();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Check 'None Of the these apply to me' CheckBox");
		waitTime(500);
		signup.clickOnNoneOfTheTheseApplyToMeCheckBox();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Next Button");
		waitTime(500);
		signup.clickOnNextButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Risk tolerance : Low");
		waitTime(1000);
		signup.clickOnRiskToleranceLowOption();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select How often do you plan to invest in companies? : Several times a week");
		waitTime(500);
		signup.clickOnSeveralTimesAWeek();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Investing Experience: 0 to 1 year");
		waitTime(500);
		signup.clickOnInvestingExperience0To1Year();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Yearly Income: 0 to 10 lakh rupees");
		waitTime(500);
		signup.clickOnYearlyIncome0To10Lac();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select liquid net worth: 0 to 5 Lakh rupees");
		waitTime(500);
		signup.clickOnLiquidNetWorth0To5LakhRupees();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select total net worth: 0 to 10 Lakh rupees");
		waitTime(500);
		signup.clickOnTotalNetWorth0To10LakhRupees();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Source of Investment : Gift");
		waitTime(500);
		signup.clickOnprimarySourceSelectSourceDropDownGiftOption();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select In the next 12 months, how many deposits and withdrawals do you plan to make with your Vested account? : 6 to 10");
		waitTime(500);
		signup.clickOnDepositsAndWithdrawals6To10();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select In the next 12 months, how much money do you plan to deposit into your Vested account? : 0 to 50,000");
		waitTime(500);
		signup.clickOnMoneyPlanToDeposits0To50000();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select In the last 12 months, how many investments have you made? : 0 to 5");
		waitTime(500);
		signup.clickOnInvestments0To5();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Next Button");
		waitTime(500);
		signup.clickOnNextButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select What country do you primarily file taxes in? : India");
		waitTime(500);
		signup.clickOnPrimaryTaxFilesCountryIndia();
		
		
		waitTime(2000);
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Is your mobile number linked with Aadhaar? : NO");
		waitTime(500);
		signup.clickOnMobileNumberLinkedWithAdhar();
		
		
		waitTime(2000);
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Mobile Number : "+mobileNumber);
		signup.enterMobileNumberWithOutScroll(mobileNumber);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Send OTP button");
		waitTime(500);
		signup.clickOnSendOTPButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Wait for 30 Seconds");
		waitTime(30000);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Resend OTP button");
		waitTime(5000);
		signup.clickOnResendOTPButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Wait for 30 Seconds");
		waitTime(30000);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Recieve OTP via Call button");
		waitTime(5000);
		signup.clickOnRecieveOTPViaCallButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Wait for 30 Seconds");
		waitTime(30000);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Continue Anyway button");
		waitTime(5000);
		signup.clickOnContinueAnyWayButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Upload PAN Card button");
		signup.clickOnUploadPanCardButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Confirm button in dialog");
		signup.clickOnPanCardConfirmButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Saving '"+panCardFileName+"' file to device.");
		try {
			((IOSDriver<MobileElement>) getDriver()).pushFile("/sdcard/Download/"+panCardFileName, new File(imagePath+panCardFileName));
		} catch (Exception e) {
			printString(e.getMessage());
		}
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Upload button in dialog.");
		signup.clickOnUploadButtonPanCardDialog();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Choose from Gallery button.");
		signup.clickOnChooseFromGalleryButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select PAN Card image from gallery.");
		signup.selectCardImage(panCardFileName);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify PAN Card uploaded successfully message is displaying.");
		waitTime(10000);
		ErrorCollector.verifyTrue(signup.verifyPANCardUploadedSuccessfully(),"Verified PAN Card uploaded successfully message is displaying");
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Saving '"+aadhaarCardFileName+"' file to device.");
		try {
			((IOSDriver<MobileElement>) getDriver()).pushFile("/sdcard/Download/"+aadhaarCardFileName, new File(imagePath+aadhaarCardFileName));
		} catch (Exception e) {
			printString(e.getMessage());
		}
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Upload AADHAAR CARD button.");
		signup.clickOnUploadAadhaarCardButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Confirm button in dialog");
		signup.clickOnPanCardConfirmButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Upload button in dialog.");
		signup.clickOnUploadButtonPanCardDialog();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Choose from Gallery button.");
		signup.clickOnChooseFromGalleryButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select AADHAAR Card image from gallery.");
		signup.selectCardImage(aadhaarCardFileName);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'Aadhaar uploaded' message is displaying.");
		waitTime(10000);
		ErrorCollector.verifyTrue(signup.verifyAsdhaarCardUploadedSuccessfully(),"Verified 'Aadhaar uploaded' message is displaying");
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Address Line 1 : "+addressLine1);
		waitTime(500);
		signup.enterAddressLine1(addressLine1);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter City : "+city);
		waitTime(500);
		signup.enterCity(city);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select State : "+state);
		waitTime(500);
		signup.selectState(state);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter PinCode : "+cityPinCode);
		waitTime(500);
		signup.enterPin(cityPinCode);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Check 'I confirm that the information outlined in my uploaded documents is correct and accurate. Vested will use the information to open your Vested account.' checkbox.");
		waitTime(500);
		signup.checkIConfirmInfoCheckBox();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Next Button");
		waitTime(2000);
		signup.clickOnNextButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Next Button on Plan Page");
		waitTime(3000);
		signup.clickOnNextButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Check 'I confirm that the information outlined in my uploaded documents is correct and accurate. Vested will use the information to open your Vested account.' checkbox.");
		waitTime(2000);
		signup.checkIAgreeDriveWealthPrivacyPolicy();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Full Name : "+fullName);
		signup.enterFullName(fullName);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Next Button");
		waitTime(1000);
		signup.clickOnNextButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'Your KYC form is submitted' message is displaying.");
		waitTime(2000);
		ErrorCollector.verifyTrue(signup.verifyKYCSubmittedSuccessfully(),"Verified 'Your KYC form is submitted' message is displaying");
		
		
		waitTime(1000);
		goBack(1);
	}
	
	@Test
	public void KYC_Reg_UAE() {

		initReport();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-648\"><b>QAA-648 : iOS - KYC registration for UAE</b></a>");

		
		String email = getUniqueEmailId("Test");
		initConfiguration();
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		String nationality = "United Arab Emirates";
		String gender = "Male";
		String maritalStatus = "Single";
		String employment = "Unemployed";

		int step = 0;
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup button displaying.");
		ErrorCollector.verifyTrue(signup.verifySignUpButtonShowing(), "Verified Signup button displaying");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up button.");
		waitTime(3000);
		signup.clickOnSignUpButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup with Email button displaying.");
		ErrorCollector.verifyTrue(signup.verifySignUpWithEmailButtonShowing(),
				"Verified Signup with Email button displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up With Email button.");
		signup.clickOnSignUpWithEmailButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter email address : " + email);
		signup.enterEmailAddress(email);
		
		String password = getUniquePassword();
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + password);
		signup.enterPassword(password);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign Up button.");
		signup.clickOnSubmitSignupButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Verification Code screen is displaying.");
		ErrorCollector.verifyTrue(signup.verifyOTPScreenIsDisplaying(),
				"Verify Verification Code screen is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Back button.");
		waitTime(3000);
		signup.clickOnBackButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Back button.");
		waitTime(1000);
		signup.clickOnBackButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login button.");
		signup.clickOnLoginButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter email address : " + email);
		signup.enterEmailAddress(email);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + password);
		signup.enterPassword(password);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'START KYC' button is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyStarKYCButton(), "Verified 'START KYC' button is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'EXPLORE PLATFORM' button is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyExplorePlatformButton(),
				"Verified 'EXPLORE PLATFORM' button is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'START KYC' button.");
		signup.clickOnStartKYCButton();
		waitTime(8000);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Accept and Proceed' button.");
		signup.clickOnAcceptAndProceedButton();
		waitTime(3000);

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Ok' button in popup.");
		signup.clickOnOkButtonInTermsAcceptedModal();

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'AWESOME!' button in popup.");
		signup.clickOnAwesomeButtonInModal();

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Start KYC Process!' button.");
		signup.clickOnStartKycProcessButton();
		waitTime(2000);

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Accept and Continue' button.");
		signup.clickOnAcceptAndContinueButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Nationality : "+nationality);
		signup.selectNationality(nationality);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Gender : "+gender);
		signup.clickOnGenderMaleOption();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Marital Status : "+maritalStatus);
		signup.clickOnMaritalStatusSingleOption();
		
		scrollDown();
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Employment : "+employment);
		signup.clickOnUnemployedOption();
		scrollDown();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Check 'None of these apply to me' checkbox.");
		signup.clickOnNoneOfTheTheseApplyToMeCheckBox();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Next' button.");
		signup.clickOnNextButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Risk tolerance: Low' option.");
		signup.clickOnRiskToleranceLowOption();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on ': Several times a week' option.");
		signup.clickOnSeveralTimesAWeek();
		
		scrollToText("Investing experience");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Investing Experience: 0 to 1 year' option.");
		signup.clickOnInvestingExperience0To1Year();
		
		scrollToText("Yearly income");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Yearly income: $0 to $ 30,000' option.");
		signup.clickOnYearlyIncome0To300000();

		scrollToText("Liquid net worth (stocks + bank balance)");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Liquid net worth (stocks + bank balance): $0 to $15,000' option.");
		signup.clickOnLiquidNetWorth0To150000();
		
		scrollToText("Total net worth (liquid net worth + all other assets)");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Total net worth (liquid net worth + all other assets): $0 to $15,000' option.");
		signup.clickOnNetWorth0To300000();
		
		scrollToText("What is your primary source of investments?");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'What is your primary source of investments?: $0 to $15,000' option.");
		signup.selectPrimarySourceOfIncome();
		
		
		scrollToText("What is your primary source of investments?");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Investment frequency: 11+.");
		signup.selectFrequency11();
		
		scrollToText("In the next 12 months, how much money do you plan to deposit into your Vested account?");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'expected deposit in next 12 months: $0 to $5000.");
		signup.selectExpectedDepositInNext12Months();
		
		scrollToText("In the last 12 months, how many investments have you made?");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'In the last 12 months, how many investments have you made?: 0 to 5.");
		signup.selectExpectedInvestmentsInNext12Months();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Next' button.");
		signup.clickOnNextButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Verify your Identity' button.");
		signup.clickOnIdentityVerification();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'Verify your Identity' pop up is displaying.");
		ErrorCollector.verifyTrue(signup.verifyIdentityVerificationModalIsDisplaying(),"Verified 'Verify your Identity' pop up is displaying.");

	}


	@Test
	public void KYC_IndianNationality_NonIndianTaxResidency() {

		initReport();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-658\"><b>QAA-658 : [IOS] - KYC Verification For User With Indian Nationality and Non-Indian Tax Residence</b></a>");
		String email = getUniqueEmailId("Test");
		initConfiguration();
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		String nationality = "India";
		String taxResidency = "Albania";
		String gender = "Male";
		String maritalStatus = "Single";
		String employment = "Unemployed";
		String mobileNumber="0987654321";
		String taxIdNumber="296482326";

		int step = 0;
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup button displaying.");
		ErrorCollector.verifyTrue(signup.verifySignUpButtonShowing(), "Verified Signup button displaying");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up button.");
		waitTime(3000);
		signup.clickOnSignUpButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup with Email button displaying.");
		ErrorCollector.verifyTrue(signup.verifySignUpWithEmailButtonShowing(),
				"Verified Signup with Email button displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up With Email button.");
		signup.clickOnSignUpWithEmailButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter email address : " + email);
		signup.enterEmailAddress(email);
		
		String password = getUniquePassword();
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + password);
		signup.enterPassword(password);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign Up button.");
		signup.clickOnSubmitSignupButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Verification Code screen is displaying.");
		ErrorCollector.verifyTrue(signup.verifyOTPScreenIsDisplaying(),
				"Verify Verification Code screen is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Back button.");
		waitTime(3000);
		signup.clickOnBackButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Back button.");
		waitTime(1000);
		signup.clickOnBackButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login button.");
		signup.clickOnLoginButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter email address : " + email);
		signup.enterEmailAddress(email);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + password);
		signup.enterPassword(password);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'START KYC' button is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyStarKYCButton(), "Verified 'START KYC' button is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'EXPLORE PLATFORM' button is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyExplorePlatformButton(),
				"Verified 'EXPLORE PLATFORM' button is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'START KYC' button.");
		signup.clickOnStartKYCButton();
		waitTime(8000);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Accept and Proceed' button.");
		signup.clickOnAcceptAndProceedButton();
		waitTime(3000);

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Ok' button in popup.");
		signup.clickOnOkButtonInTermsAcceptedModal();

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'AWESOME!' button in popup.");
		signup.clickOnAwesomeButtonInModal();

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Start KYC Process!' button.");
		signup.clickOnStartKycProcessButton();
		waitTime(2000);

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Accept and Continue' button.");
		signup.clickOnAcceptAndContinueButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Nationality : "+nationality);
		signup.selectNationality(nationality);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Primary Tax Residency  : "+taxResidency);
		signup.selectTaxResidency(taxResidency);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Gender : "+gender);
		signup.clickOnGenderMaleOption();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Marital Status : "+maritalStatus);
		signup.clickOnMaritalStatusSingleOption();
		
		scrollDown();
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Employment : "+employment);
		signup.clickOnUnemployedOption();
		scrollDown();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Check 'None of these apply to me' checkbox.");
		signup.clickOnNoneOfTheTheseApplyToMeCheckBox();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Next' button.");
		signup.clickOnNextButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Risk tolerance: Low' option.");
		signup.clickOnRiskToleranceLowOption();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on ': Several times a week' option.");
		signup.clickOnSeveralTimesAWeek();
		
		scrollToText("Investing experience");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Investing Experience: 0 to 1 year' option.");
		signup.clickOnInvestingExperience0To1Year();
		
		scrollToText("Yearly income");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Yearly income: $0 to $ 30,000' option.");
		signup.clickOnYearlyIncome0To300000();

		scrollToText("Liquid net worth (stocks + bank balance)");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Liquid net worth (stocks + bank balance): $0 to $15,000' option.");
		signup.clickOnLiquidNetWorth0To150000();
		
		scrollToText("Total net worth (liquid net worth + all other assets)");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Total net worth (liquid net worth + all other assets): $0 to $15,000' option.");
		signup.clickOnNetWorth0To300000();
		
		scrollToText("What is your primary source of investments?");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'What is your primary source of investments?: $0 to $15,000' option.");
		signup.selectPrimarySourceOfIncome();
		
		
		scrollToText("What is your primary source of investments?");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Investment frequency: 11+.");
		signup.selectFrequency11();
		
		scrollToText("In the next 12 months, how much money do you plan to deposit into your Vested account?");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'expected deposit in next 12 months: $0 to $5000.");
		signup.selectExpectedDepositInNext12Months();
		
		scrollToText("In the last 12 months, how many investments have you made?");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'In the last 12 months, how many investments have you made?: 0 to 5.");
		signup.selectExpectedInvestmentsInNext12Months();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Next' button.");
		signup.clickOnNextButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Tax ID Number: "+taxIdNumber);
		signup.enterTaxIdNumber(taxIdNumber);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter mobile number: "+mobileNumber);
		signup.enterMobileNumber(mobileNumber);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Send OTP' button.");
		signup.clickOnSendOTPButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Wait for 30 seconds to appear Resend OTP button.");
		waitTime(32*1000);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Resend OTP' button.");
		signup.clickOnResendOTPButton();

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Wait for 30 seconds to appear Receive OTP via call button.");
		waitTime(32*1000);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Receive OTP via call' button.");
		signup.clickOnRecieveOTPViaCallButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Wait for 30 seconds to appear continue Anyway button.");
		waitTime(32*1000);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Continue Anyway' button.");
		signup.clickOnContinueAnyWayButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Verify your Identity' button.");
		signup.clickOnIdentityVerification();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'Verify your Identity' pop up is displaying.");
		ErrorCollector.verifyTrue(signup.verifyIdentityVerificationModalIsDisplaying(),"Verified 'Verify your Identity' pop up is displaying.");

	}
	
	@Test
	public void KYC_NonIndianNationality_IndianTaxResidency() {

		initReport();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-663\"><b>QAA-663 : [IOS] - KYC Verification For User With Non-Indian Nationality and Indian Tax Residence</b></a>");
		
		String email = getUniqueEmailId("Test");
		initConfiguration();
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		String nationality = "Albania";
		String taxResidency = "India";
		String gender = "Male";
		String maritalStatus = "Single";
		String employment = "Unemployed";
		String mobileNumber="0987654321";
		String taxIdNumber="296482326";
		String aadhaarCardFileName = "aadhaar_card.jpg";
		
		try {
			((IOSDriver<MobileElement>) getDriver()).pushFile("/private/var/mobile/Media/DCIM/"+aadhaarCardFileName, new File(imagePath + aadhaarCardFileName));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		int step = 0;
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup button displaying.");
		ErrorCollector.verifyTrue(signup.verifySignUpButtonShowing(), "Verified Signup button displaying");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up button.");
		waitTime(3000);
		signup.clickOnSignUpButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Signup with Email button displaying.");
		ErrorCollector.verifyTrue(signup.verifySignUpWithEmailButtonShowing(),
				"Verified Signup with Email button displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign up With Email button.");
		signup.clickOnSignUpWithEmailButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter email address : " + email);
		signup.enterEmailAddress(email);
		
		String password = getUniquePassword();
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + password);
		signup.enterPassword(password);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Sign Up button.");
		signup.clickOnSubmitSignupButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify Verification Code screen is displaying.");
		ErrorCollector.verifyTrue(signup.verifyOTPScreenIsDisplaying(),
				"Verify Verification Code screen is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Back button.");
		waitTime(3000);
		signup.clickOnBackButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Back button.");
		waitTime(1000);
		signup.clickOnBackButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login button.");
		signup.clickOnLoginButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter email address : " + email);
		signup.enterEmailAddress(email);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter Password : " + password);
		signup.enterPassword(password);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'START KYC' button is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyStarKYCButton(), "Verified 'START KYC' button is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'EXPLORE PLATFORM' button is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyExplorePlatformButton(),
				"Verified 'EXPLORE PLATFORM' button is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'START KYC' button.");
		signup.clickOnStartKYCButton();
		waitTime(8000);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Accept and Proceed' button.");
		signup.clickOnAcceptAndProceedButton();
		waitTime(3000);

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Ok' button in popup.");
		signup.clickOnOkButtonInTermsAcceptedModal();

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'AWESOME!' button in popup.");
		signup.clickOnAwesomeButtonInModal();

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Start KYC Process!' button.");
		signup.clickOnStartKycProcessButton();
		waitTime(2000);

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Accept and Continue' button.");
		signup.clickOnAcceptAndContinueButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Nationality : "+nationality);
		signup.selectNationality(nationality);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Primary Tax Residency  : "+taxResidency);
		signup.selectTaxResidency(taxResidency);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Gender : "+gender);
		signup.clickOnGenderMaleOption();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Marital Status : "+maritalStatus);
		signup.clickOnMaritalStatusSingleOption();
		
		scrollDown();
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Select Employment : "+employment);
		signup.clickOnUnemployedOption();
		scrollDown();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Check 'None of these apply to me' checkbox.");
		signup.clickOnNoneOfTheTheseApplyToMeCheckBox();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Next' button.");
		signup.clickOnNextButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Risk tolerance: Low' option.");
		signup.clickOnRiskToleranceLowOption();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on ': Several times a week' option.");
		signup.clickOnSeveralTimesAWeek();
		
		scrollToText("Investing experience");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Investing Experience: 0 to 1 year' option.");
		signup.clickOnInvestingExperience0To1Year();
		
		scrollToText("Yearly income");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Yearly income: $0 to $ 30,000' option.");
		signup.clickOnYearlyIncome0To300000();

		scrollToText("Liquid net worth (stocks + bank balance)");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Liquid net worth (stocks + bank balance): $0 to $15,000' option.");
		signup.clickOnLiquidNetWorth0To150000();
		
		scrollToText("Total net worth (liquid net worth + all other assets)");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Total net worth (liquid net worth + all other assets): $0 to $15,000' option.");
		signup.clickOnNetWorth0To300000();
		
		scrollToText("What is your primary source of investments?");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'What is your primary source of investments?: $0 to $15,000' option.");
		signup.selectPrimarySourceOfIncome();
		
		
		scrollToText("What is your primary source of investments?");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Investment frequency: 11+.");
		signup.selectFrequency11();
		
		scrollToText("In the next 12 months, how much money do you plan to deposit into your Vested account?");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'expected deposit in next 12 months: $0 to $5000.");
		signup.selectExpectedDepositInNext12Months();
		
		scrollToText("In the last 12 months, how many investments have you made?");
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'In the last 12 months, how many investments have you made?: 0 to 5.");
		signup.selectExpectedInvestmentsInNext12Months();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Next' button.");
		signup.clickOnNextButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Mobile number linked with Aadhar No' button.");
		signup.clickOnMobileLinkedWithAadharNoButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Enter mobile number: "+mobileNumber);
		signup.enterMobileNumber(mobileNumber);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Send OTP' button.");
		signup.clickOnSendOTPButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Wait for 30 seconds to appear Resend OTP button.");
		waitTime(32*1000);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Resend OTP' button.");
		signup.clickOnResendOTPButton();

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Wait for 30 seconds to appear Receive OTP via call button.");
		waitTime(32*1000);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Receive OTP via call' button.");
		signup.clickOnRecieveOTPViaCallButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Wait for 30 seconds to appear continue Anyway button.");
		waitTime(32*1000);
		scrollUp();
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Continue Anyway' button.");
		signup.clickOnContinueAnyWayButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'UPLOAD AADHAR' button.");
		signup.clickOnUploadAadhaarCardButton();

		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'UPLOAD AADHAR Confirm' button.");
		signup.clickOnPanCardConfirmButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'UPLOAD' button in dialog.");
		signup.clickOnUploadButtonPanCardDialog();
		
//		try {
//			driver.pushFile(aadhaarCardFileName, new File(imagePath + aadhaarCardFileName));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		waitTime(3000);
		printString(getDriver().getPageSource());
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Click on 'Choose from Gallery' button.");
		signup.clickOnChooseFromGalleryButton();
		
		ExtentListeners.attachScreenShot("Gallery  Screenshot");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+ " : Verify 'Verify your Identity' pop up is displaying.");
		ErrorCollector.verifyTrue(signup.verifyIdentityVerificationModalIsDisplaying(),"Verified 'Verify your Identity' pop up is displaying.");

	}
	
	@Test(priority = 5)
	public void VerifyLetsOpenYourAccountScreen() {

		initReport();
		

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-769\">QAA-769 iOS  - Verify the Let’s open your account screen<a/>");
	
		initConfiguration();
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		KYCUserPurchaseStockPage kYCUserPurchaseStockPage = new KYCUserPurchaseStockPage();

		String validinvestAmount = "50";


		Object[][] dataArr = getData("testData", "TestData");
		String email ="codeautomation.nouman+28@vestedfinance.co";
		String password = "Test@12345";
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
		
		loginPage.clickVestedWidget();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Pin Code  : " + pinCode);
//		waitTime(3000);
//		loginPage.enterPinCode(pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(), "Verified home page is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Complete Kyc' button.");
		kYCUserPurchaseStockPage.clickOnCompleteKycButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Next' button.");
		kYCUserPurchaseStockPage.clickOnNextButton();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'vested logo' is displaying and clickable'");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.isDoneBtnClickable(), "Verified 'vested logo' is displaying and clickable'");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'cross icon' is displaying and clickable'");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.isDoneBtnClickable(), "Verified 'cross icon' is displaying and clickable'");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Let open your account' is displaying.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.isHeadingLetsOpenAccountDisplaying(), "Verified 'Let open your account' is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Terms and conditions' is displaying.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.isHeadingTermsAndConditionDisplaying(), "Verified 'Terms and condition' is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Checkbox' with label ' want to enroll in the Securities Lending Income Program and have reviewed DriveWealth’s Master Securities Lending Agreement,' is displaying.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.isCheckboxWithlabelIWanttoEnrolDisplaying(), "Verified 'Checkbox' with label ' want to enroll in the Securities Lending Income Program and have reviewed DriveWealth’s Master Securities Lending Agreement,' is displaying.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Checkbox with label I agree to Vested’s Advisory Agreement, ESIGN Agreement, Vested’s Privacy Policy, Vested’s Terms of Service, DriveWealth’s Privacy Policy,'  is displaying.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.isCheckboxWithlabelIAgreetoVested(), "Verified 'Checkbox with label I agree to Vested’s Advisory Agreement, ESIGN Agreement, Vested’s Privacy Policy, Vested’s Terms of Service, DriveWealth’s Privacy Policy,'  is displaying.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Checkbox with label I have reviewed and agree to VF Securities Account Agreement ' is displaying.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.isCheckboxWithlabelIHaveReviewedVF(), "Verified Checkbox with label I have reviewed and agree to VF Securities Account Agreement ' is displaying.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Checkbox with label I have reviewed the Client Relationship Summary' is displaying.");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.isCheckboxIHaveReviewedClientRelation(), "Verified 'Checkbox with label I have reviewed the Client Relationship Summary' is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Field Enter Full Name'");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.isFieldEnterFullNameDisplauing(), "Verified 'Field Enter Full Name'");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'By Checking Indicated above and typing your name' is displaying");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.isLabelByCheckingInicatedDisplaying(), "Verified 'By Checking Indicated above and typing your name' is displaying");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'By Signing above, you agree' is displaying");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.isLabelBySigningAboveDisplaying(), "Verified 'By Signing above, you agree' is displaying");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Previous Button is displaying and clickable'");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.isPreviousBtnClickable(), "Verified Previous Button is displaying and clickable'");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Done Button is displaying and clickable'");
		ErrorCollector.verifyTrue(kYCUserPurchaseStockPage.isDoneBtnClickable(), "Verified Done Button is displaying and clickable'");
		
		
		
		
	}
	
	@Test
	public void VerifyUserBuyOrderForMarketInstrument() {
		
		initReport();
		
		
		ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-785\">QAA-785 IOS] - Verify that user is buy Instrument/stock for market order<a/>");
		
		initConfiguration();
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		DIYVestPage diyVestPage = new DIYVestPage();
		
		Object[][] dataArr = getData(TestDataFileName,testDataSheet);
		String email=dataArr[0][1].toString();
		String password=dataArr[0][2].toString();
		String pinCode=dataArr[0][3].toString();
		String vestName = "vest user"+randomNumberString(3); 
		String Value;
		String amountValue = "10";
		
		int step=0;
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(),"Verified Login button displaying");
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+email);
		signup.enterEmailAddress(email);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+password);
		signup.enterPassword(password);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Pin Code  : "+pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified home page is displaying.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
		String searchinput = "microsoft";
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Search "+searchinput);
		browsePage.enterSearchValue(searchinput);
		
		waitTime(3000);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on First Search Element.");
		browsePage.clickOnFirstSearchElement();
		
		waitTime(3000);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Buy button.");
		browsePage.clickOnBuyButton();
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Search "+searchinput);
		browsePage.enterSharesValue("5");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Preview button.");
		browsePage.clickOnPreviewButton();
		
		waitTime(3000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Place Order button.");
		browsePage.clickOnPlaceOrderButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify successfull message is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyOrderSuccessfullMessage(),"Verified successfull message is displaying.");
		
	}

}