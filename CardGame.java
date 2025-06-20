//package cardGame;

// Name: Angel A. Cisneros
// Date: June 13 2025

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


public class CardGame {

	private static ArrayList<Card> deckOfCards = new ArrayList<>();
	private static ArrayList<Card> playerCards = new ArrayList<>();


	public static void main(String[] args) {

		Scanner input = null;
		try {
			input = new Scanner(new File("cards.txt"));
		} catch (FileNotFoundException e) {
			// error
			System.out.println("error: Cannont find file");
			e.printStackTrace();
			return;
		}
		
		// Read cards from file and populate deck
		while (input.hasNext()) {
			String[] fields = input.nextLine().split(",");
			//	public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
			Card newCard = new Card(fields[0].trim(), fields[1].trim(),
					Integer.parseInt(fields[2].trim()), fields[3].trim());
			deckOfCards.add(newCard);	
		}

		shuffle();

		//for(Card c: deckOfCards)
			//System.out.println(c);

		//deal the player 5 cards
		for(int i = 0; i < 5; i++) {
			playerCards.add(deckOfCards.remove(0));
		}
		
		System.out.println("Player's cards");
		for (Card c: playerCards)
			System.out.println(c);

		System.out.println("pairs is " + (checkFor2Kind() ? "Yes" : "No"));

	}//end main

	//START OF NEW FEATURE

	//Allow the player to draw more cards

	Scanner userInput = new Scanner(system.in);
	String response;
	do {
		System.out.print("\nDo you want to draw another card? (yes/no): ");
		response = userInput.nextLine().trim().toLowerCase();

		if (response.equals("yes")){
			if (!deckOfCards.isEmpty()) {
				Card drawn = deckOfCards.remove(0);
				playerCards.add(drawn);
				System.out.println("You drew: " + drawn);
			} else {
				System.out.println("No more cards in the deck!");
			}
			
			System.out.println("Updated Hand:");
			for (Card c : playerCards){
				System.out.println(c);

			System.out.println("Pairs found: " + (checkFor2Kind() ? "Yes" : "No"));
			}
		}
	} while (response.equals("yes"));
	userInput.close();
	
	// Shuffling the cards using Collections shuffle
	public static void shuffle() {
		Collections.shuffle(deckofCards);
	}



	// Check for 2 of a kind in the player's hand
	public static boolean checkFor2Kind() {
		for (int i = 0; i < playerCards.size(); i++) {
			for(int j = i+1; j < playerCards.size(); j++) {
				if (playerCards.get(i).equals(playerCards.get(j))) {
					return true;
				}

			}//end outer for
		}
		return false;
	}
}//end class
