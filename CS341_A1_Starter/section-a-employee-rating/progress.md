# Task 1 Progress and Compliance Summary

1. Positive Tests
- Field initialization and getters (getName, getScore) verified.
- Whitespace trimming on name input verified.
- Summary string formatting across all rating bands verified.
- Status: Met

2. Equivalence Partitioning (EP)
- Band 1 (Score < 50): Nominal score 25 tested -> Needs Improvement, Bonus Eligible = false.
- Band 2 (Score 50 to 69): Nominal score 60 tested -> Meets Expectations, Bonus Eligible = true.
- Band 3 (Score 70 to 84): Nominal score 77 tested -> Exceeds Expectations, Bonus Eligible = true.
- Band 4 (Score 85 to 100): Nominal score 92 tested -> Outstanding, Bonus Eligible = true.
- Status: Met

3. Boundary Value Analysis (BVA)
- Global score limits tested: -1, 0, 1, 99, 100, 101.
- Band 1 to 2 threshold tested: 49, 50, 51.
- Band 2 to 3 threshold tested: 69, 70, 71.
- Band 3 to 4 threshold tested: 84, 85, 86.
- Status: Met

4. Negative Tests (Exceptions)
- Null name throws IllegalArgumentException with exact message.
- Empty string name throws IllegalArgumentException with exact message.
- Whitespace-only name throws IllegalArgumentException with exact message.
- Negative scores (-1, -5, -25, -100) throw IllegalArgumentException with exact message.
- Excessive scores (101, 105, 150, 200, 1000) throw IllegalArgumentException with exact message.
- Status: Met

5. Exact Assertions
- Exception types verified with assertThrows(IllegalArgumentException.class).
- Exact error messages verified for name and score validations.
- Exact equality verified using assertEquals, assertTrue, and assertFalse.
- Status: Met

6. Structure and Best Practices
- Pure JUnit 5 implementation using org.junit.jupiter API.
- Organized hierarchy using @Nested and @DisplayName annotations.
- Parameterized tests used for multi-input coverage.
- Status: Met