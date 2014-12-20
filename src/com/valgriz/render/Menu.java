package com.valgriz.render;

import java.awt.Graphics;

import com.valgriz.main.Global;
import com.valgriz.main.Mouse;

public class Menu {
	// Objects
	private SpriteSheet spriteSheet = new SpriteSheet();
	private HowToPlay htp = new HowToPlay();
	private Global global = new Global();
	private Mouse mo = new Mouse();
	// Variables
	private int SCALE;
	private int selection;

	public Menu(int SCALE) {
		this.SCALE = SCALE;
		selection = 4;
	}

	public void update() {

	}

	public void paint(Graphics g) {
		if (global.isInMenu()) {
			g.drawImage(spriteSheet.getSprite(17, 28, 43, 56), 9 * SCALE,
					12 * SCALE, 42 * SCALE, 55 * SCALE, null);
			switch (mo.getSelection()) {
			case 0:
				g.drawImage(spriteSheet.getSprite(17, 19, 43, 9), 9 * SCALE,
						201, 42 * SCALE, 9 * SCALE, null);
				break;
			case 1:
				g.drawImage(spriteSheet.getSprite(17, 19, 43, 9), 9 * SCALE,
						254, 42 * SCALE, 9 * SCALE, null);
				break;
			case 2:
				g.drawImage(spriteSheet.getSprite(17, 19, 43, 9), 9 * SCALE,
						308, 42 * SCALE, 9 * SCALE, null);
				break;
			case 3:
				g.drawImage(spriteSheet.getSprite(17, 19, 43, 9), 9 * SCALE,
						361, 42 * SCALE, 9 * SCALE, null);
				break;
			}
		}
		if (global.isInHowToPlay()) {
			g.drawImage(htp.getSprite(0, 0, 354, 510), 0, 0, null);
		}
	}
}