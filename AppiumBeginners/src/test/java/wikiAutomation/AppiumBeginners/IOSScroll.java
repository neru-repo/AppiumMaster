package wikiAutomation.AppiumBeginners;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSScroll extends iOSBaseTestClass {
	
	@Test
	
	public void iOSScrollTest() throws InterruptedException {
		
		WebElement ele = driver.findElement(AppiumBy.iOSNsPredicateString("name CONTAINS 'Web '"));
		scroll(ele);
		ele.click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'UIKitCatalog'`]")).click();
		String red_send = "80";
		String green_send = "220";
		String blue_send = "185";
		driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypePickerWheel' AND name CONTAINS 'Red'")).sendKeys(red_send);
		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypePickerWheel' AND name CONTAINS 'Green'")).sendKeys(green_send);
		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypePickerWheel' AND name CONTAINS 'Blue'")).sendKeys(blue_send);
		
		String red_get = driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypePickerWheel' AND name CONTAINS 'Red'")).getText();
		String green_get = driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypePickerWheel' AND name CONTAINS 'Green'")).getText();
		String blue_get = driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypePickerWheel' AND name CONTAINS 'Blue'")).getText();
		
		assertEquals(red_get, red_send);
		assertEquals(green_get, green_send);
		assertEquals(blue_get, blue_send);
	}

}
