import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 10;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        while (attempts < maxAttempts) {
            attempts++;
            System.out.print("Enter your guess (or type 'q' to quit): ");
            String guess = scanner.nextLine();

            if (guess.equals("q")) {
                System.out.println("You're quitting? Alright, thanks for playing!");
                return;
            }

            if (!isGuessValid(guess)) {
                System.out.println("Invalid input. Please enter a number between 1 and 100.");
                continue;
            }

            int guessedNumber = Integer.parseInt(guess);

            if (guessedNumber < numberToGuess) {
                System.out.println("Your guess is too low. Try again!");
            } else if (guessedNumber > numberToGuess) {
                System.out.println("Your guess is too high. Try again!");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                return;
            }
        }

        System.out.println("Sorry, you didn't guess the number. The number was " + numberToGuess + ".");
        System.out.print("Would you like to play again? (y/n): ");
        String playAgain = scanner.nextLine();

        if (playAgain.equals("y")) {
            main(null);
        } else {
            System.out.println("Thanks for playing!");
        }
    }

    private static boolean isGuessValid(String guess) {
        try {
            int number = Integer.parseInt(guess);
            return number >= 1 && number <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}