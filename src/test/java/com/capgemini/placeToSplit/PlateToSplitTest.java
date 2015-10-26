package com.capgemini.placeToSplit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PlateToSplitTest {

	@Test
	public void shouldReturnTrue() {
		int[] table = { 1, 1, 1, 2, 1 };
		assertThat(PlaceToSplit.canBalance(table)).isTrue();
	}
	
	@Test
	public void shouldReturnFalse() {
		int[] table = { 2, 1, 1, 2, 1 };
		assertThat(PlaceToSplit.canBalance(table)).isFalse();
	}

	@Test
	public void shouldReturnTrue2() {
		int[] table = { 10, 10 };
		assertThat(PlaceToSplit.canBalance(table)).isTrue();
	}
	
	@Test
	public void shouldReturnFalse2() {
		int[] table = { 10, 30 };
		assertThat(PlaceToSplit.canBalance(table)).isFalse();
	}
}
