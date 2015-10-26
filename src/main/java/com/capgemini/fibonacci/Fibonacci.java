package com.capgemini.fibonacci;

public class Fibonacci {
	public static long fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		return (fib(n - 2) + fib(n - 1));
	}
}
