package wikiAutomation.AppiumBeginners;


import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class Scrolling extends BaseTestClass {
	
	@Test
	public void ScrollingTest() throws InterruptedException {
			
			driver.findElement(AppiumBy.accessibilityId("Views")).click();
			scrollWithTargetElement("WebView");
			//scrollWithoutTargetElement("Secure View");
		
		}
	

}
