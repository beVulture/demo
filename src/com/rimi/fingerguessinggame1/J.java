package com.rimi.fingerguessinggame1;

public class J {
	static String speack = " 亲爱的小明请出拳:1.剪刀   2.石头   3.布\r\n";
	static String speack1 = "玩家【%s】出的拳头为:【%s】\r\n";
	static String speack2 = "机器人【%s】出的拳头为:【%s】\r\n";
	static String speack3 = "恭喜【%s】本次活动胜利，加1分，当前分数为%d\r\n";
	static String speack4 = "【%s】与【%s】心有灵犀一点通:平局，都不计分\r\n";

	/**
	 * 判断输赢的方法
	 * 
	 * @param player 玩家
	 * @param robot  机器人
	 * @param a      玩家出的拳
	 * @param b      机器人出的拳
	 */
	static void judge(Player player, Robot robot, int a, int b) {
		// 判断大小
		int result = a - b;
		// 输出裁判说的语句
		System.out.printf(speack1, player.getPlayerName(), J.playerGuess(a));
		System.out.printf(speack2, robot.getRobotName(), J.playerGuess(b));
		// 玩家赢的情况
		if (result == 1 || result == -2) {
			// 计算累计得分
			player.setToatal(player.getToatal() + 1);
			System.out.printf(speack3, player.getPlayerName(), player.getToatal());
			// 平局的情况
		} else if (result == 0) {
			System.out.printf(speack4, player.getPlayerName(), robot.getRobotName());
			// 机器人赢得情况
		} else {
//			计算累计的分
			robot.setTotal(robot.getTotal() + 1);
			System.out.printf(speack3, robot.getRobotName(), robot.getTotal());
		}
	}

//	根据累计得分判断最终输赢的方法
	static void whoWin(Player player, Robot robot) {
		if (player.getToatal() > robot.getTotal()) {
			System.out.printf("本局比赛%s赢\r\n", player.getPlayerName());
		} else if (player.getToatal() == robot.getTotal()) {
			System.out.println("本局比赛平局");
		} else {
			System.out.printf("本局比赛%s赢\r\n", robot.getRobotName());
		}
	}

//	判断玩家出拳的招式
	static String playerGuess(int a) {
		switch (a) {
		case 1:
			return "剪刀";

		case 2:
			return "石头";

		case 3:
			return "布";
		default:
			return "";
		}

	}

//	判断机器人出拳的招式
	static String playerGuess1(int b) {
		switch (b) {
		case 1:
			return "剪刀";

		case 2:
			return "石头";

		case 3:
			return "布";
		default:
			return "";
		}

	}
}
