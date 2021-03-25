package com.illuminati.services;

import com.illuminati.models.Line;
import com.illuminati.models.snakeandladder.SnakeAndLadderBoard;
import com.illuminati.models.snakeandladder.SnakeAndLadderPlayer;
import com.illuminati.utils.CommonUtils;

public class SnakeAndLadderService extends CommonBoardGameService {
	
	private SnakeAndLadderBoard board;
	
	public SnakeAndLadderService(SnakeAndLadderBoard board) {
		this.board = board;
	}
	
	private SnakeAndLadderPlayer getPlayer(int playerIndex) {
		return board.getPlayers().get(playerIndex);
	}

	public void movePiece(int playerIndex) {
		SnakeAndLadderPlayer player = getPlayer(playerIndex);
		int output = rollDice();
		player.getPosition().setX(player.getPosition().getX() + output);
		if(player.getPosition().getX() > board.getWidth()) {
			player.getPosition().setX(player.getPosition().getX() % board.getWidth());
			player.getPosition().setY(CommonUtils.clamp(player.getPosition().getY() + 1, board.getHeight()));
		}
		for(Line ladder: board.getLadders()) {
			if(ladder.getP1().getX() == player.getPosition().getX() && ladder.getP1().getY() == player.getPosition().getY()) {	//p1 = bottom of ladder
				player.getPosition().setX(ladder.getP2().getX());
				player.getPosition().setY(ladder.getP2().getY());
				break;
			}
		}
		for(Line snake: board.getSnakes()) {
			if(snake.getP1().getX() == player.getPosition().getX() && snake.getP1().getY() == player.getPosition().getY()) {	//p1 = head of snake
				player.getPosition().setX(snake.getP2().getX());
				player.getPosition().setY(snake.getP2().getY());
				break;
			}
		}
	}
	
}
