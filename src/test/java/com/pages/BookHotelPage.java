package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.MainBaseClass;

public class BookHotelPage extends MainBaseClass {

	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "first_name_span")
	WebElement txtFirNamErrMsg;
	@FindBy(id = "last_name_span")
	WebElement txtLstNamErrMsg;
	@FindBy(id = "address_span")
	WebElement txtAddErrMsg;
	@FindBy(id = "cc_num_span")
	WebElement txtCCNumErrMsg;
	@FindBy(id = "cc_type_span")
	WebElement txtCCTypeErrMsg;
	@FindBy(id = "cc_expiry_span")
	WebElement txtCCExpErrMsg;
	@FindBy(id = "cc_cvv_span")
	WebElement txtCVVErrMsg;
	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	WebElement txtBkHtl;

	@FindBy(id = "first_name")
	WebElement txtFirstName;

	@FindBy(id = "last_name")
	WebElement txtLastName;

	@FindBy(id = "address")
	WebElement txtAdd;

	@FindBy(id = "cc_num")
	WebElement txtCcNum;

	@FindBy(id = "cc_type")
	WebElement dDnCtype;

	@FindBy(id = "cc_exp_month")
	WebElement dDnExpMonth;

	@FindBy(id = "cc_exp_year")
	WebElement dDnExpYear;

	@FindBy(id = "cc_cvv")
	WebElement txtCvvNum;

	@FindBy(id = "book_now")
	WebElement btnBookNow;
	
	
	public WebElement getTxtBkHtl() {
		return txtBkHtl;
	}
	
	public WebElement getTxtFirNamErrMsg() {
		return txtFirNamErrMsg;
	}

	public WebElement getTxtLstNamErrMsg() {
		return txtLstNamErrMsg;
	}

	public WebElement getTxtAddErrMsg() {
		return txtAddErrMsg;
	}

	public WebElement getTxtCCNumErrMsg() {
		return txtCCNumErrMsg;
	}

	public WebElement getTxtCCTypeErrMsg() {
		return txtCCTypeErrMsg;
	}

	public WebElement getTxtCCExpErrMsg() {
		return txtCCExpErrMsg;
	}

	public WebElement getTxtCVVErrMsg() {
		return txtCVVErrMsg;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAdd() {
		return txtAdd;
	}

	public WebElement getTxtCcNum() {
		return txtCcNum;
	}

	public WebElement getdDnCtype() {
		return dDnCtype;
	}

	public WebElement getdDnExpMonth() {
		return dDnExpMonth;
	}

	public WebElement getdDnExpYear() {
		return dDnExpYear;
	}

	public WebElement getTxCvvNum() {
		return txtCvvNum;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public void bookHotel(String first_Name, String last_Name, String address, String cardNum, String cardType,
			String cardExpMonth, String cardExpyear, String cvNum) {
		sendKeys(getTxtFirstName(), first_Name);
		sendKeys(getTxtLastName(), last_Name);
		sendKeys(getTxtAdd(), address);
		sendKeys(getTxtCcNum(), cardNum);
		selectByVisibleText(getdDnCtype(), cardType);
		selectByVisibleText(getdDnExpMonth(), cardExpMonth);
		sendKeys(getdDnExpYear(), cardExpyear);
		sendKeys(getTxCvvNum(), cvNum);
		click(getBtnBookNow());
	}

	public void bookHotel() {
		click(getBtnBookNow());

	}
}