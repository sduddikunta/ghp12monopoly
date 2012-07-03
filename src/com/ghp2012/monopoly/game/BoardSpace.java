package com.ghp2012.monopoly.game;

public class BoardSpace {
	private String name;
	private int cost;
	private Property represent;
	
	public BoardSpace(String name, int cost) {
		this.name = name;
		this.cost = cost;
	}
	
	public BoardSpace(String name, int cost, Property prop) {
		this.name = name;
		this.cost = cost;
		represent = prop;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCost() {
		return cost;
	}
	
	public Property getProperty() {
		return represent;
	}
}
