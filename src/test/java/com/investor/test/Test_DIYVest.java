package com.investor.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.investor.base.BaseClass;
import com.investor.base.BaseClass.Direction;
import com.investor.base.PropertiesReader;
import com.investor.errorCollectors.ErrorCollector;
import com.investor.listeners.ExtentListeners;
import com.investor.pages.DIYVestPage;
import com.investor.pages.ExplorePage;
import com.investor.pages.LoginPage;
import com.investor.pages.SignupPage;
import com.investor.utilities.Waits;

import io.appium.java_client.pagefactory.bys.builder.AppiumByBuilder;
import junit.framework.Assert;

public class Test_DIYVest extends BaseClass{
	
	@Test(groups = "CashRequired")
	public void CreateNewDIYVest() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-89\">QAA-89 : [IOS automation DIY Vest] Create a new DIY vest<a/>");


		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		DIYVestPage diyVestPage = new DIYVestPage();

		Object[][] dataArr = getData(TestDataFileName,testDataSheet);
		String email=dataArr[0][1].toString();
		String password=dataArr[0][2].toString();
		String pinCode=dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}

		String vestName = "vest user"+randomNumberString(3); 
		String Value;
		String amountValue;

		int step=0;
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(),"Verified Login button displaying");
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+email);
		signup.enterEmailAddress(email);
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+password);
		signup.enterPassword(password);
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Pin Code  : "+pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified home page is displaying.");
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(),"Verified Browse button displaying");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'DIY Vest' Button ");
		diyVestPage.clickOnDIYVestButton();
		
		waitTime(15000);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Create New Vest' Button ");
		diyVestPage.clickOnCreateNewVestButton();
		
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Create New Vest Page Title' displaying");
		ErrorCollector.verifyTrue(diyVestPage.verifyCreateNewVesPageTitleIsDisplaying(),"Verified 'Create New Vest Page Title' displaying");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Search and select stock: AAPL");
		diyVestPage.searchAndSelectStock("MSFT");
		
		Waits.wait2s();
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Search and select stock: MSFT");
		diyVestPage.searchAndSelectStock("GOOGL");
//		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Stock Added' Button ");
		diyVestPage.clickOnStockAddedButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Popup Next' Button ");
		diyVestPage.clickOnPopupNextButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'First Stock Plus' Button ");
		diyVestPage.clickOnFirstStockPlusButton();

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Sum Of First And Second Stock Value'"+diyVestPage.getSumOfFirstAndSecondStockValue()+" is Equal To 'total Stock Value :'"+diyVestPage.getstockTotalValue()+"");
		ErrorCollector.verifyEquals("100", diyVestPage.getstockTotalValue());
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Vest Name : "+vestName);
		diyVestPage.enterTheVestName(vestName);
		driver.hideKeyboard();
		
		//ExtentListeners.attachScreenShot("Home Page Screenshot");
		mobileScrollScreenIOS(Direction.DOWN);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Create Vest' Button ");
		diyVestPage.clickOnCreateVestButton();
		
		diyVestPage.tryClickOnErrorDialogOkButton();
		waitTime(6000);
		diyVestPage.clickOnOkButtonInDialog();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Popup Next' Button if it is showing.");
		diyVestPage.clickOnCreateVestPagePopupNextButton();
		
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Buy' Button ");
		diyVestPage.clickOnBuyButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Investor Amount : "+"50");
		diyVestPage.investmentAmount("50");
		//mobileScrollScreenIOS(Direction.DOWN);
		//driver.hideKeyboard();
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Preview Order' Button ");
		diyVestPage.clickOnPreviewOrderButton();
		waitTime(5000);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Order Preview Page Title' displaying");
		ErrorCollector.verifyTrue(diyVestPage.verifyOrderPreviewTitleIsDisplaying(),"Verified 'Order Preview Page Title' is displaying");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Investor Amount:'"+"50"+" is Equal to 'total Investor Amount: "+diyVestPage.getTotalAmountValue()+"'");
		ErrorCollector.verifyEquals("50", diyVestPage.getTotalAmountValue());
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Enterered Vest Name:'"+vestName+" is Equal to 'Vest Name On  Order Preview Page: "+diyVestPage.getVestNameLabel()+"'");
		ErrorCollector.verifyEquals(vestName, diyVestPage.getVestNameLabel());
//		
		
//		diyVestPage.getVestNameLabel();
	}
	
	@Test
	public void CreateDuplicateDIYVest() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-91\">QAA-91 : [IOS Automation DIY Vest] Create a duplicate vest name, user should not be allowed to create a duplicate vest name<a/>");


		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		DIYVestPage diyVestPage = new DIYVestPage();

		Object[][] dataArr = getData(TestDataFileName,testDataSheet);
		String email=dataArr[0][1].toString();
		String password=dataArr[0][2].toString();
		String pinCode=dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String vestName = "vest user"+randomNumberString(3); 
		String Value;
		String amountValue;

		int step=0;
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(),"Verified Login button displaying");
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+email);
		signup.enterEmailAddress(email);
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+password);
		signup.enterPassword(password);
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Pin Code  : "+pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified home page is displaying.");
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Browse button displaying.");
		ErrorCollector.verifyTrue(browsePage.verifyBrowseButtonIsDisplaying(),"Verified Browse button displaying");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'DIY Vest' Button ");
		diyVestPage.clickOnDIYVestButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Getting already created vest name.");
		String vestNameString = diyVestPage.getFirstDIYVestName();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Create New Vest' Button ");
		diyVestPage.clickOnCreateNewVestButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Create New Vest Page Titel' displaying");
		ErrorCollector.verifyTrue(diyVestPage.verifyCreateNewVesPageTitleIsDisplaying(),"Verified 'Create New Vest Page Titel' displaying");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Search and select stock: AAPL");
		diyVestPage.searchAndSelectStock("MSFT");
		
		Waits.wait2s();
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Search and select stock: MSFT");
		diyVestPage.searchAndSelectStock("GOOGL");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Stock Added' Button ");
		diyVestPage.clickOnStockAddedButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Popup Next' Button ");
		diyVestPage.clickOnPopupNextButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Vest Name : "+vestNameString);
		diyVestPage.enterTheVestName(vestNameString);
		driver.hideKeyboard();
		
		mobileScrollScreenIOS(Direction.DOWN);
		ExtentListeners.attachScreenShot("Screenshot");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Create Vest' Button ");
		diyVestPage.clickOnCreateVestButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verified 'Sorry, you’ve already created a vest with the name.\"+vestName+\"  Please choose a different name' is displaying");
		ErrorCollector.verifyTrue(diyVestPage.verifyalreadyCreatedVestErrorMessagePopupIsDisplaying(),"Verified 'Sorry, you’ve already created a vest with the name."+vestNameString+"  Please choose a different name' is displaying");
		
		

	}
	
	
	@Test
	public void DeleteNonInvestedDIYVest() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-420\">QAA-420 : [IOS Automation DIY Vest] Delete Non-Invested DIY Vests<a/>");
		
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		DIYVestPage diyVestPage = new DIYVestPage();
		
		Object[][] dataArr = getData(TestDataFileName,testDataSheet);
		String email=dataArr[0][1].toString();
		String password=dataArr[0][2].toString();
		String pinCode=dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String vestName = "vest user"+randomNumberString(3); 
		String Value;
		String amountValue;
		
		int step=0;
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(),"Verified Login button displaying");
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+email);
		signup.enterEmailAddress(email);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+password);
		signup.enterPassword(password);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Pin Code  : "+pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified home page is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'DIY Vest' menu button ");
		diyVestPage.clickOnDIYVestButton();
		
		waitTime(3000);
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Get all DIY Vests.");
		List<WebElement> vestsList = diyVestPage.getAllDIYVests();
		printString("Size: "+vestsList.size());
		for(int i=1;i<vestsList.size();i++) {
			String diyVestName = diyVestPage.getDIYVestName(vestsList.get(i));
			ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Invest status for DIY Vest: <b>"+diyVestName+"</b>");
			if(diyVestPage.isDIYVestNotInvested(vestsList.get(i))) {
				ErrorCollector.verifyTrue(true,"Verified DIY Vest: <b>"+diyVestName+"</b> is not invested.");
				
				ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on three dots menu for DIY Vest: <b>"+diyVestName+"</b>");
				diyVestPage.clickOnVestDotMenu(vestsList.get(i));
				
				ErrorCollector.extentLogInfo("Step "+(++step)+" : Select delete from three dots menu.");
				diyVestPage.clickOnDeleteMenu();
				Waits.wait2s();
				
				ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Yes, Delete button in confirmation dialog..");
				diyVestPage.clickOnYesDeleteButtonInDialog();
				Waits.wait4s();
			}else {
				ErrorCollector.verifyFalse(false,"Verified DIY Vest: <b>"+diyVestName+"</b> is Invested.");
			}
		}
		
	}
	
	@Test
	public void DIYVest_SortingParameters() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-93\">QAA-93 : [IOS Automation DIY Vest] Sorting of the User's DIY Vest on the basis of different sorting parameters.</a>");


		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		DIYVestPage diyVestPage = new DIYVestPage();

		Object[][] dataArr = getData(TestDataFileName,testDataSheet);
		String email=dataArr[0][1].toString();
		String password=dataArr[0][2].toString();
		String pinCode=dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String vestName = "vest user"+randomNumberString(3); 
		String Value;
		String amountValue;

		int step=0;
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(),"Verified Login button displaying");
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+email);
		signup.enterEmailAddress(email);
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+password);
		signup.enterPassword(password);
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Pin Code  : "+pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);
		

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified home page is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'DIY Vest' Button ");
		diyVestPage.clickOnDIYVestButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify DIY Vest page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyDIYVestPageIsDisplaying(),"Verified DIY Vest page is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on sorting dropdown.");
		diyVestPage.clickOnSortingDropDown();

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Select sorting dropdown: Alphabetical");
		diyVestPage.selectSortingDropDown("Alphabetical");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : get DIY Vest names.");
		ArrayList<String> diyVestsNames= diyVestPage.getDIYVestNames();
		
		ArrayList<String> diyVestsNamesSorted = new ArrayList<>();
		diyVestsNamesSorted.addAll(diyVestsNames);
		Collections.sort(diyVestsNamesSorted);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify DIY vests sorted Alphabetically.");
		ErrorCollector.verifyEquals(diyVestsNames, diyVestsNamesSorted,"DIY Vests are not sorted Alphabetically");
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on sorting dropdown.");
		diyVestPage.clickOnSortingDropDown();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Select sorting dropdown: Inception Date");
		diyVestPage.selectSortingDropDown("Inception Date");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : get DIY Vest Percentage.");
		ArrayList<Double> diyVestsInceptionDate = diyVestPage.getDIYVestPercentage();
		
		ArrayList<Double> diyVestsInceptionDateSorted = new ArrayList<>();
		diyVestsInceptionDateSorted.addAll(diyVestsInceptionDate);
		Collections.sort(diyVestsInceptionDateSorted);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify DIY vests sorted by Inception Date.");
		ErrorCollector.verifyEquals(diyVestsInceptionDate, diyVestsInceptionDateSorted,"DIY Vests are not sorted Inception Date");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on sorting dropdown.");
		diyVestPage.clickOnSortingDropDown();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Select sorting dropdown: 1W Returns");
		diyVestPage.selectSortingDropDown("1W Returns");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : get DIY Vest Percentage.");
		ArrayList<Double> diyVests1WReturns = diyVestPage.getDIYVestPercentage();
		
		ArrayList<Double> diyVests1WReturnsSorted = new ArrayList<>();
		diyVests1WReturnsSorted.addAll(diyVests1WReturns);
		Collections.sort(diyVests1WReturnsSorted);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify DIY vests sorted by 1W Returns.");
		ErrorCollector.verifyEquals(diyVestsInceptionDate, diyVestsInceptionDateSorted,"DIY Vests are not sorted by 1W Returns");

		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on sorting dropdown.");
		diyVestPage.clickOnSortingDropDown();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Select sorting dropdown: 1M Returns");
		diyVestPage.selectSortingDropDown("1M Returns");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : get DIY Vest Percentage.");
		ArrayList<Double> diyVests1MReturns = diyVestPage.getDIYVestPercentage();
		
		ArrayList<Double> diyVests1MReturnsSorted = new ArrayList<>();
		diyVests1MReturnsSorted.addAll(diyVests1MReturns);
		Collections.sort(diyVests1MReturnsSorted,Collections.reverseOrder());
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify DIY vests sorted by 1M Returns.");
		ErrorCollector.verifyEquals(diyVests1MReturns, diyVests1MReturnsSorted,"DIY Vests are not sorted by 1M Returns");

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on sorting dropdown.");
		diyVestPage.clickOnSortingDropDown();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Select sorting dropdown: 3M Returns");
		diyVestPage.selectSortingDropDown("3M Returns");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : get DIY Vest Percentage.");
		ArrayList<Double> diyVests3MReturns = diyVestPage.getDIYVestPercentage();
		
		ArrayList<Double> diyVests3MReturnsSorted = new ArrayList<>();
		diyVests3MReturnsSorted.addAll(diyVests3MReturns);
		Collections.sort(diyVests3MReturnsSorted,Collections.reverseOrder());
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify DIY vests sorted by 3M Returns.");
		ErrorCollector.verifyEquals(diyVests3MReturns, diyVests3MReturnsSorted,"DIY Vests are not sorted by 3M Returns");

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on sorting dropdown.");
		diyVestPage.clickOnSortingDropDown();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Select sorting dropdown: 1Y Returns");
		diyVestPage.selectSortingDropDown("1Y Returns");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : get DIY Vest Percentage.");
		ArrayList<Double> diyVests1YReturns = diyVestPage.getDIYVestPercentage();
		
		ArrayList<Double> diyVests1YReturnsSorted = new ArrayList<>();
		diyVests1YReturnsSorted.addAll(diyVests1YReturns);
		Collections.sort(diyVests1YReturnsSorted,Collections.reverseOrder());
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify DIY vests sorted by 1Y Returns.");
		ErrorCollector.verifyEquals(diyVests1YReturns, diyVests1YReturnsSorted,"DIY Vests are not sorted by 1Y Returns");

		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on sorting dropdown.");
		diyVestPage.clickOnSortingDropDown();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Select sorting dropdown: 5Y Returns");
		diyVestPage.selectSortingDropDown("5Y Returns");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : get DIY Vest Percentage.");
		ArrayList<Double> diyVests5YReturns = diyVestPage.getDIYVestPercentage();
		
		ArrayList<Double> diyVests5YReturnsSorted = new ArrayList<>();
		diyVests5YReturnsSorted.addAll(diyVests5YReturns);
		Collections.sort(diyVests5YReturnsSorted,Collections.reverseOrder());
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify DIY vests sorted by 5Y Returns.");
		ErrorCollector.verifyEquals(diyVests5YReturns, diyVests5YReturnsSorted,"DIY Vests are not sorted by 5Y Returns");

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on sorting dropdown.");
		diyVestPage.clickOnSortingDropDown();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Select sorting dropdown: All Time Returns");
		diyVestPage.selectSortingDropDown("All Time Returns");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : get DIY Vest Percentage.");
		ArrayList<Double> diyVestsAllTimeReturns = diyVestPage.getDIYVestPercentage();
		
		ArrayList<Double> diyVestsAllTimeReturnsSorted = new ArrayList<>();
		diyVestsAllTimeReturnsSorted.addAll(diyVestsAllTimeReturns);
		Collections.sort(diyVestsAllTimeReturnsSorted,Collections.reverseOrder());
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify DIY vests sorted by All Time Returns.");
		ErrorCollector.verifyEquals(diyVestsAllTimeReturns, diyVestsAllTimeReturnsSorted,"DIY Vests are not sorted by All Time Returns.");

	}
	
	@Test
	public void VerifyUserCanPlaceSellOrderForDIYVest() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-691\">QAA-691 IOS] - Verify User can place sell order for DIY Vest<a/>");
		
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		DIYVestPage diyVestPage = new DIYVestPage();
		
		Object[][] dataArr = getData(TestDataFileName,testDataSheet);
		String email=dataArr[0][1].toString();
		String password=dataArr[0][2].toString();
		String pinCode=dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String vestName = "vest user"+randomNumberString(3); 
		String Value;
		String amountValue = "10";
		
		int step=0;
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(),"Verified Login button displaying");
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+email);
		signup.enterEmailAddress(email);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+password);
		signup.enterPassword(password);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Pin Code  : "+pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified home page is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'DIY Vest' menu button ");
		diyVestPage.clickOnDIYVestButton();
		
		waitTime(3000);
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Get all DIY Vests.");
		List<WebElement> vestsList = diyVestPage.getAllDIYVests();
		printString("Size: "+vestsList.size());
		for(int i=0;i<vestsList.size();i++) {
			String diyVestName = diyVestPage.getDIYVestName(vestsList.get(i));
			ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Invest status for DIY Vest: <b>"+diyVestName+"</b>");
			if(diyVestPage.isDIYVestNotInvested(vestsList.get(i))) {
				
				continue;
			}else {
				vestsList.get(i).click();
				ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Sell'  button ");
				diyVestPage.clickOnSellBtn();
				if(diyVestPage.error422isDisplayed() == true ) {
					diyVestPage.clickonOkButton();
					diyVestPage.clickonGoBackButton();
					continue;
				}else {
					break;
				}
			}
		}
		
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Popup Next' Button ");
//		diyVestPage.clickOnVestPopupNextButton();
		
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Sell'  button ");
//		diyVestPage.clickOnSellBtn();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Select All'  Checkbox ");
		diyVestPage.clickOnSelectAll();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify DiyVest Investment Amount is displaying in input field.");
		ErrorCollector.assertEquals(diyVestPage.getDIYVestSellAmount(), diyVestPage.getDIYVestCurrentInvestmentAmount());
			
		
//		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Sell Amount  : "+amountValue);
//		diyVestPage.enterTheSellAmount(amountValue);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Preview Order'  Button ");
		diyVestPage.clickOnSellPreviewOrderButton();
		if(!isPreProdEnv) {
			ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Place Sell Order'  Button ");
			diyVestPage.clickOnPlaceSellOrderButton();
			
			ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Place Order successfully");
			ErrorCollector.verifyTrue(diyVestPage.isOkButtonDisplaying(),"Verified Order Place Successful message is displaying");
		}
	}
	
	@Test(priority = 15)
	public void VerifyUserCanPlaceBuyOrderForExistingDIYVest() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-722\">QAA-722 [IOS] - Verify user is able to buy existing DIY Vest<a/>");
		
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		DIYVestPage diyVestPage = new DIYVestPage();
		
		Object[][] dataArr = getData(TestDataFileName,testDataSheet);
		String email=dataArr[0][1].toString();
		String password=dataArr[0][2].toString();
		String pinCode=dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String vestName = "vest user"+randomNumberString(3); 
		String Value;
		String amountValue = "10";
		
		int step=0;
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(),"Verified Login button displaying");
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+email);
		signup.enterEmailAddress(email);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+password);
		signup.enterPassword(password);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Pin Code  : "+pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified home page is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'DIY Vest' menu button ");
		diyVestPage.clickOnDIYVestButton();
		
		waitTime(3000);
	
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on vest");
		diyVestPage.clickOnDIYVest();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Buy' Button ");
		diyVestPage.clickOnBuyButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Investor Amount : "+"50");
		diyVestPage.investmentAmount("50");
		//mobileScrollScreenIOS(Direction.DOWN);
		//driver.hideKeyboard();
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Preview Order' Button ");
		diyVestPage.clickOnPreviewOrderButton();
		waitTime(5000);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Order Preview Page Title' displaying");
		ErrorCollector.verifyTrue(diyVestPage.verifyOrderPreviewTitleIsDisplaying(),"Verified 'Order Preview Page Title' is displaying");
		
		if(isPreProdEnv) {
			ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Place Buy Order' Button ");
			diyVestPage.clickOnPlaceBuyOrderButton();
			waitTime(5000);
			
			ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Success Message' displaying");
			ErrorCollector.verifyTrue(diyVestPage.isSuccessMessageDisplaying(),"Verified 'Success Message' displaying");
		}
	}
	
	@Test(priority = 15)
	public void NotAbleToAddOTCStockInDIYVestRebalance() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-855\">QAA-855 [iOS] - While rebalancing DIY Vest, Verify that user is not able to add OTC stocks/instruments<a/>");
		
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		DIYVestPage diyVestPage = new DIYVestPage();
		
		Object[][] dataArr = getData(TestDataFileName,testDataSheet);
		String email=dataArr[0][1].toString();
		String password=dataArr[0][2].toString();
		String pinCode=dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String vestName = "vest user"+randomNumberString(3); 
		String Value;
		String amountValue = "10";
		String otcStock1 = "GBTC";
		String otcStock2 = "ADDY";
		
		int step=0;
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(),"Verified Login button displaying");
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+email);
		signup.enterEmailAddress(email);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+password);
		signup.enterPassword(password);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Pin Code  : "+pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified home page is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'DIY Vest' menu button ");
		diyVestPage.clickOnDIYVestButton();
		
		waitTime(3000);
	
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on vest");
		diyVestPage.clickOnDIYVest();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Edit Allocations' Button ");
		diyVestPage.clickOnEditAllocationsButton();
				
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Search' Button ");
		diyVestPage.clickOnSearchAllocationsButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Search for the stock : "+otcStock1);
		diyVestPage.searchForTheStock(otcStock1);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify search results are zero.");
		ErrorCollector.verifyEquals(diyVestPage.getStocksSearchResultsSize(), 0);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Clear search input.");
		diyVestPage.clearSearchInput();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Search' Button ");
		diyVestPage.clickOnSearchAllocationsButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Search for the stock : "+otcStock2);
		diyVestPage.searchForTheStock(otcStock2);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify search results are zero.");
		ErrorCollector.verifyEquals(diyVestPage.getStocksSearchResultsSize(), 0);
		
	}
	
	@Test
	public void NotAbleToAddOTCStockInCreateNewDIYVest() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-852\">QAA-852 [iOS] - While user create new account, Verify user is not able to create 'DIY Vest' with OTC stocks/instruments<a/>");
		
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		DIYVestPage diyVestPage = new DIYVestPage();
		
		Object[][] dataArr = getData(TestDataFileName,testDataSheet);
		String email=dataArr[0][1].toString();
		String password=dataArr[0][2].toString();
		String pinCode=dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String otcStock1 = "GBTC";
		String otcStock2 = "ADDY";
		
		int step=0;
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(),"Verified Login button displaying");
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+email);
		signup.enterEmailAddress(email);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+password);
		signup.enterPassword(password);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Pin Code  : "+pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified home page is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'DIY Vest' menu button ");
		diyVestPage.clickOnDIYVestButton();
		
		waitTime(3000);
	
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Create New Vest' Button ");
		diyVestPage.clickOnCreateNewVestButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Create New Vest Page Title' displaying");
		ErrorCollector.verifyTrue(diyVestPage.verifyCreateNewVesPageTitleIsDisplaying(),"Verified 'Create New Vest Page Title' displaying");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Search for the stock : "+otcStock1);
		diyVestPage.searchDIYVestStock(otcStock1);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify search results are zero.");
		ErrorCollector.verifyEquals(diyVestPage.getStocksSearchResultsSize(), 0);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Clear search input.");
		diyVestPage.clearSearchInput();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Search for the stock : "+otcStock2);
		diyVestPage.searchDIYVestStock(otcStock2);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify search results are zero.");
		ErrorCollector.verifyEquals(diyVestPage.getStocksSearchResultsSize(), 0);
		
	}


	@Test
	public void CancelAllPendingVestOrders() {
		
		initReport();
		initConfiguration();
		
		ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-896\">QAA-896 [iOS] Cancel All Pending Vests Orders<a/>");
		
		
		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		DIYVestPage diyVestPage = new DIYVestPage();
		
		Object[][] dataArr = getData(TestDataFileName,testDataSheet);
		String email=dataArr[0][1].toString();
		String password=dataArr[0][2].toString();
		String pinCode=dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String vestName = "vest user"+randomNumberString(3); 
		String Value;
		String amountValue = "10";
		String otcStock1 = "GBTC";
		String otcStock2 = "ADDY";
		
		int step=0;
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify Login button displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyLoginButtonIsDisplaying(),"Verified Login button displaying");
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		waitTime(7000);
		loginPage.clickOnLoginButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login With Email button.");
		loginPage.clickOnLoginWithEmailButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter email address : "+email);
		signup.enterEmailAddress(email);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Password : "+password);
		signup.enterPassword(password);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on Login button.");
		loginPage.clickOnLoginSubmitButton();
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Pin Code  : "+pinCode);
		waitTime(3000);
		loginPage.enterPinCode(pinCode);
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify home page is displaying.");
		ErrorCollector.verifyTrue(loginPage.verifyHomePageIsDisplaying(),"Verified home page is displaying.");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Scroll down to pending vests orders.");
		mobileScrollScreenIOS(Direction.DOWN,500);
		waitTime(1000);
		scrollDownToText("PENDING VEST ORDERS");
		waitTime(3000);
		diyVestPage.scrollToPendingVests();
		waitTime(3000);
		
		
		List<WebElement> pendingVests = diyVestPage.getAllPendingVestsOrder();
		for(WebElement ele : pendingVests) {
			if(!isElementDisplayed(ele)) {
				swipeUpSlightly();
			}
			ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Cancel' button in pop up");
			clickOnElementRightDownCorner(ele);
			
			ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Yes' button in pop up");
			diyVestPage.clickOnYesButtoninPopUp();
		}
		
	}
	
	
	@Test//(groups = "CashRequired")
	public void CreateAndBuyNewDIYVest() {

		initReport();
		initConfiguration();

		ErrorCollector.extentLogInfo("<a target=\"_blank\" href=\"https://vestedfinance.atlassian.net/browse/QAA-720\">QAA-720 : [iOS] [New] - Verify user is able to buy new DIY Vest<a/>");


		SignupPage signup = new SignupPage();
		LoginPage loginPage = new LoginPage();
		ExplorePage browsePage = new ExplorePage();
		DIYVestPage diyVestPage = new DIYVestPage();

		Object[][] dataArr = getData(TestDataFileName,testDataSheet);
		String email=dataArr[0][1].toString();
		String password=dataArr[0][2].toString();
		String pinCode=dataArr[0][3].toString();

		if (isPreProdEnv) {
			email = PropertiesReader.getPropertyValue(env+"_EmailId");
			password = PropertiesReader.getPropertyValue(env+"_Password");
		}
		String vestName = "vest user"+randomNumberString(3); 
		String Value;
		String amountValue;

		int step=loginPage.loginToApplication(0, email, password, pinCode);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'DIY Vest' Button ");
		diyVestPage.clickOnDIYVestButton();
		
		waitTime(15000);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Create New Vest' Button ");
		diyVestPage.clickOnCreateNewVestButton();
		
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Create New Vest Page Title' displaying");
		ErrorCollector.verifyTrue(diyVestPage.verifyCreateNewVesPageTitleIsDisplaying(),"Verified 'Create New Vest Page Title' displaying");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Search and select stock: MSFT");
		diyVestPage.searchAndSelectStock("MSFT");
		
		Waits.wait2s();
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Search and select stock: GOOGL");
		diyVestPage.searchAndSelectStock("GOOGL");
//		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Stock Added' Button ");
		diyVestPage.clickOnStockAddedButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Popup Next' Button ");
		diyVestPage.clickOnPopupNextButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'First Stock Plus' Button ");
		diyVestPage.clickOnFirstStockPlusButton();

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Sum Of First And Second Stock Value'"+diyVestPage.getSumOfFirstAndSecondStockValue()+" is Equal To 'total Stock Value :'"+diyVestPage.getstockTotalValue()+"");
		ErrorCollector.verifyEquals("100", diyVestPage.getstockTotalValue());
		
		//ExtentListeners.attachScreenShot("Home Page Screenshot");
		mobileScrollScreenIOS(Direction.DOWN);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Create Vest' Button ");
		diyVestPage.clickOnCreateVestButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Vest Name : "+vestName);
		diyVestPage.enterTheVestName(vestName);
		driver.hideKeyboard();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify error message 'Vest Name is Required' is displaying");
		ErrorCollector.verifyTrue(diyVestPage.verifyVestNameIsRequiredErrorMessageIsDisplaying(),"Verified error message 'Vest Name is Required' is displaying.");

		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Create Vest' Button ");
		diyVestPage.clickOnCreateVestButton();
		
		diyVestPage.tryClickOnErrorDialogOkButton();
		waitTime(6000);
		diyVestPage.clickOnOkButtonInDialog();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Popup Next' Button if it is showing.");
		diyVestPage.clickOnCreateVestPagePopupNextButton();
		
		
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Buy' Button ");
		diyVestPage.clickOnBuyButton();
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Enter Investor Amount : "+"50");
		diyVestPage.investmentAmount("50");
		//mobileScrollScreenIOS(Direction.DOWN);
		//driver.hideKeyboard();
		waitTime(1000);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Preview Order' Button ");
		diyVestPage.clickOnPreviewOrderButton();
		waitTime(5000);
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Order Preview Page Title' displaying");
		ErrorCollector.verifyTrue(diyVestPage.verifyOrderPreviewTitleIsDisplaying(),"Verified 'Order Preview Page Title' is displaying");
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Investor Amount:'"+"50"+" is Equal to 'total Investor Amount: "+diyVestPage.getTotalAmountValue()+"'");
		ErrorCollector.verifyEquals("50", diyVestPage.getTotalAmountValue());
		
		ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Enterered Vest Name:'"+vestName+" is Equal to 'Vest Name On  Order Preview Page: "+diyVestPage.getVestNameLabel()+"'");
		ErrorCollector.verifyEquals(vestName, diyVestPage.getVestNameLabel());
		
		if(isPreProdEnv) {
			ErrorCollector.extentLogInfo("Step "+(++step)+" : Click on 'Place Buy Order' Button ");
			diyVestPage.clickOnPlaceBuyOrderButton();
			waitTime(5000);
			
			ErrorCollector.extentLogInfo("Step "+(++step)+" : Verify 'Success Message' displaying");
			ErrorCollector.verifyTrue(diyVestPage.isSuccessMessageDisplaying(),"Verified 'Success Message' displaying");
		}
	}
	
}