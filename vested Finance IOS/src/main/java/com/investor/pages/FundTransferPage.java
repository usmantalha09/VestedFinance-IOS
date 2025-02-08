package com.investor.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.investor.base.BaseClass;
import com.investor.errorCollectors.ErrorCollector;
import com.investor.listeners.ExtentManager;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.offset.PointOption;

public class FundTransferPage extends BaseClass {

	@FindBy(xpath = "//XCUIElementTypeOther[@name='ADD FUNDS']")
	WebElement addFundsButton;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='transferTabAddFundsBtn']")
	WebElement addFundsButton_2;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='WITHDRAW FUNDS']")
	WebElement withdrawFundsButton;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='transferTabWithdrawFundsBtn']")
	WebElement withdrawFundsButton_2;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Add funds']")
	WebElement addFundsPopUp;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Withdrawal Process']")
	WebElement withdrawalFundsPopUp;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name='Skip'])[3]")
	WebElement addFundsPupUpSkipButton;

	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Transfer, tab,')]")
	WebElement transferMenu;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name='Transfer Funds'])[6]")
	WebElement transferPageHeading;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='withdrawalAmountToWithdrawAmount']")
	WebElement withdrawlAmountField;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='withdrawalProceedBtn']")
	private WebElement btnProceedWithdrawFunds;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='withdrawalBeneficiaryName']")
	private WebElement benificiaryNameField;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='withdrawalBeneficiaryAccountNumber']")
	private WebElement accountNumberField;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='withdrawalConfirmAccountNumber']")
	private WebElement confirmAccountNumberField;

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Select Bank Country'])//following-sibling::XCUIElementTypeOther[@name='withdrawalBeneficiaryBankCountry'] | //XCUIElementTypeTextField[@name=\"searchCountryTermTextInput\"]")
	private WebElement dropdownBankSelector;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Select Account Type']//following-sibling::XCUIElementTypeOther | //XCUIElementTypeStaticText[@name='Account Type']")
	private WebElement dropdownAccountType;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='withdrawalBeneficiarySwiftABA']")
	private WebElement swiftCodeField;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='withdrawalConfirmSwiftABA']")
	private WebElement confirmSwiftCodeField;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='withdrawalBeneficiaryBankName']")
	private WebElement bankNameField;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='withdrawalBeneficiaryBankCity']")
	private WebElement bankCityField;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='withdrawalBeneficiaryBankAddress']")
	private WebElement bankAddressField;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Select Bank State']//XCUIElementTypeTextField")
	private WebElement bankStateField;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='withdrawalBeneficiaryBankZip']")
	private WebElement bankZipCodeField;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name='Continue'])[last()]")
	private WebElement btnContinue;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='You have entered an invalid OTP. Please enter the correct OTP']")
	private WebElement errorMessageInvalidOTP;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name='Skip'])[3]")
	private WebElement btnSkipFundTransferDialog;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='transferOptionItemOTHER']")
	private WebElement methodIndianBank;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='ICICI Bank chevron_right'] | //XCUIElementTypeOther[@label='ICICI Bank chevron_right']")
	private WebElement iciIndianBank;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='transferOptionItemNON_INDIAN']")
	private WebElement methodInternationalBank;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='UPLOAD WIRE RECEIPT']")
	private WebElement btnUploadWireReceipt;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Please enter amount to transfer']")
	private WebElement amountToTransferErrorMessage;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Amount to transfer']//following-sibling:: XCUIElementTypeOther//XCUIElementTypeTextField")
	private WebElement amountToTransferField;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Please enter a valid amount to transfer']")
	private WebElement invalidAmountToTransferError;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Wire receipt date is required']")
	private WebElement wireReceiptRequiredErrorMessage;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name=\"Select Date\"])[2]")
	private WebElement dateDropdown;


	@FindBy(xpath = "//XCUIElementTypeOther[@name=\"Confirm\"]")
	private WebElement dateConfirm;

	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"Choose from Gallery...\"]")
	private WebElement chooseFromGallery;

	@FindBy(xpath = "(//XCUIElementTypeImage)[last()]")
	private WebElement galleryImage;

	@FindBy(xpath = "(//*[contains(@label,'Thank you')])[last()]")
	private WebElement transferConfirmation;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Further Credit To']//parent::XCUIElementTypeOther//following-sibling::XCUIElementTypeOther//XCUIElementTypeStaticText")
	private WebElement furtherCreditToText;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Further Credit To']//parent::XCUIElementTypeOther//following-sibling::XCUIElementTypeOther//XCUIElementTypeOther")
	private WebElement furtherCreditToCopyBtn;

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Beneficiary Information']//following-sibling::XCUIElementTypeOther)[1]//XCUIElementTypeOther//XCUIElementTypeStaticText")
	private WebElement addFundsNameText;

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Beneficiary Information']//following-sibling::XCUIElementTypeOther)[1]//XCUIElementTypeOther//XCUIElementTypeOther")
	private WebElement addFundsNameCopyBtn;

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Beneficiary Information']//following-sibling::XCUIElementTypeOther)[2]//XCUIElementTypeOther//XCUIElementTypeStaticText")
	private WebElement addFundsAccNoText;

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Beneficiary Information']//following-sibling::XCUIElementTypeOther)[2]//XCUIElementTypeOther//XCUIElementTypeOther")
	private WebElement addFundsAccNoCopyBtn;

	@FindBy(xpath = "//XCUIElementTypeTextField[@value='Search bank']")
	private WebElement searchInput;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='Instruction Options']//following-sibling::XCUIElementTypeOther")
	private WebElement instructionsOption;



	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Beneficiary Information']//following-sibling::XCUIElementTypeOther)[4]//XCUIElementTypeOther//XCUIElementTypeStaticText")
	private WebElement addFundsEmailText;

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Beneficiary Information']//following-sibling::XCUIElementTypeOther)[4]//XCUIElementTypeOther//XCUIElementTypeOther")
	private WebElement addFundsEmailCopyBtn;

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Beneficiary Information']//following-sibling::XCUIElementTypeOther)[5]//XCUIElementTypeOther//XCUIElementTypeStaticText")
	private WebElement addFundsPhoneText;

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Beneficiary Information']//following-sibling::XCUIElementTypeOther)[5]//XCUIElementTypeOther//XCUIElementTypeOther")
	private WebElement addFundsPhoneCopyBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='addFundSelectBankProcessWithVistedDirectBtn']")
	private WebElement proceedWithVestedButton;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name='DOWNLOAD NETBANKING INSTRUCTIONS'])[2]")
	private WebElement downloadInstructionsButton;

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Ok'] | //XCUIElementTypeButton[@name='OK']")
	private WebElement popUpOkBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name=\"OK, GOT IT\"]")
	private WebElement okGotItBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name=\"vestedDirectOpenAccountBtn\"]")
	private WebElement openVestedDirectAccount;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Introducing the Vested Direct Account\"]")
	private WebElement vestedDirectAccountPopUp;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"close\"]")
	private WebElement closeBtn;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mobile number verified\"]")
	private WebElement mobileNumberVerificationPage;

	@FindBy(xpath = "//*[contains(@label,'Bank servers are offline')]")
	private WebElement bankServersOfflineMessage;

	private WebElement searchBankField;

	@FindBy (xpath = "//XCUIElementTypeOther[@name='search']/XCUIElementTypeOther/XCUIElementTypeTextField")
	private WebElement searchSelectBankCountryElement;



	public FundTransferPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyAddFundButtonIsDisplaying() {
		try {
			waitForElementToBeClickable(addFundsButton_2, 30);
			return isElementDisplayed(addFundsButton_2);
		} catch (Exception e) {
			waitForElementToBeClickable(addFundsButton, 30);
			return isElementDisplayed(addFundsButton);
		}
	}

	public void clickOnAddFundsButton() {
		try {
			waitForElementToBeClickable(addFundsButton_2, 60);
			clickWebElement(addFundsButton_2);

		} catch (Exception e) {
			waitForElementToBeClickable(addFundsButton, 50);
			clickWebElement(addFundsButton);
		}
		waitTime(1000);
		if (isElementDisplayed(addFundsPupUpSkipButton)) {
			clickOnSkipAddFundsPopup();
		}
	}

	public boolean verifyWithdrawFundButtonIsDisplaying() {
		try {
			waitForElementToBeClickable(withdrawFundsButton_2, 30);
			return isElementDisplayed(withdrawFundsButton_2);

		} catch (Exception e) {
			waitForElementToBeClickable(withdrawFundsButton, 30);
			return isElementDisplayed(withdrawFundsButton);
		}
	}

	public void clickOnWithdrawFundsButton() {
		try {
			waitForElementToBeClickable(withdrawFundsButton_2, 30);
			clickWebElement(withdrawFundsButton_2);
		} catch (Exception e) {
			waitForElementToBeClickable(withdrawFundsButton, 30);
			clickWebElement(withdrawFundsButton);
		}
	}

	public boolean verifyAddFundsPopUpIsDisplaying() {
		waitForElementToBeClickable(addFundsPopUp, 30);
		return isElementDisplayed(addFundsPopUp);
	}

	public boolean verifyWithdrawalFundsPopUpIsDisplaying() {
		waitForElementToBeClickable(withdrawalFundsPopUp, 30);
		return isElementDisplayed(withdrawalFundsPopUp);
	}

	public void clickOnSkipAddFundsPopup() {
		waitForElementToBeClickable(addFundsPupUpSkipButton, 30);
		clickWebElement(addFundsPupUpSkipButton);
	}

	public void clickOnTransferMenuButton() {
		waitForElementToBeClickable(transferMenu, 30);
		clickWebElement(transferMenu);
	}

	public boolean verifyTransferPageIsDisplaying() {

		return isElementDisplayed(transferPageHeading);
	}

	public void enterAmountToWithdraw(String amount) {
		clickWebElement(withdrawlAmountField);
		//sendKeysToElement(withdrawlAmountField, amount, "Withdraw Amount");
		typeKeysViaKeyboard(amount);
		hideKeyboard(withdrawlAmountField);
	}

	public void clikcOnWithdrawFundsProceedsButton() {
		clickWebElement(btnProceedWithdrawFunds);
	}

	public void enterbennificiaryName(String name) {
		sendKeysToElement(benificiaryNameField, name, "Ben name");
	}

	public void enterAccountNumber(String accountNumber) {
		sendKeysToElement(accountNumberField,accountNumber, "Account Number");
	}

	public void enterConfirmAccountNumber(String accountNumber) {
		sendKeysToElement(confirmAccountNumberField,accountNumber, "Confirm Account Number");
	}

	public void selectbankCountry(String bankCountry) {
		click(dropdownBankSelector);
		waitTime(1000);
		clickWebElement(getDriver().findElement(By.xpath("(//XCUIElementTypeOther[@name='"+bankCountry+"'])[2]")));
	}

	public void searchSelectBankCountry(String country){
		click(searchSelectBankCountryElement);
		sendKeysToElement(searchSelectBankCountryElement, country, country);
//		waitTime(1000);
//		clickWebElement(getDriver().findElement(By.xpath("(//XCUIElementTypeOther[@name='"+country+"'])[3]")));
	}

	public void selectAccountType(String accountType) {
		click(dropdownAccountType);
		waitTime(1000);
//		clickWebElement(getDriver().findElement(By.xpath("(//XCUIElementTypeOther[@name='"+accountType+"'])[last()]")));
		new TouchAction(driver).tap(PointOption.point(121, 760)).perform();
	}

	public void enterSwiftCode(String swiftCode) {
		scrollDownToIOSElement((IOSElement)getDriver().findElement(By.xpath("(//XCUIElementTypeOther[@name='Continue'])[last()]")));
		waitTime(1000);
		sendKeysToElement(swiftCodeField, swiftCode, "Swift Code");
	}

	public void enterConfirmSwiftCode(String swiftCode) {
		sendKeysToElement(confirmSwiftCodeField, swiftCode, "Confirm Swift Code");
	}

	public void enterBankName(String bankName) {
		sendKeysToElement(bankNameField, bankName, "Bank Name");
	}

	public void enterBankCity(String bankCity) {
		sendKeysToElement(bankCityField, bankCity, "Bank City");
	}

	public void enterBankAddress(String bankAddress) {
		sendKeysToElement(bankAddressField, bankAddress, "Bank Address");
	}

	public void enterBankZipCode(String bankZipCode) {
		sendKeysToElement(bankZipCodeField, bankZipCode, "Bank Zip Code");
	}

	public void clickOnContinueButton() {
		scrollDownToIOSElement((IOSElement)getDriver().findElement(By.xpath("(//XCUIElementTypeOther[@name='Continue'])[last()]")));
		waitTime(1000);
		clickWebElement(btnContinue);
	}

	public boolean verifyInvalidWithdrawOTPErrorMessageIsDisplaying() {
		return isElementDisplayed(errorMessageInvalidOTP);
	}

	public void enterBankState(String bankState) {
		sendKeysToElement(bankStateField,bankState, "Bank State");
	}

	public void enterVerificationCode(String pinCode) {
		char[] digitChars = pinCode.toLowerCase().toCharArray();
		for(int i=0;i<digitChars.length;i++) {
			getDriver().findElement(By.xpath("(//XCUIElementTypeOther[@name='0'])[1]")).sendKeys(""+digitChars[i]);
		}
	}

	public void clickOnTransferFunds() {
		clickWebElement(btnSkipFundTransferDialog);
	}

	public void clickOnIndianBankMethod() {
		clickWebElement(methodIndianBank);
	}

	public void searchbank(String bank) {
		sendKeysToElement(searchInput, bank, "Bank Name");
	}

	public void clickOnICIBank() {
//		sendKeysToElement(searchBankField, "ICICI Bank", env);
//		waitTime(2000);
		clickWebElement(iciIndianBank);
	}

	public void clickOnWireReceiptButton() {

		try {
			ExtentManager.captureScreenshot();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println(e.getMessage()+"\n\n"+e.getStackTrace());
		}

		scrollIntoViewSmoothly(btnUploadWireReceipt);
		clickWebElement(btnUploadWireReceipt);
		//new TouchAction(driver).tap(PointOption.point(200, 770)).perform();

	}

	public boolean verifyAmountErrorMassage() {
		return isElementDisplayed(amountToTransferErrorMessage);
	}

	public void enterAmountToTransfer(String amount) {
		sendKeysToElement(amountToTransferField, amount, "Amount");
	}

	public boolean verifyEnterValidAmountErrorMassage() {
		return isElementDisplayed(invalidAmountToTransferError);
	}

	public boolean verifyWireReceiptErrorMassage() {
		return isElementDisplayed(wireReceiptRequiredErrorMessage);
	}
	public void clickOnDatedropDown() {
		clickWebElement(dateDropdown);
	}
	public void clickOnDateConfirm() {
		clickWebElement(dateConfirm);
	}

	public void clickOnChoseFromGallery() {
		clickWebElement(chooseFromGallery);
	}
	public void clickOnGalleryImage() {
		clickWebElement(galleryImage);
	}
	public void clickOnInternationalBank() {
//		scrollIntoViewSmoothly(methodInternationalBank);
		clickWebElement(methodInternationalBank);
	}
	public boolean verifyTransferConfirmationIsDisplaying() {
		return isElementDisplayed(transferConfirmation);
	}

	public void clickOnfurtherCreditToCopyBtn() {
		clickWebElement(furtherCreditToCopyBtn);
	}
	public void clickOnaddFundsNameCopyBtn() {
		clickWebElement(addFundsNameCopyBtn);
	}
	public void clickOnaddFundsAccNoCopyBtn() {
		clickWebElement(addFundsAccNoCopyBtn);
	}
	public void clickOnaddFundsEmailCopyBtn() {
		clickWebElement(addFundsEmailCopyBtn);
	}
	public void clickOnaddFundsPhoneCopyBtn() {
		clickWebElement(addFundsPhoneCopyBtn);
	}

	public String getaddFundsNameText() {
		return addFundsNameText.getText();
	}

	public String getFurtherCreditToText() {
		return furtherCreditToText.getText();
	}

	public String getaddFundsAccNoText() {
		return addFundsAccNoText.getText();
	}

	public String getaddFundsEmailText() {
		return addFundsEmailText.getText();
	}

	public String getaddFundsPhoneText() {
		return addFundsPhoneText.getText();
	}

	public boolean verifyProceedWithVestedButtonIsDisplaying() {
		return isElementDisplayed(proceedWithVestedButton);

	}

	public boolean verifySelectIndianBankIsDisplaying() {

		return isElementDisplayed(methodIndianBank);


	}
	public boolean verifySelectInternationalBankIsDisplaying() {

		return isElementDisplayed(methodInternationalBank);


	}
	public void clickOnDownloadInstructionsBtn() {
//		clickWebElement(instructionsOption);
		clickWebElement(downloadInstructionsButton);
	}

	public boolean verifyPopOkBtn() {

		return isElementDisplayed(popUpOkBtn);

	}
	public void clickOnOkBtn() {
		clickWebElement(popUpOkBtn);
		waitTime(5000);
		new TouchAction(driver).tap(PointOption.point(32, 22)).perform();
	}

	public void clickOnOkGotItBtn() {
		clickWebElement(okGotItBtn);

	}

	public void clickOnProceedWithVestedBtn() {
		clickWebElement(proceedWithVestedButton);

	}
	public void clickOnCloseBtn() {
		clickWebElement(closeBtn);

	}

	public void clickOnDirectVestedAccBtn() {
		clickWebElement(openVestedDirectAccount);

	}

	public boolean verifyVestedDirectAccountPopUp() {

		return isElementDisplayed(vestedDirectAccountPopUp);

	}

	public boolean verifyMobileVerifcationScreen() {

		return isElementDisplayed(mobileNumberVerificationPage);

	}

	public boolean isBankServerOfflineMessageDisplaying() {
		return isElementDisplayed(bankServersOfflineMessage);
	}
}