package com.ghp2012.monopoly.sim;

import com.ghp2012.monopoly.game.BoardSpace;
import com.ghp2012.monopoly.game.GameBoard;
import com.ghp2012.monopoly.game.Player;

public class MonopolySimulation {

	private GameBoard board;
	private int numHouses = 0;

	public MonopolySimulation() {
		board = new GameBoard();
	}

	public void simulate() {
		GameInfo.fillGame(board);
		board.beginGame();
		while (true) {
			Player current = board.getNextPlayer(); // Get a player
			int[] roll = board.rollDice(); // Roll
			current.setLocation((current.getLocation() + roll[0] + roll[1]) % 40); // Move
			BoardSpace location = board.getSpace(current.getLocation()); // Location
			if (location.prop != null) { // It's a property, pay rent
				int rent = 0;
				if (location.prop.base == -1) {
					// It's a utility
					rent = (roll[0] + roll[1]) * 10;
				} else {
					// It's not a utility, calculate normally
					switch (numHouses) {
					case 0:
						rent = location.prop.base;
						break;
					case 1:
						rent = location.prop.one;
						break;
					case 2:
						rent = location.prop.two;
						break;
					case 3:
						rent = location.prop.three;
						break;
					case 4:
						rent = location.prop.four;
						break;
					case 5:
						rent = location.prop.hotel;
						break;
					default:
						// what....? Derped...
						rent = Integer.MAX_VALUE;
					}
				}
				//Got the rent, apply it
			}
		}
	}
}
