package wikiAutomation.AppiumBeginners;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSSlider extends iOSBaseTestClass {
	
	@Test
	
	public void iOSSlideTest () throws InterruptedException {
		WebElement slider = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == \"AppElem\"`]"));
		slider.sendKeys("0%");
		Thread.sleep(2000);
		assertEquals(slider.getAttribute("value"), "0%");
		
		slider.sendKeys("1%");
		Thread.sleep(2000);
		assertEquals(slider.getAttribute("value"), "100%");
		
	}

}
