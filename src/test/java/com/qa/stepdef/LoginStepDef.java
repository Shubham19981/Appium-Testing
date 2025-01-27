package com.qa.stepdef;
import com.qa.utils.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.qa.utils.DriverManager.driver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

//import java.time.Duration;

public class LoginStepDef {
    private static AppiumDriver driver;

    public LoginStepDef() {
        // No-argument constructor required by Cucumber
    }

    @Before
    public void setUp() throws Exception {
        DriverManager driverManager = new DriverManager();
        driverManager.initializeDriver();
        this.driver = driverManager.getDriver();
    }
    @Given("I am on the language selection page")
    public void iAmOnTheLanguageSelectionPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement pageText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/tv_language_heading']")
        ));
        System.out.println("Checking if the Language Selection page is displayed");
        // Verify the element is displayed
        if (pageText.isDisplayed()) {
            System.out.println("Language Selection page is displayed successfully");
        } else {
            System.out.println("Language Selection page is not displayed");
            throw new AssertionError("Language Selection page not displayed");
        }
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I select the language as {string}")
    public void i_select_the_language_as(String language) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement languageCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.RadioButton[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/change_lang_rb_hindi']")
        ));

        // Check if the checkbox is selected
        if (!languageCheckbox.isSelected()) {
            // If not selected, click to select it
            languageCheckbox.click();
            System.out.println("Language  " + language + " is now selected.");
        } else {
            // If already selected, no action needed
            System.out.println("Language " + language + " is already selected.");
        }
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I click on the language_next_button")
    public void i_click_on_the_language_next_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.Button[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/btn_language_next']")
        ));
        button.click();
        System.out.println("language_next_button is clicked");
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I should be on the Select Use Case screen")
    public void iShouldBeOnTheSelectUseCaseScreen(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pageText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.view.ViewGroup")
        ));
        System.out.println("Checking if the Use Case screen is displayed");
        if (pageText.isDisplayed()) {
            System.out.println("Use Case screen is displayed successfully");
        } else {
            System.out.println("Use Case screen is not displayed");
            throw new AssertionError("Use Case screen not displayed");
        }
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I select the {string} radio button")
    public void i_select_the_radio_button(String useCase){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement useCaseCheckBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.RadioButton[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/user_case_clinical_personal']")
        ));
        useCaseCheckBox.click();
        System.out.println("Use Case " + useCase + " is selected.");
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @When("I click on the use_case_next_button")
    public void i_click_on_the_use_case_next_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.Button[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/btn_use_next']")
        ));
        button.click();
        System.out.println("use_case_next_button is clicked");
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I should be on the Instructions screen")
    public void iShouldBeOnTheInstructionsScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pageText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/pageTitle']")
        ));
        System.out.println("Checking if the Instruction page is displayed");
        // Verify the element is displayed
        if (pageText.isDisplayed()) {
            System.out.println("Instruction page is displayed successfully");
        } else {
            System.out.println("Instruction page is not displayed");
            throw new AssertionError("Instruction page not displayed");
        }
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @When("I click the instruction_next_button five times")
    public void iClickTheInstruction_next_buttonFiveTimes() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for(int repeat = 1; repeat <= 5; repeat++ ){
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.xpath("//android.widget.Button[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/btn_next']")
            ));
            button.click();
            System.out.println("Button clicked : "+ repeat );
        }
    }

    @Then("I should be on the Phone Number page")
    public void iShouldBeOnThePhoneNumberPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pageText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/tv_language_heading']")
        ));
        System.out.println("Checking if the Phone Number page is displayed");
        // Verify the element is displayed
        if (pageText.isDisplayed()) {
            System.out.println("Phone Number page is displayed successfully");
        } else {
            System.out.println("Phone Number page is not displayed");
            throw new AssertionError("Phone Number page not displayed");
        }
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I enter the phone number as {string}")
    public void i_enter_the_phone_number_as(String phoneNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.EditText[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/et_mobile_number']")
        ));
        phoneNumberField.sendKeys(phoneNumber);;
        System.out.println("Phone " + phoneNumber + " is entered");
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I click the checkbox")
    public void iClickTheCheckbox(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.CheckBox[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/checkbox_terms']")
        ));
        checkbox.click();
        System.out.println("Check box is clicked");
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I click on the Get_OTP_button")
    public void i_click_on_the_get_otp_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement getOtpButton = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.Button[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/btn_get_otp']")
        ));
        getOtpButton.click();
        System.out.println("Get OPT button is clicked");
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I should be on the OTP screen")
    public void iShouldBeOnTheOTPScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pageText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("(//android.widget.FrameLayout[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/nav_host_fragment'])[2]/android.view.ViewGroup")
        ));
        System.out.println("Checking if the OTP screen is displayed");
        // Verify the element is displayed
        if (pageText.isDisplayed()) {
            System.out.println("OTP screen is displayed successfully");
        } else {
            System.out.println("OTP screen is not displayed");
            throw new AssertionError("OTP screen not displayed");
        }
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @When("I enter {string} as the OTP")
    public void i_enter_as_the_opt(String otp) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement otpField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.EditText")
        ));
        otpField.sendKeys(otp);
        System.out.println("OTP : " + otp + " is entered");
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I click on the Verify_OTP_button")
    public void i_click_on_the_verify_otp_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement verifyOtpButton = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.Button[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/btn_verify_otp']")
        ));
        verifyOtpButton.click();
        System.out.println("Verify OPT button is clicked");
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I should be on Dashboard")
    public void i_should_be_on_dashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/home_fragment_hello_text']")
        ));
        assert dashboardText.isDisplayed();
        System.out.println("We are in Dashboard");
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I click on the Lead II ECG")
    public void iClickOnTheLeadIIECG(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lead2Ecg = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("(//android.widget.FrameLayout[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/ecg_test_option_card_view'])[11]/android.view.ViewGroup")
        ));
        lead2Ecg.click();
        System.out.println("Lead 2 ECG is clicked");
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Then("I should be on Lead II ECG Test Page")
    public void iShouldBeOnLeadIIECGTestPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pageText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/new_detail_fragment_test_name_text']")
        ));
        assert pageText.isDisplayed();
        System.out.println("We are in Lead II ECG Test Page");
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I click on Start_Test_button")
    public void iClickOnStart_Test_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lead2EcgTestButton = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.view.ViewGroup[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/activity_ecg_test_start_test_button']")
        ));
        lead2EcgTestButton.click();
        System.out.println("Lead 2 ECG is clicked");
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I should be on a blank screen")
    public void iShouldBeOnABlankScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pageText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/buy_device_fragment_troubleshoot_text']")
        ));
        assert pageText.isDisplayed();
        System.out.println("We are on blank page");
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("Device is connected")
    public void deviceIsConnected() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dialogueText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/alertTitle']")
        ));
        assert dialogueText.isDisplayed();
        System.out.println("Device is Connected");
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I click on ok button")
    public void iClickOnOkButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.Button[@resource-id='android:id/button1']")
        ));
        okButton.click();
        System.out.println("Ok button is clicked");
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I click on Start Test")
    public void iClickOnStartTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.view.ViewGroup[@resource-id='in.sunfox.healthcare.spandanecg.debug:id/activity_ecg_test_start_test_button']")
        ));
        okButton.click();
        System.out.println("Start Test Button is clicked");
        try {
            Thread.sleep(200); // 2 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
