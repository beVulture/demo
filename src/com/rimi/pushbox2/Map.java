package com.rimi.pushbox2;

public class Map {
	Point point;
	Point person;
	Point box;
	Point door;
	public String[][] map;

	/**
	 * 初始化地图，记录人、箱子、出口的位置
	 * 
	 * @param map 游戏地图
	 */
	public void init(String[][] map) {
		this.map = map;
		person = new Point();
		box = new Point();
		door = new Point();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
//				找到人的初始位置
				if (map[i][j] == "R") {
					person.x = i;
					person.y = j;
				}
//				找到箱子的初始位置
				if (map[i][j] == "O") {
					box.x = i;
					box.y = j;
				}
//				找到门的位置
				if ((i == 0 || i == map.length - 1 || j == 0 || j == map[i].length - 1) && map[i][j] == " ") {
					door.x = i;
					door.y = j;
				}
			}

		}
	}

//	判断是否是门的方法
	public boolean isDoor() {
		return box.equals(door);
	}

//	上移动的方法
	public void moveUp() {
//		获取下一个  下下一个人的坐标
		Point next = person.getUp();
		Point nextnext = next.getUp();
		exchang(next, nextnext);
	}

//	下移动的方法
	public void moveDown() {
		Point next = person.getDown();
		Point nextnext = next.getDown();
		exchang(next, nextnext);
	}

//	左移动的方法
	public void moveLeft() {
		Point next = person.getLeft();
		Point nextnext = next.getLeft();
		exchang(next, nextnext);
	}

//	右移动的方法
	public void moveRight() {
		Point next = person.getRight();
		Point nextnext = next.getRight();

		exchang(next, nextnext);
	}

	/**
	 * 交换位置的方法
	 * 
	 * @param next     人的下一个坐标点
	 * @param nextnext 人的下下一个坐标点
	 */
	public void exchang(Point next,Point nextnext) {
		if (isOk(next)) {
//			判断下一个位置是否为空白
			if (map[next.x][next.y] == " ") {
//				交换人和空白的位置
				map[person.x][person.y]=" ";
				map[next.x][next.y]="R";
//				更新人的位置
				person=next;
//				判断下一个位置是否为箱子，下下一个位置是否为抢
			} else if (map[next.x][next.y] == "O" && map[nextnext.x][nextnext.y] != "#") {
				if (isOk(nextnext)) {
//					交换人、箱子、空白的位置
					map[person.x][person.y]=" ";
					map[next.x][next.y]="R";
					map[nextnext.x][nextnext.y] = "O";
//					更新箱子、人的位置
					person = box;
					box = nextnext;
			}
		}
		}
	}

//	判断是否超出地图边界的方法
	public boolean isOk(Point point) {
		if (point.x >= 0 && point.y >= 0 && point.x < map.length && point.y < map[point.x].length) {
			return true;
		} else {
			return false;
		}
	}

//打印地图的方法
	public void print() {
		for (int indexX = 0; indexX < map.length; indexX++) {
			for (int indexY = 0; indexY < map[indexX].length; indexY++) {
				System.out.print(map[indexX][indexY]);
			}

			System.out.println();
		}
	}
}
