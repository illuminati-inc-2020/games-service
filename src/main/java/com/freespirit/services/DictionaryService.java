package com.freespirit.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

@Service
public class DictionaryService {
	
	private static final String KEY = "Dictionary";
	
	private Jedis jedis;
	
	public DictionaryService() {
		this.jedis = new Jedis();
		createDictionary();
	}
	
	private void createDictionary() {
		try {
			Scanner words = new Scanner(new File("src/main/resources/words.txt"));
			while(words.hasNext()) {
				String word = words.nextLine().toUpperCase();
				jedis.hset(KEY, word, "");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean wordExists(String word) {
		return jedis.hget(KEY, word.toUpperCase()) != null;
	}

}
