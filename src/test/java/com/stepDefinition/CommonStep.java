package com.stepDefinition;

import org.junit.Assert;

import com.baseclass.MainBaseClass;
import com.pageobjectmanager.PageObjectManager;

import cucumber.api.java.en.Then;

public class CommonStep extends MainBaseClass {
	PageObjectManager pageObject = new PageObjectManager();

	@Then("User should verify the login sucessfuly {string}")
	public void userShouldVerifyTheLoginSucessfuly(String expectedMsg) {
		Assert.assertEquals("Verify the expected welcome message", expectedMsg, getAttribute(pageObject.getSearchHotelPage().getTextWelcomeMsg()));


	}

}
