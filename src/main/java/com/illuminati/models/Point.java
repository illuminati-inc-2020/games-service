package com.illuminati.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Point {

	@JsonProperty("x")
	private int x;
	
	@JsonProperty("y")
	private int y;
	
	public Point() {
		this(0, 0);
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
