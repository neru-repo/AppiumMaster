package wikiAutomation.AppiumBeginners;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AlertsAssignment extends BaseTestClass {
	
//	@Test
//	public void okCancelDialogWithMessage() {
//		driver.findElement(AppiumBy.accessibilityId("App")).click();
//		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
//		driver.findElement(By.id("io.appium.android.apis:id/two_buttons")).click();
//		String alert_message = driver.findElement(By.id("android:id/alertTitle")).getText();
//		System.out.println(alert_message);
//		String ok_button = driver.findElement(By.id("android:id/button1")).getText();
//		String cancel_button = driver.findElement(By.id("android:id/button2")).getText();
//		System.out.printf("The available buttons are: ", ok_button + "and ", cancel_button);
//		driver.findElement(By.id("android:id/button1")).click();
//		
//	}
//	
//	@Test
//	public void okCancelDialogWithUltraLongMessage() throws InterruptedException {
//		driver.findElement(AppiumBy.accessibilityId("App")).click();
//		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
//		driver.findElement(By.id("io.appium.android.apis:id/two_buttons2ultra")).click();
//		String alert_message = driver.findElement(By.id("android:id/message")).getText();
//		System.out.println(alert_message);
//		driver.findElement(By.id("android:id/message")).click();
//		scrollWithoutTargetElement("android:id/message");
//		Thread.sleep(2000);
//		String ok_button = driver.findElement(By.id("android:id/button1")).getText();
//		String cancel_button = driver.findElement(By.id("android:id/button2")).getText();
//		System.out.println(ok_button);
//		System.out.println(cancel_button);
//		driver.findElement(By.id("android:id/button1")).click();
//	}
	
//	@Test
//	public void listDialog() throws InterruptedException {
//		driver.findElement(AppiumBy.accessibilityId("App")).click();
//		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
//		driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
//		String alert_title = driver.findElement(By.id("android:id/alertTitle")).getText();
//		String command_one = driver.findElement(By.xpath("//android.widget.TextView[@text='Command one']")).getText();
//		String command_two = driver.findElement(By.xpath("//android.widget.TextView[@text='Command two']")).getText();
//		String command_three = driver.findElement(By.xpath("//android.widget.TextView[@text='Command three']")).getText();
//		String command_four = driver.findElement(By.xpath("//android.widget.TextView[@text='Command four']")).getText();
//		System.out.println(alert_title);
//		System.out.println(command_one);
//		System.out.println(command_two);
//		System.out.println(command_three);
//		System.out.println(command_four);
//		driver.findElement(By.xpath("//android.widget.TextView[@text='Command four']")).click();
//		String message = driver.findElement(By.id("android:id/message")).getText();
//		System.out.println(message);
//	}
	
	@Test
	
	public void singleChoiceList() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		String alert_title = driver.findElement(By.id("android:id/alertTitle")).getText();
		String map = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Map']")).getText();
		String satellite = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Satellite']")).getText();
		String traffic = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Traffic']")).getText();
		String street_view = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Street view']")).getText();
		System.out.println(alert_title);
		System.out.println(map);
		System.out.println(satellite);
		System.out.println(traffic);
		System.out.println(street_view);
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Satellite']")).click();
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(2000);
	}

}
