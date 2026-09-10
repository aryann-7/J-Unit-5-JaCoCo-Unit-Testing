# CS341 Assignment 1 - Software Quality and Testing

## About This Project

This repository contains our submission for CS341 Assignment 1. The goal of this assignment is to practice unit testing using JUnit 5, test case design techniques (Equivalence Partitioning and Boundary Value Analysis), and measuring test coverage with JaCoCo.

The assignment is split into two parts:

- Section A: Writing unit tests for an existing `Employee` class to reach 100% statement and branch coverage without changing any of the provided code.
- Section B: Designing test cases for a car park overstay calculator (`CalcOverstayCharge`), finding and logging bugs in the provided implementation, fixing the code, and automating the test suite using parameterized tests.

---

## Project Structure

```text
CS341_A1_Java_Starter/
└── CS341_A1_Starter/
    ├── README.md                           # This file
    ├── CS341_A1_Report_Group5.pdf          # Final report (PDF version)
    ├── CS341_A1_Report_Group5.docx         # Final report (Word document)
    ├── CS341_A1_UTP_Group5.xlsx            # Unit Test Plan spreadsheet
    ├── CS341_A1_DefectTracker_Group5.xlsx  # Defect Tracker logging all found bugs
    │
    ├── section-a-employee-rating/          # Section A project folder
    │   ├── pom.xml                         # Maven dependencies (JUnit 5 & JaCoCo)
    │   ├── jacoco-report/                  # Saved coverage reports
    │   └── src/
    │       ├── main/java/fj/usp/cs341/sectiona/
    │       │   └── Employee.java           # Given class (unmodified)
    │       └── test/java/fj/usp/cs341/sectiona/
    │           └── EmployeeTest.java       # Our JUnit 5 tests
    │
    └── section-b-overstay-charge/          # Section B project folder
        ├── pom.xml                         # Maven dependencies (JUnit 5 & JaCoCo)
        ├── jacoco-report/                  # Saved coverage reports
        └── src/
            ├── main/java/fj/usp/cs341/sectionb/
            │   └── CalcOverstayCharge.java # Bug-fixed calculator class
            └── test/java/fj/usp/cs341/sectionb/
                └── CalcOverstayChargeTest.java # Automated parameterized tests
```

---

## What You Need to Run This

- Java JDK 17 or higher installed
- Apache Maven installed

You can check if both are set up properly by opening your command line and typing:

```bash
java -version
mvn -version
```

---

## What We Did in Each Section

### Section A: Employee Rating System

In this section, we were given `Employee.java`. The class takes an employee's name and score (0 to 100) and returns their performance rating:

- 85 to 100: Outstanding
- 70 to 84: Exceeds Expectations
- 50 to 69: Meets Expectations
- Below 50: Needs Improvement
- Anyone scoring 50 or above is eligible for a bonus.

We were not allowed to edit `Employee.java`. We wrote tests in `EmployeeTest.java` to test:

- Valid employee creation and rating outputs
- Boundary scores (0, 49, 50, 69, 70, 84, 85, 100)
- Invalid scores (< 0 and > 100)
- Invalid names (null, empty strings, and whitespace-only strings)
- Bonus eligibility checks and the summary string format

Our test suite achieved 100% statement and branch coverage on this class.

---

### Section B: Car Park Overstay Charge Calculator

In this section, we tested `CalcOverstayCharge.java`, which calculates parking penalty fees based on:

- Hours overstayed (valid range is 1 to 48 hours)
- Vehicle type (1 for Car, 2 for Truck)
- Permit type (1 for Visitor, 2 for Resident)

Pricing rules according to the assignment brief:

- Car with Visitor permit:
  - 1 to 4 hours: $2.00 per hour
  - 5 to 12 hours: $4.00 per hour
  - 13 to 48 hours: $8.00 per hour (also flagged for wheel clamping)
- Car with Resident permit:
  - 1 to 12 hours: $1.00 per hour
  - 13 to 48 hours: $3.00 per hour
- Truck (any permit):
  - $15.00 per hour for all hours
- Any invalid input should return -1.0.

Our workflow for this section was:

1. Designed our test cases first using Boundary Value Analysis and Equivalence Partitioning in `CS341_A1_UTP_Group5.xlsx`.
2. Ran the test cases against the initial starter code and recorded which tests failed.
3. Documented each bug in `CS341_A1_DefectTracker_Group5.xlsx`.
4. Fixed the bugs in `CalcOverstayCharge.java`.
5. Automated all test cases in `CalcOverstayChargeTest.java` using JUnit 5 parameterized tests (`@ParameterizedTest` with `@CsvSource`).
6. Verified with JaCoCo that all branches and statements are 100% covered.

---

## How to Build and Run the Tests

Note: Each section has its own separate Maven project and `pom.xml`. You need to `cd` into the folder you want to run before entering any Maven commands.

### Running Section A

1. Open your terminal and change directory to the Section A folder:

```bash
cd CS341_A1_Starter/section-a-employee-rating
```

1. Compile the code:

```bash
mvn clean compile
```

1. Run the unit tests:

```bash
mvn test
```

1. Run the tests and build the JaCoCo coverage report:

```bash
mvn verify
```

1. View the coverage report:
   Open `target/site/jacoco/index.html` in your browser to see the coverage results.

---

### Running Section B

1. Change directory to the Section B folder:

```bash
cd CS341_A1_Starter/section-b-overstay-charge
```

1. Compile the code:

```bash
mvn clean compile
```

1. Run the unit tests:

```bash
mvn test
```

1. Run the tests and build the JaCoCo coverage report:

```bash
mvn verify
```

1. View the coverage report:
   Open `target/site/jacoco/index.html` in your browser to see the coverage results.

---

## Submission Files

- `CS341_A1_Report_Group5.pdf`: Our written report with explanations of our test techniques, tables for EP and BVA, defect descriptions, and screenshots of our coverage reports.
- `CS341_A1_UTP_Group5.xlsx`: The test plan spreadsheet with all test cases and expected values.
- `CS341_A1_DefectTracker_Group5.xlsx`: The bug log showing what was broken, how we reproduced it, and how it was resolved.
- Source code in `section-a-employee-rating/` and `section-b-overstay-charge/`.
