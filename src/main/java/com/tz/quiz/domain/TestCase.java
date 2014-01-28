package com.tz.quiz.domain;

import com.tz.quiz.support.Constants;

public class TestCase {

	private int T; 	// testcase count
    private int Z;	// zombie count
    private Zombie[] zombies = new Zombie[Constants.zombieMaxCnt];
    
	public int getT() {
		return T;
	}
	public void setT(int t) {
		T = t;
	}
	public int getZ() {
		return Z;
	}
	public void setZ(int z) {
		Z = z;
	}

	public void addZombie(Zombie zombie) {
		this.zombies[Z] = zombie;
		this.Z++;
	}

	public Zombie getZombie(int index) {
		return this.zombies[index];
	}

}
