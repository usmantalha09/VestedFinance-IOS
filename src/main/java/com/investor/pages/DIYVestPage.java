package com.investor.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.investor.base.BaseClass;
import com.investor.listeners.ExtentListeners;
import com.investor.utilities.Waits;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.offset.PointOption;

public class DIYVestPage extends BaseClass {
	
	@FindBy(xpath ="//XCUIElementTypeTextField")
	public WebElement emailInput;
	
	@FindBy(xpath ="//XCUIElementTypeButton[contains(@name,'DIY Vest, tab,')]")
	WebElement DIYVestButton;
	
	@FindBy(xpath ="//XCUIElementTypeOther[@name='diyCreateVest']")
	WebElement createNewVest_id;
	
	@FindBy(xpath ="(//XCUIElementTypeOther[contains(@label,'diyCreateVest')])[1]")
	WebElement createNewVest;
	
	
	@FindBy(xpath ="//XCUIElementTypeStaticText[@name='Create New Vest - Add Stocks'] | //XCUIElementTypeOther[@name='diyCreateVest']")
	WebElement createNewVesPageTitle;
	
	@FindBy(xpath ="(//XCUIElementTypeStaticText[contains(@label,'$')])[1]/following-sibling::XCUIElementTypeOther")
	WebElement firstStockPlusAddButton;
	
	@FindBy(xpath ="(//XCUIElementTypeStaticText[contains(@label,'$')])[2]/following-sibling::XCUIElementTypeOther")
	WebElement secondStockPlusAddButton;
	
	@FindBy(xpath ="//XCUIElementTypeOther[@name='diyVestStockEtfsProceedBtn']")
	WebElement StockAddedButton;
	
	@FindBy(xpath ="(//XCUIElementTypeTextField)[1]")
	WebElement EnterTheVestNameTxt;
	
	@FindBy(xpath ="//XCUIElementTypeOther[@name='diyVestAddStock0']")
	WebElement firstStockPlusBtn;
	
	@FindBy(xpath ="//XCUIElementTypeOther[@name='diyVestStockPercentageView0']")
	WebElement firstStockTxt;
	
	@FindBy(xpath ="//XCUIElementTypeOther[@name='diyVestStockPercentageView1']")
	WebElement secondStockTxt;
	
	@FindBy(xpath ="//XCUIElementTypeTextField[@name='diyVestStockTotalPercentageInput']")
	WebElement totalStockValue;
	
	@FindBy(xpath ="//XCUIElementTypeOther[@name='createDiyVestBtn']")
	WebElement createVestBtn;
	
	@FindBy(id ="Manage Allocations")
	WebElement createNewVestPageTitle;
	
	@FindBy(xpath ="(//XCUIElementTypeOther[contains(@name,'NEXT')])[1]")
	WebElement nextBtn;
	
	
	@FindBy(xpath ="(//XCUIElementTypeOther[@name=\"Next\"])[2]")
	WebElement nextBtnSellVest;
	
	@FindBy(xpath ="(//XCUIElementTypeOther[contains(@name,'GOT IT')])[1]")
	WebElement gotItBtn;
	
	@FindBy(xpath ="(//XCUIElementTypeOther[contains(@label,'Next')])[1]")
	WebElement popUpNextBtn;
	
	@FindBy(xpath ="(//XCUIElementTypeOther[@name='vestBuyPreviewOrderBtn'])[1]")
	WebElement PriviewOrderBtn;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='vestDetailsBuyBtn']")
	WebElement vestDetailsBuyButton;
	
	@FindBy(id ="vestPlaceOrderBtn")
	WebElement vestPlaceOrderBtn;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='vestNameLabel']")
	WebElement vestNameLabel;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='totalVestPerchaseAmountValue']")
	WebElement totalAmountLabel;

	@FindBy(xpath ="(//XCUIElementTypeTextField)[1]")
	WebElement investmentAmountTxt;
	
	@FindBy(id ="Order Preview")
	WebElement orderPreviewTitle;
	
	@FindBy(xpath ="(//XCUIElementTypeOther[contains(@label,'Close modal Sorry, you’ve already created a vest with the name ')])[1]")
	WebElement alreadyCreatedVestErrorMessagePopup;
	
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='diyVestSearchStockEtfsInput'])[last()]")
	WebElement diyVestSearchInput;

	@FindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Search Or Browse Ideas\")]/following-sibling::XCUIElementTypeOther[contains(@name, \"Search stocks & ETFs\")]")
	WebElement diyVestSearchInputValue;

	@FindBy(xpath = "(//XCUIElementTypeOther[@name='diyVestStocksList'])[1]")
	WebElement diyVestSearchedStock;
	
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='diyVestName'])[1]")
	WebElement diyVestListFirstVestName;

	@FindBy(xpath = "//XCUIElementTypeOther[@name=\"manageDiyVestVestDetailClicked\"]")
	private List<WebElement> diyVestsList;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='divVestDropDownDeleteValue']")
	private WebElement btnDeleteMenu;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Yes, Delete']")
	private WebElement yesDeleteButton;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='diyVestSortingDropdown']")
	private WebElement sortingDropDown;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='diyVestName']")
	List<WebElement> vestsNames;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='percent']")
	private List<WebElement> vestsPercentages;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name=\"vestDetailsSellBtn\"]")
	WebElement diyVestSellBtn;
	
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Sell All\"]//preceding::XCUIElementTypeOther)[last()]")
	WebElement diyVestSelectAll;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Current Investment\"]//following-sibling::XCUIElementTypeStaticText")
	WebElement currentInvestmentAmount;
	
	
	
	@FindBy(xpath = "//XCUIElementTypeTextField")
	WebElement diyVestSellAmount;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='vestSellPreviewOrderBtn']")
	WebElement diyVestSellPreviewOrderBtn;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='vestPlaceOrderBtn']")
	WebElement placeSellOrderBtn;
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name=\"Request failed with status code 422\"])[2]")
	WebElement error422;
	
	
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='OK']")
	WebElement okButton;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='vestPlaceOrderBtn']")
	WebElement placeBuyOrderBtn;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='goToHomeScreen'] | //XCUIElementTypeStaticText[contains(@value,'Your order has been placed')]")
	WebElement successMsg;
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='manageDiyVestVestDetailClicked'])[1]")
	WebElement diyVest;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='diyVestEditAllocationBtn']")
	private WebElement btnEditAllocation;

	@FindBy(xpath ="//XCUIElementTypeOther[@name='searchEnableButton']")
	private WebElement searchAllocationButton;

	@FindBy(xpath="//XCUIElementTypeOther[@name='DIYVestScreenSearchInputClear']/..")
	private WebElement searchManageAllocation;
	
	@FindBy(xpath="//XCUIElementTypeOther[@name='diyVestStocksList']")
	List<WebElement> stocksSearchResults;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='DIYVestScreenSearchInputClear'] | //XCUIElementTypeOther[@name='diyVestSearchStockEtfsInputCleartInput']")
	private WebElement clearSearchInput;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='Yes']")
	private WebElement btnYesPopUp;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='PENDING VEST ORDERS info_outline']/following-sibling::XCUIElementTypeOther")
	private List<WebElement> pendingVestsOrder;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='diyVestNameInputIdError']")
	private WebElement vestNameRequiredErrorMessage;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
	private WebElement clickOk;

	@FindBy(xpath = "//XCUIElementTypeOther[@name=\"backButton\"]")
	private WebElement goBackButton;
	
	public DIYVestPage() {
		PageFactory.initElements(driver, this);
	}
	
    public void enterEmailAddress(String email) {
    	Waits.wait6s();
    	sendKeysToWebElement(emailInput, email);
	}
    
    public void clickOnDIYVestButton() {
		waitForElementToBeClickable(DIYVestButton, 30);
		clickWebElement(DIYVestButton);
	}
    
    public void clickOnCreateNewVestButton() {
    	Waits.wait6s();
    	clickWebElement(createNewVest_id);
//    	try {
//			waitForElementToBeClickable(createNewVest, 30);
//			clickWebElement(createNewVest);
//		} catch (Exception e) {
//			// TODO: handle exception
//			clickWebElement(createNewVest_id);	
//		}
    	
		
	}
    
    public boolean verifyCreateNewVesPageTitleIsDisplaying() {
		waitForElementToBePresent(createNewVesPageTitle, 30);
		return isElementDisplayed(createNewVesPageTitle);
	}
    
    public boolean error422isDisplayed() {
    	try {
    		waitForElementToBePresent(error422, 10);
    		return isElementDisplayed(error422);
			
		} catch (Exception e) {
			return false;
		}
		
	}
    public void clickonOkButton() {
    	waitForElementToBePresent(clickOk, 10);
    	clickWebElement(clickOk);
    }
    public void clickonGoBackButton() {
    	waitForElementToBePresent(goBackButton, 10);
    	clickWebElement(goBackButton);
    }
    
    public boolean verifyalreadyCreatedVestErrorMessagePopupIsDisplaying() {
		waitForElementToBePresent(alreadyCreatedVestErrorMessagePopup, 30);
		return isElementDisplayed(alreadyCreatedVestErrorMessagePopup);
	}
    
    
    public void clickOnFirstStockPlusAddButton() {
		waitForElementToBeClickable(firstStockPlusAddButton, 30);
		clickWebElement(firstStockPlusAddButton);
	}
    
    public void clickOnSecondStockPlusAddButton() {
		waitForElementToBeClickable(secondStockPlusAddButton, 30);
		clickWebElement(secondStockPlusAddButton);
	}
    
    public void clickOnStockAddedButton() {
		waitForElementToBeClickable(StockAddedButton, 30);
		clickWebElement(StockAddedButton);
	}
    
    public boolean verifyCreateNewVestPageTitleIsDisplaying() {
		waitForElementToBePresent(createNewVestPageTitle, 30);
		return isElementDisplayed(createNewVestPageTitle);
	}
    
    public void clickOnFirstStockPlusButton() {
		try{
			waitForElementToBeClickable(firstStockPlusBtn, 30);
			clickWebElement(firstStockPlusBtn);
		}catch (Exception e){
			new TouchAction(driver).tap(PointOption.point(299, 313)).perform();
		}

	}
    
    public void enterTheVestName(String vestName) {
    	Waits.wait6s();
    	sendKeysToWebElement(EnterTheVestNameTxt, vestName);
    	System.out.println("vest name : "+vestName);
    }
    
    public String getSumOfFirstAndSecondStockValue() {
    	Waits.wait6s();
    	String firstStockVal ="";
    	String secondStockVal ="";
    	Integer value = 0;
    	firstStockVal = getElementAttribute(firstStockTxt,"label").replace("%", "").trim();
    	System.out.println("first stock value: "+ firstStockVal);
    	
    	secondStockVal = getElementAttribute(secondStockTxt,"label").replace("%", "").trim();
    	System.out.println("second stock value: "+secondStockVal);
    	value = Integer.parseInt(firstStockVal)+ Integer.parseInt(secondStockVal); 
    	return value.toString(); 
    }
    
    public String getstockTotalValue() {
    	Waits.wait6s();
    	String totalStockVal ="";
    	totalStockVal = getElementAttribute(totalStockValue,"value").replace("%", "").trim();
    	System.out.println("total Stock Value: "+ totalStockValue);
    	return totalStockVal ; 
    }
    
    public void clickOnCreateVestButton() {
		waitForElementToBeClickable(createVestBtn, 30);
		clickWebElement(createVestBtn);
	}
    
    public void clickOnPopupNextButton() {
    	try {
    	Waits.wait6s();
    	waitForElementToBeClickable(nextBtn, 30);
		clickWebElement(nextBtn);
		Waits.wait6s();
		Waits.wait6s();
		
		System.out.println("one next");
		new TouchAction(driver).tap(PointOption.point(77, 395)).perform();
		new TouchAction(driver).tap(PointOption.point(77, 395)).perform();
		
//		clickWebElement(nextBtn);
		Waits.wait6s();
		
		Waits.wait6s();
		Waits.wait6s();
		System.out.println("one next");

//		clickWebElement(gotItBtn);
		//ExtentListeners.attachScreenShot("Home Page Screenshot");
		new TouchAction(driver).tap(PointOption.point(94, 422)).perform();
		new TouchAction(driver).tap(PointOption.point(76, 418)).perform();
		Waits.wait6s();
		//ExtentListeners.attachScreenShot("Home Page Screenshot");
		
		System.out.println("got it");
		
    	}catch(Exception e) {
    		
    	}
	}
    
    public void clickOnVestPopupNextButton() {
    	try {
    		Waits.wait6s();
        	waitForElementToBeClickable(nextBtnSellVest, 30);
    		clickWebElement(nextBtnSellVest);
    		Waits.wait6s();
    		Waits.wait6s();
    		
    		System.out.println("one next");
    		new TouchAction(driver).tap(PointOption.point(100, 680)).perform();
    		Waits.wait6s();
    		System.out.println("one next");

    		new TouchAction(driver).tap(PointOption.point(100, 480)).perform();
    		Waits.wait6s();
    		System.out.println("one next");
    		
    		
    		new TouchAction(driver).tap(PointOption.point(114, 723)).perform();
    		Waits.wait6s();
    		System.out.println("one next");
    		
    		new TouchAction(driver).tap(PointOption.point(100, 360)).perform();
    		Waits.wait6s();
    		System.out.println("one next");
    		
    		new TouchAction(driver).tap(PointOption.point(90, 370)).perform();
    		Waits.wait6s();
    		System.out.println("one next");
    		
    		
    		new TouchAction(driver).tap(PointOption.point(100, 240)).perform();
    		Waits.wait6s();
    		
    		
    	
    		//ExtentListeners.attachScreenShot("Home Page Screenshot");
    		
    		System.out.println("got it");
    	}catch(Exception e) {}
	}
    
    
    public void clickOnOkButtonInDialog() {
    	new TouchAction(driver).tap(PointOption.point(337, 487)).perform();
	}
    
    public void clickOnBuyButton() {
//    	Waits.wait6s();
//    	new TouchAction(driver).tap(PointOption.point(199, 789)).perform();
//		Waits.wait3s();
    	click(vestDetailsBuyButton);
	}
    
    public void clickOnCreateVestPagePopupNextButton() {
    	try {
    		Waits.wait6s();
    		clickWebElement(popUpNextBtn);
    		Waits.wait3s();
    	}catch(Exception e) {}
	}
    
    public void clickOnPreviewOrderButton() {
    	Waits.wait6s();
    	clickWebElement( PriviewOrderBtn);
    	Waits.wait2s();
//    	new TouchAction(driver).tap(PointOption.point(200, 796)).perform();
//		Waits.wait3s();
	}
    
    public void investmentAmount(String vestName) {
    	Waits.wait6s();
    	sendKeysToWebElement(investmentAmountTxt, vestName);
    	System.out.println("investmentAmountTxt : "+vestName);
    }
    
    public String getTotalAmountValue() {
    	printString(driver.getPageSource());
    	Waits.wait6s();
    	String totalLabel ="";
    	totalLabel = getElementText(totalAmountLabel).replace("$", "").replace("00","").replace(".","").trim();
    	System.out.println("total Label: "+ totalLabel);
    	return totalLabel ; 
    }
    
    public String getVestNameLabel() {
    	Waits.wait6s();
    	String VestNameLabel = "";
    	VestNameLabel = getElementText(vestNameLabel);
    	System.out.println("Vest Name Label: "+ VestNameLabel);
    	return VestNameLabel; 
    }
    
    public boolean verifyOrderPreviewTitleIsDisplaying() {
		waitForElementToBePresent(orderPreviewTitle, 30);
		return isElementDisplayed(orderPreviewTitle);
	}

	public void searchAndSelectStock(String stockName) {
		Waits.wait2s();
		click(diyVestSearchInput);
		Waits.wait4s();
		try{
			typeKeysViaKeyboard(stockName);
		}catch (Exception e){
			sendKeysToWebElement(diyVestSearchInputValue, stockName);
		}

		Waits.wait3s();
		click(diyVestSearchedStock);
	}
	
	public void searchDIYVestStock(String stockName) {
		Waits.wait2s();
		click(diyVestSearchInput);
		Waits.wait4s();
		//sendKeysToWebElement(diyVestSearchInput, stockName);
		typeKeysViaKeyboard(stockName);
	}

	public void tryClickOnErrorDialogOkButton() {
		Waits.wait6s();
    	new TouchAction(driver).tap(PointOption.point(335, 486)).perform();
		Waits.wait3s();
	}

	public String getFirstDIYVestName() {
		return getElementText(diyVestListFirstVestName);
	}

	public List<WebElement> getAllDIYVests() {
		return diyVestsList;
	}

	public boolean isDIYVestNotInvested(WebElement vest) {
		return vest.findElements(By.xpath("//XCUIElementTypeStaticText[@name='diyVestNotInvested']")).size()>0;
	}

	public void clickOnVestDotMenu(WebElement element) {
		scrollDownToIOSElement((IOSElement) element);
		waitTime(1000);
		clickWebElement(element.findElement(By.xpath("//XCUIElementTypeOther[@name='diyVestMoreDotMenu']")));
	}

	public void clickOnDeleteMenu() {
		clickWebElement(btnDeleteMenu);
	}

	public void clickOnYesDeleteButtonInDialog() {
		clickWebElement(yesDeleteButton);
	}

	public String getDIYVestName(WebElement webElement) {
		return getElementText(webElement.findElement(By.xpath("//XCUIElementTypeStaticText[@name='diyVestName']")));
	}

	public void clickOnSortingDropDown() {
		clickWebElement(sortingDropDown);
	}

	public void selectSortingDropDown(String menuItem) {
		clickWebElement(getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name='diyVestSortingDropdownMenuItemLabel' and @label='"+menuItem+"']")));
	}

	public ArrayList<String> getDIYVestNames() {
		ArrayList<String> nameStrings= new ArrayList<>();
		for(WebElement element:vestsNames) {
			nameStrings.add(getElementText(element).toLowerCase());
		}
		return nameStrings;
	}

	public ArrayList<Double> getDIYVestPercentage() {
		ArrayList<Double> nameStrings= new ArrayList<>();
		for(WebElement element:vestsPercentages) {
			nameStrings.add(Double.parseDouble(removeCharsFromString(getElementText(element).toLowerCase(),new String[] {"%",","})));
		}
		return nameStrings;
	}
	
	  public void clickOnSellBtn() {
			waitForElementToBeClickable(diyVestSellBtn, 30);
			clickWebElement(diyVestSellBtn);
		}
	  
	  public void clickOnSelectAll() {
			waitForElementToBeClickable(diyVestSelectAll, 30);
			clickWebElement(diyVestSelectAll);
		}
	  
	  public float getDIYVestCurrentInvestmentAmount() {
			String value =  getElementText(currentInvestmentAmount).replace("$", "").trim();
			return Integer.parseInt(value);  
		}
	  
	  public void enterTheSellAmount(String amount) {
	    	Waits.wait6s();
	    	diyVestSellAmount.clear();
	    	sendKeysToWebElement(diyVestSellAmount, amount);
	    }
	  
	  public float getDIYVestSellAmount() {
		  String value =  diyVestSellAmount.getAttribute("value").replace("$", "").trim();// getElementText(currentInvestmentAmount); 
		  return Float.parseFloat(value);  
	  }
	  
	  public void clickOnSellPreviewOrderButton() {
			waitForElementToBeClickable(diyVestSellPreviewOrderBtn, 30);
			clickWebElement(diyVestSellPreviewOrderBtn);
		}
	  
	  
	  public void clickOnPlaceSellOrderButton() {
			waitForElementToBeClickable(placeSellOrderBtn, 30);
			clickWebElement(placeSellOrderBtn);
		}
	  
	  public Boolean isOkButtonDisplaying() {
		  return isElementDisplayed(okButton);
	  }
	  public void clickOnPlaceBuyOrderButton() {
			waitForElementToBeClickable(placeBuyOrderBtn, 30);
			clickWebElement(placeBuyOrderBtn);
		}
	  
	  public void clickOnDIYVest() {
			clickWebElement(diyVest);
		}
	  
	  public Boolean isSuccessMessageDisplaying() {
		  return isElementDisplayed(successMsg);
	  }

	public void clickOnEditAllocationsButton() {
		try {
			scrollDownToText("Edit allocations & rebalance vest");//Transaction History
			waitTime(2000);
		} catch (Exception e) {
		}
		click(btnEditAllocation);
	}

	public void clickOnSearchAllocationsButton() {
		click(searchAllocationButton);
	}

	public void searchForTheStock(String string) {
		sendKeysToElementWithoutReturn(searchManageAllocation, string, string);
	}

	public int getStocksSearchResultsSize() {
		return stocksSearchResults.size();
	}

	public void clearSearchInput() {
		click(clearSearchInput);
	}

	public void clickOnYesButtoninPopUp() {
		click(btnYesPopUp);
	}

	public List<WebElement> getAllPendingVestsOrder() {
		
		return pendingVestsOrder;
	}

	public void scrollToPendingVests() {
		try {
			scrollDownToIOSElement(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='PENDING VEST ORDERS']")));
		} catch (Exception e) {
		}
	}

	public boolean verifyVestNameIsRequiredErrorMessageIsDisplaying() {
		return isElementDisplayed(vestNameRequiredErrorMessage);
	}
	  
    
}