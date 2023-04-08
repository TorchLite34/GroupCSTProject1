import java.util.ArrayList;
import java.util.Collections;

public class Dealer extends Person{
    private GroupOfCards Deck = new GroupOfCards();
    private Card reference = new Card();

    Dealer(){

    }
    Dealer(double Balance, String name){
        setBalance(Balance);
        super.name = name;
    }
    public void makeDeck(int ammount) {				//lots of stupid logic i spent too long on, probably dont worry about it. ****creates a sorted array of cards****
        for(int i = 1; i <= ammount; i++){
            for(int s = 1; s <= 4; s++){
                for(int n = 1; n <= 13; n++) {
                    Deck.cards.add(new Card(s, n));
                }
            }
        }
    }

    public void shuffleDeck() {  					//Shuffles the array of card objects, im too dumb to use arraylist
        Collections.shuffle(Deck.cards);
    }
    public void showCard(Card c){
        System.out.println(c.toString());
    }

    public GroupOfCards getDeck() {
        return Deck;
    }
    public void deal(Player p, int ammount){
        for(int i = 0; 0 < ammount; i++){
            p.getHand().add(Deck.cards.get(i));
            Deck.cards.remove(i);
        }
    }
    public void setDeck(GroupOfCards deck) {
        Deck = deck;
    }
}
