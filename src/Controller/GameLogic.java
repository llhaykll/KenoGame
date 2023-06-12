package Controller;
import Model.KenoModel;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


/**
 * The "GameLogic" class contains the necessary methods for building the game logic such as -
 * "guessAndBet", "randomElements", "winCheck", "balanceCheck" and "balanceTop",
 * as well as methods for starting the game - "callingAllMethods", "play" and "playAgain".
 * This class is the main class for starting the game.
 */


public class GameLogic {

    /**
     * An instance of the "KenoModel" class to use the main game variables that are declared in the "KenoModel" class
     */
    private KenoModel kenoModel = new KenoModel();

    /**
     *An instance of the "CorrectInputLogic" class is used to utilize the methods assigned for proper data input in the console.
     */
    private CorrectInputLogic inputLogic = new CorrectInputLogic();




    /**
     * The "balanceTop" method allows the user to enter the desired amount of funds into the console,
     * which is then checked for correctness using a special method from the "CorrectInputLogic" class.
     */
    private void balanceTop(){
        kenoModel.setAccountBalance(inputLogic.balanceTop());
    }


    /**
     * The "print Numbers" method displays the numbers from 0 to 100 as a square, purely visually.
     */
    private void printNumbers() {

        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 0) {
                System.out.print(i + "\n");

            } else {
                System.out.print(i + " ");
            }
        }
    }


    /**
     *The "guessAndBet" method allows the user to enter the betInputLogic amount into the console,
     *  which is then checked for correctness using a special method from the "CorrectInputLogic" class.
     *  This method also allows you to enter two numbers, "guess1" and "guess2",
     *  which are also checked for correctness using special methods from the "CorrectInputLogic" class.
     *  After this method is executed, the values of all declared variables inside it are passed through setters to the
     *  corresponding variables of the "KenoModel" class. This is done to later check
     *  for matches between guessed and randomly generated numbers.
     */
    private void guessAndBet() {


        int bet = betInputLogic();
        int guess1 = inputLogic.firstGuessedNumber();
        int guess2 = inputLogic.secondGuessedNumber();
        HashSet<Integer> randomSet = randomElements();

        kenoModel.setBet(bet);
        kenoModel.setGuessNumber1(guess1);
        kenoModel.setGuessNumber2(guess2);
        kenoModel.setRandomSet(randomSet);
        kenoModel.setTotalWin(bet);

    }

    /**
     * The "randomElements" method generates 20 random numbers that will be used to compare against our guessed numbers.
     */
    private HashSet<Integer> randomElements() {
        System.out.println("\u001B[31m" + "Random numbers generation..." + "\u001B[0m");

        HashSet<Integer> randomNumbers = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            int element = new Random().nextInt(0, 101);
            randomNumbers.add(element);
        }

        Iterator<Integer> it = randomNumbers.iterator();
        int count = 0;
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
            count++;

            if (count == 10) {
                System.out.print("\n");
            }
            if (count == 20) {
                break;
            }
        }

        return randomNumbers;
    }


    /**
     * The "winCheck" method takes as a parameter an object of type "KenoModel",
     * which stores randomly generated numbers. This method checks for matches
     * between guessed numbers and randomly generated numbers to determine if the player has won or not.
     * If two numbers match, the player wins and his betInputLogic is multiplied by 10%. If one number matches, the betInputLogic is returned,
     * and if there are no matches, the player loses, and the betInputLogic amount is deducted from his balance.
     *
     */
    private void winCheck(KenoModel kenoMod) {
        boolean numberOne = false;
        boolean numberTwo = false;

        for (Integer element : kenoMod.getRandomSet()) {
            if (kenoMod.getGuessNumber1() == element) {
                numberOne = true;
            }
            if (kenoMod.getGuessNumber2() == element) {
                numberTwo = true;
            }
        }

        if (numberOne && numberTwo) {
            System.out.println("\n" + "\u001B[33m" + "<<You win your bet is multiplied by 10%>>" + "\u001B[0m");
            kenoMod.setTotalWin((int) (kenoMod.getBet() * 0.1) + kenoMod.getBet());
            kenoModel.setAccountBalance(kenoMod.getAccountBalance() + kenoMod.getTotalWin());



        } else if (!numberOne && numberTwo || numberOne && !numberTwo) {
            System.out.println("\n" + "\u001B[33m" + "<<You guessed one number your bet is returned>>" + "\u001B[0m");
            kenoMod.setTotalWin(0);
            kenoModel.setAccountBalance(kenoMod.getAccountBalance() + kenoMod.getTotalWin());


        } else {
            System.out.println("\n" + "\u001B[33m" + "Unfortunately you lost" + "\u001B[0m");
            kenoMod.setTotalWin(-kenoMod.getBet());
            kenoModel.setAccountBalance(kenoMod.getAccountBalance() + kenoModel.getTotalWin());
        }

    }

    /**
     *The "balanceCheck" method is designed to check the available funds on the account after each game.
     */
    private void balanceCheck(){
        if (kenoModel.getAccountBalance() == 0) {
            System.out.println("Your balance is 0. Please top up your balance!");
            balanceTop();
        }
    }


    /**
     *The "playAgain" method is for checking if the user wants to play again or not after each game is completed.
     */
    private void playAgain() {
        System.out.println("Will you play again ? (yes / no)");
        String answer = new Scanner(System.in).next();

        if (answer.toLowerCase().contains("yes")) {
            callingAllMethods();
        } else {
            System.out.println("GOOD LUCK!!");
        }
    }


    /**
     *The "callingAllMethods" method calls all the necessary methods in the correct order to start the game.
     */
    private void callingAllMethods() {

        printNumbers();
        guessAndBet();
        winCheck(kenoModel);
        System.out.println("Your balance: " + kenoModel.getAccountBalance() + " AMD" + "\n");
        balanceCheck();
        playAgain();

    }


    /**
     * The "play" method is designed to start the game and is called in the "main" method.
     */
    public void play() {
        balanceTop();
        callingAllMethods();
    }

    /**
     * Prompts the user to enter the bet size for the Keno game.
     * Validates the input and ensures it is within the allowed range (50 to the current account balance).
     * If the input is invalid, prompts the user to enter the correct bet size until a valid input is provided.
     *
     * @return the valid bet size within the allowed range
     */

    private int betInputLogic(){

        Scanner in = new Scanner(System.in);
        System.out.println("Place your bet");
        int bet = in.nextInt();
        if (bet >= 50 && bet <= kenoModel.getAccountBalance()) {
            return bet;
        } else {

            bet:
            while (true) {

                System.out.println("The bet you place cannot be greater than your account amount or  be less than 50!!");
                System.out.println("Please enter new bet size - ");

                in = new Scanner(System.in);
                int bet1 = in.nextInt();
                if (bet1 >= 50 && bet1 <= kenoModel.getAccountBalance()) {
                    bet = bet1;
                    break bet;
                }

            }
        }
        return bet;
    }

}