package com.investor.pages;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.investor.base.BaseClass;
import com.investor.errorCollectors.ErrorCollector;
import com.investor.utilities.Waits;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.offset.PointOption;

public class KYCUserPurchaseStockPage extends BaseClass {
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='watchListItemItem'])[2]")
	public WebElement firstInstrument;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name='YOUR PORTFOLIO î¢�'])[1]/following-sibling::XCUIElementTypeOther")
	public WebElement secondInstrument;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='instrumentDetailsBuyBtn']")
	public WebElement buyButton;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='instrumentDetailsSellBtn']")
	public WebElement sellButton;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'Shares')]//XCUIElementTypeTextField)[1]")
	public WebElement shareTxt;

	@FindBy(xpath = "//XCUIElementTypeOther[@label='Preview Order']")
	public WebElement previewOrderButton;

	@FindBy(xpath = "(//XCUIElementTypeOther[@label='Place Buy Order'])[1]")
	public WebElement placeBuyOrderButton;

	@FindBy(xpath = "(//XCUIElementTypeOther[@label='Place Sell Order'])[1]")
	public WebElement placeSellOrderButton;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Order Preview']")
	public WebElement orderPreviewTitle;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Your order was placed successfully.']")
	public WebElement orderWasPlacedSuccessfullyPage;

	@FindBy(xpath = "//XCUIElementTypeOther[@label='OK']")
	public WebElement successfullOkBtn;

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Market')]")
	public WebElement marketOpensInTitle;

	@FindBy(id = "Not Now")
	public WebElement notNowBtn;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name='VestCard'])[1]")
	WebElement firstThemeBasedVest;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='superVestDetailsActionBuyBtn']")
	WebElement vestBuyButton;

	@FindBy(xpath = "//XCUIElementTypeOther[@name=\"vestDetailsBuyBtn\"]")
	WebElement vestBuyButton_2;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='vestDetailsSellBtn']")
	WebElement vestSellButton;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Name']")
	WebElement vestBuyNameHeader;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Price']")
	WebElement vestBuyPriceHeader;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Weight']")
	WebElement vestBuyWeightHeader;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='No. of Shares']")
	WebElement vestBuySharesHeader;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='vestBuyPreviewOrderBtn']")
	WebElement vestBuyPreviewOrderButton;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='purchasePreviewInvestedAmountInputAmount']")
	WebElement vestBuyInvestmentAmountInput;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Investment Amount is required']")
	WebElement vestBuyInvestmentAmountIsRequiredError;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='totalVestPerchaseAmountValue']")
	WebElement totalVestPerchaseAmountValue;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='vestPlaceOrderBtn']")
	WebElement vestPlaceOrderBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='VestCard']")
	List<WebElement> themeBasedVests;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='superVestDetailsActionBuyBtn'] | //XCUIElementTypeOther[@name='vestDetailsBuyBtn']")
	private WebElement multiAssetClassVestBuyButton;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='superVestDetailsActionSellBtn'] | //XCUIElementTypeOther[@name='vestDetailsSellBtn']")
	private WebElement multiAssetClassVestSellButton;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='purchasePreviewInvestedAmountInputAmount']")
	private WebElement fieldInvestmentAmountBuyThemeVest;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='vestBuyPreviewOrderBtn']")
	private WebElement themebasedBuyVestPreviewButton;

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@label,'Please enter a value greater than or equal to $10')]")
	private WebElement errorThemeBasedAmountLessThan10Dollars;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='estimateCostInputId']")
	private WebElement estimatedCostInput;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name=\"PortfolioStockHoldingsItem\"])[1]")
	private WebElement portfolioFirstStock;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='vestDetailsCreateRecurringInvestmentBtn']")
	private WebElement createRecurringInvestmentButton;

	@FindBy(xpath = "//XCUIElementTypeTextField[@name='sipInvestmentAmount']")
	private WebElement createRecurringInvestmentAmountInput;

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Please enter a value greater than or equal to $10')]")
	private WebElement errorInvestmentAmountLessThan10Dollars;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='totalBuyingPower']")
	private WebElement totalBuyingPowerCreateReccInvestment;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='sipStartDatepicker']")
	private WebElement dropdownStartDate;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='sipFrequencyDropdown']")
	private WebElement frequencyDropdown;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Frequently Asked Questions']")
	private WebElement faqDialog;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='componentsRecurringInvestmentFAQModalOnCLose']")
	private WebElement closeFAQDialogButton;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='FAQs'] | //XCUIElementTypeOther[@name='sipFAQsBtn']")
	private WebElement faqButton;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='sipPreviewRecurringInvestmentBtn'] | //XCUIElementTypeOther[@name='Preview Recurring Investment']")
	private WebElement previewRecurringInvestmentButton;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='previewSipInvestmentAmount']")
	private WebElement investmentAmountPrevieReccInvestment;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='previewSipStartDateValue']")
	private WebElement startingDtaeReccInvestmentPriewPage;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='previewSipStartRecurringInvestmentBtn']")
	private WebElement btnStartReccurringInvestment;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='recurringInvestmentScheduledSuccessFullyLabel']")
	private WebElement recurringInvestmentSuccessMessage;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='startNewRecurringInvestmentBtn']")
	private WebElement btnStartNewReccurringInvestment;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='superVestDetailsCreateRecurringInvestmentBtn']")
	private WebElement btnCreateRecInvestmentMultiAssetClass;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='orderType']")
	private WebElement orderTypeDropdown;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@label,'Limit Order')])[last()]")
	private WebElement limitOrderType;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Fractional shares are not supported for limit orders.']")
	private WebElement errorMessageLimitBuyOrder;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='buyOrSellMarketPriceValue']")
	private WebElement marketPriceBuySell;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'Shares')]//XCUIElementTypeTextField)[2] | //XCUIElementTypeTextField[@name='limitOrderPriceValue']")
	private WebElement limitPriceField;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='PENDING VEST ORDERS']")
	private WebElement pendingVestsOrderHeading;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Yes']")
	private WebElement yesButton;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@label,'Stop Order')])[last()]")
	private WebElement stopOrderType;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'Shares')]//XCUIElementTypeTextField)[1] | //XCUIElementTypeTextField[@name='stopOrderShareValue']")
	private WebElement stopOrderShareField;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'Stop Price')]//XCUIElementTypeTextField)[last()] | //XCUIElementTypeTextField[@name='stopOrderPriceValue']")
	private WebElement stopPriceField;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Low Stop Price']")
	private WebElement messageLowStopPrice;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='vestedInfoDialogClose'] | //XCUIElementTypeStaticText[@name='close']")
	private WebElement btnCloseStopLowPriceModal;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='High Stop Price']")
	private WebElement messageHighStopPrice;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Invalid cash.']")
	private WebElement errorMessageInvalidCash;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='PENDING ORDERS']")
	private WebElement pendingOrdersSection;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='showMore']")
	private WebElement btnShowMorePendingOrders;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='stockListItem']")
	private List<WebElement> pendingOrdersList;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Estimated Proceeds']/../following-sibling::XCUIElementTypeStaticText | //XCUIElementTypeStaticText[@name='Total Cost']/../following-sibling::XCUIElementTypeStaticText | //XCUIElementTypeStaticText[@name='Total']/preceding-sibling::XCUIElementTypeStaticText")
	private WebElement totalCostOrderPreview;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='COMPLETE KYC']")
	private WebElement completeKyc;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='basicsForm'] | (//*[@label='Next'])[last()]")
	private WebElement nextBtn;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Let’s open your account.\"]")
	private WebElement headingLetsOpenAccount;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Terms & Conditions\"]")
	private WebElement headingLetsTermsAndCondition;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'I want to enroll in the Securities')])[last()]")
	private WebElement checkBoxIwantToEnroll;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'I agree to Vested')])[last()]")
	private WebElement checkBoxIAgreeToVestedAdvisory;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='I have reviewed and agree to VF Securities Account Agreement, VF Securities Use and Risk Disclosures, and VF Securities Business Continuity Plan.']//preceding::XCUIElementTypeOther[1]")
	private WebElement checkboxIreviewedVF;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='I have reviewed the Client Relationship Summary.']//preceding::XCUIElementTypeOther[1]")
	private WebElement checkboxIreviewedClientRelation;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name='Enter Your Full Name'])[1]")
	private WebElement fieldEnterYourFirstName;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'Previous')])[last()]")
	private WebElement previousBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='signatureForm']")
	private WebElement doneBtn;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='kycSignatureBackBtn']//following-sibling::XCUIElementTypeOther")
	private WebElement vestedLogo;
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='kycSignatureBackBtn']/../..//following-sibling::XCUIElementTypeOther)[last()]")
	private WebElement crossIcon;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'By checking where indicated above and typing your name')]")
	private WebElement labelByCheckingIndicated;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'By signing above')]")
	private WebElement labelBySigningAbove;
	
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name=\"In progress\"])[1]")
	private WebElement loadingIcon;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='yourPortfolioShowAllBtn']")
	private WebElement showall;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Sell All']/preceding-sibling::XCUIElementTypeOther | //XCUIElementTypeOther[@name='']")
	private WebElement sellAllButton;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
	private WebElement donebtn;

	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
	private WebElement clickOk;

	@FindBy(xpath = "//XCUIElementTypeOther[@name=\"rebalanceAcceptedForQueueSecondaryButton\"]")
	private WebElement skipButton;

	@FindBy(xpath = "//XCUIElementTypeOther[@name=\"YES, SKIP\"]")
	private WebElement yesSkipButton;


	public KYCUserPurchaseStockPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnFirstInstrument() {
		clickWebElement(firstInstrument);
	}

	public void clickOnSecondInstrument() {
		waitForElementToBeClickable(secondInstrument, 30);
		clickWebElement(secondInstrument);
	}

	public void clickOnBuyButton() {
		waitForElementToBeClickable(buyButton, 30);
		clickWebElement(buyButton);
	}

	public void clickOnSellButton() {
		clickWebElement(sellButton);

	}

	public void enterShareValue(String shareValue) {
		Waits.wait6s();
		sendKeysToWebElement(shareTxt, shareValue);
		System.out.println("Share Value : " + shareValue);
	}

	public void clickOnPreviewOrderButton() {
		try {
			clickWebElement(donebtn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		waitForElementToBeClickable(previewOrderButton, 30);
		clickWebElement(previewOrderButton);
	}

	public void clickOnPlaceBuyOrderButton() {
		waitForElementToBeClickable(placeBuyOrderButton, 30);
		clickWebElement(placeBuyOrderButton);
	}

	public void clickOnPlaceSellOrderButton() {
		waitForElementToBeClickable(placeSellOrderButton, 30);
		clickWebElement(placeSellOrderButton);
	}

	public void clickOnSuccessfullOkButton() {
		waitForElementToBeClickable(successfullOkBtn, 30);
		clickWebElement(successfullOkBtn);
	}

	public void clickOnNotNowButton() {
		waitForElementToBeClickable(notNowBtn, 30);
		clickWebElement(notNowBtn);
	}

	public boolean verifyOrderPreviewTitleIsDisplaying() {
		waitForElementToBePresent(orderPreviewTitle, 30);
		return isElementDisplayed(orderPreviewTitle);
	}

	public boolean verifySellButtonIsDisplaying() {
//		waitForElementToBePresent(sellButton, 30);
		return isElementDisplayed(sellButton);
	}

	public boolean verifyorderWasPlacedSuccessfullyPageTitleIsDisplaying() {
		return isElementPresent(successfullOkBtn, 30);
	}

	public String getVestNameLabel() {
		Waits.wait6s();
		String marketOpensInVal = "";
		marketOpensInVal = getElementText(marketOpensInTitle);
		System.out.println("Vest Name Label: " + marketOpensInVal);
		return marketOpensInVal;
	}

	public void clickOnFirstThemeBasedVest() {
		waitForElementToBeClickable(firstThemeBasedVest, 30);
		clickWebElement(firstThemeBasedVest);
	}

	public void clickOnVestBuyButton() {
		try {
			waitForElementToBeClickable(vestBuyButton, 30);
			clickWebElement(vestBuyButton);
		}catch (Exception e) {
			waitForElementToBeClickable(vestBuyButton_2, 30);
			clickWebElement(vestBuyButton_2);
		}

	}

	public boolean verifyTableHeaderNameOnPreviewOrderTable() {
		return isElementDisplayed(vestBuyNameHeader);
	}

	public boolean verifyTableHeaderPriceOnPreviewOrderTable() {
		return isElementDisplayed(vestBuyPriceHeader);
	}

	public boolean verifyTableHeaderWeightOnPreviewOrderTable() {
		return isElementDisplayed(vestBuyWeightHeader);
	}

	public boolean verifyTableHeaderSharesOnPreviewOrderTable() {
		return isElementDisplayed(vestBuySharesHeader);
	}

	public boolean verifyErrorMessageInvestementAmountIsRequiredIsDisplaying() {
		return isElementDisplayed(vestBuyInvestmentAmountIsRequiredError);
	}

	public void clickOnPlaceOrderButton() {
		waitForElementToBeClickable(vestBuyPreviewOrderButton, 30);
		clickWebElement(vestBuyPreviewOrderButton);
	}

	public void enterValueInInvestementInput(String keys) {
		sendKeysToElement(vestBuyInvestmentAmountInput, keys, "");
	}

	public int getThemeBasedVestsCount() {
		waitTime(5000);
		return themeBasedVests.size();
	}

	public String getThemeBasedVestNameAtIndex(int i) {
		return getDriver()
				.findElement(By.xpath("//XCUIElementTypeStaticText[@name='themeBasedVestCardLabel" + i + "']"))
				.getText();
	}

	public boolean getThemeBasedVestInvestedStatusAtIndex(int i) {
		return themeBasedVests.get(i)
				.findElements(By.xpath("//XCUIElementTypeOther[@name='themeBasedVestInvestedBtn']")).size() > 0;
	}

	public void clickOnThemebasedVestAtIndex(int i) {
		waitForElementToBeClickable(themeBasedVests.get(i), 30);
		click(themeBasedVests.get(i));
	}

	public boolean verifyBuyButtonIsShowingAtVestDetailsPage() {

		try {
			waitForElementToBePresent(vestBuyButton_2, 15);
			return isElementDisplayed(vestBuyButton_2);
		}catch (Exception e){
			return isElementDisplayed(vestBuyButton);
		}

	}

	public boolean verifyBuyButtonIsShowingAtMultiAsserClassVestDetailsPage() {
		return isElementDisplayed(multiAssetClassVestBuyButton);
	}

	public boolean verifySellButtonIsShowingAtVestDetailsPage() {
		return isElementDisplayed(vestSellButton);
	}

	public boolean verifySellButtonIsShowingAtMultiAssetClassVestDetailsPage() {
		return isElementDisplayed(multiAssetClassVestSellButton);
	}

	public String getMultiAssetClassVestNameAtIndex(int i) {
		
		return getDriver().findElement(By.xpath("//*[@name='superVests"+i+"Item']"))
				.getText();
	}

	public boolean getMultiAssetClassVestInvestedStatusAtIndex(int i) {
		return themeBasedVests.get(i).findElements(By.xpath("//XCUIElementTypeOther[@name='superVestsInvestedBtn']"))
				.size() > 0;
	}

	public void clickOnMultiAssetClassVestAtIndex(int i) {
		waitTime(1000);
		
		getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name='superVests" + i + "Item']")).click();
	}

	public void enterInvestAmount(String amount) {
		sendKeysToElement(fieldInvestmentAmountBuyThemeVest, amount, "");
	}

	public void clickOnThemeBasedBuyVestPreviewOrderButton() {
		click(themebasedBuyVestPreviewButton);
	}

	public boolean verifyErrorMessageInvestementAmountIsLessThan10DollarsIsDisplaying() {
		return isElementDisplayed(errorThemeBasedAmountLessThan10Dollars);
	}

	public boolean isThemeBasedBuyVestInvestmentAmountFieldEnabled() {
		return getElementAttribute(vestBuyInvestmentAmountInput, "enabled").equals("true");
	}

	public boolean isThemeBasedBuyVestPreviewOrderButtonEnabled() {
		return getElementAttribute(themebasedBuyVestPreviewButton, "enabled").equals("true");
	}

	public boolean verifyAmountValueIsAutoPopulated() {
		String value = getElementAttribute(estimatedCostInput, "value");
		return Double.parseDouble(value) > 0;
	}

	public String getAmountFieldValue() {
		return getElementAttribute(estimatedCostInput, "value");
	}

	public void estimatedAmountValue(String amount) {
		sendKeysToElement(estimatedCostInput, amount, "");
	}

	public void clickOnYourPortfolioFirstStock() {
//		scrollDownToIOSElement((IOSElement)getDriver().findElement(By.xpath("(//XCUIElementTypeOther[@name='PortfolioStockHoldings'])[1]")));
//		waitTime(1000);
		clickWebElement(showall);
		clickWebElement(portfolioFirstStock);
	}

	public void clickOnCreateRecurringInvestmentButton() {
		clickWebElement(createRecurringInvestmentButton);
	}

	public void enterInvestmentAmount(String keys) {
		sendKeysToElement(createRecurringInvestmentAmountInput, keys, "");
	}

	public boolean verifyInvestmenteAmountIsLessThanTheMinValue() {
		return isElementDisplayed(errorInvestmentAmountLessThan10Dollars);
	}

	public Double getTotalBuyingPower() {
		return Double
				.parseDouble(removeDollarandSpaces(getElementAttribute(totalBuyingPowerCreateReccInvestment, "value")));
	}

	public String getDateThreeDaysAhead() {
		return getElementText(dropdownStartDate);
	}

	public boolean verifyFrequencyDropdownIsEnabled() {
		return isElementDisplayed(frequencyDropdown);
	}

	public boolean verifyFAQIsDisplaying() {
		return isElementDisplayed(faqDialog);
	}

	public void clickOnFAQButton() {
		clickWebElement(faqButton);
	}

	public void clickOnCloseFAQButton() {
		clickWebElement(closeFAQDialogButton);
	}

	public void clickOnPreviewRecurringInvestmentButton() {
		click(previewRecurringInvestmentButton);
	}

	public String getInvestmentAmountAtPreviewReccInvestment() {
		// TODO Auto-generated method stub
		return removeDollarandSpaces(getElementText(investmentAmountPrevieReccInvestment));
	}

	public String getStartingDateAtPreviewReccInvestment() {
		// TODO Auto-generated method stub
		return getElementText(startingDtaeReccInvestmentPriewPage);
	}

	public void clickOnStartReccInvestmentButton() {
		click(btnStartReccurringInvestment);
	}

	public boolean verifyRecurringInvestmentSuccessMessageIsDisplaying() {
		// TODO Auto-generated method stub
		return isElementDisplayed(recurringInvestmentSuccessMessage);
	}

	public void clickOnStartRecurringInvestmentButton() {
		try {
			clickWebElement(btnStartNewReccurringInvestment);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickOnCreateMultiAssetClassRecurringInvestmentButton() {
		click(btnCreateRecInvestmentMultiAssetClass);
	}

	public boolean verifyStartNewRecInvestmentDialogDisplaying() {
		return isElementDisplayed(btnStartNewReccurringInvestment);
	}

	public void selectLimitBuyOrder() {
		click(orderTypeDropdown);
		waitTime(1000);
		click(limitOrderType);
	}

	public boolean verifyLimitBuyShareErrorMessage() {
		return isElementDisplayed(errorMessageLimitBuyOrder);
	}

	public double getMarketPriceOnBuySell() {
		return Double.parseDouble(removeDollarandSpaces(getElementText(marketPriceBuySell)));
	}

	public void enterLimitPrice(String marketPriceString) {
		sendKeysToElement(limitPriceField, marketPriceString, "Limit Price");
	}

	public boolean isCancelPendingVestsOrderDisplaying() {
		return isElementPresent(pendingVestsOrderHeading, 10);
	}

	public List<MobileElement> getAllPendingVestsOrders() {
		try {
			getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name='pendingVestsOrderListShowAll']")).click();
			waitTime(2000);
		} catch (Exception e) {
		}
		return getDriver().findElements(By.xpath("//XCUIElementTypeOther[contains(@name,'PendingVestOrderListItem')]"));

	}

	public String getPendingVestOrdersVestName(int i) {
		return getElementText(getDriver().findElement(
				By.xpath("//XCUIElementTypeStaticText[@name='PendingVestOrderListItemVestName" + i + "']")));
	}

	public void clickOnCancelButtonForVestOrder(int i) {
		click(getDriver().findElement(
				By.xpath("//XCUIElementTypeStaticText[@name='PendingVestOrderListItemCancelButton" + i + "']")));
	}

	public void clickOnYesCancelButton() {
		click(yesButton);
	}

	public void selectStopBuyOrder() {
		click(orderTypeDropdown);
		waitTime(1000);
		click(stopOrderType);
	}

	public void enterStopOrderShareValue(String value) {
		sendKeysToElement(stopOrderShareField, value, "Share");
	}

	public void enterStopPrice(double price) {
		stopPriceField.clear();
		waitTime(3000);
		sendKeysToElement(stopPriceField, price + "", "Stop Price");
	}

	public boolean verifyLowStopPriceErrorMessage() {
		waitForElementToBePresent(messageLowStopPrice, 30);
		return isElementDisplayed(messageLowStopPrice);
	}

	public void clickOnCloseLowStopPriceButton() {
		clickWebElement(btnCloseStopLowPriceModal);
	}

	public boolean verifyHighStopPriceErrorMessage() {
		return isElementDisplayed(messageHighStopPrice);
	}

	public boolean verifyInValidCashErrorMessageDisplaying() {
		return isElementDisplayed(errorMessageInvalidCash);
	}

	public boolean isPendingOrdersPresent() {
		return isElementPresent(pendingOrdersSection, 15);
	}

	public List<WebElement> getAllStocksList() {
		try {
			clickOnShowMoreButton();
		} catch (Exception e) {
		}
		waitTime(2000);
		return pendingOrdersList;
	}

	public void clickOnShowMoreButton() {
		clickWebElement(btnShowMorePendingOrders);
	}

	public String getPendingOrderStockSymbolAt(int i) {
		return getElementText(
				getDriver().findElement(By.xpath("(//XCUIElementTypeStaticText[@name='stockSymbol'])[" + i + "]")));
	}

	public void clickOnCancelPendingOrderAt(int i) {
		clickWebElement(
				getDriver().findElement(By.xpath("(//XCUIElementTypeStaticText[@name='cancelOrder'])[" + 1 + "]")));
	}

	public void clickOnNoPendingOrderCancelDialog() {
		clickWebElement(getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name='No']")));
	}

	public void clickOnYesPendingOrderCancelDialog() {
		clickWebElement(getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name='Yes']")));
	}

	public String getTotalCostPreviewOrder() {
		return getElementText(totalCostOrderPreview);
	}

	public void clickOnCompleteKycButton() {
		waitForElementToBeClickable(completeKyc, 30);
		clickWebElement(completeKyc);
	}

	public void clickOnNextButton() {
		try {
			waitForElementToBeClickable(nextBtn, 10);
			clickWebElement(nextBtn);
		}catch(Exception e) {}
	}

	public boolean isHeadingLetsOpenAccountDisplaying() {
		return isElementPresent(headingLetsOpenAccount, 15);
	}

	public boolean isHeadingTermsAndConditionDisplaying() {
		return isElementPresent(headingLetsTermsAndCondition, 15);
	}

	public boolean isCheckboxWithlabelIWanttoEnrolDisplaying() {
		return isElementPresent(checkBoxIwantToEnroll, 15);
	}

	public boolean isCheckboxWithlabelIAgreetoVested() {
		return isElementPresent(checkBoxIAgreeToVestedAdvisory, 15);
	}

	public boolean isCheckboxWithlabelIHaveReviewedVF() {
		return isElementPresent(checkboxIreviewedVF, 15);
	}

	public boolean isCheckboxIHaveReviewedClientRelation() {
		return isElementPresent(checkboxIreviewedClientRelation, 15);
	}
	public boolean isLabelByCheckingInicatedDisplaying() {
		return isElementPresent(labelByCheckingIndicated, 15);
	}
	
	public boolean isLabelBySigningAboveDisplaying() {
		return isElementPresent(labelBySigningAbove, 15);
	}

	public boolean isFieldEnterFullNameDisplauing() {
		return isElementPresent(fieldEnterYourFirstName, 15);
	}

	public boolean isPreviousBtnClickable() {
		waitForElementToBeClickable(previousBtn, 15);
		return isElementPresent(previousBtn, 15);
	}

	public boolean isDoneBtnClickable() {
		waitForElementToBeClickable(doneBtn, 15);
		return isElementPresent(doneBtn, 15);
	}
	
	public boolean isVestedLogoClickable() {
		waitForElementToBeClickable(vestedLogo, 15);
		return isElementPresent(vestedLogo, 15);
	}
	
	public boolean isCrossIconlickable() {
		waitForElementToBeClickable(crossIcon, 15);
		return isElementPresent(crossIcon, 15);
	}

	public void clickOnSellAllButton() {
		click(sellAllButton);
	}

	public void clickOnOkButtonInDialog() {
		waitForElementToBePresent(clickOk, 10);
		clickWebElement(clickOk);
	}
	public void clickOnYourPortfolioFirstStockWithOutShowALl() {;
		clickWebElement(portfolioFirstStock);
	}

	public void clickOnSkipButton() {;
		clickWebElement(skipButton);
		waitTime(2000);
		clickWebElement(yesSkipButton);
	}
}
