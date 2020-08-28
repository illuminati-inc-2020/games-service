package com.freespirit.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freespirit.models.findwords.FindWordGame;
import com.freespirit.services.FindWordService;

@RestController
@RequestMapping("/api/v1/findword")
public class FindWordController {

	FindWordService service;
	
	public FindWordController(FindWordService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public FindWordGame show(
			HttpServletRequest request, 
			HttpServletResponse response) {
		return service.show();
	}
	
	@RequestMapping(value = "/add-letter", method = RequestMethod.PUT)
	public FindWordGame addLetter(
			@RequestParam Character letter,
			HttpServletRequest request, 
			HttpServletResponse response) {
		return service.addLetter(letter);
	}
	
	@RequestMapping(value = "/remove-letter", method = RequestMethod.PUT)
	public FindWordGame removeLetter(
			HttpServletRequest request, 
			HttpServletResponse response) {
		return service.removeLetter();
	}
	
	@RequestMapping(value = "/add-word", method = RequestMethod.PUT)
	public FindWordGame addWord(
			HttpServletRequest request, 
			HttpServletResponse response) {
		return service.addWord();
	}
	
	@RequestMapping(value = "/remove-word", method = RequestMethod.PUT)
	public FindWordGame removeWord(
			HttpServletRequest request, 
			HttpServletResponse response) {
		return service.removeWord();
	}
	
	@RequestMapping(value = "/new-game", method = RequestMethod.POST)
	public FindWordGame newGame(
			@RequestParam(required=false, defaultValue="10") @Min(5) @Max(20) Integer numberOfLetters,
			HttpServletRequest request, 
			HttpServletResponse response) {
		return service.init(numberOfLetters);
	}
	
}
