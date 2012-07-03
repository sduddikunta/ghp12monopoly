package com.ghp2012.monopoly.game;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

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
	private ArrayList<ChanceCard> chanceCards;
	private ArrayList<CommunityChestCard> communityCards;
	private ArrayBlockingQueue<Player> queue;

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
	 * Begin a new game by clearing the queue and re-randomizing it.
	 */
	public void beginGame() {
		queue.clear();
		ArrayList<Player> p = (ArrayList<Player>) players.clone();
		while (!p.isEmpty()) {
			int r = random.nextInt(0, p.size());
			queue.add(p.get(r));
			p.remove(r);
		}
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
	public int rollDice(){
		return(random.nextInt(1,13));
	}
	
}
