package com.ghp2012.monopoly.game;

public enum Property {
	//Double the normal rents.
	//Utility rents need to be addressed.
	MEDITERRANEAN_AVENUE("Mediterranean Avenue", 60, 2, 10, 30, 90, 160, 250, 50),
	BALTIC_AVENUE("Baltic Avenue", 60, 4, 20, 60, 180, 320, 450, 50),
	READING_RAILROAD("Reading Railroad", 200, 200, 200, 200, 200, 200, 200, 0),
	ORIENTAL_AVENUE("Oriental Avenue", 100, 6, 30, 90, 270, 400, 550, 50),
	VERMONT_AVENUE("Vermont Avenue", 100, 6, 30, 90, 270, 400, 550, 50),
	CONNECTICUT_AVENUE("Connecticut Avenue", 120, 8, 40, 100, 300, 450, 600, 50),
	ST_CHARLES_PLACE("St. Charles Place", 140, 10, 50, 150, 450, 625, 750, 100),
	ELECTRIC_COMPANY("Electric Company", 150, -1, -1, -1, -1, -1, -1, 0),
	STATES_AVENUE("States Avenue", 140, 10, 50, 150, 450, 625, 750, 100),
	VIRGINIA_AVENUE("Virginia Avenue", 160, 12, 60, 180, 500, 700, 900, 100),
	PENNSYLVANIA_RAILROAD("Pennsylvania Railroad", 200, 200, 200, 200, 200, 200, 200, 0),
	ST_JAMES_PLACE("St. James Place", 180, 14, 70, 200, 550, 750, 950, 100),
	TENNESSEE_AVENUE("Tennessee Avenue", 180, 14, 70, 200, 550, 750, 950, 100),
	NEW_YORK_AVENUE("New York Avenue", 200, 16, 80, 220, 600, 800, 1000, 100),
	KENTUCKY_AVENUE("Kentuky Avenue", 220, 18, 90, 250, 700, 875, 1050, 150),
	INDIANA_AVENUE("Indiana Avenue", 220, 18, 90, 250, 700, 875, 1050, 150),
	ILLINOIS_AVENUE("Illinois Avenue", 240, 20, 100, 300, 750, 925, 1100, 150),
	B_AND_O_RAILROAD("B & O Railroad", 200, 200, 200, 200, 200, 200, 200, 0),
	ATLANTIC_AVENUE("Atlantic Avenue", 260, 22, 110, 330, 800, 975, 1150, 150),
	VENTNOR_AVENUE("Ventnor Avenue", 260, 22, 110, 330, 800, 975, 1150, 150),
	WATER_WORKS("Water Works", 150, -1, -1, -1, -1, -1, -1, 0),
	MARVIN_GARDENS("Marvin Gardens", 280, 22, 120, 360, 850, 1025, 1200, 150),
	PACIFIC_AVENUE("Pacific Avenue", 300, 26, 130, 390, 900, 1100, 1275, 200),
	NORTH_CAROLINA_AVENUE("North Carolina Avenue", 300, 26, 130, 390, 900, 1100, 1275, 200),
	PENNSYLVANIA_AVENUE("Pennsylvania Avenue", 320, 28, 150, 450, 1000, 1200, 1400, 200),
	SHORT_LINE_RAILROAD("Short Line Railroad", 200, 200, 200, 200, 200, 200, 200, 0),
	PARK_PLACE("Park Place", 350, 35, 175, 500, 1100, 1300, 1500, 200),
	BOARDWALK("Boardwalk", 400, 50, 200, 600, 1400, 1700, 2000, 200);
	
	public final String name;
	public final int initialPrice;
	public final int base;
	public final int one;
	public final int two;
	public final int three;
	public final int four;
	public final int hotel;
	public final int houseCost;

	private Property(String name, int price, int baserent, int rent1, int rent2, int rent3, int rent4, int renthotel, int houseCost) {
		this.name = name;
		initialPrice = price;
		base = baserent;
		one = rent1;
		two = rent2;
		three = rent3;
		four = rent4;
		hotel = renthotel;
		this.houseCost = houseCost;
	}
}