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
	private int location = 0;
	private boolean hasChanceJailCard;
	private boolean hasCCJailCard;
	private int turnsInJail = 0;
	
	public Player(String name, int money) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMoney() {
		return money;
	}
	public void changeMoney(int howMuch){
		money = (money+howMuch);
	}
	public void addProperty(Property p){
		properties.add(p);
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public boolean hasChanceJailCard() {
		return hasChanceJailCard;
	}

	public void setHasChanceJailCard(boolean hasChanceJailCard) {
		this.hasChanceJailCard = hasChanceJailCard;
	}

	public boolean hasCCJailCard() {
		return hasCCJailCard;
	}

	public void setHasCCJailCard(boolean hasCCJailCard) {
		this.hasCCJailCard = hasCCJailCard;
	}

	public int getTurnsInJail() {
		return turnsInJail;
	}

	public void setTurnsInJail(int turnsInJail) {
		this.turnsInJail = turnsInJail;
	}
}
