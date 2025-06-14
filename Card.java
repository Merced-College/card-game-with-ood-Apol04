package cardGame;

// Name: Angel A. Cisneros
// Date: June 13 2025
// This class represents a playing card with a suit, name. value, and image

public class Card {
  private String cardSuit;
  private String CardName;
  private int cardValue;
  private String cardPicture;

  //Constructor
  public Card(String suit, String name, int value, String picture) {
    this.cardSuit = suit;
    this.cardName = name;
    this.cardValue = value;
    this.cardPicture = picture;
  }

  //Accessors
  public String getCardSuit() {
    return cardSuit;
  }
  
  public String getCardName() {
    return cardName;
  }

  public int getCardValue() {
    return cardValue;
  }

  public String getCardPicture() {
    return cardPicture;
  }

  //Mutators
  public void setCardSuit(String suit) {
    this.cardSuit = suit;
  }

  public void setCardName(String Name) {
    this.cardName = name;
  }

  public void setCardValue(int Value) {
    this.cardValue = value;
  }

  public void setCardPicture(String Picture) {
    this.cardPicture = picture;
  }

  //Override equals method to compare cards by name and suit
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Card) {
      Card other = (Card) obj;
      return this.cardName.equals(other.CardName) &&
        this.cardSuit.equals(other.cardSuit);
    }
    return false;
  }

  @Override
  public String toString() {
    return cardName + " of " +cardSuit +" (" + cardValue + " )";
  }
}
