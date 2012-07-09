package com.ghp2012.monopoly;

import java.io.PrintStream;

import com.ghp2012.monopoly.sim.MonopolySimulation;

/**
 * The main class for this program.
 * 
 * @author Siddu Duddikunta
 * @author Raj Patel
 */
public class Main {
	public static void main(String[] args) throws Exception {
		final int TIMES_TO_RUN = Integer.parseInt(args[0]);
		PrintStream s = System.out;
		System.setOut(new PrintStream("/dev/null"));
		int[] results = new int[8];
		s.println("Running Simulation...");
		for (int i = 0; i < TIMES_TO_RUN; i++) {
			MonopolySimulation sim = new MonopolySimulation();
			results[sim.simulate() - 1]++;
			if (i % (TIMES_TO_RUN/100) == 0) {
				s.println(i / (TIMES_TO_RUN/100)+"% done.");
			}
		}
		s.println("\nResults:");
		int total = 0;
		s.println("Purple: "+results[0]);
		total += results[0];
		s.println("Light Blue: "+results[1]);
		total += results[1];
		s.println("Pink: "+results[2]);
		total += results[2];
		s.println("Orange: "+results[3]);
		total += results[3];
		s.println("Red: "+results[4]);
		total += results[4];
		s.println("Yellow: "+results[5]);
		total += results[5];
		s.println("Green: "+results[6]);
		total += results[6];
		s.println("Dark Blue: "+results[7]);
		total += results[7];
		s.println("Total Runs: " + total);
	}
}