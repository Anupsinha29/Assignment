package Utility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public	ExcelUtility excelUtilty;
	public	FileUtility fileUtility;
	public	JavaUtility javaUtility;
	public	WebDriverUtility webdriverUtility;
	public	String url;
	public	String browser;
	public	String timeout;
	public	long timeouts;
	public WebDriver driver;

	@BeforeClass
	public void classSetup() {
		excelUtilty=new ExcelUtility();
		fileUtility= new FileUtility();
		javaUtility= new JavaUtility();
		webdriverUtility=new WebDriverUtility();
		fileUtility.initiallizePropertyFile(IConstant.PROPERTYFILEPATH);
		excelUtilty.initiallizeExcelFile(IConstant.EXCELPATH);
		url = fileUtility.getDataFromProperty("url");
		browser = fileUtility.getDataFromProperty("browser");
		timeout = fileUtility.getDataFromProperty("timeout");
		timeouts = javaUtility.stringToLong(timeout);
		
	}
	@BeforeMethod
	public void methodSetup() {
		driver = webdriverUtility.setupDriver(browser);
		webdriverUtility.openApplication(url);
		webdriverUtility.maxmizeBrowser();
		webdriverUtility.implicitWait(timeouts);
	}
	@AfterMethod
	public void methodTearDown() {
		webdriverUtility.closeBrowser();
	}
	@AfterClass
	public void classTearDown() {
		
		excelUtilty.closeWorkbook();

	}
}
