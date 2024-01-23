package wikiAutomation.AppiumBeginners;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragAndDrop extends BaseTestClass{

@Test

	public void DragAndDropTest() {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement drag_point = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) drag_point).getId(),
			    "endX", 831,
			    "endY", 747
			));
		String after_drop = driver.findElement(By.xpath("//android.widget.TextView[@text='Dropped!']")).getText();
		System.out.println(after_drop);
		assertEquals(after_drop, "Dropped!");

	}

}
