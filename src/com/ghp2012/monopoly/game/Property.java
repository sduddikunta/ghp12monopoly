package com.ghp2012.monopoly.game;

public enum Property {
	
	ST_JAMES_PLACE("St. James Place");
	
	private final String name;

	private Property(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}