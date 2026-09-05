package fj.usp.cs341.sectionb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * CS341 Assignment 1 - Section B, Task 6.
 *
 * Automate the test cases from your Unit Test Plan in this class.
 *
 * Work in this order:
 *   Task 4  Design your test cases on paper first (BVA and EP) and record them
 *           in the Unit Test Plan workbook, WITH expected values, BEFORE you run
 *           anything. Expected values come from the specification in the
 *           assignment brief, never from what the program happens to return.
 *   Task 5  Execute those cases against the supplied CalcOverstayCharge class,
 *           record PASS or FAIL, and log every FAIL in the Defect Tracker.
 *   Task 6  Automate the cases here, fix the defects in CalcOverstayCharge,
 *           and re-run until the suite is green with 100% coverage.
 *
 * The two examples below are provided so the project compiles. Replace them.
 */
class CalcOverstayChargeTest {

    private static final double DELTA = 0.001;

    @Test
    @DisplayName("Example: car on a visitor permit, 3 hours, charged at $2 per hour")
    void carVisitorTierOne() {
        assertEquals(6.0, CalcOverstayCharge.computeOverstayCharge(3, 1, 1), DELTA);
    }

    @Test
    @DisplayName("Example: zero hours is below the valid range and returns -1")
    void zeroHoursIsInvalid() {
        assertEquals(-1, CalcOverstayCharge.computeOverstayCharge(0, 1, 1), DELTA);
    }

    // TODO: Task 6 - automate the rest of your Unit Test Plan below.
}
