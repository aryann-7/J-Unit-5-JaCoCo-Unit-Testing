package fj.usp.cs341.sectionb;

/**
 * Car park overstay charge calculator.
 *
 * Rules (see the assignment brief for the authoritative specification):
 *
 *   Car, Visitor permit:
 *       1-4   hours -> $2.00 per hour
 *       5-12  hours -> $4.00 per hour
 *       13-48 hours -> $8.00 per hour, and the vehicle is flagged for clamping
 *
 *   Car, Resident permit:
 *       1-12  hours -> $1.00 per hour
 *       13-48 hours -> $3.00 per hour
 *
 *   Truck, any permit type:
 *       $15.00 per hour for every hour overstayed
 *
 *   hoursOverstayed is valid from 1 to 48 inclusive.
 *   vehicleType: 1 = Car, 2 = Truck
 *   permitType : 1 = Visitor, 2 = Resident
 *
 *   Returns the total charge, or -1 if any input is invalid.
 *
 * NOTE: This implementation was supplied by the development team and has NOT
 * been verified against the specification. Test it against your Unit Test Plan,
 * log every mismatch in your Defect Tracker, then fix the defects in Task 6.
 */
public class CalcOverstayCharge {

    public static final int MIN_HOURS = 1;
    public static final int MAX_HOURS = 48;

    public static final int VEHICLE_CAR = 1;
    public static final int VEHICLE_TRUCK = 2;

    public static final int PERMIT_VISITOR = 1;
    public static final int PERMIT_RESIDENT = 2;

    public static final double INVALID = -1;

    /**
     * Computes the overstay charge.
     *
     * @param hoursOverstayed number of hours overstayed
     * @param vehicleType     1 = Car, 2 = Truck
     * @param permitType      1 = Visitor, 2 = Resident
     * @return the total charge, or -1 if any input is invalid
     */
    public static double computeOverstayCharge(int hoursOverstayed, int vehicleType, int permitType) {

        if (hoursOverstayed < MIN_HOURS) {
            return INVALID;
        }

        if (vehicleType != VEHICLE_CAR && vehicleType != VEHICLE_TRUCK) {
            return INVALID;
        }

        if (vehicleType == VEHICLE_TRUCK) {
            return hoursOverstayed * 15.0;
        }

        if (permitType != PERMIT_VISITOR && permitType != PERMIT_RESIDENT) {
            return INVALID;
        }

        if (permitType == PERMIT_VISITOR) {
            if (hoursOverstayed <= 4) {
                return hoursOverstayed * 2.0;
            }
            if (hoursOverstayed <= 13) {
                return hoursOverstayed * 4.0;
            }
            return hoursOverstayed * 8.0;
        }

        if (hoursOverstayed < 12) {
            return hoursOverstayed * 1.0;
        }
        return hoursOverstayed * 3.0;
    }

    /**
     * A car on a visitor permit that overstays 13 hours or more is flagged for
     * clamping. No other combination is flagged.
     *
     * @return true if the vehicle should be flagged for clamping
     */
    public static boolean isFlaggedForClamping(int hoursOverstayed, int vehicleType, int permitType) {
        if (computeOverstayCharge(hoursOverstayed, vehicleType, permitType) == INVALID) {
            return false;
        }
        return vehicleType == VEHICLE_CAR
                && permitType == PERMIT_VISITOR
                && hoursOverstayed >= 13;
    }
}
