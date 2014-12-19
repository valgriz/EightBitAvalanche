package com.valgriz.main;

public class Global {
	public static boolean inMenu;
	public static boolean inGame;
	public static boolean gameOver;
	public static boolean inHtp;
	public static boolean inExit;
	public static boolean inHighScores;
	public static boolean isPaused;
	public static boolean resetSwitch;
	public static boolean pixelBurst;
	public static boolean highscore;
	public static int score;

	public Global() {
	}

	public boolean isInMenu() {
		return inMenu;
	}

	public void setInMenu(boolean inMenu) {
		this.inMenu = inMenu;
	}

	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public static boolean isGameOver() {
		return gameOver;
	}

	public static void setGameOver(boolean gameOver) {
		Global.gameOver = gameOver;
	}

	public static boolean isInHtp() {
		return inHtp;
	}

	public static void setInHtp(boolean inHtp) {
		Global.inHtp = inHtp;
	}

	public static boolean isInExit() {
		return inExit;
	}

	public static void setInExit(boolean inExit) {
		Global.inExit = inExit;
	}

	public static boolean isPaused() {
		return isPaused;
	}

	public static void setPaused(boolean isPaused) {
		Global.isPaused = isPaused;
	}

	public static boolean isResetSwitch() {
		return resetSwitch;
	}

	public static void setResetSwitch(boolean resetSwitch) {
		Global.resetSwitch = resetSwitch;
	}

	public static boolean isPixelBurst() {
		return pixelBurst;
	}

	public static void setPixelBurst(boolean pixelBurst) {
		Global.pixelBurst = pixelBurst;
	}

	public static boolean isInHighScores() {
		return inHighScores;
	}

	public static void setInHighScores(boolean inHighScores) {
		Global.inHighScores = inHighScores;
	}

	public static boolean isHighscore() {
		return highscore;
	}

	public static void setHighscore(boolean highscore) {
		Global.highscore = highscore;
	}
}
