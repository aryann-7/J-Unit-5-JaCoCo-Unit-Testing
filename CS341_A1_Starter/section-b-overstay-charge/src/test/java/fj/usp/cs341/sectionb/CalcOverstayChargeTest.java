package fj.usp.cs341.sectionb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * CS341 Assignment 1 - Section B, Task 6.
 *
 * Automate the test cases from your Unit Test Plan in this class.
 *
 * Work in this order:
 * Task 4 Design your test cases on paper first (BVA and EP) and record them
 * in the Unit Test Plan workbook, WITH expected values, BEFORE you run
 * anything. Expected values come from the specification in the
 * assignment brief, never from what the program happens to return.
 * Task 5 Execute those cases against the supplied CalcOverstayCharge class,
 * record PASS or FAIL, and log every FAIL in the Defect Tracker.
 * Task 6 Automate the cases here, fix the defects in CalcOverstayCharge,
 * and re-run until the suite is green with 100% coverage.
 *
 * The two examples below are provided so the project compiles. Replace them.
 */
class CalcOverstayChargeTest {

    private static final double DELTA = 0.001;

    @ParameterizedTest(name = "{0}")
    @CsvSource({
            "TC-01, 0, 1, 1, -1.0",
            "TC-02, 1, 1, 1, 2.0",
            "TC-03, 2, 1, 1, 4.0",
            "TC-04, 3, 1, 1, 6.0",
            "TC-05, 4, 1, 1, 8.0",
            "TC-06, 5, 1, 1, 20.0",
            "TC-07, 6, 1, 1, 24.0",
            "TC-08, 8, 1, 1, 32.0",
            "TC-09, 11, 1, 1, 44.0",
            "TC-10, 12, 1, 1, 48.0",
            "TC-11, 13, 1, 1, 104.0",
            "TC-12, 14, 1, 1, 112.0",
            "TC-13, 20, 1, 1, 160.0",
            "TC-14, 47, 1, 1, 376.0",
            "TC-15, 48, 1, 1, 384.0",
            "TC-16, 49, 1, 1, -1.0",

            "TC-17, 1, 1, 2, 1.0",
            "TC-18, 6, 1, 2, 6.0",
            "TC-19, 11, 1, 2, 11.0",
            "TC-20, 12, 1, 2, 12.0",
            "TC-21, 13, 1, 2, 39.0",
            "TC-22, 14, 1, 2, 42.0",
            "TC-23, 30, 1, 2, 90.0",
            "TC-24, 48, 1, 2, 144.0",

            "TC-25, 1, 2, 1, 15.0",
            "TC-26, 10, 2, 1, 150.0",
            "TC-27, 10, 2, 2, 150.0",
            "TC-28, 48, 2, 2, 720.0",
            "TC-29, 49, 2, 1, -1.0",

            "TC-30, 5, 0, 1, -1.0",
            "TC-31, 5, 3, 1, -1.0",
            "TC-32, 5, 1, 0, -1.0",
            "TC-33, 5, 1, 3, -1.0",
            "TC-34, 5, 2, 0, -1.0",
            "TC-35, 5, 2, 3, -1.0"
    })
    void testOverstayCharge(
            String tcId,
            int hours,
            int vehicle,
            int permit,
            double expected) {

        assertEquals(
                expected,
                CalcOverstayCharge.computeOverstayCharge(
                        hours, vehicle, permit),
                DELTA,
                tcId);
    }

    @ParameterizedTest
    @CsvSource({
            "12, 1, 1, false",
            "13, 1, 1, true",
            "13, 1, 2, false",
            "13, 2, 1, false",
            "49, 1, 1, false"
    })
    void testClamping(
            int hours,
            int vehicle,
            int permit,
            boolean expected) {

        assertEquals(
                expected,
                CalcOverstayCharge.isFlaggedForClamping(
                        hours, vehicle, permit));
    }

    @Test
    void testConstructor() {
        assertNotNull(new CalcOverstayCharge());
    }
}
