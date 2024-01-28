package wikiAutomation.AppiumBeginners;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class iOSLongPress extends iOSBaseTestClass {
	
	@Test
	
	public void longPressTest() {
		
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Steppers'")).click();
		WebElement ele = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'Increment'`][3]"));
		touchAndHold(ele);
	}

}
