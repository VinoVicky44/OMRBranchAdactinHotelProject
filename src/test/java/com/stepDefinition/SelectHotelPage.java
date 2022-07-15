package com.stepDefinition;

import org.junit.Assert;

import com.pageobjectmanager.PageObjectManager;

import cucumber.api.java.en.Then;
/**
 * 
 * @author ELCOT
 * @description Select page Scenarios snippet execution
 * @date 05/07/2022
 */
public class SelectHotelPage {
	PageObjectManager pageObject=new PageObjectManager();

	@Then("User should perform select hotel")
	public void userShouldPerformSelectHotel() {
		pageObject.getSelectHotelPage().selectHotel();

	}

	@Then("User should verify the message after clicking continue {string}")
	public void userShouldVerifyTheMessageAfterClickingContinue(String expectedBookHtlMsg) {
		Assert.assertEquals("Verify the Book Hotel message", expectedBookHtlMsg,pageObject.getBookHotelPage().getTxtBkHtl().getText());
	}

	@Then("User should perform continue without selecting any hotels")
	public void userShouldPerformContinueWithoutSelectingAnyHotels() {
		pageObject.getSelectHotelPage().continueWithoutHotel();

	}

	@Then("User should verify the error message in select hotel {string}")
	public void userShouldVerifyTheErrorMessageInSelectHotel(String expectedErrorMsg) {
		Assert.assertEquals("Verify the err message", expectedErrorMsg, pageObject.getSelectHotelPage().getTxtErrMsg().getText());

	}

}
