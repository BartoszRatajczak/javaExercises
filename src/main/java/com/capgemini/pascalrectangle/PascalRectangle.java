package com.capgemini.pascalrectangle;

public class PascalRectangle {
	public static long pascal(int c, int r) {
		if (c <= r) {
			if (c == 1 || c == r) {
				return 1;
			} else {
				return pascal(c - 1, r - 1) + pascal(c, r - 1);
			}
		}
		return 0;
	}
}
