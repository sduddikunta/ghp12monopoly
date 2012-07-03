package com.ghp2012.monopoly.sim;

public abstract class RandomSource {
	/**
	 * Generates the next random integer between begin (inclusive) and end (exclusive).
	 * @param begin the first possible integer (inclusive)
	 * @param end the last possible integer (exclusive)
	 * @return the random integer
	 */
	public abstract int nextInt(int begin, int end);
}