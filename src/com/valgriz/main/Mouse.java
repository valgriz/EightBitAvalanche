package com.valgriz.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.valgriz.highscores.HighscoreManager;
import com.valgriz.render.Focus;
import com.valgriz.render.HUD;

public class Mouse implements MouseMotionListener, MouseListener {
	private Global global = new Global();
	private Focus focus = new Focus();
	private int SCALE = 6;
	private static int selection = 4;
	private static int highlight = 3;
	private static boolean outOfRange;

	public Mouse() {
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		selection = 4;
		highlight = 3;
		if (global.isInMenu()) {
			if (e.getX() >= 9 * 6 && e.getX() <= 305) {
				if (e.getY() >= 200 && e.getY() <= 70 * 6) {
					{
						if (e.getY() >= 201 && e.getY() <= 255) {
							global.setResetSwitch(true);
						}
						if (e.getY() >= 256 && e.getY() <= 310) {
							HighscoreManager hm = new HighscoreManager();
							global.setInGame(false);
							global.setInMenu(false);
							global.setInHighScores(true);
						}
						if (e.getY() >= 311 && e.getY() <= 365) {

							System.out.println("2");
						}
						if (e.getY() >= 366 && e.getY() <= 420) {
							System.exit(0);
						}

					}
				} else {
				}
			} else {
			}
		}

		if (global.isPaused()) {
			if (e.getY() >= 270 && e.getY() <= 335) {
				if (e.getX() >= 96 && e.getX() <= 173) {
					global.setInGame(false);
					global.setInMenu(true);
					global.setGameOver(false);
					global.setPaused(false);
				}
				if (e.getX() >= 174 && e.getX() <= 251) {
					global.setResetSwitch(true);
				}
			}
		}
		if (global.isInHighScores()) {
			if (e.getX() >= 66 && e.getX() <= 293) {
				if (e.getY() >= 426 && e.getY() <= 491) {
					if (e.getX() >= 66 && e.getX() <= 143) {
						global.setInGame(false);
						global.setInMenu(true);
						global.setGameOver(false);
						global.setPaused(false);
						global.setInHighScores(false);
					} else if (e.getX() >= 216 && e.getX() <= 293) {
						global.setResetSwitch(true);
						global.setInHighScores(false);
					} else {
					}
				} else {
				}
			} else {
			}
		}
		if (global.isGameOver()) {
			if (e.getY() >= 336 && e.getY() <= 401) {
				if (e.getX() >= 96 && e.getX() <= 173) {
					global.setInGame(false);
					global.setInMenu(true);
					global.setGameOver(false);
					global.setPaused(false);
					global.setHighscore(false);
				}
				if (e.getX() >= 174 && e.getX() <= 251) {
					global.setResetSwitch(true);
					global.setHighscore(false);
				}
			}
			if (e.getX() >= 96 && e.getX() <= 251 && e.getY() > 270
					&& e.getY() <= 335) {
				global.setInGame(false);
				global.setInMenu(false);
				global.setGameOver(false);
				global.setPaused(false);
				global.setInHighScores(true);
				global.setHighscore(false);
			}
		}
		if (global.isInGame()) {
			if (e.getY() < 462) {
				if (e.getX() / SCALE >= focus.getX()
						&& e.getX() / SCALE <= focus.getX() + 8) {
					if (e.getY() / SCALE >= focus.getY()
							&& e.getY() / SCALE <= focus.getY() + 16
							&& !global.isPaused() && !global.isGameOver()) {
						if (focus.getdY() < 0) {
							global.setPixelBurst(true);
						}
						focus.setdY(Math.abs(focus.getdY()));
						focus.setdY(focus.getdY() * focus.getFriction());

						if (e.getY() > 50)
							focus.setdY(focus.getdY() + .1);
						if (focus.getdY() < .9 + global.getScore() * .0002) {
							focus.setdY(focus.getdY() + .2);
						} else {
							focus.setdY(focus.getdY() - .1);
						}

						if ((e.getX() / SCALE) >= focus.getX() - 1
								&& e.getX() / SCALE < focus.getX() + 1) {
							focus.setdX(focus.getdX() + .4);
						}
						if ((e.getX() / SCALE) >= focus.getX() + 1
								&& e.getX() / SCALE < focus.getX() + 2) {
							focus.setdX(focus.getdX() + .3);
						}
						if ((e.getX() / SCALE) >= focus.getX() + 2
								&& e.getX() / SCALE < focus.getX() + 3) {
							focus.setdX(focus.getdX() + .2);
						}
						if ((e.getX() / SCALE) >= focus.getX() + 3
								&& e.getX() / SCALE < focus.getX() + 4) {
							focus.setdX(focus.getdX() + .1);
						}
						if ((e.getX() / SCALE) >= focus.getX() + 4
								&& e.getX() / SCALE < focus.getX() + 5) {
							focus.setdX(focus.getdX() - .1);
						}
						if ((e.getX() / SCALE) >= focus.getX() + 5
								&& e.getX() / SCALE < focus.getX() + 6) {
							focus.setdX(focus.getdX() - .2);
						}
						if ((e.getX() / SCALE) >= focus.getX() + 6
								&& e.getX() / SCALE < focus.getX() + 7) {
							focus.setdX(focus.getdX() - .3);
						}
						if ((e.getX() / SCALE) >= focus.getX() + 7
								&& e.getX() / SCALE < focus.getX() + 8) {
							focus.setdX(focus.getdX() - .4);
						}
					}
				}
			}
			if (e.getX() > 322 && e.getX() < 357) {
				if (e.getY() > 467 && e.getY() < 502) {
					if (!global.isPaused && !global.isGameOver()) {
						global.setPaused(true);
					} else if (global.isPaused) {
						global.setPaused(false);
					}
				}
			}
		}

		if (e.getY() >= 462 && e.getX() < 320 && global.isInGame()
				&& !global.isPaused()) {
			outOfRange = true;
		}
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
		if (global.isInMenu()) {
			if (e.getX() >= 9 * SCALE && e.getX() <= 305) {
				if (e.getY() >= 200 && e.getY() <= 70 * SCALE) {
					{
						if (e.getY() >= 201 && e.getY() <= 255) {
							selection = 0;
						}
						if (e.getY() >= 256 && e.getY() <= 310) {
							selection = 1;
						}
						if (e.getY() >= 311 && e.getY() <= 365) {
							selection = 2;
						}
						if (e.getY() >= 366 && e.getY() <= 420) {
							selection = 3;
						}
					}
				} else {
					selection = 4;
				}
			} else {
				selection = 4;
			}
		}
		if (global.gameOver) {
			if (e.getX() >= 96 && e.getX() <= 245) {
				if (e.getY() >= 270 && e.getY() <= 329) {
					highlight = 0;
				} else if (e.getY() >= 342 && e.getY() <= 395) {
					if (e.getX() < 174) {
						highlight = 1;
					} else {
						highlight = 2;
					}
				} else {
					highlight = 3;
				}
			} else {
				highlight = 3;
			}
		}

		if (global.inHighScores) {
			if (e.getX() >= 66 && e.getX() <= 293) {
				if (e.getY() >= 426 && e.getY() <= 491) {
					if (e.getX() >= 66 && e.getX() <= 143) {
						highlight = 1;
					} else if (e.getX() >= 216 && e.getX() <= 293) {
						highlight = 2;
					} else {
						highlight = 3;
					}
				} else {
					highlight = 3;
				}
			} else {
				highlight = 3;
			}
		}

		if (global.isPaused) {
			if (e.getX() >= 96 && e.getX() <= 245) {
				if (e.getY() >= 270 && e.getY() <= 329) {
					if (e.getX() < 174) {
						highlight = 1;
					} else {
						highlight = 2;
					}
				} else {
					highlight = 3;
				}
			} else {
				highlight = 3;
			}
		}
	}

	public int getSelection() {
		return selection;
	}

	public static int getHighlight() {
		return highlight;
	}

	public static void setHighlight(int highlight) {
		Mouse.highlight = highlight;
	}

	public boolean isOutOfRange() {
		return outOfRange;
	}

	public void setOutOfRange(boolean outOfRange) {
		this.outOfRange = outOfRange;
	}
}
