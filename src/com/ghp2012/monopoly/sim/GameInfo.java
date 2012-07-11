package com.ghp2012.monopoly.sim;

import java.security.SecureRandom;

import com.ghp2012.monopoly.game.GameBoard;
import com.ghp2012.monopoly.game.Player;
import com.ghp2012.monopoly.game.Property;

public class GameInfo {
	
	public static int STARTING_MONEY = 5000;
	private static SecureRandom r;
	
	static {
		r = new SecureRandom();
	}
	
	public static void fillGame(GameBoard g) {
		g.addPlayer(new Player("Player 1", STARTING_MONEY));
		g.addPlayer(new Player("Player 2", STARTING_MONEY));
		g.addPlayer(new Player("Player 3", STARTING_MONEY));
		g.addPlayer(new Player("Player 4", STARTING_MONEY));
		g.addPlayer(new Player("Player 5", STARTING_MONEY));
		g.addPlayer(new Player("Player 6", STARTING_MONEY));
		g.addPlayer(new Player("Player 7", STARTING_MONEY));
		g.addPlayer(new Player("Player 8", STARTING_MONEY));
		for (Player p : g.getPlayers()) {
			while (true) {
				switch (r.nextInt(8)+1) {
				case 1:
					if (!g.getByProperty(Property.MEDITERRANEAN_AVENUE).equals(g.getBank())) continue;
					g.assignProperty(Property.MEDITERRANEAN_AVENUE, p);
					g.assignProperty(Property.BALTIC_AVENUE, p);
					break;
				case 2:
					if (!g.getByProperty(Property.ORIENTAL_AVENUE).equals(g.getBank())) continue;
					g.assignProperty(Property.ORIENTAL_AVENUE, p);
					g.assignProperty(Property.VERMONT_AVENUE, p);
					g.assignProperty(Property.CONNECTICUT_AVENUE, p);
					break;
				case 3:
					if (!g.getByProperty(Property.ST_CHARLES_PLACE).equals(g.getBank())) continue;
					g.assignProperty(Property.ST_CHARLES_PLACE, p);
					g.assignProperty(Property.STATES_AVENUE, p);
					g.assignProperty(Property.VIRGINIA_AVENUE, p);
					break;
				case 4:
					if (!g.getByProperty(Property.ST_JAMES_PLACE).equals(g.getBank())) continue;
					g.assignProperty(Property.ST_JAMES_PLACE, p);
					g.assignProperty(Property.TENNESSEE_AVENUE, p);
					g.assignProperty(Property.NEW_YORK_AVENUE, p);
					break;
				case 5:
					if (!g.getByProperty(Property.KENTUCKY_AVENUE).equals(g.getBank())) continue;
					g.assignProperty(Property.KENTUCKY_AVENUE, p);
					g.assignProperty(Property.INDIANA_AVENUE, p);
					g.assignProperty(Property.ILLINOIS_AVENUE, p);
					break;
				case 6:
					if (!g.getByProperty(Property.ATLANTIC_AVENUE).equals(g.getBank())) continue;
					g.assignProperty(Property.ATLANTIC_AVENUE, p);
					g.assignProperty(Property.VENTNOR_AVENUE, p);
					g.assignProperty(Property.MARVIN_GARDENS, p);
					break;
				case 7:
					if (!g.getByProperty(Property.PACIFIC_AVENUE).equals(g.getBank())) continue;
					g.assignProperty(Property.PACIFIC_AVENUE, p);
					g.assignProperty(Property.NORTH_CAROLINA_AVENUE, p);
					g.assignProperty(Property.PENNSYLVANIA_AVENUE, p);
					break;
				case 8:
					if (!g.getByProperty(Property.PARK_PLACE).equals(g.getBank())) continue;
					g.assignProperty(Property.PARK_PLACE, p);
					g.assignProperty(Property.BOARDWALK, p);
					break;
				}
				break;
			}
		}
	}
}
