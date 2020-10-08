package com.illuminati.services;

import java.util.Stack;

import org.springframework.stereotype.Service;

import com.illuminati.models.towersofhanoi.Tower;
import com.illuminati.models.towersofhanoi.TowersOfHanoi;

@Service
public class TowersOfHanoiService {

	private TowersOfHanoi towersOfHanoi;
	
	public TowersOfHanoiService() {
		this.towersOfHanoi = new TowersOfHanoi();
	}
	
	public void init(Integer numberOfRings) {
		towersOfHanoi = new TowersOfHanoi(numberOfRings == null ? 5 : numberOfRings);
	}
	
	public TowersOfHanoi towers() {
		return towersOfHanoi;
	}
	
	public void move(Tower src, Tower dst) {
		Stack<Integer> srcTower = towersOfHanoi.getTower(src);
		if(srcTower.isEmpty())
			return;
		Stack<Integer> dstTower = towersOfHanoi.getTower(dst);
		int ring = srcTower.pop();
		if(dstTower.isEmpty() || dstTower.peek() > ring) {
			dstTower.push(ring);
			towers().setMoves(towers().getMoves() + 1);
		} else {
			srcTower.push(ring);
		}
	}
	
}
