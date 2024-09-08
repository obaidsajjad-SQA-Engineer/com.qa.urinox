# Urinox Mobile App Automation Framework

This project is an automation testing framework for the Urinox mobile app, using the Page Object Model (POM) architecture with the factory pattern. The project is built using **Maven** and **TestNG** to structure the tests and manage dependencies.

## Project Structure

- **Main/base**: Contains the base classes like `TestBase` for driver initialization and common utilities.
- **Main/config**: Configuration files and constants used in the project.
- **Main/pages**: Page classes following the Page Object Model (POM), encapsulating elements and actions.
- **Main/utilities**: Utility classes for actions such as taking screenshots, reporting, etc.
- **Test/testcases**: Test classes where each test case is written and organized.
- **Applications**: Stores the APK file for the Urinox app.

### Key Dependencies

- **Appium Java Client (9.2.2)**: Used for interacting with the mobile application under test.
- **TestNG (7.10.2)**: Testing framework for managing and executing test cases.
- **Selenium (4.20.0)**: WebDriver library to control the mobile app via Appium.
- **ExtentReports (5.0.0)**: Used for generating detailed HTML reports for the test execution.
- **Commons IO (2.11.0)**: Utility library for working with IO operations like file management.

## Getting Started

### Prerequisites

Ensure you have the following tools installed:

- **Java JDK 8+**
- **Maven**
- **Appium Server**
- **Android Studio** (for Android SDKs)
- **TestNG plugin** (if using an IDE like Eclipse or IntelliJ)

### Running the Tests

1. Clone the repository:

    ```bash
    git clone https://github.com/obaidsajjad-SQA-Engineer/com.qa.urinox.git
    ```

2. Navigate to the project directory and run the tests using Maven:

    ```bash
    mvn clean test
    ```

3. After execution, the ExtentReports will be generated under the `/test-output` folder.

## License

This project is licensed under the MIT License.
