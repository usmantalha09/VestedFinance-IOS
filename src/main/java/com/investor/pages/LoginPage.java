package com.investor.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.errorCollectors.ErrorCollector;
import com.investor.utilities.Waits;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import com.investor.webElements.LoginPageElements;

public class LoginPage extends BaseClass{
    
	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'Login')])[last()]")
	public WebElement loginButton;
	
	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'Login')])[last()]")
	public WebElement loginSubmitButton;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Login with email']")
	public WebElement loginWithEmailButton;
	
	@FindBy(xpath ="//XCUIElementTypeTextField")
	public WebElement emailInput;

	@FindBy(xpath ="//XCUIElementTypeStaticText[contains(@name,'Email address')]/following-sibling:: XCUIElementTypeOther/XCUIElementTypeStaticText")
	public WebElement emailErrorMessage;
	
	@FindBy(xpath = "//XCUIElementTypeSecureTextField")
	public WebElement passwordInput;
	
	@FindBy(xpath = "//XCUIElementTypeSecureTextField[@name='signUpWithEmailPasswordValue']")
	public WebElement passwordInput_2;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Password')]/following-sibling:: XCUIElementTypeOther/XCUIElementTypeStaticText")
	public WebElement passwordErrorMessage;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'Login')])[last()]/following-sibling::XCUIElementTypeStaticText")
	public WebElement invalidCredentialsErrorMessage;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='signUpSuccessStartKycBtn']")
	public WebElement startKYCButton;

	@FindBy(xpath = "//XCUIElementTypeOther[@label='START KYC']")
	public WebElement startKYCButton_2;
	
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='signUpSuccessExplorePlatformBtn']")
	public WebElement explorPlatformButton;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@label='EXPLORE THE PLATFORM']")
	public WebElement explorPlatformButton_2;

	//XCUIElementTypeOther[@name="signUpSuccessExplorePlatformBtn"]
	
	@FindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[17]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]")
	public WebElement profileButton;
	
	@FindBy(xpath ="//XCUIElementTypeStaticText[contains(@name,'HI,')]")
	public WebElement homePage;
	
	@FindBy(xpath ="//XCUIElementTypeButton[contains(@name,'Home, tab,')]")
	public WebElement homePageB2B;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Incorrect email ID and password combination.']")
	public WebElement loginErrorMessage;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Enter Vested PIN']")
	public WebElement pinPage;
	
	@FindBy(xpath = "//*[contains(@label,'invalid PIN')]")
	WebElement invalidPinErrorMessage;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'Password')])[last()]")
	WebElement btnChangePassword;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Current Password']/following-sibling::XCUIElementTypeOther//XCUIElementTypeSecureTextField")
	WebElement inputCurrentPassword;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Current Password profileSecurityPasswordCurrentPasswordValue profileSecurityPasswordCurrentPasswordEyeOutlineOffIcon']")
	WebElement inputCurrentPassword_2;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Enter Password']/following-sibling::XCUIElementTypeOther//XCUIElementTypeSecureTextField")
	WebElement inputNewPassword;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Enter Password profileSecurityPasswordEnterPasswordValue profileSecurityPasswordEnterPasswordEyeOutlineOffIcon']")
	WebElement inputNewPassword_2;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Confirm Password']/following-sibling::XCUIElementTypeOther//XCUIElementTypeSecureTextField")
	WebElement inputConfirmNewPassword;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Confirm Password profileSecurityPasswordConfirmPasswordValue profileSecurityPasswordConfirmPasswordValueError profileSecurityPasswordConfirmPasswordEyeOutlineOffIcon']")
	WebElement inputConfirmNewPassword_2;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Confirm Password']/following-sibling::XCUIElementTypeOther//XCUIElementTypeTextField")
	WebElement inputNonSecureConfirmNewPassword;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Confirm Password']/following-sibling::XCUIElementTypeOther[last()]")
	WebElement inputConfirmNewPasswordEyeButton;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Change Password']")
	WebElement btnSubmitChangePassword;

	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='Change Password']")
	WebElement ChangePasswordPageHeading;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Password is changed successfully']")
	WebElement passwordChangedSuccessfullyMessage;
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='BACK TO DASHBOARD'])[2]")
	WebElement btnBackToDashboard;
	
	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'Security Pin')])[last()]")
	WebElement btnSecurityPIN;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name='DIY Vest'])[last()]")
	private WebElement DIYVestPage;
	
	@FindBy(xpath = "(//*[contains(@label,'Vested Invest')])[last()]")
	WebElement vestedInvestButton;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLoginButtonIsDisplaying(){
		waitForElementToBePresent(loginButton,30);
        return isElementDisplayed(loginButton);
    }
	
	public void clickOnLoginButton(){
		waitForElementVisibility(loginButton,80);
        click(loginButton);
    }
    
    public void clickOnLoginWithEmailButton(){
        click(loginWithEmailButton);
    }
    
    public void enterEmailAddress(String email) {
    	sendKeysToWebElement(emailInput, email);
	}
    
    
    public void enterPassword(String pass) {
    	try {
    		sendKeysToWebElement(passwordInput_2, pass);
			
		} catch (Exception e) {
			sendKeysToWebElement(passwordInput, pass);
		}
	}
    
    public void clickOnB2BLoginSubmitButton(){
	waitForElementVisibility(loginSubmitButton,10);
        click(loginSubmitButton);
    }
    
    public void clickVestedWidget() {
    	tryWaitForElementToBePresent(vestedInvestButton,5);
    	if(isElementDisplayed(vestedInvestButton)) {
    		click(vestedInvestButton);
    	}
    }
    
    public void clickOnLoginSubmitButton(){
	waitForElementVisibility(loginSubmitButton,30);
        click(loginSubmitButton);
    }
    public boolean verifyStarKYCButton(){
    	try {
    		return isElementDisplayed(startKYCButton_2);
			
		} catch (Exception e) {
			return isElementDisplayed(startKYCButton);
		}
    }
    
    public boolean verifyExplorePlatformButton(){
    	try {
    		return isElementDisplayed(explorPlatformButton_2);
			
		} catch (Exception e) {
			return isElementDisplayed(explorPlatformButton);
		}
    }
    
    public boolean verifyHomePageIsDisplaying(){
        return isElementDisplayed(homePage);
    }
    
    public boolean verifyHomePageB2BIsDisplaying(){
        return isElementDisplayed(homePageB2B);
    }
    
    public void enterPinCode(String code) {
   	tryWaitForElementToBePresent(vestedInvestButton,5);
   	if(isElementDisplayed(vestedInvestButton)) {
   		click(vestedInvestButton);
   	}else 
    	{
    		waitForElementToBePresent(pinPage, 90);
        	waitTime(3000);
        	char[] digitChars = code.toCharArray();
        	for(int i=0;i<digitChars.length;i++) {
        		getDriver().findElement(By.xpath("//XCUIElementTypeKey[@name='"+digitChars[i]+"']")).click();
        	}
    	}
    	tryWaitForElementToBePresent(vestedInvestButton,5);
    	if(isElementDisplayed(vestedInvestButton)) {
    		click(vestedInvestButton);
    	}
    	
	}
    
    public void enterPinCodeWithoutVestedInvestClick(String code) {

		waitForElementToBePresent(pinPage, 90);
    	waitTime(3000);
    	char[] digitChars = code.toCharArray();
    	for(int i=0;i<digitChars.length;i++) {
    		getDriver().findElement(By.xpath("//XCUIElementTypeKey[@name='"+digitChars[i]+"']")).click();
    	}

	}

	public boolean verifyLoginErrorDisplaying() {
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean isPresent = isElementPresent(loginErrorMessage,"5");
		getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(PropertiesReader.getPropertyValue("implicit.wait")), TimeUnit.SECONDS);
		return isPresent;
	}

	public String getEmailErrorMessage() {
		return getElementText(emailErrorMessage);
	}
	
	public String getPasswordErrorMessage() {
		return getElementText(passwordErrorMessage);
	}
	
	public boolean verifyEmailErrorMessageIsDisplaying() {
		return isElementDisplayed(emailErrorMessage);
	}
	
	public boolean verifyPasswordErrorMessageIsDisplaying() {
		return isElementDisplayed(passwordErrorMessage);
	}
	
	public String getCredentialErrorMessage() {
		return getElementText(invalidCredentialsErrorMessage);
	}
	
	public boolean verifyInvalidCredentialsErrorMessageIsDisplaying() {
		return isElementDisplayed(invalidCredentialsErrorMessage);
	}

	public void waitForElementVerificationPinScreen(int time) {
		waitForElementInvisibility(pinPage, time+60);
	}

	public boolean verifyInvalidPINErrorMessageIsDisplaying() {
		return isElementDisplayed(invalidPinErrorMessage);
	}
	
	public void clickOnChangePasswordButton() {
		click(btnChangePassword);
	}
	
	public boolean verifyChangePasswordPageIsDisplaying() {
		try {
			return isElementDisplayed(ChangePasswordPageHeading);
		} catch (Exception e) {
			return isElementDisplayed(btnSubmitChangePassword);
		}
	}
	
	public void enterCurrentPassword(String pass) {
		waitTime(3000);
		try {
			inputCurrentPassword_2.sendKeys(pass);
		} catch (Exception e) {
//			inputCurrentPassword.sendKeys(pass);
		}
	}
	
	public void enterNewPassword(String pass) {
		waitTime(3000);
		try {
			inputNewPassword_2.sendKeys(pass);
		} catch (Exception e) {
//			inputNewPassword.sendKeys(pass);
		}
	}
	
	public void enterConfirmNewPassword(String pass) {
		waitTime(3000);
		try {
			inputConfirmNewPassword_2.sendKeys(pass);
		} catch (Exception e) {
//			inputConfirmNewPassword.sendKeys(pass);
		}
	}
	
	public void clickOnConfirmNewPasswornEyeButton() {
		click(inputConfirmNewPasswordEyeButton);
	}
	
	public String getConfirmPasswordInputValue() {
		return getElementAttribute(inputNonSecureConfirmNewPassword,"value");
	}
	
	public boolean verifyPasswordChangedSuccesfullyMessageIsdisplaying() {
		return isElementDisplayed(passwordChangedSuccessfullyMessage);
	}
	
	public void clickOnSubmitChangePasswordButton() {
		click(btnSubmitChangePassword);
	}
	
	public void clickOnGoToDashboardButton() {
		click(btnBackToDashboard);
	}

	public void clickOnSecurityPIN() {
		click(btnSecurityPIN);
	}

	public boolean verifyDIYVestPageIsDisplaying() {
		return isElementDisplayed(DIYVestPage);
	}

	public int loginToApplication(int step, String email, String password, String pinCode) {
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Login button displaying.");
		ErrorCollector.verifyTrue(verifyLoginButtonIsDisplaying(), "Verified Login button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login button.");
		waitTime(7000);
		clickOnLoginButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login With Email button.");
		clickOnLoginWithEmailButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter email address : " + email);
		enterEmailAddress(email);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Password : " + password);
		enterPassword(password);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login button.");
		clickOnLoginSubmitButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Pin Code  : " + pinCode);
		waitTime(3000);
		enterPinCode(pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify home page is displaying.");
		ErrorCollector.verifyTrue(verifyHomePageIsDisplaying(), "Verified home page is displaying.");

		return step;
	}
	
	public int loginToApplication(int step, String email, String password) {
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Login button displaying.");
		ErrorCollector.verifyTrue(verifyLoginButtonIsDisplaying(), "Verified Login button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login button.");
		waitTime(7000);
		clickOnLoginButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login With Email button.");
		clickOnLoginWithEmailButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter email address : " + email);
		enterEmailAddress(email);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Password : " + password);
		enterPassword(password);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login button.");
		clickOnLoginSubmitButton();
		
		try {
			tryWaitForElementToBePresent(vestedInvestButton,5);
	    	if(isElementDisplayed(vestedInvestButton)) {
	    		click(vestedInvestButton);
	    	}
		} catch (Exception e) {
			// TODO: handle exception
		}

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify home page is displaying.");
		ErrorCollector.verifyTrue(verifyHomePageIsDisplaying(), "Verified home page is displaying.");

		return step;
	}
}
