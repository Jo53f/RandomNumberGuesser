package org.example;

import java.util.Random;
import java.util.Scanner;

public class App {
    Scanner input = new Scanner(System.in); // Input scanner object
    Random rand = new Random();
    boolean gameState = true;
    int targetNumber;
    int score = 0;

    /**
     * Generates a random integer between 0 and 100, assigning it to class attribute
     * targetNumber
     */
    public void generateInt(){
        targetNumber = rand.nextInt(0, 100);
    }

    public void StartGame() {
        generateInt();
        System.out.println("Welcome to Number Guesser");
        System.out.println("Guess an integer between 0 and 100");
        while (gameState) { // Keep looping the game until boolean gameState is set to false to end the game
            int guess = input.nextInt(); // Read the integer input
            input.nextLine(); // Used to clear the extra line from return carriage from previous input
            
            // Check if the guess was correct, printing one of two messages otherwise
            if (guess == targetNumber) {
                // Increment score and print message. Check if the player wants to keep playing,
                // generating a new Int for them to guess.
                System.out.println("Correct guess!!!");
                score++;
                System.out.println(String.format("Your current score is: %d", score));
                System.out.println("Would you like to play again?, answer y/n");
                String replaystr = input.nextLine();
                if (replaystr.equalsIgnoreCase("y")) {
                    generateInt();
                    System.out.println("Starting again, guess an integer between 0 and 100");
                } else {
                    System.out.println("Ending game");
                    gameState = false;
                }
            }
            else if (guess < targetNumber) {
                System.out.println("You guess is too low"); // Print message when guess is too low
            }
            else if (guess > targetNumber) {
                System.out.println("Your guess is too high"); // Print message when guess is too high
            }
        }
    }

    public static void main(String[] args) {
        new App().StartGame();
    }
}
