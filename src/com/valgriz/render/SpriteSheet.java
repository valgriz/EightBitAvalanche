package com.valgriz.render;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private BufferedImage spriteSheet;

	public SpriteSheet() {
		try {
			spriteSheet = ImageIO.read(this.getClass().getResource(
					"/res/images/spritesheet.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.print("Image failed to load");
		}
	}

	public BufferedImage getSprite(int x, int y, int w, int h) {
		BufferedImage sprite = spriteSheet.getSubimage(x, y, w, h);
		return sprite;
	}
}
