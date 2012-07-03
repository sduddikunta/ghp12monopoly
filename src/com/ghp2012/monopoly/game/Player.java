package com.ghp2012.monopoly.game;

/**
 * Represents a player.
 * @author Siddu Duddikunta
 * @author Raj Patel
 */
public class Player {
	
	private String name;
	private int money;
	
	public Player(String name, int money) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMoney() {
		return money;
	}
}
