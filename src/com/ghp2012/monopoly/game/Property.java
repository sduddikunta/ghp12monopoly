package com.ghp2012.monopoly.game;

public enum Property {
	
	ST_JAMES_PLACE("St. James Place", 0, 0, 0, 0, 0, 0);
	
	public final String name;
	public final int base;
	public final int one;
	public final int two;
	public final int three;
	public final int four;
	public final int hotel;

	private Property(String name, int baserent, int rent1, int rent2, int rent3, int rent4, int renthotel) {
		this.name = name;
		base = baserent;
		one = rent1;
		two = rent2;
		three = rent3;
		four = rent4;
		hotel = renthotel;
	}
}