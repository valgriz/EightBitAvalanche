package com.valgriz.render;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.valgriz.main.Global;
import com.valgriz.main.Main;

public class Focus {
	// Objects
	private SpriteSheet spriteSheet = new SpriteSheet();
	private Pixel pixel = new Pixel();
	private Global global = new Global();
	private Burst burst = new Burst();
	// Variables
	private static int SCALE;
	private static double x;
	private static double y;
	private static double dX;
	private static double dY;
	private double gravity;
	private double time;
	private static double friction = .9;

	public Focus() {
		x = 27;
		y = 65;
		dY = 0;
		dX = 0;
		gravity = -.05;
		time = .2;
	}

	public void update(int SCALE) {
		if (global.isPixelBurst()) {
			burst.setX(x - 6);
			burst.setY(y - 16);
			burst.update();
		}
		this.SCALE = SCALE;
		if (dY < 0) {
			pixel.setdY(dY / 3);
		}
		if (dY > 0) {
			pixel.setdY(dY / 3);
		}
		if (y < pixel.getY() + 80) {

			pixel.setdY(.2);
		}
		if (y < 1) {
			global.setGameOver(true);

		} else {
			dY = dY + gravity * time;
			y += dY * time + .5 * gravity * time * time;
		}

		if (x < 0) {
			x = 0;
			dX = -dX;
		}
		if (x > 52) {
			x = 52;
			dX = -dX;
		}
		y += dY;
		x += dX;
	}

	public void paint(Graphics g, int SCALE) {
		burst.paint(g, SCALE);
		g.drawImage(spriteSheet.getSprite(0, 0, 8, 8), (int) x * SCALE, (int) y
				* SCALE, spriteSheet.getSprite(0, 0, 8, 8).getWidth() * SCALE,
				spriteSheet.getSprite(0, 0, 8, 8).getHeight() * SCALE, null);
		if (y > 84) {
			g.drawImage(spriteSheet.getSprite(5, 9, 1, 1), (int) (x + 3)
					* SCALE, 84 * SCALE, spriteSheet.getSprite(5, 9, 2, 1)
					.getWidth() * SCALE, spriteSheet.getSprite(5, 9, 1, 1)
					.getHeight() * SCALE, null);
		}
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

	public double getdX() {
		return dX;
	}

	public void setdX(double dX) {
		this.dX = dX;
	}

	public double getdY() {
		return dY;
	}

	public void setdY(double dY) {
		this.dY = dY;
	}

	public double getFriction() {
		return friction;
	}

	public void setFriction(double friction) {
		this.friction = friction;
	}

}
