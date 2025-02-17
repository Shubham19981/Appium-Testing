package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;

public class DriverManager {
    public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    static TestUtils utils = new TestUtils();

    // Get the current driver
    public static AppiumDriver getDriver() {
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

    public void initializeDriver() throws Exception {
        if (driver.get() == null || !isDriverSessionActive(driver.get())) {
            try {
                utils.log().info("Initializing Appium driver");

                AppiumDriver driver = null;
                GlobalParams params = new GlobalParams();

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

    // Check if the driver session is active
    private boolean isDriverSessionActive(AppiumDriver driver) {
        try {
            // Just an example check, depending on the capabilities, you can adjust it
            return driver != null && driver.getSessionId() != null;
        } catch (Exception e) {
            return false;
        }
    }
}
