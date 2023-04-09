import java.util.Scanner;

public class BlackJack {
	//Blackjack class
	//Creates two objects a player and a dealer
	//player get a hand of two cards and draws until they go above 21 or are satisfied
	//dealer does the same as the player
	//once both are done whoever is closer to 21 or didn't go above 21 wins

	Dealer MrMann = new Dealer(500, "Dealer");
	Player p1 = new Player();

	public void play(){
		//Sets players name and balance
		p1.setName(getString(p1, "Enter your name"));
		p1.setBalance(getDouble(p1, "Enter your Balance"));

		//displays player info
		System.out.println(p1.toString());

		//dealer makes deck
		MrMann.makeDeck(1);
		MrMann.shuffleDeck();

		//game start
		System.out.println("\n________Starting________");
		while(true){
			//set things to 0
			MrMann.setPrizePool(0);
			p1.total = 0;
			MrMann.total = 0;
			p1.getHand().clear();
			MrMann.getHand().clear();

			//Make a bet
			System.out.println("Your balance: " + p1.getBalance());
			p1.makeBet(MrMann, getDouble(p1, "Enter a bet"));

			//Deal the cards
			MrMann.deal(p1, 2);
			MrMann.deal(MrMann, 2);

			//Sum the cards and display them
			printHand(p1);
			p1.calcTotal();
			printInt(p1.getTotal(), "The total is");
			System.out.println("\nDealers First card:");
			MrMann.showCard();
			System.out.println();

			//Ask for hit or stay
			if(!MrMann.hitOrStay(p1, MrMann)){
				continue;
			}

			//Show dealer hand
			printHand(MrMann);
			MrMann.calcTotal();
			printInt(MrMann.getTotal(), "The total is");

			//Draw for dealer
			MrMann.dealerHitOrStay(p1);

			//Declare winner
			MrMann.declairWinner(p1);
		}
	}

	public String getString(Player p, String message){ //convieniece DRY method
		System.out.println(String.format("Player %s; %s: ", p.playerCount, message));
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		return str;
	}

	public static Double getDouble(Person p, String message){ //convieniece DRY method
		System.out.println(String.format("%s; %s: ", p.name, message));
		Scanner scan = new Scanner(System.in);
		Double bal = scan.nextDouble();
		return bal;
	}

	public static void printHand(Person p){        //convieniece DRY method
		System.out.println("\n" + p.name + " 's Hand\n" + p.getHand().toString());
	}

	public static void printInt(int i, String message){ //convieniece DRY method
		System.out.println(String.format("%s : %s", message, i));
	}


}
