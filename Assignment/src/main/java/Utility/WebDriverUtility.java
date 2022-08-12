package Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility

{
		private WebDriver driver;
		
		

		/**
		 * This method is used to setup driver instance
		 * 
		 * @param browser
		 * @return
		 */
		public WebDriver setupDriver(String browser) {

			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;

			default:
				System.out.println("Entered wrong browser key in the Property file");

				break;
			}
			return driver;
		}

		/**
		 * This method is used to maximize the browser
		 */
		public void maxmizeBrowser() {
			driver.manage().window().maximize();
		}

		/**
		 * This method is used to wait the page by using Implicit wait
		 * 
		 * @param longTimeout
		 */
		public void implicitWait(long longTimeout) {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
		}

		/**
		 * This method is used to navigate the application
		 * 
		 * @param url
		 */
		public void openApplication(String url) {
			driver.get(url);

		}

		
		/**
		 * this method is used to close particular Browser
		 */
		public void closeBrowser() {
			driver.close();
		}

		

		

		

		

}
