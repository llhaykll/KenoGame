package Model;
import java.util.HashSet;

/**
 *The KenoModel class represents a model for playing Keno.
 *  It contains information about expected numbers, stakes, winnings,
 *  a randomly generated set of numbers and account balance.
 */

public class KenoModel {

    private int guessNumber1;
    private int guessNumber2;
    private int bet;
    private int totalWin;
    private HashSet<Integer> randomSet;
    private int accountBalance;


    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public HashSet<Integer> getRandomSet() {
        return randomSet;
    }

    public void setRandomSet(HashSet<Integer> randomSet) {
        this.randomSet = randomSet;
    }


    public int getTotalWin() {
        return totalWin;
    }

    public void setTotalWin(int totalWin) {
        this.totalWin = totalWin;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getGuessNumber1() {
        return guessNumber1;
    }

    public void setGuessNumber1(int guessNumber1) {
        this.guessNumber1 = guessNumber1;
    }

    public int getGuessNumber2() {
        return guessNumber2;
    }

    public void setGuessNumber2(int guessNumber2) {
        this.guessNumber2 = guessNumber2;
    }

}
