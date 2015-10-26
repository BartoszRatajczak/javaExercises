package com.capgemini.placeToSplit;

public final class PlaceToSplit {
	private PlaceToSplit() {
	}

	public static boolean canBalance(int[] nums) {
		int[] sums = new int[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			sums[i] = sum;
		}
		for (int i = 0; i < nums.length; i++) {
			if (sums[i] == sums[nums.length - 1]/2.0) {
				return true;
			}
		}
		return false;
	}
}
