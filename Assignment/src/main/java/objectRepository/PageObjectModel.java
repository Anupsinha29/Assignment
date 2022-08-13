package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectModel {
	public WebDriver driver;
	@FindBy(xpath="//input[@id='searchBox']")
	private WebElement searchBox;
	
	private String cityName="//label[contains(.,'%s')]";
	private String celsius="//div[contains(.,'%s')]/child::div/span[@class='tempRedText']";
	private String farenheit="//div[contains(.,'%s')]/ancestor::div[@class=\"outerContainer\"]//div[@class='temperatureContainer']/span[@class='tempWhiteText']";
	public PageObjectModel(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;

	}
	
	//business library
	
	public WebElement convertDynamicXpathToWebElement(String elementPartialXpath,String replaceData)
	{
		String xpath=String.format(elementPartialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}

	public void selectTheCityName(String replaceData) {
		WebElement city = convertDynamicXpathToWebElement(cityName, replaceData);
		city.click();
	}
	public void enterCityName(String city)
	{
		searchBox.clear();
		searchBox.sendKeys(city);
	}
	public String getTheValuesInCelsius(String replaceData)
	{
		WebElement celsiusValue=convertDynamicXpathToWebElement(celsius, replaceData);
			return	celsiusValue.getText().trim();
	}
	public String getValuesInFarenheit(String replaceData)
	{
		WebElement farenheitValue = convertDynamicXpathToWebElement(farenheit, replaceData);
		return farenheitValue.getText().trim();
	}
	
}
