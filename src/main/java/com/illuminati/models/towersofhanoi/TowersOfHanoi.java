package com.illuminati.models.towersofhanoi;

import java.util.Stack;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TowersOfHanoi {
	
	@JsonProperty("a")
	Stack<Integer> a;
	
	@JsonProperty("b")
	Stack<Integer> b;
	
	@JsonProperty("c")
	Stack<Integer> c;
	
	@JsonProperty("moves")
	int moves;
	
	public TowersOfHanoi( ) {
		this(5);
	}
	
	public TowersOfHanoi(int numberOfRings) {
		a = new Stack<Integer>();
		b = new Stack<Integer>();
		c = new Stack<Integer>();
	for(int ring = numberOfRings; ring > 0; ring--) {
			a.push(ring);
		}
		moves = 0;
	}
	
	public Stack<Integer> getTower(Tower tower) {
		switch(tower) {
			case B: return b;
			case C: return c;
			default: return a;
		}
	}

}
