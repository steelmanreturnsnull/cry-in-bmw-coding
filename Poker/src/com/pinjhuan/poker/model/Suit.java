package com.pinjhuan.poker.model;

public enum Suit {
	CLUBS(1), //Ã·»¨
	DIAMONDS(2), //·½¿é
	HEARTS(3), //ºìÌÒ
	SPADES(4), //ºÚÌÒ
	JOKER(5);

	private Integer m_code;

	private Suit(int c) {
		m_code = new Integer(c);
	}

	public Integer getCode() {
		return m_code;
	}

	@Override
	public String toString() {
		String s = super.toString();
		return s.substring(0, 1);
	}
}
