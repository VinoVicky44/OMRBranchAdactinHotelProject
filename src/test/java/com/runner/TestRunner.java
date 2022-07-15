package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.baseclass.MainBaseClass;
import com.report.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
/**
 * 
 * @author ELCOT
 * @description test runner class for executing the project
 * @date 06/07/2022
 */
@RunWith(Cucumber.class)
@CucumberOptions( tags= {"@SearchHotel"},plugin = {
		"json:target\\JSONFile.json" }, monochrome = true, dryRun = false, strict = false, features = {
				"src\\test\\resources" }, snippets = SnippetType.CAMELCASE, glue = { "com.stepDefinition" })

public class TestRunner {
	
	 @AfterClass
	 public static void JVMReport() throws IOException {
	 Reporting.getJVMReports(MainBaseClass.getPropertyFileValue("jsonReportPath"));
	
	 }
	

}
