package main;
import java.util.Scanner;
import main.Pokemon;

public class Main {
	static Scanner Input = new Scanner(System.in);
	public static void main(String[] args) {
		Pokemon userPoke;
		System.out.println("Choose a starter Pokemon:\n1)Charmander\n2)Bulbasaur(i swear to god if you pick this)\n3)Squirtle");

		int userPokeChoice = Input.nextInt();
		switch(userPokeChoice) {
			case 1: userPoke = new Pokemon("Charmander", 39, 52, 43, 60, 50, 65, 40, 130, 0, 0);
					break;
			case 2: userPoke = new Pokemon("Bulbasaur", 45, 49, 49, 65, 65, 45, 0, 0, 0, 0);
					break;
			case 3: userPoke = new Pokemon("Squirtle", 44, 48, 65, 50, 64, 43, 40, 110, 0, 0);
					break;
		}
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
	
	public static void fight(Pokemon a, Pokemon b, String priority) {
		System.out.println("What move would you like to use?\n1) " + a.m1 + "\n2) " + a.m2 + "\n3) " + a.m3 + "\n4) " + a.m4);
		int userMoveChoice = Input.nextInt();
		int Mod = 1;
		int power;
		Pokemon c;
		Pokemon d;
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
		int damage = ((((20/5)+2)*power*(c.att/c.def)/50)+2)*Mod;
	}
}
