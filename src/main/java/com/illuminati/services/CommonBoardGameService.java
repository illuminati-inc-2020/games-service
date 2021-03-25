package com.illuminati.services;

import com.illuminati.utils.CommonUtils;

public abstract class CommonBoardGameService {
	
	protected int rollDice() {
		return CommonUtils.random(1, 6);
	}

}
