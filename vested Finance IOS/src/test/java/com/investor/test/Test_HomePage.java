package com.investor.test;

import java.util.ArrayList;
import java.util.Collections;

import org.testng.annotations.Test;

import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.errorCollectors.ErrorCollector;
import com.investor.pages.HomePage;
import com.investor.pages.KYCUserPurchaseStockPage;
import com.investor.pages.LoginPage;

public class Test_HomePage extends BaseClass{

	@Test
	public void WatchListStocks_SortingParameters() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-425\">QAA-425 : IOS - Verify Watchlist Sorting Parameter<a/>");

		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String shareValue = "1";
		String amount="50";

		int step = 0;
		step = loginPage.loginToApplication(step, email,password,pinCode);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on WatchList Sorting Dropdown.");
		homePage.clickOnWatchListSortingDropdown();
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Select WatchList Sorting paremeter: Symbol");
		homePage.selectWatchListSortingParameter("Symbol");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get Watchlist stocks symbols.");
		ArrayList<String> watchListStockSymbol = homePage.getWatchListStocksSymbol();
		
		ArrayList<String> watchListStockSymbolSorted = new ArrayList<>();
		watchListStockSymbolSorted.addAll(watchListStockSymbol);
		
		Collections.sort(watchListStockSymbolSorted);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify WatchList stocks are sorted by Symbols.");
		ErrorCollector.verifyEquals(watchListStockSymbol, watchListStockSymbolSorted,"Watchlist stocks are not sorted by Symbols.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on WatchList Sorting Dropdown.");
		homePage.clickOnWatchListSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Select WatchList Sorting paremeter: Market Price");
		homePage.selectWatchListSortingParameter("Market Price");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get Watchlist stocks Market Price.");
		ArrayList<Double> watchListStockMarketPrice = homePage.getWatchListStocksMarketPrice();
		
		ArrayList<Double> watchListStockMarketPriceSorted = new ArrayList<>();
		watchListStockMarketPriceSorted.addAll(watchListStockMarketPrice);
		
		Collections.sort(watchListStockMarketPriceSorted,Collections.reverseOrder());
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify WatchList stocks are sorted by Market Price.");
		ErrorCollector.verifyEquals(watchListStockMarketPrice, watchListStockMarketPriceSorted,"Watchlist stocks are not sorted by Market Price.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on WatchList Sorting Dropdown.");
		homePage.clickOnWatchListSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Select WatchList Sorting paremeter: Daily Change (USD)");
		homePage.selectWatchListSortingParameter("Daily Change (USD)");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get Watchlist stocks Daily Change (USD).");
		ArrayList<Double> watchListStockDailyChangeUSD = homePage.getWatchListStocksDailyChangeUSD();
		
		ArrayList<Double> watchListStockDailyChangeUSDSorted = new ArrayList<>();
		watchListStockDailyChangeUSDSorted.addAll(watchListStockDailyChangeUSD);
		
		Collections.sort(watchListStockDailyChangeUSDSorted,Collections.reverseOrder());
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify WatchList stocks are sorted by Daily Change (USD).");
		ErrorCollector.verifyEquals(watchListStockDailyChangeUSD, watchListStockDailyChangeUSDSorted,"Watchlist stocks are not sorted by Daily Change (USD).");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on WatchList Sorting Dropdown.");
		homePage.clickOnWatchListSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Select WatchList Sorting paremeter: Daily Change (%)");
		homePage.selectWatchListSortingParameter("Daily Change (%)");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get Watchlist stocks Daily Change (%).");
		ArrayList<Double> watchListStockDailyChangePercentage = homePage.getWatchListStocksDailyChangePercentage();
		
		ArrayList<Double> watchListStockDailyChangePercentageSorted = new ArrayList<>();
		watchListStockDailyChangePercentageSorted.addAll(watchListStockDailyChangePercentage);
		
		Collections.sort(watchListStockDailyChangePercentageSorted,Collections.reverseOrder());
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify WatchList stocks are sorted by Daily Change (%).");
		ErrorCollector.verifyEquals(watchListStockDailyChangePercentage, watchListStockDailyChangePercentageSorted,"Watchlist stocks are not sorted by Daily Change (%).");
		
		
	}


	@Test
	public void YourPortfolioStocks_SortingParameters() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-426\">QAA-426 : IOS - Verify Your Portfolio Sorting Parameter<a/>");

		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}

		int step = 0;
		step = loginPage.loginToApplication(step, email,password,pinCode);
		waitTime(8000);
		scrollToText("YOUR PORTFOLIO");
		waitTime(3000);
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Your Portfolio Sorting Dropdown.");
		homePage.clickOnYourPortfolioSortingDropdown();
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Select Your Portfolio Sorting paremeter: Symbol");
		homePage.selectWatchListSortingParameter("Symbol");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get Your Portfolio stocks symbols.");
		ArrayList<String> yourPortfolioStockSymbol = homePage.getYourPortfolioStocksSymbol();
		
		ArrayList<String> yourPortfolioStockSymbolSorted = new ArrayList<>();
		yourPortfolioStockSymbolSorted.addAll(yourPortfolioStockSymbol);
		
		Collections.sort(yourPortfolioStockSymbolSorted);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Your Portfolio stocks are sorted by Symbols.");
		ErrorCollector.verifyEquals(yourPortfolioStockSymbol, yourPortfolioStockSymbolSorted,"Your Portfolio stocks are not sorted by Symbols.");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Your Portfolio Sorting Dropdown.");
		homePage.clickOnYourPortfolioSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Select Your Portfolio Sorting paremeter: Market Price");
		homePage.selectWatchListSortingParameter("Market Price");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get Your Portfolio stocks Market Price.");
		ArrayList<String> yourPortfolioStockMarketPrice = homePage.getYourPortfolioStocksMarketPrice();
		
		ArrayList<String> yourPortfolioStockMarketPriceSorted = new ArrayList<>();
		yourPortfolioStockMarketPriceSorted.addAll(yourPortfolioStockMarketPrice);
		
		Collections.sort(yourPortfolioStockMarketPriceSorted,Collections.reverseOrder());
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Your Portfolio stocks are sorted by Market Price.");
		ErrorCollector.verifyEquals(yourPortfolioStockMarketPrice, yourPortfolioStockMarketPriceSorted,"Your Portfolio stocks are not sorted by Market Price.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Your Portfolio Sorting Dropdown.");
		homePage.clickOnYourPortfolioSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Select Your Portfolio Sorting paremeter: Daily Change (USD)");
		homePage.selectWatchListSortingParameter("Daily Change (USD)");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get Your Portfolio stocks Daily Change (USD).");
		ArrayList<Double> yourPortfolioStockDailyChangeUSD = homePage.getYourPortfolioStocksDailyChangeUSD();
		
		ArrayList<Double> yourPortfolioStockDailyChangeUSDSorted = new ArrayList<>();
		yourPortfolioStockDailyChangeUSDSorted.addAll(yourPortfolioStockDailyChangeUSD);
		
		Collections.sort(yourPortfolioStockDailyChangeUSDSorted,Collections.reverseOrder());
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Your Portfolio stocks are sorted by Daily Change (USD).");
		ErrorCollector.verifyEquals(yourPortfolioStockDailyChangeUSD, yourPortfolioStockDailyChangeUSDSorted,"Your Portfolio stocks are not sorted by Daily Change (USD).");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Your Portfolio Sorting Dropdown.");
		homePage.clickOnYourPortfolioSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Select Your Portfolio Sorting paremeter: Daily Change (%)");
		homePage.selectWatchListSortingParameter("Daily Change (%)");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get Your Portfolio stocks Daily Change (%).");
		ArrayList<Double> yourPortfolioStockDailyChangePercentage = homePage.getYourPortfolioStocksDailyChangePercentage();
		
		ArrayList<Double> yourPortfolioStockDailyChangePercentageSorted = new ArrayList<>();
		yourPortfolioStockDailyChangePercentageSorted.addAll(yourPortfolioStockDailyChangePercentage);
		
		Collections.sort(yourPortfolioStockDailyChangePercentageSorted,Collections.reverseOrder());
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Your Portfolio stocks are sorted by Daily Change (%).");
		ErrorCollector.verifyEquals(yourPortfolioStockDailyChangePercentage, yourPortfolioStockDailyChangePercentageSorted,"Your Portfolio stocks are not sorted by Daily Change (%).");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Your Portfolio Sorting Dropdown.");
		homePage.clickOnYourPortfolioSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Select Your Portfolio Sorting paremeter: Current Value");
		homePage.selectWatchListSortingParameter("Current Value");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get Your Portfolio stocks Current Value.");
		ArrayList<Double> yourPortfolioStockCurrentValue = homePage.getYourPortfolioStocksCurrentValue();
		
		ArrayList<Double> yourPortfolioStockCurrentValueSorted = new ArrayList<>();
		yourPortfolioStockCurrentValueSorted.addAll(yourPortfolioStockCurrentValue);
		
		Collections.sort(yourPortfolioStockCurrentValueSorted,Collections.reverseOrder());
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Your Portfolio stocks are sorted by Current Value.");
		ErrorCollector.verifyEquals(yourPortfolioStockCurrentValue, yourPortfolioStockCurrentValueSorted,"Your Portfolio stocks are not sorted by Current Value.");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Your Portfolio Sorting Dropdown.");
		homePage.clickOnYourPortfolioSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Select Your Portfolio Sorting paremeter: Investment Returns (USD)");
		homePage.selectWatchListSortingParameter("Investment Returns (USD)");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get Your Portfolio stocks Investment Returns (USD).");
		ArrayList<Double> yourPortfolioStockInvestmentReturnedUSD = homePage.getYourPortfolioStocksDailyChangeUSD();
		
		ArrayList<Double> yourPortfolioStockInvestmentReturnedUSDSorted = new ArrayList<>();
		yourPortfolioStockInvestmentReturnedUSDSorted.addAll(yourPortfolioStockInvestmentReturnedUSD);
		
		Collections.sort(yourPortfolioStockCurrentValueSorted);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Your Portfolio stocks are sorted by Investment Returns (USD).");
		ErrorCollector.verifyEquals(yourPortfolioStockInvestmentReturnedUSD, yourPortfolioStockInvestmentReturnedUSDSorted,"Your Portfolio stocks are not sorted by Investment Returns (USD).");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Your Portfolio Sorting Dropdown.");
		homePage.clickOnYourPortfolioSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Select Your Portfolio Sorting paremeter: Investment Returns (%)");
		homePage.selectWatchListSortingParameter("Investment Returns (%)");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get Your Portfolio stocks Investment Returns (%).");
		ArrayList<Double> yourPortfolioStockInvestmentReturnedPercentage = homePage.getYourPortfolioStocksDailyChangePercentage();
		
		ArrayList<Double> yourPortfolioStockInvestmentReturnedPercentageSorted = new ArrayList<>();
		yourPortfolioStockInvestmentReturnedPercentageSorted.addAll(yourPortfolioStockInvestmentReturnedPercentage);
		
		Collections.sort(yourPortfolioStockCurrentValueSorted);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Your Portfolio stocks are sorted by Investment Returns (%).");
		ErrorCollector.verifyEquals(yourPortfolioStockInvestmentReturnedPercentage, yourPortfolioStockInvestmentReturnedPercentageSorted,"Your Portfolio stocks are not sorted by Investment Returns (%).");
		
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Your Portfolio Sorting Dropdown.");
		homePage.clickOnYourPortfolioSortingDropdown();
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Select Your Portfolio Sorting paremeter: Volatility");
		homePage.selectWatchListSortingParameter("Volatility");
		
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Get Your Portfolio stocks Volatility.");
		ArrayList<String> yourPortfolioStockVolatility = homePage.getYourPortfolioStocksVolatility();
		
		ArrayList<String> yourPortfolioStockVolatilitySorted = new ArrayList<>();
		yourPortfolioStockVolatilitySorted.addAll(yourPortfolioStockVolatility);
		
		Collections.sort(yourPortfolioStockCurrentValueSorted);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Your Portfolio stocks are sorted by Volatility.");
		ErrorCollector.verifyEquals(yourPortfolioStockVolatility, yourPortfolioStockVolatilitySorted,"Your Portfolio stocks are not sorted by Volatility.");
		
		
	}

}
