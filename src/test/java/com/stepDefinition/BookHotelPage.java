package com.stepDefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.baseclass.MainBaseClass;
import com.pageobjectmanager.PageObjectManager;

import cucumber.api.java.en.Then;
/**
 * 
 * @author ELCOT
 * @description BookHotel page Scenarios snippet execution
 * @date 05/07/2022
 */
public class BookHotelPage extends MainBaseClass {
	
	PageObjectManager pageObject=new PageObjectManager();
	
	@Then("User should perform book hotel{string},{string}and{string}")
	public void userShouldPerformBookHotelAnd(String firstName, String lastName, String address, io.cucumber.datatable.DataTable dataTable) {
		
		List<Map<String,String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(1);
		String cardNo = map.get("cardNo");
		String cardType = map.get("cardType");
		String expMon = map.get("expMon");
		String expYear = map.get("expYear");
		String cvv = map.get("cvv");
		
		pageObject.getBookHotelPage().bookHotel(firstName, lastName, address, cardNo, cardType, expMon, expYear, cvv);
	
		
	}

	@Then("User should verify the message after clicking book now {string}")
	public void userShouldVerifyTheMessageAfterClickingBookNow(String expectedMsg) {
	   Assert.assertEquals("Verify the Sucessful BookingConfirmation message", expectedMsg, pageObject.getBookingConfirmationPage().getTextBookConf().getText());
	}

	@Then("USer should not enter any fields")
	public void userShouldNotEnterAnyFields() {
		pageObject.getBookHotelPage().bookHotel();
	}

	@Then("User should verify the error message after clicking book now in Book hotel {string},{string},{string},{string},{string},{string}and{string}")
	public void userShouldVerifyTheErrorMessageAfterClickingBookNowInBookHotelAnd(String expectedErrorMsg1, String expectedErrorMsg2, String expectedErrorMsg3, String expectedErrorMsg4, String expectedErrorMsg5, String expectedErrorMsg6, String expectedErrorMsg7) {
	   Assert.assertEquals("Verify the following error messages", expectedErrorMsg1, pageObject.getBookHotelPage().getTxtFirNamErrMsg().getText());
	   Assert.assertEquals("Verify the following error messages", expectedErrorMsg2, pageObject.getBookHotelPage().getTxtLstNamErrMsg().getText());
	   Assert.assertEquals("Verify the following error messages", expectedErrorMsg3, pageObject.getBookHotelPage().getTxtAddErrMsg().getText());
	   Assert.assertEquals("Verify the following error messages", expectedErrorMsg4, pageObject.getBookHotelPage().getTxtCCNumErrMsg().getText());
	   Assert.assertEquals("Verify the following error messages", expectedErrorMsg5, pageObject.getBookHotelPage().getTxtCCTypeErrMsg().getText());
	   Assert.assertEquals("Verify the following error messages", expectedErrorMsg6, pageObject.getBookHotelPage().getTxtCCExpErrMsg().getText());
	   Assert.assertEquals("Verify the following error messages", expectedErrorMsg7, pageObject.getBookHotelPage().getTxtCVVErrMsg().getText());
	}
}
