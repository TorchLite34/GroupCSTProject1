public class Player extends Person {
    //Player class extends person and has a couple basic functionality
    //Has the ability to make bets and decide on hits or stays

    public static int playerCount = 0;
    Player(){
        super.name = "John Doe";
        setBalance(1000);
        playerCount++;
    }

    Player(double Balance, String name){
        setBalance(Balance);
        super.name = name;
        playerCount++;
    }

    public void makeBet(Dealer d, double ammount){
        setBalance(getBalance()-ammount);
        d.PrizePool += ammount;
    }

    public String toString(){
        return String.format("Player: %d \nName: %s \nBalance: $%.2f", playerCount, getName(), getBalance());
    }

}
