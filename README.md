# Java RestAPI Automation

API Automation project written in Java, using RestAssured and TestNG.

Tests CRUD operations for the
website https://jsonplaceholder.typicode.com/.

Test runs tracked with Allure Reports. See report at https://camescasse.github.io/java-api-test/.

## Getting Started

### Prerequisites

- Java Development Kit v.22 (JDK)

### Installing

1. Clone this repository
2. Navigate to the project directory
3. Install dependencies found in `pom.xml` using Maven or your preferred IDE

#### Optional:

Create a file in root called `.properties` and copy the key/values from the `example.properties` file

| Key    | Description                                                 |
|--------|-------------------------------------------------------------|
| `HOST` | Defines stage/test environment host. Defaults to production. |

