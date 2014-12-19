package com.valgriz.render;

import java.awt.Color;
import java.awt.Graphics;

import com.valgriz.highscores.HighscoreManager;
import com.valgriz.main.Global;
import com.valgriz.main.Mouse;

public class HighscoreTable {
	// Objects
	private SpriteSheet spriteSheet = new SpriteSheet();
	private Global global = new Global();
	private Mouse mo = new Mouse();
	private HighscoreManager hm = new HighscoreManager();
	private Color c = new Color(192, 192, 192);
	// Variables
	private int SCALE;
	private int selection;
	private int[] aR;
	private static String font_map = "0123456789";

	public HighscoreTable(int SCALE) {
		this.SCALE = SCALE;
		selection = 4;
		aR = new int[hm.getHighscore().length];
		;
	}

	public void update() {
		if (global.isInHighScores() || global.isGameOver()) {
			aR = new int[hm.getHighscore().length];
			aR = hm.getHighscore();
		}
		if (global.isGameOver()) {
			if (global.getScore() > aR[5]) {
				global.setHighscore(true);
			}
		}
	}

	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(11 * SCALE, 4 * SCALE, 38 * SCALE, SCALE);
		g.drawImage(spriteSheet.getSprite(17, 61, 43, 5), 9 * SCALE, 7 * SCALE,
				42 * SCALE, 5 * SCALE, null);
		g.fillRect(11 * SCALE, 14 * SCALE, 38 * SCALE, SCALE);
		// g.fillRect(11 * SCALE, 18 * SCALE, 38 * SCALE, 5 * SCALE);
		// g.fillRect(11 * SCALE, 27 * SCALE, 38 * SCALE, 5 * SCALE);
		// g.fillRect(11 * SCALE, 36 * SCALE, 38 * SCALE, 5 * SCALE);
		// g.fillRect(11 * SCALE, 45 * SCALE, 38 * SCALE, 5 * SCALE);
		// g.fillRect(11 * SCALE, 54 * SCALE, 38 * SCALE, 5 * SCALE);
		// g.fillRect(11 * SCALE, 63 * SCALE, 38 * SCALE, 5 * SCALE);
		g.setColor(c);
		g.fillRect(23 * SCALE, 20 * SCALE, SCALE, SCALE);
		g.fillRect(23 * SCALE, 29 * SCALE, SCALE, SCALE);
		g.fillRect(23 * SCALE, 38 * SCALE, SCALE, SCALE);
		g.fillRect(23 * SCALE, 47 * SCALE, SCALE, SCALE);
		g.fillRect(23 * SCALE, 56 * SCALE, SCALE, SCALE);
		g.fillRect(23 * SCALE, 65 * SCALE, SCALE, SCALE);
		switch (mo.getHighlight()) {
		case 1:
			g.setColor(Color.white);
			g.fillRect(66, 426, 78, 66);
			break;
		case 2:
			g.setColor(Color.white);
			g.fillRect(216, 426, 78, 66);
			break;
		case 3:

			break;
		}
		g.setColor(Color.black);
		g.fillRect(72, 432, 66, 54);
		g.fillRect(222, 432, 66, 54);
		g.drawImage(spriteSheet.getSprite(0, 16, 9, 5), 13 * SCALE, 74 * SCALE,
				54, 30, null);
		g.drawImage(spriteSheet.getSprite(0, 22, 9, 7), 38 * SCALE, 73 * SCALE,
				54, 42, null);

		// Scores
		for (int i = 0; i < aR.length; i++) {
			String currScoreUp = String.valueOf(aR[i]);
			for (int j = 0; j < currScoreUp.length(); j++) {
				int pos = font_map.indexOf(currScoreUp.charAt(j));
				g.drawImage(spriteSheet.getSprite(20 + (pos * 4), 0, 4, 5),
						156 + ((30 * j)), 108 + (54 * i), 24, 30, null);
				g.drawImage(spriteSheet.getSprite(20 + (pos * 4), 0, 4, 5),
						156 + ((30 * j)), 108 + (54 * i), 24, 30, null);
			}
		}
	}
}