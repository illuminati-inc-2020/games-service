package com.illuminati.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.illuminati.models.Line;
import com.illuminati.models.Point;
import com.illuminati.models.tictactoe.TicTacToeBoard;
import com.illuminati.models.tictactoe.TicTacToeCell;

@Service
public class TicTacToeService {
	
	private TicTacToeBoard board;
	
	private int turn;
	
	public TicTacToeService() {
		board = new TicTacToeBoard();
		turn = 0;
	}
	
	public TicTacToeBoard board() {
		return board;
	}
	
	public TicTacToeBoard mark(int row, int column) {
		if(board.getStatus() != null) {
			clear();
		}
		if(board.getBoard()[row][column] == null) {
			board.getBoard()[row][column] = (turn % 2 == 0 ? TicTacToeCell.X : TicTacToeCell.O);
			findWinner(row, column);
			turn++;
		}
		if(turn == 9) {
			board.setStatus("Draw");
		}
		return board;
	}
	
	public TicTacToeBoard clear() {
		turn = 0;
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				board.getBoard()[i][j] = null;
		board.setLine(null);
		board.setStatus(null);
		return board;
	}
	
	private void findWinner(int row, int column) {
		if(turn > 3) {
			TicTacToeCell mark = board.getBoard()[row][column];
			int offset[][] = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, -1}};
			int multiplier[][] = {{2, 2}, {1, 1}, {0, 0}, {-1 ,-1}, {-2, -2}};
			for(int i = 0; i < offset.length; i++) {
				ArrayList<Point> line = new ArrayList<Point>();
				for(int m = 0; m < multiplier.length; m++) {
					int x = row + offset[i][0] * multiplier[m][0]; 
					int y = column + offset[i][1] * multiplier[m][1];
					if(board.getCell(x, y) == mark) {
						line.add(new Point(x, y));
					}
				}
				if(line.size() == 3) {
					board.setLine(new Line(line.get(0), line.get(2)));
					board.setStatus(mark + " Wins");
					return;
				}
			}
		}
	}

}
