package com.tz.quiz.domain;

public class TestCase {

	private int T; 	// testcase count
    private int Z;	// zombie count
    private Zombie[] zombies;
    
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
	
	public Zombie[] getZombies() {
		return zombies;
	}
	
	public void setZombies(Zombie[] zombies) {
		this.zombies = zombies;
	}

	public void addZombie(Zombie zombie) {
		this.zombies[this.zombies.length] = zombie;
	}

	public Zombie getZombie(int index) {
		return this.zombies[index];
	}

}
