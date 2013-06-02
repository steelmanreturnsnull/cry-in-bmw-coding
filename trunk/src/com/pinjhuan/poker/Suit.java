package com.pinjhuan.poker;

public enum Suit {
	SPADES, //ºÚÌÒ
	HEARTS, //ºìÌÒ
	DIAMONDS, //·½¿é
	CLUBS, //Ã·»¨
	JOKER;
	
	@Override
	public String toString() {
		String s = super.toString();
		return s.substring(0, 1);
	}
}
