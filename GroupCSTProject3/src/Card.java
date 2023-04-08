
import java.util.Random;

public class Card {

    private int suit; //clubs, spades, diamonds, hearts
    private int number;//1-13
	private String s;
	private String n;
	public static String[] suits = "HEARTS,DIAMONDS,SPADES,CLUBS".split(",");
	public static String[] numbers = "ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING,JOKER".split(",");



   public Card() {
		Random rand = new Random();
		suit = rand.nextInt(4)+1;
		number = rand.nextInt(13)+1;
		s = suits[suit-1];
		n = numbers[number-1];
	}
	
	public Card(int suit, int num) {
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
	public boolean equalsTo(Card c) {
		boolean bool = false;
		if(number == c.getNumber() && suit == c.getSuit()) {
			bool = true;
		}
		return bool;
	}
	public String toString() {
		return n + " of " + s;
	}

}
