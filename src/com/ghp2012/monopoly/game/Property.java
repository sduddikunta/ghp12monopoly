package com.ghp2012.monopoly.game;

public enum Property {
	
	MEDITERRANEAN_AVENUE("Mediterranean Avenue", 0, 0, 0, 0, 0, 0),
	BALTIC_AVENUE("Baltic Avenue", 0, 0, 0, 0, 0, 0),
	READING_RAILROAD("Reading Railroad", 0, 0, 0, 0, 0, 0),
	ORIENTAL_AVENUE("Oriental Avenue", 0, 0, 0, 0, 0, 0),
	VERMONT_AVENUE("Vermont Avenue", 0, 0, 0, 0, 0, 0),
	ST_CHARLES_AVENUE("St. Charles Place", 0, 0, 0, 0, 0, 0),
	ELECTRIC_COMPANY("Electric Company", 0, 0, 0, 0, 0, 0),
	STATES_AVENUE("States Avenue", 0, 0, 0, 0, 0, 0),
	VIRGINIA_AVENUE("Virginia Avenue", 0, 0, 0, 0, 0, 0),
	PENNSYLVANIA_RAILROAD("Pennsylvania Railroad", 0, 0, 0, 0, 0, 0),
	ST_JAMES_PLACE("St. James Place", 0, 0, 0, 0, 0, 0),
	TENNESSEE_AVENUE("Tennessee Avenue", 0, 0, 0, 0, 0, 0),
	NEW_YORK_AVENUE("New York Avenue", 0, 0, 0, 0, 0, 0),
	KENTUCKY_AVENUE("Kentuky Avenue", 0, 0, 0, 0, 0, 0),
	INDIANA_AVENUE("Indiana Avenue", 0, 0, 0, 0, 0, 0),
	ILLINOIS_AVENUE("Illinois Avenue", 0, 0, 0, 0, 0, 0),
	B_AND_O_RAILROAD("B & O Railroad", 0, 0, 0, 0, 0, 0),
	ATLANTIC_AVENUE("Atlantic Avenue", 0, 0, 0, 0, 0, 0),
	VENTNOR_AVENUE("Ventnor Avenue", 0, 0, 0, 0, 0, 0),
	WATER_WORKS("Water Works", 0, 0, 0, 0, 0, 0),
	MARVIN_GARDENS("Marvin Gardens", 0, 0, 0, 0, 0, 0),
	PACIFIC_AVENUE("Pacific Avenue", 0, 0, 0, 0, 0, 0),
	NORTH_CAROLINA_AVENUE("North Carolina Avenue", 0, 0, 0, 0, 0, 0),
	PENNSYLVANIA_AVENUE("Pennsylvania Avenue", 0, 0, 0, 0, 0, 0),
	SHORT_LINE_RAILROAD("Short Line Railroad", 0, 0, 0, 0, 0, 0),
	PARK_PLACE("Park Place", 0, 0, 0, 0, 0, 0),
	BOARDWALK("Boardwalk", 0, 0, 0, 0, 0, 0);
	
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