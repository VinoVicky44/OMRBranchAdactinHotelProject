package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author ELCOT
 * @description CancelBooking Page object model
 * @date 07/07/2022
 */
public class CancelBookingPage extends BookingConfirmationPage {

	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath = "//a[text()='Booked Itinerary']")
	// WebElement textBookIty;

	@FindBy(id = "order_id_text")
	WebElement srchBox;

	@FindBy(id = "search_hotel_id")
	WebElement btnGo;

	@FindBy(xpath = "//input[@name='check_all']")
	WebElement checkBox;

	@FindBy(xpath = "//input[contains(@id,'btn_id_')]")
	WebElement clickBox;
	@FindBy(id = "search_result_error")
	WebElement textSrchRes;
	@FindBy(name = "cancelall")
	WebElement btnCancel;

	public WebElement getTextSrchRes() {
		return textSrchRes;
	}

	public WebElement getTextBookIty() {
		return textBookIty;
	}

	public WebElement getSrchBox() {
		return srchBox;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getClickBox() {
		return clickBox;
	}
	/**
	 * @description  method for cancel the booking 
	 * @param orderId
	 * @throws InterruptedException
	 * @date 08/07/2022
	 */
	public void cancelBkOrdId(String orderId) throws InterruptedException {

		click(getTextBookIty());
		sendKeys(getSrchBox(), orderId);
		click(getBtnGo());
		click(getClickBox());
		alertAccept();

	}

}
