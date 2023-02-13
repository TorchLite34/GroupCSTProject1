
public class Deck extends Card{
	int top = 0;
	Card[] cards;
	
	public Deck(){ 									//No arg deck constructor makes a deck of 54 cards w jokers
		cards = new Card[54];
		makeDeck(54);		
	}
	
	public Deck(int length) {						//Length constructor, makes an unambiguous card list of any length no cards in it
		cards = new Card[length];					//This is for making things like hands, play  piles, discard piles
	}
	
	public Deck(int amountOfDecks, boolean jokers) {//Multideck constructor, makes a deck of decks for games that need more than 54 cards or no jokers
		int def = 54;								//amount of decks is 52 or 54 times an int amount. jokers is a boolean that includes 2 jokers in the deck
		def -= jokers == true ? 0 : 2;
		cards = new Card[def*amountOfDecks];
		makeDeck(def);
	}
	
	public void makeDeck(int length) {				//lots of stupid logic i spent too long on, probably dont worry about it. ****creates a sorted array of cards****
		int num = 1, suit = 1, count = 0; 			
		for(int i = 0; i < cards.length; i++) {		
			if(i%length == 0 && i != 0) {			//if the counter reaches the end of the deck it restarts to the beginning of the next
				count = 0;
				suit = 1;
				num = 1;
			}
			if (count < length-2 || length == 52) { //if the count is in the deck, do logic for making the cards lol			
				suit += (count%(13) == 0 && count != 0) ? 1 : 0;  
				num += (count%13 == 0 && count != 0) ? (-13) : 0;   
				cards[i] = new Card(suit, num++);	//make card objects
				count++;							//count only goes up here so the existence of jokers is irrelevant 
			}
			else if(length == 54) {
				cards[i] = new Card(5, 14);         //creates the Jokers
			}
			
		}
	}
	
	public void shuffleDeck() {  					//Shuffles the array of card objects, im too dumb to use arraylist
		Card tempcard;
		java.util.Random rand = new java.util.Random();
		for(int i = 0; i < cards.length; i++) {
			int temp = rand.nextInt(cards.length);
			tempcard = cards[i];					//Picks a random card and swaps it with the current one
			cards[i] = cards[temp];
			cards[temp] = tempcard;			
		}
	}
	

	public void moveCard(int cardnumber, Deck newDeck) {		//im too dumb to use arraylist so heres a move thing
		Card tempcard;
		top--;
		newDeck.cards[newDeck.getTop()] = cards[cardnumber]; 	//moves the card but only works if the array is big enough
		for(int i = cardnumber; i < cards.length; i++) {		//shifts the rest of the array so that there isnt any null space
			tempcard = i+1 == cards.length ? null : cards[i+1]; 
			cards[i] = tempcard;
		}
		newDeck.incrementTop();
	}
	
	public void incrementTop() {
		top++;
	}
	
	
	public int getTop() {
		return top;
	}
	
	public Card[] getCards() {
		return cards;
	}
	
	public void setTop(int top) {
		this.top = top;
	}
	public void setCards(Card[] cards) {
		this.cards = cards;
	}
	
	public String toString() {
		String str = "";
		for(int i = 0; i < cards.length; i++) {
			if(cards[i] == null) {
				break;
			}
			str += i%13 == 0 ? "\n" : "";										//spaces out the new lines modify the 13 to change how many cards on one line
			str += String.format("%-26s", (i+1) + ": " + cards[i].toString()); 	//formats the cards so its all in one line
		}
		return str;
	}
}
