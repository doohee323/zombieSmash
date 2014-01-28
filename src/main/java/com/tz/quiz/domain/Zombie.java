package com.tz.quiz.domain;

import com.tz.quiz.support.Constants;

public class Zombie {

	private int X; // location X
	private int Y; // location Y
	private int M; // time to show
	private boolean showYn; // currently show or not
	private int showTime = Constants.zombieShow; // left show time

	public Zombie(int x, int y, int m) {
		X = x;
		Y = y;
		M = m;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getM() {
		return M;
	}

	public void setM(int m) {
		M = m;
	}

	public boolean isShowYn() {
		return showYn;
	}

	public void setShowYn(boolean showYn) {
		this.showYn = showYn;
	}

	public int getShowTime() {
		return showTime;
	}

	public void setShowTime() {
		if (this.showYn) {
			this.showTime--;
			if (this.showTime < 0)
				this.showTime = Constants.zombieShow; // ?? re-show
		}
	}
}
