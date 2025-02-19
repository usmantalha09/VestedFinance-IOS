package com.investor.pages;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.investor.base.BaseClass;
import com.investor.listeners.ExtentListeners;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.offset.PointOption;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//XCUIElementTypeOther[@name='watchListFilterIcon']")
	WebElement watchListSortingDropdown;

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='watchListItemLabel'])")
	List<WebElement> watchListStocksSymbol;
	
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='watchlistItemLatestPriceValue'])")
	List<WebElement> watchListStocksMarketPrice;

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='watchListItemDailyChangeValue'])")	
	List<WebElement> watchListStocksDailyChangeUSD;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='yourPortfolioStockFilterIcon']")
	private WebElement yourPortfolioSortingDropdown;

	@FindBy(xpath = "//XCUIElementTypeOther[@name='holdingItemLabelContainer']")
	List<WebElement> yourPortfolioStocksSymbols;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='holdingItemMarketPriceValue']")
	List<WebElement> yourPortfolioStocksMarketPrice;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='holdingItemDailyChangeValue']")
	List<WebElement> yourPortfolioStocksDailyChange;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='CURRENT_VALUE']")
	List<WebElement>  yourPortfolioStocksCurrentValue;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='holdingItemVolatilityValue']")
	List<WebElement>  yourPortfolioStocksVolatility;

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnWatchListSortingDropdown() {
		if(isElementPresent(By.xpath("//XCUIElementTypeOther[@name='watchListFilterIcon']"), defaultTimeForVisibility)) {
			for(int i=0;i<10;i++) {
				if(watchListSortingDropdown.isDisplayed()) {
					break;
				}else {
					swipeUpLess();
				}
			}
		}
		waitTime(1000);
		clickWebElement(watchListSortingDropdown);
	}

	public void selectWatchListSortingParameter(String parameter) {
		clickWebElement(getDriver().findElement(By.xpath("(//XCUIElementTypeOther[contains(@name,'"+parameter+"')])[last()]")));
	}

	public ArrayList<String> getWatchListStocksSymbol() {
		ArrayList<String> symbols = new ArrayList<>();
		for(WebElement element:watchListStocksSymbol) {
			symbols.add(getElementText(element));
		}
		return symbols;
	}

	public ArrayList<Double> getWatchListStocksMarketPrice() {
		ArrayList<Double> symbols = new ArrayList<>();
		for(WebElement element:watchListStocksMarketPrice) {
			symbols.add(Double.parseDouble(removeDollarandSpaces(getElementText(element))));
		}
		return symbols;
	}

	public ArrayList<Double> getWatchListStocksDailyChangeUSD() {
		ArrayList<Double> symbols = new ArrayList<>();
		for(WebElement element:watchListStocksDailyChangeUSD) {
			String changeString = getElementText(element);
			changeString = changeString.substring(0, changeString.indexOf("("));
			symbols.add(Double.parseDouble(removeDollarandSpaces(changeString)));
		}
		return symbols;
	}

	public ArrayList<Double> getWatchListStocksDailyChangePercentage() {
		ArrayList<Double> symbols = new ArrayList<>();
		for(WebElement element:watchListStocksDailyChangeUSD) {
			String value = getElementText(element);
			value = value.substring(value.indexOf("(")+1,value.length()-1);
			symbols.add(Double.parseDouble(removeCharsFromString(value, new String[]{"%"})));
		}
		return symbols;
	}

	public void clickOnYourPortfolioSortingDropdown() {
		clickWebElement(yourPortfolioSortingDropdown);
	}

	public ArrayList<String> getYourPortfolioStocksSymbol() {
		ArrayList<String> symbols = new ArrayList<>();
		for(WebElement element:yourPortfolioStocksSymbols) {
			String value = getElementText(element);
			symbols.add(value.substring(0,value.indexOf(" ")));
		}
		return symbols;
	}

	public ArrayList<String> getYourPortfolioStocksMarketPrice() {
		ArrayList<String> symbols = new ArrayList<>();
		for(WebElement element:yourPortfolioStocksMarketPrice) {
			symbols.add(getElementText(element));
		}
		return symbols;
	}

	public ArrayList<Double> getYourPortfolioStocksDailyChangeUSD() {
		ArrayList<Double> symbols = new ArrayList<>();
		for(WebElement element:yourPortfolioStocksDailyChange) {
			String value = getElementText(element);
			value = value.substring(0,value.indexOf('(')-1).trim();
			value = removeDollarandSpaces(value);
			symbols.add(Double.parseDouble(value.trim()));
		}
		return symbols;
	}

	public ArrayList<Double> getYourPortfolioStocksDailyChangePercentage() {
		ArrayList<Double> symbols = new ArrayList<>();
		for(WebElement element:yourPortfolioStocksDailyChange) {
			String value = getElementText(element);
			value = value.substring(value.indexOf("(")+1,value.length()-1);
			String temp = removeCharsFromString(value, new String[]{"%"});
			String removePlus = temp.replaceAll("\\+", "");
			String removeComa = removePlus.replace(",", "");
			symbols.add(Double.parseDouble(removeComa.trim()));
		}
		return symbols;
	}

	public ArrayList<Double> getYourPortfolioStocksCurrentValue() {
		ArrayList<Double> symbols = new ArrayList<>();
		for(WebElement element:yourPortfolioStocksCurrentValue) {
			symbols.add(Double.parseDouble(removeDollarandSpaces(getElementText(element))));
		}
		return symbols;
	}

	public ArrayList<String> getYourPortfolioStocksVolatility() {
		ArrayList<String> symbols = new ArrayList<>();
		for(WebElement element:yourPortfolioStocksVolatility) {
			symbols.add(getElementText(element));
		}
		return symbols;
	}
}
