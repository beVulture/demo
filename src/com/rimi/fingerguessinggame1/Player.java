package com.rimi.fingerguessinggame1;

import java.util.Scanner;

public class Player implements Game {
	Scanner scanner = new Scanner(System.in);
	// 玩家的名字
	private String PlayerName;
	// 得分
	private int toatal;

	// 初始化得分
	public Player() {
		this.toatal = 0;
	}

	public int getToatal() {
		return toatal;
	}

	public void setToatal(int toatal) {
		this.toatal = toatal;
	}
	public String getPlayerName() {
		return PlayerName;
	}

	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}

	// 玩家出拳的方法
	@Override
	public int startGame() {

		return scanner.nextInt();
	}

}
