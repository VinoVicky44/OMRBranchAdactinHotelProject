package com.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.baseclass.MainBaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
/**
 * 
 * @author ELCOT
 * @description Before and After execution of each individual scenarios
 * Before will launch the browser and load URL
 * After will generate screenshots for scenarios
 *
 */
public class Hooks extends MainBaseClass {
	
	@Before
	public void launchAdactin() throws IOException {
		driver(getPropertyFileValue("browserType"));
		getUrl(getPropertyFileValue("url"));
		maximize();
		implicitWait(10);
	}
	
	@After
	public void adactinOutSource(Scenario scenario) {
		
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshotAs, "AdactinScreenShots");
		close();
		
		
	}
	
}
