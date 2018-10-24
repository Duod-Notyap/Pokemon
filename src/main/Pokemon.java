package main;

public class Pokemon {
	public String name;
	public int hp;
	public int att;
	public int def;
	public int spatt;
	public int spdef;
	public int speed;
	public int m1;
	public int m2;
	public int m3;
	public int m4;
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
	
	public int adjHp(int diff) {
		hp += diff;
		return hp;
	}
	
	
	
}
