package com.rimi.pushbox2;

public class Point {
	int x;
	int y;

	public Point() {
		super();
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

//比较两个坐标点的方法
	@Override
	public boolean equals(Object obj) {
		Point point = (Point) obj;
		return this.x == point.x && this.y == point.y;
	}
	public Point getUp() {
		return new Point(x - 1, y);
	}

	public Point getDown() {
		return new Point(x + 1, y);
	}

	public Point getLeft() {
		return new Point(x, y - 1);
	}

	public Point getRight() {
		return new Point(x, y + 1);
	}
}
