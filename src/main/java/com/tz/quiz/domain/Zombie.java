package com.tz.quiz.domain;

public class Zombie {

	private int X; 	// location X
    private int Y;	// location Y
    private int M;	// time to show
    
    public Zombie(int x, int y, int m) {
    	X = x; Y = y; M = m;
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
}
