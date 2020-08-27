package com.freespirit.models.tictactoe;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.freespirit.models.Line;

import lombok.Data;

@Data
public class TicTacToeBoard {
	
	@JsonProperty("board")
	private TicTacToeCell board[][];
	
	@JsonProperty("line")
	private Line line;
	
	@JsonProperty("status")
	private String status;
	
	public TicTacToeBoard() {
		board = new TicTacToeCell[][] {
			new TicTacToeCell[] {null, null, null},
			new TicTacToeCell[] {null, null, null},
			new TicTacToeCell[] {null, null, null}
		};
	}
	
	public TicTacToeCell getCell(int row, int column) {
		if(row < 0 || row > 2 || column < 0 || column > 2) return null;
		return board[row][column];
	}
	
}
