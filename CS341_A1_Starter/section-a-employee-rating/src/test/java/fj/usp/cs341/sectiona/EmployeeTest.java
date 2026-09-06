package fj.usp.cs341.sectiona;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}