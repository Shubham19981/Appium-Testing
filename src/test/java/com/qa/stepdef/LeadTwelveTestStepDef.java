package com.qa.stepdef;

import com.qa.utils.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LeadTwelveTestStepDef {
    private static AppiumDriver driver;

    public LeadTwelveTestStepDef() {
        // Reuse the existing driver initialized in LoginStepDef
        this.driver = DriverManager.getDriver();
    }

    @Given("I am on the dashboard screen")
    public void iAmOnTheDashboard() {
    }

    @When("I click on the Lead XII ECG")
    public void iClickOnTheLeadXIIECG() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lead12Ecg = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("(//android.widget.FrameLayout[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/ecg_test_option_card_view'])[11]/android.view.ViewGroup")
        ));
        lead12Ecg.click();
        System.out.println("Lead II ECG is clicked");
    }

    @Then("I should be on Lead II ECG Test Page")
    public void iShouldBeOnLeadXIIECGTestPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pageText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/new_detail_fragment_test_name_text']")
        ));
        assert pageText.isDisplayed();
        System.out.println("We are on Lead II ECG Test Page");
    }

    @When("I click on Start_Test_button in Lead XII ECG")
    public void iClickOnStart_Test_button_in_Lead_XII_ECG() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement startTestButton = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.view.ViewGroup[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/activity_ecg_test_start_test_button']")
        ));
        startTestButton.click();
        System.out.println("Start Test Button is clicked");
    }

    @Then("I should be on a blank screen in Lead XII ECG")
    public void iShouldBeOnABlankScreen_in_Lead_XII_ECG() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement blankScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/buy_device_fragment_troubleshoot_text']")
        ));
        assert blankScreen.isDisplayed();
        System.out.println("We are on a blank screen before the test starts");
    }

    @When("Device is connected  in Lead XII ECG")
    public void deviceIsConnected_in_Lead_XII_ECG() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement connectionAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/alertTitle']")
        ));
        assert connectionAlert.isDisplayed();
        System.out.println("Device is connected successfully");
    }

    @And("I click on ok button in Lead XII ECG")
    public void iClickOnOkButton_in_Lead_XII_ECG() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.Button[@resource-id='android:id/button1']")
        ));
        okButton.click();
        System.out.println("OK button is clicked");
    }

    @And("I click on Start Test  in Lead XII ECG")
    public void iClickOnStartTest_in_Lead_XII_ECG() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement startTestButton = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.view.ViewGroup[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/activity_ecg_test_start_test_button']")
        ));
        startTestButton.click();
        System.out.println("Start Test Button is clicked again to begin the test");
    }

    @Then("The ECG test should start successfully in Lead XII ECG")
    public void theECGTestShouldStartSuccessfully_in_Lead_XII_ECG() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement ecgGraph = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"in.sunfox.healthcare.spandanecg.debug:id/activity_ecg_test_root_constraint_layout\"]/android.view.View[5]")
        ));
        assert ecgGraph.isDisplayed();
        System.out.println("ECG test has started successfully, graph is visible");
    }

    @When("I click on the Get_Report_button in Lead XII ECG")
    public void iClickOnTheGetReportButton_in_Lead_XII_ECG() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait for the button to be clickable
        WebElement getReportButton = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.TextView[@resource-id=\"in.sunfox.healthcare.spandanecg.debug:id/activity_ecg_test_ecg_move_to_next_text_view\"]")
        ));

        // Ensure button is visible and enabled before clicking
        if (getReportButton.isDisplayed() && getReportButton.isEnabled()) {
            getReportButton.click();
            System.out.println("Get Report button clicked successfully.");
        } else {
            System.out.println("Get Report button is not clickable.");
        }
    }

    @Then("I should be on Report Page in Lead XII ECG")
    public void iShouldBeOnReportPage_in_Lead_XII_ECG() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement ecgGraph = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("in.sunfox.healthcare.spandanecg.debug:id/fragment_container_root_constraint_layout")
        ));
        assert ecgGraph.isDisplayed();
        System.out.println("ECG test has started successfully, graph is visible");
    }

    @Then("I click on the Save_Report_button in Lead XII ECG")
    public void i_click_on_the_save_report_button_in_Lead_XII_ECG() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement startTestButton = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.TextView[@resource-id=\"in.sunfox.healthcare.spandanecg.debug:id/activity_ecg_report_save_report_button_tv\"]")
        ));
        startTestButton.click();
        System.out.println("Start Test Button is clicked again to begin the test");
    }

    @And("I click on the Back Button in Lead XII ECG")
    public void i_click_on_the_back_button_in_Lead_XII_ECG() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement back_button = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.ImageView[@resource-id=\"in.sunfox.healthcare.spandanecg.debug:id/ecg_test_activity_action_bar_back_button\"]")
        ));
        back_button.click();
        System.out.println("Back button clicked successfully.");
    }

    @And("I click on the Go_Home_Button in Lead XII ECG")
    public void i_click_on_the_go_home_button_in_Lead_XII_ECG() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement go_home_button = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.Button[@resource-id=\"in.sunfox.healthcare.spandanecg.debug:id/dialog_delete_user_confirmation_negative\"]")
        ));
        go_home_button.click();
        System.out.println("Go Home Button clicked successfully.");
    }

//    @Then("I should be on Dashboard")
//    public void i_should_be_on_the_dashboard() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement dashboardText = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                AppiumBy.xpath("//android.widget.TextView[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/home_fragment_hello_text']")
//        ));
//        assert dashboardText.isDisplayed();
//        System.out.println("We are in the Dashboard");
//
//    }

    @Then("I should be on the Dashboard")
    public void iShouldBeOnTheDashboard_in_Lead_XII_ECG() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/home_fragment_hello_text']")
        ));
        assert dashboardText.isDisplayed();
        System.out.println("We are in the Dashboard");
    }
}
