package testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageobjects.DashBoardPageObjects;
import pageobjects.LoginPageObjects;

public class TestPendingLeaveRequest extends CommonFunctions {
	static Logger logger = Logger.getLogger(TestPendingLeaveRequest.class);
	static String actualMessage = null;

	public static void login() {
		logger.info("Login to the Application");
		PageFactory.initElements(driver, LoginPageObjects.class);
		LoginPageObjects.userName.sendKeys(properties.getProperty("USERNAME"));
		LoginPageObjects.pwd.sendKeys(properties.getProperty("PASSWORD"));
		LoginPageObjects.loginBtn.click();
	}

	public static void getPendingLeaveRequest() {
		PageFactory.initElements(driver, DashBoardPageObjects.class);
		actualMessage = DashBoardPageObjects.pendingLeavesDay.getText();
	}

	@Test
	public static void verifyPendingLeaveRequest() {
		login();
		logger.info("Getting the Pending Leave Request Details");
		getPendingLeaveRequest();
		logger.info("Verification");
		Assert.assertEquals(actualMessage, "(1) Pending Self Review");
		logger.info("End of TestPendingLeaveRequest test case");

	}
}
