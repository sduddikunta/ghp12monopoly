package com.ghp2012.monopoly.sim;

import com.ghp2012.monopoly.game.GameBoard;
import com.ghp2012.monopoly.game.Player;
import com.ghp2012.monopoly.game.Property;

public class GameInfo {
	public static void fillGame(GameBoard g) {
		g.addPlayer(new Player("Player 1", 1500));
		g.addPlayer(new Player("Player 2", 1500));
		g.addPlayer(new Player("Player 3", 1500));
		g.addPlayer(new Player("Player 4", 1500));
		g.addPlayer(new Player("Player 5", 1500));
		g.addPlayer(new Player("Player 6", 1500));
		g.addPlayer(new Player("Player 7", 1500));
		g.addPlayer(new Player("Player 8", 1500));
		g.assignProperty(Property.MEDITERRANEAN_AVENUE, g.getPlayer(0));
		g.assignProperty(Property.BALTIC_AVENUE, g.getPlayer(0));
		g.assignProperty(Property.ORIENTAL_AVENUE, g.getPlayer(1));
		g.assignProperty(Property.VERMONT_AVENUE, g.getPlayer(1));
		g.assignProperty(Property.CONNECTICUT_AVENUE, g.getPlayer(1));
		g.assignProperty(Property.ST_CHARLES_PLACE, g.getPlayer(2));
		g.assignProperty(Property.STATES_AVENUE, g.getPlayer(2));
		g.assignProperty(Property.VIRGINIA_AVENUE, g.getPlayer(2));
		g.assignProperty(Property.ST_JAMES_PLACE, g.getPlayer(3));
		g.assignProperty(Property.TENNESSEE_AVENUE, g.getPlayer(3));
		g.assignProperty(Property.NEW_YORK_AVENUE, g.getPlayer(3));
		g.assignProperty(Property.KENTUCKY_AVENUE, g.getPlayer(4));
		g.assignProperty(Property.INDIANA_AVENUE, g.getPlayer(4));
		g.assignProperty(Property.ILLINOIS_AVENUE, g.getPlayer(4));
		g.assignProperty(Property.ATLANTIC_AVENUE, g.getPlayer(5));
		g.assignProperty(Property.VENTNOR_AVENUE, g.getPlayer(5));
		g.assignProperty(Property.MARVIN_GARDENS, g.getPlayer(5));
		g.assignProperty(Property.PACIFIC_AVENUE, g.getPlayer(6));
		g.assignProperty(Property.NORTH_CAROLINA_AVENUE, g.getPlayer(6));
		g.assignProperty(Property.PENNSYLVANIA_AVENUE, g.getPlayer(6));
		g.assignProperty(Property.PARK_PLACE, g.getPlayer(7));
		g.assignProperty(Property.BOARDWALK, g.getPlayer(7));
	}
}
