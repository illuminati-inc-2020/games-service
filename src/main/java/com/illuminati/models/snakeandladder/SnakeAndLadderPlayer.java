package com.illuminati.models.snakeandladder;

import com.illuminati.enums.Color;

import lombok.Data;

@Data
public class SnakeAndLadderPlayer {
	
	private String name;
	private Color color;
	private SnakeAndLadderBoard board;
	private int position;
	
}
