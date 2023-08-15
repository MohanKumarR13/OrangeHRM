package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPageObjects {
@FindBy(xpath = "//p[normalize-space()='(1) Pending Self Review']")
public static WebElement pendingLeavesDay;
}
