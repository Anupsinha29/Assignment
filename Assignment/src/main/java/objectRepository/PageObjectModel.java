package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjectModel {
	@FindBy(xpath="//input[@id='searchBox']")
	private WebElement searchBox;
	

}
