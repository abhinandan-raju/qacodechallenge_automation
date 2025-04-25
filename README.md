# Hostelworld QA Code Challenge

This repository contains both **manual** and **automated** test cases developed as part of the Hostelworld QA Code Challenge. The app under test is a basic Android application with the following screens:

- **Main Screen**: "Create Account" and "Login" buttons
- **Create Account**: Form with input validation
- **Login**: Authentication screen
- **User Logged In**: User details and Logout button

---

## Challenge Requirements Covered

1. Tested the Android application on a mobile device
2. Created relevant manual and automated test cases 
3. Identified and documented bugs (see Bug Report.docx file)
4. Created UI automation using **Appium + Java + TestNG**

---

## Project Structure

app folder - contains the Hostelworld QA Code challenge Test app
automation folder - contains the automation code
manual folder - contains the manual test cases, bug report and bug reproducing video file

---

## Automation Setup & Execution

### Prerequisites

- Java JDK 11
- Maven
- Appium Server installed and running
- Android Emulator or real device connected
- Node.js
- Android SDK with environment variables configured

---

### How to Run the Tests

1. Clone the repository: https://github.com/abhinandan-raju/qacodechallenge_automation
2. Navigate to the automation folder
3. Install dependcies and run tests using mvn clean test
4. View the TestNG report in the test output folder


### Test Coverage
Automated Tests:
1. Verify presence of buttons on Main Screen
2. E2E test - From user signup from Create Account screen and then to login using registered user id and password and then validating that the login home screen is displayed

### Bugs found
Please refer to the Bug Report.docx file in the manual folder for a list of issues identified during testing with reproduction steps and expected behaviour.

Notes: 
- Appium inspector was used to locate UI Elements
- Unable to locate the error messages in the create account signup screen and the locators was not possible to identify using different attributes, so had to proceed with Happy path validation for Automated UI Tests
- All tests are designed to be modular, maintainable, and follow the Page Object Model (POM) structure.


## Author:
Abhinandan Raju | 
QA Automation Expert | 12+ years experience
LinkedIN: https://www.linkedin.com/in/abhinandanraju 
