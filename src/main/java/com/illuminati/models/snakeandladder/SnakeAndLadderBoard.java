package com.illuminati.models.snakeandladder;

import java.util.List;

import lombok.Data;

@Data
public class SnakeAndLadderBoard {
	
	private List<SnakeAndLadderPlayer> players;
	private int width;
	private int height;
	private int currentPlayerIndex;

}
