package com.valgriz.render;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.RepaintManager;

import com.valgriz.highscores.HighscoreManager;
import com.valgriz.main.Global;
import com.valgriz.main.Mouse;

public class HUD {
	// Objects
	private Global global = new Global();
	private SpriteSheet spriteSheet = new SpriteSheet();
	private Mouse mo = new Mouse();
	private Color dim = new Color(255, 255, 255, 15);
	private HighscoreManager hm = new HighscoreManager();
	// Variables
	static String font_map = "0123456789";
	String score;
	private int x;
	private int y;
	private int offset;
	private Color fade;
	private int opacity;
	private int counter;
	private int wait;
	private boolean saveHighscore;

	public HUD() {
		x = 100;
		y = 100;
		offset = 12;
		opacity = 0;
		score = String.valueOf(global.getScore());
		wait = 0;
	}

	public void update() {
		if (!global.isPaused) {
			counter++;
			if (counter % 2 == 0 && global.gameOver != true)
				global.setScore(global.getScore() + 1);
			score = String.valueOf(global.getScore());
		}
	}

	public void paint(Graphics g) {

		if (mo.isOutOfRange()) {
			g.setColor(new Color(255, 255, 255, 30));
			g.fillRect(0, 456, 360, 100);
			g.setColor(new Color(255, 255, 255, 10));
			g.fillRect(0, 456, 360, 6);
			wait++;
			if (wait > 10) {
				mo.setOutOfRange(false);
				wait = 0;
			}
		}
		for (int i = 0; i < score.length(); i++) {
			int pos = font_map.indexOf(score.charAt(i));
			g.drawImage(spriteSheet.getSprite(20 + (pos * 4), 0, 4, 5),
					12 + ((30 * i)), 468, 24, 30, null);
		}

		if (!global.isGameOver()) {
			saveHighscore = true;
		}

		if (global.isGameOver()) {
			if (saveHighscore) {
				HighscoreManager hm = new HighscoreManager();
				hm.addScore(0, 0, global.getScore());
				saveHighscore = false;
			}
			switch (mo.getHighlight()) {
			case 0:
				g.setColor(Color.white);
				g.fillRect(96, 270, 156, 66);
				break;
			case 1:
				g.setColor(Color.white);
				g.fillRect(96, 336, 78, 66);
				break;
			case 2:
				g.setColor(Color.white);
				g.fillRect(174, 336, 78, 66);
				break;
			}
			g.setColor(Color.black);
			g.fillRect(102, 162, 144, 102);
			g.fillRect(102, 276, 144, 54);
			g.fillRect(102, 342, 66, 54);
			g.fillRect(180, 342, 66, 54);
			if (global.isHighscore()) {
				g.drawImage(spriteSheet.getSprite(0, 89, 20, 13), 114, 174,
						120, 78, null);
			} else
				g.drawImage(spriteSheet.getSprite(20, 5, 20, 13), 114, 174,
						120, 78, null);
			g.drawImage(spriteSheet.getSprite(0, 84, 22, 5), 108, 288, 132, 30,
					null);
			g.drawImage(spriteSheet.getSprite(0, 16, 9, 5), 108, 354, 54, 30,
					null);
			g.drawImage(spriteSheet.getSprite(0, 22, 9, 7), 186, 348, 54, 42,
					null);

//			if (global.isHighscore()) {
//				g.setColor(Color.black);
//				g.fillRect(17 * 6, 14 * 6, 24 * 6, 11 * 6);
//
//			}
		}
		if (global.isPaused() && !global.isGameOver()) {
			switch (mo.getHighlight()) {
			case 1:
				g.setColor(Color.white);
				g.fillRect(96, 270, 78, 66);
				break;
			case 2:
				g.setColor(Color.white);
				g.fillRect(174, 270, 78, 66);
				break;
			}
			g.setColor(Color.black);
			g.fillRect(102, 162, 144, 102);
			g.fillRect(102, 276, 66, 54);
			g.fillRect(180, 276, 66, 54);
			g.drawImage(spriteSheet.getSprite(40, 5, 20, 13), 114, 174, 120,
					78, null);
			g.drawImage(spriteSheet.getSprite(0, 16, 9, 5), 108, 288, 54, 30,
					null);
			g.drawImage(spriteSheet.getSprite(0, 22, 9, 7), 186, 282, 54, 42,
					null);
			g.drawImage(spriteSheet.getSprite(12, 16, 3, 5), 325, 468, 18, 30,
					null);
		} else
			g.drawImage(spriteSheet.getSprite(9, 16, 3, 3), 325, 468, 18, 30,
					null);

	}
}
