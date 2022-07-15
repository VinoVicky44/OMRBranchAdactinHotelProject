package com.stepDefinition;

import java.io.IOException;

import org.junit.Assert;

import com.baseclass.MainBaseClass;
import com.pageobjectmanager.PageObjectManager;

import cucumber.api.java.en.Then;
/**
 * 
 * @author ELCOT
 * @description CancelBooking page Scenarios snippet execution
 * @date 06/07/2022
 */
public class CancelBookingPageStep extends MainBaseClass {

	PageObjectManager pageObject = new PageObjectManager();

	@Then("User should perform cancel booking")
	public void userShouldPerformCancelBooking() throws IOException, InterruptedException {

		String orderId = pageObject.getBookingConfirmationPage().orderId();
		pageObject.getCancelBookingPage().cancelBkOrdId(orderId);
	}

	@Then("User should verify the message after cancel booking contains{string}")
	public void userShouldVerifyTheMessageAfterCancelBookingContains(String expectedMsg) {
		String text = pageObject.getCancelBookingPage().getTextSrchRes().getText();
		String trim = text.trim();
		Assert.assertEquals("expectedMsg", expectedMsg, trim);
	}

	@Then("User should perform cancel booking by existing order id {string}")
	public void userShouldPerformCancelBookingByExistingOrderId(String orderId)
			throws InterruptedException, IOException {

		pageObject.getCancelBookingPage().cancelBkOrdId(getPropertyFileValue("orderId"));

	}
}
