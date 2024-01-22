package wikiAutomation.AppiumBeginners;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class LandscapeAndOtherMiscellaneousActions extends BaseTestClass {
	
	@Test
	public void WifiSettingsName() {
		// to find app package name and activity - open the specific page in the emulator
		// and execute the command in terminal 
		// adb shell dumpsys window | grep -E 'mCurrentFocus'
		// following line is for opening a specific activity from the app package
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		driver.findElement(By.id("android:id/checkbox")).click();
		
		// to change the device orientation to landscape
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String popupTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(popupTitle);
		assertEquals("WiFi settings", popupTitle);
		
		// Clipboard testing, where the text copied in clipboard is being used for sendkeys
		driver.setClipboardText("Airtel_Air_Connect");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		// KeyPress events
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

		
		
	}

}
