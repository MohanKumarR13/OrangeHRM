package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {
@FindBy(name = "username")
public static WebElement userName;
@FindBy(name = "password")
public static WebElement pwd;
@FindBy(xpath = "//button[normalize-space()='Login']")
public static WebElement loginBtn;
}
