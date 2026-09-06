package fj.usp.cs341.sectiona;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    //Equivalence Partitioning test cases (nominal values for each partition)
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

    //Boundary value test cases
    @Nested
    @DisplayName("Boundary Value Analysis (BVA) Tests")
    class BoundaryValueAnalysisTests {

        @Nested
        @DisplayName("Global Score Range Boundaries (0 and 100)")
        class GlobalRangeBoundaries {

            @Test
            @DisplayName("BVA: Score 0 (Minimum valid score) -> Needs Improvement, Not Bonus Eligible")
            void boundaryScoreZero() {
                Employee employee = new Employee("John Doe", 0);
                assertEquals("Needs Improvement", employee.getRating());
                assertFalse(employee.isBonusEligible());
            }

            @Test
            @DisplayName("BVA: Score 1 (Just above minimum) -> Needs Improvement, Not Bonus Eligible")
            void boundaryScoreOne() {
                Employee employee = new Employee("John Doe", 1);
                assertEquals("Needs Improvement", employee.getRating());
                assertFalse(employee.isBonusEligible());
            }

            @Test
            @DisplayName("BVA: Score 99 (Just below maximum) -> Outstanding, Bonus Eligible")
            void boundaryScoreNinetyNine() {
                Employee employee = new Employee("John Doe", 99);
                assertEquals("Outstanding", employee.getRating());
                assertTrue(employee.isBonusEligible());
            }

            @Test
            @DisplayName("BVA: Score 100 (Maximum valid score) -> Outstanding, Bonus Eligible")
            void boundaryScoreOneHundred() {
                Employee employee = new Employee("John Doe", 100);
                assertEquals("Outstanding", employee.getRating());
                assertTrue(employee.isBonusEligible());
            }

            @Test
            @DisplayName("BVA: Score -1 (Just below minimum score 0) -> Throws IllegalArgumentException")
            void boundaryScoreNegativeOneThrowsException() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new Employee("John Doe", -1));
                assertEquals("Score must be between 0 and 100", exception.getMessage());
            }

            @Test
            @DisplayName("BVA: Score 101 (Just above maximum score 100) -> Throws IllegalArgumentException")
            void boundaryScoreOneHundredAndOneThrowsException() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new Employee("John Doe", 101));
                assertEquals("Score must be between 0 and 100", exception.getMessage());
            }
        }

        @Nested
        @DisplayName("Threshold Boundaries (49/50/51, 69/70/71, 84/85/86)")
        class ThresholdBoundaries {

            // Boundary test for (needs improvement) vs (meets expectations & bonus eligibility)
            @Test
            @DisplayName("BVA: Score 49 (Upper bound of Needs Improvement) -> Needs Improvement, Not Bonus Eligible")
            void boundaryScoreFortyNine() {
                Employee employee = new Employee("John Doe", 49);
                assertEquals("Needs Improvement", employee.getRating());
                assertFalse(employee.isBonusEligible());
            }

            @Test
            @DisplayName("BVA: Score 50 (Lower bound of Meets Expectations & Bonus Threshold) -> Meets Expectations, Bonus Eligible")
            void boundaryScoreFifty() {
                Employee employee = new Employee("John Doe", 50);
                assertEquals("Meets Expectations", employee.getRating());
                assertTrue(employee.isBonusEligible());
            }

            @Test
            @DisplayName("BVA: Score 51 (Just above lower bound of Meets Expectations) -> Meets Expectations, Bonus Eligible")
            void boundaryScoreFiftyOne() {
                Employee employee = new Employee("John Doe", 51);
                assertEquals("Meets Expectations", employee.getRating());
                assertTrue(employee.isBonusEligible());
            }

            // Boundary test for (meets expectations) vs (exceeds expectations)
            @Test
            @DisplayName("BVA: Score 69 (Upper bound of Meets Expectations) -> Meets Expectations, Bonus Eligible")
            void boundaryScoreSixtyNine() {
                Employee employee = new Employee("John Doe", 69);
                assertEquals("Meets Expectations", employee.getRating());
                assertTrue(employee.isBonusEligible());
            }

            @Test
            @DisplayName("BVA: Score 70 (Lower bound of Exceeds Expectations) -> Exceeds Expectations, Bonus Eligible")
            void boundaryScoreSeventy() {
                Employee employee = new Employee("John Doe", 70);
                assertEquals("Exceeds Expectations", employee.getRating());
                assertTrue(employee.isBonusEligible());
            }

            @Test
            @DisplayName("BVA: Score 71 (Just above lower bound of Exceeds Expectations) -> Exceeds Expectations, Bonus Eligible")
            void boundaryScoreSeventyOne() {
                Employee employee = new Employee("John Doe", 71);
                assertEquals("Exceeds Expectations", employee.getRating());
                assertTrue(employee.isBonusEligible());
            }

            // Boundary: Exceeds Expectations vs Outstanding (85)
            @Test
            @DisplayName("BVA: Score 84 (Upper bound of Exceeds Expectations) -> Exceeds Expectations, Bonus Eligible")
            void boundaryScoreEightyFour() {
                Employee employee = new Employee("John Doe", 84);
                assertEquals("Exceeds Expectations", employee.getRating());
                assertTrue(employee.isBonusEligible());
            }

            @Test
            @DisplayName("BVA: Score 85 (Lower bound of Outstanding) -> Outstanding, Bonus Eligible")
            void boundaryScoreEightyFive() {
                Employee employee = new Employee("John Doe", 85);
                assertEquals("Outstanding", employee.getRating());
                assertTrue(employee.isBonusEligible());
            }

            @Test
            @DisplayName("BVA: Score 86 (Just above lower bound of Outstanding) -> Outstanding, Bonus Eligible")
            void boundaryScoreEightySix() {
                Employee employee = new Employee("John Doe", 86);
                assertEquals("Outstanding", employee.getRating());
                assertTrue(employee.isBonusEligible());
            }
        }
    }

    // =========================================================================
    // 4. Negative Tests (Input Validation & Exception Assertions)
    // =========================================================================
    @Nested
    @DisplayName("Negative Tests - Invalid Input Validation")
    class NegativeTests {

        @Nested
        @DisplayName("Invalid Name Validation")
        class InvalidNameTests {

            @Test
            @DisplayName("Null name should throw IllegalArgumentException with exact message")
            void nullNameThrowsException() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new Employee(null, 75));
                assertEquals("Employee name must not be null or empty", exception.getMessage());
            }

            @Test
            @DisplayName("Empty string name should throw IllegalArgumentException with exact message")
            void emptyNameThrowsException() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new Employee("", 75));
                assertEquals("Employee name must not be null or empty", exception.getMessage());
            }

            @Test
            @DisplayName("Whitespace-only name should throw IllegalArgumentException with exact message")
            void whitespaceOnlyNameThrowsException() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new Employee("   ", 75));
                assertEquals("Employee name must not be null or empty", exception.getMessage());
            }

            @ParameterizedTest(name = "Invalid whitespace name: \"{0}\"")
            @ValueSource(strings = { " ", "  ", "\t", "\n", "\t\n " })
            @DisplayName("Various whitespace combinations for name should throw IllegalArgumentException")
            void variousWhitespaceNamesThrowException(String invalidName) {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new Employee(invalidName, 75));
                assertEquals("Employee name must not be null or empty", exception.getMessage());
            }
        }

        @Nested
        @DisplayName("Invalid Score Validation")
        class InvalidScoreTests {

            @ParameterizedTest(name = "Invalid negative score: {0}")
            @ValueSource(ints = { -1, -5, -25, -100 })
            @DisplayName("Scores below 0 should throw IllegalArgumentException with exact message")
            void scoresBelowZeroThrowException(int invalidScore) {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new Employee("Valid Name", invalidScore));
                assertEquals("Score must be between 0 and 100", exception.getMessage());
            }

            @ParameterizedTest(name = "Invalid excessive score: {0}")
            @ValueSource(ints = { 101, 105, 150, 200, 1000 })
            @DisplayName("Scores above 100 should throw IllegalArgumentException with exact message")
            void scoresAboveOneHundredThrowException(int invalidScore) {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new Employee("Valid Name", invalidScore));
                assertEquals("Score must be between 0 and 100", exception.getMessage());
            }
        }
    }

    // =========================================================================
    // 5. Summary String Formatting Tests
    // =========================================================================
    @Nested
    @DisplayName("Summary String Format Tests")
    class SummaryTests {

        @Test
        @DisplayName("getSummary() for score 90 (Outstanding, Bonus Eligible)")
        void summaryForOutstanding() {
            Employee employee = new Employee("Ana Singh", 90);
            assertEquals("Ana Singh - Outstanding - Bonus Eligible", employee.getSummary());
        }

        @Test
        @DisplayName("getSummary() for score 75 (Exceeds Expectations, Bonus Eligible)")
        void summaryForExceedsExpectations() {
            Employee employee = new Employee("Bob Kumar", 75);
            assertEquals("Bob Kumar - Exceeds Expectations - Bonus Eligible", employee.getSummary());
        }

        @Test
        @DisplayName("getSummary() for score 60 (Meets Expectations, Bonus Eligible)")
        void summaryForMeetsExpectations() {
            Employee employee = new Employee("Charlie Brown", 60);
            assertEquals("Charlie Brown - Meets Expectations - Bonus Eligible", employee.getSummary());
        }

        @Test
        @DisplayName("getSummary() for score 30 (Needs Improvement, Not Bonus Eligible)")
        void summaryForNeedsImprovement() {
            Employee employee = new Employee("David Lee", 30);
            assertEquals("David Lee - Needs Improvement - Not Bonus Eligible", employee.getSummary());
        }
    }
}