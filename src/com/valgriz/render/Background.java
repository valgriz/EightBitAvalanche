package com.valgriz.render;

import java.awt.Color;
import java.awt.Graphics;

public class Background {
	// Objects
	private SpriteSheet spriteSheet = new SpriteSheet();
	private Dot[] dot = new Dot[30];
	// Variables
	private int SCALE;
	private double x;
	private double y;
	private double dX;
	private double dY;
	private double gravity;
	private double time;
	private double friction = .9;

	public Background() {
		for (int i = 0; i < dot.length; i++) {
			dot[i] = new Dot();
		}
	}

	public void update(int SCALE) {
		this.SCALE = SCALE;
		for (int i = 0; i < dot.length; i++) {
			dot[i].update();
		}
	}

	public void paint(Graphics g, int SCALE) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 60 * SCALE, 90 * SCALE);
		for (int i = 0; i < dot.length; i++) {
			dot[i].paint(g, SCALE);
		}
	}
}
