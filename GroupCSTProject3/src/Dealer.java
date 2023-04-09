import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Dealer extends Person{
    //dealer class extends the person class and has major control over the game
    //does things like:
    // shuffling the deck
    // dealing the cards
    // doing hits
    // declairing the winner
    // awarding the money

    private GroupOfCards Deck = new GroupOfCards();

    public double PrizePool = 0;

    Dealer(){}

    Dealer(double Balance, String name){
        setBalance(Balance);
        super.name = name;
    }

    public void makeDeck(int amount) {				//Nested for loops to create as many decks of 52 cards as you want
        for(int i = 1; i <= amount; i++){           //loop for amount of decks
            for(int s = 1; s <= 4; s++){            //loop for suits
                for(int n = 1; n <= 13; n++) {      //loop for cards
                    Deck.getCards().add(new Card(s, n));    //creates the card objects and adds to the deck arraylist
                }
            }
        }
    }

    public void shuffleDeck() {  					//Shuffles the array of card objects, im too dumb to use arraylist
        Collections.shuffle(Deck.getCards());
    }

    public void showCard(){
        System.out.println(getHand().get(0).toString());
    }

    public GroupOfCards getDeck() {
        return Deck;
    }

    public void deal(Person p, int ammount){
        ArrayList<Card> hand = p.getHand();
        for(int i = 0; i < ammount; i++){
            hand.add(Deck.getCards().get(0));
            Deck.getCards().remove(0);
        }
        p.setHand(hand);
    }

    public boolean hitOrStay(Person p, Dealer d){
        while(p.total <= 21){
            String hitOrStay = getPlayerInput(p, "Hit or Stay?").toLowerCase();

            //Do Hit or Stay
            if(hitOrStay.equals("hit")){
                p.hit(d);

                //Display the new hand
                readHand(p);

                //Handle bust if it happened
                p.calcTotal();
                readInt(p.getTotal(), "The total is");
                if(p.checkBust() == "Bust!!!"){
                    System.out.println("\n______Better luck next time______\n");
                    break;
                }
            } else if(hitOrStay.equals("stay")){
                p.stay();
                break;
            } else{
                System.out.println("that is not a valid option");
            }
        }
        if(p.total > 21){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean dealerHitOrStay(Person p){
        while(p.total > total){
            System.out.println("\nDealer Drawing");
            moveCard(getDeck().getCards());
            System.out.println(getHand().toString());
            calcTotal();
            readInt(getTotal(), "The total is");
            if(checkBust() == "Bust!!!"){
                System.out.println("\n________Dealer Bust!!!________");
                return false;
            }
        }
        return true;
    }

    public void declairWinner(Person p){
        if(p.total > total || total > 21){
            System.out.println("\n______You win!!!______\n");

            //Award money
            double newbal = getBalance() - PrizePool;
            setBalance(newbal);
            PrizePool = PrizePool*2;
            awardMoney(p);
        }
        else if(p.total == total){
            System.out.println("\n______Its a tie!!!______\n");
            double newbal = p.getBalance() + PrizePool;
            p.setBalance(newbal);
        }
        else{
            System.out.println("\n______Dealer Wins...______\n");
            double newbal = getBalance() + PrizePool;
            setBalance(newbal);
        }
    }

    public void awardMoney(Person p){
        p.setBalance(p.getBalance()+PrizePool);
    }

    public String getPlayerInput(Person p, String message){
        System.out.println(String.format("Player %s; %s: ", p.name, message));
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        return str;
    }

    public void readHand(Person p){        //for ease of use
        System.out.println("\n" + p.name + " 's Hand\n" + p.getHand().toString());
    }

    public void readInt(int i, String message){
        System.out.println(String.format("%s : %s", message, i));
    }

    public double getPrizePool() {
        return PrizePool;
    }

    public void setPrizePool(double prizePool) {
        PrizePool = prizePool;
    }

    public void setDeck(GroupOfCards deck) {
        Deck = deck;
    }
}
