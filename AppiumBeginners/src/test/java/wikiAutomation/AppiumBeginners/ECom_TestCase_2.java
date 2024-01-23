package wikiAutomation.AppiumBeginners;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ECom_TestCase_2 extends BaseTestClass {
	
	@Test
	
	public void addToCart() {
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));")).click();
		driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("VG");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		int product_size = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")).size();
		String xpath_for_products = "(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[X]";
		for (int i = 0; i <product_size; i++) {
			String product_name = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")).get(i).getText();
			if (product_name.equals("Jordan 6 Rings")) {
				xpath_for_products = xpath_for_products.replace("X", String.valueOf(i+1));
				driver.findElement(By.xpath(xpath_for_products)).click();
				break;
			}
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text" , "Cart"));
		String productName = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		assertEquals(productName, "Jordan 6 Rings");
	}
	

}
