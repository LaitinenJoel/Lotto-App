# LOTTO APP
This is a lotto application that asks you for seven numbers, then chooses seven numbers of its own, and tells you how many of the numbers are matching. It also features an alternate mode where it calculates how many years it would take for you to win with the numbers you've chosen if a new lotto were randomized every week. It has a command line interface, but not a graphical interface.

## Overview
This started as a school project, but I have afterward, on my own, modified and expanded it. This is partly out of interest to revisit an old project, but also to put it on public display in the search for a job in the field of programming.

## Build status
This is version 1.1. The standard mode (normal lotto) and secondary mode (how many years it takes for you to win) are functional. More modes, as well as a graphical user interface, may be added in the future.

## Code style
This program is coded entirely with Java.

## Code example
This is one method from the Main class which asks the user which mode, standard or secondary, they'd like to pick. It then performs the necessary operations and displays the end result to the user.
```
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
```

## Screenshot
Here is a screenshot of what the `chooseMode()` method (code example above) displays in the terminal after the user has picked the standard mode (normal lotto) and given seven numbers:

![image](https://github.com/user-attachments/assets/5f41a834-cbb0-488e-b492-d0bf71cad4fb)

## Installation and usage
1. Make sure you have Java installed on your computer. You can download it from [https://adoptium.net/en-GB/](https://adoptium.net/en-GB/).
2. Download the `app` folder using [https://download-directory.github.io/](https://download-directory.github.io/) or download the files inside the folder manually. You can insert them anywhere on your computer, but make sure the file structure remains intact.
3. Open the Windows terminal in the directory location you placed the `app` folder in. Any application capable of simulating the terminal should work as well.
4. Type `javac -d . app/Main.java app/util/*.java` in the terminal to compile the files.
5. Type `java app/Main` to run the program.
