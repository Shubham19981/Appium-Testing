package com.qa.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {

    @Given("I am on the {string} screen")
    public void i_am_on_the_screen(String screen) {
        // Code to verify user is on the specified screen
        if (screen.equals("Login")) {
            // Code to check that login screen is displayed
            checkScreenDisplayed("loginScreenTitle");
        } else if (screen.equals("Home")) {
            // Code to check that home screen is displayed
            checkScreenDisplayed("homeScreenTitle");
        }
        // Add additional screens as needed
    }

    @When("I select the language as {string}")
    public void i_select_the_language_as(String language) {
        // Code to select language from the language selector
        selectLanguage(language);
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String button) {
        // Code to click the specified button
        clickButton(button);
    }

    @When("I select the {string} radio button")
    public void iSelectTheRadioButton(String radioButton) {
        // Code to select the radio button based on input
        selectRadioButton(radioButton);
    }

    @When("I click the {string} button five times to proceed")
    public void i_click_the_button_five_times_to_proceed(String button) {
        // Code to click the specified button five times
        for (int i = 0; i < 5; i++) {
            clickButton(button);
        }
    }

    @When("I enter the phone number as {string}")
    public void i_enter_the_phone_number_as(String phoneNumber) {
        // Code to enter the phone number into the input field
        enterPhoneNumber(phoneNumber);
    }

    @When("I check the checkbox")
    public void i_check_the_checkbox() {
        // Code to check the OTP checkbox
        checkCheckbox();
    }

    @When("I click on the OTP button")
    public void i_click_on_the_otp_button() {
        // Code to click the OTP button to generate/send OTP
        clickOtpButton();
    }

    @Then("I should be on the {string} screen")
    public void i_should_be_on_the_screen(String screen) {
        // Code to verify that the user is on the expected screen
        if (screen.equals("Home")) {
            // Code to check that the home screen is displayed
            checkScreenDisplayed("homeScreenTitle");
        } else if (screen.equals("Login")) {
            // Code to check that the login screen is displayed
            checkScreenDisplayed("loginScreenTitle");
        }
        // Add additional screen checks as needed
    }

    @When("I enter {string} as the OTP")
    public void i_enter_as_the_otp(String otp) {
        // Code to enter the OTP in the OTP input field
        enterOtp(otp);
    }

    @When("I click on the verify OTP button")
    public void i_click_on_the_verify_otp_button() {
        // Code to click the verify OTP button
        clickVerifyOtpButton();
    }

    @Then("I should {string}")
    public void i_should(String outcome) {
        // Code to handle different outcomes after verifying OTP
        if (outcome.equals("success")) {
            // Code to check if logged in
            checkLoggedIn();
        } else if (outcome.equals("failure")) {
            // Code to check if error message is displayed
            checkErrorMessageDisplayed();
        }
    }

    @Then("I should \"see an error message \"Otp not verified\"\"")
    public void iShouldSeeAnErrorMessageInvalidOTP() {
        // Code to verify the error message "Invalid OTP"
        checkErrorMessageDisplayed("Otp not verified");
    }

    // Helper Methods
    private void checkScreenDisplayed(String screenTitle) {
        // Code to check if the specified screen is displayed (replace with actual code)
        findElementAndVerify(screenTitle);
    }

    private void selectLanguage(String language) {
        // Example code for selecting a language
        switch (language.toLowerCase()) {
            case "english":
                clickButton("languageEnglish");
                break;
            case "spanish":
                clickButton("languageSpanish");
                break;
            case "french":
                clickButton("languageFrench");
                break;
            default:
                throw new IllegalArgumentException("Language not supported");
        }
    }

    private void clickButton(String button) {
        // Code to click a button
        findElementAndClick(button);
    }

    private void selectRadioButton(String radioButton) {
        // Code to select a radio button based on its label
        findElementAndClick(radioButton);
    }

    private void enterPhoneNumber(String phoneNumber) {
        // Code to enter the phone number in the text field
        findElementAndEnterText("phoneNumberField", phoneNumber);
    }

    private void checkCheckbox() {
        // Code to check a checkbox (e.g., OTP checkbox)
        findElementAndClick("otpCheckbox");
    }

    private void clickOtpButton() {
        // Code to click the OTP button
        findElementAndClick("otpButton");
    }

    private void enterOtp(String otp) {
        // Code to enter OTP
        findElementAndEnterText("otpField", otp);
    }

    private void clickVerifyOtpButton() {
        // Code to click the verify OTP button
        findElementAndClick("verifyOtpButton");
    }

    private void checkLoggedIn() {
        // Code to check if the user is logged in (e.g., check for a logged-in element)
        findElementAndVerify("logoutButton");
    }

    private void checkErrorMessageDisplayed() {
        // Code to check if error message is displayed (e.g., for failed OTP)
        findElementAndVerify("Otp not verified");
    }

    private void checkErrorMessageDisplayed(String message) {
        // Code to check if specific error message is displayed
        String errorMessage = getElementText("Otp not verified");
        if (!errorMessage.equals(message)) {
            throw new RuntimeException("Error message does not match. Expected: " + message + ", Found: " + errorMessage);
        }
    }

    // Mock helper methods (these should be implemented using Appium or your UI automation framework)
    private void findElementAndVerify(String elementId) {
        // Example: verify if an element is displayed using your framework
        // Replace with actual implementation
    }

    private void findElementAndClick(String elementId) {
        // Example: interact with an element (click) using your framework
        // Replace with actual implementation
    }

    private void findElementAndEnterText(String elementId, String text) {
        // Example: interact with an element (enter text) using your framework
        // Replace with actual implementation
    }

    private String getElementText(String elementId) {
        // Example: get the text of an element
        // Replace with actual implementation
        return "Otp not verified"; // Placeholder
    }
}
