package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;

public class DriverManager {
    public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    // Get the current driver
    public AppiumDriver getDriver() {
        if (driver.get() != null) {
            utils.log().info("Driver is running and not null.");
        } else {
            utils.log().warn("Driver is not initialized or is null.");
        }
        return driver.get();
    }

    // Set the driver
    public void setDriver(AppiumDriver driver2) {
        if (driver2 != null) {
            driver.set(driver2);
            utils.log().info("Driver has been set successfully.");
        } else {
            utils.log().warn("Attempted to set a null driver.");
        }
    }

    // Initialize the driver based on platform
    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;
        GlobalParams params = new GlobalParams();
        PropertyManager props = new PropertyManager();

        if (driver == null) {
            try {
                utils.log().info("Initializing Appium driver");

                switch (params.getPlatformName()) {
                    case "Android":
                        utils.log().info("Initializing Android driver...");
                        driver = new AndroidDriver(new ServerManager().getServer().getUrl(),
                                new CapabilitiesManager().getCaps());
                        break;
                    case "iOS":
                        utils.log().info("Initializing iOS driver...");
                        driver = new IOSDriver(new ServerManager().getServer().getUrl(),
                                new CapabilitiesManager().getCaps());
                        break;
                    default:
                        throw new Exception("Platform not supported: " + params.getPlatformName());
                }

                if (driver == null) {
                    utils.log().fatal("Driver initialization failed. Driver is null.");
                    throw new Exception("Driver is null. ABORT!!!");
                }

                // Log successful driver initialization
                utils.log().info("Driver is initialized successfully.");
                this.driver.set(driver);

            } catch (IOException e) {
                utils.log().fatal("Driver initialization failure due to IOException: " + e.getMessage());
                throw e;
            } catch (Exception e) {
                utils.log().fatal("Driver initialization failure. ABORT !!!!" + e.toString());
                throw e;
            }
        } else {
            utils.log().warn("Driver already initialized.");
        }
    }

    // Uncomment this method if you want to quit the driver and log the action
//    public void quitDriver() {
//        if (driver.get() != null) {
//            driver.get().quit();
//            driver.remove();
//            utils.log().info("Driver has been quit and removed");
//        } else {
//            utils.log().warn("Attempted to quit a null driver.");
//        }
//    }
}
