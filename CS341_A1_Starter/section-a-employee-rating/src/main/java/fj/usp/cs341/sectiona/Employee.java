package fj.usp.cs341.sectiona;

/**
 * Employee Performance Rating System.
 *
 * Each employee has a name and a performance score (0-100). Based on the score
 * the system returns a performance rating and a bonus eligibility status.
 *
 * Rating bands:
 *   Outstanding           : 85 and above
 *   Exceeds Expectations  : 70 - 84
 *   Meets Expectations    : 50 - 69
 *   Needs Improvement     : below 50
 *
 * Bonus eligibility:
 *   An employee is bonus eligible if the score is 50 or above.
 *
 * Validation:
 *   A null, empty or whitespace-only name raises IllegalArgumentException.
 *   A score below 0 or above 100 raises IllegalArgumentException.
 *
 * DO NOT MODIFY THIS CLASS. Your task is to test it.
 */
public class Employee {

    public static final int MIN_SCORE = 0;
    public static final int MAX_SCORE = 100;

    private final String name;
    private final int score;

    public Employee(String name, int score) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name must not be null or empty");
        }
        if (score < MIN_SCORE || score > MAX_SCORE) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
        this.name = name.trim();
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    /**
     * @return the performance rating band for this employee's score.
     */
    public String getRating() {
        if (score >= 85) {
            return "Outstanding";
        }
        if (score >= 70) {
            return "Exceeds Expectations";
        }
        if (score >= 50) {
            return "Meets Expectations";
        }
        return "Needs Improvement";
    }

    /**
     * @return true if this employee qualifies for a bonus.
     */
    public boolean isBonusEligible() {
        return score >= 50;
    }

    /**
     * @return a single-line summary, e.g. "Ana Singh - Outstanding - Bonus Eligible".
     */
    public String getSummary() {
        return name + " - " + getRating() + " - "
                + (isBonusEligible() ? "Bonus Eligible" : "Not Bonus Eligible");
    }
}
