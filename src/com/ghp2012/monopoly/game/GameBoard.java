package com.ghp2012.monopoly.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import com.ghp2012.monopoly.game.Card.ChanceCard;
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
	private ArrayBlockingQueue<Card> communityCards;
	private ArrayBlockingQueue<Player> queue;
	private ArrayList<Property> properties;

	/**
	 * Makes a new gameboard.
	 */
	public GameBoard() {
		players = new ArrayList<Player>();
		queue = new ArrayBlockingQueue<Player>(50);
		chanceCards = new ArrayBlockingQueue<ChanceCard>(50);
		communityCards = new ArrayBlockingQueue<Card>(50);
		properties = new ArrayList<Property>();
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
		/*ArrayList<Card> cards = new ArrayList<Card>();
		communityCards.drainTo(cards);
		while (!cards.isEmpty()) {
			int r = random.nextInt(0, p.size());
			communityCards.add(cards.get(r));
			cards.remove(r);
		}*/
		List<ChanceCard> cards = Arrays.asList(ChanceCard.values());
		while (!cards.isEmpty()) {
			int r = random.nextInt(0, p.size());
			chanceCards.add(cards.get(r));
			cards.remove(r);
		}
	}

	/**
	 * Get the next community chest card from the top of the pile.
	 * 
	 * @return the card
	 */
	public Card getNextCommunityCard() {
		Card c = communityCards.poll();
		if (c == null)
			return null;
		if (c.shouldReplace())
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
	public int rollDice() {
		return random.nextInt(1, 13);
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
	}

	public void addChanceCard(ChanceCard c) {
		chanceCards.add(c);
	}

	public void addCommunityChestCard(Card c) {
		communityCards.add(c);
	}

	public void addProperty(Property p) {
		properties.add(p);
	}
}