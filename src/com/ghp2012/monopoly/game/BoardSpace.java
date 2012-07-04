package com.ghp2012.monopoly.game;

public enum BoardSpace {
	GO("GO", -200), MEDITERRANEAN_AVE("Mediterranean Avenue",
			Property.MEDITERRANEAN_AVENUE), COMMUNITY_CHEST("Community Chest",
			0), BALTIC_AVE("Baltic Avenue", Property.BALTIC_AVENUE), INCOME_TAX(
			"Income Tax", 200), READING_RAILROAD("Reading Railroad",
			Property.READING_RAILROAD);

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
