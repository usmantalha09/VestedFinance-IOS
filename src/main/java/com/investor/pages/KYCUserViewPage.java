package com.investor.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.investor.base.BaseClass;
import com.investor.utilities.Waits;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class KYCUserViewPage extends BaseClass {
	@FindBy(xpath ="(//XCUIElementTypeOther[@name=\"WATCHLIST\"])[1]/following-sibling::XCUIElementTypeOther[1]")
	public WebElement firstInstrument;
	
	@FindBy(xpath ="(//XCUIElementTypeOther[@name='YOUR PORTFOLIO î¢�'])[1]/following-sibling::XCUIElementTypeOther")
	public WebElement secondInstrument;
	
	
	@FindBy(xpath ="(//XCUIElementTypeOther[contains(@name,'Aggressive')])[46]")
	public WebElement randomVestUnderTheme;
	
	@FindBy(id ="î �")
	public WebElement shareBtn;
	
	@FindBy(xpath ="//XCUIElementTypeStaticText[@value='S&P500']/following-sibling::XCUIElementTypeStaticText")
	public WebElement iPopup;
	
	@FindBy(xpath ="//XCUIElementTypeOther[@name='Vest Performance Chart']")
	public WebElement vestPerformanceChartTitle;
	
	@FindBy(xpath ="//XCUIElementTypeStaticText[@value='close']")
	public WebElement IPopupClosebtn;
	
	@FindBy(xpath ="//XCUIElementTypeOther[@name='vestDetailsCreateRecurringInvestmentBtn'] | //XCUIElementTypeOther[@label='Create Recurring Investment']")
	public WebElement createRecurringInvestmentBtn;
	
	@FindBy(xpath ="//XCUIElementTypeOther[@name='vestGraphMaxBtn'] | //XCUIElementTypeOther[@name='MAX']")
	public WebElement vestGraphMaxBtn_2;
	
//	@FindBy(id ="vestGraphMaxBtn")
	@FindBy(xpath ="(//XCUIElementTypeOther[@name='Vertical scroll bar, 1 page Horizontal scroll bar, 1 page'])[1]")
	public WebElement vestGraphMaxBtn;
	
	@FindBy(xpath ="//XCUIElementTypeOther[@name='vestGraphFiveYearBtn'] | //XCUIElementTypeOther[@name='5Y']")
	public WebElement vestGraph5YearBtn_2;
	
	@FindBy(id ="vestGraphFiveYearBtn")
	public WebElement vestGraph5YearBtn;
	
	@FindBy(xpath ="//XCUIElementTypeOther[@name='vestGraphOneYearBtn'] | //XCUIElementTypeOther[@name='1Y']")
	public WebElement vestGraph1YearBtn_2;
	
	@FindBy(id ="vestGraphOneYearBtn")
	public WebElement vestGraph1YearBtn;
	
	@FindBy(xpath ="//XCUIElementTypeOther[@name='vestGraphThreeMonthBtn'] | //XCUIElementTypeOther[@name='3M']")
	public WebElement vestGraph3MonthBtn_2;
	
	@FindBy(id ="vestGraphThreeMonthBtn")
	public WebElement vestGraph3MonthBtn;
	
	@FindBy(xpath ="//XCUIElementTypeOther[@name='vestGraphOneMonthBtn'] | //XCUIElementTypeOther[@name='1M']")
	public WebElement vestGraph1MonthBtn_2;
	
	@FindBy(id ="vestGraphOneMonthBtn")
	public WebElement vestGraph1MonthBtn;
	
	@FindBy(xpath ="//XCUIElementTypeOther[@name='vestGraphOneWeekBtn'] | //XCUIElementTypeOther[@name='1W']")
	public WebElement vestGraph1WeekBtn_2;
	
	@FindBy(id ="vestGraphOneWeekBtn")
	public WebElement vestGraph1WeekBtn;
	
	@FindBy(xpath ="//XCUIElementTypeOther[@name='MAX 5Y 1Y 3M 1M 1W']/following-sibling::XCUIElementTypeOther")
	public WebElement overviewGraph;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='superVestsItem0']")
	WebElement randomMultiAssetClassVest;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='superVestDetailsOverviewCompareVestsBtn']")
	private WebElement compareVestsButton;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='close']")
	WebElement btnCloseCompareVestsModal;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='vestDetailsComparingInfoIcon']")
	private WebElement infoIconCompareVestsVBNIX;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Vest Performance Chart']")
	private WebElement vestCompareVBNIXInfoPopup;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='superVestDetailsCreateRecurringInvestmentBtn']")
	private WebElement vestDetailsCreateRecurringInvestmentBtn;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Create recurring investments']")
	private WebElement pageCreateRecurringInvestment;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='backButton']")
	private WebElement backButton;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='superVestDetailsActionBuyBtn']")
	private WebElement vestBuyButton;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='MAX 5Y 1Y 3M 1M 1W']/following-sibling::XCUIElementTypeOther")
	private WebElement multiAssetVestOverviewGraph;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Conservative Moderate View Aggressive View']/child::XCUIElementTypeOther[contains(@name, 'Conservative')]")
	private WebElement vestConservativeComparePrtfolioModal;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Conservative Moderate View Aggressive View']/child::XCUIElementTypeOther[contains(@name, 'Moderate')]")
	private WebElement vestModerateComparePrtfolioModal;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Conservative Moderate View Aggressive View']/child::XCUIElementTypeOther[contains(@name, 'Aggressive')]")
	private WebElement vestAggressiveComparePrtfolioModal;

	public KYCUserViewPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnFirstInstrument() {
		waitForElementToBeClickable(firstInstrument, 30);
		clickWebElement(firstInstrument);
	}

	public void clickOnSecondInstrument() {
		waitForElementToBeClickable(secondInstrument, 30);
		clickWebElement(secondInstrument);
	}
	
	public void clickOnRandomVestUnderTheme() {
		waitForElementToBeClickable(randomVestUnderTheme, 30);
		clickWebElement(randomVestUnderTheme);
	}
	
	public void clickOnShareButton() {
		waitForElementToBeClickable(shareBtn, 30);
		clickWebElement(shareBtn);
	}
	
	public boolean ShareCopyButtonIsClickable() {
		waitTime(5000);
		new TouchAction(driver).tap(PointOption.point(349, 624)).perform();
		waitTime(5000);
		new TouchAction(driver).tap(PointOption.point(349, 624)).perform();
		waitTime(5000);
		clickOnShareButton();
		return isElementClickable(shareBtn,30);
	}
	
	public String getSharePopupCopyText() throws IOException {		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        String actualCopedText="";
		try {
			actualCopedText = (String) clipboard.getData(DataFlavor.stringFlavor);
		} catch (UnsupportedFlavorException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println(e.getMessage()+"\n\n"+e.getStackTrace());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println(e.getMessage()+"\n\n"+e.getStackTrace());
		}
        return actualCopedText;
	}
	
	public void clickOnRandomVestUnderThemeButton() {
		waitForElementToBeClickable(randomVestUnderTheme, 30);
		clickWebElement(randomVestUnderTheme);
	}
	
	public void clickOnIPopupButton() {
		waitForElementToBeClickable(iPopup, 30);
		clickWebElement(iPopup);
	}
	
	public void clickOnIPopupCloseButton() {
		waitForElementToBeClickable(IPopupClosebtn, 30);
		clickWebElement(IPopupClosebtn);
	}
	
	public void clickOnvestGraphMaxButton() {
		try {
			waitTime(5000);
			driver.findElementByAccessibilityId("MAX").click();
			
		} catch (Exception e) {
			clickWebElement(vestGraphMaxBtn_2);
			
		}
	}
	public void clickOnVestGraph5YearButton() {
		try {
			waitTime(5000);
			driver.findElementByAccessibilityId("vestGraphFiveYearBtn").click();
		} catch (Exception e) {
			clickWebElement(vestGraph5YearBtn_2);
		}
	}
	public void clickOnVestGraph1YearButton() {
		try {
			waitTime(5000);
			driver.findElementByAccessibilityId("5Y").click();
		} catch (Exception e) {
			clickWebElement(vestGraph1YearBtn_2);
		}
	}
	public void clickOnVestGraph3MonthButton() {
		try {
			waitTime(5000);
			driver.findElementByAccessibilityId("3M").click();
		} catch (Exception e) {
			clickWebElement(vestGraph3MonthBtn_2);
		}
	}
	
	public void clickOnVestGraph1MonthButton() {
		try {
			waitTime(5000);
			driver.findElementByAccessibilityId("1M").click();
		} catch (Exception e) {
			clickWebElement(vestGraph1MonthBtn_2);
		}
	}
	
	public void clickOnVestGraph1WeekButton() {
		try {
			waitTime(5000);
			driver.findElementByAccessibilityId("1W").click();
		} catch (Exception e) {
			clickWebElement(vestGraph1WeekBtn_2);
		}
	}
	
	public void clickOnCreateRecurringInvestmentButton() {
		waitForElementToBeClickable(createRecurringInvestmentBtn, 30);
		clickWebElement(createRecurringInvestmentBtn);
	}
	
	public boolean verifyVestPerformanceChartTitleIsDisplaying() {
		waitForElementToBePresent(vestPerformanceChartTitle, 30);
		return isElementDisplayed(vestPerformanceChartTitle);
	}
	
	public boolean verifyCreateRecurringInvestmentButtonIsDisplaying() {
		return isElementDisplayed(createRecurringInvestmentBtn);
	}
	
	public boolean verifyOverviewGraphIsDisplaying() {
		waitForElementToBePresent(overviewGraph, 30);
		return isElementDisplayed(overviewGraph);
	}
	
	public void clickOnRandomVestMultiAssetClass() {
		waitForElementToBeClickable(randomMultiAssetClassVest, 30);
		clickWebElement(randomMultiAssetClassVest);
	}

	public void clickOnCompareVestsButton() {
		clickWebElement(compareVestsButton);
	}

	public boolean verifyVestIsDisplaying(String name) {
		
		return isElementDisplayed(getDriver().findElement(By.xpath("(//XCUIElementTypeStaticText[@name='"+name+"'])[1]")));
	}

	public void clickOnCloseModalButton() {
		clickWebElement(btnCloseCompareVestsModal);
	}

	public void clickOnVBNIXInfoIcon() {
//		scrollDownToIOSElement(getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Your Position\"]")));
		waitTime(1000);
		clickWebElement(infoIconCompareVestsVBNIX);
	}

	public boolean verifyVBNIXInfoPopup() {
		return isElementDisplayed(vestCompareVBNIXInfoPopup);
	}

	public void clickVestDetailsCreateRecurringInvestmentButton() {
		click(vestDetailsCreateRecurringInvestmentBtn);
	}

	public boolean vverifyCreateRecurringInvestmentPageIsDisplaying() {
		return isElementDisplayed(pageCreateRecurringInvestment);
	}

	public void clickOnBackButton() {
		try {
			click(backButton);
		} catch (Exception e) {
			new TouchAction(driver).tap(PointOption.point(20, 68)).perform();
		}
	}

	public boolean verifyVestBuyButtonIsDisplaying() {
		waitForElementToBePresent(vestBuyButton,30);
		return isElementDisplayed(vestBuyButton);
	}

	public boolean verifyMultiAssetVestOverviewGraphIsDisplaying() {
		
		return isElementDisplayed(multiAssetVestOverviewGraph);
	}

	public boolean verifyConservativeVestInComparePortfolioModalIsDisplaying() {
		return isElementDisplayed(vestConservativeComparePrtfolioModal);
	}

	public boolean verifyModerateVestInComparePortfolioModalIsDisplaying() {
		return isElementDisplayed(vestModerateComparePrtfolioModal);
	}

	public boolean verifyAggressiveVestInComparePortfolioModalIsDisplaying() {
		return isElementDisplayed(vestAggressiveComparePrtfolioModal);
	}
	
	
	
}
