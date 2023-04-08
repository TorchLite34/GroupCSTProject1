public class Player extends Person {

    static int playerCount = 1;
    Player(){
    }
    Player(double Balance, String name){
        setBalance(Balance);
        super.name = name;
        playerCount++;
    }
    public void makeBet(Dealer d, double ammount){
        setBalance(getBalance()-ammount);
    }
    public void hit() {
    }
    public void stay(){

    }
    public String toString(){
        return String.format("Player: %d \nName: %s \nBalance: $%.2f", playerCount, getName(), getBalance());
    }

}
