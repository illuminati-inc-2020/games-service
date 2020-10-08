package com.illuminati.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Min;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.illuminati.models.towersofhanoi.Tower;
import com.illuminati.models.towersofhanoi.TowersOfHanoi;
import com.illuminati.services.TowersOfHanoiService;

@RestController
@RequestMapping("/api/v1/towersofhanoi")
public class TowersOfHanoiController {

	private TowersOfHanoiService service;
	
	public TowersOfHanoiController(TowersOfHanoiService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/towers", method = RequestMethod.GET)
	public TowersOfHanoi towers(
			HttpServletRequest request, 
			HttpServletResponse response) {
		return service.towers();
	}
	
	@RequestMapping(value = "/new-game", method = RequestMethod.POST)
	public TowersOfHanoi newGame(
			@RequestParam(required=false, defaultValue="5") @Min(3) Integer numberOfRings,
			HttpServletRequest request, 
			HttpServletResponse response) {
		service.init(numberOfRings);
		return service.towers();
	}
	
	@RequestMapping(value = "/move", method = RequestMethod.PUT)
	public TowersOfHanoi move(
			@RequestParam Tower src,
			@RequestParam Tower dst,
			HttpServletRequest request, 
			HttpServletResponse response) {
		service.move(src, dst);
		return service.towers();
	}
	
}
