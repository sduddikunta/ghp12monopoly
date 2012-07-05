package com.ghp2012.monopoly.game;

public enum BoardSpace {
			GO("GO", -200), 
			MEDITERRANEAN_AVE("Mediterranean Avenue",Property.MEDITERRANEAN_AVENUE), 
			COMMUNITY_CHEST("Community Chest",0),
			BALTIC_AVE("Baltic Avenue", Property.BALTIC_AVENUE), 
			INCOME_TAX("Income Tax", 200), 
			READING_RAILROAD("Reading Railroad",Property.READING_RAILROAD), 
			ORIENTAL_AVE("Oriental Avenue",Property.ORIENTAL_AVENUE),
			CHANCE("Chance", 0),
			VERMONT_AVE("Vermont Avenue", Property.VERMONT_AVENUE),
			CONNECTICUT_AVE("Connecticut Avenue", Property.CONNECTICUT_AVENUE),
			JAIL("Jail / Just Visiting", 0), 
			ST_CHARLES_PLACE("St. Charles Place",Property.ST_CHARLES_PLACE),
			ELECTRIC_COMPANY("Electric Company",Property.ELECTRIC_COMPANY), 
			STATES_AVE("States Avenue",	Property.STATES_AVENUE), 
			VIRGINIA_AVE("Virginia Avenue",	Property.VIRGINIA_AVENUE),
			PENNSYLVANIA_RAILROAD("Pennsylvania Railroad", Property.PENNSYLVANIA_RAILROAD), 
			ST_JAMES_PLACE("St. James Place", Property.ST_JAMES_PLACE),
			COMMUNITY_CHEST_2("Community Chest", 0),
			TENNESSEE_AVE("Tennessee Avenue", Property.TENNESSEE_AVENUE),
			NEW_YORK_AVE("New York Avenue", Property.NEW_YORK_AVENUE),
			FREE_PARKING("Free Parking", 0),
			KENTUCKY_AVE("Kentucky Avenue", Property.KENTUCKY_AVENUE),
			CHANCE_2("Chance", 0),
			INDIANA_AVE("Indiana Avenue", Property.INDIANA_AVENUE),
			ILLINOIS_AVE("Illinois Avenue", Property.ILLINOIS_AVENUE),
			B_AND_O_RAILROAD("B & O Railroad", Property.B_AND_O_RAILROAD),
			ATLANTIC_AVE("Atlantic Avenue", Property.ATLANTIC_AVENUE),
			VENTNOR_AVE("Ventnor Avenue", Property.VENTNOR_AVENUE),
			WATER_WORKS("Water Works", Property.WATER_WORKS),
			MARVIN_GARDENS("Marvin Gardens", Property.MARVIN_GARDENS),
			GO_TO_JAIL("Go to Jail", 0),
			PACIFIC_AVE("Pacific Avenue", Property.PACIFIC_AVENUE),
			NORTH_CAROLINA("North Carolina Avenue", Property.NORTH_CAROLINA_AVENUE),
			COMMUNITY_CHEST_3("Community Chest", 0),
			PENNSYLVANIA_AVE("Pennsylvania Avenue", Property.PENNSYLVANIA_AVENUE),			
			SHORT_LINE_RAILROAD("Short Line Railroad", Property.SHORT_LINE_RAILROAD),
			CHANCE_3("Chance", 0),
			PARK_PLACE(	"Park Place", Property.PARK_PLACE),
			LUXURY_TAX("Luxury Tax", 75),
			BOARDWALK("Boardwalk", Property.BOARDWALK);
			

	public final String name;
	public final int cost;
	public final Property prop;

	private BoardSpace(String name, int cost) {
		this.name = name;
		this.cost = cost;
		prop = null;
	}

	private BoardSpace(String name, Property prop) {
		this.name = name;
		cost = 0;
		this.prop = prop;
	}
}
