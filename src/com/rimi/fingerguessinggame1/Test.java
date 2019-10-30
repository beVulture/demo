package com.rimi.fingerguessinggame1;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			// new一个玩家
			Player player = new Player();
			// 设置玩家的名字
			player.setPlayerName("小明");
			// new一个机器人
			Robot robot = new Robot();
			// 设置机器人的名字
			robot.setRobotNme("深蓝");
			// 一局比赛进行三次猜拳
			for (int i = 0; i < 3; i++) {
				// 获得玩家的出拳
				int playerOut = player.startGame();
				// 获得机器人的出拳
				int robotOut = robot.startGame();
				J.judge(player, robot, playerOut, robotOut);
			}
			System.out.println("---------------------");
			// 输出比赛结果
			J.whoWin(player, robot);
			System.out.println("---------------------");
			System.out.println("继续比赛吗？q退出，任意键继续");
			// 判断是否继续比赛
			String option = scanner.next();
			if (option.equals("q")) {
				return;
			}
		}
	}
}
