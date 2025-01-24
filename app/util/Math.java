package app.util;

/**
 * Returns a random integer between the given values.
 *
 * Two integers, min and max, are defined whenever the getRandom method is called.
 * The getRandom method then returns the sum of min and the result of
 * Math.random() multiplied by the difference of max and min plus 1. This
 * result is converted into an integer before it is added to min.
 *
 * @author Joel Laitinen
 * @version 1.0
 */

public class Math {
    /**
     * Don't know what to say here that I haven't said above.
     *
     * @param min the smaller of the two numbers defined in the Main class.
     * @param max the larger of the two numbers defined in the Main class.
     * @return the sum of min and the integer conversion of a random number
     * between 0 and 1 multiplied by the difference of max and min plus 1.
     */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}