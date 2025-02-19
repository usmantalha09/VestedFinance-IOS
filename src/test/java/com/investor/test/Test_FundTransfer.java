package com.investor.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.errorCollectors.ErrorCollector;
import com.investor.pages.FundTransferPage;
import com.investor.pages.LoginPage;


public class Test_FundTransfer extends BaseClass {


    @Test(priority = 1)
    public void FundsTransfer() {

        initReport();
        initConfiguration();
        ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-57\">QAA-57 : iOS - Verify that user is able to initiate fund transfer<a/>");

        LoginPage loginPage = new LoginPage();
        FundTransferPage fundTransferPage = new  FundTransferPage();

        Object[][] dataArr = getData(TestDataFileName,TestDataSheetName);
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

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Transfer Menu button.");
        fundTransferPage.clickOnTransferMenuButton();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Transfer Page is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyTransferPageIsDisplaying(),"Verified Transfer Page is displaying");


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify ADD FUNDS button is displaying.");
        waitTime(3000);
        ErrorCollector.verifyTrue(fundTransferPage.verifyAddFundButtonIsDisplaying(),"Verified ADD FUNDS button is displaying");

        waitTime(70000);
        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on ADD FUNDS button.");
        fundTransferPage.clickOnAddFundsButton();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify ADD FUNDS popup is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyAddFundsPopUpIsDisplaying(),"Verified ADD FUNDS popup is displaying");


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Back Button button.");
        pressBackOnActionBar();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Withdraw Funds button is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyWithdrawFundButtonIsDisplaying(),"Verified Withdraw Funds button is displaying");


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Withdraw Funds button.");
        fundTransferPage.clickOnWithdrawFundsButton();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Withdraw Funds popup is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyWithdrawalFundsPopUpIsDisplaying(),"Verified Withdraw Funds popup is displaying");

    }


   // @Test(priority = 2)//(groups = "CashRequired")
    public void WithdrawFunds_OTPValidation() {

        initReport();
        initConfiguration();
        ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-421\">QAA-421 : iOS - Verify withdraw funds OTP validation message.<a/>");

        LoginPage loginPage = new LoginPage();
        FundTransferPage fundTransferPage = new FundTransferPage();

        Object[][] dataArr = getData(TestDataFileName,TestDataSheetName);
        String email = dataArr[0][1].toString();
        String password = dataArr[0][2].toString();
        String pinCode = dataArr[0][3].toString();

        if (isPreProdEnv) {
            email = PropertiesReader.getPropertyValue(env+"_EmailId");
            password = PropertiesReader.getPropertyValue(env+"_Password");
        }
        String amountToWithdraw = "10";
        String beneficiaryName = "Ben Name";
        String bankCountry = "India";
        String accountNumber = "3991422522";
        String accountType = "Current";
        String swiftCode = "59883";
        String bankName = "Test Bank Ltd";
        String bankAddress = "xyz street";
        String bankState = "pqr State";
        String bankCity = "test City";
        String bankZipCode = "56864";


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

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Transfer Menu button.");
        fundTransferPage.clickOnTransferMenuButton();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Transfer Page is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyTransferPageIsDisplaying(),"Verified Transfer Page is displaying");


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Withdraw Funds button is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyWithdrawFundButtonIsDisplaying(),"Verified Withdraw Funds button is displaying");

        waitTime(70000);
        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Withdraw Funds button.");
        fundTransferPage.clickOnWithdrawFundsButton();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Withdraw Funds popup is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyWithdrawalFundsPopUpIsDisplaying(),"Verified Withdraw Funds popup is displaying");

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter amount to Withdraw: "+amountToWithdraw);
        fundTransferPage.enterAmountToWithdraw(amountToWithdraw);


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Proceed button.");
        fundTransferPage.clikcOnWithdrawFundsProceedsButton();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Benificiary Name: "+beneficiaryName);
        fundTransferPage.enterbennificiaryName(beneficiaryName);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Select bank country: "+bankCountry);
        fundTransferPage.searchSelectBankCountry(bankCountry);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Account Number: "+accountNumber);
        fundTransferPage.enterAccountNumber(accountNumber);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Confirm Account Number: "+accountNumber);
        fundTransferPage.enterConfirmAccountNumber(accountNumber);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Select account type: "+accountType);
        fundTransferPage.selectAccountType(accountType);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter swift code: "+swiftCode);
        fundTransferPage.enterSwiftCode(swiftCode);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Re-type swift code: "+swiftCode);
        fundTransferPage.enterConfirmSwiftCode(swiftCode);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter bank name : "+bankName);
        fundTransferPage.enterBankName(bankName);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter bank address : "+bankAddress);
        fundTransferPage.enterBankAddress(bankAddress);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter bank state : "+bankState);
        fundTransferPage.enterBankState(bankState);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter bank city : "+bankCity);
        fundTransferPage.enterBankCity(bankCity);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter bank zip code : "+bankZipCode);
        fundTransferPage.enterBankZipCode(bankZipCode);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Continue' button");
        fundTransferPage.clickOnContinueButton();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter verification code  : "+pinCode);
        waitTime(3000);
        fundTransferPage.enterVerificationCode(pinCode);
        //loginPage.typeKeysViaKeyboard(pinCode);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify invalid OTP error message is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyInvalidWithdrawOTPErrorMessageIsDisplaying(),"Verified the error message 'You have entered an invalid OTP. Please enter the correct OTP' is displaying.");
    }


    @Test(priority = 3)
    public void Negative_AddFunds() {

        initReport();
        initConfiguration();
        ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-500\">QAA-500 : [Negetive]  IOS - Verify add funds updated flow for each different bank.<a/>");

        LoginPage loginPage = new LoginPage();
        FundTransferPage fundTransferPage = new FundTransferPage();

        Object[][] dataArr = getData(TestDataFileName,TestDataSheetName);
        String email = dataArr[0][1].toString();
        String password = dataArr[0][2].toString();
        String pinCode = dataArr[0][3].toString();

        if (isPreProdEnv) {
            email = PropertiesReader.getPropertyValue(env+"_EmailId");
            password = PropertiesReader.getPropertyValue(env+"_Password");
        }
        String invalidAmountToTransfer = "-5";
        String invalidAmountToTransfer2 = "0";
        String validAmountToTransfer = "5";


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

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Transfer Menu button.");
        fundTransferPage.clickOnTransferMenuButton();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Transfer Page is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyTransferPageIsDisplaying(),"Verified Transfer Page is displaying");


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify ADD FUNDS button is displaying.");
        waitTime(3000);
        ErrorCollector.verifyTrue(fundTransferPage.verifyAddFundButtonIsDisplaying(),"Verified ADD FUNDS button is displaying");

        waitTime(70000);
        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on ADD FUNDS button.");
        fundTransferPage.clickOnAddFundsButton();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify ADD FUNDS popup is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyAddFundsPopUpIsDisplaying(),"Verified ADD FUNDS popup is displaying");


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Indian Bank.");
        fundTransferPage.clickOnIndianBankMethod();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Search ICIC Bank");
        fundTransferPage.searchbank("ICIC");

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on ICICI Bank.");
        fundTransferPage.clickOnICIBank();
        try {
            fundTransferPage.clickOnICIBank();

        } catch (Exception e) {
            // TODO: handle exception
        }

        scrollDown();
        scrollDown();

        /*ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Upload Wire Receipt.");
        fundTransferPage.clickOnWireReceiptButton();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Please enter amount to transfer' error message is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyAmountErrorMassage(),"Verified 'Please enter amount to transfer' error message is displaying.");

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter amount to transfer: "+invalidAmountToTransfer);
        fundTransferPage.enterAmountToTransfer(invalidAmountToTransfer);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Please enter a valid amount to transfer' error message is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyEnterValidAmountErrorMassage(),"Verified 'Please enter a valid amount to transfer' error message is displaying.");

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter amount to transfer: "+validAmountToTransfer);
        fundTransferPage.enterAmountToTransfer(validAmountToTransfer);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Upload Wire Receipt.");
        fundTransferPage.clickOnWireReceiptButton();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Wire receipt date is required' error message is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyWireReceiptErrorMassage(),"Verified 'Wire receipt date is required' error message is displaying.");*/

    }

    @Test(priority = 4)
    public void VerifyAddFundsUpdatedFlowForEeachDifferentBank() {

        initReport();
        initConfiguration();
        ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-498\">QAA-498 : IOS - Verify add funds updated flow for each different bank.<a/>");

        LoginPage loginPage = new LoginPage();
        FundTransferPage fundTransferPage = new FundTransferPage();

        Object[][] dataArr = getData(TestDataFileName,TestDataSheetName);
        String email = dataArr[0][1].toString();
        String password = dataArr[0][2].toString();
        String pinCode = dataArr[0][3].toString();

        if (isPreProdEnv) {
            email = PropertiesReader.getPropertyValue(env+"_EmailId");
            password = PropertiesReader.getPropertyValue(env+"_Password");
        }
        String invalidAmountToTransfer = "-5";
        String invalidAmountToTransfer2 = "0";
        String validAmountToTransfer = "5";


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

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Transfer Menu button.");
        fundTransferPage.clickOnTransferMenuButton();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Transfer Page is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyTransferPageIsDisplaying(),"Verified Transfer Page is displaying");


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify ADD FUNDS button is displaying.");
        waitTime(3000);
        ErrorCollector.verifyTrue(fundTransferPage.verifyAddFundButtonIsDisplaying(),"Verified ADD FUNDS button is displaying");

        waitTime(70000);
        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on ADD FUNDS button.");
        fundTransferPage.clickOnAddFundsButton();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify ADD FUNDS popup is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyAddFundsPopUpIsDisplaying(),"Verified ADD FUNDS popup is displaying");


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Indian Bank.");
        fundTransferPage.clickOnIndianBankMethod();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Search ICIC Bank");
        fundTransferPage.searchbank("ICIC");

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on ICICI Bank.");
        fundTransferPage.clickOnICIBank();
        try {
            fundTransferPage.clickOnICIBank();

        } catch (Exception e) {
            // TODO: handle exception
        }



//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on ICICI Bank.");
//        fundTransferPage.clickOnICIBank();

        scrollDown();

        /*ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter amount to transfer: "+validAmountToTransfer);
        fundTransferPage.enterAmountToTransfer(validAmountToTransfer);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Date DropDown");
        fundTransferPage.clickOnDatedropDown();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Confirm Date.");
        fundTransferPage.clickOnDateConfirm();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Upload Wire Receipt.");
        fundTransferPage.clickOnWireReceiptButton();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Chose from gallery'.");
        fundTransferPage.clickOnChoseFromGallery();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on image in the gallery");
        fundTransferPage.clickOnGalleryImage();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify the success message is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyTransferConfirmationIsDisplaying(),"Verified the success message is displaying");*/

    }

    @Test(priority = 5)
    public void VerifyAddFundsFlowWithGlobalUser() {

        initReport();
        initConfiguration();
        ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-531\">QAA-531 : IOS - Verify Add Funds Flow With Global User.<a/>");

        LoginPage loginPage = new LoginPage();
        FundTransferPage fundTransferPage = new FundTransferPage();

        Object[][] dataArr = getData(TestDataFileName,TestDataSheetName);
        String email = dataArr[0][1].toString();
        String password = dataArr[0][2].toString();
        String pinCode = dataArr[0][3].toString();

        if (isPreProdEnv) {
            email = PropertiesReader.getPropertyValue(env+"_EmailId");
            password = PropertiesReader.getPropertyValue(env+"_Password");
        }
        String invalidAmountToTransfer = "-5";
        String invalidAmountToTransfer2 = "0";
        String validAmountToTransfer = "5";


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

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Transfer Menu button.");
        fundTransferPage.clickOnTransferMenuButton();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Transfer Page is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyTransferPageIsDisplaying(),"Verified Transfer Page is displaying");


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify ADD FUNDS button is displaying.");
        waitTime(3000);
        ErrorCollector.verifyTrue(fundTransferPage.verifyAddFundButtonIsDisplaying(),"Verified ADD FUNDS button is displaying");

        waitTime(70000);
        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on ADD FUNDS button.");
        fundTransferPage.clickOnAddFundsButton();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify ADD FUNDS popup is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyAddFundsPopUpIsDisplaying(),"Verified ADD FUNDS popup is displaying");


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on International Bank.");
        waitTime(1000);
        scrollDown();
        fundTransferPage.clickOnInternationalBank();

        waitTime(3000);
        scrollDown();
        scrollDown();



        /*
        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Further Credit To Copy Button.");
        fundTransferPage.clickOnfurtherCreditToCopyBtn();

       try {



        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify further credit can be copied.");
        ErrorCollector.assertEquals(fundTransferPage.getFurtherCreditToText(), getClipboardText());

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on benificiary name Copy Button.");
        fundTransferPage.clickOnaddFundsNameCopyBtn();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify benificiary name can be copied.");
        ErrorCollector.assertEquals(fundTransferPage.getaddFundsNameText(), getClipboardText());

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on benificiary Acc no Copy Button.");
        fundTransferPage.clickOnaddFundsAccNoCopyBtn();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify benificiary Acc no can be copied.");
        ErrorCollector.assertEquals(fundTransferPage.getaddFundsAccNoText(), getClipboardText());

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on benificiary Email Copy Button.");
        fundTransferPage.clickOnaddFundsEmailCopyBtn();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify benificiary Email can be copied.");
        ErrorCollector.assertEquals(fundTransferPage.getaddFundsEmailText(), getClipboardText());

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on benificiary Phone Copy Button.");
        fundTransferPage.clickOnaddFundsPhoneCopyBtn();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify benificiary Phone can be copied.");
        ErrorCollector.assertEquals(fundTransferPage.getaddFundsPhoneText(), getClipboardText());
       } catch (Exception e) {
   		//e.printStackTrace();
   	}*/

      /* scrollDown();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter amount to transfer: "+validAmountToTransfer);
        fundTransferPage.enterAmountToTransfer(validAmountToTransfer);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Date DropDown");
        fundTransferPage.clickOnDatedropDown();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Confirm Date.");
        fundTransferPage.clickOnDateConfirm();

        waitTime(5000);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Upload Wire Receipt.");
        fundTransferPage.clickOnWireReceiptButton();



        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Chose from gallery'.");
        fundTransferPage.clickOnChoseFromGallery();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on image in the gallery");
        fundTransferPage.clickOnGalleryImage();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify the success message is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyTransferConfirmationIsDisplaying(),"Verified the success message is displaying");*/


    }

    @Test(priority = 6)
    public void VerifyAddFundsFlowWithIndianUser() {

        initReport();
        initConfiguration();
        ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-558\">QAA-558 : IOS - Verify Add Funds Flow With Indian User.<a/>");

        LoginPage loginPage = new LoginPage();
        FundTransferPage fundTransferPage = new FundTransferPage();

        Object[][] dataArr = getData(TestDataFileName,TestDataSheetName);
        String email = dataArr[0][1].toString();
        String password = dataArr[0][2].toString();
        String pinCode = dataArr[0][3].toString();

        if (isPreProdEnv) {
            email = PropertiesReader.getPropertyValue(env+"_EmailId");
            password = PropertiesReader.getPropertyValue(env+"_Password");
        }
        String invalidAmountToTransfer = "-5";
        String invalidAmountToTransfer2 = "0";
        String validAmountToTransfer = "5";


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

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Transfer Menu button.");
        fundTransferPage.clickOnTransferMenuButton();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Transfer Page is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyTransferPageIsDisplaying(),"Verified Transfer Page is displaying");


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify ADD FUNDS button is displaying.");
        waitTime(3000);
        ErrorCollector.verifyTrue(fundTransferPage.verifyAddFundButtonIsDisplaying(),"Verified ADD FUNDS button is displaying");

        waitTime(70000);
        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on ADD FUNDS button.");
        fundTransferPage.clickOnAddFundsButton();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'International Bank' is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifySelectInternationalBankIsDisplaying(),"Verified 'International Bank' is displaying.");


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Indian Bank' is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifySelectIndianBankIsDisplaying(),"Verified 'Indian Bank' is displaying.");


//        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Proceed with Vested Direct' is displaying.");
//        ErrorCollector.verifyTrue(fundTransferPage.verifyProceedWithVestedButtonIsDisplaying(),"Verified 'Proceed with Vested Direct' is displaying.");


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Indian Bank.");
        fundTransferPage.clickOnIndianBankMethod();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Search ICIC Bank");
        fundTransferPage.searchbank("ICIC");

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on ICICI Bank.");
        fundTransferPage.clickOnICIBank();
        try {
            fundTransferPage.clickOnICIBank();

        } catch (Exception e) {
            // TODO: handle exception
        }



        /*ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Downlaod Instruction");
        fundTransferPage.clickOnDownloadInstructionsBtn();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'OK' Button");
        fundTransferPage.clickOnOkBtn();;

        scrollDown();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter amount to transfer: "+validAmountToTransfer);
        fundTransferPage.enterAmountToTransfer(validAmountToTransfer);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Date DropDown");
        fundTransferPage.clickOnDatedropDown();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Confirm Date.");
        fundTransferPage.clickOnDateConfirm();

        scrollDown();
        waitTime(5000);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Upload Wire Receipt.");
        fundTransferPage.clickOnWireReceiptButton();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Choose from gallery'.");
        fundTransferPage.clickOnChoseFromGallery();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on image in the gallery");
        fundTransferPage.clickOnGalleryImage();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify the success message is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyTransferConfirmationIsDisplaying(),"Verified the success message is displaying");

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Ok Got It' Button");
        fundTransferPage.clickOnOkGotItBtn();

        //for international bank
      waitTime(70000);
        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on ADD FUNDS button.");
        fundTransferPage.clickOnAddFundsButton();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify ADD FUNDS popup is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyAddFundsPopUpIsDisplaying(),"Verified ADD FUNDS popup is displaying");


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on International Bank.");
        fundTransferPage.clickOnInternationalBank();

        scrollDown();*/

        /*
        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Further Credit To Copy Button.");
        fundTransferPage.clickOnfurtherCreditToCopyBtn();

       try {



        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify further credit can be copied.");
        ErrorCollector.assertEquals(fundTransferPage.getFurtherCreditToText(), getClipboardText());

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on benificiary name Copy Button.");
        fundTransferPage.clickOnaddFundsNameCopyBtn();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify benificiary name can be copied.");
        ErrorCollector.assertEquals(fundTransferPage.getaddFundsNameText(), getClipboardText());

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on benificiary Acc no Copy Button.");
        fundTransferPage.clickOnaddFundsAccNoCopyBtn();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify benificiary Acc no can be copied.");
        ErrorCollector.assertEquals(fundTransferPage.getaddFundsAccNoText(), getClipboardText());

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on benificiary Email Copy Button.");
        fundTransferPage.clickOnaddFundsEmailCopyBtn();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify benificiary Email can be copied.");
        ErrorCollector.assertEquals(fundTransferPage.getaddFundsEmailText(), getClipboardText());

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on benificiary Phone Copy Button.");
        fundTransferPage.clickOnaddFundsPhoneCopyBtn();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify benificiary Phone can be copied.");
        ErrorCollector.assertEquals(fundTransferPage.getaddFundsPhoneText(), getClipboardText());
       } catch (Exception e) {

   	}
        */
       /* scrollDown();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter amount to transfer: "+validAmountToTransfer);
        fundTransferPage.enterAmountToTransfer(validAmountToTransfer);

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Date DropDown");
        fundTransferPage.clickOnDatedropDown();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Confirm Date.");
        fundTransferPage.clickOnDateConfirm();

        waitTime(5000);
        scrollDown();



        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Upload Wire Receipt.");
        fundTransferPage.clickOnWireReceiptButton();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Choose from gallery'.");
        fundTransferPage.clickOnChoseFromGallery();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on image in the gallery");
        fundTransferPage.clickOnGalleryImage();

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify the success message is displaying.");
        ErrorCollector.verifyTrue(fundTransferPage.verifyTransferConfirmationIsDisplaying(),"Verified the success message is displaying");

        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Ok Got It' Button");
        fundTransferPage.clickOnOkGotItBtn();


        // for proceed with vested button
          waitTime(70000);
        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on ADD FUNDS button.");
        fundTransferPage.clickOnAddFundsButton();


        ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Proceed with vested' Button.");
        fundTransferPage.clickOnProceedWithVestedBtn();

        if(fundTransferPage.isBankServerOfflineMessageDisplaying()) {
        	ErrorCollector.extentLogInfo("Step "+(++step)+" : Bank servers are offline message is displaying.");
        }else {
        	ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Vested Direct Account Pop up' is displaying.");
            ErrorCollector.verifyTrue(fundTransferPage.verifyVestedDirectAccountPopUp(),"Verified  'Vested Direct Account Pop up' is displaying.");


            ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Open Vested Direct Account' Button.");
            fundTransferPage.clickOnDirectVestedAccBtn();

            ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Close' Button.");
            fundTransferPage.clickOnCloseBtn();

            ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Mobile Verification Page' is displaying.");
            ErrorCollector.verifyTrue(fundTransferPage.verifyVestedDirectAccountPopUp(),"Verified  'Mobile Verification Page' is displaying.");

        }*/
    }

}
