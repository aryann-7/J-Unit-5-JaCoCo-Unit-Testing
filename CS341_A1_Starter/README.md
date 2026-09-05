# CS341 Assignment 1 — Starter Projects (Semester 2, 2026)

Two independent Maven projects. Open each one separately in your IDE, or open
this folder and import both as Maven projects.

```
CS341_A1_Starter/
├── section-a-employee-rating/     Section A — Employee Performance Rating System
└── section-b-overstay-charge/     Section B — Car Park Overstay Charge
```

## Requirements

- JDK 17 or later (`java -version`)
- Maven 3.8 or later (`mvn -v`)
- An internet connection the first time you build, so Maven can download JUnit

## Section A — Employee Performance Rating System

The class under test is `Employee`. **Do not modify it.** Your job is to test it.

```bash
cd section-a-employee-rating
mvn clean test          # run your tests
mvn clean verify        # run tests + generate the JaCoCo report (after Task 3)
```

The JaCoCo report appears at `target/site/jacoco/index.html`.

`pom.xml` deliberately does **not** include the JaCoCo plugin — adding and
configuring it is Task 3. There is a comment in `pom.xml` marking where it goes.

`EmployeeTest` contains one example test so the project compiles. Replace it
with your own suite covering positive cases, BVA, EP and invalid input.

## Section B — Car Park Overstay Charge

`CalcOverstayCharge` was supplied by the development team and has **not** been
verified against the specification. It may or may not be correct.

Work in this order — the order matters for your marks:

1. **Task 4.** Design your test cases from the specification in the assignment
   brief and write them into the Unit Test Plan workbook, including the expected
   value for each case. Do this *before* you run the program. If you take your
   expected values from whatever the program returns, every test passes by
   definition and you have tested nothing.
2. **Task 5.** Execute each case against the supplied class, mark PASS or FAIL,
   and log every FAIL in the Defect Tracker workbook with full reproduction
   details.
3. **Task 6.** Automate your cases in `CalcOverstayChargeTest`, fix the defects
   in `CalcOverstayCharge`, and re-run until the suite is green with 100%
   statement, branch and path coverage. Update the Defect Tracker status column
   as each defect is retested and closed.

```bash
cd section-b-overstay-charge
mvn clean test
mvn clean verify
```

## Submitting

Zip this whole folder (both projects) as `CS341_A1_Java_GPX.zip`, replacing `X`
with your group number. Run `mvn clean` in both projects first so you are not
submitting `target/` directories — but keep your generated JaCoCo reports if you
have moved them elsewhere for your report.

## Getting help

Post on the Moodle **Assignment Discussion Forum**. Do not email code directly.
