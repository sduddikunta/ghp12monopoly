package com.ghp2012.monopoly.sim;

import com.ghp2012.monopoly.game.BoardSpace;
import com.ghp2012.monopoly.game.Card.ChanceCard;
import com.ghp2012.monopoly.game.Card.CommunityChestCard;
import com.ghp2012.monopoly.game.GameBoard;
import com.ghp2012.monopoly.game.Player;

public class MonopolySimulation {

	private GameBoard board;
	public static final int numHouses = 0;

	public MonopolySimulation() {
		board = new GameBoard();
	}

	public void simulate() {
		GameInfo.fillGame(board);
		board.beginGame();
		while (true) {
			// TODO: Handle Go to Jail.
			// TODO: Handle in jail.
			// TODO: Handle Doubles.
			Player current = board.getNextPlayer(); // Get a player
			int[] roll = board.rollDice(); // Roll
			current.setLocation((current.getLocation() + roll[0] + roll[1]) % 40); // Move
			BoardSpace location = board.getSpace(current.getLocation()); // Location
			if (current.getLocation() - roll[0] - roll[1] < 0 // Check for pass GO
					&& !location.equals(BoardSpace.GO)) {
				current.changeMoney(200);
			}
			processSpace(current, location, roll);
		}
	}
	
	public void processSpace(Player current, BoardSpace location, int[] roll) {
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
					break;
				}
			}
			// Got the rent, apply it
			board.attemptTransfer(current, board.getByProperty(location.prop), rent);
		} else {
			if (location.cost >= 0) {
				board.attemptTransfer(current, board.getBank(), location.cost);
			} else {
				if (location.equals(BoardSpace.CHANCE)
						|| location.equals(BoardSpace.CHANCE_2)
						|| location.equals(BoardSpace.CHANCE_3)) {
					ChanceCard c = board.getNextChanceCard();
					c.doCard(current, this, board);
				} else if (location.equals(BoardSpace.COMMUNITY_CHEST)
						|| location.equals(BoardSpace.COMMUNITY_CHEST_2)
						|| location.equals(BoardSpace.COMMUNITY_CHEST_3)) {
					CommunityChestCard c = board.getNextCommunityCard();
					c.doCard(current, this, board);
				}
			}
		}
	}
	
	public void processSpace(Player p, int location, int[] roll) {
		processSpace(p, board.getSpace(location), roll);
	}
	
}
