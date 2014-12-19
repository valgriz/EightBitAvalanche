package com.valgriz.render;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Pixel {
	// Objects
	private SpriteSheet spriteSheet = new SpriteSheet();
	private BufferedImage sprite;
	private Random r = new Random();
	// Variables
	private double x;
	private double y;
	private int posX;
	private int posY;
	private static double dY;
	private double dX;
	private double index;

	Pixel() {
		y = -60;
		// -60
		// dY = .2;
	}

	public void update(int SCALE) {
		if (y < 0)
			y += (dY);
		index += .3;
		if (index > 5)
			index = 0;

		if (y < -80) {
			y = -80;
		} else if (y > -5)
			y = -5;

	}

	public void paint(Graphics g, int SCALE) {
		g.drawImage(spriteSheet.getSprite(0, ((int) index + 3) * 84, 60, 80),
				(int) x * SCALE, (int) y * SCALE,
				spriteSheet.getSprite(0, 84, 60, 80).getWidth() * SCALE,
				spriteSheet.getSprite(0, 84, 60, 80).getHeight() * SCALE, null);
	}

	public double getdY() {
		return dY;
	}

	public void setdY(double dY) {
		this.dY = dY;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
}
