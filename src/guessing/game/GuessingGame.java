package guessing.game;

import java.util.Random;
import java.util.Scanner;


public class GuessingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		rulesOfGame();
		guessTheNumber();
	}
	
	public static void rulesOfGame () {
		
		System.out.println("A random number will be generated.\nYou have 5 tries to guess the number correctly.");
	}
	
	public static void guessTheNumber() {
		
		int theRandomNumber; //Random number generated by the computer
		int theUserGuess;	 //Number guessed by the user
		int i;				 //For loop & if statement counter
		int tries = 5;		 //Number of guesses allowed
		
		Random random = new Random();
		theRandomNumber = random.nextInt(100) + 1;		//To get a result from the required range
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.println("Pick a number between 1 and 100:");
		theUserGuess = input.nextInt();
		
		//Error message outside of range so it doesn't count as a "try"
//		while (theUserGuess < 1 || theUserGuess > 100) {
//			
//			System.out.println("Your guess is not between 1 and 100, please try again:");
//			theUserGuess = input.nextInt();
//		}
//		
		//For loop, 5 iterations max + if statement. Use break; to jump out of the loop
		for (i = 1; i <= tries; i++) {
			
			//While loop moved inside for loop, placed first to weed out invalid input & not increment tries
			while (theUserGuess < 1 || theUserGuess > 100) {
				System.out.println("Your guess is not between 1 and 100, please try again:");
				theUserGuess = input.nextInt();
			}
			
			if (theUserGuess == theRandomNumber) {
				System.out.println("You win!");
				break;
			}
			
			else if (theUserGuess > theRandomNumber && i != tries) {
				System.out.println("Please pick a lower number:");
				theUserGuess = input.nextInt();
			}
			
			else if (theUserGuess < theRandomNumber && i != tries) {
				System.out.println("Please pick a higher number:");
				theUserGuess = input.nextInt();
			}
			
			else if (i == tries) {
				
				System.out.println("You lose, the number to guess was: " + theRandomNumber);
			}
		}
		
		input.close();		
	 }
}
