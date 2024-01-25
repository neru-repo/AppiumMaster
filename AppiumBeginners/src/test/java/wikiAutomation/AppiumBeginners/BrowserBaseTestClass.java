package wikiAutomation.AppiumBeginners;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTestClass {

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
		options.setChromedriverExecutable("//Users//vignesh//Downloads//chromedriver_113//chromedriver");
		options.setCapability("browserName", "Chrome");
		//options.setApp("//Users//vignesh//git//AppiumCode//AppiumBeginners//src//test//java//resources//General-Store.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

		@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
