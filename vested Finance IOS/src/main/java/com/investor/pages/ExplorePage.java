package com.investor.pages;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.base.BaseClass.Direction;
import com.investor.listeners.ExtentListeners;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ExplorePage extends BaseClass {

	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Browse, tab,')]")
	WebElement browseButton;

	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Home, tab,')]")
	WebElement homeButton;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Recommended']")
	WebElement recommendedLabel;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='WATCHLIST']")
	WebElement watchListLabel;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='watchListLabel']")
	WebElement watchListLabel_2;
	
	

	@FindBy(xpath = "//XCUIElementTypeOther[@name='watchListLabel watchListRefreshIcon watchListFilterIcon']/following-sibling:: XCUIElementTypeOther/XCUIElementTypeScrollView")
	WebElement firstWatchListStock;
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='watchListItemItem'])[1] | (//XCUIElementTypeOther[@name='watchListItemSymbol watchListItemLabel'])[1]")
	WebElement firstWatchListStock_2;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='RenderTickerWatchListBtn']")
	WebElement watchListButton;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@label,'Overview')])[last()]")
	WebElement overviewTab;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name=\"Overview\"])[2]")
	WebElement overviewTab_2;


	@FindBy(xpath = "//XCUIElementTypeOther[@name='Returns']")
	WebElement returnsTab;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'fundamental data')])[last()]")
	WebElement fundamentalDataTab;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'key ratios')])[last()]")
	WebElement keyRatiosTab;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'Today')])[last()]")
	WebElement overviewTabDetails;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Past Week']")
	WebElement overviewTabDetails_2;

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'1-Week Return')]")
	WebElement returnsTabDetails;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='No data available!']")
	WebElement returnsTabDetails_2;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='incomeStatement']")
	WebElement fundamentalDataTabDetails;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='No income statements data available!']")
	WebElement fundamentalDataTabDetails_2;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@label,'LIQUIDITY')])[last()]")
	WebElement keyRatiosTabDetails;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name='No data available!'])[2]")
	WebElement keyRatiosTabDetails_2;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='instrumentDetailsBuyBtn'] | (//XCUIElementTypeOther[@label='BUY'])[last()]")
	WebElement BUYButton;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Total Buying Power']")
	WebElement fundAccountPage;

	@FindBy(xpath = "(//android.widget.TextView[@text='Shares']/following-sibling::android.widget.EditText)[1]")
	WebElement inputSharesBuyStock;

	@FindBy(xpath = "(//android.widget.TextView[@text='Shares']/following-sibling::android.widget.EditText)[2]")
	WebElement inputEstimateCostBuyStock;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[31]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView")
	WebElement marketPriceLabel;

	@FindBy(xpath = "//android.widget.TextView[@text='Preview Order']")
	WebElement previewOrderButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Order Preview']")
	WebElement previewOrderPage;

	@FindBy(xpath = "//android.widget.TextView[@text='Place Buy Order']")
	WebElement placeBUYOrderButton;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Your order has been placed')]")
	WebElement orderPlacedButton;

	@FindBy(xpath = "//android.widget.TextView[@text='YOUR PORTFOLIO']")
	WebElement yourPortfolioLabel;

	@FindBy(xpath = "(//android.widget.TextView[@text='YOUR PORTFOLIO']/following-sibling::android.widget.ScrollView//android.view.ViewGroup)[1]")
	WebElement portfolioFirstStock;

	@FindBy(xpath = "//android.widget.TextView[@text='SELL']")
	WebElement SELLButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Place Sell Order']")
	WebElement placeSellOrderButton;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'HI,')]")
	WebElement homePageHeading;

	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Transfer, tab,')]")
	WebElement transferMenu;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'Transfer Funds')])[last()]")
	WebElement transferPageHeading;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='ADD FUNDS']")
	WebElement transferFundsAddFundsBtn;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='WITHDRAW FUNDS']")
	WebElement transferFundsWithdrawFundsBtn;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'SWITCH BANK')]")
	WebElement switchBankBtn;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'PROCEED WITH ')])[last()]")
	WebElement proceedWIthBankBtn;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='HOW MUCH DO YOU WANT TO DEPOSIT?']")
	WebElement depositPageHeading;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Add funds']")
	WebElement transferAddFundsPageHeading;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Withdrawal Process']")
	WebElement transferWithdrawalProcessPageHeading;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Withdrawal Process']")
	WebElement transferWithdrawalProcessPageHeading_2;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label='Alphabetical']")
	WebElement sortingAlpha;
	

	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Direct, tab,')]")
	WebElement directMenu;

	@FindBy(xpath = "//*[contains(@name,'Vested Direct')]")
	WebElement directPageHeading;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name='OPEN VESTED DIRECT ACCOUNT'])[2]")
	WebElement openVestedDirectAccountBtn;
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='vestedDirectOpenAccountBtn'])[2]")
	WebElement openVestedDirectAccountBtn_2;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Open Vested Direct Account'] | //*[contains(@name,'Downtime')]")
	WebElement openVestedDirectAccountPageHeading;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Open Vested Direct Account']")
	WebElement openVestedDirectAccountPageHeading_2;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Bank servers are offline from 11 PM to 4 AM IST.']")
	WebElement bankServersAreOfflinePage;
	

	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'DIY Vest, tab,')]")
	WebElement diyVestMenu;

	@FindBy(xpath = "//XCUIElementTypeOther[@name=\"dashboardHeaderProfileIcon\"]")
	WebElement profileMenu;
//	/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[15]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup

	By profileButton = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[15]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup");

	@FindBy(xpath = "(//*[@name='Profile & Settings'])[last()]")
	WebElement profilePageHeading;
	
	@FindBy(xpath = "//*[@name='General']")
	WebElement generalTabProfilePage;

	@FindBy(xpath = "//android.widget.TextView[@text='Referral']")
	WebElement referralMenu;

	@FindBy(xpath = "//android.widget.TextView[@text='Give $10, Get $10']")
	WebElement referralPageHeading;

	@FindBy(xpath = "//android.widget.TextView[@text='Referral disclosure']")
	WebElement referralDisclosureLink;

	@FindBy(xpath = "//android.widget.TextView[@text='Disclosure for Referrer']")
	WebElement disclosureForReferrerHeading;

	@FindBy(xpath = "//android.widget.TextView[@text='FAQs']")
	WebElement FAQsLink;

	@FindBy(xpath = "//android.widget.TextView[@text='Frequently Asked Questions']")
	WebElement frequentlyAskedQuestionsHeading;

	@FindBy(xpath = "//android.widget.TextView[@text='COMPLETE KYC PROCESS']")
	WebElement completeKycProcessBtn;

	@FindBy(xpath = "//android.widget.TextView[@text='Risk tolerance']")
	WebElement completeKycProcessHeading;

	@FindBy(xpath = "//android.widget.TextView[@text='Ok, Got It']")
	WebElement dialogGotItButton;

	@FindBy(xpath = "//android.widget.TextView[@text='OK']")
	WebElement okButton;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]")
	WebElement ratingPopupNoBtn;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]")
	WebElement weSorryToHearThatPopupCancelBtn;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@label, 'Transactions')])[last()] | (//*[contains(@label,'Transactions')])[last()]")
	WebElement profile_TransactionsButton;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Transactions']")
	WebElement profile_TransactionsPage;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@label, 'Trade Confirmation')])[last()] | (//*[contains(@label,'Trade Confirmation')])[last()]")
	WebElement profile_TradeConfirmation;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Trade Confirmations']")
	WebElement profile_TradeConfirmationsPage;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@label, 'Account statement')])[last()] | (//*[contains(@label,'Account statement')])[last()]")
	WebElement profile_AccountStatement;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Account Statements']")
	WebElement profile_AccountStatementPage;
	

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'Tax Documents')])[last()]")
	WebElement profile_taxDocument;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='managePlanLabel'] | //XCUIElementTypeStaticText[@label='Manage Plan']")
	WebElement profile_ManagePlan;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Plan Management']")
	WebElement profile_planManagementHeading;

	@FindBy(xpath = "//android.widget.TextView[@text='Top Movers']/following-sibling::android.widget.HorizontalScrollView[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")
	WebElement topMoversFistStockElement;

	@FindBy(xpath = "//android.widget.TextView[@text='Recommended']/following-sibling::android.widget.HorizontalScrollView[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")
	WebElement recommendedFirstStockItem;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name='DIY Vest'])[last()]")
	private WebElement diyVestPageHeading;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[23]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.TextView")
	WebElement divVestMoreOption3Dots;

	@FindBy(xpath = "//android.widget.TextView[@text = 'Share']")
	WebElement shareButton;

	@FindBy(xpath = "//android.widget.TextView[@text = 'Alphabetical']")
	WebElement alphabeticalButton;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@label,'Create New Vest')])[last()]")
	WebElement createNewButton;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='diyCreateVest']")
	WebElement createNewButton_2;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Search Or Browse Ideas']")
	WebElement searhOrBrowserIdeasText;

	@FindBy(xpath = "//android.widget.TextView[@text = 'Past week']")
	WebElement pastWeek;

	@FindBy(xpath = "//android.widget.TextView[contains(@text , 'Next')]")
	WebElement nextText;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='renderSectionTopMoversShowAllBtn'] | (//XCUIElementTypeOther[@label='Show all'])[1]")
	WebElement btnShowAllTopMovers;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'Top Movers')])[3]")
	private WebElement topMoversPageHeading;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name='Show all'])[2]")
	WebElement btnShowAllRecommended;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name='Skip'])[3]")
	WebElement skipButton;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Investment Profile']")
	WebElement headingInvestmentProfile;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Recurring Investments']")
	WebElement headingRecurringInvestmentPage;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='superVestsInfoIcon'] | //XCUIElementTypeStaticText[@name=\"MULTI-ASSET CLASS VESTS\"]//following-sibling::XCUIElementTypeOther")
	WebElement multiAssetVestInfoIcon;

	@FindBy(xpath = "//XCUIElementTypeOther[contains(@name,'Multi-Asset Class Portfolios')]")
	WebElement multiAssetClassVestInfoDialog;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Multi-Asset Class Portfolios']//following-sibling::XCUIElementTypeStaticText | //XCUIElementTypeStaticText[@name='vestedInfoDialogClose']")
	WebElement InfoDialogCloseButton;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='close']")
	WebElement ThemeBasedVestInfoDialogCloseButton;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'MULTI-ASSET CLASS VESTS')]/following::XCUIElementTypeOther//XCUIElementTypeScrollView/XCUIElementTypeOther)[1]/XCUIElementTypeOther")
	List<WebElement> multiAssetClassVestsTypes;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'THEME-BASED VESTS')]/following::XCUIElementTypeOther//XCUIElementTypeScrollView/XCUIElementTypeOther)[1]/XCUIElementTypeOther")
	List<WebElement> themeBasedVestsTypes;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'themeBasedVestCardLabel')]")
	List<WebElement> themeBasedVestsTypes_2;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='VestedInfoDialog'] | (//XCUIElementTypeOther[contains(@label,'Theme-Based Vests ')])[last()]")
	WebElement themeBasedVestInfoDialog;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='EducationBannerShow'] | (//XCUIElementTypeOther[contains(@name,'THEME-BASED VESTS')]/following::XCUIElementTypeOther[contains(@name,'Features')])[1]")
	WebElement themeBasedVestFeatureBanner;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value='Features']")
	WebElement themeBasedVestFeatureBanner_2;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@label='Recurring Investments'] | //XCUIElementTypeOther[@name='recurringInvestmentsLabel']")
	WebElement recurringInvestments;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@label='Referral'] | //XCUIElementTypeOther[@name='referralLabel']")
	WebElement referral;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='backButton'] | //XCUIElementTypeOther[@name=\"\"]")
	private WebElement backButton;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='THEME-BASED VESTS']/following-sibling::XCUIElementTypeOther")
	private WebElement themeBasedVestInfoIcon;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='cashAvailableForTrade']")
	WebElement buyingPower;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='unSettledCash']")
	WebElement UnsettledCash;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='transferTabVestedUSDBalanceValue']")
	WebElement vestedAvailableBalance;

	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Rewards, tab,')]")
	private WebElement rewardsTabMenu;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name='Rewards'])[last()]")
	private WebElement rewardsPage;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Earn']")
	private WebElement btnRewardsEarnTab;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Refer And Earn']")
	private WebElement referAndEarnSection;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Redeem']")
	private WebElement btnRewardsRedeemTab;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Redeem For Cash']")
	private WebElement rewardsRedeemSections;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='History']")
	private WebElement btnRewardsHistoryTab;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='No transaction yet']")
	private WebElement rewardsHistorySection;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'profileTaxDocumentYearScelectionListItem')])[last()]")
	private WebElement latestTaxDocumentItem;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Supporting Tax Documents']")
	private WebElement supportingTaxDocumentDetailsPage;
	
	@FindBy(xpath = "	\r\n"
			+ "//XCUIElementTypeStaticText[@name=\"No Documents Available.\"]")
	private WebElement nodocPage;


	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='profileTaxDocumentScreenTaxPdf']")
	private WebElement generalFilingSummaryPDFTaxDoc;

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'.pdf')]")
	private WebElement pdfTaxDocument;

	@FindBy(xpath ="//XCUIElementTypeButton[@name='Cancel']")
	private WebElement btnCancelViewTaxDoc;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='profileTaxDocumentScreenTaxXlsx']")
	private WebElement generalFilingSummaryXLSXTaxDoc;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'.xlsx')]")
	private WebElement xlsxTaxDocument;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='profileTaxDocumentScreenForeignAsset']")
	private WebElement foriegnAssetsFilingSummary;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='profileTaxDocumentScreenTaxSchedule']")
	private WebElement foreignSourceOfIncomeTaxDoc;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='profileTaxDocumentScreenTaxForm67']")
	private WebElement form67FilingSummaryTaxDoc;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='profileTaxDocumentScreenScheduleTRUrl']")
	private WebElement scheduleTRFilingSimmaryTaxDoc;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select A Plan\"]")
	private WebElement selectAPlanPage;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name=\"selectBillingPeriodBtnPREMIUMdefault\"] | //XCUIElementTypeOther[@name=\"selectBillingPeriodBtnPREMIUMquarterly\"]")
	private WebElement priceGoPremiumPage;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"goPremiumLabel\"] | (//XCUIElementTypeOther[contains(@name, \"Go Premium\")])[last()]")
	private WebElement goPremiumBtn;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='chevronLeftBackBtnPreimuimSub'] | //XCUIElementTypeStaticText[@name=\"chevron_left\"]")
	private WebElement premiumPageBackButton;
	
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Multi-Asset Class Vests are only available to Premium subscribers.\"]")
	private WebElement buyPopUp;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Subscribe and save Vest fees\"]")
	private WebElement subscribeSaveButton;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name=\"transferTabWithdrawFundsBtn\"]")
	private WebElement withdrawFundBtn;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='browseTabSearchBtn']//XCUIElementTypeOther")
	private WebElement searchField;
	
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='searchTextInput']")
	private WebElement searchFieldBrowsePage;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='searchResultList']//XCUIElementTypeOther")
	private WebElement firstSearchElement;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='instrumentDetailsBuyBtn']")
	private WebElement buyButton;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='estimateCostInputId']")
	private WebElement previewButton;
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='Place Buy Order'])[2]")
	private WebElement placeOrderButton;
	
	@FindBy(xpath = "//XCUIElementTypeTextField[@name='marketInputShareId']")
	private WebElement shareInput;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Your order was placed successfully.']")
	private WebElement successfullMessage;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'View details')])[last()]")
	private WebElement btnViewReferralDetails;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Referrals']")
	private WebElement referralsPage;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Invite']")
	private WebElement btnInviteReferral;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='FAQs']")
	private WebElement btnFAQReferral;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Referral disclosure']")
	private WebElement referralDisclosure;

	@FindBy(xpath="//XCUIElementTypeButton[@name='Copy']")
	private WebElement btnCopyReferral;

	@FindBy(xpath="//XCUIElementTypeImage[@name=\"copy\"]")
	private WebElement btnCopyReferral_2;

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='renderScetionTitle' and @label='Signals'])[1]")
	private WebElement signalsSection;

	@FindBy( xpath ="//XCUIElementTypeStaticText[@name='headerLeftName']")
	private WebElement signalDetailsPage;

	@FindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'LEARN MORE')])[last()]")
	private WebElement learnMoreButton;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='rightHeaderDropdown']")
	private WebElement signalsSortinDropdown;

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='renderScetionTitle'])[1]/following-sibling::XCUIElementTypeOther")
	private WebElement signalsInfoIcon;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Signals']")
	private WebElement signalsInfoDialog;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='close']")
	private WebElement closePopupSignalPopup;

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Signals are lists of stocks pre-screened with fundamental strategies or technical indicators.')]")
	private WebElement signalsDescription;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Signals Disclosure']")
	private WebElement signalsDisclosure;

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'At Vested, our mission is to empower you to become a successful investor.')]")
	WebElement signalsDisclosureDescription;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='vestedInfoDialogClose']")
	WebElement signalsDisclosureCloseIcon;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name=\"General\"]")
	WebElement generalTabInProfile;

	By otcSection = By.xpath("(//XCUIElementTypeStaticText[@name='renderScetionTitle' and @label='OTC'])[1]");

	By incomeFocusSection = By.xpath("//XCUIElementTypeStaticText[@label=\"Income Focused\"]");
	

	By etfproviderSection = By.xpath("//XCUIElementTypeStaticText[@label=\"ETF Providers\"]");
	
	

	By topMoversSection = By.xpath("(//XCUIElementTypeStaticText[@name='renderScetionTitle'])[2]");

	@FindBy(xpath="//XCUIElementTypeStaticText[@name='renderSectionOTCShowAllBtn']")
	private WebElement otcShowAllButton;

	@FindBy(xpath="(//XCUIElementTypeStaticText[@name='headerLeftName' and @label='OTC'])")
	private WebElement otcDetailsScreen;

	@FindBy(xpath="//XCUIElementTypeOther[@name='signUpSuccessExplorePlatformBtn']")
	private WebElement explorePlatformButton;

	@FindBy(xpath="//XCUIElementTypeOther[@name='ACCEPT AND PROCEED']")
	private WebElement btnAcceptAndProceed;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name='Over-the-Counter (OTC) Securities'])[last()]")
	private WebElement otcDetailsHeading;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='collectionStockMarketcap']")
	List<WebElement> otcStocksMarketCapital;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='collectionStockName']")
	List<WebElement> otcStocksNames;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='collectionStockSymbol']")
	List<WebElement> otcStocksSymbols;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='collectionStockPrice']")
	List<WebElement> otcStocksMarketPrice;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='collectionStockChangePercent']")
	List<WebElement> otcStocksDailyChange;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='renderSectionTopMoversShowAllBtn']")
	private WebElement topMoversShowAllButton;

	private By recommendedSection = By.xpath("(//XCUIElementTypeStaticText[@name='renderScetionTitle'])[3]");

	@FindBy(xpath="//XCUIElementTypeStaticText[@name='renderSectionRecommendedShowAllBtn']")
	private WebElement recommendedShowAllButton;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Recommended Disclosure']")
	private WebElement recommendedDisclosure;

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Recommended Disclosure'])[2]")
	private WebElement recommendedDisclosurePopUp;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='vestedInfoDialogClose']")
	private WebElement xIconRecommendedDisclosure;

	@FindBy( xpath = "//XCUIElementTypeStaticText[contains(@name,'At Vested, our mission is to empower you to become a successful investor.')]")
	private WebElement recommendedDisclosureDescription;

	private By emergingThemeSection = By.xpath("//XCUIElementTypeStaticText[@name='renderScetionTitle' and @label='Emerging Themes']");

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Emerging Themes Disclosure'])[last()]")
	private WebElement emergingThemeDisclosure;

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Emerging Themes Disclosure'])[2]")
	private WebElement emergingThemeDisclosurePopUp;

	@FindBy( xpath = "//XCUIElementTypeStaticText[contains(@name,'This collection is a curated list of companies that have material involvement in the specified collection.')]")
	private WebElement emergingThemeDisclosureDescription;

	private By sectorsSection = By.xpath("//XCUIElementTypeStaticText[@name='renderScetionTitle' and @label='Sectors']");
	private By emergingThemesSection = By.xpath("//XCUIElementTypeStaticText[@name='renderScetionTitle' and @label='Emerging Themes']");
	private By geographySection = By.xpath("//XCUIElementTypeStaticText[@name='renderScetionTitle' and @label='Geographic Breakdowns']");

	@FindBy(xpath="//XCUIElementTypeStaticText[@name='renderSectionRecommendedShowAllBtn'] | (//XCUIElementTypeStaticText[@name='renderScetionTitle' and @label='Signals'])[1] | (//XCUIElementTypeStaticText[@name='renderScetionTitle' and @label='Top Movers'])[1]")
	private WebElement browsePage;
	
	public ExplorePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyBrowseButtonIsDisplaying() {
		//waitForElementToBeClickable(browseButton, 30);
		return isElementDisplayed(browseButton);
	}

	public void clickOnBrowseButton() {
		new TouchAction(driver).tap(PointOption.point(118, 783)).perform();
		//clickWebElement(browseButton);
	}

	public void clickOnHomeButton() {
		waitForElementToBeClickable(homeButton, 30);
		clickWebElement(homeButton);
	}
	public void clickOnGeneralTab() {
		waitForElementToBeClickable(generalTabInProfile, 30);
		clickWebElement(generalTabInProfile);
	}
	public boolean verifyRecommendedLabelIsDisplaying() {
		waitForElementToBePresent(By.xpath("//XCUIElementTypeStaticText[@label='Recommended']"), defaultTimeForVisibility);
		for(int i=0;i<3;i++){
			if(recommendedLabel.isDisplayed()) {
				break;
			}
			swipeUpLess();
		}
		return isElementDisplayed(recommendedLabel);
	}

	public boolean verifyWatchListLabelIsDisplaying() {
		try {
			//waitForElementToBePresent(watchListLabel_2, 30);
			return isElementDisplayed(watchListLabel_2);
		} catch (Exception e) {
			//waitForElementToBePresent(watchListLabel, 30);
			return isElementDisplayed(watchListLabel);
		}
	}

	public boolean verifyYourPortfolioLabelIsDisplaying() {
		scrollToText("YOUR PORTFOLIO");
		waitTime(2000);
		waitForElementToBePresent(yourPortfolioLabel, 30);
		return isElementDisplayed(yourPortfolioLabel);
	}

	public void clickOnWatchListStock() {
		try {
			try {
				//waitForElementToBeClickable(firstWatchListStock_2, 30);
				clickWebElement(firstWatchListStock_2);
				
			} catch (Exception e) {
				swipeUpLess();
				//waitForElementToBeClickable(firstWatchListStock_2, 30);
				clickWebElement(firstWatchListStock_2);
			}
			
		} catch (Exception e) {
			
			//waitForElementToBeClickable(firstWatchListStock, 30);
			clickWebElement(firstWatchListStock);
			// TODO: handle exception
		}
	}

	public boolean verifyWatchListButtonIsDisplaying() {
		//waitForElementToBePresent(watchListButton, 30);
		return isElementDisplayed(watchListButton);
	}

	public void clickOnOverviewTab() {
		try{
			waitForElementToBeClickable(overviewTab, 30);
			clickWebElement(overviewTab);
		}catch (Exception e){
			waitForElementToBeClickable(overviewTab_2, 30);
			clickWebElement(overviewTab_2);
		}

	}

	public boolean verifyOverviewTabDetailsIsDisplaying() {
		try {
			waitForElementToBePresent(overviewTabDetails, 30);
			return isElementDisplayed(overviewTabDetails);
		}catch (Exception e){
			waitForElementToBePresent(overviewTabDetails_2, 30);
			return isElementDisplayed(overviewTabDetails_2);
		}

	}

	public void clickOnReturnsTab() {
		//waitForElementToBeClickable(returnsTab, 30);
		clickWebElement(returnsTab);
	}

	public boolean verifyReturnsTabDetailsIsDisplaying() {
		try {
			waitForElementToBePresent(returnsTabDetails, 30);
			return isElementDisplayed(returnsTabDetails);
		}catch (Exception e){
			waitForElementToBePresent(returnsTabDetails_2, 30);
			return isElementDisplayed(returnsTabDetails_2);
		}

	}

	public void clickOnFundamentalDataTab() {
		waitForElementToBeClickable(fundamentalDataTab, 30);
		clickWebElement(fundamentalDataTab);
	}

	public boolean verifyFundamentalDataTabDetailsIsDisplaying() {
		try {
			waitForElementToBePresent(fundamentalDataTabDetails, 30);
			return isElementDisplayed(fundamentalDataTabDetails);
		}catch (Exception e){
			waitForElementToBePresent(fundamentalDataTabDetails_2, 30);
			return isElementDisplayed(fundamentalDataTabDetails_2);
		}

	}

	public void clickOnKeyRatiosTab() {
		waitForElementToBeClickable(keyRatiosTab, 30);
		clickWebElement(keyRatiosTab);
	}

	public boolean verifyKeyRatiosTabDetailsIsDisplaying() {
		try {
			return isElementDisplayed(keyRatiosTabDetails);
		}catch (Exception e){
			return isElementDisplayed(keyRatiosTabDetails_2);
		}

	}

	public boolean verifyFundAccountPageIsDisplaying() {
		waitForElementToBeClickable(fundAccountPage, 30);
		return isElementDisplayed(fundAccountPage);
	}

	public void clickOnBUYTab() {
		waitForElementToBeClickable(BUYButton, 30);
		clickWebElement(BUYButton);
	}

	public void enterShareValue(String shares) {
		waitForElementToBeClickable(inputSharesBuyStock, 30);
		sendKeysToWebElement(inputSharesBuyStock, shares, "Share value");
	}

	public boolean verifyEstimateCostValueIsAutoPopulated() {
		waitForElementToBePresent(inputEstimateCostBuyStock, 30);
		String cost = getWebElementText(inputEstimateCostBuyStock, "Estimate Cost");
		return !cost.equals("0");
	}

	public String getEstimatedCostValue() {
		waitForElementToBePresent(inputEstimateCostBuyStock, 30);
		String cost = getWebElementText(inputEstimateCostBuyStock, "Estimate Cost");
		return cost;
	}

	public double getStockMarketPrice() {
		double marketPrice = 0.00;
		String price = getWebElementText(marketPriceLabel, "");
		price.replace("$", "");
		price.replace(",", "");
		marketPrice = Double.parseDouble(price);
		return marketPrice;
	}

	public void clickOnPreviewOrderButton() {
		waitForElementToBeClickable(previewOrderButton, 30);
		clickWebElement(previewOrderButton);
	}

	public boolean verifyPreviewOrderPageIsDisplaying() {
		waitForElementToBePresent(previewOrderPage, 30);
		return isElementDisplayed(previewOrderPage);
	}

	public void clickOnPlaceBuyOrderButton() {
		waitForElementToBeClickable(placeBUYOrderButton, 30);
		clickWebElement(placeBUYOrderButton);
	}

	public boolean verifyOrderPlacedPageIsDisplaying() {
		waitForElementToBePresent(orderPlacedButton, 30);
		return isElementDisplayed(orderPlacedButton);
	}

	public void clickOnPortfolioFirstStock() {
		waitForElementToBeClickable(portfolioFirstStock, 30);
		clickWebElement(portfolioFirstStock);
	}

	public void clickOnSELLButton() {
		waitForElementToBeClickable(SELLButton, 30);
		clickWebElement(SELLButton);
	}

	public void clickOnPlaceSellOrderButton() {
		waitForElementToBeClickable(placeSellOrderButton, 30);
		clickWebElement(placeSellOrderButton);
	}

	public boolean verifyHomePageIsDisplaying() {
		waitForElementToBePresent(homePageHeading, 30);
		return isElementDisplayed(homePageHeading);
	}

	// Transfer Menu
	public void clickOnTransferMenuButton() {
		waitForElementToBeClickable(transferMenu, 30);
		clickWebElement(transferMenu);
	}

	public boolean verifyTransferPageIsDisplaying() {
		waitForElementToBePresent(transferPageHeading, 30);
		return isElementDisplayed(transferPageHeading);
	}

	public void clickOnSkipButton() {
		waitForElementToBeClickable(skipButton, 30);
		clickWebElement(skipButton);
	}

	public void clickOnTransferFundsAddFundsButton() {
		waitForElementToBeClickable(transferFundsAddFundsBtn, 30);
		clickWebElement(transferFundsAddFundsBtn);
		waitTime(2000);
		if (isElementDisplayed(skipButton)) {
			clickOnSkipButton();
		}
	}

	public void clickOnProceedWithBankButton() {
		waitForElementToBeClickable(proceedWIthBankBtn, 30);
		clickWebElement(proceedWIthBankBtn);
	}

	public boolean verifyDepositPageHeadingIsDisplaying() {
		waitForElementToBePresent(depositPageHeading, 30);
		return isElementDisplayed(depositPageHeading);
	}

	public void clickOnSwitchBankButton() {
		try {
			waitForElementToBeClickable(switchBankBtn, 30);
			goBack();
		} catch (Exception e) {
		}
	}

	public boolean verifyTransferAddFundsPageHeadingIsDisplaying() {
		waitForElementToBePresent(transferAddFundsPageHeading, 30);
		return isElementDisplayed(transferAddFundsPageHeading);
	}

	public boolean verifyTransferWithdrawalProcessPageHeadingIsDisplaying() {
		
		try {
			waitForElementToBePresent(transferWithdrawalProcessPageHeading_2, 30);
			return isElementDisplayed(transferWithdrawalProcessPageHeading_2);
			
		} catch (Exception e) {
			waitForElementToBePresent(transferWithdrawalProcessPageHeading, 30);
			return isElementDisplayed(transferWithdrawalProcessPageHeading);
		}
	}

	public void clickOnTransferFundsWithdrawFundsButton() {
		waitForElementToBeClickable(transferFundsWithdrawFundsBtn, 30);
		clickWebElement(transferFundsWithdrawFundsBtn);
	}

	// Direct Menu
	public void clickOnDirectMenuButton() {
		waitForElementToBeClickable(directMenu, 30);
		clickWebElement(directMenu);
	}

	public boolean verifyDirectPageIsDisplaying() {
		waitForElementToBePresent(directPageHeading, 30);
		return isElementDisplayed(directPageHeading);
	}

	public void clickOnOpenVestedDirectAccountButton() {

		try {
			waitForElementToBeClickable(openVestedDirectAccountBtn_2, 30);
			clickWebElement(openVestedDirectAccountBtn_2);
			
		} catch (Exception e) {
			waitForElementToBeClickable(openVestedDirectAccountBtn, 30);
			clickWebElement(openVestedDirectAccountBtn);
		}
	}

	public boolean verifyOpenVestedDirectAccountPageHeadingIsDisplaying() {
		 if(verifyBankServersAreOfflinePageIsDisplaying() == false) {
			 try {
				 waitForElementToBePresent(openVestedDirectAccountPageHeading_2, 30);
				 return isElementDisplayed(openVestedDirectAccountPageHeading_2);
			} catch (Exception e) {
				waitForElementToBePresent(openVestedDirectAccountPageHeading, 30);
				return isElementDisplayed(openVestedDirectAccountPageHeading);
			}
		 }
		 return verifyBankServersAreOfflinePageIsDisplaying();
	}
	
	public boolean verifyBankServersAreOfflinePageIsDisplaying() {
		try {
			waitForElementToBePresent(bankServersAreOfflinePage, 30);
			return isElementDisplayed(bankServersAreOfflinePage);
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnProfileMenuButton() {
		try {
			waitForElementToBeClickable(profileMenu, 30);
			clickWebElement(profileMenu);		
		} catch (Exception e) {
			new TouchAction(driver).tap(PointOption.point(396, 70)).perform();
		}
		
//		
		
	}

	public void clickOnProfileMenuButtonAndroidElement() {
		IOSElement element = waitForElementToBePresent(profileButton, 30);
		clickElement(element, "");
	}

	public void clickOnDIYVestMenuButton() {
		waitForElementToBeClickable(diyVestMenu, 60);
		clickWebElement(diyVestMenu);
	}

	public boolean verifyProfilePageIsDisplaying() {
		waitForElementToBePresent(profilePageHeading, 30);
		return isElementDisplayed(profilePageHeading);
	}
	
	public boolean verifyGeneralTabIsDisplaying() {
		waitForElementToBePresent(generalTabProfilePage, 30);
		return isElementDisplayed(generalTabProfilePage);
	}
	
	public void clickGeneralTab() {
		waitForElementToBeClickable(generalTabProfilePage, 30);
		clickWebElement(generalTabProfilePage);
		
	}

	public void clickOnGotItButtonInDialog() {
		waitForElementToBeClickable(dialogGotItButton, 30);
		clickWebElement(dialogGotItButton);
	}

	public void clickOnOkButton() {
		waitForElementToBeClickable(okButton, 30);
		clickWebElement(okButton);
	}

	public void clickOnratingPopupNoButton() {
//		waitForElementToBeClickable(ratingPopupNoBtn, 30);
//		clickWebElement(element, "Rating Popup No Button");
//		Alert alert = driver.switchto().alert;
//		alert.accept();

	}

	public void clickOnweSorryToHearThatPopupCancelButton() {
		waitForElementToBeClickable(weSorryToHearThatPopupCancelBtn, 30);
		clickWebElement(weSorryToHearThatPopupCancelBtn);
	}

	public void goBack() {
		driver.navigate().back();
	}

//	public void clickOnOkButton() {
//		waitForElementToBeClickable(okButton, 30);
//		clickWebElement(element, "Ok Button");
//	}

	public void clickOnReferralMenuButton() {
		waitForElementToBeClickable(referralMenu, 30);
		clickWebElement(referralMenu);
	}

	public boolean verifyReferralPageHeadingIsDisplaying() {
		waitForElementToBePresent(referralPageHeading, 30);
		return isElementDisplayed(referralPageHeading);
	}

	public void clickOnReferralDisclosureLink() {
		waitTime(5000);
		scrollToText("Referral disclosure");
		waitForElementToBeClickable(referralDisclosureLink, 30);
		clickWebElement(referralDisclosureLink);
	}

	public boolean verifyDisclosureForReferrerHeadingIsDisplaying() {
		waitForElementToBePresent(disclosureForReferrerHeading, 30);
		return isElementDisplayed(disclosureForReferrerHeading);
	}

	public void clickOnFAQsLink() {
		waitTime(5000);
		scrollToText("FAQs");
		waitForElementToBeClickable(FAQsLink, 30);
		clickWebElement(FAQsLink);
	}

	public boolean verifyFrequentlyAskedQuestionsHeadingIsDisplaying() {
		waitForElementToBePresent(frequentlyAskedQuestionsHeading, 30);
		return isElementDisplayed(frequentlyAskedQuestionsHeading);
	}

	public void clickOncompleteKycProcessButton() {
		waitTime(5000);
		scrollToText("COMPLETE KYC PROCESS");
		waitForElementToBeClickable(completeKycProcessBtn, 30);
		clickWebElement(completeKycProcessBtn);
	}

	public boolean verifyCompleteKycProcessHeadingIsDisplaying() {
		waitForElementToBePresent(completeKycProcessHeading, 30);
		return isElementDisplayed(completeKycProcessHeading);
	}

	public void clickOnProfileTransactionButton() {
		
			waitForElementToBeClickable(profile_TransactionsButton, 30);
			clickWebElement(profile_TransactionsButton);
		
	}

	public boolean verifyTransactionHeadingIsDisplaying() {
		waitForElementToBePresent(profile_TransactionsPage, 30);
		return isElementDisplayed(profile_TransactionsPage);
	}

	public void clickOnProfileTradeConfirmationButton() {
		
			waitForElementToBeClickable(profile_TradeConfirmation, 30);
			clickWebElement(profile_TradeConfirmation);
		
	}

	public boolean verifyTradeConfirmationHeadingIsDisplaying() {
		waitForElementToBePresent(profile_TradeConfirmationsPage, 30);
		return isElementDisplayed(profile_TradeConfirmationsPage);
	}

	public void clickOnProfileAccountStatementsButton() {
		
//			waitForElementToBeClickable(profile_AccountStatement, 30);
			clickWebElement(profile_AccountStatement);
		
	}

	public boolean verifyAccountStatementsHeadingIsDisplaying() {
		waitForElementToBePresent(profile_AccountStatementPage, 30);
		return isElementDisplayed(profile_AccountStatementPage);
	}

	public void clickOnProfileTaxDocumentsButton() {
		waitForElementToBeClickable(profile_taxDocument, 30);
		clickWebElement(profile_taxDocument);
	}

	public boolean verifyTaxDocumentsHeadingIsDisplaying() {
		waitForElementToBePresent(profile_taxDocument, 30);
		return isElementDisplayed(profile_taxDocument);
	}

	public void clickOnProfileManagePlanButton() {
		
			scrollToText("Manage Plan");
			waitTime(1000);
			waitForElementToBeClickable(profile_ManagePlan, 30);
			clickWebElement(profile_ManagePlan);
	}

	public boolean verifyManagePlanHeadingIsDisplaying() {
		waitForElementToBePresent(profile_planManagementHeading, 30);
		return isElementDisplayed(profile_planManagementHeading);
	}

	public void clickOnButton(String btnName) {
		scrollToText(btnName);
		waitTime(1000);
		WebElement element = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + btnName + "']"));
		waitForElementToBeClickable(element, 30);
		clickWebElement(element);
	}

	public void clickOnButtonContains(String btnName) {
		scrollToText(btnName);
		waitTime(1000);
		WebElement element = driver.findElement(By.xpath("(//*[contains(@name,'" + btnName + "')])[last()]"));
		waitForElementToBeClickable(element, 30);
		clickWebElement(element);
	}

	public boolean verifyHeadingIsDisplaying(String heading) {
		WebElement element = driver.findElement(By.xpath("(//*[contains(@label,'" + heading + "')])[last()] | (//*[contains(@text,'" + heading + "')])[last()]"));
		return isElementDisplayed(element);
	}

	public void clickOnTopMoversStockItem() {
		clickWebElement(topMoversFistStockElement);
	}

	public void clickOnRecommendedStockItem() {
		clickWebElement(recommendedFirstStockItem);
	}

	public boolean verifyDIYVestPageIsDisplaying() {
		waitForElementToBePresent(diyVestPageHeading, 30);
		return isElementDisplayed(diyVestPageHeading);
	}

	public void clickOnDivVestMoreOption3Dots() {
		waitForElementToBeClickable(divVestMoreOption3Dots, 30);
		clickWebElement(divVestMoreOption3Dots);
	}

	public boolean isShareButtonPresent() {
		waitForElementToBePresent(shareButton, 30);
		return isElementDisplayed(shareButton);
	}

	public void clickOnDYourVestDropDown() {
		waitForElementToBeClickable(alphabeticalButton, 30);
		clickWebElement(alphabeticalButton);
	}

	public boolean isAlphabeticalButtonPresent() {
		waitForElementToBePresent(alphabeticalButton, 30);
		return isElementDisplayed(alphabeticalButton);
	}

	public void clickOnAlphabeticalButton() {
		waitForElementToBeClickable(alphabeticalButton, 30);
		clickWebElement(alphabeticalButton);
	}

	public void clickOnCreateNewButton() {
		waitTime(6000);
		try {
			waitForElementToBeClickable(createNewButton_2, 30);
			clickWebElement(createNewButton_2);
		} catch (Exception e) {
			waitForElementToBeClickable(createNewButton, 30);
			clickWebElement(createNewButton);
		}
	}

	public boolean isCreateNewDIYVestPagePresent() {
		waitForElementToBePresent(searhOrBrowserIdeasText, 30);
		return isElementDisplayed(searhOrBrowserIdeasText);
	}

	public void clickOnDIYVestPastWeekButton() {
		waitForElementToBeClickable(pastWeek, 30);
		clickWebElement(pastWeek);
	}

	public boolean isCreatedDIYVestPagePresent() {
		waitForElementToBePresent(nextText, 30);
		return isElementDisplayed(nextText);
	}

	public void clickOnshowAllButton() {
		waitForElementToBePresent(btnShowAllTopMovers, 30);
		click(btnShowAllTopMovers);
	}

	public boolean verifyTopMoversPageIsDisplaying() {
		return isElementDisplayed(topMoversPageHeading);
	}

	public void clickOnRecommendedShowAllButton() {
		for(int i=0;i<5;i++){
			if(recommendedShowAllButton.isDisplayed()) {
				break;
			}
			swipeUpLess();
		}
		waitTime(1000);
		click(recommendedShowAllButton);
	}

	public void pressBackButtonFromTopMoversPage() {
		waitTime(2000);
		new TouchAction(driver).tap(PointOption.point(22, 70)).perform();
	}

	public boolean verifyInvestmentProfileHeadingIsDisplaying() {

		return isElementDisplayed(headingInvestmentProfile);
	}

	public boolean verifyRecurringInvestmentHeadingIsDisplaying() {

		return isElementDisplayed(headingRecurringInvestmentPage);
	}

	public void scrollToMultiAssetClassVests() {
		scrollDownToText("MULTI-ASSET CLASS VESTS");
	}

	public void clickOnMultiAssetVestsInfoIcon() {
//		try {
//			scrollDownToIOSElement((IOSElement)getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name=\"superVestsInfoIcon\"]")));
//		} catch (Exception e) {
//			//e.printStackTrace();
//			System.err.println(e.getMessage()+"\n\n"+e.getStackTrace());
//		}
		waitTime(1000);
		clickWebElement(multiAssetVestInfoIcon);
	}

	public boolean isMultiAssetClassVestsDialogDisplaying() {
		return isElementDisplayed(multiAssetClassVestInfoDialog);
	}

	public void clickOnDialogCloseIcon() {
		click(InfoDialogCloseButton);
	}
	
	public void clickOnThemeBasedVestDialogCloseIcon() {
		click(ThemeBasedVestInfoDialogCloseButton);
	}

	public int getMultiAssetClassVestsListSize() {
		return multiAssetClassVestsTypes.size();
	}

	public void scrollToThemeBasedVests() {
		scrollDownToText("THEME-BASED VESTS");
	}

	public void clickOnThemeBasedVestsInfoIcon() {
		try {
			getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name='closeVestInfo']")).click();
			waitTime(1000);
			ExtentListeners.attachScreenShot("Click close vest info banner");
		}catch (Exception e) {
		}
		//waitForElementToBeClickable(themeBasedVestInfoIcon, defaultTimeForVisibility);
		MobileElement element = getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name='THEME-BASED VESTS']/following-sibling::XCUIElementTypeOther"));
		scrollToElementUpward(element);
		waitTime(2000);		
		click(element);
	}

	public boolean isThemeBasedVestsDialogDisplaying() {
		themeBasedVestInfoDialog = getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name='THEME-BASED VESTS']"));
		waitTime(2000);
		return isElementPresent(themeBasedVestInfoDialog,10);
	}

	public boolean isThemeBasedVestsBannerDisplaying() {
		try {
			return isElementDisplayed(themeBasedVestFeatureBanner_2);

		} catch (Exception e) {
			return isElementDisplayed(themeBasedVestFeatureBanner);
			// TODO: handle exception
		}
	}

	public List<WebElement> getThemeBasedVests() {
		return themeBasedVestsTypes_2;
	}

	public String getThemBasedVestName(WebElement element) {
//		String vestTextString = getElementText(element);
//		vestTextString = vestTextString.replace("renderSvgUriSymbol ","");
//		System.out.println(vestTextString);
		String name = getElementText(element);//vestTextString.substring(0, vestTextString.indexOf(" "));
		System.out.println("NAME OF ELEMENT:- "+name);
		scrollRightToText(name);
		waitTime(500);
		return name;
	}

	public boolean verifyThemeBasedVestIsEnabled(WebElement element) {
		return element.getAttribute("enabled").equals("true");
	}
	
	public void clickOnRecurringInvestmentsButton() {
//			waitForElementToBeClickable(recurringInvestments, 30);
//			clickWebElement(recurringInvestments);
//			
		Point location = recurringInvestments.getLocation();
		new TouchAction(driver).tap(PointOption.point(location)).perform();
		
	}
	
	public void clickOnReferralButton() {
			waitForElementToBeClickable(referral, 30);
			clickWebElement(referral);
	}
	
	public void clickOnBackButton() {
		click(backButton);
	}

	public Double getBuyingPower() {
		String BuyingP = "";
		try {
			scrollIntoViewSmoothly(buyingPower);
			waitForElementVisibility(buyingPower, defaultTimeForVisibility);
			BuyingP = getElementText(buyingPower);
		}catch (Exception e) {
			scrollIntoViewSmoothly(buyingPower);
			waitForElementVisibility(buyingPower, defaultTimeForVisibility);
			BuyingP = getElementText(buyingPower);
		}
		
		return Double.valueOf(BuyingP.replace("$", "").replace(",", ""));
	}
	
	public String getSlackMessage( String email, String env,String type) {
		String  slackMessage =  "**********************************************\n"
				+"iOS - Insufficient "+type+"("+env+")\n"
				+ "--------------------\n"
				+ "Cash dependent test scripts will be skipped due to insufficient "+type+". \n"
				+ "Kindly add funds and re-run the job.\n" + "Email: "
				+ email
				+ "\n**********************************************";
		return slackMessage;
	}
	
	public Double getUnSettledCash() {
		String Cost = "";
		try {
			scrollIntoViewSmoothly(UnsettledCash);
			waitForElementVisibility(UnsettledCash, defaultTimeForVisibility);
			Cost = getElementText(UnsettledCash);
		}catch (Exception e) {
			scrollIntoViewSmoothly(UnsettledCash);
			waitForElementVisibility(UnsettledCash, defaultTimeForVisibility);
			Cost = getElementText(UnsettledCash);
		}
		
		return Double.valueOf(Cost.replace("$", "").replace(",", ""));
	}
	
	public Double getTranferBalance() {
		Double Amount = 0.0;
		waitForElementVisibility(vestedAvailableBalance, defaultTimeForVisibility);
		Amount = Double.valueOf(getElementText(vestedAvailableBalance).replace(",", "").replace("$", "").toString());
		return Amount;
	}

	public void clickOnRewardsTab() {
		clickWebElement(rewardsTabMenu);
	}

	public boolean verifyRewardsPageIsDisplaying() {
		return isElementDisplayed(rewardsPage);
	}

	public void clickOnRewardsEarnTab() {
		click(btnRewardsEarnTab);
	}

	public boolean verifyReferAndEarnSectionIsDisplaying() {
		return isElementDisplayed(referAndEarnSection);
	}

	public void clickOnRewardsRedeemTab() {
		click(btnRewardsRedeemTab);
	}

	public boolean verifyRedeemSectionIsDisplaying() {
		return isElementDisplayed(rewardsRedeemSections);
	}

	public void clickOnRewardsHistoryTab() {
		click(btnRewardsHistoryTab);
	}

	public boolean verifyHistorySectionIsDisplaying() {
		return isElementDisplayed(rewardsHistorySection);
	}

	public void clickOnLatestTaxDocument() {
		clickWebElement(latestTaxDocumentItem);
	}

	public boolean verifySupportingTaxDocumentsHeadingIsDisplaying() {
		return isElementDisplayed(supportingTaxDocumentDetailsPage);
	}
	
	public boolean verifyNoDocAvailable() {
		return isElementDisplayed(nodocPage);
	}

	public void clickOnGeneralFilingSummaryPDF() {
		click(generalFilingSummaryPDFTaxDoc);
	}

	public boolean verifyTaxDocumentPDFDisplaying() {
		return isElementDisplayed(pdfTaxDocument);
	}

	public void clickOnTaxDocViewCancelButton() {
		((IOSDriver<MobileElement>) getDriver()).nativeWebTap(true);
		clickWebElement(btnCancelViewTaxDoc);
		try {
			waitForElementToBePresent(supportingTaxDocumentDetailsPage, 20);
		}catch(Exception e) {
			new TouchAction(driver).tap(PointOption.point(42, 65)).perform();
		}
	}

	public void clickOnGeneralFilingSummaryXLSX() {
		click(generalFilingSummaryXLSXTaxDoc);
	}

	public boolean verifyTaxDocumentXLSXDisplaying() {
		return isElementDisplayed(xlsxTaxDocument);
	}

	public void clickOnForiegnAssetsFilingSummaryXLSX() {
		click(foriegnAssetsFilingSummary);
	}

	public void clickOnForiegnSourceOfIncomeFilingSummaryXLSX() {
		click(foreignSourceOfIncomeTaxDoc);
	}

	public void clickOnForm67FilingSummaryXLSX() {
		click(form67FilingSummaryTaxDoc);
	}

	public void clickOnScheduleTRFilingSummaryXLSX() {
		click(scheduleTRFilingSimmaryTaxDoc);
	}
	
	public void clickOnGoPremiumBtn() {
		click(goPremiumBtn);
	}
	
	public void clickOnBackBtnPremiumPage() {
		click(premiumPageBackButton);
	}
	
	public void clickOnSubscribeSaveButton() {
		click(subscribeSaveButton);
	}
	
	public boolean verifySelectAPlanPage() {
		return isElementDisplayed(selectAPlanPage);
	}
	public boolean verifyPriceGoPremiumPage() {
		return isElementDisplayed(priceGoPremiumPage);
	}
	
	public boolean verifyBuyPop() {
		return isElementDisplayed(buyPopUp);
	}
	
	public void clickOnWithdrawFund() {
		click(withdrawFundBtn);
	}
	
	public void clickOnFirstSearchElement() {
		click(firstSearchElement);
	}
	
	public void clickOnBuyButton() {
		click(buyButton);
	}
	
	public void clickOnPreviewButton() {
		click(previewButton);
	}
	
	
	public void clickOnPlaceOrderButton() {
		click(placeOrderButton);
	}
	
	
	
	public void scrollToPrice() {
		scrollToElement(priceGoPremiumPage);
	}
	
	public void enterSearchValue(String shares) {
		click(searchField);
		waitTime(3000);
		waitForElementToBeClickable(searchFieldBrowsePage, 30);
		sendKeysToWebElement(searchFieldBrowsePage, shares, "Share value");
	}
	
	public void enterSharesValue(String shares) {
		waitForElementToBeClickable(shareInput, 30);
		sendKeysToWebElement(shareInput, shares, "Share value");
	}
	
	public boolean verifyOrderSuccessfullMessage() {
		return isElementDisplayed(successfullMessage);
	}

	public boolean veriyReferralDetailsButtonIsDisplaying() {
		
		return isElementDisplayed(btnViewReferralDetails);
	}

	public void clickOnRewardsViewDetailsButton() {
		click(btnViewReferralDetails);
	}

	public boolean veriyReferralsPageIsDisplaying() {
		return isElementDisplayed(referralsPage);
	}

	public boolean verifyInviteButtonIsDisplaying() {
		return isElementDisplayed(btnInviteReferral);
	}

	public boolean verifyInviteButtonIsEnabled() {
		return isElementClickable(btnInviteReferral, 30);
	}

	public boolean verifyFAQButtonIsDisplaying() {
		return isElementDisplayed(btnFAQReferral);
	}

	public boolean verifyFAQButtonIsEnabled() {
		return isElementClickable(btnFAQReferral,30);
	}
	
	public boolean verifyReferralDisclosureButtonIsDisplaying() {
		return isElementDisplayed(referralDisclosure);
	}

	public boolean verifyReferralDisclosureButtonIsEnabled() {
		return isElementClickable(referralDisclosure,30);
	}

	public void clickOnInviteButton() {
		click(btnInviteReferral);
	}

	public boolean verifyCopyButtonIsDisplaying() {
		try {
			waitForElementToBePresent(btnCopyReferral, 30);
			return isElementDisplayed(btnCopyReferral);
		}catch (Exception e){
			waitForElementToBePresent(btnCopyReferral_2, 30);
			return isElementDisplayed(btnCopyReferral_2);
		}
	}

	public void clickOnSignals(String string) {
		click(driver.findElement(By.xpath("(//*[contains(@label,'"+string+"')])[last()]")));
	}

	
	public boolean isSignalDisplaying(String string) {
		WebElement signal = driver.findElement(By.xpath("(//*[contains(@label,'"+string+"')])[last()]"));
		try {
			scrollRightUntilTextDisplaying(string);
		} catch (Exception e) {
		}
		return isElementDisplayed(signal);
	}
	
	public boolean isSignalClickable(String string) {
		return isElementClickable(driver.findElement(By.xpath("(//*[contains(@label,'"+string+"')])[last()]")),20);
	}
	
	public void clickOnSignalsWithScrolling(String string) {
		try {
			scrollRightUntilTextDisplaying(string);
			waitTime(1000);
		}catch(Exception e) {}
		click(driver.findElement(By.xpath("(//*[contains(@label,'"+string+"')])[last()]")));
	}

	public boolean verifySignalsSortingDropdownIsDisplaying() {
		return isElementDisplayed(signalsSortinDropdown);
	}

	public boolean verifySignalsSectionIsDisplaying() {
		return isElementDisplayed(signalsSection);
	}

	public boolean verifySignalsDetailsPageIsDisplaying() {
		return isElementDisplayed(signalDetailsPage);
	}

	public boolean verifySignalsDescriptionIsDisplaying(String desc) {
		return isElementDisplayed(driver.findElement(By.xpath("(//XCUIElementTypeOther[contains(@name,'"+desc+"')])[last()]")));
	}

	public boolean verifyLearnMoreButtonDisplaying() {
		return isElementDisplayed(learnMoreButton);
	}

	public boolean verifyLearnMoreButtonIsClickable() {
		return isElementClickable(learnMoreButton, 30);
	}

	public String getSelectedValueOfSignalsSortingDropdown() {
		return getElementText(signalsSortinDropdown);
	}

	public void clickOnSortingDropdown() {
		click(signalsSortinDropdown);
	}
	
	public boolean verifySortingFilterIsDisplaying(String filter) {
		return isElementDisplayed(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='"+filter+"']")));
	}
	
	public boolean verifySortingFilterAlphaIsDisplaying() {
		return isElementDisplayed(sortingAlpha);
	}
	

	public void clickOnSignalsInfoIcon() {
		click(signalsInfoIcon);
	}
	
	public boolean isSignalsInfoIconDisplayed() {
		return isElementDisplayed(signalsInfoIcon);
	}

	public boolean isSignalsInfoIconClickable() {
		return isElementClickable(signalsInfoIcon,20);
	}

	public boolean verifySignalsInfoDialogIsDisplaying() {
		return isElementDisplayed(signalsInfoDialog);
	}

	public boolean verifySignalsInfoDialogClosIconIsDisplaying() {
		return isElementDisplayed(closePopupSignalPopup);
	}

	public void clickOnSignalsInfoPopUpCloseIcon() {
		click(closePopupSignalPopup);
	}

	public boolean verifySigalsDescriptionIsDisplaying() {
		return isElementDisplayed(signalsDescription);
	}

	public boolean verifySignalsInfoDialogCloseIconIsClickable() {
		return isElementClickable(closePopupSignalPopup, 20);
	}

	public boolean isSignalDisclosureIsDisplaying() {
		return isElementDisplayed(signalsDisclosure);
	}

	public boolean isSignalDisclosureIsClickable() {
		return isElementClickable(signalsDisclosure, defaultTimeTOBeClickable);
	}

    public boolean verifySignalStockNameAvailable(String stockName) {
		return  isElementPresent(By.xpath("(//XCUIElementTypeOther[contains(@name,'"+stockName+"')])[last()]"),20);
    }

    public boolean verifySignalStockSymbolAvailable(String stockName) {
		return  isElementPresent(By.xpath("(//XCUIElementTypeOther[contains(@name,'"+stockName+"')])[last()]"),20);
    }

	public void clickOnSortingDropdownMenu(String filter) {
		click(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='"+filter+"']")));
	}

	public boolean verifySignalsDisclosureIsDisplaying() {
		return  isElementDisplayed(signalsDisclosure);
	}

	public void clickOnSignalsDisclosure() {
		click(signalsDisclosure);
	}

	public boolean verifySignalsDisclosureDialogIsDisplaying() {
		return isElementDisplayed(signalsDisclosureCloseIcon);
	}

	public boolean verifySigalsDisclosureDescriptionIsDisplaying() {

		return isElementDisplayed(signalsDisclosureDescription);
	}

	public boolean verifySignalsDisclosureDialogClosIconIsDisplaying() {

		return isElementDisplayed(signalsDisclosureCloseIcon);
	}

	public boolean verifySignalsDisclosureDialogCloseIconIsClickable() {
		return isElementClickable(signalsDisclosureCloseIcon,30);
	}

	public void clickOnSignalsDisclosurePopUpCloseIcon() {
		click(signalsDisclosureCloseIcon);
	}

	public boolean verifyOTCSectionIsAvailable() {
		return isElementPresent(otcSection, defaultTimeForVisibility);
	}

	public void scrollDownToOTCSection() {
		//scrollUpToText("OTC");
		IOSElement otc = (IOSElement) driver.findElement(otcSection);
		//scrollDownToIOSElement(otc);
		//mobileScrollScreenIOS(Direction.DOWN, 70);
		for(int i=0;i<6;i++){
			if(otc.isDisplayed()) {
				return;
			}
			swipeUpLess();
			//mobileScrollScreenIOS(Direction.DOWN, 10);
		//	scroll(ScrollDirection.DOWN, 0.5);
			
				}
		waitTime(1000);
	}

	public void scrollDownToIncoeFocusSection() {
		IOSElement otc = (IOSElement) driver.findElement(incomeFocusSection);
		for(int i=0;i<10;i++){
			if(otc.isDisplayed()) {
				break;
			}
			swipeUpLess();
		}
		swipeUpLess();
//		swipeUpLess();
		waitTime(1000);
	}
	
	public void scrollDownToETFSection() {
		IOSElement otc = (IOSElement) driver.findElement(etfproviderSection);
		for(int i=0;i<10;i++){
			if(otc.isDisplayed()) {
				return;
			}
			swipeUpLess();
		}
		swipeUpLess();
//		swipeUpLess();
		waitTime(1000);
	}

	public void scrollDownToEmergingThemesSection() {
		IOSElement otc = (IOSElement) driver.findElement(emergingThemesSection);
		for(int i=0;i<10;i++){
			if(otc.isDisplayed()) {
				break;
			}
			swipeUpLess();
		}
		swipeUpLess();
		swipeUpLess();
		waitTime(1000);
	}

	public boolean verifyOTCShowAllButtonIsDisplaying() {
		return isElementDisplayed(otcShowAllButton);
	}

	public boolean verifyOTCShowAllButtonIsClickable() {
		return isElementClickable(otcShowAllButton, 10);
	}

	public void clickOnExplorePlatformButton() {
		click(explorePlatformButton);
	}

	public void clickOnAcceptAndProceedButton() {
		click(btnAcceptAndProceed);
	}

	public void clickOnOTCShowAllButton() {
		click(otcShowAllButton);
	}

	public boolean verifyOTCHeadingIsDisplaying() {
		return isElementPresent(By.xpath("(//XCUIElementTypeOther[@name='Over-the-Counter (OTC) Securities'])[last()]"),20);
	}

	public ArrayList<Double> getOTCStocksMarketCapital() {
		ArrayList<Double> stringData = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("####0.00");
		for(WebElement capital:otcStocksMarketCapital) {
			String cap = getElementText(capital);
			if(!cap.contains("-")) {
				int multiplier = 1000000000;
				if(cap.contains("B")) {
					multiplier = 1000000000;
				}else {
					multiplier = 1000000;
				}
				cap = cap.replaceAll("$", "").replaceAll("B", "").replaceAll("M", "");
				cap = removeDollarandSpaces(cap);
				Double d = Double.parseDouble(cap);
				d = d*multiplier;
				d = d/1000000000;
				System.out.println("CurrentValue: "+d);
				System.out.println("AfterFormating: "+df.format(d));
				stringData.add(Double.parseDouble(df.format(d)));
			}
		}
		return stringData;
	}

	public void clickOnSortingFilter(String filter) {
		click(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@label='"+filter+"']")));
	}

	public ArrayList<String> getOTCStocksNames() {
		ArrayList<String> names = new ArrayList<>();
		for(WebElement e:otcStocksNames) {
			names.add(getElementText(e));
		}
		return names;
	}

	public ArrayList<String> getOTCStocksSymbols() {
		ArrayList<String> names = new ArrayList<>();
		for(WebElement e:otcStocksSymbols) {
			names.add(getElementText(e));
		}
		return names;
	}

	public ArrayList<Double> getOTCStocksMarketPrice() {
		ArrayList<Double> stringData = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("####0.00");
		for(WebElement capital:otcStocksMarketPrice) {
			String cap = getElementText(capital);
			cap = cap.replaceAll("$", "").replaceAll("B", "").replaceAll("M", "");
			cap = removeDollarandSpaces(cap);
			stringData.add(Double.parseDouble(cap));
		}
		return stringData;
		
	}

	public ArrayList<Double> getOTCStocksDailyChange() {
		ArrayList<Double> stringData = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("####0.00");
		for(WebElement capital:otcStocksDailyChange) {
			String cap = getElementText(capital);
			cap = cap.replaceAll("$", "").replaceAll("%", "").replaceAll("M", "");
			cap = removeDollarandSpaces(cap);
			stringData.add(Double.parseDouble(cap));
		}
		return stringData;
	}

	public boolean verifyTopMoversSectionIsAvailable() {
		return isElementPresent(topMoversSection, defaultTimeForVisibility);
	}

	public boolean verifyTopMoversShowAllButtonIsDisplaying() {
		return isElementDisplayed(topMoversShowAllButton);
	}

	public boolean verifyTopMoversShowAllButtonIsClickable() {
		return isElementClickable(topMoversShowAllButton, defaultTimeForVisibility);
	}

	public void clickOnTopMoversShowAllButton() {
		clickWebElement(topMoversShowAllButton);
	}

	public boolean verifyRecommendedSectionIsAvailable() {
		return isElementPresent(recommendedSection , defaultTimeForVisibility);
	}

	public boolean verifyRecommendedShowAllButtonIsDisplaying() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		IOSElement otc = (IOSElement) driver.findElement(recommendedSection);
		for(int i=0;i<15;i++){
			if(otc.isDisplayed()) {
				break;
			}
			swipeUpLess();
		}
		waitTime(1000);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertiesReader.getPropertyValue("implicit.wait")), TimeUnit.SECONDS);
		return isElementDisplayed(recommendedShowAllButton);
	}

	public boolean verifyRecommendedShowAllButtonIsClickable() {
		return isElementClickable(recommendedShowAllButton, defaultTimeForVisibility);
	}

	public boolean verifyRecommendedDisclosureIsDisplaying() {
		return isElementDisplayed(recommendedDisclosure);
	}

	public void clickOnRecommendedDisclosure() {
		click(recommendedDisclosure);
	}

	public boolean verifyRecommendedDisclosurePopUpIsDisplaying() {
		return isElementDisplayed(recommendedDisclosurePopUp);
	}

	public boolean verifyXIConInRecommendedDisclosurePopUpIsDisplaying() {
		return isElementDisplayed(xIconRecommendedDisclosure);
	}

	public void clickCloseOnRecommendedDisclosure() {
		clickWebElement(xIconRecommendedDisclosure);
	}

	public boolean verifyRecommendedDisclosurePopUpDescriptionIsDisplaying() {
		return isElementDisplayed(recommendedDisclosureDescription);
	}

	public boolean verifyEmergingThemesSectionIsAvailable() {
		return isElementPresent(emergingThemeSection , defaultTimeForVisibility);
	}

	public boolean verifyEmergingThemesDisclosureIsDisplaying() {
		return isElementDisplayed(emergingThemeDisclosure);
	}

	public void clickOnEmergingThemesDisclosure() {
		clickWebElement(emergingThemeDisclosure);
	}

	public boolean verifyEmergingThemesDisclosurePopUpIsDisplaying() {
		return isElementDisplayed(emergingThemeDisclosurePopUp);
	}

	public boolean verifyEmergingThemesDisclosurePopUpDescriptionIsDisplaying() {
		return isElementDisplayed(emergingThemeDisclosureDescription);
	}

	public boolean verifyXIConInEmergingThemesDisclosurePopUpIsDisplaying() {
		return isElementDisplayed(xIconRecommendedDisclosure);
	}

	public void clickCloseOnEmergingThemesDisclosure() {
		clickWebElement(xIconRecommendedDisclosure);
		
	}

	public boolean verifyRecommendedDisclosureIsClickable() {
		return isElementClickable(recommendedDisclosure, defaultTimeForVisibility);
	}

	public void scrollDownToSectorsSection() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		IOSElement otc = (IOSElement) driver.findElement(sectorsSection);
		for(int i=0;i<15;i++){
			if(otc.isDisplayed()) {
				break;
			}
			swipeUpLess();
			
		}
		swipeUpLess();
		waitTime(1000);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertiesReader.getPropertyValue("implicit.wait")), TimeUnit.SECONDS);
	}

	public boolean verifySectorsSectionIsDisplaying() {
		return isElementDisplayed(getDriver().findElement(sectorsSection));
	}

	public boolean verifySectorCategoryIsDisplaying(String sector) {
		return isElementPresent(By.xpath("//XCUIElementTypeStaticText[@name='renderCollectionItemLabel' and @label='"+sector+"']"), defaultTimeForVisibility);
	}

	public boolean verifySectorCategoryIsClickable(String sector) {
		try {
			scrollRightUntilTextDisplaying(sector);
			waitTime(1000);
		}catch(Exception e) {}
		List<MobileElement> elements = driver.findElements(By.xpath("//XCUIElementTypeStaticText[@name='renderCollectionItemLabel' and @label='"+sector+"']"));
		for(MobileElement e:elements) {
			if(e.isDisplayed()) {
				return isElementClickable(e, defaultTimeForVisibility);
			}
		}
		return false;
	}

	public void scrollDownToGeographySection() {
		IOSElement otc = (IOSElement) driver.findElement(emergingThemeSection);
		for(int i=0;i<15;i++){
			if(otc.isDisplayed()) {
				return;
			}
			swipeUpLess();
		}
		waitTime(1000);
	}

	public boolean verifyGeographySectionIsDisplaying() {
		return isElementDisplayed(getDriver().findElement(geographySection));
	}

	public boolean verifyIncomeFocusIsDisplaying() {
		return isElementDisplayed( driver.findElement(incomeFocusSection));
	}
	
	public boolean verifyETFSectionIsDisplaying() {
		return isElementDisplayed( driver.findElement(etfproviderSection));
	}

	public boolean verifyBrowsePageIsDisplaying() {
		return isElementDisplayed(browsePage);
	}
	
	public void swipeRightForETFs(String sector) {
		// ExtentTestManager.getTest().info("Swiping screen");
		WebElement element  = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='renderCollectionItemLabel' and @label='"+sector+"']"));
		int upperY = element.getLocation().getY();
		int lowerY = upperY + element.getSize().getHeight();
		int middleY = (upperY + lowerY) / 2;
		System.out.println("ETF's\nUpper Y: "+upperY+"\nLower Y: "+lowerY+"\nCenter Y: "+middleY);
		swipeRightAtYLocation(middleY);//316
	}

	public void swipeRightForEmergingThemes(String sector) {
		WebElement element  = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='renderCollectionItemLabel' and @label='"+sector+"']"));
		int upperY = element.getLocation().getY();
		int lowerY = upperY + element.getSize().getHeight();
		int middleY = (upperY + lowerY) / 2;
		System.out.println("Emerging Themes\nUpper Y: "+upperY+"\nLower Y: "+lowerY+"\nCenter Y: "+middleY);
		swipeRightAtYLocation(middleY);//316
	}

	public void scrollDownToGeographyection() {
		IOSElement otc = (IOSElement) driver.findElement(geographySection);
		for(int i=0;i<10;i++){
			if(otc.isDisplayed()) {
				break;
			}
			swipeUpLess();
		}
		swipeUpLess();
		waitTime(1000);
	}
}
