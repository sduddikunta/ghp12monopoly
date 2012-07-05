package com.ghp2012.monopoly.sim;

import com.ghp2012.monopoly.game.GameBoard;

public class MonopolySimulation {
	
	private GameBoard board;
	
	public MonopolySimulation() {
		board = new GameBoard();
	}
	
	public void simulate() {
		GameInfo.fillGame(board);
		board.beginGame();
	}
}
