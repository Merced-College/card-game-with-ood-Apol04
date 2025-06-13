package cardGame;

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

		System.out.println("pairs is " + checkFor2Kind() ? "Yes" : "No"));

	}//end main

	//Start of new game

	//Allow the player to draw more cards

	public static void shuffle() {

		//shuffling the cards by deleting and reinserting
		for (int i = 0; i < deckOfCards.size(); i++) {
			int index = (int) (Math.random()*deckOfCards.size());
			Card c = deckOfCards.remove(index);
			//System.out.println("c is " + c + ", index is " + index);
			deckOfCards.add(c);
		}
	}

	//check for 2 of a kind in the players hand
	public static boolean checkFor2Kind() {

		int count = 0;
		for(int i = 0; i < playerCards.size() - 1; i++) {
			Card current = playerCards.get(i);
			Card next = playerCards.get(i+1);
			
			for(int j = i+1; j < playerCards.size(); j++) {
				next = playerCards.get(j);
				//System.out.println(" comparing " + current);
				//System.out.println(" to " + next);
				if(current.equals(next))
					count++;
			}//end of inner for
			if(count == 1)
				return true;

		}//end outer for
		return false;
	}
}//end class
