package com.qa.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {
    TestUtils utils = new TestUtils();

    public DesiredCapabilities getCaps() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        try{
            utils.log().info("getting capabilities");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", params.getPlatformName());
            caps.setCapability("udid", params.getUDID());
            caps.setCapability("deviceName", params.getDeviceName());
            caps.setCapability("noReset","false");
            
            switch(params.getPlatformName()){
                case "Android":
                    caps.setCapability("automationName", props.getProperty("androidAutomationName"));
                    caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
                    caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
                    caps.setCapability("systemPort", params.getSystemPort());
                    caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
                    caps.setCapability("automationName", "UiAutomator2");
                    caps.setCapability("androidInstallTimeout", 300000);

                    //String androidAppUrl = getClass().getResource(props.getProperty("androidAppLocation")).getFile();


// Construct the APK path relative to the Jenkins workspace
                    String androidAppUrl = File.separator + "root" + File.separator + ".jenkins" + File.separator + "workspace" + File.separator + "Test_Android" + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "apps" + File.separator + "app-debug.apk";

                    utils.log().info("appUrl is {}", androidAppUrl);

// Set the capability to use the dynamically resolved APK path
                    caps.setCapability("app", androidAppUrl);


                    break;
//                case "iOS":
//                    caps.setCapability("automationName", props.getProperty("iOSAutomationName"));
//                    //String iOSAppUrl = getClass().getResource(props.getProperty("iOSAppLocation")).getFile();
//                    String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
//                            + File.separator + "resources" + File.separator + "apps" + File.separator + "app-debug.apk";
//                    utils.log().info("appUrl is" + iOSAppUrl);
//                    caps.setCapability("bundleId", props.getProperty("iOSBundleId"));
//                    caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
//                    caps.setCapability("webkitDebugProxyPort", params.getWebkitDebugProxyPort());
//                    caps.setCapability("app", iOSAppUrl);
//                    break;
            }
            return caps;
        }
        catch(Exception e){
            e.printStackTrace();
            utils.log().fatal("Failed to load capabilities. ABORT!!{}", e.toString());
            throw e;
        }
    }
}
