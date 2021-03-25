package com.illuminati.models.snakeandladder;

import java.util.ArrayList;
import java.util.List;

import com.illuminati.constants.Constants;
import com.illuminati.enums.Color;
import com.illuminati.models.Line;
import com.illuminati.models.Point;
import com.illuminati.utils.CommonUtils;

import lombok.Data;

@Data
public class SnakeAndLadderBoard {
	
	private List<SnakeAndLadderPlayer> players;
	private int width;
	private int height;
	private int currentPlayerIndex;
	private List<Line> ladders;
	private List<Line> snakes;
	
	public SnakeAndLadderBoard(int nPlayers) {
		this(nPlayers, 10, 10, 5, 5);
	}
	
	public SnakeAndLadderBoard(int nPlayers, int width, int height) {
		this(nPlayers, width, height, 5, 5);
	}
	
	public SnakeAndLadderBoard(int nPlayers, int width, int height, int maxSnakes, int maxLadders) {
		players = new ArrayList<SnakeAndLadderPlayer>();
		nPlayers = CommonUtils.clamp(nPlayers, Constants.COLORS.length);
		for(int i = 0; i < nPlayers; i++) {
			Color color = Constants.COLORS[i];
			players.add(new SnakeAndLadderPlayer(color.toString(), color, this));
		}
		this.width = width;
		this.height = height;
		int nSnakes = CommonUtils.random(0, maxSnakes);
		snakes = new ArrayList<Line>();
		for(int i = 0; i < nSnakes; i++) {
			snakes.add(new Line(
					new Point(CommonUtils.random(0, width), CommonUtils.random(0, height)),
					new Point(CommonUtils.random(0, width), CommonUtils.random(0, height))
				));
		}
		int nLadders = CommonUtils.random(0, maxLadders);
		ladders = new ArrayList<Line>();
		
		for(int i = 0; i < nLadders; i++) {
			ladders.add(new Line(
					new Point(CommonUtils.random(0, width), CommonUtils.random(0, height)),
					new Point(CommonUtils.random(0, width), CommonUtils.random(0, height))
				));
		}
		currentPlayerIndex = 0;
	}

}
