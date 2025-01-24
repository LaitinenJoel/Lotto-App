package app.util;

import java.io.Console;

/**
 * Checks if a given value falls within a certain range.
 *
 * This class has only one method. Its purpose is explained
 * in the documentation below.
 *
 * @author Joel Laitinen
 * @version 1.0
 */

public class MyConsole {
    /**
     * This method is given a range between min and max, and the user
     * is asked to input an integer within that range. If the user gives
     * a number outside the range, it prompts the user to give a number
     * in the appropriate range. If the user gives something other than
     * a number, it prompts the user to give a number.
     *
     * @param min the smallest value the user can give.
     * @param max the highest value the user can give.
     * @param errorMessageNonNumeric the message displayed if the user gives something other than a number.
     * @param errorMessageNonMinandMax the message displayed if the user gives a number outside the defined range.
     * @return the number given by the user.
     */
    public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {
        Console c = System.console();
        int input = 0;
        boolean check = true;

        while (check) {
            try {
                input = Integer.parseInt(c.readLine());
                while (!(min <= input && max >= input)) {
                    System.out.println(errorMessageNonMinAndMax);
                    input = Integer.parseInt(c.readLine());
                }
                check = false;
            } catch (NumberFormatException e) {
                System.out.println(errorMessageNonNumeric);
            }
        }

        return input;
    }
}