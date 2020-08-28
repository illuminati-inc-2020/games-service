package com.freespirit.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.freespirit.models.tictactoe.TicTacToeBoard;
import com.freespirit.services.TicTacToeService;

@RestController
@RequestMapping("/api/v1/tictactoe")
public class TicTacToeController {
	
	public TicTacToeController(TicTacToeService service) {
		this.service = service;
	}
	
	private TicTacToeService service;
	
	@RequestMapping(value = "/board", method = RequestMethod.GET, produces = {"application/json"})
	@ResponseStatus(code = HttpStatus.OK)
	public TicTacToeBoard board(
			HttpServletRequest request, 
			HttpServletResponse response) {
		return service.board();
	}
	
	@RequestMapping(value = "/mark", method = RequestMethod.PUT, produces = {"application/json"})
	@ResponseStatus(code = HttpStatus.OK)
	public TicTacToeBoard mark(
			@RequestParam @Min(0) @Max(2) int row, 
			@RequestParam @Min(0) @Max(2) int column, 
			HttpServletRequest request, 
			HttpServletResponse response) {
		return service.mark(row, column);
	}
	
	@RequestMapping(value = "/new-game", method = RequestMethod.POST, produces = {"application/json"})
	@ResponseStatus(code = HttpStatus.OK)
	public TicTacToeBoard newGame(
			HttpServletRequest request, 
			HttpServletResponse response) {
		return service.clear();
	}

}
