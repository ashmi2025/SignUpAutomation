SignUp Automation — TAP (The Authorized Partner)

Automated test suite for the multi-step agent sign-up flow on the TAP platform (https://authorized-partner.vercel.app/), built with Selenium WebDriver, Java, TestNG, and Maven.

// What This Covers
Home Page — clicking "Join Us Now" to start registration
Terms Page — accepting terms & conditions and continuing
Personal Details — filling first name, last name, email, phone, and password
Email OTP Verification — verifying the account via a 6-digit code sent to email
Agency Details — entering agency name, role, email, website, address, and region
Professional Experience — entering years of experience, focus area, and services provided.

// Tech Stack
Java
Selenium WebDriver — browser automation
TestNG — test execution, assertions, and test chaining
Maven — dependency management and build
Page Object Model (POM) — locators and page actions are separated from test logic

// Project Structure

src/main/java/pages/

HomePage.java
TermsPage.java
PersonalDetails.java
AgencyDetails.java
ProfessionalExperience.java

src/main/java/base/

BaseTest.java

src/test/java/tests/

SignUpAutomation.java

Each page class holds its locators, a constructor, and action/verification methods. Test classes handle test flow and assertions only, no locators or element interactions live in the test files. Test methods are chained using TestNG's dependsOnMethods so the flow runs in order without resetting the browser between steps.

// Prerequisites
Java JDK installed
Maven installed
Google Chrome installed
Eclipse (or any Java IDE with Maven + TestNG support)

//How to Run
Clone this repository
Open the project in Eclipse as a Maven project
Right-click SignUpAutomation.java
Test results appear in the Console and the TestNG results panel
