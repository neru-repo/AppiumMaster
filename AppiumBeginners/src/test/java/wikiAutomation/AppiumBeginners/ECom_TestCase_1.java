package wikiAutomation.AppiumBeginners;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;


public class ECom_TestCase_1 extends BaseTestClass {

	@Test(priority=0)

	public void fillFormWithoutName() {
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));")).click();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toast_message = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		assertEquals(toast_message, "Please enter your name");

	}


	@Test(priority=1)

	public void fillForm() throws InterruptedException {

		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));")).click();
		String name_header = driver.findElement(By.xpath("//android.widget.TextView[@text='Your Name']")).getText();
		assertEquals(name_header, "Your Name");
		driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("VG");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);

	}

}
