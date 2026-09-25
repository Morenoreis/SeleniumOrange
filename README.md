![CI](https://github.com/Morenoreis/SeleniumOrange/actions/workflows/ci.yml/badge.svg)
# SeleniumOrange

End-to-end test automation project using **Selenium WebDriver + Java + TestNG** on the [OrangeHRM](https://opensource-demo.orangehrmlive.com) demo website.

Built as a practical QA Automation portfolio focused on best practices, clean architecture, and real module coverage of an HR system.

---

##   Tech Stack

- [Selenium WebDriver](https://www.selenium.dev/) 4.18.1
- Java 21
- TestNG 7.9.0
- WebDriverManager 5.7.0
- ExtentReports 5.1.1
- Maven 3.9.9
- Page Object Model (POM)

---

## 📁 Project Structure

```
SeleniumOrange/
├── src/
│   └── test/
│       └── java/
│           └── com/
│               └── orangehrm/
│                   ├── base/
│                   │   └── BaseTest.java
│                   ├── pages/
│                   │   ├── LoginPage.java
│                   │   ├── SideMenuPage.java
│                   │   ├── AdminPage.java
│                   │   └── PimPage.java
│                   └── tests/
│                       ├── LoginTest.java
│                       ├── NavigationTest.java
│                       ├── AdminTest.java
│                       └── PimTest.java
├── pom.xml
├── testng.xml
└── README.md

```

##    Test Coverage

###   Login Tests
- Valid login should redirect to dashboard
- Invalid login should show error message
- Empty fields should show required error

###   Navigation Tests
- Should display all main menu items
- Should navigate to Admin module
- Should navigate to PIM module
- Should navigate to Leave module

###   Admin Tests
- Should access Admin module successfully
- Should display table headers correctly
- Should find existing user in search
- Should show No Records Found for invalid user

###   PIM Tests
- Should access PIM module successfully
- Should display employee list with records
- Should display table headers correctly
- Should find employee by name

---

##   Getting Started

### Prerequisites
- Java 21+
- Maven 3.9+
- Google Chrome (latest)

### Installation
```bash
git clone https://github.com/Morenoreis/SeleniumOrange.git
cd SeleniumOrange
mvn install
```

### Run all tests
```bash
mvn test
```

### Run via TestNG XML
Right-click `testng.xml` → Run in IntelliJ IDEA

---

##   Architecture

This project follows the **Page Object Model (POM)** pattern:

- `BaseTest` — handles WebDriver setup and teardown for all tests
- Each module has its own Page Object under `pages/`
- Locators are centralized using `By` selectors in each Page class
- `WebDriverWait` is used for explicit waits throughout
- `WebDriverManager` handles automatic ChromeDriver management

---

##   Notes

- The demo site resets data periodically
- Tests run sequentially via TestNG XML suite

---

##   Author

**Moreno Barros Reis**

QA Automation Engineer

• [LinkedIn](https://www.linkedin.com/in/morenoreis/)

• [GitHub](https://github.com/Morenoreis)
