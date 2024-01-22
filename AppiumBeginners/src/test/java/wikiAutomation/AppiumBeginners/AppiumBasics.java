package wikiAutomation.AppiumBeginners;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;


public class AppiumBasics extends BaseTestClass {
	
	@Test
	public void WifiSettingsName() {
		// different types of locators are
		// accessibilityId, id, xpath, className, androidUIAutomator
		// AppiumBy is used here because accessibilityId is a locator unique to appium
		// Sometimes className for appium shows error, so we use AppiumBy for className as well
		// Use AppiumBy for androidUIAutomator as well
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		// xpath usually follows //tagname[@attribute='value'] pattern
		// if no attribute value is present, then we can use //tagName 
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String popupTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(popupTitle);
		assertEquals("WiFi settings", popupTitle);
		driver.findElement(By.id("android:id/edit")).sendKeys("WiFi Name");
		driver.findElement(By.id("android:id/button1")).click();
		
	}

}
