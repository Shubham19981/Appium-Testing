package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;

public class DriverManager {
    public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    public AppiumDriver getDriver() {
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2) {
        driver.set(driver2);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;
        GlobalParams params = new GlobalParams();
        PropertyManager props = new PropertyManager();

        if (driver == null) {
            try {
                utils.log().info("Initializing Appium driver");
                switch (params.getPlatformName()) {
                    case "Android":
                        driver = new AndroidDriver(new ServerManager().getServer().getUrl(),
                                new CapabilitiesManager().getCaps());
                        break;
                    case "iOS":
                        driver = new IOSDriver(new ServerManager().getServer().getUrl(),
                                new CapabilitiesManager().getCaps());
                        break;
                    default:
                        throw new Exception("Platform not supported: " + params.getPlatformName());
                }

                if (driver == null) {
                    throw new Exception("Driver is null. ABORT!!!");
                }

                utils.log().info("Driver is initialized");
                this.driver.set(driver);
            } catch (IOException e) {
                utils.log().fatal("Driver initialization failure due to IOException: " + e.getMessage());
                throw e;
            } catch (Exception e) {
                utils.log().fatal("Driver initialization failure. ABORT !!!!" + e.toString());
                throw e;
            }
        }
    }

//    public void quitDriver() {
//        if (driver.get() != null) {
//            driver.get().quit();
//            driver.remove();
//            utils.log().info("Driver has been quit and removed");
//        }
//    }
}
