package main;
import java.util.Scanner;
import main.Pokemon;

public class Main {
	static Scanner Input = new Scanner(System.in);
	static Pokemon enemPoke;
	static Pokemon userPoke;
	public static void main(String[] args) {
		System.out.println("Choose a starter Pokemon:\n1)Charmander\n2)Bulbasaur(i swear to god if you pick this)\n3)Squirtle");

		int userPokeChoice = Input.nextInt();
		switch(userPokeChoice) {
			case 1: userPoke = new Pokemon("Charmander", 39, 52, 43, 60, 50, 65, 40, 130, 0, 0);
					break;
			case 2: userPoke = new Pokemon("Bulbasaur", 0, 49, 49, 65, 65, 45, 0, 0, 0, 0);
					break;
			case 3: userPoke = new Pokemon("Squirtle", 44, 48, 65, 50, 64, 43, 40, 110, 0, 0);
					break;
		}
		double enemy = Math.random()*3;
		if(enemy < 0.5) {
			enemPoke = new Pokemon("Growlithe", 55, 70, 45, 70, 50, 60, 40, 90, 0, 0);
		}else if(enemy < 1.0) {
			enemPoke = new Pokemon("Eevee", 55, 55, 50, 45, 65, 55, 40, 0, 0, 0);
		}else if(enemy < 1.5) {
			enemPoke = new Pokemon("Magikarp", 20, 10, 55, 15, 20, 80, 0, 0, 0, 0);
		}else if(enemy < 2.0) {
			enemPoke = new Pokemon("Pikachu", 35, 55, 30, 50, 40, 90, 40, 110, 0, 0);
		}else if(enemy < 2.5) {
			enemPoke = new Pokemon("Clefairy", 70, 45, 48, 60, 65, 35, 40, 85, 0, 0);
		}else if(enemy < 2.75) {
			enemPoke = new Pokemon("Arceus", 120, 120, 120, 120, 120, 120, 110, 160, 0, 0);
		}else if(enemy < 3.0) {
			enemPoke = new Pokemon("Giratina", 150, 120, 100, 120, 100, 90, 110, 160, 0, 0);
		}
		BattleStart(userPoke, enemPoke);
	}

	public static void BattleStart(Pokemon a, Pokemon b) {
		String priority;
		double rand;
		int menuChoice;
		System.out.println("BATTLE START\nCHALLENGER 1: " + b.name() + "\nCHALLENGER 2: " + a.name());
		if(a.speed > b.speed) {
			priority = a.name();
		}else if(b.speed > a.speed){
			priority = b.name();
		}else{
			rand = Math.random();
			if(rand>0.5) {
				priority = b.name();
			}else {
				priority = a.name();
			}
		}
		System.out.println("What would you like to do?\n1) Fight\n2) Bag\n3) Pokemon\n4) Run");
		menuChoice = Input.nextInt();
		switch(menuChoice) {
			case 1: fight(a, b, priority);
					break;
			case 2: bag();
					break;
			case 3: swapActive();
					break;
			case 4: run();
					break;
		}
	}

	static int calcpower;
	static Pokemon c;
	static Pokemon d;
	public static void fight(Pokemon a, Pokemon b, String priority) {
		System.out.println("What move would you like to use?\n1) " + a.m1 + "\n2) " + a.m2 + "\n3) " + a.m3 + "\n4) " + a.m4);
		int userMoveChoice = Input.nextInt();
		int Mod = 1;
		int power;
		if(a.name() == priority) {
			c = a;
			d = b;
		}else if(b.name() == priority) {
			c = b;
			d = a;
		}
		
		switch(userMoveChoice) {
			case 1: power = c.m1;
					break;
			case 2: power = c.m2;
					break;
			case 3: power = c.m3;
					break;
			case 4: power = c.m4;
					break;
		}
		
		int damage = ((((20/5)+2)*calcpower*(c.att/c.def)/50)+2)*Mod;
	}
	
	public static void bag() {
		
	}
	
	public static void run() {
		
	}
	
	public static void swapActive() {
		
	}
	
}
