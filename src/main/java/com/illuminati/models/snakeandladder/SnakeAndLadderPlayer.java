package com.illuminati.models.snakeandladder;

import com.illuminati.enums.Color;
import com.illuminati.models.Point;

import lombok.Data;

@Data
public class SnakeAndLadderPlayer {
	
	private String name;
	private Color color;
	private SnakeAndLadderBoard board;
	private Point position;
	private boolean won;
	
	public SnakeAndLadderPlayer(String name, Color color, SnakeAndLadderBoard board) {
		this.name = name;
		this.color = color;
		this.board = board;
		position = new Point(0, 0);
		won = false;
	}
	
}
