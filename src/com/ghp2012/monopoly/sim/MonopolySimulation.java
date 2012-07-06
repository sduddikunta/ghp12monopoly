package com.ghp2012.monopoly.sim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				r.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			int doublesCounter = 0;
			Player current = board.getNextPlayer(); // Get a player
			System.out.println("It is " + current.getName() + "'s turn.");
			System.out.println(current.getName() + " currently has $" + current.getMoney() + ".");
			if (current.isInJail()) {
				System.out.println(current.getName() + " is in jail.");
				current.setTurnsInJail(current.getTurnsInJail() + 1);
				if (current.getTurnsInJail() == 3) { // Must leave
					System.out.println(current.getName() + " must leave.");
					boolean usedCard = false;
					if (current.hasChanceJailCard()) {
						System.out.println(current.getName()
								+ " has a get out of jail free card.");
						current.setHasChanceJailCard(false);
						usedCard = true;
						board.addChanceCard(ChanceCard.GET_OUT_FREE);
					} else if (current.hasCCJailCard()) {
						System.out.println(current.getName()
								+ " has a get out of jail free card.");
						current.setHasCCJailCard(false);
						usedCard = true;
						board.addCommunityChestCard(CommunityChestCard.OUT_OF_JAIL);
					}
					int[] roll = board.rollDice(); // Roll
					System.out.println(current.getName() + " rolled a "
							+ (roll[0] + roll[1]) + " (" + roll[0] + ", "
							+ roll[1] + ").");
					if (!usedCard) { // Pay if we haven't used a card
						if (roll[0] != roll[1])
							board.attemptTransfer(current, board.getBank(), 50);
					}
					if (current.isBankrupt()) { // Check for bankruptcy on
												// getting out of jail
						continue;
					}
					current.setLocation((current.getLocation() + roll[0] + roll[1]) % 40); // Move
					BoardSpace location = board.getSpace(current.getLocation()); // Location
					System.out.println(current.getName() + " has landed on "
							+ location.name);
					processSpace(current, location, roll);
				} else { // We don't have to leave
					System.out.println(current.getName()
							+ " does not have to leave.");
					int[] roll = board.rollDice(); // Roll
					System.out.println(current.getName() + " rolled a "
							+ (roll[0] + roll[1]) + " (" + roll[0] + ", "
							+ roll[1] + ").");
					if (roll[0] == roll[1]) { // Never mind, yes we do
						current.setLocation((current.getLocation() + roll[0] + roll[1]) % 40); // Move
						BoardSpace location = board.getSpace(current
								.getLocation()); // Location
						System.out.println(current.getName()
								+ " has landed on " + location.name);
						processSpace(current, location, roll);
					}
				}
			}
			while (true) {
				if (doublesCounter == 3) {
					System.out.println(current.getName() + " has rolled too many doubles.");
					current.setLocation(10);
					current.setTurnsInJail(0);
					current.setInJail(true);
					System.out.println(current.getName() + " is now in jail.");
					break;
				}
				int[] roll = board.rollDice(); // Roll
				System.out.println(current.getName() + " rolled a " + (roll[0]
						+ roll[1]) + " (" + roll[0] + ", " + roll[1] + ").");
				current.setLocation((current.getLocation() + roll[0] + roll[1]) % 40); // Move
				BoardSpace location = board.getSpace(current.getLocation()); // Location
				System.out.println(current.getName() + " has landed on "
						+ location.name);
				if (location.equals(BoardSpace.GO_TO_JAIL)) {
					System.out.println(current.getName() + " is now in jail.");
					current.setLocation(10);
					current.setTurnsInJail(0);
					current.setInJail(true);
					break;
				}
				if (current.getLocation() - roll[0] - roll[1] < 0 // Check for
																	// pass GO
						&& !location.equals(BoardSpace.GO)) {
					System.out.println(current.getName() + " just passed go.");
					current.changeMoney(200);
				}
				processSpace(current, location, roll);
				if (roll[0] != roll[1]) { // We did not roll doubles
					break;
				} else
					doublesCounter++;
				System.out.println(current.getName() + " rolled doubles.");
			}
			System.out.println(current.getName() + " now has $"
					+ current.getMoney() + ".");
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
			System.out.println(current.getName() + " paid $" + rent + " in rent.");
			// Got the rent, apply it
			board.attemptTransfer(current, board.getByProperty(location.prop),
					rent);
		} else {
			if (location.cost >= 0) {
				board.attemptTransfer(current, board.getBank(), location.cost);
			} else {
				if (location.equals(BoardSpace.CHANCE)
						|| location.equals(BoardSpace.CHANCE_2)
						|| location.equals(BoardSpace.CHANCE_3)) {
					ChanceCard c = board.getNextChanceCard();
					System.out.println(current.getName() + " landed on chance and got " + c.card.getDescription());
					c.doCard(current, this, board);
				} else if (location.equals(BoardSpace.COMMUNITY_CHEST)
						|| location.equals(BoardSpace.COMMUNITY_CHEST_2)
						|| location.equals(BoardSpace.COMMUNITY_CHEST_3)) {
					CommunityChestCard c = board.getNextCommunityCard();
					System.out.println(current.getName() + " landed on community chest and got " + c.card.getDescription());
					c.doCard(current, this, board);
				}
			}
		}
	}

	public void processSpace(Player p, int location, int[] roll) {
		processSpace(p, board.getSpace(location), roll);
	}

}
