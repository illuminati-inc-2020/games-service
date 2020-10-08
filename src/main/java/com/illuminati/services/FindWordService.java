package com.illuminati.services;

import org.springframework.stereotype.Service;

import com.illuminati.models.findwords.FindWordGame;

@Service
public class FindWordService {
	
	private DictionaryService dictionary;
	private FindWordGame game;
	
	public FindWordService(DictionaryService dictionary) {
		this.dictionary = dictionary;
		init(10);
	}
	
	public FindWordGame init(int numberOfLetters) {
		this.game = new FindWordGame(numberOfLetters);
		return game;
	}
	
	public FindWordGame show() {
		return game;
	}
	
	public FindWordGame addLetter(Character letter) {
		letter = Character.toUpperCase(letter);
		if(game.getLetters().remove(letter)) {
			game.setBuffer(game.getBuffer() + letter);
		}
		return game;
	}
	
	public FindWordGame removeLetter() {
		Character letter = game.getBuffer().charAt(game.getBuffer().length() - 1);
		game.setBuffer(game.getBuffer().substring(0, game.getBuffer().length() - 2));
		if(letter != null) {
			game.getLetters().add(letter);
		}
		return game;
	}
	
	public FindWordGame addWord() {
		String word = game.getBuffer();
		if(word.length() > 1 && dictionary.wordExists(word)) {
			game.getWords().add(word);
			game.setBuffer("");
		}
		return game;
	}
	
	public FindWordGame removeWord() {
		if(!game.getWords().isEmpty()) {
			String word = game.getWords().remove(game.getWords().size() - 1);
			word.chars().forEach(c -> game.getLetters().add((char)c));
		}
		return game;
	}

}

