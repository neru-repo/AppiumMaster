package wikiAutomation.AppiumBeginners;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.SupportsContextSwitching;

public class ECom_TestCase_3 extends BaseTestClass {

	@Test

	public void totalCartAmount() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));")).click();
		driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("VG");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String xpath_for_products = "(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[X]";
		for (int i = 1; i < 3; i ++) {
			xpath_for_products = xpath_for_products.replace("X", String.valueOf(i));
			driver.findElement(By.xpath(xpath_for_products)).click();
			xpath_for_products = "(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[X]";
		}
		String xpath_for_price = "(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice'])[X]";
		float total = 0;
		for (int i = 1; i < 3; i ++) {
			xpath_for_price = xpath_for_price.replace("X", String.valueOf(i));
			String price = driver.findElement(By.xpath(xpath_for_price)).getText();
			price = price.replace("$", "");
			total += Double.valueOf(price);
			price = "";
			xpath_for_price = "(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice'])[X]";
		}
		System.out.println(total);
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text" , "Cart"));
		String totalCartAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		totalCartAmount = totalCartAmount.replace("$", "");
		totalCartAmount = totalCartAmount.trim();
		System.out.println(totalCartAmount);
		assertEquals(totalCartAmount, String.valueOf(total));
		WebElement terms = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(terms);
		driver.findElement(By.xpath("//android.widget.Button[@text='CLOSE']")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(20000);

		Set<String> contexts = ((SupportsContextSwitching) driver).getContextHandles();
		for (String contextName : contexts) {
			System.out.println(contextName);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Harry Potter");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		// Comment added to create merge conflict

	}

}
