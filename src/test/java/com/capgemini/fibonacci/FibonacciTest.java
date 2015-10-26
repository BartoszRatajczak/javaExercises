package com.capgemini.fibonacci;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void shouldReturnZero() {
		assertThat(Fibonacci.fib(0)).isEqualTo(0);
	}

	@Test
	public void shouldReturnOne() {
		assertThat(Fibonacci.fib(1)).isEqualTo(1);
	}
	
	@Test
	public void shouldReturnFiftyFive() {
		assertThat(Fibonacci.fib(10)).isEqualTo(55);
	}
}
