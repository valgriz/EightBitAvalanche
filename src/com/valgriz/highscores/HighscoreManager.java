package com.valgriz.highscores;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class HighscoreManager {
	
	//Test

	private ArrayList<Score> scores;
	private static final String HIGHSCORE_FILE = "save.8ba";
	ObjectOutputStream outputStream = null;
	ObjectInputStream inputStream = null;

	public HighscoreManager() {
		scores = new ArrayList<Score>();
	}

	public ArrayList<Score> getScores() {
		loadScoreFile();
		sort();
		return scores;
	}

	private void sort() {
		ScoreComparator comparator = new ScoreComparator();
		Collections.sort(scores, comparator);
	}

	public void addScore(int c1, int c2, int score) {
		loadScoreFile();
		scores.add(new Score(c1, c2, score));
		updateScoreFile();
	}

	public void loadScoreFile() {
		try {
			inputStream = new ObjectInputStream(new FileInputStream(
					HIGHSCORE_FILE));
			scores = (ArrayList<Score>) inputStream.readObject();
		} catch (Exception e) {
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (Exception e2) {
			}
		}
	}

	public void updateScoreFile() {
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(
					HIGHSCORE_FILE));
			outputStream.writeObject(scores);
		} catch (Exception e) {
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (Exception e2) {
			}
		}
	}

	public int[] getHighscoreC1() {
		// String highscoreString = "";
		int max = 6;
		ArrayList<Score> scores;
		scores = getScores();
		int[] c1 = new int[max];
		int i = 0;
		int x = scores.size();
		if (x > max) {
			x = max;
		}
		while (i < x) {
			// highscoreString += (i + 1) + ".\n" + scores.get(i).getNaam()
			// + "\t\t" + scores.get(i).getScore() + "\n";
			c1[i] = scores.get(i).getScore();
			i++;
		}
		return c1;
	}

	public int[] getHighscoreC2() {
		// String highscoreString = "";
		int max = 6;
		ArrayList<Score> scores;
		scores = getScores();
		int[] c2 = new int[max];
		int i = 0;
		int x = scores.size();
		if (x > max) {
			x = max;
		}
		while (i < x) {
			// highscoreString += (i + 1) + ".\n" + scores.get(i).getNaam()
			// + "\t\t" + scores.get(i).getScore() + "\n";
			c2[i] = scores.get(i).getScore();
			i++;
		}
		return c2;
	}

	public int[] getHighscore() {
		// String highscoreString = "";
		int max = 6;
		ArrayList<Score> scores;
		scores = getScores();
		int[] aScore = new int[max];
		int i = 0;
		int x = scores.size();
		if (x > max) {
			x = max;
		}
		while (i < x) {
			// highscoreString += (i + 1) + ".\n" + scores.get(i).getNaam()
			// + "\t\t" + scores.get(i).getScore() + "\n";
			aScore[i] = scores.get(i).getScore();
			i++;
		}
		return aScore;
	}
}
