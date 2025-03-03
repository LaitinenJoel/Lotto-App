package app;

import app.util.Math;
import app.util.Arrays;
import app.util.MyConsole;

/**
 * A lotto. Match seven numbers, each between 1 and 40.
 *
 * This is a lotto with two modes the user can choose between.
 * The first is a typical lotto where the user picks seven
 * numbers in the range of 1-40 and the program looks how many
 * are matching with its randomly generated ones and tells
 * the user this. The second tells the user how many years
 * it would take for them to win the lotto with their chosen
 * numbers for each amount of matches. Look at the documentation
 * below for more information.
 *
 * @author Joel Laitinen
 * @version 1.1
 */

public class Main {
    /**
     * This is the welcoming message for the app. It is not seen again unless
     * the user closes and restarts the program, since it immediately calls the
     * chooseMode() method afterwards.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("WELCOME TO THE LOTTO APP.");

        chooseMode();
    }

    /**
     * This method first asks the user what mode they want to launch the
     * program in. Standard mode means trying a lotto once, and then the
     * program tells you the numbers you picked as well as the numbers
     * randomly generated by the program and how many of them are matching. The
     * "How many years" mode tells you how many years it would take you to win
     * the lotto with the numbers you picked for each amount of matches.
     */
    private static void chooseMode() {
        System.out.println("");
        System.out.println("Choose your preferred mode by inputting the corresponding number.");
        System.out.println("1: Standard");
        System.out.println("- Try a normal lotto once");
        System.out.println("2: How many years");
        System.out.println("- Submit the numbers and see how many years it takes for them to yield you a win");

        int mode = MyConsole.readInt(1,2,"Please give a number.","Please give a number between 1 and 2.");

        if (mode == 1) {
            int[] userNumbers = userInputs();
            System.out.println("YOUR NUMBERS:");
            for (int i = 0; i < userNumbers.length - 1; i++) {
                System.out.print(userNumbers[i] + ", ");
                if (i == userNumbers.length - 2) {
                    System.out.print(userNumbers[i + 1]);
                }
            }

            System.out.println("");
            int[] lottoNumbers = calculateLotto();
            System.out.println("LOTTO NUMBERS:");
            for (int i = 0; i < lottoNumbers.length - 1; i++) {
                System.out.print(lottoNumbers[i] + ", ");
                if (i == lottoNumbers.length - 2) {
                    System.out.print(lottoNumbers[i + 1]);
                }
            }

            System.out.println("");
            System.out.println("You got " + Arrays.containsSameValues(userNumbers,lottoNumbers) + " right.");
        } else if (mode == 2) {
            int[] time = howManyYears();

            for (int i = 0; i < time.length; i++) {
                System.out.println("You got " + (i + 1) + " right. It took " + time[i] + " years.");
            }
        }

        tryAgain();
    }

    /**
     * This method creates an array with seven elements.
     * It asks the user to input a number between 1 and 40.
     * If the element is already contained in the array, however,
     * it prompts the user with a message to give a number they
     * haven't already given. If the user gives a number outside
     * the range of 1-40, it prompts the user to give a number
     * in the appropriate range. If the user gives something
     * other than a number, it prompts the user to give a number.
     *
     * @return the array of seven unique elements between 1 and 40 given by the user, called userNumbers.
     */
    private static int[] userInputs() {
        int[] userNumbers = new int[7];

        for (int i = 0; i < userNumbers.length;) {
            System.out.println("Please give a unique number between 1 and 40.");
            int temporary = MyConsole.readInt(1,40,"Please give a number.","Please give a number between 1 and 40.");
            if (Arrays.contains(temporary, userNumbers)) {
                System.out.println("Please give a number you haven't already given.");
                continue;
            } else {
                userNumbers[i] = temporary;
                i++;
            }
        }

        return userNumbers;

    }

    /**
     * This method creates an array with seven elements.
     * It randomly generates each element between 1 and 40.
     * If the element is already contained in the array, however,
     * it generates it again until it is unique. This is to avoid
     * duplicates.
     *
     * @return the array of seven unique numbers each between 1 and 40, called lottoNumbers.
     */
    private static int[] calculateLotto() {

        int[] lottoNumbers = new int[7];

        for (int i = 0; i < lottoNumbers.length;) {
            int temporary = Math.getRandom(1,40);
            if (Arrays.contains(temporary, lottoNumbers)) {
                continue;
            } else {
                lottoNumbers[i] = temporary;
                i++;
            }
        }

        return lottoNumbers;
    }

    /**
     * This method checks how many years it takes for
     * randomly generated numbers to match the numbers given
     * by the user. Each iteration takes one week, so 52.1429
     * loops increments the year by 1.
     *
     * @return the number of years for each amount of matches between randomly generated numbers and the user's given numbers.
     */
    private static int[] howManyYears() {

        int[] userNumbers = userInputs();
        int correctPermanent = 0;
        double week = 0;
        int year = 0;
        int[] correctYears = new int[7];

        while (true) {
            int[] lottoNumbers = calculateLotto();
            int correct = 0;

            for (int i = 0; i < userNumbers.length; i++) {
                if (Arrays.contains(lottoNumbers[i],userNumbers)) {
                    correct++;
                    if (correct > correctPermanent) {
                        correctPermanent++;
                        correctYears[correct - 1] = year;
                    }
                }
            }

            if (correct == 7) return correctYears;

            week++;
            if (week >= 53) {
                year++;
                week = week - 52.1429;
            }
        }
    }

    /**
     * This method asks the user whether they'd like to try again by pressing
     * 1, or if they'd like to close the program by pressing 2.
     */
    private static void tryAgain() {
        System.out.println("");
        System.out.println("Would you like to try again? Pick the corresponding number.");
        System.out.println("1. Yes.");
        System.out.println("2. No, I would like to close the application.");

        int yesOrNo = MyConsole.readInt(1,2,"Please give a number.","Please give a number between 1 and 2.");

        if (yesOrNo == 1) {
            chooseMode();
        } else if (yesOrNo == 2) {
            System.out.println("Closing application.");
            System.exit(0);
        }
    }
}