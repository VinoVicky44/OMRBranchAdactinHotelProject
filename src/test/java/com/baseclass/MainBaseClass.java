package com.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * @description BaseClass contains all selenium methods in a pre executable format
 * @author ELCOT
 * @date 16/06/2022
 */
public class MainBaseClass {
	 
	
	 public static WebDriver driver;
	 WebDriverWait driverWait;
/**
 * @description method for different browser driver initiation in switch case
 * @param browserType
 * @throws IOException
 * @date 16/06/2022
 */
	public static  void driver(String browserType) throws IOException {
		switch (browserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			  driver=new FirefoxDriver();
		case "Edge":
			WebDriverManager.edgedriver().setup();
			  driver=new EdgeDriver();
			
		default:
			break;
		}
	}
	public static String getPropertyFileValue(String key) throws IOException {
		
		
		FileInputStream stream=new FileInputStream(System.getProperty("user.dir")+"\\Config.properties");
		Properties properties=new Properties();
		properties.load(stream);
		Object object = properties.get(key);
		String value =(String) object;
		return value;
	
	}
	/**
	 * @description for url launching
	 * @param url
	 * @date 16/06/2022
	 */
	public static  void getUrl(String url) {
      driver.get(url);
	}
	/**
	 * @description for window maximize
	 * @date 16/06/2022
	 */
	public   void maximize() {
       driver.manage().window().maximize();
	}
	/**
	 * @description for window minimize
	 * @date 16/06/2022
	 */
	public void minimize() {
		driver.manage().window().minimize();
	}
	public void switchTo() {
	 driver.switchTo();
	}
	/**
	 * @description get the current window url
	 * @date 16/06/2022 
	 *  @return String
	 */
	public String getCurrentUrl() {
    String currentUrl = driver.getCurrentUrl();
    return currentUrl;
	}
	/**
	 * @description get the current window title
	 * @date 16/06/2022 
	 * @return String
	 */
	public  String getTittle() {
      String title = driver.getTitle();
      return title;
      
	}
/**
 * @description get the current window title
 * @param attributeId
 * @return element
 */
	public    WebElement findElementById(String attributeId ) {

		WebElement element = driver.findElement(By.id(attributeId));
		return element;
		
	}
	/**
	 * 
	 * @param attributeId
	 * @param value
	 * @return
	 * @throws IOException
	 */
	public   WebElement findElementByIdWithSendKeys(String attributeId,String value ) throws IOException {
		
		WebElement element = driver.findElement(By.id(attributeId));
		
		element.sendKeys(value);
		String attribute = element.getAttribute("value");
		System.out.println(attribute);
		return element;
				
	}
	public   WebElement findElementByIdWithClick(String attributeId) {
		
		WebElement element = driver.findElement(By.id(attributeId));
		element.click();
		return element;
		
	}
	
	public  WebElement findElementByName(String attributeName) {
		WebElement element = driver.findElement(By.name(attributeName));
		return element;
		
	}
	public  WebElement findElementByNameWithSendKeys(String attributeName,String value) {
		WebElement element = driver.findElement(By.name(attributeName));
		element.sendKeys(value);
		return element;
		
	}
	public  WebElement findElementByNameWithClick(String attributeName) {
		WebElement element = driver.findElement(By.name(attributeName));
		element.click();
		return element;
		
	}
	public  WebElement findElementByClassName(String attributeName) {
		WebElement element = driver.findElement(By.className(attributeName));
		return element;
		
	}
	public  WebElement findElementByClassNameWithSendKeys(String attributeName,String value) {
		WebElement element = driver.findElement(By.className(attributeName));
		element.sendKeys(value);
		return element;
		
	}
	public  WebElement findElementByClassNameWithClick(String attributeName) {
		WebElement element = driver.findElement(By.className(attributeName));
		element.click();
		return element;
		
	}

	public  WebElement findElementByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
		
	}
//Locators
	public static  String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		
		
		
	 return attribute;
	}
	public  String getText(WebElement element) {
		
  String text = element.getText();
  return text;
	}
	public  String getTagName(WebElement element) {

		String tagName = element.getTagName();
		return tagName;
		
	}
	public   void click(WebElement element) {

		  element.click();
		
	}
	public static void clear(WebElement element) {
		element.clear();
	}
	
	public   void sendKeys(WebElement element,String value) {
		element.sendKeys(value);

	}
//select	
	public  void selectByIndex(WebElement element,int index) {
   Select select= new  Select(element);
   select.selectByIndex(index);
	}
	public   void selectByValue(WebElement element,String value) {
	    Select select= new  Select(element);
	    select.selectByValue(value);

	}
	public   void selectByVisibleText(WebElement element,String text) {
	    Select select= new  Select(element);
	    select.selectByVisibleText(text);

	}
	public   void deselectByVisibleText(WebElement element,String text) {

	    Select select= new  Select(element);
	    select.selectByVisibleText(text);
	
	}
	public   void deselectByValue(WebElement element,String value) {
	    Select select= new  Select(element);
	    select.deselectByValue(value);

	}
	public  static void deselectByIndex(WebElement element,int index) {
	    Select select= new  Select(element);
	    select.deselectByIndex(index);
		}
	
	public  List<WebElement> selectAllOptions(WebElement element) {
	    Select select= new  Select(element);
	    List<WebElement> options = select.getOptions();
	    return options;

	}
	public  List<WebElement> selectedOptions(WebElement element) {
	    Select select= new  Select(element);
	    List<WebElement> selectedOptions = select.getAllSelectedOptions();
		return selectedOptions;
	    
	    

	}
	public  WebElement firstSelectedOption(WebElement element) {
		Select select= new  Select(element);
		 WebElement firstOption = select.getFirstSelectedOption();
		return firstOption;
	
				
	}
	public  boolean isMultiple(WebElement element) {
		Select select= new  Select(element);
		 boolean multiple = select.isMultiple();
	return multiple;
	}
	public  List<WebElement> getAllSelectedOptions(WebElement element) {
		Select select= new  Select(element);
		List<WebElement> options = select.getAllSelectedOptions();
		return options;
	}
	public  static void deselectAll(WebElement element) {
		Select select= new  Select(element);
		select.deselectAll();
		
	}
//select	
//alert
	public   void alertAccept() {
    Alert alert=driver.switchTo().alert();
    alert.accept();
	}
	public   void alertDismiss() {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	public   void alertSendKeys(String values) {
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(values);
	}
//alert
//Actions
	public   void doubleClick() {
		Actions actions=new Actions(driver);
		actions.doubleClick();
	}
	public   void doubleClickElement(WebElement element) {
    Actions actions=new Actions(driver);
    actions.doubleClick(element);
    
	}
	
	public   void actionsClick() {
	     Actions actions=new Actions(driver);
	     actions.click();
	     
	}
	public   void actionsClickElement(WebElement element) {
		Actions actions=new Actions(driver);
		actions.click(element);
		
	}
	public   void actionClickAndHold(WebElement element) {
		Actions actions=new Actions(driver);
		actions.clickAndHold(element);
		
	}
	public   void actionContextClick(WebElement element) {
		Actions actions=new Actions(driver);
		actions.contextClick(element);
			
	}
	public   void actionsdragAndDrop(WebElement element,WebElement element2) {
		Actions actions=new Actions(driver);
		actions.dragAndDrop(element, element2);
	}
	
	public   void actionsClickAndHold(WebElement element) {
		Actions actions=new Actions(driver);
		actions.clickAndHold(element);
	}
	public   void actionsKeyDown(String key) {
		Actions actions=new Actions(driver);
		actions.keyDown(key);
	}
	
	public   void actionsKeyUp(String key) {
		Actions actions=new Actions(driver);
		actions.keyUp(key);
		
	}
	public   void actionsSendKeys(String value) {
		Actions actions=new Actions(driver);
		actions.sendKeys(value);
		
	}
//actions	
	
	
	
//Robot
	public   void keyPress(int keycode) throws AWTException {
  Robot robot=new Robot();
  robot.keyPress(keycode);
	}
	public   void keyRelese(int keycode) throws AWTException {
	 Robot robot=new Robot();
	 robot.keyRelease(keycode);
	}
//robot
//JS
	public   void jsSetAttribute(WebElement element,String data) {
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("arguements[0].setAttribute('value',"+data+")",element);
		
	}
	
	public  Object jsGetAttribute(WebElement element) {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		Object script = executor.executeScript("return arguements[0].getAttribute('value')",element);
		return script;
	}
	public   void jsClick(WebElement element) {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguements[0].click()",element);
	}
	public   void navigateBack() {
		driver.navigate().back();
			
	}
	public   void navigateForward() {
		driver.navigate().forward();
		
	}
	public   void navigateRefresh() {
		driver.navigate().refresh();;
		
	}
	public   void navigateToUrl(String url) {

		driver.navigate().to(url);
	}
//Navigation
	
//FindElements
	public  List<WebElement> findElenentsByid(String id) {
		List<WebElement> findElements = driver.findElements(By.id(id));
		return findElements;
	}
	public  List<WebElement> findElenentsByName(String name) {
		List<WebElement> findElements = driver.findElements(By.name(name));
		return findElements;
	}
	public  List<WebElement> findElenentsByClassName(String className) {
		List<WebElement> findElements = driver.findElements(By.className(className));
		return findElements;
	}
	public  List<WebElement> findElenentsByXpath(String xpath) {
		List<WebElement> findElements = driver.findElements(By.xpath(xpath));
		return findElements;
	}
	
	public  List<WebElement> findElenentsByTagName(String tagName) {
		List<WebElement> findElements = driver.findElements(By.tagName(tagName));
		return findElements;
	}
//FindElements

	
//ScreenShotts
	public  File getScreenShotAs(String fileName) throws IOException {
		
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		File file=new File("C:\\Users\\ELCOT\\eclipse-workspace\\MavenProject\\Excel Sheets"+fileName);
		FileUtils.copyDirectory(screenshotAs, file);
		
		
		return screenshotAs;
		
	}
	public  File getScreenShotAsElement(WebElement element,String fileName) throws IOException {
		
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		File file=new File("C:\\Users\\ELCOT\\eclipse-workspace\\MavenProject\\Excel Sheets"+fileName);
		FileUtils.copyFile(screenshotAs, file);
		
		return screenshotAs;
		
	}
//frames
	public   void switchToFrameByIndex(int index) {
    driver.switchTo().frame(index);
	}
	
	public   void switchToFrameByElement(WebElement element) {
	 driver.switchTo().frame(element);

	}
	
	public   void switchToFrameByNameAndId(String url) {
		driver.switchTo().frame(url);
	}
	public   void defaultContent() {
		driver.switchTo().defaultContent();
		
	}
	
	public  void parentFrame() {
		driver.switchTo().parentFrame();
	}
	public   void switchToWindowByUrl(String url) {
		driver.switchTo().window(url);
		
	}
public  String getWindowHandle() {

	 String handle = driver.getWindowHandle();
	 
	 return handle;
	 
}
public  Set<String> getWindowHandles() {
  Set<String> Handles = driver.getWindowHandles();
  
  return Handles;
}
	public   void fileCreate(String pathname) throws IOException {
   File file=new File(pathname);
   file.createNewFile();
   //FileInputStream stream=new FileInputStream(file);
	}

		
	public static  void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
			
	}
	public   void aletIsPresent(int seconds) {
		driverWait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		driverWait.until(ExpectedConditions.alertIsPresent());	
	}
	public   void elementToBeClickable(WebElement element,int seconds) {
		driverWait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		driverWait.until(ExpectedConditions.elementToBeClickable(element));	
	}
	public   void elementToBeSelected(WebElement element,int seconds) {
		driverWait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		driverWait.until(ExpectedConditions.elementToBeSelected(element));	
	}
	public   void visibliyOfAllElement(WebElement element,int seconds) {
		driverWait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		driverWait.until(ExpectedConditions.visibilityOfAllElements(element));	
	}
//	public static static void explicitVisibliyOfElementToBeSelected(WebElement element,int seconds,String value ) {
//		driverWait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
//		driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((value)));	
//	}
	public   void visibliyOfElementLocated(WebElement element,int seconds) {
		driverWait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated((By) element));	
	}
	public   void presenceOfElementLocated(WebElement element,int seconds) {
		driverWait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		driverWait.until(ExpectedConditions.presenceOfElementLocated((By) element));	
	}
	public   void tresenceOfElementLocatedBy(WebElement element,int seconds) {
		driverWait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) element));	
	}
	
	public   void textToBeBePresentInElement(WebElement element,int seconds,String text) {
		driverWait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		driverWait.until(ExpectedConditions.textToBePresentInElement(element, text));	
	}
	public   void textToBeBePresentInElementValue(WebElement element,int seconds,String value) {
		driverWait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		driverWait.until(ExpectedConditions.textToBePresentInElementValue(element, value));	
	}
	public  Boolean titleIs(WebElement element,int seconds,String value) {
		driverWait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		Boolean until = driverWait.until(ExpectedConditions.titleIs(value));
		return until;
	}
	public   void titleConains(int seconds,String value) {
		driverWait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		driverWait.until(ExpectedConditions.titleContains(value));
			
	}
	public   void textToBePresentInElementLocated(WebElement element,int seconds,String text) {
		driverWait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		driverWait.until(ExpectedConditions.textToBePresentInElementLocated((By) element, text));
		
	}
	public   void visiblityOf(WebElement element,int seconds) {
		driverWait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		driverWait.until(ExpectedConditions.visibilityOf(element));
		
	}
//	public static static void frameToBeAvailableAndSwitchToIt(WebElement element,int seconds,String name,int id) {
//		driverWait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
//		switch (driverWait.equals()) {
//		
//		case element:
//			WebDriver until = driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
//
//			break;
//		case name:
//			WebDriver until2 = driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name));
//
//			break;
//		case id:
//			WebDriver until3 = driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
//
//			break;
//		default:
//			break;
//		}
//insert data
	public  String readData(String sheetName,int rowNo,int cellNo) throws IOException {
		String s=null;
		File  file=new  File("C:\\Users\\ELCOT\\eclipse-workspace\\MavenProject\\Excel Sheets\\adactiin.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		System.out.println(workbook);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			s= cell.getStringCellValue();
			
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date value2 = cell.getDateCellValue();
				SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MMM/yyyy");
				s = dateFormat.format(value2);
				
				
				
				
			} else {
				double cellValue = cell.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf(cellValue);
				s = valueOf.toString();

			}
			break;
		default:
			break;
		}
		
		return s;
				
		
	}
		
	public   void updateData(String sheetName,int rowNo,int cellNo,String oldData,String newData) throws IOException {
		
		File  file=new  File("C:\\Users\\ELCOT\\eclipse-workspace\\MavenProject\\Excel Sheets\\vino.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		System.out.println(workbook);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String value = cell.getStringCellValue();
		if (value.equals(oldData)) {
			cell.setCellValue(newData);
			
		}
		FileOutputStream out=new FileOutputStream(file);
		workbook.write(out);
				
		
	//	Cell cell = row.getCell(cellNo);
	//	CellType cellType = cell.getCellType();	
		
	}
	
	public   void writeData(String sheetName,int rowNo,int cellNo,String data) throws IOException {
		
		File  file=new  File("C:\\Users\\ELCOT\\eclipse-workspace\\MavenProject\\Excel Sheets\\adactiin.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		System.out.println(workbook);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(data);
		
		
		FileOutputStream out=new FileOutputStream(file);
		workbook.write(out);
				
		
	//	Cell cell = row.getCell(cellNo);
	//	CellType cellType = cell.getCellType();	
		
	}
	public   void writeMultipledata(String sheetname,WebElement element) throws IOException {

	
		
		
		
		File file=new File("C:\\Users\\ELCOT\\eclipse-workspace\\MavenProject\\Excel Sheets\\adactinHotel.xlsx");

	    
		FileInputStream stream =new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		System.out.println(workbook);

		Sheet sheet = workbook.getSheet("a");
	
		
   		
		
		Select select=new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i <options.size(); i++) {
			WebElement element2 = options.get(i);
			String text = element2.getText();


			for (int k = 0; k < sheet.getPhysicalNumberOfRows(); i++) {
				
				Row row = sheet.getRow(i);
				
				for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
					Cell cell = row.getCell(j);
					cell.setCellValue(text);
					CellType cellType = cell.getCellType();
					switch (cellType) {
					case STRING:
						cell.getStringCellValue();
						
						break;
					case NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							Date dateCellValue = cell.getDateCellValue();
							SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MMM-yyyy");
							dateFormat.format(dateCellValue);
							
						} else {

						
						double value2 = cell.getNumericCellValue();
						BigDecimal valueOf = BigDecimal.valueOf(value2);
						valueOf.toString();
						}
					default:
						break;
					}
					
					
				}
				
			}
			
		}


		FileOutputStream out =new FileOutputStream(file);
      workbook.write(out);
      
			
		    
			
		}
	public static void close() {
			driver.quit();
	}
	
	}
	
	
	


