import java.util.ArrayList;

public class Person {
    //Person is the class that allows the dealer and player class to share functionality

    public String name;

    private double Balance;

    private ArrayList<Card> Hand = new ArrayList<>();

    public int total = 0;

    Person(){
    }

    public void moveCard(ArrayList<Card> Group) {		                    //moves the card
        Hand.add(Group.get(0));
        Group.remove(0);
    }

    public String checkBust(){
        return (total > 21) ? "Bust!!!" : "No Bust!!!";
    }

    public void calcTotal(){
        int sum = 0;
        for(int i = 0; i < getHand().size(); i++){                          //iterates for every card in the hand and adds their values
            int num = getHand().get(i).getNumber();
            if(num <= 10){
                sum += (num != 1) ? num : (sum + 10 <= 21) ? 10 : 1;        //ternary that adds the number if its not an ace, and if it is an ace it adds 10 unless theres a burst where it adds 1
            }
            else{
                sum += 10;
            }
        }
        total = sum;                        //sets the sum as the total
    }

    public void hit(Dealer d) {             //draws a card from the dealers deck
        moveCard(d.getDeck().getCards());
    }

    public void stay(){                     //does nothing as staying should
        //left unimplimented
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
