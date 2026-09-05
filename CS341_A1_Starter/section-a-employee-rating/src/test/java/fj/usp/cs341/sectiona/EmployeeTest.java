package fj.usp.cs341.sectiona;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * CS341 Assignment 1 - Section A, Task 1.
 *
 * Write your JUnit 5 tests for the Employee class in this file.
 *
 * Your test suite must include:
 *   - Positive tests covering every rating band and bonus eligibility.
 *   - Boundary Value Analysis tests around each band boundary.
 *   - Equivalence Partitioning tests using one representative value per partition.
 *   - Negative tests for invalid input, asserting the exception type AND message
 *     using assertThrows.
 *
 * Use meaningful method names and @DisplayName annotations.
 *
 * The single example below is provided so the project compiles and
 * 'mvn clean test' runs. Delete it or replace it with your own tests.
 */
class EmployeeTest {

    @Test
    @DisplayName("Example: a score of 90 is rated Outstanding")
    void scoreOf90IsOutstanding() {
        Employee employee = new Employee("Ana Singh", 90);
        assertEquals("Outstanding", employee.getRating());
    }

    // TODO: Task 1 - add your positive, BVA, EP and negative tests below.
}
