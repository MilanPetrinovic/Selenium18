# Automation Exercise Project

This project contains automated tests for the Automation Exercise web application.

## Introduction

This repository includes automated tests written in Java using the TestNG framework for the [Automation Exercise](https://automationexercise.com/) web application. The tests cover various functionalities of the application, including user authentication, cart management, product browsing, and end-to-end purchase scenarios.
Project demonstrates the use of Page Object Model (POM) and Data Driven Testing (DDT) concepts.

## Features

- **User Authentication Tests**: Verify user login, logout, and account creation.
- **Cart Management Tests**: Ensure the proper functioning of the shopping cart.
- **Product Browsing Tests**: Validate product listing, details, and search functionality.
- **End-to-End Purchase Scenario Tests**: Comprehensive tests covering user registration, product purchase, and logout.
- Various page functionalities tests

## Prerequisites

Ensure the following tools are installed before running the tests:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Apache Maven](https://maven.apache.org/download.cgi)
- WebDriver compatible with Selenium (e.g., ChromeDriver)

## Getting Started

1. **Clone the repository:**

   ```bash
   git clone https://github.com/MilanPetrinovic/automation-exercise.git
   
2. **Navigate to the project directory:**
   ```bash
      cd AutomationExercise18
3. **Run the tests**

## Usage
- Each test class corresponds to a specific category of tests (e.g., LoginTest, CartTests, EndToEndTest).
- Tests can be executed using TestNG or through the Maven build tool.

# Tests
## Test categories
1. **LoginTest: Tests related to user authentication.**
2. **CartTests: Tests for managing the shopping cart.**
3. **EndToEndTest: Comprehensive end-to-end tests covering user registration, product purchase, and logout.**

## Running Tests
- Tests can be run individually or collectively based on the testing needs.

## Aditional Information

- Java Version: 11 
- TestNG Version: 7.3.0
- Selenium Version: 3.141.59
