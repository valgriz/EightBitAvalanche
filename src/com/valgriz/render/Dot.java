package com.valgriz.render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.valgriz.main.Global;

public class Dot {
	// Objects
	private SpriteSheet spriteSheet = new SpriteSheet();
	private BufferedImage sprite;
	private Random r = new Random();
	private Global global = new Global();
	// Variables
	private double x;
	private double y;
	private int posX;
	private int posY;
	private double dY;
	private double dX;

	Dot() {
		x = r.nextInt(58);
		y = r.nextInt(84);
		posX = r.nextInt(8);
		posY = r.nextInt(2) + 14;
		dY = -.4;

	}

	public void update() {
		if (y < 0) {
			y = 84;
			x = r.nextInt(58);
			posX = r.nextInt(8);
			posY = r.nextInt(2) + 14;
		}
		y += dY - (global.getScore() * .0005);
	}

	public void paint(Graphics g, int SCALE) {
		g.drawImage(spriteSheet.getSprite(posX, posY, 1, 1), (int) x * SCALE,
				(int) y * SCALE, spriteSheet.getSprite(posX, posY, 1, 1)
						.getWidth() * SCALE,
				spriteSheet.getSprite(posX, posY, 1, 1).getHeight() * SCALE,
				null);
	}
}
