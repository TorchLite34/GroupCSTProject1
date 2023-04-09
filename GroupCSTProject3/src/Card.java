
import java.util.Random;

public class Card {
	//Card class provides a foundation for all types of card games, having a string value and an int value for each card for easy displaying and calculating

    private int suit; //clubs, spades, diamonds, hearts

    private int number;//1-13

	private String s;

	private String n;

	public static String[] suits = "HEARTS,DIAMONDS,SPADES,CLUBS".split(",");

	public static String[] numbers = "ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING,JOKER".split(",");

   public Card() {					//creates a random card
		Random rand = new Random();
		suit = rand.nextInt(4)+1;
		number = rand.nextInt(13)+1;
		s = suits[suit-1];
		n = numbers[number-1];
	}
	
	public Card(int suit, int num) { //creates a specific card
		this.suit = suit;
		this.number = num;
		s = suits[suit-1];
		n = numbers[number-1];
	}

	public int getSuit() {
		return suit;
	}

	public int getNumber() {
		return number;
	}

	public void setSuit(int suit) {
		this.suit = suit;
		s = suits[suit-1];
	}

	public void setNumber(int number) {
		this.number = number;
		n = numbers[number-1];
	}

	public String toString() {
		return n + " of " + s;
	}
}
