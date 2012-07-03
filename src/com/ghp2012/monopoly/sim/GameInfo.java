package com.ghp2012.monopoly.sim;

import com.ghp2012.monopoly.game.GameBoard;
import com.ghp2012.monopoly.game.Player;

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
		// Add sets and properties, chance cards, community chest cards
	}
}
