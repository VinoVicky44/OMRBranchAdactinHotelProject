package com.stepDefinition;

import org.junit.Assert;

import com.pageobjectmanager.PageObjectManager;

import cucumber.api.java.en.Then;
/**
 * 
 * @author ELCOT
 * @description Search page Scenarios snippet execution
 * @date 04/07/2022
 */
public class SearchHotelPageStep {
	PageObjectManager pageObject=new PageObjectManager();
	@Then("User should perform search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldPerformSearchHotelAnd(String locations, String hotels, String roomType, String roomNo, String checkInDate, String checkOutDate, String adultRoomNo, String childRoomNo) {
		pageObject.getSearchHotelPage().searchHotel(locations, hotels, roomType, roomNo, checkInDate, checkOutDate, adultRoomNo, childRoomNo);
	}

	@Then("User should verify the message after clicking search {string}")
	public void userShouldVerifyTheMessageAfterClickingSearch(String expectedSelectHotelMsg) {

		Assert.assertEquals("Verify the Select Hotel text", expectedSelectHotelMsg, pageObject.getSelectHotelPage().getTxtSelect().getText());
	}

	@Then("User should select only the mandatory fields {string},{string},{string},{string} and {string}")
	public void userShouldSelectOnlyTheMandatoryFieldsAnd(String locations, String roomNo, String checkInDate, String checkOutDate, String adultRoomNo) {
		pageObject.getSearchHotelPage().searchHotel(locations, roomNo, checkInDate, checkOutDate, adultRoomNo);

	}

	@Then("User should verify the error message after clicking search in search hotel {string},{string}")
	public void userShouldVerifyTheErrorMessageAfterClickingSearchInSearchHotel(String expectedchekInDateErrMsg, String expectedchekOutDateErrMsg) {
		Assert.assertEquals("Verify the chekInDate error mesaage", expectedchekInDateErrMsg, pageObject.getSearchHotelPage().getTextCheckInErrMsg().getText());
		Assert.assertEquals("Verify the chekOutDate error mesaage", expectedchekOutDateErrMsg, pageObject.getSearchHotelPage().getTextCheckOutErrMsg().getText());

	}

	@Then("User should perform search hotel without fields")
	public void userShouldPerformSearchHotelWithoutFields() {
		pageObject.getSearchHotelPage().searchHotel();
		
	}

	@Then("User should verify the error message after clicking search in search hotel {string}")
	public void userShouldVerifyTheErrorMessageAfterClickingSearchInSearchHotel(String expectedErrorMsg) {
		Assert.assertEquals("Verify the error message text", expectedErrorMsg, pageObject.getSearchHotelPage().getTextLocErrMsg().getText());

	}

}
