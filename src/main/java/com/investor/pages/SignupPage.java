package com.investor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.investor.base.BaseClass;
import com.investor.utilities.Waits;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.offset.PointOption;

public class SignupPage extends BaseClass {
	
	@FindBy(xpath ="//XCUIElementTypeTextField")
	public WebElement emailInput;

	@FindBy(xpath = "//XCUIElementTypeSecureTextField")
	public WebElement passwordInput;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Sign Up']")
	public WebElement signUpButton;
	
	By signUpButtonBy = By.xpath("//XCUIElementTypeOther[@name='Sign Up']");
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Sign Up with email']")
	public WebElement signUpButtonWithEmail;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Sign Up']")
	public WebElement btnSubmitSignup;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='signUpWithEmailSignUpBtn']")
	public WebElement btnSubmitSignup_2;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Verification Code']")
	public WebElement verificationCodeScreen;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='chevron_left']")
	public WebElement actionbarBackBtn;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='verifyOtpHeaderBackIcon']")
	public WebElement actionbarBackBtn_1;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='signUpWithEmailHeaderBackIcon']")
	public WebElement actionbarBackBtn_2;
	
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='kycBasicsScreenPhoneNumberInput']")
	public WebElement mobileNumberEditText;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='kycBasicsScreenSendOtpBtn']")
	public WebElement sendOTPButton;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='kycBasicsScreenResendOtpBtn']")
	public WebElement resendOTPButton;
	
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='kycMobileVerificationReceiveOTPViaCall']")
	public WebElement recieveOTPViaCallButton;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='kycMobileVerificationSkip']")
	public WebElement continueAnywayButton;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'UPLOAD PAN CARD')]")
	public WebElement uploadPanCardButton;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='CONFIRM']")
	public WebElement panCardConfirmButton;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='UPLOAD']")
	public WebElement uploadButtonPanCardDialog;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Choose from Gallery...']")
	public WebElement chooseFromGalleryButton;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Show roots']")
	public WebElement drawerNavigation;
	
	@FindBy(xpath = "(//android.widget.TextView[contains(@text,'download')] | //android.widget.TextView[contains(@text,'Download')])[1]")
	public WebElement downloadFolder;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.android.documentsui:id/item_root']")
	public WebElement cardImage;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Pan Card Uploaded Successfully')]")
	public WebElement panCardUploadedSuccessfully;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='UPLOAD AADHAAR']")
	public WebElement uploadAadhaarCardButton;
	
	@FindBy(xpath = "//android.widget.EditText[contains(@text,'Address Line 1')]")
	public WebElement addressLine1EditText;
	
	@FindBy(xpath = "//android.widget.EditText[contains(@text,'City')]")
	public WebElement cityEditText;
	
	@FindBy(xpath = "//android.widget.EditText[contains(@text,'PinCode')]")
	public WebElement pinCodeEditText;

	@FindBy(xpath = "(//android.widget.TextView[@text='State'])[last()]/parent::android.view.ViewGroup")
	public WebElement stateDropDown;
	
	@FindBy(xpath = "(//android.widget.TextView[contains(@text,'I confirm that the information outlined')]/preceding-sibling::android.view.ViewGroup)[last()]")
	public WebElement checkboxIConfirmedInformation;

	@FindBy(xpath = "(//android.widget.TextView[contains(@text,'I agree to Drivewealth’s Privacy')]/preceding-sibling::android.view.ViewGroup)[last()]")
	public WebElement checkboxIAgreeDriveWealthPolicy;

	@FindBy(xpath = "//android.widget.EditText[@text='Enter Your Full Name']")
	public WebElement fullNameEditText;

	@FindBy(xpath = "//android.widget.TextView[@text='Your KYC form is submitted']")
	public WebElement kycSubmittedMessage;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Aadhaar uploaded')]")
	public WebElement aadhaarSubmittedMessage;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Nationality']/XCUIElementTypeTextField")
	public WebElement nationalityField;
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='United Arab Emirates'])[last()]")
	public WebElement nationalityFieldDropdownSelector;

	@FindBy(xpath = "//android.widget.EditText[contains(@text,'Enter your SSN')]")
	public WebElement ssnNumberEditText;

	@FindBy(xpath = "//android.widget.EditText[contains(@text,'Passport file no')]")
	public WebElement passportFileNoEditText;

	@FindBy(xpath = "//android.widget.TextView[@text='UPLOAD PASSPORT']")
	public WebElement uploadPassportButton;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Passport Uploaded Successfully')]")
	public WebElement passportUploadedSuccessfully;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Tax ID number']//XCUIElementTypeTextField")
	public WebElement taxIdNumEditText;
	
	@FindBy(xpath = "//android.widget.EditText[contains(@text,'State')]")
	public WebElement stateEditText;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name='AWESOME!']")
	public WebElement welcomeToVestedPopupAwsomeBtn;
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='ACCEPT AND CONTINUE'])[last()]")
	public WebElement acceptAndContinueBtn;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='genderSelector_0']")
	public WebElement genderMaleOption;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Female']")
	public WebElement genderFemaleOption;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='maritalStatus_0']")
	public WebElement maritalStatusSingleOption;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='securitySelectStatus_4']")
	public WebElement employmentUnemployedOption;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='None of the these apply to me']")
	public WebElement checkAnyThatApplytoYouLabel;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='basicsCheckboxNoneOfAbove']")
	public WebElement noneOfTheTheseApplyToMeCheckBox;
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='Next'])[last()]")
	public WebElement nextBtn;
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='personalizationSelectRiskTolerance_i'])[1] | //XCUIElementTypeOther[@name='personalizationSelectRiskTolerance_0']")
	public WebElement riskToleranceLowOption;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='personalizationSelectInvestmentObjectives_0']")
	public WebElement severalTimesAWeekOption;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='personalizationSelectInvestmentExperience_0']")
	public WebElement investingExperience0To1Year;
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='0 to 10 lakh rupees'])[1]")
	public WebElement yearlyIncome0To10LakhRupees;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='0 - 5 lakh rupees']")
	public WebElement liquidNetWorth0To5LakhRupees;
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='0 to 10 lakh rupees'])[2]")
	public WebElement totalNetWorth0T010LakhRupees;
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='Select source'])[2]")
	public WebElement primarySourceSelectSourceDropDownBtn;
	
	@FindBy(xpath = "//*[@name='Gift']")
	public WebElement primarySourceSelectSourceDropDownGiftOption;
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='6 to 10'])[1]")
	public WebElement depositsAndWithdrawals6To10;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='0 to 50,000 rupees (0 to 700 U.S. dollars)']")
	public WebElement moneyPlanToDeposits0To50000;
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='s0 to 5'])[2]")
	public WebElement investments0To5;
	
	@FindBy(xpath = "//android.widget.TextView[@text='India']")
	public WebElement primaryTaxFilesCountryIndia;
	
	@FindBy(xpath = "//android.widget.TextView[@text='NO']")
	public WebElement mobileNumberLinkedWithAdharNo;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='signUpSuccessStartKycBtn']")
	public WebElement StartKYCButton;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name='Login'])[6]")
	private WebElement btnLoginSignupPage;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Verification Code']/following-sibling:: XCUIElementTypeOther//XCUIElementTypeTextField")
	private WebElement inputVerificationCode;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Confirm Account']")
	private WebElement btnConfirmAccount;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='verifyOtpConfirmAccount']")
	private WebElement confirmAccountBtn_2;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Confirm Account']/following-sibling:: XCUIElementTypeStaticText")
	private WebElement verificationCodeErrorMessage;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Invalid verification code provided, please try again.']")
	private WebElement verificationCodeErrorMessage_2;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='personalizationSelectAnnualIncome_0']")
	private WebElement yearlyIncome0T030000;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='personalizationSelectNetworthLiquid_0']")
	private WebElement liquidNetWorth0To15000Dollars;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='personalizationSelectNetworthTotal_0']")
	private WebElement totalNetWorth0To30000Dollars;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Select source']")
	private WebElement primarySourceOfIncomeDrropdown;
	
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='Gift'])[last()]")
	private WebElement primarySourceOfIncomeGift;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='personalizationSelectTransferFrequencyPerMonth_0']")
	private WebElement frequencyIn12Months11;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='personalizationSelectTransferTotalExpected_0']")
	private WebElement deposit0To5000;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='personalizationSelectInvestmentHistory12M_0']")
	private WebElement Investments0To5;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='kycGlobalIdentityVerification']")
	private WebElement verifyYourIdentityButton;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Verify your identity']")
	private WebElement popUpIdentityVerification;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='ACCEPT AND PROCEED']")
	private WebElement btnAcceptAndProceed;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
	private WebElement okButtonTermsAccepted;

	@FindBy(xpath = "(//*[contains(@name,'AWESOME!')])[last()]")
	private WebElement awesomeButtonInModal;

	@FindBy(xpath = "(//*[contains(@name,'GREAT!')])[last()]")
	private WebElement greatButtonInModal;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Start KYC process']")
	private WebElement startKYCProcessButton;

	@FindBy(xpath = "(//XCUIElementTypeTextField[@name='searchCountryTermTextInput'])[last()] | //XCUIElementTypeTextField[@name='kycBasicsScreenPrimaryTaxResidencyInput']")
	private WebElement taxResidencyField;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='undefined_1']")
	private WebElement mobileLinkedWithAadharNoButton;

	@FindBy(xpath = "(//*[contains(@name,'DONE')])[last()]")
	private WebElement doneButtonInModal;
	
	

	public SignupPage() {
		PageFactory.initElements(driver, this);
	}
	
    public void enterEmailAddress(String email) {
    	Waits.wait6s();
    	sendKeysToWebElement(emailInput, email);
	}
    
    public void enterPassword(String pass) {
    	sendKeysToWebElement(passwordInput, pass);
	}
    
    public void clickOnSignUpButton(){
    	scrollIntoViewSmoothly(signUpButton);
    	waitTime(1000);
       click(signUpButton);
    }
    
    public boolean verifySignUpButtonShowing(){
        return isElementDisplayed(signUpButton);
    }
    
//    public boolean verifySignUpButton() {
//    	IOSElement element = waitForElementToBePresent(signUpButtonBy,10 );
//    	return isElementDisplayedIOS(element);
//    }

    public void clickOnSignUpWithEmailButton(){
    	click(signUpButtonWithEmail);
    }
    
    public boolean verifySignUpWithEmailButtonShowing(){
        return isElementDisplayed(signUpButtonWithEmail);
    }
        
    public void clickOnSubmitSignupButton() {
    	try {
    		waitForElementToBeClickable(btnSubmitSignup_2, 20);
    		click(btnSubmitSignup_2);
    	} catch (Exception e) {
			waitForElementToBeClickable(btnSubmitSignup, 20);
	    	click(btnSubmitSignup);
		}
    }
    
    public boolean verifyOTPScreenIsDisplaying(){
        waitForElementToBePresent(verificationCodeScreen, 20);
        return isElementDisplayed(verificationCodeScreen);
    }
    
    public void clickOnBackButton() {
    	try {
    		try {
    			waitForElementToBeClickable(actionbarBackBtn_1, 20);
    			click(actionbarBackBtn_1);
			} catch (Exception e) {
    			waitForElementToBeClickable(actionbarBackBtn_2, 20);
    			click(actionbarBackBtn_2);
			}
		} catch (Exception e) {
			waitForElementToBeClickable(actionbarBackBtn, 20);
			click(actionbarBackBtn);
		}
    }
    
    public void clickOnStartKYCButton() {
        clickWebElement(StartKYCButton);
    }
    
    public void clickOnWelcomeToVestedAwsomeButton() {
        waitForElementToBeClickable(welcomeToVestedPopupAwsomeBtn, 30);
        click(welcomeToVestedPopupAwsomeBtn);
    }
    
    public void clickOnAcceptAndContinueButton() {
    	try {
    		waitTime(3000);
            waitForElementToBeClickable(acceptAndContinueBtn, 30);
            click(acceptAndContinueBtn);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    public void clickOnGenderMaleOption() {
        clickWebElement(genderMaleOption);
    }
    
    public void clickOnMaritalStatusSingleOption() {
        waitForElementToBeClickable(maritalStatusSingleOption, 30);
        click(maritalStatusSingleOption);
    }
    
    public void clickOnUnemployedOption() {
		scrollToText("Unemployed");
		waitTime(1000);
		waitForElementToBeClickable(employmentUnemployedOption, 30);
        click(employmentUnemployedOption);
    }
    
    public void clickOnNoneOfTheTheseApplyToMeCheckBox() {
		scrollToText("None of the these apply to me");
		waitTime(1000);
        clickWebElement(noneOfTheTheseApplyToMeCheckBox);
    }
    
    public void clickOnNextButton() {
        waitForElementToBeClickable(nextBtn, 30);
        click(nextBtn);
        waitTime(2000);
    }
    
    public void clickOnRiskToleranceLowOption() {
        clickWebElement(riskToleranceLowOption);
    }
    
    public void clickOnSeveralTimesAWeek() {
        clickWebElement(severalTimesAWeekOption);
    }
    
    public void clickOnInvestingExperience0To1Year() {
		scrollToText("0 to 1 year");
		waitTime(1000);
		clickWebElement(investingExperience0To1Year);
    }
    
    public void clickOnYearlyIncome0To300000() {
		clickWebElement(yearlyIncome0T030000);
	}
    
    public void clickOnYearlyIncome0To10Lac() {
		scrollToText("0 to 10 lakh rupees");
		waitTime(1000);
		clickWebElement(yearlyIncome0To10LakhRupees);
    }
    
    public void clickOnLiquidNetWorth0To5LakhRupees() {
		scrollToText("0 - 5 lakh rupees");
		waitTime(1000);
		clickWebElement(liquidNetWorth0To5LakhRupees);
    }
    
    public void clickOnTotalNetWorth0To10LakhRupees() {
		scrollToText("Total net worth (liquid net worth + all other assets)");
		waitTime(3000);
		clickWebElement(totalNetWorth0T010LakhRupees);
    }
    
    public void clickOnprimarySourceSelectSourceDropDownGiftOption() {
		scrollToText("Select source");
		waitTime(1000);
		waitForElementToBeClickable(primarySourceSelectSourceDropDownBtn, 30);
        click(primarySourceSelectSourceDropDownBtn);
        waitTime(2000);
        waitForElementToBeClickable(primarySourceSelectSourceDropDownGiftOption, 30);
        click(primarySourceSelectSourceDropDownGiftOption);
    }
    
    public void clickOnDepositsAndWithdrawals6To10() {
		scrollToTextContains("how many deposits and withdrawals");
		waitTime(1000);
		waitForElementToBeClickable(depositsAndWithdrawals6To10, 30);
        click(depositsAndWithdrawals6To10);
        
    }
    
    public void clickOnMoneyPlanToDeposits0To50000() {
		scrollToText("0 to 50,000 rupees (0 to 700 U.S. dollars)");
		waitTime(1000);
		waitForElementToBeClickable(moneyPlanToDeposits0To50000, 30);
        click(moneyPlanToDeposits0To50000);
    }
    
    public void clickOnInvestments0To5() {
		scrollToText("0 to 50,000 rupees (0 to 700 U.S. dollars)");
		waitTime(1000);
		swipeUp();
		waitForElementToBeClickable(investments0To5, 30);
        click(investments0To5);
    }
    
    public void clickOnPrimaryTaxFilesCountryIndia() {
		waitForElementToBeClickable(primaryTaxFilesCountryIndia, 30);
        click(primaryTaxFilesCountryIndia);
    }
    
    public void clickOnMobileNumberLinkedWithAdhar() {
		waitForElementToBeClickable(mobileNumberLinkedWithAdharNo, 30);
        click(mobileNumberLinkedWithAdharNo);
    }
    
    public void enterMobileNumber(String number) {
		scrollToText("SEND OTP");
		waitTime(1000);
		mobileNumberEditText.sendKeys(number);
	}
    
    public void enterMobileNumberWithOutScroll(String number) {
//		scrollToText("SEND OTP");
//		waitTime(1000);
		waitForElementToBeClickable(mobileNumberEditText, 30);
		mobileNumberEditText.sendKeys(number);
	}

	public void clickOnSendOTPButton() {
		scrollToText("SEND OTP");
		waitTime(2000);
		waitForElementToBeClickable(sendOTPButton, 30);
        click(sendOTPButton);
	}

	public void clickOnResendOTPButton() {
		waitForElementToBeClickable(resendOTPButton, 30);
        click(resendOTPButton);
	}

	public void clickOnRecieveOTPViaCallButton() {
		scrollToTextContains("OTP via call");
		waitTime(1000);
        tapOnElementRight(recieveOTPViaCallButton);
	}
	
	public void clickOnRecieveOTPViaCallButtonWithOutScroll() {
//		scrollToTextContains("OTP via call");
//		waitTime(1000);
        tapOnElementRight(recieveOTPViaCallButton);
	}
	
	public void clickOnContinueAnyWayButton() {
        tapOnElementRight(continueAnywayButton);
	}
	
	public void clickOnUploadPanCardButton() {
		scrollToText("UPLOAD PAN CARD");
		waitTime(2000);
		waitForElementToBeClickable(uploadPanCardButton, 30);
        click(uploadPanCardButton);
	}
	
	public void clickOnPanCardConfirmButton() {
        clickWebElement(panCardConfirmButton);
	}
	
	protected void tapAtPoint(Point point) {
		
//	    PointerInput input = new PointerInput(Kind.TOUCH, "finger1");
//	    Sequence tap = new Sequence(input, 0);
//	    tap.addAction(input.createPointerMove(Duration.ZERO, Origin.viewport(), point.x, point.y));
//	    tap.addAction(input.createPointerDown(MouseButton.LEFT.asArg()));
//	    tap.addAction(new Pause(input, Duration.ofMillis(200)));
//	    tap.addAction(input.createPointerUp(MouseButton.LEFT.asArg()));
//	    getDriver().perform(ImmutableList.of(tap));
		
		
		//((JavascriptExecutor) driver).executeScript("el = document.elementFromPoint("+point.x+", "+point.y+"); el.click();");
	
		TouchAction touchAction=new TouchAction(driver);
		touchAction.tap(PointOption.point(point.x, point.y)).perform();
	}
	
	protected void tapOnElementRight(WebElement el) {
	    Rectangle elRect = el.getRect();
	    Point point = new Point(
	        elRect.x + (int)(elRect.getWidth() / 1.5),
	        elRect.y + (int)(elRect.getHeight() / 1.5)
	    );
	    tapAtPoint(point);
	}

	public void clickOnUploadButtonPanCardDialog() {
        clickWebElement(uploadButtonPanCardDialog);
	}
	
	public void clickOnChooseFromGalleryButton() {
        clickWebElement(chooseFromGalleryButton);
	}

	public void selectCardImage(String name) {
			printString(driver.getPageSource());
			waitForElementToBeClickable(drawerNavigation, 30);
	        click(drawerNavigation);
	        click(downloadFolder);
	        WebElement image = driver.findElement(By.xpath("//*[@text='"+name+"']"));
	        waitForElementToBeClickable(image, 30);
	        click(image);
	}
	
	public boolean verifyPANCardUploadedSuccessfully(){
        waitForElementToBeClickable(panCardUploadedSuccessfully, 20);
        return isElementDisplayed(panCardUploadedSuccessfully);
    }
	
	public void clickOnUploadAadhaarCardButton() {
        clickWebElement(uploadAadhaarCardButton);
	}
	
	public void enterAddressLine1(String address) {
		scrollToText("Address Line 2");
		waitTime(1000);
		scrollIntoViewSmoothly(addressLine1EditText);
		addressLine1EditText.sendKeys(address);
	}    
	
	public void enterCity(String city) {
		scrollToText("City");
		waitTime(1000);
		waitTime(1000);
		waitForElementToBePresent(cityEditText, 30);
		cityEditText.sendKeys(city);
	} 
    
	public void enterPin(String pin) {
		swipeUp();
		waitTime(500);
		scrollToText("Next");
		waitTime(1000);
		swipeUp();
		waitTime(1000);
		waitForElementToBePresent(pinCodeEditText, 30);
		pinCodeEditText.sendKeys(pin);
	}

	public void selectState(String state) {
		scrollToText("State");
		waitTime(1000);
		swipeUpSlightly();
		waitTime(500);
		waitForElementToBeClickable(stateDropDown, 30);
		click(stateDropDown);
		waitTime(2000);
		scrollToText(state);
		waitTime(1000);
		WebElement stateElement = driver.findElement(By.xpath("//android.widget.TextView[@text='"+state+"']/.."));
		stateElement.click();
	}

	public void checkIConfirmInfoCheckBox() {
		scrollToTextContains("I confirm that the information outlined");
		waitTime(1000);
		waitForElementToBeClickable(checkboxIConfirmedInformation, 30);
		click(checkboxIConfirmedInformation);
	}

	public void checkIAgreeDriveWealthPrivacyPolicy() {
		waitForElementToBeClickable(checkboxIAgreeDriveWealthPolicy, 30);
		click(checkboxIAgreeDriveWealthPolicy);
	}

	public void enterFullName(String name) {
		fullNameEditText.sendKeys(name);
	}

	public boolean verifyKYCSubmittedSuccessfully() {
	   waitForElementToBePresent(kycSubmittedMessage, 30);
		return kycSubmittedMessage.isDisplayed();
	}

	public boolean verifyAsdhaarCardUploadedSuccessfully() {
		waitForElementToBePresent(aadhaarSubmittedMessage, 30);
		return aadhaarSubmittedMessage.isDisplayed();
	} 
	
	
	public void enterSSNNumber(String num) {
		waitForElementToBeClickable(ssnNumberEditText, 30);
		ssnNumberEditText.sendKeys(num);
	}
	
	public void enterPassportFileNumber(String num) {
		waitForElementToBeClickable(passportFileNoEditText, 30);
		passportFileNoEditText.sendKeys(num);
	}
	
	public void clickOnUploadPassportButton() {
		scrollToText("UPLOAD PASSPORT");
		waitTime(2000);
		waitForElementToBeClickable(uploadPassportButton, 30);
        click(uploadPassportButton);
	}
	
	public boolean verifyPassportUploadedSuccessfully(){
        waitForElementToBeClickable(passportUploadedSuccessfully, 20);
        return isElementDisplayed(passportUploadedSuccessfully);
    }

	public void enterTaxIdNumber(String taxIdNumber) {
		taxIdNumEditText.sendKeys(taxIdNumber);
	}

	public void enterState(String state) {
		swipeUp();
		waitTime(1000);
		waitForElementToBeClickable(stateEditText, 30);
		stateEditText.sendKeys(state);
	}

	public void clickOnLoginButton() {
		waitForElementToBeClickable(btnLoginSignupPage, 30);
		click(btnLoginSignupPage);
		
	}
	
	public void enterVerificationCode(String code) {
    	sendKeysToWebElement(inputVerificationCode, code);
	}

	public void clickOnConfirmAccountButton() {
		try {
			waitForElementToBeClickable(confirmAccountBtn_2, 30);
			click(confirmAccountBtn_2);
			
		} catch (Exception e) {
			waitForElementToBeClickable(btnConfirmAccount, 30);
			click(btnConfirmAccount);
		}
	}
	
	public String getVerificationCodeErrorMessage() {
		
		try {
			waitForElementToBePresent(verificationCodeErrorMessage_2, 30);
			return getElementText(verificationCodeErrorMessage_2);
			
		} catch (Exception e) {
			waitForElementToBePresent(verificationCodeErrorMessage, 30);
			return getElementText(verificationCodeErrorMessage);
		}
	}
	
	public boolean verifyPINErrorMessageIsDisplaying() {
		
		try {
			waitForElementToBePresent(verificationCodeErrorMessage_2, 30);
			return isElementDisplayed(verificationCodeErrorMessage_2);
		} catch (Exception e) {
			waitForElementToBePresent(verificationCodeErrorMessage, 30);
			return isElementDisplayed(verificationCodeErrorMessage);
		}
	}
	
	public void selectNationality(String nationality) {
		sendKeysToElement(nationalityField, nationality, "nationality");
		waitTime(1000);
		clickWebElement(getDriver().findElement(By.xpath("(//XCUIElementTypeOther[@name='"+nationality+"'])[last()]")));
	}

	public void selectTaxResidency(String nationality) {
		try {
			getDriver().findElement(By.xpath("(//XCUIElementTypeStaticText[@name='close'])[2]")).click();
			waitTime(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		sendKeysToElementWithoutReturn(taxResidencyField, nationality, "Tax Residency");
		waitTime(2000);
//		try {
//			getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name='search']")).click();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		clickWebElement(getDriver().findElement(By.xpath("(//XCUIElementTypeOther[@name='"+nationality+"'])[last()]")));
	}
	
	public void sendKeysToElementWithoutReturn(WebElement element, String keys,String elementLabel) {
		//ExtentTestManager.getTest().info("Entering "+ elementLabel + ": " + keys);\
		element.clear();
		element.sendKeys(keys);
	}

	public void clickOnLiquidNetWorth0To150000() {
		clickWebElement(liquidNetWorth0To15000Dollars);
	}

	public void clickOnNetWorth0To300000() {
		clickWebElement(totalNetWorth0To30000Dollars);
	}

	public void selectPrimarySourceOfIncome() {
		clickWebElement(primarySourceOfIncomeDrropdown);
		waitTime(1000);
		clickWebElement(primarySourceOfIncomeGift);
	}

	public void selectFrequency11() {
		clickWebElement(frequencyIn12Months11);
	}

	public void selectExpectedDepositInNext12Months() {
		clickWebElement(deposit0To5000);
	}
	public void selectExpectedInvestmentsInNext12Months() {
		clickWebElement(Investments0To5);
	}

	public void clickOnIdentityVerification() {
		clickWebElement(verifyYourIdentityButton);
	}

	public boolean verifyIdentityVerificationModalIsDisplaying() {
		return isElementDisplayed(popUpIdentityVerification);
	}

	public void clickOnAcceptAndProceedButton() {
		clickWebElement(acceptAndContinueBtn);
	}

	public void clickOnOkButtonInTermsAcceptedModal() {
		try {
			clickWebElement(okButtonTermsAccepted);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickOnAwesomeButtonInModal() {
		try {
			clickWebElement(awesomeButtonInModal);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickOnGreateButtonInModal() {
		try {
			click(greatButtonInModal);
		}catch(Exception e) {}
	}
	
	public void clickOnStartKycProcessButton() {
		try {
			clickWebElement(startKYCProcessButton);
		} catch (Exception e) {
			System.out.println("Start KYC Process Button Not Displaying");
		}
	}

	public void clickOnMobileLinkedWithAadharNoButton() {
		clickWebElement(mobileLinkedWithAadharNoButton);
	}

	public void clickOnDoneButtonInModal() {
		try {
			click(doneButtonInModal);
		}catch(Exception e) {}
	}
    
}