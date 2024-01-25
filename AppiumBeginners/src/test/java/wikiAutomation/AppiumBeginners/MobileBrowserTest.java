package wikiAutomation.AppiumBeginners;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTestClass {
	
	@Test
	
	public void BrowserTest() {
		
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Harry Potter");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

}
