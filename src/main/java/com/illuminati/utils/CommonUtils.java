package com.illuminati.utils;

public class CommonUtils {
	
	public static int random(int min, int max) {
		return min + (int) (Math.random() * (max-min));
	}
	
	public static <D> D random(D[] array) {
		return array[random(0, array.length)];
	}
	
	public static int clamp(int n, int max) {
		return n > max ? max : n;
	}
	
	public static int clamp(int n, int min, int max) {
		return n < min ? min : n > max ? max : n;
	}

}
