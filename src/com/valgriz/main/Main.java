package com.valgriz.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.valgriz.render.Background;
import com.valgriz.render.Focus;
import com.valgriz.render.HUD;
import com.valgriz.render.HighscoreTable;
import com.valgriz.render.Menu;
import com.valgriz.render.Snow;
import com.valgriz.render.SpriteSheet;

public class Main extends Canvas implements Runnable {

	// Objects
	private JFrame frame = new JFrame();
	private Focus focus = new Focus();
	private SpriteSheet spriteSheet = new SpriteSheet();
	private Background background = new Background();
	private Snow snow = new Snow();
	private HUD hud = new HUD();
	private Global global = new Global();
	private Menu menu;
	private Mouse mo = new Mouse();
	private HighscoreTable ht = new HighscoreTable(6);
	private Thread thread;
	// Variables
	private boolean running;
	private final int SCALE = 6;

	public static void main(String[] args) {
		new Main().start();
	}

	public Main() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(60 * SCALE, (90 * SCALE) - 2));
		frame.add(this);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("8-Bit Avalanche");
		frame.setVisible(true);
		menu = new Menu(SCALE);
		global.setInGame(false);
		global.setInMenu(true);
		addMouseListener(mo);
		addMouseMotionListener(mo);
		BufferedImage mouse;
		mouse = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		mouse = spriteSheet.getSprite(16, 8, 4, 4);
		mouse.getGraphics();
		mouse.createGraphics();
		Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(mouse,
				new Point(0, 0), "Foot");
		setCursor(cursor);
		global.setGameOver(false);
		// Scores
	}

	public void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void stop() {
		running = false;
	}

	public void reset() {
		if (global.isResetSwitch() == true) {
			global.setInGame(true);
			global.setInMenu(false);
			global.setGameOver(false);
			global.setPaused(false);
			focus = new Focus();
			snow = new Snow();
			global.setScore(0);
			mo = new Mouse();
			global.setHighscore(false);
			global.setResetSwitch(false);
		}
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		{
			// Background
			background.paint(g, SCALE);
			// Override Menu
			if (global.inMenu && !global.inGame) {
				menu.paint(g);
			} else if (global.inGame) {
				// Focus
				focus.paint(g, SCALE);
				// Snow
				snow.paint(g, SCALE);
				// HUD
				hud.paint(g);
			} else if (global.inHighScores) {
				ht.paint(g);
			}
		}
		g.dispose();
		bs.show();
	}

	public void update() {
		if (!global.isPaused) {
			// Update Objects 60 Times/Second
			if (global.inMenu || global.inHighScores && !global.inGame) {
				menu.update();
				if (global.getScore() != 0)
					global.setScore(0);
			} else if (global.inGame) {
				focus.update(SCALE);
				snow.update(SCALE);
			}
			if (global.inHighScores || global.gameOver) {
				ht.update();
			}
			background.update(SCALE);
		}
		hud.update();
		if (global.resetSwitch) {
			reset();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		double tps = 1000000000D / 60;

		int ticks = 0;
		int frames = 0;

		long lastTimer = System.currentTimeMillis();
		double delta = 0;

		while (running) {
			long now = System.nanoTime();
			boolean shouldRender = false;
			delta += (now - lastTime) / tps;
			lastTime = now;
			while (delta >= 1) {
				ticks++;
				delta -= 1;
				shouldRender = true;
			}

			if (shouldRender) {
				frames++;
				update();
			}
			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				System.out.println(frames + ":" + ticks);
				frames = 0;
				ticks = 0;
			}
			render();
		}
	}
}
