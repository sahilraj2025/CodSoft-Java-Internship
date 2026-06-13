package codsoft;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;
        System.out.println("===== NUMBER GUESSING GAME =====");

        while (playAgain) {

            int numberToGuess = random.nextInt(100) + 1; // 1 to 100
            int maxAttempts = 10;
            int attempts = 0;
            boolean guessedCorrectly = false;
            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                attempts++;
                if (guess == numberToGuess) {
                    System.out.println("🎉 Correct! You guessed the number.");
                    guessedCorrectly = true;

                    score += (maxAttempts - attempts + 1) * 10;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }
            if (!guessedCorrectly) {
                System.out.println("❌ You ran out of attempts.");
                System.out.println("The correct number was: " + numberToGuess);
            }
            System.out.println("Current Score: " + score);
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String choice = sc.next();
            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        System.out.println("\n===== GAME OVER =====");
        System.out.println("Final Score: " + score);
        sc.close();
    }
}
