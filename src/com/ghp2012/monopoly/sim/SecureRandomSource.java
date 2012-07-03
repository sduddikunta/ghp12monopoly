package com.ghp2012.monopoly.sim;

import java.security.SecureRandom;

public class SecureRandomSource extends RandomSource {

	private SecureRandom random;
	
	public SecureRandomSource() {
		random = new SecureRandom();
	}

	@Override
	public int nextInt(int begin, int end) {
		return random.nextInt(end - begin) + begin;
	}
}
