package com.capgemini.pokerHands;

public class CardOccurence {

	private int card;
	private int occurence;

	public CardOccurence() {

	}

	public CardOccurence(int card, int occurence) {
		this.card = card;
		this.occurence = occurence;
	}

	public int getCard() {
		return card;
	}

	public void setCard(int card) {
		this.card = card;
	}

	public int getOccurence() {
		return occurence;
	}

	public void setOccurence(int occurence) {
		this.occurence = occurence;
	}
	
	public String toString() {
		return card+" "+occurence;
	}
}
