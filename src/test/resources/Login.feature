@test
Feature: User Login and OTP Verification in Spandan App

  Scenario Outline: User completes the login process and verifies OTP
    Given I am on the language selection page
    When I select the language as "<language>"
    And I click on the language_next_button
    Then I should be on the Select Use Case screen
    When I select the "<use_case>" radio button
    And I click on the use_case_next_button
    Then I should be on the Instructions screen
    When I click the instruction_next_button five times
    Then I should be on the Phone Number page
    When I enter the phone number as "<phone_number>"
    And I click the checkbox
    And I click on the Get_OTP_button
    Then I should be on the OTP screen
    When I enter "<otp>" as the OTP
    And I click on the Verify_OTP_button
    Then I should be on Dashboard
    When I click on the Lead II ECG
    Then I should be on Lead II ECG Test Page
    When I click on Start_Test_button
    Then I should be on a blank screen
#    When Device is connected
#    And I click on ok button
#    And I click on Start Test


    Examples:
      | language | use_case | phone_number | otp    |
      | Hindi | Clinical Use | 6306046513   | 123456 |

