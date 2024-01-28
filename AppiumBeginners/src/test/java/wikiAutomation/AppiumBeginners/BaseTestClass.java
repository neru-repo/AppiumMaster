package wikiAutomation.AppiumBeginners;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTestClass {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws MalformedURLException {

		// Start Appium Server Using Code. The AppiumJS is a file and we give the path of appium main file. IP address and Ports are constant
		service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium/build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		// starts the server
		//service.start();

		// This is used to set the Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel");
		// To run on a real device, give a generic device name like below
		//options.setDeviceName("Android Device");
		options.setApp("//Users//vignesh//git//AppiumCode//AppiumBeginners//src//test//java//resources//General-Store.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public void longPressAction(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId()),
				"duration", 4000);
	}

	public void scrollWithTargetElement(String tar_ele) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+tar_ele+"\"));"));
	}

	public void scrollWithoutTargetElement(String locator) {
		boolean canScrollMore;
		boolean ele_visible;

		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0
				));
			try {

				ele_visible = driver.findElement(By.xpath(locator)).isDisplayed();
				System.out.println(ele_visible);

			}

			catch(Exception e) {

				ele_visible = false;
			}

			if (ele_visible) {

				break;

			}

			else {

				continue;

			}


		} while(canScrollMore);
	}

	public void swipeAction(WebElement ele, String direction, double percent) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "direction", direction,
			    "percent", percent
			));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
