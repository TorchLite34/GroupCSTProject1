import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args) {
		
		Dealer MrMann = new Dealer(500, "MrMann");
		Player p1 = new Player();

		p1.setName(getNames(p1));
		p1.setBalance(getBalances(p1));

		System.out.println(p1.toString());

		MrMann.makeDeck(1);
		MrMann.shuffleDeck();


		System.out.println("Starting...");
		boolean cont = true;
		while(cont == true){
			MrMann.deal(p1, 2);
			printHand(p1);
		}
     	
	}
	public static String getInput(Player p){
		System.out.println("Player " + p.playerCount + " Hit or Stay?: ");
		Scanner scan = new Scanner(System.in);
		String opt = scan.next();
		return opt;
	}
	public static String getNames(Player p){
		System.out.println("Player " + p.playerCount + " Enter your Name: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		return name;
	}
	public static Double getBalances(Person p){
		System.out.println("Set Starting balance for " + p.name + ": ");
		Scanner scan = new Scanner(System.in);
		Double bal = scan.nextDouble();
		return bal;
	}
	public static void printDeck(Dealer d){		//for ease of use
		System.out.println(d.getDeck().toString());
	}
	public static void printHand(Person p){		//for ease of use
		System.out.println(p.getHand().toString());
	}
}
