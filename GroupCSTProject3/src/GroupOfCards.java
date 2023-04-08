import java.util.ArrayList;

public class GroupOfCards extends Card{
	ArrayList<Card> cards = new ArrayList<Card>();
	
	public GroupOfCards() {

	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public String toString() {
		String str = "";
		for(int i = 0; i < cards.size(); i++) {
			if(cards.get(i) == null) {
				break;
			}
			str += i%13 == 0 ? "\n" : "";										//spaces out the new lines modify the 13 to change how many cards on one line
			str += String.format("%-26s", (i+1) + ": " + cards.get(i).toString()); 	//formats the cards so its all in one line
		}
		return str;
	}
}
