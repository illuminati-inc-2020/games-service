package com.illuminati.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Line {

	@JsonProperty("p1")
	Point p1;
	
	@JsonProperty("p2")
	Point p2;
	
	public Line() {
		this(new Point(), new Point());
	}
	
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
}
