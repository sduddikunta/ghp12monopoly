package com.ghp2012.monopoly;

import java.io.PrintStream;

import com.ghp2012.monopoly.sim.GameInfo;
import com.ghp2012.monopoly.sim.MonopolySimulation;

/**
 * The main class for this program.
 * 
 * @author Siddu Duddikunta
 * @author Raj Patel
 */
public class Main {
	public static void main(String[] args) throws Exception {
		PrintStream actual = System.out;
		System.setOut(new PrintStream("/dev/null"));
		MonopolySimulation sim = new MonopolySimulation();
		int total = Integer.parseInt(args[0]);
		int money = Integer.parseInt(args[1]);
		int numHouses = Integer.parseInt(args[2]);
		MonopolySimulation.numHouses = numHouses;
		GameInfo.STARTING_MONEY = money;
		for (int i = 0; i < total; i++) {
			try {
				actual.print(sim.simulate() - 1);
			} catch (Exception ex) {
			}
			actual.flush();
		}
	}
}