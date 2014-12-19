package com.valgriz.render;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.valgriz.main.Global;

public class Burst {
	// Objects
	private SpriteSheet spriteSheet = new SpriteSheet();
	private BufferedImage sprite;
	private Global global = new Global();
	// Variables
	private double x;
	private double y;
	private int posX;
	private int posY;
	private int counter;
	private double dY;
	private double dX;

	public Burst() {
		x = 10;
		y = 10;
		counter = 0;
		global.setPixelBurst(false);
	}

	public void update() {
		if (global.isPixelBurst()) {
			if (counter % 2 == 1) {
				if (posX < 40)
					posX += 20;
				else {
					posX = 0;
					posY += 20;
					if (posY > 60) {
						posY = 0;
					}
				}
			}
			if (posX >= 40 && posY >= 60) {
				global.setPixelBurst(false);
				posX = 0;
				posY = 0;
			}

		}
		if (counter < 100) {
			counter++;
		}
		if (!global.isPixelBurst())
			counter = 0;
	}

	public void paint(Graphics g, int SCALE) {
		g.drawImage(spriteSheet.getSprite(0 + posX, 172 + posY, 20, 20),
				(int) x * SCALE, (int) y * SCALE,
				spriteSheet.getSprite(0, 0, 20, 20).getWidth() * SCALE,
				spriteSheet.getSprite(0, 0, 20, 20).getHeight() * SCALE, null);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

}
