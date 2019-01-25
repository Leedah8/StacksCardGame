/*Khalidah Abdul-Muqtadir
 * CIS-211
 * Program a simple game that shuffles a deck of 52 cards 
 * and hands them out to two players randomly (26 each).  
 */

import java.util.ArrayList;
import java.util.Collections;


public class CardGameDriver {


	static ArrayList<Integer> deck = new ArrayList<>();
	static LinkedStack <Integer> shuffledDeck = new LinkedStack<>();
	static LinkedStack<Integer> playerOneHand = new LinkedStack<>();
	static LinkedStack<Integer> playerTwoHand = new LinkedStack<>();
	static LinkedStack<Integer> playerOneWins = new LinkedStack<>();
	static LinkedStack<Integer> playerTwoWins = new LinkedStack<>();
	
	//Keeping track of the wins for each player by initializing a variable 
	static int playerOneScoreCount = 0;
	static int playerTwoScoreCount = 0;

	public static void main(String[] args) {

		System.out.println("\n*********LET'S PLAY A CARD GAME*********\n");		

		for (int i = 0; i < 52; i++) { //initialize stack of cards: Add 52 cards to stack

			deck.add(i);

		}

		//Shuffles the original deck of cards
		Collections.shuffle(deck); 

		//Loops through the deck of cards, and pushes shuffled cards to new Stack of cards
		for (Integer deck: deck) 
			shuffledDeck.push(deck);		

		//method for dealing each player 26 cards
		dealPlayerCards(); 

		//method for comparing each player's top card
		cardGame();

		//compare the amount of cards in each player's winning hand and displays the winner
		winningHand();

	}


	public static void dealPlayerCards() {

		System.out.println("PlayerOne's hand: ");
		for (int i = 0; i < 26; i++) {
			if (!shuffledDeck.isEmpty()) {
				playerOneHand.push(shuffledDeck.pop());	
				System.out.print(playerOneHand.peek() + " ");
			}
		}

		System.out.println("\n");

		System.out.println("PlayerTwo's hand: ");
		for (int i = 0; i < 26; i++) {
			if (!shuffledDeck.isEmpty()) {
				playerTwoHand.push(shuffledDeck.pop());	
				System.out.print(playerTwoHand.peek() + " ");
			}
		}

	}

	public static void cardGame() {


		while(!playerOneHand.isEmpty() && !playerTwoHand.isEmpty()) {

			//			if (playerOneHand.equals(playerTwoHand)) {
			//				System.out.println("These players have equal hands."); //checks to see if the top cards are equal
			//			}

			if (playerOneHand.peek() > playerTwoHand.peek()) { //comparing player1 and player2's cards

				playerOneWins.push(playerTwoHand.pop());  
				playerOneWins.push(playerOneHand.pop());

				System.out.println("\n\nPlayer One wins this round!");
				System.out.println("Card # " + playerOneWins.peek() + " was added to Player One's winning deck.");
				++playerOneScoreCount;
			}
			else {
				playerTwoWins.push(playerOneHand.pop());
				playerTwoWins.push(playerTwoHand.pop());

				System.out.println("\n\nPlayer Two won this round!");
				System.out.println("Card # " + playerTwoWins.peek() + " was added to Player Two's winning deck.");
				++playerTwoScoreCount;
			}	
		} 
	}

	public static void winningHand() {

		System.out.println("\n*****************************************");
		
		
		if (playerOneScoreCount > playerTwoScoreCount) {
			System.out.println("PLAYER ONE WINS THE GAME WITH " + playerOneScoreCount + " POINTS!");
		}
		else if (playerTwoScoreCount > playerOneScoreCount) {
			System.out.println("PLAYER TWO WINS THE GAME WITH " + playerTwoScoreCount + " POINTS!");
			
		}
		else if (playerTwoScoreCount == playerOneScoreCount)  {
			System.out.println("         IT'S A TIE!");
		}
		System.out.println("*****************************************");

	}
}






