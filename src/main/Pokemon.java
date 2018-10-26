package main;

public class Pokemon {
	public String name;
	public int hp;
	public int att;
	public int def;
	public int spatt;
	public int spdef;
	public int speed;
	public Moves m1;
	public Moves m2;
	public Moves m3;
	public Moves m4;
	public String type1;
	public String type2;
	Pokemon(String a, int b, int c, int d, int e, int f, int g, Moves h, Moves i, Moves j, Moves k, String l, String m){
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
		type1 = type1 != null ? type1 : l;
		type2 = type2 != null ? type2 : m;
	}

	public void adjHp(int diff) {
		hp += diff;
	}
	
	
	
}
