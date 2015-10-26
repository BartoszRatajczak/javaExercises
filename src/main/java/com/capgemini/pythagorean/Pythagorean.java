package com.capgemini.pythagorean;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Pythagorean {
	private static final int SUM = 1000;
	private static final Logger LOGGER = Logger.getLogger(Pythagorean.class.getName());

	public static void findTriplet() {
		int a, b, c;
		for (a = 1; a < SUM; a++) {
			for (b = a + 1; b < SUM; b++) {
				c = SUM - a - b;
				if (b < c && (a * a + b * b == c * c)) {
					// a = 200, b = 375, c = 425
					LOGGER.log(Level.INFO, a+" "+b+" "+c);
				}
			}
		}
	}
}
