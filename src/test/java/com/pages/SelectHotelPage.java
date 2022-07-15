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
public class SelectHotelPage extends MainBaseClass {

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "login_title")
	private WebElement txtSelect;
	@FindBy(id = "radiobutton_span")
	private WebElement txtErrMsg;
	@FindBy(id = "radiobutton_0")
	private WebElement btnRadio;
	@FindBy(id = "continue")

	private WebElement btnContinue;

	public WebElement getTxtErrMsg() {
		return txtErrMsg;
	}

	public WebElement getTxtSelect() {
		return txtSelect;
	}

	public WebElement getBtnRadio() {
		return btnRadio;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
/**
 * @description method for selecting hotel scenario
 * @date 07/07/2022
 */
	public void selectHotel() {
		click(getBtnRadio());
		click(getBtnContinue());

	}
/**
 *  @description method for without selecting hotel scenario
 *  @date 07/07/2022
 */
	public void continueWithoutHotel() {
		click(getBtnContinue());
	}

}
