package com.qa.stepdef;

import com.qa.utils.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Lead2StepDef {
    private static AppiumDriver driver;

    public Lead2StepDef() {
    }
    @Before
    public void setUp() throws Exception {
        DriverManager driverManager = new DriverManager();
        driverManager.initializeDriver();
        this.driver = driverManager.getDriver();
    }
        @When("I click on the Lead II ECG")
        public void iClickOnTheLeadIIECG(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement lead2Ecg = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.xpath("(//android.widget.FrameLayout[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/ecg_test_option_card_view'])[11]/android.view.ViewGroup")
            ));
            lead2Ecg.click();
            System.out.println("Lead 2 ECG is clicked");
//        try {
//            Thread.sleep(200); // 2 milliseconds
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        }


        @Then("I should be on Lead II ECG Test Page")
        public void iShouldBeOnLeadIIECGTestPage() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement pageText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath("//android.widget.TextView[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/new_detail_fragment_test_name_text']")
            ));
            assert pageText.isDisplayed();
            System.out.println("We are in Lead II ECG Test Page");
//        try {
//            Thread.sleep(200); // 2 milliseconds
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        }

        @When("I click on Start_Test_button")
        public void iClickOnStart_Test_button() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement lead2EcgTestButton = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.xpath("//android.view.ViewGroup[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/activity_ecg_test_start_test_button']")
            ));
            lead2EcgTestButton.click();
            System.out.println("Lead 2 ECG is clicked");
//        try {
//            Thread.sleep(200); // 2 milliseconds
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        }

        @Then("I should be on a blank screen")
        public void iShouldBeOnABlankScreen() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement pageText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath("//android.widget.TextView[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/buy_device_fragment_troubleshoot_text']")
            ));
            assert pageText.isDisplayed();
            System.out.println("We are on blank page");
//        try {
//            Thread.sleep(200); // 2 milliseconds
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        }

        @When("Device is connected")
        public void deviceIsConnected() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement dialogueText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/alertTitle']")
            ));
            assert dialogueText.isDisplayed();
            System.out.println("Device is Connected");
//        try {
//            Thread.sleep(200); // 2 milliseconds
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        }

        @And("I click on ok button")
        public void iClickOnOkButton() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.xpath("//android.widget.Button[@resource-id='android:id/button1']")
            ));
            okButton.click();
            System.out.println("Ok button is clicked");
//        try {
//            Thread.sleep(200); // 2 milliseconds
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        }

        @And("I click on Start Test")
        public void iClickOnStartTest() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.xpath("//android.view.ViewGroup[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/activity_ecg_test_start_test_button']")
            ));
            okButton.click();
            System.out.println("Start Test Button is clicked");
//        try {
//            Thread.sleep(200); // 2 milliseconds
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        }
    }

