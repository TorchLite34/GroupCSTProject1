import java.util.ArrayList;

public class Person {
    private double Balance;
    private ArrayList<Card> Hand = new ArrayList<>();
    public String name;
    Person(){
    }
    public void moveCard(int cardnumber, ArrayList<Card> Group) {		//im too dumb to use arraylist so heres a move thing
        Group.add(Hand.get(cardnumber));                             	//moves the card
        Hand.remove(cardnumber);
    }
    public ArrayList<Card> getHand() {
        return Hand;
    }
    public void setHand(ArrayList<Card> hand) {
        Hand = hand;
    }
    public double getBalance() {
        return Balance;
    }
    public void setBalance(double balance) {
        Balance = balance;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
