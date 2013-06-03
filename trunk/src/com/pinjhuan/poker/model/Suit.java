package com.pinjhuan.poker.model;

public enum Suit {
	CLUBS(1), //÷��
	DIAMONDS(2), //����
	HEARTS(3), //����
	SPADES(4), //����
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
