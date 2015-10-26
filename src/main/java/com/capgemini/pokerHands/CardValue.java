package com.capgemini.pokerHands;

public enum CardValue {

	UNDEFINED(0, "UNDEFINED"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(7,
			"7"), EIGHT(8, "8"), NINE(9, "9"), TEN(10, "T"), JACK(11, "J"), QUEEN(12, "Q"), KING(13, "K"), ACE(14, "A");

	private int key;
	private String value;

	private CardValue(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public static int getKeyOf(String value) {
		for (CardValue card : CardValue.values()) {
			if (card.value.equals(value)) {
				return card.key;
			}
		}
		return 0;
	}
}
