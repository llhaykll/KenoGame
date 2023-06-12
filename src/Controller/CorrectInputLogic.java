package Controller;
import java.util.Scanner;

/**
 * The {@code CorrectInputLogic} class provides methods for validating and retrieving user input related to the Keno game.
 * It includes methods for topping up the balance and entering guessed numbers.
 */
public class CorrectInputLogic  {


    /**
     * Prompts the user to enter the amount they want to top up their balance with.
     * Validates the input and ensures it is within the allowed range (100 to 400,000).
     * If the input is invalid, prompts the user to enter the correct amount until a valid input is provided.
     *
     * @return the amount to top up the balance with, within the allowed range
     */

    protected int balanceTop() {
        int sum = 0;

        Scanner in = new Scanner(System.in);
        System.out.println("\u001B[35m" + "Enter how much will you top up your balance?" + "\u001B[0m");

        sum = in.nextInt();
        if (sum >= 100 && sum <= 400000) {
            return sum;

        } else {
            sum:
            while (true) {
                System.out.println("You cannot top up the balance with an amount less than 100 or more than 400000 AMD");
                System.out.println("Please enter the correct amount");

                in = new Scanner(System.in);
                int sum1 = in.nextInt();
                if (sum1 >= 100 && sum1 <= 400000) {
                    sum = sum1;
                    break sum;
                }
            }

        }
        return sum;
    }


    /**
     * Prompts the user to enter the first guessed number within the range of 0 to 100.
     * Validates the input and ensures it is within the allowed range.
     * If the input is invalid, prompts the user to enter the correct number until a valid input is provided.
     *
     * @return the first guessed number within the allowed range
     */

    protected int firstGuessedNumber() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first guessed number from 0 to 100");
        int guess1 = in.nextInt();
        if (guess1 >= 0 && guess1 <= 100) {
            return guess1;
        } else {

            guess1:

            while (true) {

                System.out.println("Guessed number will be from 0 to 100");
                System.out.println("Please input guessed number from 0 to 100");

                int guess = new Scanner(System.in).nextInt();
                if (guess >= 0 && guess <= 100) {
                    guess1 = guess;
                    break guess1;
                }

            }
        }
        return guess1;
    }

    /**
     * Prompts the user to enter the second guessed number within the range of 0 to 100.
     * Validates the input and ensures it is within the allowed range.
     * If the input is invalid, prompts the user to enter the correct number until a valid input is provided.
     *
     * @return the second guessed number within the allowed range
     */


    protected int secondGuessedNumber() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the second guessed number from 0 to 100");
        int guess2 = in.nextInt();
        if (guess2 >= 0 && guess2 <= 100) {
            return guess2;
        } else {

            guess1:

            while (true) {

                System.out.println("Guessed number will be from 0 to 100");
                System.out.println("Please input guessed number from 0 to 100");

                int guess = new Scanner(System.in).nextInt();
                if (guess >= 0 && guess <= 100) {
                    guess2 = guess;
                    break guess1;
                }

            }
        }
        return guess2;
    }

}
