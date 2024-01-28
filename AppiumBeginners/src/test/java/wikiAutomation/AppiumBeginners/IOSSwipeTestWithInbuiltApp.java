package wikiAutomation.AppiumBeginners;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSSwipeTestWithInbuiltApp extends iOSBaseTestClass { 
	
	@Test
	
	public void swipeTestWithInBuiltApp() throws InterruptedException {
		Map<String, String> params = new HashMap<>();
		params.put("bundleId", "com.apple.mobileslideshow");
		driver.executeScript("mobile: launchApp", params);
		Thread.sleep(2000);
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'All Photos'")).click();
		List<WebElement> all_photos = driver.findElements(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeCell' AND name CONTAINS 'Photo'"));
		System.out.println(all_photos.size());
		driver.findElement(By.xpath("//XCUIElementTypeCell[1]")).click();
		for (int i = 1; i < all_photos.size(); i++) {
			System.out.println(driver.findElement(By.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));
			Map<String, String> params1 = new HashMap<>();
			params1.put("direction", "left");
			// When element is not given, iOS automatically swipes from the center of the page
			//params1.put(((RemoteWebElement) ele).getId(), "");
			driver.executeScript("mobile: swipe", params1);
		}
		
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'All Photos'")).click();
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Albums'")).click();
	
	}

}
