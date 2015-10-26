package com.capgemini.coins;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CoinsTest {
	
	private List<Integer> coins;
	
	@Before
	public void executedBeforeEachCounting() {
		coins = new ArrayList<Integer>();
	}

	@Test
	public void shouldReturnFour() {
		coins.add(1);
		coins.add(1);
		coins.add(0);
		coins.add(1);
		coins.add(0);
		coins.add(0);
		assertThat(Coins.solution(coins)).isEqualTo(4);
	}

	@Test
	public void shouldReturnZero() {
		coins.add(1);
		coins.add(1);
		assertThat(Coins.solution(coins)).isEqualTo(0);
	}
	
	@Test
	public void shouldReturnOne() {
		coins.add(1);
		coins.add(0);
		assertThat(Coins.solution(coins)).isEqualTo(1);
	}
}
