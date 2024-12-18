@test
Feature: User Login and OTP Verification in Spandan App

  Scenario Outline: User completes the login process and verifies OTP
    Given I am on the "<screen>" screen
    When I select the language as "<language>"
    And I click on the "<next_button>" button
    And I am on the "Select Use Case" screen
    And I select the "<use_case>" radio button
    And I click on the "<next_button>" button
    And I am on the "Instructions" screen
    And I click the "<next_button>" button five times to proceed
    And I am on the "Enter Phone Number" screen
    And I enter the phone number as "<phone_number>"
    And I check the checkbox
    And I click on the "Get OTP" button
    Then I should be on the "OTP" screen
    When I enter "<otp>" as the OTP
    And I click on the "Verify OTP" button
    Then I should "<outcome>"

    Examples:
      | screen          | language | next_button | use_case     | phone_number | otp    | outcome                                 |
      | Select Language | English  | Next        | Clinical Use | 1234567890   | 123456 | be redirected to the dashboard          |
      | Select Language | Spanish  | Siguiente   | Clinical Use | 9876543210   | 654321 | be redirected to the dashboard          |
      | Select Language | French   | Suivant     | Personal Use | 1122112210   | 246824 | see an error message "Otp not verified" |
