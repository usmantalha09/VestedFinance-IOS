package com.investor.test;

import com.investor.base.BaseClass;
import com.investor.base.BaseClass.Direction;
import com.investor.base.PropertiesReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.investor.errorCollectors.ErrorCollector;
import com.investor.listeners.ExtentListeners;
import com.investor.pages.ExplorePage;
import com.investor.pages.FundTransferPage;
import com.investor.pages.LoginPage;
import com.investor.pages.SignupPage;

public class Test_Signals extends BaseClass {

	@Test
	public void VerifySignalsSection() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-791\">QAA-791 : [iOS] - While user logged in with existing user, Verify the 'Signals' section on dashboard screen<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}
		String[] signalNames = { "Value Creators", "Income Generators", "Coffee Can Investing", "Bullish RSI",
				"Rising Stars", "Buffet-Graham Formula", "Golden Crossover" };

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify “i” icon is available next to “Signals” heading.");
		ErrorCollector.verifyTrue(browsePage.isSignalsInfoIconDisplayed(),
				"Verified “i” icon is available next to “Signals” heading.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify “i” icon is Clickable.");
		ErrorCollector.verifyTrue(browsePage.isSignalsInfoIconClickable(), "Verified “i” icon is Clickable.");

		for (String signal : signalNames) {
			ErrorCollector
					.extentLogInfo("Step " + (++step) + " : Verify <b>“" + signal + "”</b> signal is Displaying.");
			ErrorCollector.verifyTrue(browsePage.isSignalDisplaying(signal),
					"Verified <b>“" + signal + "”</b> signal is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify <b>“" + signal + "”</b> signal is Clickable.");
			ErrorCollector.verifyTrue(browsePage.isSignalClickable(signal),
					"Verified <b>“" + signal + "”</b> signal is Clickable.");
		}

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Signals Disclosure' is displaying.");
		ErrorCollector.verifyTrue(browsePage.isSignalDisclosureIsDisplaying(),
				"Verified 'Signals Disclosure' is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Signals Disclosure' is clickable.");
		ErrorCollector.verifyTrue(browsePage.isSignalDisclosureIsClickable(),
				"Verified 'Signals Disclosure' is clickable");

	}

	@Test
	public void ValueCreater_SignalsDetails() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-803\">QAA-803 : [iOS] - While user logged in with existing user, Verify the 'Value Creators' signal detail screen<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}
		String signalName = "Value Creators";

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignals(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in Signals sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by signal dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal description is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDescriptionIsDisplaying(
				"This Signal lists stocks with strong free cash flow indicators and revenue over the last 12 months"),
				"Verify Signal description is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonDisplaying(),

				"Verify Signal button is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is cilckable.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonIsClickable(), "Verify Signal button is clickable.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
				"Verified 'Alphabetical' filter is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
				"Verified 'Symbol' filter is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
				"Verified 'Market Price' filter is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
				"Verified 'Daily Change' filter is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
				"Verified 'Market Cap' filter is displaying.");

	}

	@Test
	public void CoffeeCanInvesting_SignalsDetails() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-809\">QAA-809 : [iOS] - While user logged in with existing user, Verify the 'Coffee Can Investing' signal detail screen</a>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}
		String signalName = "Coffee Can Investing";

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignals(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in Signals sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by signal dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal description is displaying.");
		ErrorCollector.verifyTrue(
				browsePage.verifySignalsDescriptionIsDisplaying("The Coffee Can Investing approach refers to "),
				"Verify Signal description is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonDisplaying(),

				"Verify Signal button is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is cilckable.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonIsClickable(), "Verify Signal button is clickable.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");

		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}

	}

	@Test
	public void CoffeeCanInvesting_SignalsDetails_NonPremiumUsers() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-872\">QAA-872 : [iOS] - While user logged in with non premium user, Verify the 'Coffee Can Investing' signal detail screen</a>");
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][24].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_NonPremiumEmailId");
			password = PropertiesReader.getPropertyValue(env + "_NonPremiumPassword");
			pinCode = PropertiesReader.getPropertyValue(env + "_Pin");
		}

		String signalName = "Coffee Can Investing";

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignals(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in Signals sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by signal dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal description is displaying.");
		ErrorCollector.verifyTrue(
				browsePage.verifySignalsDescriptionIsDisplaying("The Coffee Can Investing approach refers to "),
				"Verify Signal description is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonDisplaying(),

				"Verify Signal button is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is cilckable.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonIsClickable(), "Verify Signal button is clickable.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

//		ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
//		ErrorCollector.extentLogInfo(
//				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");

		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}

	}

	@Test
	public void IncomeGenerators_SignalsDetails() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-806\">QAA-806 : [iOS] - While user logged in with existing user, Verify the 'Income Generators' signal detail screen</a>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}
		String signalName = "Income Generators";

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignals(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in Signals sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by signal dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify Signal description 'This Signal lists companies with high dividend yields and strong free cash flow to support steady dividend payments' is displaying.");
		ErrorCollector.verifyTrue(
				browsePage
						.verifySignalsDescriptionIsDisplaying("This Signal lists companies with high dividend yields"),
				"Verify Signal description is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonDisplaying(),

				"Verify Signal button is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is cilckable.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonIsClickable(), "Verify Signal button is clickable.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");

		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}

	}

	@Test
	public void BullishRSI_SignalsDetails() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-812\">QAA-812 : [iOS] - While user logged in with existing user, Verify the 'Bullish RSI' signal detail screen</a>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}
		String signalName = "Bullish RSI";

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignalsWithScrolling(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in Signals sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by signal dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify Signal description 'This Signal is based on the relative strength index (RSI) technical indicator. It employs filters that screen for stocks where the 14-day RSI crosses over 30, indicating a bullish pattern for the stock price' is displaying.");
		ErrorCollector.verifyTrue(
				browsePage.verifySignalsDescriptionIsDisplaying("This Signal is based on the relative strength index"),
				"Verify Signal description is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonDisplaying(),

				"Verify Signal button is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is cilckable.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonIsClickable(), "Verify Signal button is clickable.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
				"Verified 'Alphabetical' filter is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
				"Verified 'Symbol' filter is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
				"Verfied 'Market Price' filter is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
				"Verified 'Daily Change' filter is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
				"Verified 'Market Cap' filter is displaying");

	}

	@Test
	public void RisingStars_SignalsDetails() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-815\">QAA-815 : [iOS] - While user logged in with existing user, Verify the 'Rising Stars' signal detail screen</a>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}
		String signalName = "Rising Stars";

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignalsWithScrolling(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in Signals sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by signal dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify Signal description 'This Signal provides you with a list of Small and Mid Cap companies that have good fundamentals and growth' is displaying.");
		ErrorCollector.verifyTrue(
				browsePage.verifySignalsDescriptionIsDisplaying(
						"This Signal provides you with a list of Small and Mid Cap companies"),
				"Verify Signal description is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonDisplaying(),

				"Verify Signal button is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is cilckable.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonIsClickable(), "Verify Signal button is clickable.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == false) {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");

		} else {

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");
		}
	}

	@Test
	public void BuffetGrahamFormula_SignalsDetails() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-818\">QAA-818 : [iOS] - While user logged in with existing user, Verify the 'Buffet-Graham Formula' signal detail screen</a>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}
		String signalName = "Buffet-Graham Formula";

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignalsWithScrolling(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in Signals sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by signal dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify Signal description 'The Buffet-Graham Formula is used to identify fundamentally strong companies that have good earning potential and are available at a good buying price' is displaying.");
		ErrorCollector.verifyTrue(
				browsePage.verifySignalsDescriptionIsDisplaying(
						"The Buffet-Graham Formula is used to identify fundamentally strong companies"),
				"Verify Signal description is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonDisplaying(),

				"Verify Signal button is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is cilckable.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonIsClickable(), "Verify Signal button is clickable.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");

		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}

	}

	@Test
	public void GoldenCrossover_SignalsDetails() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-821\">QAA-821 : [iOS] - While user logged in with existing user, Verify the 'Golden Crossover' signal detail screen</a>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}
		String signalName = "Golden Crossover";

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignalsWithScrolling(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in Signals sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by signal dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify Signal description 'A Golden Crossover is a bullish technical indicator. This Signal screens for companies whose stock price has formed a golden cross pattern' is displaying.");
		ErrorCollector.verifyTrue(
				browsePage.verifySignalsDescriptionIsDisplaying("A Golden Crossover is a bullish technical indicator."),
				"Verify Signal description is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonDisplaying(),

				"Verify Signal button is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is cilckable.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonIsClickable(), "Verify Signal button is clickable.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");

		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}

	}

	@Test
	public void SignalPopUp_ExplorePage() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-862\">QAA-862 : [iOS] - While logged in with existing user, Verify the 'Signals' popup on dashboard screen</a>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signals info icon.");
		browsePage.clickOnSignalsInfoIcon();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals info pop is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsInfoDialogIsDisplaying(),
				"Verified Signals info pop up is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'X' is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsInfoDialogClosIconIsDisplaying(),
				"Verified 'X' is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'X' is clickable.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsInfoDialogCloseIconIsClickable(),
				"Verified 'X' is clickable.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify description 'Signals are lists of stocks pre-screened with fundamental strategies or technical indicators. The list of stocks for each Signal is generated every day using the latest data available on' is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySigalsDescriptionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signals dialog close icon.");
		browsePage.clickOnSignalsInfoPopUpCloseIcon();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals info pop is closed.");
		ErrorCollector.verifyFalse(browsePage.verifySignalsInfoDialogIsDisplaying(),
				"Verified Signals info pop up is closed.");

	}

	@Test
	public void IncomeGenerator_SignalsDetails_NonPremiumUsers() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-869\">QAA-869 : [iOS] - While user logged in with non premium user, Verify the 'Income Generators' signal detail screen</a>");
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][24].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_NonPremiumEmailId");
			password = PropertiesReader.getPropertyValue(env + "_NonPremiumPassword");
			pinCode = PropertiesReader.getPropertyValue(env + "_Pin");
		}
		String signalName = "Income Generators";

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignals(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in Signals sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by signal dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal description is displaying.");
		ErrorCollector.verifyTrue(
				browsePage.verifySignalsDescriptionIsDisplaying(
						"This Signal lists companies with high dividend yields and strong"),
				"Verify Signal description is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonDisplaying(),

				"Verify Signal button is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is cilckable.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonIsClickable(), "Verify Signal button is clickable.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");

		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}

	}

	@Test
	public void IncomeGenerators_SignalsNameAndSymbolsOnDetailsScreen() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-833\">QAA-833 : [iOS] - Verify the 'Names' and 'Symbols' of available stock in 'Income Generators' signal detail screen</a>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}
		String signalName = "Income Generators";
		HashMap<String, String> signalsDetails = new HashMap<>();
//		signalsDetails.put("AFC Gamma Inc", "AFCG");
//		signalsDetails.put("Annaly Capital Management Inc", "NLY");
//		signalsDetails.put("Arch Coal Inc", "ARCH");
//		signalsDetails.put("Armada Hoffler Properties Inc", "AHH");
//		signalsDetails.put("Brookline Bancorp Inc", "BRKL");
//		signalsDetails.put("Equity Residential", "EQR");
//		signalsDetails.put("F.N.B. Corporation", "FNB");
//		signalsDetails.put("Financial Institutions Inc", "FISI");
//		signalsDetails.put("Fulton Financial Corp", "FULT");
//		signalsDetails.put("HBT Financial Inc", "HBT");
//		signalsDetails.put("Independent Bank Corp", "INDB");
//		signalsDetails.put("Kearny Financial Corp", "KRNY");
//		signalsDetails.put("Kenon Holdings Ltd", "KEN");
//		signalsDetails.put("LOANDEPOT INC -CLASS A", "LDI");
//		signalsDetails.put("Office Properties Income Trust", "OPI");
//		signalsDetails.put("Regency Centers Corporation", "REG");
//		signalsDetails.put("Rocket Companies Inc", "RKT");
//		signalsDetails.put("Star Bulk Carriers Corp", "SBLK");
//		signalsDetails.put("State Street Corp", "STT");
//		signalsDetails.put("Virtu Financial, Inc. - Class A Shares", "VIRT");

		signalsDetails.put("BLACKSTONE SECURED LENDING F", "BXSL");
		signalsDetails.put("Columbia Banking System Inc", "COLB");
		signalsDetails.put("Equity Commonwealth", "EQC");
		signalsDetails.put("FIVE STAR BANCORP", "FSBC");
		signalsDetails.put("FRANKLIN BSP REALTY TRUST INC", "FBRT");
		signalsDetails.put("GERMAN AMERICAN BANCORP", "GABC");
		signalsDetails.put("Gaming & Leisure Properties", "GLPI");
		signalsDetails.put("HARBORONE BANCORP INC", "HONE");
		signalsDetails.put("Hannon Armstrong Sustnbl Infrstr Cap Inc", "HASI");
		signalsDetails.put("Heritage Commerce Corp", "HOMB");
//		signalsDetails.put("Invitation Homes Inc.", "INVH");
		signalsDetails.put("ONE Gas Inc", "OGS");
		signalsDetails.put("Prosperity Bancshares Inc", "PB");
		signalsDetails.put("Sierra Bancorp", "BSRR");
		signalsDetails.put("Skyworks Solutions Inc", "SWKS");
		signalsDetails.put("South State Corp", "SSB");
		signalsDetails.put("Synovus Financial Corp.", "SNV");
		signalsDetails.put("TCP Capital Corp", "TCPC");
		signalsDetails.put("Westamerica Bancorp", "WABC");


		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignals(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verified Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Alphabetical' filter.");
			browsePage.clickOnSortingDropdownMenu("Alphabetical");

			for (int i = 0; i < signalsDetails.size(); i++) {

				if (i % 8 == 0) {
					mobileScrollScreenIOS(Direction.DOWN, 100);
				}

				String stockName = signalsDetails.keySet().toArray()[i].toString();
				String stockSymbol = signalsDetails.get(stockName);
				ErrorCollector
						.extentLogInfo("Step " + (++step) + " : Verify stock name: '" + stockName + "' is available.");
				ErrorCollector.verifyTrue(browsePage.verifySignalStockNameAvailable(stockName),
						"Verified stock '" + stockName + "' is available.");

				ErrorCollector.extentLogInfo(
						"Step " + (++step) + " : Verify stock symbol: '" + stockSymbol + "' is available.");
				ErrorCollector.verifyTrue(browsePage.verifySignalStockSymbolAvailable(stockSymbol),
						"Verified stock '" + stockSymbol + "' is available.");
			}
		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}
	}

	@Test
	public void ValueCreators_SignalsNameAndSymbolsOnDetailsScreen() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-824\">QAA-824 : [iOS] - Verify the 'Names' and 'Symbols' of available stock in 'Value Creators' signal detail screen</a>");
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}
		String signalName = "Value Creators";
		HashMap<String, String> signalsDetails = new HashMap<>();
//		signalsDetails.put("AstraZeneca PLC ADR", "AZN");
		signalsDetails.put("AT&T Inc", "T");
		signalsDetails.put("Alibaba Group Holding Ltd", "BABA");
		signalsDetails.put("Alphabet Inc Class A", "GOOGL");
		signalsDetails.put("Amgen Inc", "AMGN");
		signalsDetails.put("Applied Materials Inc", "AMAT");
		signalsDetails.put("Automatic Data Processing Inc", "ADP");
//		signalsDetails.put("Bank of Nova Scotia", "BNS");
//		signalsDetails.put("Booking Holdings Inc", "BKNG");
//		signalsDetails.put("Builders FirstSource, Inc.", "BLDR");
//		signalsDetails.put("BCE Inc", "BCE");
//		signalsDetails.put("BioNTech SE", "BNTX");
		signalsDetails.put("COREBRIDGE FINANCIAL, INC. (SAFG RETIREMENT SERVICES)", "CRBG");
		signalsDetails.put("Cisco Systems Inc", "CSCO");
//		signalsDetails.put("Canadian Natural Resources Ltd", "CNQ");
//		signalsDetails.put("Charles Schwab Corp", "SCHW");
//		signalsDetails.put("Cheniere Energy Inc", "LNG");
//		signalsDetails.put("Cheniere Energy Partners LP", "CQP");
//		signalsDetails.put("Chevron Corp", "CVX");
//		signalsDetails.put("ConocoPhillips", "COP");
//		signalsDetails.put("EOG Resources Inc", "EOG");
//		signalsDetails.put("Exxon Mobil Corp", "XOM");
		signalsDetails.put("Enbridge Inc", "ENB");
//		signalsDetails.put("Expeditors International of Washington Inc", "EXPD");
//		signalsDetails.put("Fiserv Inc", "FISV");
		signalsDetails.put("Gilead Sciences Inc", "GILD");
//		signalsDetails.put("Hartford Financial Services Group", "HIG");
		signalsDetails.put("Illinois Tool Works Inc", "ITW");
		signalsDetails.put("International Business Machines", "IBM");
//		signalsDetails.put("JPMorgan Chase & Co", "JPM");
		signalsDetails.put("Lam Research Corp", "LRCX");
//		signalsDetails.put("Lincoln National Corporation", "LNC");
//		signalsDetails.put("Mastercard Inc", "MA");
		signalsDetails.put("McDonald’s Corporation", "MCD");
		signalsDetails.put("Meta Platforms Inc", "META");
//		signalsDetails.put("Nucor Corp", "NUE");
		signalsDetails.put("NVIDIA Corporation", "NVDA");
//		signalsDetails.put("Novartis AG ADR", "NVS");
		signalsDetails.put("Oracle Corporation", "ORCL");
//		signalsDetails.put("Principal Financial Group Inc", "PFG");
		signalsDetails.put("Procter & Gamble Company", "PG");
		signalsDetails.put("Reinsurance Group of America", "RGA");
//		signalsDetails.put("Royal Bank of Canada", "RY");
//		signalsDetails.put("Salesforce.com Inc", "CRM");
//		signalsDetails.put("Takeda Pharmaceutical Company Limited", "TAK");
		signalsDetails.put("U.S. Bancorp", "USB");
//		signalsDetails.put("Wells Fargo & Company", "WFC");
//		signalsDetails.put("PNC Financial Services Group Inc", "PNC");
//		signalsDetails.put("Pioneer Natural Resources Co", "PXD");
//		signalsDetails.put("Visa Inc. Class A", "V");

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignals(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verified Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
				"Verified 'Alphabetical' filter is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Alphabetical' filter.");
		browsePage.clickOnSortingDropdownMenu("Alphabetical");

		for (int i = 0; i < signalsDetails.size(); i++) {

			if (i % 8 == 0) {
				mobileScrollScreenIOS(Direction.DOWN, 100);
			}

			String stockName = signalsDetails.keySet().toArray()[i].toString();
			String stockSymbol = signalsDetails.get(stockName);
			ErrorCollector
					.extentLogInfo("Step " + (++step) + " : Verify stock name: '" + stockName + "' is available.");
			ErrorCollector.verifyTrue(browsePage.verifySignalStockNameAvailable(stockName),
					"Verified stock '" + stockName + "' is available.");

			ErrorCollector
					.extentLogInfo("Step " + (++step) + " : Verify stock symbol: '" + stockSymbol + "' is available.");
			ErrorCollector.verifyTrue(browsePage.verifySignalStockSymbolAvailable(stockSymbol),
					"Verified stock '" + stockSymbol + "' is available.");
		}
	}

	@Test
	public void SignalsDisclosure_ExplorePage() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-865\">QAA-865 : [iOS] - While logged in with existing user, Verify the 'Signals Disclosure' popup on dashboard screen</a>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals Disclosure is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDisclosureIsDisplaying(),
				"Verify Signals Disclosure is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signals Disclosure icon.");
		browsePage.clickOnSignalsDisclosure();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals disclosure pop is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDisclosureDialogIsDisplaying(),
				"Verified Signals disclosure pop up is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'X' is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDisclosureDialogClosIconIsDisplaying(),
				"Verified 'X' is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'X' is clickable.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDisclosureDialogCloseIconIsClickable(),
				"Verified 'X' is clickable.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify disclosure description is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySigalsDisclosureDescriptionIsDisplaying(),
				"Verify disclosure description is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signals dialog close icon.");
		browsePage.clickOnSignalsDisclosurePopUpCloseIcon();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals disclosure pop up is closed.");
		waitTime(1000);
		ErrorCollector.verifyFalse(browsePage.verifySignalsDisclosureDialogIsDisplaying(),
				"Verified Signals disclosure pop up is closed.");

	}

	@Test
	public void BullishRSI_SignalsNameAndSymbolsOnDetailsScreen() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-839\">QAA-839 : [iOS] - Verify the 'Names' and 'Symbols' of available stock in 'Bullish RSI' signal detail screen</a>");
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}
		String signalName = "Bullish RSI";
		HashMap<String, String> signalsDetails = new HashMap<>();
		signalsDetails.put("ARCUTIS BIOTHERAPEUTICS INC", "ARQT");
		signalsDetails.put("AT&T Inc", "T");
		signalsDetails.put("Bandwidth Inc", "BAND");
		signalsDetails.put("Bowlero Corp", "BOWL");
		signalsDetails.put("First Horizon National Corporation", "FHN");
		signalsDetails.put("GDS Holdings Ltd", "GDS");
		signalsDetails.put("Incyte Corporation", "INCY");
		signalsDetails.put("KYNDRYL HOLDINGS INC", "KD");
		signalsDetails.put("Levi Strauss & Co Class A", "LEVI");
		signalsDetails.put("NanoString Technologies Inc", "NSTG");
		signalsDetails.put("Peabody Energy Corporation", "BTU");
		signalsDetails.put("Pfizer Inc", "PFE");
		signalsDetails.put("Sleep Number Corporation", "SNBR");
		signalsDetails.put("SunPower Corporation", "SPWR");
		signalsDetails.put("Tandem Diabetes Care, Inc.", "TNDM");
		signalsDetails.put("Telephone & Data Systems Inc.", "TDS");
		signalsDetails.put("Trupanion, Inc.", "TRUP");
		signalsDetails.put("UGI Corporation", "UGI");
		signalsDetails.put("UP Fintech Holding Limited", "TIGR");

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignalsWithScrolling(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verified Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
				"Verified 'Alphabetical' filter is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Alphabetical' filter.");
		browsePage.clickOnSortingDropdownMenu("Alphabetical");

		for (int i = 0; i < signalsDetails.size(); i++) {
			if (i % 8 == 0) {
				mobileScrollScreenIOS(Direction.DOWN, 100);
			}

			String stockName = signalsDetails.keySet().toArray()[i].toString();
			String stockSymbol = signalsDetails.get(stockName);

			if (browsePage.verifySignalStockNameAvailable(stockName) == true) {
				ErrorCollector
						.extentLogInfo("Step " + (++step) + " : Verify stock name: '" + stockName + "' is available.");
				ErrorCollector.verifyTrue(browsePage.verifySignalStockNameAvailable(stockName),
						"Verified stock '" + stockName + "' is available.");

				ErrorCollector.extentLogInfo(
						"Step " + (++step) + " : Verify stock symbol: '" + stockSymbol + "' is available.");
				ErrorCollector.verifyTrue(browsePage.verifySignalStockSymbolAvailable(stockSymbol),
						"Verified stock '" + stockSymbol + "' is available.");

			}

		}
	}

	@Test
	public void GoldenCrossover_SignalsDetails_NonPremiumUsers() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-881\">QAA-881 : [iOS] - While user logged in with non premium user, Verify the 'Golden Crossover' signal detail screen</a>");
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][24].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_NonPremiumEmailId");
			password = PropertiesReader.getPropertyValue(env + "_NonPremiumPassword");
			pinCode = PropertiesReader.getPropertyValue(env + "_Pin");
		}
		String signalName = "Golden Crossover";

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignalsWithScrolling(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in Signals sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by signal dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal description is displaying.");
		ErrorCollector.verifyTrue(
				browsePage.verifySignalsDescriptionIsDisplaying("A Golden Crossover is a bullish technical indicator."),
				"Verify Signal description is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonDisplaying(),

				"Verify Signal button is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is cilckable.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonIsClickable(), "Verify Signal button is clickable.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");

		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}

	}

	@Test
	public void RisingStars_SignalsDetails_NonPremiumUsers() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-875\">QAA-875 : [iOS] - While user logged in with non premium user, Verify the 'Rising Stars' signal detail screen</a>");
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][24].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_NonPremiumEmailId");
			password = PropertiesReader.getPropertyValue(env + "_NonPremiumPassword");
			pinCode = PropertiesReader.getPropertyValue(env + "_Pin");
		}
		String signalName = "Rising Stars";

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignalsWithScrolling(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in Signals sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by signal dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal description is displaying.");
		ErrorCollector.verifyTrue(
				browsePage.verifySignalsDescriptionIsDisplaying(
						"This Signal provides you with a list of Small and Mid Cap companies"),
				"Verify Signal description is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonDisplaying(),

				"Verify Signal button is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is cilckable.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonIsClickable(), "Verify Signal button is clickable.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");
		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}

	}

	@Test
	public void BuffetGrahamFormula_SignalsDetails_NonPremiumUsers() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-878\">QAA-878 : [iOS] - While user logged in with non premium user, Verify the 'Buffet-Graham Formula' signal detail screen</a>");
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][24].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_NonPremiumEmailId");
			password = PropertiesReader.getPropertyValue(env + "_NonPremiumPassword");
			pinCode = PropertiesReader.getPropertyValue(env + "_Pin");
		}
		String signalName = "Buffet-Graham Formula";

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignalsWithScrolling(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in Signals sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by signal dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal description is displaying.");
		ErrorCollector.verifyTrue(
				browsePage.verifySignalsDescriptionIsDisplaying(
						"The Buffet-Graham Formula is used to identify fundamentally strong companies"),
				"Verify Signal description is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonDisplaying(),

				"Verify Signal button is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'LEARN MORE' button is cilckable.");
		ErrorCollector.verifyTrue(browsePage.verifyLearnMoreButtonIsClickable(), "Verify Signal button is clickable.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

//		ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
//		ErrorCollector.extentLogInfo(
//				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");

		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}

	}

	@Test
	public void NewUser_IncomeGeneratorSignalsDetailsSortingFilters() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-921\">QAA-921 : [iOS] - While user logged in with new user, Verify the sorting filters of 'Income Generators' signal detail screen<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		String signalName = "Income Generators";

		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = PropertiesReader.getPropertyValue(env + "_NewUserEmailId");
//		String email = "vested.automation+w02@gmail.com";
		String password = PropertiesReader.getPropertyValue(env + "_NewUserPassword");
		String pinCode = dataArr[0][3].toString();

		int step = 0;
		ErrorCollector.extentLogInfo("Step " + (++step) + " : <b>Login With New User Credentials</b>.");
		step = loginPage.loginToApplication(step, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();
//		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on GREATE! button in modal.");
//		signup.clickOnGreateButtonInModal();
//		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Done' button in modal.");
//		signup.clickOnDoneButtonInModal();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(), "Verified Browse Page is displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignals(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by sorting dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Alphabetical' filter.");
			browsePage.clickOnSortingFilter("Alphabetical");
			ArrayList<String> names = browsePage.getOTCStocksNames();

			ArrayList<String> sortedNames = new ArrayList<>();
			sortedNames.addAll(names);
			Collections.sort(sortedNames);
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Alphabetical' filter.");
			ErrorCollector.verifyEquals(names, sortedNames,
					"'" + signalName + "' signal are not sorted by names Alphabetically.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Symbol' filter.");
			browsePage.clickOnSortingFilter("Symbol");
			ArrayList<String> symbols = browsePage.getOTCStocksSymbols();

			ArrayList<String> sortedSymbols = new ArrayList<>();
			sortedSymbols.addAll(symbols);
			Collections.sort(sortedSymbols);
			ErrorCollector.extentLogInfo(
					"Step " + (++step) + " : Verify '" + signalName + "' signal stocks are sorted by 'Symbol' filter.");
			ErrorCollector.verifyEquals(symbols, sortedSymbols,
					"'" + signalName + "' signal stocks are not sorted by names Symbol.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Pricep' filter.");
			browsePage.clickOnSortingFilter("Market Price");
			ArrayList<Double> MarketPrice = browsePage.getOTCStocksMarketPrice();

			ArrayList<Double> sortedMarketPrices = new ArrayList<>();
			sortedMarketPrices.addAll(MarketPrice);
			Collections.sort(sortedMarketPrices, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Price' filter.");
			ErrorCollector.verifyEquals(MarketPrice, sortedMarketPrices,
					"'" + signalName + "' signal are not sorted by market price.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Daily Change' filter.");
			browsePage.clickOnSortingFilter("Daily Change");
			ArrayList<Double> DailyChange = browsePage.getOTCStocksDailyChange();

			ArrayList<Double> sortedDailyChange = new ArrayList<>();
			sortedDailyChange.addAll(DailyChange);
			Collections.sort(sortedDailyChange, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Daily Change' filter.");
			ErrorCollector.verifyEquals(DailyChange, sortedDailyChange,
					"'" + signalName + "' signal are not sorted by Daily Change.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Cap' filter.");
			browsePage.clickOnSortingFilter("Market Cap");
			ArrayList<Double> marketCapitals = browsePage.getOTCStocksMarketCapital();

			ArrayList<Double> sortedMarketCapitals = new ArrayList<>();
			sortedMarketCapitals.addAll(marketCapitals);
			Collections.sort(sortedMarketCapitals, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Cap' filter.");
			ErrorCollector.verifyEquals(marketCapitals, sortedMarketCapitals,
					"'" + signalName + "' signal are not sorted by market capital.");
		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}
	}

	@Test
	public void NewUser_ValueCreatorsSignalsDetailsSortingFilters() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-919\">QAA-919 : [iOS] - While user logged in with new user, Verify the sorting filters of 'Value Creators' signal detail screen<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		String signalName = "Value Creators";

		Object[][] dataArr = getData(testDataFile, testDataSheet);
	//	String email = "vested.automation+w02@gmail.com";
		String email = PropertiesReader.getPropertyValue(env + "_NewUserEmailId");
		String password = PropertiesReader.getPropertyValue(env + "_NewUserPassword");
		String pinCode = dataArr[0][3].toString();

		int step = 0;
		ErrorCollector.extentLogInfo("Step " + (++step) + " : <b>Login With New User Credentials</b>.");
		step = loginPage.loginToApplication(step, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on GREATE! button in modal.");
//		signup.clickOnGreateButtonInModal();
//		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Done' button in modal.");
//		signup.clickOnDoneButtonInModal();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(), "Verified Browse Page is displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignals(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by sorting dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Alphabetical' filter.");
			browsePage.clickOnSortingFilter("Alphabetical");
			ArrayList<String> names = browsePage.getOTCStocksNames();

			ArrayList<String> sortedNames = new ArrayList<>();
			sortedNames.addAll(names);
			Collections.sort(sortedNames);
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Alphabetical' filter.");
			ErrorCollector.verifyEquals(names, sortedNames,
					"'" + signalName + "' signal are not sorted by names Alphabetically.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Symbol' filter.");
			browsePage.clickOnSortingFilter("Symbol");
			ArrayList<String> symbols = browsePage.getOTCStocksSymbols();

			ArrayList<String> sortedSymbols = new ArrayList<>();
			sortedSymbols.addAll(symbols);
			Collections.sort(sortedSymbols);
			ErrorCollector.extentLogInfo(
					"Step " + (++step) + " : Verify '" + signalName + "' signal stocks are sorted by 'Symbol' filter.");
			ErrorCollector.verifyEquals(symbols, sortedSymbols,
					"'" + signalName + "' signal stocks are not sorted by names Symbol.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Pricep' filter.");
			browsePage.clickOnSortingFilter("Market Price");
			ArrayList<Double> MarketPrice = browsePage.getOTCStocksMarketPrice();

			ArrayList<Double> sortedMarketPrices = new ArrayList<>();
			sortedMarketPrices.addAll(MarketPrice);
			Collections.sort(sortedMarketPrices, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Price' filter.");
			ErrorCollector.verifyEquals(MarketPrice, sortedMarketPrices,
					"'" + signalName + "' signal are not sorted by market price.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Daily Change' filter.");
			browsePage.clickOnSortingFilter("Daily Change");
			ArrayList<Double> DailyChange = browsePage.getOTCStocksDailyChange();

			ArrayList<Double> sortedDailyChange = new ArrayList<>();
			sortedDailyChange.addAll(DailyChange);
			Collections.sort(sortedDailyChange, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Daily Change' filter.");
			ErrorCollector.verifyEquals(DailyChange, sortedDailyChange,
					"'" + signalName + "' signal are not sorted by Daily Change.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Cap' filter.");
			browsePage.clickOnSortingFilter("Market Cap");
			ArrayList<Double> marketCapitals = browsePage.getOTCStocksMarketCapital();

			ArrayList<Double> sortedMarketCapitals = new ArrayList<>();
			sortedMarketCapitals.addAll(marketCapitals);
			Collections.sort(sortedMarketCapitals, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Cap' filter.");
			ErrorCollector.verifyEquals(marketCapitals, sortedMarketCapitals,
					"'" + signalName + "' signal are not sorted by market capital.");
		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}
	}

	@Test
	public void NewUser_CoffeeCanInvestingSignalsDetailsSortingFilters() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-923\">QAA-923 : [iOS] - While user logged in with new user, Verify the sorting filters of 'Coffee Can Investing' signal detail screen<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		String signalName = "Coffee Can Investing";

		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = PropertiesReader.getPropertyValue(env + "_NewUserEmailId");
		String password = PropertiesReader.getPropertyValue(env + "_NewUserPassword");
		String pinCode = dataArr[0][3].toString();

		int step = 0;
		ErrorCollector.extentLogInfo("Step " + (++step) + " : <b>Login With New User Credentials</b>.");
		step = loginPage.loginToApplication(step, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on GREATE! button in modal.");
//		signup.clickOnGreateButtonInModal();
//		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Done' button in modal.");
//		signup.clickOnDoneButtonInModal();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(), "Verified Browse Page is displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignals(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by sorting dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Alphabetical' filter.");
			browsePage.clickOnSortingFilter("Alphabetical");
			ArrayList<String> names = browsePage.getOTCStocksNames();

			ArrayList<String> sortedNames = new ArrayList<>();
			sortedNames.addAll(names);
			Collections.sort(sortedNames);
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Alphabetical' filter.");
			ErrorCollector.verifyEquals(names, sortedNames,
					"'" + signalName + "' signal are not sorted by names Alphabetically.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Symbol' filter.");
			browsePage.clickOnSortingFilter("Symbol");
			ArrayList<String> symbols = browsePage.getOTCStocksSymbols();

			ArrayList<String> sortedSymbols = new ArrayList<>();
			sortedSymbols.addAll(symbols);
			Collections.sort(sortedSymbols);
			ErrorCollector.extentLogInfo(
					"Step " + (++step) + " : Verify '" + signalName + "' signal stocks are sorted by 'Symbol' filter.");
			ErrorCollector.verifyEquals(symbols, sortedSymbols,
					"'" + signalName + "' signal stocks are not sorted by names Symbol.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Pricep' filter.");
			browsePage.clickOnSortingFilter("Market Price");
			ArrayList<Double> MarketPrice = browsePage.getOTCStocksMarketPrice();

			ArrayList<Double> sortedMarketPrices = new ArrayList<>();
			sortedMarketPrices.addAll(MarketPrice);
			Collections.sort(sortedMarketPrices, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Price' filter.");
			ErrorCollector.verifyEquals(MarketPrice, sortedMarketPrices,
					"'" + signalName + "' signal are not sorted by market price.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Daily Change' filter.");
			browsePage.clickOnSortingFilter("Daily Change");
			ArrayList<Double> DailyChange = browsePage.getOTCStocksDailyChange();

			ArrayList<Double> sortedDailyChange = new ArrayList<>();
			sortedDailyChange.addAll(DailyChange);
			Collections.sort(sortedDailyChange, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Daily Change' filter.");
			ErrorCollector.verifyEquals(DailyChange, sortedDailyChange,
					"'" + signalName + "' signal are not sorted by Daily Change.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Cap' filter.");
			browsePage.clickOnSortingFilter("Market Cap");
			ArrayList<Double> marketCapitals = browsePage.getOTCStocksMarketCapital();

			ArrayList<Double> sortedMarketCapitals = new ArrayList<>();
			sortedMarketCapitals.addAll(marketCapitals);
			Collections.sort(sortedMarketCapitals, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Cap' filter.");
			ErrorCollector.verifyEquals(marketCapitals, sortedMarketCapitals,
					"'" + signalName + "' signal are not sorted by market capital.");
		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}
	}

	@Test
	public void NewUser_BullishRSISignalsDetailsSortingFilters() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-925\">QAA-925 : [iOS] - While user logged in with new user, Verify the sorting filters of 'Bullish RSI' signal detail screen<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		String signalName = "Bullish RSI";

		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = PropertiesReader.getPropertyValue(env + "_NewUserEmailId");
		String password = PropertiesReader.getPropertyValue(env + "_NewUserPassword");
		String pinCode = dataArr[0][3].toString();

		int step = 0;
		ErrorCollector.extentLogInfo("Step " + (++step) + " : <b>Login With New User Credentials</b>.");
		step = loginPage.loginToApplication(step, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on GREATE! button in modal.");
//		signup.clickOnGreateButtonInModal();
//		
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Done' button in modal.");
//		signup.clickOnDoneButtonInModal();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(), "Verified Browse Page is displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignalsWithScrolling(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by sorting dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Alphabetical' filter.");
			browsePage.clickOnSortingFilter("Alphabetical");
			ArrayList<String> names = browsePage.getOTCStocksNames();

			ArrayList<String> sortedNames = new ArrayList<>();
			sortedNames.addAll(names);
			Collections.sort(sortedNames);
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Alphabetical' filter.");
			ErrorCollector.verifyEquals(names, sortedNames,
					"'" + signalName + "' signal are not sorted by names Alphabetically.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Symbol' filter.");
			browsePage.clickOnSortingFilter("Symbol");
			ArrayList<String> symbols = browsePage.getOTCStocksSymbols();

			ArrayList<String> sortedSymbols = new ArrayList<>();
			sortedSymbols.addAll(symbols);
			Collections.sort(sortedSymbols);
			ErrorCollector.extentLogInfo(
					"Step " + (++step) + " : Verify '" + signalName + "' signal stocks are sorted by 'Symbol' filter.");
			ErrorCollector.verifyEquals(symbols, sortedSymbols,
					"'" + signalName + "' signal stocks are not sorted by names Symbol.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Pricep' filter.");
			browsePage.clickOnSortingFilter("Market Price");
			ArrayList<Double> MarketPrice = browsePage.getOTCStocksMarketPrice();

			ArrayList<Double> sortedMarketPrices = new ArrayList<>();
			sortedMarketPrices.addAll(MarketPrice);
			Collections.sort(sortedMarketPrices, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Price' filter.");
			ErrorCollector.verifyEquals(MarketPrice, sortedMarketPrices,
					"'" + signalName + "' signal are not sorted by market price.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Daily Change' filter.");
			browsePage.clickOnSortingFilter("Daily Change");
			ArrayList<Double> DailyChange = browsePage.getOTCStocksDailyChange();

			ArrayList<Double> sortedDailyChange = new ArrayList<>();
			sortedDailyChange.addAll(DailyChange);
			Collections.sort(sortedDailyChange, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Daily Change' filter.");
			ErrorCollector.verifyEquals(DailyChange, sortedDailyChange,
					"'" + signalName + "' signal are not sorted by Daily Change.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Cap' filter.");
			browsePage.clickOnSortingFilter("Market Cap");
			ArrayList<Double> marketCapitals = browsePage.getOTCStocksMarketCapital();

			ArrayList<Double> sortedMarketCapitals = new ArrayList<>();
			sortedMarketCapitals.addAll(marketCapitals);
			Collections.sort(sortedMarketCapitals, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Cap' filter.");
			ErrorCollector.verifyEquals(marketCapitals, sortedMarketCapitals,
					"'" + signalName + "' signal are not sorted by market capital.");

		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}
	}

	@Test
	public void NewUser_RisingStarsSignalsDetailsSortingFilters() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-927\">QAA-927 : [iOS] - While user logged in with new user, Verify the sorting filters of 'Rising Stars' signal detail screen<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		String signalName = "Rising Stars";
//
		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = PropertiesReader.getPropertyValue(env + "_NewUserEmailId");
//		String email = "vested.automation+w02@gmail.com";
		String password = PropertiesReader.getPropertyValue(env + "_NewUserPassword");
		String pinCode = dataArr[0][3].toString();

		int step = 0;
		ErrorCollector.extentLogInfo("Step " + (++step) + " : <b>Login With New User Credentials</b>.");
		step = loginPage.loginToApplication(step, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on GREATE! button in modal.");
//		signup.clickOnGreateButtonInModal();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Done' button in modal.");
//		signup.clickOnDoneButtonInModal();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(), "Verified Browse Page is displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignalsWithScrolling(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by sorting dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Alphabetical' filter.");
			browsePage.clickOnSortingFilter("Alphabetical");
			ArrayList<String> names = browsePage.getOTCStocksNames();

			ArrayList<String> sortedNames = new ArrayList<>();
			sortedNames.addAll(names);
			Collections.sort(sortedNames);
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Alphabetical' filter.");
			ErrorCollector.verifyEquals(names, sortedNames,
					"'" + signalName + "' signal are not sorted by names Alphabetically.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Symbol' filter.");
			browsePage.clickOnSortingFilter("Symbol");
			ArrayList<String> symbols = browsePage.getOTCStocksSymbols();

			ArrayList<String> sortedSymbols = new ArrayList<>();
			sortedSymbols.addAll(symbols);
			Collections.sort(sortedSymbols);
			ErrorCollector.extentLogInfo(
					"Step " + (++step) + " : Verify '" + signalName + "' signal stocks are sorted by 'Symbol' filter.");
			ErrorCollector.verifyEquals(symbols, sortedSymbols,
					"'" + signalName + "' signal stocks are not sorted by names Symbol.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Pricep' filter.");
			browsePage.clickOnSortingFilter("Market Price");
			ArrayList<Double> MarketPrice = browsePage.getOTCStocksMarketPrice();

			ArrayList<Double> sortedMarketPrices = new ArrayList<>();
			sortedMarketPrices.addAll(MarketPrice);
			Collections.sort(sortedMarketPrices, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Price' filter.");
			ErrorCollector.verifyEquals(MarketPrice, sortedMarketPrices,
					"'" + signalName + "' signal are not sorted by market price.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Daily Change' filter.");
			browsePage.clickOnSortingFilter("Daily Change");
			ArrayList<Double> DailyChange = browsePage.getOTCStocksDailyChange();

			ArrayList<Double> sortedDailyChange = new ArrayList<>();
			sortedDailyChange.addAll(DailyChange);
			Collections.sort(sortedDailyChange, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Daily Change' filter.");
			ErrorCollector.verifyEquals(DailyChange, sortedDailyChange,
					"'" + signalName + "' signal are not sorted by Daily Change.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Cap' filter.");
			browsePage.clickOnSortingFilter("Market Cap");
			ArrayList<Double> marketCapitals = browsePage.getOTCStocksMarketCapital();

			ArrayList<Double> sortedMarketCapitals = new ArrayList<>();
			sortedMarketCapitals.addAll(marketCapitals);
			Collections.sort(sortedMarketCapitals, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Cap' filter.");
			ErrorCollector.verifyEquals(marketCapitals, sortedMarketCapitals,
					"'" + signalName + "' signal are not sorted by market capital.");
		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}
	}

	@Test
	public void NewUser_BuffetGrahamFormulaSignalsDetailsSortingFilters() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-929\">QAA-929 : [iOS] - While user logged in with new user, Verify the sorting filters of 'Buffet-Graham Formula' signal detail screen<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(testDataFile, testDataSheet);
//		String email = dataArr[0][1].toString();
//		String password = dataArr[0][2].toString();
//		String pinCode = dataArr[0][3].toString();
		String signalName = "Buffet-Graham Formula";

		String email = "ramya.reddy+io4@vestedfinance.co";
		String password = "iTestUser1!";
		String pinCode = "111111";

		int step = 0;

		ErrorCollector.extentLogInfo("Login to application.");
		step = loginPage.loginToApplication(step, email, password, pinCode);

//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signup button displaying.");
//		ErrorCollector.verifyTrue(signup.verifySignUpButtonShowing(), "Verified Signup button displaying");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Sign up button.");
//		waitTime(3000);
//		signup.clickOnSignUpButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signup with Email button displaying.");
//		ErrorCollector.verifyTrue(signup.verifySignUpWithEmailButtonShowing(),
//				"Verified Signup with Email button displaying.");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Sign up With Email button.");
//		signup.clickOnSignUpWithEmailButton();
//
//		String email = getUniqueEmailId("Test");
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter email address : " + email);
//		signup.enterEmailAddress(email);
//
//		String password = getUniquePassword();
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Password : " + password);
//		signup.enterPassword(password);
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Sign Up button.");
//		signup.clickOnSubmitSignupButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Verification Code screen is displaying.");
//		ErrorCollector.verifyTrue(signup.verifyOTPScreenIsDisplaying(),
//				"Verify Verification Code screen is displaying.");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Back button.");
//		waitTime(3000);
//		signup.clickOnBackButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Back button.");
//		waitTime(1000);
//		signup.clickOnBackButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login button.");
//		signup.clickOnLoginButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login With Email button.");
//		loginPage.clickOnLoginWithEmailButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter email address : " + email);
//		signup.enterEmailAddress(email);
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Enter Password : " + password);
//		signup.enterPassword(password);
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Login button.");
//		loginPage.clickOnLoginSubmitButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'START KYC' button is displaying.");
//		ErrorCollector.verifyTrue(loginPage.verifyStarKYCButton(), "Verified 'START KYC' button is displaying.");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'EXPLORE PLATFORM' button is displaying.");
//		ErrorCollector.verifyTrue(loginPage.verifyExplorePlatformButton(),
//				"Verified 'EXPLORE PLATFORM' button is displaying.");
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Explore the Platform' button.");
//		browsePage.clickOnExplorePlatformButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Accept and Proceed' button.");
//		browsePage.clickOnAcceptAndProceedButton();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Ok' button in popup.");
//		signup.clickOnOkButtonInTermsAcceptedModal();
//
//		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'AWESOME!' button in popup.");
//		signup.clickOnAwesomeButtonInModal();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on GREATE! button in modal.");
		signup.clickOnGreateButtonInModal();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Done' button in modal.");
		signup.clickOnDoneButtonInModal();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(), "Verified Browse Page is displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignalsWithScrolling(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by sorting dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
				"Verified 'Alphabetical' filter is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Alphabetical' filter.");
		browsePage.clickOnSortingFilter("Alphabetical");
		ArrayList<String> names = browsePage.getOTCStocksNames();

		ArrayList<String> sortedNames = new ArrayList<>();
		sortedNames.addAll(names);
		Collections.sort(sortedNames);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
				+ "' signal stocks are sorted by 'Alphabetical' filter.");
		ErrorCollector.verifyEquals(names, sortedNames,
				"'" + signalName + "' signal are not sorted by names Alphabetically.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
				"Verified 'Symbol' filter is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Symbol' filter.");
		browsePage.clickOnSortingFilter("Symbol");
		ArrayList<String> symbols = browsePage.getOTCStocksSymbols();

		ArrayList<String> sortedSymbols = new ArrayList<>();
		sortedSymbols.addAll(symbols);
		Collections.sort(sortedSymbols);
		ErrorCollector.extentLogInfo(
				"Step " + (++step) + " : Verify '" + signalName + "' signal stocks are sorted by 'Symbol' filter.");
		ErrorCollector.verifyEquals(symbols, sortedSymbols,
				"'" + signalName + "' signal stocks are not sorted by names Symbol.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
				"Verfied 'Market Price' filter is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Pricep' filter.");
		browsePage.clickOnSortingFilter("Market Price");
		ArrayList<Double> MarketPrice = browsePage.getOTCStocksMarketPrice();

		ArrayList<Double> sortedMarketPrices = new ArrayList<>();
		sortedMarketPrices.addAll(MarketPrice);
		Collections.sort(sortedMarketPrices, Collections.reverseOrder());
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
				+ "' signal stocks are sorted by 'Market Price' filter.");
		ErrorCollector.verifyEquals(MarketPrice, sortedMarketPrices,
				"'" + signalName + "' signal are not sorted by market price.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
				"Verified 'Daily Change' filter is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Daily Change' filter.");
		browsePage.clickOnSortingFilter("Daily Change");
		ArrayList<Double> DailyChange = browsePage.getOTCStocksDailyChange();

		ArrayList<Double> sortedDailyChange = new ArrayList<>();
		sortedDailyChange.addAll(DailyChange);
		Collections.sort(sortedDailyChange, Collections.reverseOrder());
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
				+ "' signal stocks are sorted by 'Daily Change' filter.");
		ErrorCollector.verifyEquals(DailyChange, sortedDailyChange,
				"'" + signalName + "' signal are not sorted by Daily Change.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
				"Verified 'Market Cap' filter is displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Cap' filter.");
		browsePage.clickOnSortingFilter("Market Cap");
		ArrayList<Double> marketCapitals = browsePage.getOTCStocksMarketCapital();

		ArrayList<Double> sortedMarketCapitals = new ArrayList<>();
		sortedMarketCapitals.addAll(marketCapitals);
		Collections.sort(sortedMarketCapitals, Collections.reverseOrder());
		ErrorCollector.extentLogInfo(
				"Step " + (++step) + " : Verify '" + signalName + "' signal stocks are sorted by 'Market Cap' filter.");
		ErrorCollector.verifyEquals(marketCapitals, sortedMarketCapitals,
				"'" + signalName + "' signal are not sorted by market capital.");
	}

	@Test
	public void NewUser_GoldenCrossoverSignalsDetailsSortingFilters() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-931\">QAA-931 : [iOS] - While user logged in with new user, Verify the sorting filters of 'Golden Crossover' signal detail screen<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		String signalName = "Golden Crossover";

		Object[][] dataArr = getData(testDataFile, testDataSheet);
		String email = PropertiesReader.getPropertyValue(env + "_NewUserEmailId");
		String password = PropertiesReader.getPropertyValue(env + "_NewUserPassword");
		String pinCode = dataArr[0][3].toString();

		int step = 0;
		ErrorCollector.extentLogInfo("Step " + (++step) + " : <b>Login With User Credentials</b>.");
		step = loginPage.loginToApplication(step, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse Page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowsePageIsDisplaying(), "Verified Browse Page is displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignalsWithScrolling(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by sorting dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Alphabetical' filter.");
			browsePage.clickOnSortingFilter("Alphabetical");
			ArrayList<String> names = browsePage.getOTCStocksNames();

			ArrayList<String> sortedNames = new ArrayList<>();
			sortedNames.addAll(names);
			Collections.sort(sortedNames);
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Alphabetical' filter.");
			ErrorCollector.verifyEquals(names, sortedNames,
					"'" + signalName + "' signal are not sorted by names Alphabetically.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Symbol' filter.");
			browsePage.clickOnSortingFilter("Symbol");
			ArrayList<String> symbols = browsePage.getOTCStocksSymbols();

			ArrayList<String> sortedSymbols = new ArrayList<>();
			sortedSymbols.addAll(symbols);
			Collections.sort(sortedSymbols);
			ErrorCollector.extentLogInfo(
					"Step " + (++step) + " : Verify '" + signalName + "' signal stocks are sorted by 'Symbol' filter.");
			ErrorCollector.verifyEquals(symbols, sortedSymbols,
					"'" + signalName + "' signal stocks are not sorted by names Symbol.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Pricep' filter.");
			browsePage.clickOnSortingFilter("Market Price");
			ArrayList<Double> MarketPrice = browsePage.getOTCStocksMarketPrice();

			ArrayList<Double> sortedMarketPrices = new ArrayList<>();
			sortedMarketPrices.addAll(MarketPrice);
			Collections.sort(sortedMarketPrices, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Price' filter.");
			ErrorCollector.verifyEquals(MarketPrice, sortedMarketPrices,
					"'" + signalName + "' signal are not sorted by market price.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Daily Change' filter.");
			browsePage.clickOnSortingFilter("Daily Change");
			ArrayList<Double> DailyChange = browsePage.getOTCStocksDailyChange();

			ArrayList<Double> sortedDailyChange = new ArrayList<>();
			sortedDailyChange.addAll(DailyChange);
			Collections.sort(sortedDailyChange, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Daily Change' filter.");
			ErrorCollector.verifyEquals(DailyChange, sortedDailyChange,
					"'" + signalName + "' signal are not sorted by Daily Change.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Cap' filter.");
			browsePage.clickOnSortingFilter("Market Cap");
			ArrayList<Double> marketCapitals = browsePage.getOTCStocksMarketCapital();

			ArrayList<Double> sortedMarketCapitals = new ArrayList<>();
			sortedMarketCapitals.addAll(marketCapitals);
			Collections.sort(sortedMarketCapitals, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Cap' filter.");
			ErrorCollector.verifyEquals(marketCapitals, sortedMarketCapitals,
					"'" + signalName + "' signal are not sorted by market capital.");
		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}
	}

	@Test
	public void ExistingUser_ValueCreatorsSignalsDetailsSortingFilters() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-883\">QAA-883 : [iOS] - While user logged in with existing user, Verify that user is able to sort stock data using filters for 'Value Creators' signal detail screen<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}
		String signalName = "Value Creators";

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignals(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by sorting dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
				"Verified 'Alphabetical' filter is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Alphabetical' filter.");
		browsePage.clickOnSortingFilter("Alphabetical");
		ArrayList<String> names = browsePage.getOTCStocksNames();

		ArrayList<String> sortedNames = new ArrayList<>();
		sortedNames.addAll(names);
		Collections.sort(sortedNames);
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
				+ "' signal stocks are sorted by 'Alphabetical' filter.");
		ErrorCollector.verifyEquals(names, sortedNames,
				"'" + signalName + "' signal are not sorted by names Alphabetically.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
				"Verified 'Symbol' filter is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Symbol' filter.");
		browsePage.clickOnSortingFilter("Symbol");
		ArrayList<String> symbols = browsePage.getOTCStocksSymbols();

		ArrayList<String> sortedSymbols = new ArrayList<>();
		sortedSymbols.addAll(symbols);
		Collections.sort(sortedSymbols);
		ErrorCollector.extentLogInfo(
				"Step " + (++step) + " : Verify '" + signalName + "' signal stocks are sorted by 'Symbol' filter.");
		ErrorCollector.verifyEquals(symbols, sortedSymbols,
				"'" + signalName + "' signal stocks are not sorted by names Symbol.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
				"Verfied 'Market Price' filter is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Pricep' filter.");
		browsePage.clickOnSortingFilter("Market Price");
		ArrayList<Double> MarketPrice = browsePage.getOTCStocksMarketPrice();

		ArrayList<Double> sortedMarketPrices = new ArrayList<>();
		sortedMarketPrices.addAll(MarketPrice);
		Collections.sort(sortedMarketPrices, Collections.reverseOrder());
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
				+ "' signal stocks are sorted by 'Market Price' filter.");
		ErrorCollector.verifyEquals(MarketPrice, sortedMarketPrices,
				"'" + signalName + "' signal are not sorted by market price.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
				"Verified 'Daily Change' filter is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Daily Change' filter.");
		browsePage.clickOnSortingFilter("Daily Change");
		ArrayList<Double> DailyChange = browsePage.getOTCStocksDailyChange();

		ArrayList<Double> sortedDailyChange = new ArrayList<>();
		sortedDailyChange.addAll(DailyChange);
		Collections.sort(sortedDailyChange, Collections.reverseOrder());
		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
				+ "' signal stocks are sorted by 'Daily Change' filter.");
		ErrorCollector.verifyEquals(DailyChange, sortedDailyChange,
				"'" + signalName + "' signal are not sorted by Daily Change.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
				"Verified 'Market Cap' filter is displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Cap' filter.");
		browsePage.clickOnSortingFilter("Market Cap");
		ArrayList<Double> marketCapitals = browsePage.getOTCStocksMarketCapital();

		ArrayList<Double> sortedMarketCapitals = new ArrayList<>();
		sortedMarketCapitals.addAll(marketCapitals);
		Collections.sort(sortedMarketCapitals, Collections.reverseOrder());
		ErrorCollector.extentLogInfo(
				"Step " + (++step) + " : Verify '" + signalName + "' signal stocks are sorted by 'Market Cap' filter.");
		ErrorCollector.verifyEquals(marketCapitals, sortedMarketCapitals,
				"'" + signalName + "' signal are not sorted by market capital.");
	}

	@Test
	public void ExistingUser_IncomeGeneratorsSignalsDetailsSortingFilters() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-885\">QAA-885 : [iOS] - While user logged in with existing user, Verify that user is able to sort stock data using filters for 'Income Generators' signal detail screen<a/>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}
		String signalName = "Income Generators";

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignals(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by sorting dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Alphabetical' filter.");
			browsePage.clickOnSortingFilter("Alphabetical");
			ArrayList<String> names = browsePage.getOTCStocksNames();

			ArrayList<String> sortedNames = new ArrayList<>();
			sortedNames.addAll(names);
			Collections.sort(sortedNames);
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Alphabetical' filter.");
			ErrorCollector.verifyEquals(names, sortedNames,
					"'" + signalName + "' signal are not sorted by names Alphabetically.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Symbol' filter.");
			browsePage.clickOnSortingFilter("Symbol");
			ArrayList<String> symbols = browsePage.getOTCStocksSymbols();

			ArrayList<String> sortedSymbols = new ArrayList<>();
			sortedSymbols.addAll(symbols);
			Collections.sort(sortedSymbols);
			ErrorCollector.extentLogInfo(
					"Step " + (++step) + " : Verify '" + signalName + "' signal stocks are sorted by 'Symbol' filter.");
			ErrorCollector.verifyEquals(symbols, sortedSymbols,
					"'" + signalName + "' signal stocks are not sorted by names Symbol.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Pricep' filter.");
			browsePage.clickOnSortingFilter("Market Price");
			ArrayList<Double> MarketPrice = browsePage.getOTCStocksMarketPrice();

			ArrayList<Double> sortedMarketPrices = new ArrayList<>();
			sortedMarketPrices.addAll(MarketPrice);
			Collections.sort(sortedMarketPrices, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Price' filter.");
			ErrorCollector.verifyEquals(MarketPrice, sortedMarketPrices,
					"'" + signalName + "' signal are not sorted by market price.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Daily Change' filter.");
			browsePage.clickOnSortingFilter("Daily Change");
			ArrayList<Double> DailyChange = browsePage.getOTCStocksDailyChange();

			ArrayList<Double> sortedDailyChange = new ArrayList<>();
			sortedDailyChange.addAll(DailyChange);
			Collections.sort(sortedDailyChange, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Daily Change' filter.");
			ErrorCollector.verifyEquals(DailyChange, sortedDailyChange,
					"'" + signalName + "' signal are not sorted by Daily Change.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Cap' filter.");
			browsePage.clickOnSortingFilter("Market Cap");
			ArrayList<Double> marketCapitals = browsePage.getOTCStocksMarketCapital();

			ArrayList<Double> sortedMarketCapitals = new ArrayList<>();
			sortedMarketCapitals.addAll(marketCapitals);
			Collections.sort(sortedMarketCapitals, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Cap' filter.");
			ErrorCollector.verifyEquals(marketCapitals, sortedMarketCapitals,
					"'" + signalName + "' signal are not sorted by market capital.");

		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}
	}

	@Test
	public void ExistingUser_CoffeeCanInvestingDetailsSortingFilters() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-887\">QAA-887 : [iOS] - While user logged in with existing user, Verify that user is able to sort stock data using filters for 'Coffee Can Investing' signal detail screen</a>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}
		String signalName = "Coffee Can Investing";

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignals(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in Signals sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by signal dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Alphabetical' filter.");
			browsePage.clickOnSortingFilter("Alphabetical");
			ArrayList<String> names = browsePage.getOTCStocksNames();

			ArrayList<String> sortedNames = new ArrayList<>();
			sortedNames.addAll(names);
			Collections.sort(sortedNames);
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Alphabetical' filter.");
			ErrorCollector.verifyEquals(names, sortedNames,
					"'" + signalName + "' signal are not sorted by names Alphabetically.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Symbol' filter.");
			browsePage.clickOnSortingFilter("Symbol");
			ArrayList<String> symbols = browsePage.getOTCStocksSymbols();

			ArrayList<String> sortedSymbols = new ArrayList<>();
			sortedSymbols.addAll(symbols);
			Collections.sort(sortedSymbols);
			ErrorCollector.extentLogInfo(
					"Step " + (++step) + " : Verify '" + signalName + "' signal stocks are sorted by 'Symbol' filter.");
			ErrorCollector.verifyEquals(symbols, sortedSymbols,
					"'" + signalName + "' signal stocks are not sorted by names Symbol.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Pricep' filter.");
			browsePage.clickOnSortingFilter("Market Price");
			ArrayList<Double> MarketPrice = browsePage.getOTCStocksMarketPrice();

			ArrayList<Double> sortedMarketPrices = new ArrayList<>();
			sortedMarketPrices.addAll(MarketPrice);
			Collections.sort(sortedMarketPrices, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Price' filter.");
			ErrorCollector.verifyEquals(MarketPrice, sortedMarketPrices,
					"'" + signalName + "' signal are not sorted by market price.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Daily Change' filter.");
			browsePage.clickOnSortingFilter("Daily Change");
			ArrayList<Double> DailyChange = browsePage.getOTCStocksDailyChange();

			ArrayList<Double> sortedDailyChange = new ArrayList<>();
			sortedDailyChange.addAll(DailyChange);
			Collections.sort(sortedDailyChange, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Daily Change' filter.");
			ErrorCollector.verifyEquals(DailyChange, sortedDailyChange,
					"'" + signalName + "' signal are not sorted by Daily Change.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Cap' filter.");
			browsePage.clickOnSortingFilter("Market Cap");
			ArrayList<Double> marketCapitals = browsePage.getOTCStocksMarketCapital();

			ArrayList<Double> sortedMarketCapitals = new ArrayList<>();
			sortedMarketCapitals.addAll(marketCapitals);
			Collections.sort(sortedMarketCapitals, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Cap' filter.");
			ErrorCollector.verifyEquals(marketCapitals, sortedMarketCapitals,
					"'" + signalName + "' signal are not sorted by market capital.");

		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}

	}

	@Test
	public void ExistingUser_BullishRSIDetailsSortingFilters() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-889\">QAA-889 : [iOS] - While user logged in with existing user, Verify that user is able to sort stock data using filters for 'Bullish RSI' signal detail screen</a>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}
		String signalName = "Bullish RSI";

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignalsWithScrolling(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in Signals sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by signal dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Alphabetical' filter.");
			browsePage.clickOnSortingFilter("Alphabetical");
			ArrayList<String> names = browsePage.getOTCStocksNames();

			ArrayList<String> sortedNames = new ArrayList<>();
			sortedNames.addAll(names);
			Collections.sort(sortedNames);
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Alphabetical' filter.");
			ErrorCollector.verifyEquals(names, sortedNames,
					"'" + signalName + "' signal are not sorted by names Alphabetically.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Symbol' filter.");
			browsePage.clickOnSortingFilter("Symbol");
			ArrayList<String> symbols = browsePage.getOTCStocksSymbols();

			ArrayList<String> sortedSymbols = new ArrayList<>();
			sortedSymbols.addAll(symbols);
			Collections.sort(sortedSymbols);
			ErrorCollector.extentLogInfo(
					"Step " + (++step) + " : Verify '" + signalName + "' signal stocks are sorted by 'Symbol' filter.");
			ErrorCollector.verifyEquals(symbols, sortedSymbols,
					"'" + signalName + "' signal stocks are not sorted by names Symbol.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Pricep' filter.");
			browsePage.clickOnSortingFilter("Market Price");
			ArrayList<Double> MarketPrice = browsePage.getOTCStocksMarketPrice();

			ArrayList<Double> sortedMarketPrices = new ArrayList<>();
			sortedMarketPrices.addAll(MarketPrice);
			Collections.sort(sortedMarketPrices, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Price' filter.");
			ErrorCollector.verifyEquals(MarketPrice, sortedMarketPrices,
					"'" + signalName + "' signal are not sorted by market price.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Daily Change' filter.");
			browsePage.clickOnSortingFilter("Daily Change");
			ArrayList<Double> DailyChange = browsePage.getOTCStocksDailyChange();

			ArrayList<Double> sortedDailyChange = new ArrayList<>();
			sortedDailyChange.addAll(DailyChange);
			Collections.sort(sortedDailyChange, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Daily Change' filter.");
			ErrorCollector.verifyEquals(DailyChange, sortedDailyChange,
					"'" + signalName + "' signal are not sorted by Daily Change.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Cap' filter.");
			browsePage.clickOnSortingFilter("Market Cap");
			ArrayList<Double> marketCapitals = browsePage.getOTCStocksMarketCapital();

			ArrayList<Double> sortedMarketCapitals = new ArrayList<>();
			sortedMarketCapitals.addAll(marketCapitals);
			Collections.sort(sortedMarketCapitals, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Cap' filter.");
			ErrorCollector.verifyEquals(marketCapitals, sortedMarketCapitals,
					"'" + signalName + "' signal are not sorted by market capital.");
		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}

	}

	@Test
	public void ExistingUser_RisingStarsDetailsSortingFilters() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo(
				"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-891\">QAA-891 : [iOS] - While user logged in with existing user, Verify that user is able to sort stock data using filters for 'Rising Stars' signal detail screen</a>");

		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();

		Object[][] dataArr = getData(TestDataFileName, testDataSheet);
		String email = dataArr[0][1].toString();
		String password = dataArr[0][2].toString();
		String pinCode = dataArr[0][3].toString();
		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env + "_EmailId");
			password = PropertiesReader.getPropertyValue(env + "_Password");
		}
		String signalName = "Rising Stars";

		int step = loginPage.loginToApplication(0, email, password, pinCode);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(), "Verified Browse button displaying");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Browse menu button.");
		browsePage.clickOnBrowseButton();

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals section is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSectionIsDisplaying(),
				"Verify Signals section is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on Signal: " + signalName);
		browsePage.clickOnSignalsWithScrolling(signalName);

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signal detail page is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsDetailsPageIsDisplaying(),
				"Verify Signal details page is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify Signals sorting dropdown is displaying.");
		ErrorCollector.verifyTrue(browsePage.verifySignalsSortingDropdownIsDisplaying(),
				"Verify Signal sorting dropdown is displaying.");

		ErrorCollector.extentLogInfo("Step " + (++step)
				+ " : Verify 'Market Cap' is selected by default in Signals sorting dropdown is displaying.");
		ErrorCollector.verifyEquals(browsePage.getSelectedValueOfSignalsSortingDropdown(), "Market Cap",
				"By default 'Market Cap' is not selected by signal dropdown.");

		ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
		browsePage.clickOnSortingDropdown();

		if (browsePage.verifySortingFilterAlphaIsDisplaying() == true) {

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Alphabetical' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Alphabetical"),
					"Verified 'Alphabetical' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Alphabetical' filter.");
			browsePage.clickOnSortingFilter("Alphabetical");
			ArrayList<String> names = browsePage.getOTCStocksNames();

			ArrayList<String> sortedNames = new ArrayList<>();
			sortedNames.addAll(names);
			Collections.sort(sortedNames);
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Alphabetical' filter.");
			ErrorCollector.verifyEquals(names, sortedNames,
					"'" + signalName + "' signal are not sorted by names Alphabetically.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Symbol' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Symbol"),
					"Verified 'Symbol' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Symbol' filter.");
			browsePage.clickOnSortingFilter("Symbol");
			ArrayList<String> symbols = browsePage.getOTCStocksSymbols();

			ArrayList<String> sortedSymbols = new ArrayList<>();
			sortedSymbols.addAll(symbols);
			Collections.sort(sortedSymbols);
			ErrorCollector.extentLogInfo(
					"Step " + (++step) + " : Verify '" + signalName + "' signal stocks are sorted by 'Symbol' filter.");
			ErrorCollector.verifyEquals(symbols, sortedSymbols,
					"'" + signalName + "' signal stocks are not sorted by names Symbol.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Price' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Price"),
					"Verfied 'Market Price' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Pricep' filter.");
			browsePage.clickOnSortingFilter("Market Price");
			ArrayList<Double> MarketPrice = browsePage.getOTCStocksMarketPrice();

			ArrayList<Double> sortedMarketPrices = new ArrayList<>();
			sortedMarketPrices.addAll(MarketPrice);
			Collections.sort(sortedMarketPrices, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Price' filter.");
			ErrorCollector.verifyEquals(MarketPrice, sortedMarketPrices,
					"'" + signalName + "' signal are not sorted by market price.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Daily Change' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Daily Change"),
					"Verified 'Daily Change' filter is displaying.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Daily Change' filter.");
			browsePage.clickOnSortingFilter("Daily Change");
			ArrayList<Double> DailyChange = browsePage.getOTCStocksDailyChange();

			ArrayList<Double> sortedDailyChange = new ArrayList<>();
			sortedDailyChange.addAll(DailyChange);
			Collections.sort(sortedDailyChange, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Daily Change' filter.");
			ErrorCollector.verifyEquals(DailyChange, sortedDailyChange,
					"'" + signalName + "' signal are not sorted by Daily Change.");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on sorting dropdown.");
			browsePage.clickOnSortingDropdown();

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify 'Market Cap' filter is displaying.");
			ErrorCollector.verifyTrue(browsePage.verifySortingFilterIsDisplaying("Market Cap"),
					"Verified 'Market Cap' filter is displaying");

			ErrorCollector.extentLogInfo("Step " + (++step) + " : Click on 'Market Cap' filter.");
			browsePage.clickOnSortingFilter("Market Cap");
			ArrayList<Double> marketCapitals = browsePage.getOTCStocksMarketCapital();

			ArrayList<Double> sortedMarketCapitals = new ArrayList<>();
			sortedMarketCapitals.addAll(marketCapitals);
			Collections.sort(sortedMarketCapitals, Collections.reverseOrder());
			ErrorCollector.extentLogInfo("Step " + (++step) + " : Verify '" + signalName
					+ "' signal stocks are sorted by 'Market Cap' filter.");
			ErrorCollector.verifyEquals(marketCapitals, sortedMarketCapitals,
					"'" + signalName + "' signal are not sorted by market capital.");
		} else {

			ErrorCollector.extentLogInfo("<font color=red>Sorting Dropdown is not getting displayed.</font>");
			ErrorCollector.extentLogInfo(
					"<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-898\"><font color=red>Click here to view reported bug</font></a>");
		}


	}
}
