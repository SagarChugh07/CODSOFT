import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int totalRounds = 0;
        int totalAttempts = 0;

        String playAgain = "yes";

        while (playAgain.equalsIgnoreCase("yes")) {
            totalRounds++;
            System.out.println("\nRound " + totalRounds);
            int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            playGame(generatedNumber, maxAttempts);

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
    }

    public static void playGame(int generatedNumber, int maxAttempts) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int userGuess;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        while (attempts < maxAttempts) {
            attempts++;
            System.out.print("Attempt " + attempts + "/" + maxAttempts + ": Enter your guess: ");
            userGuess = scanner.nextInt();

            if (userGuess == generatedNumber) {
                System.out.println("Congratulations! You guessed the correct number " + generatedNumber + " in " + attempts + " attempts!");
                break;
            }
            else if (userGuess < generatedNumber) {
                System.out.println("Your guess is too low.");
            }
            else {
                System.out.println("Your guess is too high.");
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + generatedNumber + ".");
        }
    }
}
