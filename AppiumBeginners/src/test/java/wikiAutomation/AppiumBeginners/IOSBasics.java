package wikiAutomation.AppiumBeginners;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends iOSBaseTestClass {
	
	@Test
	
	public void iOSBasicTest() {
		
		// iOS locators - xpath, className, IOSPredicateString, iOSClassChain, accessibility id, id
		
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == 'Text Entry'`]")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeAlert[`name == 'A Short Title Is Best'`]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]")).sendKeys("Harry");
		driver.findElement(AppiumBy.accessibilityId("OK")).click();
		
		// IOSPredicateString uses any matching string
		// we can concatenate multiple matching strings using AND
		// regex like BEGINSWITH and ENDSWITH can be used. BEGINSWITH[c]/ENDSWITH[c] makes it case-sensitive
		
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Confirm / Cancel'")).click();
//		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel'")).click();
//		driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'Confirm'")).click();
		String alert_message = driver.findElement(AppiumBy.iOSNsPredicateString("value CONTAINS 'A message'")).getText();
		System.out.println(alert_message);
		assertEquals(alert_message, "A message should be a short, complete sentence.");
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Cancel'")).click();
		
	}

}
