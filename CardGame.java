//package cardGame;

// Name: Angel A. Cisneros
// Date: June 13 2025

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Name: Your Name
 * Date: June 13, 2025
 * Program Description: A simple card game simulator that reads a deck of cards from a file,
 * shuffles them, deals cards to the player, and checks for pairs.
 * 
 * New Feature: Interactive draw feature allowing player to draw more cards.
 */

public class CardGame {

	private static ArrayList<Card> deckOfCards = new ArrayList<>();
	private static ArrayList<Card> playerCards = new ArrayList<>();

	public static void main(String[] args) {
		Scanner input = null;
		try {
			input = new Scanner(new File("cards.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found.");
			e.printStackTrace();
			return;
		}

		// Read and parse each card from the file
		while (input.hasNext()) {
			String[] fields  = input.nextLine().split(",");
			Card newCard = new Card(fields[0].trim(), fields[1].trim(),
					Integer.parseInt(fields[2].trim()), fields[3].trim());
			deckOfCards.add(newCard);	
		}

		shuffle();

		// Deal 5 cards to the player
		for (int i = 0; i < 5; i++) {
			playerCards.add(deckOfCards.remove(0));
		}

		System.out.println("Player's Cards:");
		for (Card c : playerCards)
			System.out.println(c);

		System.out.println("Pairs found: " + (checkFor2Kind() ? "Yes" : "No"));

		// ---------------- NEW FEATURE START ----------------
		// Allow the player to draw more cards dynamically
		Scanner userInput = new Scanner(System.in);
		String response;
		do {
			System.out.print("\nDo you want to draw another card? (yes/no): ");
			response = userInput.nextLine().trim().toLowerCase();

			if (response.equals("yes")) {
				if (!deckOfCards.isEmpty()) {
					Card drawn = deckOfCards.remove(0);
					playerCards.add(drawn);
					System.out.println("You drew: " + drawn);
				} else {
					System.out.println("No more cards in the deck!");
				}

				System.out.println("Updated hand:");
				for (Card c : playerCards)
					System.out.println(c);

				System.out.println("Pairs found: " + (checkFor2Kind() ? "Yes" : "No"));
			}
		} while (response.equals("yes"));
		// ---------------- NEW FEATURE END ----------------

		userInput.close();
	}

	// Shuffling the cards using Collections shuffle
	public static void shuffle() {
		Collections.shuffle(deckOfCards);
	}

	// Check for 2 of a kind in the player's hand
	public static boolean checkFor2Kind() {
		for (int i = 0; i < playerCards.size(); i++) {
			for (int j = i + 1; j < playerCards.size(); j++) {
				if (playerCards.get(i).equals(playerCards.get(j))) {
					return true;
				}
			}
		}
		return false;
	}
}
