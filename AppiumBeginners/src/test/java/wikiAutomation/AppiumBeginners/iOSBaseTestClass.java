package wikiAutomation.AppiumBeginners;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class iOSBaseTestClass {

	public IOSDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws MalformedURLException {

		// Start Appium Server Using Code. The AppiumJS is a file and we give the path of appium main file. IP address and Ports are constant
		service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium/build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		// starts the server
		service.start();

		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 13 Pro");
		//options.setApp("//Users//vignesh//Desktop//UIKitCatalog.app");
		//options.setApp("//Users//vignesh//git//AppiumCode//AppiumBeginners//src//test//java//resources//TestApp 3.app");
		options.setPlatformVersion("17.2");
		// this is for WebdriverAgent to kick started
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));	
		
		// initialize iOS drivers
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	public void touchAndHold(WebElement ele) {
		Map<String, Object> params = new HashMap<>();
		params.put("element", ((RemoteWebElement) ele).getId());
		params.put("duration", 5);
		driver.executeScript("mobile: touchAndHold", params);
	}
	
	public void scroll(WebElement ele) {
		Map<String, Object> params = new HashMap<>();
		params.put("element", ((RemoteWebElement) ele).getId());
		params.put("direction", "down");
		driver.executeScript("mobile: scroll", params);
	}

	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
