package com.valgriz.highscores;

import java.io.Serializable;

public class Score implements Serializable {

	private int score, c1, c2;

	public int getScore() {
		return score;
	}

	public Score(int c1, int c2, int score) {
		this.score = score;
		this.c1 = c1;
		this.c2 = c2;
	}

	public int getC1() {
		return c1;
	}

	public int getC2() {
		return c2;
	}
}
