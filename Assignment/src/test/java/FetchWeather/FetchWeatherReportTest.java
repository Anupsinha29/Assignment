package FetchWeather;
import org.testng.annotations.Test;

import Utility.BaseClass;
import objectRepository.PageObjectModel;

public class FetchWeatherReportTest extends BaseClass {
	@Test
	public void fetchWeatherReportTest()
	{
		String city1 = excelUtilty.getDataFormatExcel(1, 0, "City");
		String city2 = excelUtilty.getDataFormatExcel(2, 0, "City");
		PageObjectModel weatherPage=new PageObjectModel(driver);
		weatherPage.enterCityName(city1);
		weatherPage.selectTheCityName(city1);
		String celsiusString = weatherPage.getTheValuesInCelsius(city1);
		String[] celsiusArr = celsiusString.split("℃");
		String celsiusValue=celsiusArr[0];
		double celsiusDouble = javaUtility.stringToDouble(celsiusValue);
		String farenheitString = weatherPage.getValuesInFarenheit(city1);
		String[] farenheitArr = farenheitString.split("℉");
		String farenheitValue=farenheitArr[0];
		double farenheitDouble = javaUtility.stringToDouble(farenheitValue);
		weatherPage.enterCityName(city2);
		weatherPage.selectTheCityName(city2);
		String celsiusString1 = weatherPage.getTheValuesInCelsius(city2);
		String[] celsiusArr1 = celsiusString1.split("℃");
		String celsiusValue1=celsiusArr1[0];
		double celsiusDouble1 = javaUtility.stringToDouble(celsiusValue1);
		String farenheitString1 = weatherPage.getValuesInFarenheit(city2);
		String[] farenheitArr1 = farenheitString1.split("℉");
		String farenheitValue1=farenheitArr1[0];
		double farenheitDouble1 = javaUtility.stringToDouble(farenheitValue1);

		System.out.println("The value of weather in "+city1+" in celsius is "+celsiusDouble);
		System.out.println("The value of weather in "+city1+" in farenheit is "+farenheitDouble);

		System.out.println("The value of weather in "+city2+" in celsius is "+celsiusDouble1);
		System.out.println("The value of weather in "+city2+" in farenheit is "+farenheitDouble1);
		

	}



}
