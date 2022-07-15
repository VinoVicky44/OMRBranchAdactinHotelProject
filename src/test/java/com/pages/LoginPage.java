package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.MainBaseClass;

/**
 * 
 * @author ELCOT
 * @description LoginPage Page object model
 * @date 06/07/2022
 */
public class LoginPage extends MainBaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUsername;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id = "login")
	private WebElement btnLogin;

	@FindBy(xpath = "//div[@class='auth_error']")
	private WebElement textErrorLogin;

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getbtnLogin() {
		return btnLogin;
	}

	public WebElement getTextErrorLogin() {
		return textErrorLogin;
	}

	/**
	 * @description method for both valid invalid credential functionality scenario
	 * @param userName
	 * @param password
	 */
	public void loginPage(String userName, String password) {

		sendKeys(getTxtUsername(), userName);
		sendKeys(getTxtPassword(), password);
		click(getbtnLogin());

	}

	/**
	 * @description method for Enter key functionality scenario
	 * @param userName
	 * @param password
	 * @throws AWTException
	 */
	public void loginWithEnterKey(String userName, String password) throws AWTException {

		sendKeys(getTxtUsername(), userName);
		sendKeys(getTxtPassword(), password);
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
}
