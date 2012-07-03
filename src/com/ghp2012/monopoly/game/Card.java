package com.ghp2012.monopoly.game;

/**
 * Superclass for chance and community chest cards.
 * 
 * @author Siddu Duddikunta
 * @author Raj Patel
 */
public class Card {
	private String name;
	private String description;
	private boolean replace = true;

	public Card() {

	}
	
	public boolean shouldReplace() {
		return replace;
	}

	public Card(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}
