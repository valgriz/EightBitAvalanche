package com.valgriz.render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Snow {
	// Objects
	private SpriteSheet spriteSheet = new SpriteSheet();
	private Pixel pixel = new Pixel();
	private BufferedImage sprite;
	private Random r = new Random();
	// Variables
	private double x = 0;
	private double y = 0;
	private int printX = 0;
	private int printY = 0;
	private double dY;
	private double dX;
	private int SCALE;

	public Snow() {
		x = 0;
		y = 0;
		printX = 0;
		printY = 0;
	}

	public void update(int SCALE) {
		this.SCALE = SCALE;
		pixel.update(SCALE);
	}

	public void paint(Graphics g, int SCALE) {
		pixel.paint(g, SCALE);
	}
}
