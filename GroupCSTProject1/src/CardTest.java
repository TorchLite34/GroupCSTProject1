
public class CardTest {

	public static void main(String[] args) {
		
		Deck deck1 = new Deck(1, false); 	//make the deck
		deck1.shuffleDeck();				//shuffle the deck
		
		Deck hand1 = new Deck(20);			//use the length deck constructor to make a hand
		
		Deck discardPile = new Deck(100);	//use the length deck constructor to make a discard pile
		
		Deck playPile = new Deck(100);		//use the length deck constructor to make a play pile
		
		System.out.println(deck1.toString());
     		
     	System.out.println(hand1.toString());
     	
     	
     	for(int i = 0; i < 8; i++) {
         	deck1.moveCard(i, hand1);
     	}
     	System.out.print("\nDrawing 7 cards from the deck to hand1");
     	System.out.println(hand1.toString());

     	hand1.moveCard(2, playPile);
     	System.out.print("\nMoving Card 3 to playpile");
     	System.out.println(hand1.toString());

     	
     	hand1.moveCard(0, discardPile);
     	System.out.print("\nmoving card 1 to the discard pile from hand1");
     	System.out.println(hand1.toString());
     	
	}

}
