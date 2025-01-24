package app.util;

/**
 * Performs various things with arrays.
 *
 * This class has multiple methods which perform various things
 * such as converting string arrays into int arrays, comparing
 * the values of different arrays, and checking whether a certain value
 * is contained within an array. Look at the documentation below for
 * more information.
 *
 * @author Joel Laitinen
 * @version 1.1
 */

public class Arrays {
    /**
     * This method checks whether a given value is contained in
     * a given array by going through each of the array's elements
     * in a for-loop. If a match is found, it returns true; otherwise
     * it returns false.
     *
     * @param value the value that is looked for in the array.
     * @param array the array in which the value is looked for.
     * @return a boolean check of true or false depending on if the conditions are met.
     */
    public static boolean contains(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                return true;
            }
        }

        return false;
    }

    /**
     * This method checks how many of the same values are present
     * between two arrays. It does this element by element using
     * a for-loop and increments the counter for each matching value.
     *
     * @param array1 the first array to be compared.
     * @param array2 the second array to be compared.
     * @return the counter indicating the amount of matching values between the two arrays, called sameValueCounter.
     */
    public static int containsSameValues(int[] array1, int[] array2) {
        int sameValueCounter = 0;

        for (int i = 0; i < array1.length; i++) {
           if (contains(array1[i],array2)) sameValueCounter++;
        }

        return sameValueCounter;
    }
}