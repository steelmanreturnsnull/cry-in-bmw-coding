package com.pinjhuan.poker;

public enum Suit {
	SPADES, //����
	HEARTS, //����
	DIAMONDS, //����
	CLUBS, //÷��
	JOKER;
	
	@Override
	public String toString() {
		String s = super.toString();
		return s.substring(0, 1);
	}
}
