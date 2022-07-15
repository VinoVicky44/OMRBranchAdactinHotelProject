package com.report;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.baseclass.MainBaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
/**
 * 
 * @author ELCOT
 * @description JVMReport file creation
 * @date 6/7/2022
 */
public class Reporting {
	/**
	 * 
	 * @param jsonFile
	 * @throws IOException
	 * @date 6/7/2022
	 */
	public static void getJVMReports(String jsonFile) throws IOException {

		File file=new File(MainBaseClass.getPropertyFileValue("JVMReport"));
	
	   Configuration configuration=new Configuration(file, "Adactinhotel");
	   configuration.addClassifications("Browser", "Chrome");
	   configuration.addClassifications("Browser_Version", "103.00.561");
	   configuration.addClassifications("Windows_Version", "Windows_10");
	   
	   
	   List<String> jsonFiles=new ArrayList<String>();
	   jsonFiles.add(jsonFile);
	   
	   ReportBuilder builder=new  ReportBuilder(jsonFiles, configuration);
	   builder.generateReports();
	
	
	
	}
	
	

	
	
	
	
	
	
	
	
	
}
