package com.investor.utilities;

public class Constants {
	public static String premiumSkippedTestCases = "<b>***************************************************************</b><br>"
			+ "Following Test Cases will be Skipped and will not add in Report<br>"
			+ "Due to Failure of <b>'VerifyFundsAvailable_Premium'</b><br>"
			+ "<b>***************************************************************</b><br>"
			+ "-> CreateNewDIYVest<br>"
			+ "-> VerifyKYCUserPurchaseThemeBasedVests<br>"
			+ "-> Instruments_Buy<br>"
			+ "-> CreateRecurringInvestments_ThemeBasedVests";

	public static String nonPremiumSkippedTestCases = "<b>***************************************************************</b> <br>"
			+ "Following Test Cases will be Skipped and will not add in Report<br>"
			+ "Due to Failure of <b>'VerifyFundsAvailable_NonPremium'</b>br>"
			+ "<b>***************************************************************</b><br>"
			+ "-> Verify_UserProfile_BasicPlan";

}
