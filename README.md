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

## Optional Healenium Web integration

Healenium is disabled by default. Start its local services with:

```bash
docker compose -f docker-compose.healenium.yml up -d
```

The compose file uses the official Healenium Web service images (backend 3.5.1 and selector imitator 1.6) with PostgreSQL 15.5. It does not start a browser or Selenium Grid. To override the local database password, copy `healenium.env.example` to `healenium.env` and run Docker Compose with `--env-file healenium.env`.

Enable the SelfHealingDriver wrapper for a test run with:

```bash
mvn test -Dhealenium.enabled=true
```

When enabled, the wrapper connects to the local backend at `http://localhost:7878` and selector imitator at `http://localhost:8000`, as configured in `src/main/resources/healenium.properties`. Leave the property unset or set it to `false` to use the existing WebDriver directly.
