package com.ghp2012.monopoly;

import com.ghp2012.monopoly.sim.MonopolySimulation;

/**
 * The main class for this program.
 * @author Siddu Duddikunta
 * @author Raj Patel
 */
public class Main {
	public static void main(String[] args) {
		MonopolySimulation sim = new MonopolySimulation();
		sim.simulate();
	}
}