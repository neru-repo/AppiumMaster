package wikiAutomation.AppiumBeginners;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;




public class LongPress extends BaseTestClass {
	
	@Test
	public void LongPressGesture() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();
		RemoteWebElement ele = (RemoteWebElement) driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(ele);
		
		Thread.sleep(2000);
		
	}

}
