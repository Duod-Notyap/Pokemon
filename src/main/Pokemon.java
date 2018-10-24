package main;

public class Pokemon {
	public static String name;
	public static int hp;
	public static int att;
	public static int def;
	public static int spatt;
	public static int spdef;
	public static int speed;
	public static int m1;
	public static int m2;
	public static int m3;
	public static int m4;
	Pokemon(String a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k){
		name = a;
		hp = b;
		att = c;
		def = d;
		spatt = e;
		spdef = f;
		speed= g;
		m1 = h;
		m2 = i;
		m3 = j;
		m4 = k;
	}
	
	public static int adjHp(int diff) {
		hp += diff;
		return hp;
	}
	
	public static String name() {
		return name;
	}
	
	
}
