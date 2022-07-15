package com.stepDefinition;

import java.io.IOException;

import org.junit.Assert;

import com.baseclass.MainBaseClass;
import com.pageobjectmanager.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * 
 * @author ELCOT
 * @description Login page Scenarios snippet execution
 * @date 04/07/2022
 */
public class LoginPageStep extends MainBaseClass {

	PageObjectManager pageObject = new PageObjectManager();

	@Given("User is on the adactin login page")
	public void userIsOnTheAdactinLoginPage() throws IOException {
		
	}

	@When("User should perform login {string} , {string}")
	public void userShouldPerformLogin(String userName, String password) throws IOException {

		pageObject.getLoginPage().loginPage(userName, password);

	}

	@When("User should perform login {string} , {string} and press Enter key")
	public void userShouldPerformLoginAndPressEnterKey(String userName, String password) throws IOException {
		pageObject.getLoginPage().loginPage(getPropertyFileValue("userName"), getPropertyFileValue("password"));

	}

	@Then("User should verify the error message after login contains {string}")
	public void userShouldVerifyTheErrorMessageAfterLoginContains(String expectedLoginErrorMsg) {

		String text = pageObject.getLoginPage().getTextErrorLogin().getText();
		Assert.assertTrue("Verify the Error message", text.contains(expectedLoginErrorMsg));

	}

}
