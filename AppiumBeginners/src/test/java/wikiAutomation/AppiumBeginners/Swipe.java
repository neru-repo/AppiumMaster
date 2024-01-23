package wikiAutomation.AppiumBeginners;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Swipe extends BaseTestClass {

	@Test

	public void SwipingTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Gallery']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']")).click();
		WebElement ele = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "true");
		swipeAction(ele, "left", 0.1);
		assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "false");
		assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).getAttribute("focusable"), "true");
	}

}
