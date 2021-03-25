package com.illuminati.services;

public abstract class CommonBoardGameService {
	
	protected int rollDice() {
		return 1 + (int)(Math.random() * 5);
	}

}
