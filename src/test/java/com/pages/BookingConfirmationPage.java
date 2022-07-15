package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.MainBaseClass;
/**
 * 
 * @author ELCOT
 * @description BookingConfirmation Page object model
 * @date 07/07/2022
 */
public class BookingConfirmationPage extends MainBaseClass {
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	WebElement txtBkCon;

	@FindBy(id = "order_no")
	WebElement orderId;

	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	WebElement textBookConf;

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	WebElement textBookIty;
	
	
	public WebElement getTxtBkCon() {
		return txtBkCon;
	}

	public WebElement getOrderId() {
		return orderId;
	}

	public WebElement getTextBookConf() {
		return textBookConf;
	}

	public WebElement getTextBookIty() {
		return textBookIty;
	}
/**
 * @description getting booked order id from adactin
 * @return attribute
 * @date 07/07/2022
 */
	public String orderId() {
		
		String attribute = getAttribute(getOrderId());
		return attribute;

	}

}
