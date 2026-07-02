# Electra HIS Automation Framework

## Overview
This project is a hybrid Selenium Java automation framework built with Maven, TestNG, Page Object Model, Page Factory, WebDriverManager, Apache POI, Extent Reports, and Log4j2.

## Structure
- src/main/java: framework core classes and page objects
- src/test/java: test cases
- src/main/resources: configuration and test data

## How to run
```bash
mvn clean test
```

## Useful commands
```bash
mvn -Dtest=LoginTest test
mvn -Dgroups=smoke test
```
