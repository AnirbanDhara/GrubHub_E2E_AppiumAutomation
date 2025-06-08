package com.anirbandhara;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AppiumDriverLocalService serviceBuilder;
    public static AndroidDriver driver;

    @BeforeClass
    public void configureAppium() throws MalformedURLException, InterruptedException {
        // Code to start appium server automatically
        serviceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File("C://usr//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();
        serviceBuilder.start();

        // Set capabilities for Android emulator and app
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("emulator-5554") // or your emulator name from `adb devices`
                .setApp("C://Users//Anirban//Documents//UIAutomation//GrubHub_E2E_AppiumAutomation//src//test//resources//com.grubhub.android_v2022.41-202204100_Android-5.0.apk")
                .setAutomationName("UIAutomator2");
        options.setChromedriverExecutable("C://Users//Anirban//WebDrivers//chromedriver-win32_119//chromedriver.exe");

        // Connect to Appium server
        URL appiumServerUrl = new URL("http://127.0.0.1:4723");

        // Launch the app
        driver = new AndroidDriver(appiumServerUrl, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
//        ((JavascriptExecutor) driver).executeScript("mobile: startActivity",
//                ImmutableMap.of("intent", "com.grubhub.android" + "/" + "com.grubhub.dinerapp.android.sunburst.features.main.presentation.SunburstMainActivity"));
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
        serviceBuilder.close();
    }
}
