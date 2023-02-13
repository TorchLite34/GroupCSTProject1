
import java.util.Random;

public class Card {

   private int suit; //clubs, spades, diamonds, hearts
   private int number;//1-13
   
   public Card() {
		Random rand = new Random();
		suit = rand.nextInt(4)+1;
		number = rand.nextInt(13)+1;
	}
	
	public Card(int suit, int num) {
		this.suit = suit;
		this.number = num;
	}
	

	
	public static String suitToString(int suit) {
		switch (suit) {
		case 1:
			return "Hearts";
		case 2:
			return "Clubs";
		case 3:
			return "Spades";
		case 4:
			return "Diamonds";
		case 5:
			return "null";
		default:
			return ""+suit;
		}
	}
	
	public static String numToString(int number) {
		switch (number) {
		case 11:
			return "Jack";
		case 12:
			return "Queen";
		case 13:
			return "king";
		case 1:
			return "Ace";
		case 14:
			return "Joker";
		default:
			return ""+number;
		}
	}
	public int getSuit() {
		return suit;
	}
	public int getNumber() {
		return number;
	}
	public void setSuit(int suit) {
		this.suit = suit;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public boolean equalsTo(Card c) {
		boolean bool = false;
		if(number == c.getNumber() && suit == c.getSuit()) {
			bool = true;
		}
		return bool;
	}
	
	public String toString() {
		String x = (suitToString(suit) == "null") ? "" : " of " + suitToString(suit);
		return numToString(number) + x;
	}

}
