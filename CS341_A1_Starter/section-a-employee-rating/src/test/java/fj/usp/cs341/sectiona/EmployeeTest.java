package fj.usp.cs341.sectiona;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//CS341 Assignment 1 - Section A, Task 1.
//adding the test cases for the production test
 
@DisplayName("Employee Performance Rating System Tests")
class EmployeeTest {

    //Constructor, initialization & getter test cases
    @Nested
    @DisplayName("Constructor and Getter Tests")
    class ConstructorAndGetterTests {

        @Test
        @DisplayName("Valid name and score should correctly initialize fields")
        void validEmployeeInitialization() {
            Employee employee = new Employee("Ana Singh", 88);
            assertEquals("Ana Singh", employee.getName());
            assertEquals(88, employee.getScore());
        }

        @Test
        @DisplayName("Employee name with leading and trailing whitespace should be trimmed")
        void employeeNameShouldBeTrimmed() {
            Employee employee = new Employee("  Ana Singh  ", 85);
            assertEquals("Ana Singh", employee.getName());
        }
    }

    //Equivalence Partitioning test cases (nominal values)
    @Nested
    @DisplayName("Equivalence Partitioning (EP) - Valid Partitions")
    class EquivalencePartitioningTests {

        @Test
        @DisplayName("EP Partition 1 [0 - 49]: Nominal score 25 -> Needs Improvement, Not Bonus Eligible")
        void nominalNeedsImprovement() {
            Employee employee = new Employee("Alice", 25);
            assertEquals("Needs Improvement", employee.getRating());
            assertFalse(employee.isBonusEligible());
        }

        @Test
        @DisplayName("EP Partition 2 [50 - 69]: Nominal score 60 -> Meets Expectations, Bonus Eligible")
        void nominalMeetsExpectations() {
            Employee employee = new Employee("Bob", 60);
            assertEquals("Meets Expectations", employee.getRating());
            assertTrue(employee.isBonusEligible());
        }

        @Test
        @DisplayName("EP Partition 3 [70 - 84]: Nominal score 77 -> Exceeds Expectations, Bonus Eligible")
        void nominalExceedsExpectations() {
            Employee employee = new Employee("Charlie", 77);
            assertEquals("Exceeds Expectations", employee.getRating());
            assertTrue(employee.isBonusEligible());
        }

        @Test
        @DisplayName("EP Partition 4 [85 - 100]: Nominal score 92 -> Outstanding, Bonus Eligible")
        void nominalOutstanding() {
            Employee employee = new Employee("Diana", 92);
            assertEquals("Outstanding", employee.getRating());
            assertTrue(employee.isBonusEligible());
        }
    }
}