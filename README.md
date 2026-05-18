# QAMobileKit

QaMobileKit is a scalable and modern mobile automation framework built using Java, Appium, TestNG, and YAML 
configuration management.

The framework is designed for:

- Parallel mobile test execution
- Multiple Android device support
- Easy maintenance
- CI/CD integration

---

# Tech Stack

- Java 26
- Appium
- TestNG
- Maven
- SnakeYAML
- Lombok

---

# Features

✅ YAML-based configuration
✅ Parallel execution using TestNG 
✅ Multi-device execution
✅ Thread-safe driver management
✅ Scalable DriverFactory architecture
✅ Easy CI/CD integration
✅ Supports real devices and emulators

---

# Project Structure

```text
mobile-automation-framework
│
├── pom.xml
├── testng.xml
│
├── src
│   ├── main
│   │   ├── java
│   │   │
│   │   ├── config
│   │   ├── driver
│   │   ├── factory
│   │   └── model
│   │
│   └── resources
│       └── config.yaml
│
│
└── src/test
    └── java
        ├── base
        └── tests
```

---

# Configuration

All framework configuration is managed using a single YAML file.

## config.yaml

```yaml
execution:
  platform: android

server:
  url: http://127.0.0.1:4723

app:
  appPackage: com.demo.app
  appActivity: com.demo.app.MainActivity
  appPath: apps/demo.apk

devices:

  - deviceName: Pixel_8
    platformVersion: "14"
    automationName: UiAutomator2

  - deviceName: Samsung_S24
    platformVersion: "14"
    automationName: UiAutomator2
```

---

# Running Tests

## Start Appium Server

```bash
appium
```

---

## Execute Tests

```bash
mvn clean test
```

---

# Parallel Execution

Parallel execution is enabled using:

- TestNG DataProvider
- ThreadLocal Drivers
- YAML Device Matrix

Example:

```yaml
devices:

  - deviceName: Pixel_8

  - deviceName: Samsung_S24

  - deviceName: OnePlus_12
```

Each device will run tests independently in parallel.

---

# TestNG Configuration

## testng.xml

```xml
<!DOCTYPE suite SYSTEM
        "https://testng.org/testng-1.0.dtd">

<suite name="Mobile Suite"
       parallel="methods"
       thread-count="3">

    <test name="Android Tests">

        <classes>
            <class name="tests.LoginTest"/>
        </classes>

    </test>

</suite>
```

---

# Sample Test

```java
@Test(dataProvider = "devices")
public void loginTest(DeviceConfig device) {

    AndroidDriver driver =
            DriverManager.getDriver();

    System.out.println(
            "Running on device: "
                    + device.getDeviceName());

    Assert.assertTrue(true);
}
```
---

# Future Enhancements

The framework can be extended with:

- Allure Reporting
- SLF4J + Logback Logging
- Retry Analyzer
- Dynamic Appium Ports
- BrowserStack Integration
- SauceLabs Integration
- iOS Support
- Page Object Model
- API Testing Integration
- GitHub Actions CI/CD
- Docker Support


---

# Recommended Tools

| Tool | Purpose |
|---|---|
| Appium Inspector | Element inspection |
| Android Studio | Emulator management |
| ADB | Device management |
| GitHub Actions | CI/CD |

---

# Requirements

- Java 26+
- Maven 3.9+
- Node.js
- Appium Server
- Android SDK
- Connected Android Device or Emulator

---

# Install Appium

```bash
npm install -g appium
```

Verify installation:

```bash
appium -v
```

---

# Verify Connected Devices

```bash
adb devices
```

---
## :question: Need Assistance?

- Discuss your queries by writing to me @ `mohammadfaisalkhatri@gmail.com`
  OR ping me on any of the social media sites using the below link:
    - [Linktree](https://linktr.ee/faisalkhatri)
## :thought_balloon: Checkout my [Medium Blog](https://medium.com/@iamfaisalkhatri) for tutorial articles on Software Testing and Test Automation.


- 