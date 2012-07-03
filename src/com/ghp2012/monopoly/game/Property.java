package com.ghp2012.monopoly.game;

public enum Property {
	
	MEDITERRANEAN_AVENUE("Mediterranean Avenue", 60, 2, 0, 0, 0, 0, 0),
	BALTIC_AVENUE("Baltic Avenue", 60, 4, 0, 0, 0, 0, 0),
	READING_RAILROAD("Reading Railroad", 200, 0, 0, 0, 0, 0, 0),
	ORIENTAL_AVENUE("Oriental Avenue", 100, 6, 0, 0, 0, 0, 0),
	VERMONT_AVENUE("Vermont Avenue", 100, 6, 0, 0, 0, 0, 0),
	CONNECTICUT_AVENUE("Connecticut Avenue", 120, 8, 0, 0, 0, 0, 0),
	ST_CHARLES_PLACE("St. Charles Place", 140, 10, 0, 0, 0, 0, 0),
	ELECTRIC_COMPANY("Electric Company", 150, 0, 0, 0, 0, 0, 0),
	STATES_AVENUE("States Avenue", 140, 10, 0, 0, 0, 0, 0),
	VIRGINIA_AVENUE("Virginia Avenue", 160, 12, 0, 0, 0, 0, 0),
	PENNSYLVANIA_RAILROAD("Pennsylvania Railroad", 200, 0, 0, 0, 0, 0, 0),
	ST_JAMES_PLACE("St. James Place", 180, 14, 0, 0, 0, 0, 0),
	TENNESSEE_AVENUE("Tennessee Avenue", 180, 14, 0, 0, 0, 0, 0),
	NEW_YORK_AVENUE("New York Avenue", 200, 16, 0, 0, 0, 0, 0),
	KENTUCKY_AVENUE("Kentuky Avenue", 220, 18, 0, 0, 0, 0, 0),
	INDIANA_AVENUE("Indiana Avenue", 220, 18, 0, 0, 0, 0, 0),
	ILLINOIS_AVENUE("Illinois Avenue", 240, 20, 0, 0, 0, 0, 0),
	B_AND_O_RAILROAD("B & O Railroad", 200, 0, 0, 0, 0, 0, 0),
	ATLANTIC_AVENUE("Atlantic Avenue", 260, 22, 0, 0, 0, 0, 0),
	VENTNOR_AVENUE("Ventnor Avenue", 260, 22, 0, 0, 0, 0, 0),
	WATER_WORKS("Water Works", 150, 0, 0, 0, 0, 0, 0),
	MARVIN_GARDENS("Marvin Gardens", 280, 22, 0, 0, 0, 0, 0),
	PACIFIC_AVENUE("Pacific Avenue", 300, 26, 0, 0, 0, 0, 0),
	NORTH_CAROLINA_AVENUE("North Carolina Avenue", 300, 26, 0, 0, 0, 0, 0),
	PENNSYLVANIA_AVENUE("Pennsylvania Avenue", 320, 28, 0, 0, 0, 0, 0),
	SHORT_LINE_RAILROAD("Short Line Railroad", 200, 0, 0, 0, 0, 0, 0),
	PARK_PLACE("Park Place", 350, 35, 0, 0, 0, 0, 0),
	BOARDWALK("Boardwalk", 400, 50, 0, 0, 0, 0, 0);
	
	public final String name;
	public final int initialPrice;
	public final int base;
	public final int one;
	public final int two;
	public final int three;
	public final int four;
	public final int hotel;

	private Property(String name, int price, int baserent, int rent1, int rent2, int rent3, int rent4, int renthotel) {
		this.name = name;
		initialPrice = price;
		base = baserent;
		one = rent1;
		two = rent2;
		three = rent3;
		four = rent4;
		hotel = renthotel;
	}
}