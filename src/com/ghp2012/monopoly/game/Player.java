package com.ghp2012.monopoly.game;

import java.util.ArrayList;

/**
 * Represents a player.
 * @author Siddu Duddikunta
 * @author Raj Patel
 */
public class Player {
	
	private String name;
	private int money;
	private ArrayList<Property> properties;
	
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
