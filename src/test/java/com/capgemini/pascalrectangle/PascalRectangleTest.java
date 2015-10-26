package com.capgemini.pascalrectangle;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PascalRectangleTest {

	@Test
	public void shouldReturnOne() {
		assertThat(PascalRectangle.pascal(1, 1)).isEqualTo(1);
	}

	@Test
	public void shouldReturnTwo() {
		assertThat(PascalRectangle.pascal(2, 3)).isEqualTo(2);
	}
	
	@Test
	public void shouldReturnTen() {
		assertThat(PascalRectangle.pascal(4, 6)).isEqualTo(10);
	}
}
