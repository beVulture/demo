package com.rimi.fingerguessinggame1;

import java.util.Random;

public class Robot implements Game {
	Random random = new Random();
	// 机器人的名字
	private String robotName;
	// 得分
	private int total;

//初始化的分
public Robot() {
	
		this.total = 0;
}

	public String getRobotName() {
		return robotName;
	}

	public void setRobotNme(String robotName) {
		this.robotName = robotName;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	// 机器人出拳的方法
	@Override
	public int startGame() {

		return random.nextInt(3) + 1;
	}

}
