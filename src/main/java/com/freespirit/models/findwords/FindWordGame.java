package com.freespirit.models.findwords;

import java.util.ArrayList;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FindWordGame {

	@JsonProperty("letters")
	private ArrayList<Character> letters;

	@JsonProperty("buffer")
	private String buffer;
	
	@JsonProperty("words")
	private ArrayList<String> words;
	
	public FindWordGame(int numberOfLetters) {
		letters = new ArrayList<Character>();
		for(int i = 0; i < numberOfLetters; i++) {
			letters.add((char)('A' + (Math.abs(new Random().nextInt()) % 26)));
		}
		buffer = "";
		words = new ArrayList<String>();
	}
	
	public FindWordGame() {
		this(10);
	}
	
}
