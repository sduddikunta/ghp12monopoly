package com.ghp2012.monopoly.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import com.ghp2012.monopoly.game.Card.ChanceCard;
import com.ghp2012.monopoly.game.Card.CommunityChestCard;
import com.ghp2012.monopoly.sim.MonopolySimulation;
import com.ghp2012.monopoly.sim.RandomSource;
import com.ghp2012.monopoly.sim.SecureRandomSource;

/**
 * Represents the base monopoly gameboard.
 * 
 * @author Siddu Duddikunta
 * @author Raj Patel
 */
public class GameBoard {
	private RandomSource random = new SecureRandomSource();
	private ArrayList<Player> players;
	private ArrayBlockingQueue<ChanceCard> chanceCards;
	private ArrayBlockingQueue<CommunityChestCard> communityCards;
	private ArrayBlockingQueue<Player> queue;
	private List<Property> properties;
	private List<BoardSpace> spaces;
	private Player bank;
	private HashMap<Property, Player> map;

	/**
	 * Makes a new gameboard.
	 */
	public GameBoard() {
		players = new ArrayList<Player>();
		queue = new ArrayBlockingQueue<Player>(50);
		chanceCards = new ArrayBlockingQueue<ChanceCard>(50);
		communityCards = new ArrayBlockingQueue<CommunityChestCard>(50);
		properties = Arrays.asList(Property.values());
		spaces = Arrays.asList(BoardSpace.values());
		bank = new Player("The Bank", 0);
		map = new HashMap<Property, Player>(40);
		for (Property i : properties) {
			map.put(i, bank);
		}
	}

	public Player getBank() {
		return bank;
	}

	/**
	 * Returns the next player in the queue, adding the player to the end of the
	 * line afterwards.
	 * 
	 * @return the next player to move
	 */
	public Player getNextPlayer() {
		Player p = queue.poll();
		if (p != null)
			queue.add(p);
		return p;
	}

	/**
	 * Begin a new game by clearing the queues and re-randomizing them.
	 */
	public void beginGame() {
		queue.clear();
		ArrayList<Player> p = (ArrayList<Player>) players.clone();
		while (!p.isEmpty()) {
			int r = random.nextInt(0, p.size());
			queue.add(p.get(r));
			p.remove(r);
		}
		ArrayList<CommunityChestCard> cards = new ArrayList<CommunityChestCard>(
				Arrays.asList(CommunityChestCard.values()));
		while (!cards.isEmpty()) {
			int r = random.nextInt(0, cards.size());
			communityCards.add(cards.get(r));
			cards.remove(r);
		}
		ArrayList<ChanceCard> ccards = new ArrayList<ChanceCard>(
				Arrays.asList(ChanceCard.values()));
		while (!ccards.isEmpty()) {
			int r = random.nextInt(0, ccards.size());
			chanceCards.add(ccards.get(r));
			ccards.remove(r);
		}
	}

	/**
	 * Get the next community chest card from the top of the pile.
	 * 
	 * @return the card
	 */
	public CommunityChestCard getNextCommunityCard() {
		CommunityChestCard c = communityCards.poll();
		if (c == null)
			return null;
		if (c.card.shouldReplace())
			communityCards.add(c);
		return c;
	}

	/**
	 * Get the next chance card from the top of the pile.
	 * 
	 * @return the card
	 */
	public ChanceCard getNextChanceCard() {
		ChanceCard c = chanceCards.poll();
		if (c == null)
			return null;
		if (c.card.shouldReplace())
			chanceCards.add(c);
		return c;
	}

	/**
	 * Return a random integer between 1 and 12.
	 * 
	 * @return a roll of the dice
	 */
	public int[] rollDice() {
		return new int[] { random.nextInt(1, 7), random.nextInt(1, 7) };
	}

	// Getters, setters, other stuff
	public ArrayList<Player> getPlayers() {
		return players;
	}

	public Player getPlayer(int index) {
		return players.get(index);
	}

	public void addPlayer(Player p) {
		players.add(p);
	}

	public void removePlayer(Player p) {
		players.remove(p);
		queue.remove(p);
	}

	public void addChanceCard(ChanceCard c) {
		chanceCards.add(c);
	}

	public void addCommunityChestCard(CommunityChestCard c) {
		communityCards.add(c);
	}

	public void addProperty(Property p) {
		properties.add(p);
	}

	public void assignProperty(Property p, Player player) {
		map.put(p, player);
		player.changeMoney(-p.initialPrice);
		player.changeMoney(-p.houseCost * MonopolySimulation.numHouses);
		player.addProperty(p);
	}

	public BoardSpace getSpace(int i) {
		return spaces.get(i);
	}

	public Player getByProperty(Property p) {
		return map.get(p);
	}

	public void attemptTransfer(Player p1, Player p2, int amount) {
		if ((p1.getMoney() - amount < 0) && !p1.getName().equals(p2.getName())) { // We're bankrupt :(
			if (p1.getMoney() > 0) {
				p2.changeMoney(p1.getMoney());
				p1.changeMoney(-p1.getMoney());
			}
			p1.setBankrupt(true);
			if (queue.size() > 1)
				queue.remove(p1);
		} else { // Not bankrupt
			p1.changeMoney(-amount);
			p2.changeMoney(amount);
		}
	}

	public int getPlayersLeft() {
		return queue.size();
	}

}