package testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageobjects.UserRolePageObjects;

public class TestUserRole extends CommonFunctions {
	static Logger logger = Logger.getLogger(TestUserRole.class);

	public static void moveToUserPage() {
		PageFactory.initElements(driver, UserRolePageObjects.class);
		Actions actions = new Actions(driver);
		actions.moveToElement(UserRolePageObjects.userManagement);
		actions.moveToElement(UserRolePageObjects.users);
		actions.click().build().perform();
	}

	public static void selectUserRole() {
		UserRolePageObjects.userRole.click();
		UserRolePageObjects.userRole.sendKeys(Keys.DOWN);
	}

	public static void selectUserStatus() {
		UserRolePageObjects.userStatus.click();
		UserRolePageObjects.userStatus.sendKeys(Keys.DOWN, Keys.ENTER);
	}

	@Test
	public static void checkUserRole() {
		logger.info("Navigating to Users Page");
		PageFactory.initElements(driver, UserRolePageObjects.class);
		(UserRolePageObjects.adminLink).click();
		UserRolePageObjects.userManagement.click();
		UserRolePageObjects.users.click();
		// moveToUserPage();
		logger.info("Selecting the User Role");
		selectUserRole();
		logger.info("Selecting the User Status");
		selectUserStatus();
		UserRolePageObjects.searchBtn.click();
		String actualRole = UserRolePageObjects.userRoleValue.getText();
		String actualStatus = UserRolePageObjects.userStatusValue.getText();
		logger.info("Verifying the Results");
		Assert.assertEquals(actualRole, "ESS");
		Assert.assertEquals(actualStatus, "Enabled");
		logger.info("End of TestUserRole test case");

	}
}
