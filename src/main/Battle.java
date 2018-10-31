package main;
import java.util.Scanner;
import main.Pokemon;

public class Battle {
	public static boolean killgame = false;
	static Scanner Input = new Scanner(System.in);
	static Pokemon enemPoke;
	static Pokemon userPoke;
	public static String battleSummary = "";
	public static void main(String[] args) {
		System.out.println("Choose a starter Pokemon:\n1)Charmander\n2)Bulbasaur(i swear to god if you pick this)\n3)Squirtle");

		int userPokeChoice = Input.nextInt();
		switch(userPokeChoice) {
			case 1: userPoke = new Pokemon("Charmander", 39, 52, 43, 60, 50, 65, 10, new Moves("Scratch", 40, 40, 1.0), new Moves("Flamethrower", 90, 15, 1.0), new Moves("Empty", 0, 0, 1.0), new Moves("Empty", 0, 0, 1.0), "fire", "");
					break;
			case 2: System.out.println("I tried to warn you...");
					userPoke = new Pokemon("Bulbasaur", 0, 49, 49, 65, 65, 45, 10, new Moves("Empty", 0, 0, 1.0), new Moves("Empty", 0, 0, 1.0), new Moves("Empty", 0, 0, 1.0), new Moves("Empty", 0, 0, 1.0), "plant", "");
					break;
			case 3: userPoke = new Pokemon("Squirtle", 44, 48, 65, 50, 64, 43, 10, new Moves("Scratch", 40, 40, 1.0), new Moves("Hydro Pump", 110, 5, 0.8), new Moves("Empty", 0, 0, 1.0), new Moves("Empty", 0, 0, 1.0), "water", "");
					break;
		}

		double enemy = Math.random()*3;
		if(enemy < 0.5) {
			enemPoke = new Pokemon("Growlithe", 55, 70, 45, 70, 50, 60, 10, new Moves("Scratch", 40, 40, 1.0), new Moves("Flamethrower", 90, 15, 1.0), new Moves("Empty", 0, 0, 1.0), new Moves("Empty", 0, 0, 1.0), "fire", "");
		}else if(enemy < 1.0) {
			enemPoke = new Pokemon("Eevee", 55, 55, 50, 45, 65, 505, 10, new Moves("Scratch", 40, 40, 1.0), new Moves("Empty", 0, 0, 1.0), new Moves("Empty", 0, 0, 1.0), new Moves("Empty", 0, 0, 1.0), "normal", "");
		}else if(enemy < 1.5) {
			enemPoke = new Pokemon("Magikarp", 20, 10, 55, 15, 20, 80, 10, new Moves("Splash", 0, 40, 1.0), new Moves("Empty", 0, 0, 1.0), new Moves("Empty", 0, 0, 1.0), new Moves("Empty", 0, 0, 1.0), "water", "");
		}else if(enemy < 2.0) {
			enemPoke = new Pokemon("Pikachu", 35, 55, 30, 50, 40, 90, 10, new Moves("Scratch", 40, 40, 1.0), new Moves("Thunderbolt", 90, 15, 1.0), new Moves("Empty", 0, 0, 1.0), new Moves("Empty", 0, 0, 1.0),"electric", "");
		}else if(enemy < 2.5) {
			enemPoke = new Pokemon("Clefairy", 70, 45, 48, 60, 65, 35, 10, new Moves("Scratch", 40, 40, 1.0), new Moves("Body Slam", 85, 15, 1.0), new Moves("Empty", 0, 0, 1.0), new Moves("Empty", 0, 0, 1.0), "fairy", "");
		}else if(enemy < 2.75) {
			enemPoke = new Pokemon("Arceus", 120, 120, 120, 120, 120, 120, 10, new Moves("Dragon Rush", 100, 10, 1.0), new Moves("Hyper Beam", 160, 10, 0.85), new Moves("Empty", 0, 0, 1.0), new Moves("Empty", 0, 0, 1.0), "normal", "");
		}else if(enemy < 3.0) {
			enemPoke = new Pokemon("Giratina", 150, 120, 100, 120, 100, 90, 10, new Moves("Dragon Rush", 100, 10, 1.0), new Moves("Hyper Beam", 160, 10, 0.85), new Moves("Empty", 0, 0, 1.0), new Moves("Empty", 0, 0, 1.0), "ghost", "dragon");
		}
		BattleStart(userPoke, enemPoke);
	}

	public static void BattleStart(Pokemon a, Pokemon b) {
		String priority;
		double rand;
		int menuChoice;

		System.out.println("BATTLE START\nCHALLENGER 1: " + a.name + "\nCHALLENGER 2: " + b.name);
		if(a.speed > b.speed) {
			priority = a.name;
		}else if(b.speed > a.speed){
			priority = b.name;
		}else{
			rand = Math.random();
			if(rand>0.5) {
				priority = b.name;
			}else {
				priority = a.name;
			}
		}
		System.out.println("You: " + a.name + ": " + a.hp);
		System.out.println("Enemy: " + b.name + ": " + b.hp);
		System.out.println("What would you like to do?\n1) Fight\n2) Bag\n3) Pokemon\n4) Run");
		menuChoice = Input.nextInt();
		switch(menuChoice) {
			case 1: fight(a, b, priority);
					break;
			case 2: bag();
					break;
			case 3: swapActive();
					break;
			case 4: run(a, b);
					break;
		}
		if(!killgame) {
			win(a, b);
		}
		killgame = true;
	}

	static int calcpower;
	static Pokemon c;
	static Pokemon d;
	public static int power;
	public static Moves powerMove;
	public static Moves enemAtt;
	public static Moves move1;
	public static Moves move2;
	public static int escapeAttempts = 0;
	public static int damage2;
	public static void fight(Pokemon a, Pokemon b, String priority) {
		System.out.println("What move would you like to use?\n1) " + a.m1.name + " | PP: " + a.m1.PP + "\n2) " + a.m2.name + " | PP: " + a.m2.PP + "\n3) " + a.m3.name + " : " + a.m3.PP + "\n4) " + a.m4.name + " : " + a.m4.PP);
		int userMoveChoice = Input.nextInt();
		int Mod = 1;
		int enemChoice = moveChoice(b);
		if(a.name == priority) {
			c = a;
			d = b;
			switch(enemChoice) {
				case 1: enemAtt = d.m1;
						break;
				case 2: enemAtt = d.m2;
						break;
				case 3: enemAtt = d.m3; 
						break;
				case 4: enemAtt = d.m4;
						break;
			}
			switch(userMoveChoice) {
				case 1: powerMove = c.m1;
						power = powerMove.power;
						break;
				case 2: powerMove = c.m2;
						power = powerMove.power;
						powerMove.PP -= 1;
						break;
				case 3: powerMove = c.m3;
						power = powerMove.power;
						break;
				case 4: powerMove = c.m4;
						power = powerMove.power;
						break;
			}
		}else if(b.name == priority) {
			c = b;
			d = a;
			switch(enemChoice) {
				case 1: enemAtt = c.m1;
						break;
				case 2: enemAtt = c.m2;
						break;
				case 3: enemAtt = c.m3;
						break;
				case 4: enemAtt = c.m4;
						break;
			}
			switch(userMoveChoice) {
				case 1: powerMove = d.m1;
						power = powerMove.power;
						break;
				case 2: powerMove = d.m2;
						power = powerMove.power;
						break;
				case 3: powerMove = d.m3;
						power = powerMove.power;
						break;
				case 4: powerMove = d.m4;
						power = powerMove.power;
						break;
			}
		}
		
		if (a == c && b == d) {
			move1 = powerMove;
			move2 = enemAtt;
		}else if(a == d && b == c) {
			move1 = enemAtt;
			move2 = powerMove;
		}
		powerMove.PP -= 1;
		enemAtt.PP -= 1;
		int damage = -1*((((2*c.level/5)+2)*power*(c.att/d.def)/50)+2)*Mod;
		if(!move1.name.equalsIgnoreCase("Empty") && move1.PP >= 0) {
			d.adjHp(damage);
			System.out.println(c.name + " used " + move1.name + "!");
			System.out.println(c.name + " hit " + d.name + " for " + damage + " damage!");
		}
		damage2 = -1*((((2*d.level/5)+2)*enemAtt.power*(d.att/c.def)/50)+2)*Mod;
		if(!move2.name.equalsIgnoreCase("Empty") && move2.PP >= 0) {
			System.out.println(d.name  + " used " + move2.name + "!");
			System.out.println(d.name + " hit " + c.name + " for " + damage + " damage!");
			c.adjHp(damage2);
		}
		battleSummary += c.name + " hit " + d.name + " for " + damage + " damage using " + move1.name + "!\n";
		battleSummary += d.name + " hit " + c.name + " for " + damage + " damage using " + move2.name + "!\n";
	}
	
	public static void bag() {
		
	}
	
	public static void run(Pokemon a, Pokemon b) {
		escapeAttempts += 1;
		double chance = ((((double)a.speed*32.0)/(((double)b.speed/4.0)%256.0))+30.0)*(double)escapeAttempts;
		double rand = Math.random()*255.0;
		if(rand<chance || chance >= 255 || b.speed == 0) {
			System.out.println("You escaped successfully");
			killgame = true;
		}else{
			System.out.println("Your escape attempt failed!");
			BattleStart(a, b);
		}
	}
	
	public static void swapActive() {
		
	}
	public static int moveChoice(Pokemon a) {
		double enemAttChoice = Math.random()*4.0;
		int enemChoice = ((int) enemAttChoice)+1;
		switch(enemChoice) {
			case 1 : if(a.m1.name.equalsIgnoreCase("Empty")) {
						moveChoice(a);
					}else {
						return enemChoice;
					}
					break;
			case 2 : if(a.m2.name.equalsIgnoreCase("Empty")) {
							moveChoice(a);
					}else {
						return enemChoice;
					}
					break;
			case 3 : if(a.m3.name.equalsIgnoreCase("Empty")) {
						moveChoice(a);
					}else {
						return enemChoice;
					}
				   	break;
			case 4 : if(a.m4.name.equalsIgnoreCase("Empty")) {
						moveChoice(a);
					}else {
						return enemChoice;
					}
					break;
		}
		return 1;
	}
	
	public static void win(Pokemon a, Pokemon b) {

		if(a.hp < 0) {
			System.out.println("YOU DIED");
			System.out.println(battleSummary);
		}else if(b.hp < 0){
			System.out.println("YOU WIN");
			System.out.println(battleSummary);
		}else {
			BattleStart(a, b);
		}
	}
}
