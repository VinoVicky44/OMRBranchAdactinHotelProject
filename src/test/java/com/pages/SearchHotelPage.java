package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.MainBaseClass;

/**
 * 
 * @author ELCOT
 * @description SearchHotel Page object model
 * @date 06/07/2022
 */
public class SearchHotelPage extends MainBaseClass {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username_show")
	private WebElement textWelcomeMsg;
	@FindBy(id = "location_span")
	private WebElement textLocErrMsg;
	@FindBy(id = "checkin_span")
	private WebElement textCheckInErrMsg;
	@FindBy(id = "checkout_span")
	private WebElement textCheckOutErrMsg;
	@FindBy(id = "location")
	private WebElement dDnlocation;
	@FindBy(id = "hotels")
	private WebElement dDnHotels;
	@FindBy(id = "room_type")
	private WebElement dDnRoom_type;
	@FindBy(id = "room_nos")
	private WebElement dDnRoomNos;
	@FindBy(id = "datepick_in")
	private WebElement txtCheckInDate;
	@FindBy(id = "datepick_out")
	private WebElement txtCheckOutDate;
	@FindBy(id = "adult_room")
	private WebElement dDnAdultRoom;
	@FindBy(id = "child_room")
	private WebElement dDnChildRoom;
	@FindBy(id = "Submit")
	private WebElement btnClick;

	public WebElement getTextWelcomeMsg() {
		return textWelcomeMsg;
	}

	public WebElement getTextLocErrMsg() {
		return textLocErrMsg;
	}

	public WebElement getTextCheckInErrMsg() {
		return textCheckInErrMsg;
	}

	public WebElement getTextCheckOutErrMsg() {
		return textCheckOutErrMsg;
	}

	public WebElement getdDnlocation() {
		return dDnlocation;
	}

	public WebElement getdDnHotels() {
		return dDnHotels;
	}

	public WebElement getdDnRoom_type() {
		return dDnRoom_type;
	}

	public WebElement getdDnRoomNos() {
		return dDnRoomNos;
	}

	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}

	public WebElement getTxtCheckOutDate() {
		return txtCheckOutDate;
	}

	public WebElement getdDnAdultRoom() {
		return dDnAdultRoom;
	}

	public WebElement getdDnChildRoom() {
		return dDnChildRoom;
	}

	public WebElement getBtnClick() {
		return btnClick;
	}

	/**
	 * @description method for search hotel with all fields
	 * @param location
	 * @param hotels
	 * @param roomType
	 * @param room_No
	 * @param checkInDate
	 * @param checkOutDate
	 * @param aduldRoom
	 * @param childRoom
	 * @date 08/07/2022
	 */
	public void searchHotel(String location, String hotels, String roomType, String room_No, String checkInDate,
			String checkOutDate, String aduldRoom, String childRoom) {

		selectByVisibleText(getdDnlocation(), location);
		sendKeys(getdDnHotels(), hotels);
		selectByVisibleText(getdDnRoom_type(), roomType);
		sendKeys(getdDnRoomNos(), room_No);
		clear(getTxtCheckInDate());
		sendKeys(getTxtCheckInDate(), checkInDate);
		clear(getTxtCheckOutDate());
		sendKeys(getTxtCheckOutDate(), checkOutDate);
		selectByVisibleText(getdDnAdultRoom(), aduldRoom);
		selectByVisibleText(getdDnChildRoom(), childRoom);
		click(getBtnClick());
	}

	/**
	 * @description method for search hotel with only mandatory fields scenario
	 * @param location
	 * @param room_No
	 * @param checkInDate
	 * @param checkOutDate
	 * @param aduldRoom
	 * @date 08/07/2022
	 */
	public void searchHotel(String location, String room_No, String checkInDate, String checkOutDate,
			String aduldRoom) {
		selectByVisibleText(getdDnlocation(), location);
		sendKeys(getdDnRoomNos(), room_No);
		clear(getTxtCheckInDate());
		sendKeys(getTxtCheckInDate(), checkInDate);
		clear(getTxtCheckOutDate());
		sendKeys(getTxtCheckOutDate(), checkOutDate);
		selectByVisibleText(getdDnAdultRoom(), aduldRoom);
		click(getBtnClick());
	}

	/**
	 * @description method for search hotel without field scenario
	 * @date 08/07/2022
	 */
	public void searchHotel() {
		click(getBtnClick());
	}

}
